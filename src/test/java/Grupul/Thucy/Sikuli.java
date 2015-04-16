package Grupul.Thucy;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

public class Sikuli {

    public static void main(String[] args) throws InterruptedException {
        Screen s = new Screen();
        try {
            s.click("src/test/resources/p1.png");
            // s.wait(1000);
            s.wait("src/test/resources/p2.png");
            s.click();
            s.click("src/test/resources/p3.png");
            s.write("hello world ahahahhaha #ENTER.");
            s.click("src/test/resources/p4.png");
        }
        catch (FindFailed e) {
            e.printStackTrace();
        }
    }

}
