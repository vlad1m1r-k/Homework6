package ua.kiev.prog.homework6.part5;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DirMonitor {
    private static File dirForMon;

    public static void main(String[] args) {
        if (args.length < 1) System.out.println("Usage: DirMonitor MonitoringDirectory\nEnter for Exit");
        else {
            dirForMon = new File(args[0]);
            if (!dirForMon.exists() || !dirForMon.isDirectory()) System.out.println("It is not a directory.");
            else {
                Thread thread = new Thread(() -> startThread());
                thread.setDaemon(true);
                thread.start();
                System.out.println("Enter for exit.");
                new Scanner(System.in).nextLine();
            }
        }
    }

    public static File getDirForMon() {
        return dirForMon;
    }

    private static void startThread(){
        File dirForMon = DirMonitor.getDirForMon();
        List<File> previousList = new ArrayList<File>(Arrays.asList(dirForMon.listFiles()));
        File[] newState;
        while (true) {
            newState = dirForMon.listFiles();
            if (!Arrays.equals(previousList.toArray(), newState)) {
                for (int i = 0; i < newState.length; i++) {
                    if (previousList.remove(newState[i])) {
                        newState[i] = null;
                    }
                }
                for (File file: newState){
                    if (file != null){
                        System.out.println((file.isDirectory()?"Directory \"":"File \"") + file.getName() + "\" added.");
                    }
                }
                for (File file: previousList){
                    if (file != null){
                        System.out.println((file.isDirectory()?"Directory \"":"File \"") + file.getName() + "\" removed.");
                    }
                }
                previousList = new ArrayList<File>(Arrays.asList(dirForMon.listFiles()));
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
