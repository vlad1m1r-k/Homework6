package ua.kiev.prog.homework6.part5;

import java.io.File;

public class DirMonitor {
    public static void main(String[] args) {
        if (args.length < 1) System.out.println("Usage: DirMonitor MonitoringDirectory\nEnter for Exit");
        else {
            File dirForMon = new File(args[0]);
            if (!dirForMon.exists() || !dirForMon.isDirectory()) System.out.println("It is not directory.");
            else {

            }
        }
    }
}
