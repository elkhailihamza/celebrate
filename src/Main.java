import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Program program = new Program();
        program.start();
        program.startTimer(3, 1000, "wow", program);
        program.playSound("src/sounds/win.wav");
        program.shutdown();
        JOptionPane.showMessageDialog(null, "wow");
        System.exit(0);
    }
}