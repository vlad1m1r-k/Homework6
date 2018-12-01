package ua.kiev.prog.homework6.part4;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CopyThread implements Runnable {
    private File file;
    private Path target;

    public CopyThread(File file, Path target) {
        this.file = file;
        this.target = target;
    }

    @Override
    public void run() {
        try {
            Files.copy(file.toPath(), Paths.get(target.toFile().getAbsolutePath() + File.separator +file.getName()), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.out.println("Error copying file: " + file.getName());
        }
    }
}
