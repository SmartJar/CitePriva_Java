package es.license.citapriva.utils;



import es.license.citapriva.model.CityModel;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Utils {

    public static String captchaKey = "69a647027165793460eb2ad180a1589f";


    public static CityModel selectCityByName(String country, String name) {
        CityModel cityModel = null;
        for(int j = 0; j < Constants.countriesModelList.size(); j++) {
            if(Constants.countriesModelList.get(j).getName().equalsIgnoreCase(country)) {
                for (int i = 0; i < Constants.countriesModelList.get(j).getCityModels().size(); i++) {
                    if(Constants.countriesModelList.get(j).getCityModels().get(i).getName().equalsIgnoreCase(name)){
                        cityModel = Constants.countriesModelList.get(j).getCityModels().get(i);
                        break;
                    }
                }
                break;
            }
        }
        return cityModel;
    }

    public static int selectCountryByName(String name) {
        int selectedID = -1;
        for (int i = 0; i < Constants.countriesModelList.size(); i++) {
            if(Constants.countriesModelList.get(i).getName().equalsIgnoreCase(name)){
                selectedID = i;
                break;
            }
        }
        return selectedID;
    }

    public static int selectCityPositionByName(String country, String name) {
        int selectedID = 0;
        for (int i = 0; i < Constants.countriesModelList.size(); i++) {
            if(Constants.countriesModelList.get(i).getName().equalsIgnoreCase(country)){
                for (int j = 0; j < Constants.countriesModelList.get(i).getCityModels().size(); j++) {
                    if(Constants.countriesModelList.get(i).getCityModels().get(j).getName().equalsIgnoreCase(name)) {
                        selectedID = j;
                        break;
                    }
                }
                break;
            }
        }
        return selectedID;
    }

    public static CityModel selectProvinciaByName(String name) {
        CityModel selectedCity = null;
        for (int i = 0; i < getProvancia().size(); i++) {
            if(getProvancia().get(i).getName().equalsIgnoreCase(name)){
                selectedCity = getProvancia().get(i);
                break;
            }
        }
        return selectedCity;
    }



    public static boolean isEmailValid(String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static List<CityModel> getProvancia() {
        List<CityModel> cityModels = new ArrayList<>();
        cityModels.add(new CityModel(2, "Albacete"));
        cityModels.add(new CityModel(3, "Alicante/Alacant"));
        cityModels.add(new CityModel(4, "Almería"));
        cityModels.add(new CityModel(1, "Araba/Álava"));
        cityModels.add(new CityModel(33, "Asturias"));
        cityModels.add(new CityModel(5,"Ávila"));
        cityModels.add(new CityModel(6,"Badajoz"));
        cityModels.add(new CityModel(7,"Balears (Illes)"));
        cityModels.add(new CityModel(8,"Barcelona"));
        cityModels.add(new CityModel(48,"Bizkaia"));
        cityModels.add(new CityModel(9,"Burgos"));
        cityModels.add(new CityModel(10,"Cáceres"));
        cityModels.add(new CityModel(11,"Cádiz"));
        cityModels.add(new CityModel(39,"Cantabria"));
        cityModels.add(new CityModel(12,"Castellón/Castellò"));
        cityModels.add(new CityModel(51,"Ceuta"));
        cityModels.add(new CityModel(13,"Ciudad Real"));
        cityModels.add(new CityModel(14,"Córdoba"));
        cityModels.add(new CityModel(15,"Coruña (A)"));
        cityModels.add(new CityModel(16,"Cuenca"));
        cityModels.add(new CityModel(20,"Gipuzkoa"));
        cityModels.add(new CityModel(17,"Girona"));
        cityModels.add(new CityModel(18,"Granada"));
        cityModels.add(new CityModel(19,"Guadalajara"));
        cityModels.add(new CityModel(21,"Huelva"));
        cityModels.add(new CityModel(22,"Huesca"));
        cityModels.add(new CityModel(23,"Jaén"));
        cityModels.add(new CityModel(24,"León"));
        cityModels.add(new CityModel(25,"Lleida"));
        cityModels.add(new CityModel(27,"Lugo"));
        cityModels.add(new CityModel(28,"Madrid"));
        cityModels.add(new CityModel(29,"Málaga"));
        cityModels.add(new CityModel(52,"Melilla"));
        cityModels.add(new CityModel(30,"Murcia"));
        cityModels.add(new CityModel(31,"Navarra"));
        cityModels.add(new CityModel(32,"Ourense"));
        cityModels.add(new CityModel(34,"Palencia"));
        cityModels.add(new CityModel(35,"Palmas (Las)"));
        cityModels.add(new CityModel(36,"Pontevedra"));
        cityModels.add(new CityModel(26,"Rioja (La)"));
        cityModels.add(new CityModel(37,"Salamanca"));
        cityModels.add(new CityModel(38,"Santa Cruz de Tenerife"));
        cityModels.add(new CityModel(40,"Segovia"));
        cityModels.add(new CityModel(41,"Sevilla"));
        cityModels.add(new CityModel(42,"Soria"));
        cityModels.add(new CityModel(43,"Tarragona"));
        cityModels.add(new CityModel(44,"Teruel"));
        cityModels.add(new CityModel(45,"Toledo"));
        cityModels.add(new CityModel(46,"Valencia/València"));
        cityModels.add(new CityModel(47,"Valladolid"));
        cityModels.add(new CityModel(49,"Zamora"));
        cityModels.add(new CityModel(50,"Zaragoza"));
        return cityModels;
    }

    public static List<CityModel> getCities() {
        List<CityModel> cityModels = new ArrayList<>();
        cityModels.add(new CityModel(73, "Albacete"));
//        cityModels.add(new CityModel(23, "Alicante/Alacant"));
//        cityModels.add(new CityModel(221, "Alicante/Alacant-Elche"));
//        cityModels.add(new CityModel(24, "Almería"));
//        cityModels.add(new CityModel(75, "Araba/Álava"));
//        cityModels.add(new CityModel(32, "Asturias-Gijón"));
//        cityModels.add(new CityModel(26, "Asturias-Oviedo"));
//        cityModels.add(new CityModel(76,"Ávila"));
//        cityModels.add(new CityModel(77,"Badajoz"));
        cityModels.add(new CityModel(27,"Barcelona"));
//        cityModels.add(new CityModel(63,"Barcelona-Sabadell"));
//        cityModels.add(new CityModel(28,"Bizkaia"));
//        cityModels.add(new CityModel(78,"Burgos"));
//        cityModels.add(new CityModel(80,"Cáceres"));
//        cityModels.add(new CityModel(81,"Cádiz"));
//        cityModels.add(new CityModel(109,"Cádiz-La Línea"));
//        cityModels.add(new CityModel(101,"Cantabria"));
        cityModels.add(new CityModel(102,"Castellón-Castellò"));
        cityModels.add(new CityModel(103,"Ceuta"));
//        cityModels.add(new CityModel(79,"Ciudad Real"));
//        cityModels.add(new CityModel(30,"Córdoba"));
//        cityModels.add(new CityModel(1,"Coruña (A)"));
//        cityModels.add(new CityModel(64,"Coruña (A)-Santiago"));
//        cityModels.add(new CityModel(104,"Cuenca"));
//        cityModels.add(new CityModel(105,"Gipuzkoa"));
//        cityModels.add(new CityModel(33,"Girona"));
//        cityModels.add(new CityModel(34,"Granada"));
//        cityModels.add(new CityModel(35,"Guadalajara"));
//        cityModels.add(new CityModel(106,"Huelva"));
//        cityModels.add(new CityModel(107,"Huesca"));
//        cityModels.add(new CityModel(36,"Illes Balears-Ibiza"));
//        cityModels.add(new CityModel(112,"Illes Balears-Mallorca"));
//        cityModels.add(new CityModel(116,"Illes Balears-Menorca"));
//        cityModels.add(new CityModel(108,"Jaén"));
//        cityModels.add(new CityModel(31,"Las Palmas-Fuerteventura"));
//        cityModels.add(new CityModel(38,"Las Palmas-Gran Canaria"));
//        cityModels.add(new CityModel(37,"Las Palmas-Lanzarote"));
//        cityModels.add(new CityModel(39,"León"));
//        cityModels.add(new CityModel(110,"Lleida"));
//        cityModels.add(new CityModel(111,"Lugo"));
//        cityModels.add(new CityModel(40,"Madrid"));
//        cityModels.add(new CityModel(74,"Madrid-Alcalá de Henares"));
//        cityModels.add(new CityModel(2,"Madrid-Alcorcón"));
        cityModels.add(new CityModel(41,"Málaga"));
//        cityModels.add(new CityModel(113,"Melilla"));
        cityModels.add(new CityModel(61,"Murcia"));
        cityModels.add(new CityModel(29,"Murcia-Cartagena"));
//        cityModels.add(new CityModel(117,"Navarra"));
//        cityModels.add(new CityModel(118,"Ourense"));
//        cityModels.add(new CityModel(119,"Palencia"));
//        cityModels.add(new CityModel(62,"Pontevedra"));
//        cityModels.add(new CityModel(70,"Pontevedra-Vigo"));
//        cityModels.add(new CityModel(115,"Rioja (La)"));
//        cityModels.add(new CityModel(120,"S.C. de Tenerife"));
//        cityModels.add(new CityModel(126,"S.C. de Tenerife-La Palma"));
//        cityModels.add(new CityModel(114,"Salamanca"));
//        cityModels.add(new CityModel(121,"Segovia"));
//        cityModels.add(new CityModel(65,"Sevilla"));
//        cityModels.add(new CityModel(122,"Soria"));
        cityModels.add(new CityModel(67,"Tarragona"));
//        cityModels.add(new CityModel(123,"Teruel"));
//        cityModels.add(new CityModel(68,"Toledo"));
//        cityModels.add(new CityModel(66,"Toledo-Talavera"));
        cityModels.add(new CityModel(69,"Valencia-València"));
//        cityModels.add(new CityModel(25,"Valencia/València-Alzira"));
//        cityModels.add(new CityModel(124,"Valladolid"));
//        cityModels.add(new CityModel(125,"Zamora"));
//        cityModels.add(new CityModel(71,"Zaragoza"));
        return cityModels;
    }
}
