package es.license.citapriva;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FileChooser extends JFrame implements ActionListener {
    // Jlabel to show the files user selects
    static JLabel l;
    static String fileFullPath = null;
    static JButton button1;
    public static boolean started = false;
    // a default constructor
    FileChooser()
    {

    }

    public static void main(String args[])
    {
        // frame to contains GUI elements
        JFrame f = new JFrame("file chooser");

        // set the size of the frame
        f.setSize(400, 400);

        // set the frame's visibility
        f.setVisible(true);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // button to open save dialog
        button1 = new JButton("Comienzo");

        // button to open open dialog
        JButton button2 = new JButton("HTML abierto");

        // make an object of the class filechooser
        FileChooser f1 = new FileChooser();

        // add action listener to the button to capture user
        // response on buttons
        button1.setEnabled(false);
        button1.addActionListener(f1);
        button2.addActionListener(f1);

        // make a panel to add the buttons and labels
        JPanel p = new JPanel();

        // add buttons to the frame
        p.add(button1);
        p.add(button2);

        // set the label to its initial value
        l = new JLabel("ningún archivo seleccionado");

        // add panel to the frame
        p.add(l);
        f.add(p);

        f.show();
    }
    public void actionPerformed(ActionEvent evt)
    {
        // if the user presses the save button show the save dialog
        String com = evt.getActionCommand();

        if (com.equals("Comienzo")) {
            if(fileFullPath != null && !fileFullPath.isEmpty() && !started) {
                App app =new App(fileFullPath);
                app.startOperation();
            }
        }
        // if the user presses the open dialog show the open dialog

        else {
            // create an object of JFileChooser class
            JFileChooser j = new JFileChooser(FileChooser.class.getProtectionDomain().getCodeSource().getLocation().getFile());

            // restrict the user to select files of all types
            j.setAcceptAllFileFilterUsed(false);

            // set a title for the dialog
            j.setDialogTitle("Seleccione un archivo .html");

            // only allow files of .txt extension
            FileNameExtensionFilter restrict = new FileNameExtensionFilter("Solo archivos .html", "html");
            j.addChoosableFileFilter(restrict);

            // invoke the showsOpenDialog function to show the save dialog
            int r = j.showOpenDialog(null);

            // if the user selects a file
            if (r == JFileChooser.APPROVE_OPTION) {
                // set the label to the path of the selected file
                fileFullPath = j.getSelectedFile().getAbsolutePath();
                l.setText(j.getSelectedFile().getAbsolutePath());
                button1.setEnabled(true);
            }
            // if the user cancelled the operation
            else
                l.setText("El usuario canceló la operación.");
        }
    }
}
