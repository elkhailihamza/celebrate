import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Program {
    public void start() {
        System.out.println("Press \"ENTER\" to start celebration...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    public synchronized void startTimer(int iterations, int timeInMillis, String msg, Program lock) {
        try {
            for (int i = 1; i <= iterations; i++) {
                System.out.println(i);
                lock.wait(timeInMillis);
            }
        } catch (InterruptedException e) {
            System.out.println("err: " + e);
        }
        System.out.println(msg);
    }

    public void playSound(String soundPath) {
        try {
            File sound = new File(soundPath);
            if (sound.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(sound);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.setFramePosition(0);
                clip.start();
            } else {
                System.out.println("Sound not found!");
            }
        } catch (Exception e) {
            System.out.println("err: " + e);
        }
    }

    public void shutdown() {
        try {
            Runtime runTime = Runtime.getRuntime();
            runTime.exec("cmd /c start shutdown /s -s 3");
        } catch (IOException e) {
            System.out.println("err: "+e);
        }
    }
}
