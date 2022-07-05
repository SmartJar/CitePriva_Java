package es.license.citapriva;

import es.license.citapriva.utils.Constants;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class App {


    enum ProcessStage {
        IDLE,
        NO_Appointment,
        Step1,
        Step2,
        Step3,
        Step4,
        Done
    }

    private static String stateValue;
    private static ProcessStage process = ProcessStage.IDLE;
    private static WebDriver driver;
    private static String htmlString;
    private static String clickableTime;

    private static SSLConnectionSocketFactory sslSocketFactory;

    private static String pageName = "data/Barcelona.html";

    /*public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        //System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");

        SSLContext ctx = null;
        try {
            ctx = SSLContext.getInstance("TLS");
            ctx.init(new KeyManager[0], new TrustManager[]{new DefaultTrustManager()}, new SecureRandom());
            SSLContext.setDefault(ctx);

            sslSocketFactory = new SSLConnectionSocketFactory(ctx, new org.apache.http.conn.ssl.DefaultHostnameVerifier());
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            e.printStackTrace();
            System.exit(0);
        }

        //startFireFoxPage();
        startChromePage();
        //setSedeInfo();
        //showSiteUrl("https://sedeclave.dgt.gob.es/WEB_NCIT_CONSULTA/solicitarCita.faces");

    }*/

    public App(String filePath) {
        pageName = filePath;
    }

    public void startOperation() {

        Thread thread = new Thread() {
            public void run(){
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
                //System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");

                SSLContext ctx = null;
                try {
                    ctx = SSLContext.getInstance("TLS");
                    ctx.init(new KeyManager[0], new TrustManager[]{new DefaultTrustManager()}, new SecureRandom());
                    SSLContext.setDefault(ctx);

                    sslSocketFactory = new SSLConnectionSocketFactory(ctx, new org.apache.http.conn.ssl.DefaultHostnameVerifier());
                } catch (NoSuchAlgorithmException | KeyManagementException e) {
                    e.printStackTrace();
                    System.exit(0);
                }

                //startFireFoxPage();
                startChromePage();
                FileChooser.started = true;
                //setSedeInfo();
                //showSiteUrl("https://sedeclave.dgt.gob.es/WEB_NCIT_CONSULTA/solicitarCita.faces");
            }
        };

        thread.start();

    }

    private static void startFireFoxPage() {
        if (driver == null) {
            ProfilesIni profileIni = new ProfilesIni();
            FirefoxProfile profile = profileIni.getProfile("default");
            /*FirefoxProfile profile = new FirefoxProfile();
            profile.set("start-maximized");
            options.addArguments("disable-infobars");
            options.addArguments("--disable-extensions");*/
            profile.setAcceptUntrustedCertificates(true);
            profile.setAssumeUntrustedCertificateIssuer(false);
            profile.setPreference("intl.accept_languages", "en-GB");
            profile.setPreference("network.proxy.type", 0);
            //profile.setPreference("general.useragent.override", Constants.userAgents.get(new Random().nextInt(Constants.userAgents.size())));
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setProfile(profile);
            driver = new FirefoxDriver(firefoxOptions);
            driver.manage().window().maximize();
        }
        driver.get(new File(pageName).getAbsolutePath());
        processVoid();
    }

    private static void startChromePage() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-extensions");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        driver.get(new File(pageName).getAbsolutePath());
        processVoid();
    }

    private static void processVoid() {
        while (true) {
            if (process == ProcessStage.IDLE) {
                JavascriptExecutor js2 = (JavascriptExecutor) driver;
                js2.executeScript("document.getElementById(\"publicacionesForm\").querySelectorAll(\"[type='submit']\")[0].click();");
                process = ProcessStage.NO_Appointment;
            } else if (process == ProcessStage.NO_Appointment) {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
                wait.until(ExpectedConditions.or(presenceOfElementLocated(By.xpath("//form[@action='/WEB_NCIT_CONSULTA/solicitarCita.faces']")),
                        presenceOfElementLocated(By.xpath("//form[@action='/WEB_NCIT_CONSULTA/solicitarCitaPaso3.faces']"))));
                if (driver.getPageSource().contains(Constants.noAppointmentMsg)) {
                    driver.get(new File(pageName).getAbsolutePath());
                    process = ProcessStage.IDLE;
                } else if (driver.getPageSource().contains("dias")) {
                    sound();
                    System.out.println("222");
                    process = ProcessStage.Step1;

                } else {
                    driver.get(new File(pageName).getAbsolutePath());
                    process = ProcessStage.IDLE;
                }
            }
            else if (process == ProcessStage.Step1) {
                List<WebElement> ulLists = driver.findElements(By.xpath("//ul[@class='dias']"));
                int day = new Random().nextInt(ulLists.size());
                WebElement timeInput = null;
                JavascriptExecutor js2 = (JavascriptExecutor) driver;
                for (int d = 0; d < ulLists.size(); d++) {
                    WebElement selectedUl = ulLists.get(d);
                    List<WebElement> allLi = selectedUl.findElements(By.tagName("li"));
                    WebElement selectedLi = allLi.get(0);
                    WebElement timeSelectDiv = selectedLi.findElement(By.tagName("div"));
                    WebElement timeSelect = timeSelectDiv.findElement(By.tagName("select"));
                    timeInput = timeSelectDiv.findElement(By.tagName("input"));
                    if (d == day) {
                        List<WebElement> timeSelectOption = timeSelect.findElements(By.tagName("option"));
                        int max = timeSelectOption.size();
                        int min = 0;
                        int time = new Random().nextInt(max - min - 1) + 1 + min;
                        for (int i = 0; i < timeSelectOption.size(); i++) {
                            if (i == time) {
                                js2.executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);",
                                        timeSelectOption.get(i),
                                        "selected",
                                        "selected");
                                if (timeInput != null) {
                                    process = ProcessStage.Step2;
                                    js2.executeScript("arguments[0].click();", timeInput);
                                }
                                break;
                            }
                        }
                        break;
                    }
                }
            } else if (process == ProcessStage.Step2) {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
                wait.until(presenceOfElementLocated(By.id("publicacionesCitaResumenForm:responseV2")));
                WebElement Element = driver.findElement(By.linkText("Aviso legal"));
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].scrollIntoView();", Element);

                new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha/api2')]")));
                new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[@class='recaptcha-checkbox-border']")));

                WebElement captcha = driver.findElement(By.id("rc-anchor-container"));
                captcha.click();

                driver.switchTo().defaultContent();
                driver.switchTo().defaultContent();
                process = ProcessStage.Step3;
            } else if (process == ProcessStage.Step3) {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
                wait.until(presenceOfElementLocated(By.id("publicacionesCitaResumenForm:responseV2")));
                WebElement captcha = driver.findElement(By.id("publicacionesCitaResumenForm:responseV2"));
                String captchaText = captcha.getAttribute("value");
                if (captchaText != null && !captchaText.isEmpty() && !captchaText.equalsIgnoreCase("undefined")) {

                    JavascriptExecutor js2 = (JavascriptExecutor) driver;
                     js2.executeScript("document.getElementById(\"publicacionesCitaResumenForm\").querySelectorAll(\"[type='submit']\")[0].click();");
                    FileChooser.started = false;
                    break;
                } else if (driver.findElements(By.xpath("//iframe[starts-with(@name, 'c-') and starts-with(@src, 'https://www.google.com/recaptcha/api2')]")).size() > 0) {
                    imageCaptcha();
                }
            }
        }
    }



    private static class DefaultTrustManager implements X509TrustManager {

        @Override
        public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
        }

        @Override
        public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

    }


    public static void sound() {
        try {
            InputStream audioFile = App.class.getClassLoader().getResourceAsStream("ring.wav");
            AudioInputStream audioInputStream = null;
            if (audioFile != null) {
                audioInputStream = AudioSystem.getAudioInputStream(audioFile);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } else {
                System.err.println("NO AUDIO");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static boolean playCaptchaAudio = true;

    public static void imageCaptcha() {
        if (!playCaptchaAudio) return;
        try {
            InputStream audioFile = App.class.getClassLoader().getResourceAsStream("captcha.wav");
            AudioInputStream audioInputStream = null;
            if (audioFile != null) {
                audioInputStream = AudioSystem.getAudioInputStream(audioFile);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
                playCaptchaAudio = false;
            } else {
                System.err.println("NO AUDIO");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
