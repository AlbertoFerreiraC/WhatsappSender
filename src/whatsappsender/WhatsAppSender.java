package whatsappsender;

import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.URI;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class WhatsAppSender {

    public static void main(String[] args) {
        try {
            String fecha = "20/05/2023";
            String hora = "09:00";
            String doctor = "ORLANDO FERREIRA";
            String dia = "Sábado";
            String mensaje = "Buenas tardes! *Onix Odontología* le recuerda que "
                    + "usted tiene una cita marcada para el día " + dia + " "
                    + "" + fecha + " a las " + hora + " con el *Dr. " + doctor + ""
                    + "*.\nFavor confirmar asistencia.\nGracias!!";

            Robot robot = new Robot();

            String imagePath = "C:/Users/Alberto/Desktop/Ideas/WhatsAppSender/src/Imagenes/drawing-g20f6cc09b_1280.jpg";
            File imageFile = new File(imagePath);
            Desktop desktop = Desktop.getDesktop();
            desktop.open(imageFile);
            Thread.sleep(3000);
            robot.keyPress(KeyEvent.VK_CONTROL); //presiona
            robot.keyPress(KeyEvent.VK_C); //presiona
            robot.keyRelease(KeyEvent.VK_CONTROL); //livera
            robot.keyRelease(KeyEvent.VK_C);//livera
            Thread.sleep(2000);
            robot.keyPress(KeyEvent.VK_CONTROL);//presiona
            robot.keyPress(KeyEvent.VK_W);//presiona
            robot.keyRelease(KeyEvent.VK_CONTROL);//livera
            robot.keyRelease(KeyEvent.VK_W);//livera

            List<String> numeros = new ArrayList<>();
            numeros.add("595961275346");
            numeros.add("595983232390");

            for (String numero : numeros) {
                try {
                    String encodedMensaje = URLEncoder.encode(mensaje, "UTF-8");
                    String url = "https://api.whatsapp.com/send?phone=" + numero + "&text=" + encodedMensaje;

                    if (desktop.isSupported(Desktop.Action.BROWSE)) {
                        URI uri = new URI(url);
                        desktop.browse(uri);

                        Thread.sleep(5000);

                        robot.keyPress(KeyEvent.VK_CONTROL);//presiona
                        robot.keyPress(KeyEvent.VK_V);//presiona
                        Thread.sleep(2000);
                        robot.keyRelease(KeyEvent.VK_V);//livera
                        robot.keyRelease(KeyEvent.VK_CONTROL);//livera
                        Thread.sleep(2000);
                        robot.keyPress(KeyEvent.VK_ENTER);//presiona
                        Thread.sleep(2000);
                        robot.keyRelease(KeyEvent.VK_ENTER);//livera

                    } else {
                        JOptionPane.showMessageDialog(null, "NO PUDE ACCEDER A LA CUENTA DE WHATSAPP");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "¡Error! No se pudo enviar el mensaje a " + numero);
                }

                Thread.sleep(2000);
                robot.keyPress(KeyEvent.VK_ENTER);//presiona
                Thread.sleep(1000);
                robot.keyRelease(KeyEvent.VK_ENTER);//livera

                Thread.sleep(3000);

                robot.keyPress(KeyEvent.VK_CONTROL);//presiona
                robot.keyPress(KeyEvent.VK_W);//presiona
                Thread.sleep(2000);
                robot.keyRelease(KeyEvent.VK_CONTROL);//livera
                robot.keyRelease(KeyEvent.VK_W);//livera

                Thread.sleep(2000);

                robot.keyPress(KeyEvent.VK_ALT);//presiona
                robot.keyPress(KeyEvent.VK_F4);//presiona
                Thread.sleep(2000);
                robot.keyRelease(KeyEvent.VK_ALT);//livera
                robot.keyRelease(KeyEvent.VK_F4);//livera

                Thread.sleep(3000);

                robot.keyPress(KeyEvent.VK_CONTROL);//presiona
                robot.keyPress(KeyEvent.VK_W);//presiona
                Thread.sleep(1000);
                robot.keyRelease(KeyEvent.VK_CONTROL);//livera
                robot.keyRelease(KeyEvent.VK_W);//livera

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
