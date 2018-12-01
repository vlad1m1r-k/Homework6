package ua.kiev.prog.homework6.part4;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CopyDir {
    public static void main(String[] args) {
        if (args.length < 2) System.out.println("Usage: CopyDir SourceDir TargetDir");
        else {
            Path sourceDir = Paths.get(args[0]);
            Path targetDir = Paths.get(args[1]);
            if (Files.exists(sourceDir, LinkOption.NOFOLLOW_LINKS) && Files.isDirectory(targetDir, LinkOption.NOFOLLOW_LINKS)){
                if (Files.exists(targetDir, LinkOption.NOFOLLOW_LINKS) && !Files.isDirectory(targetDir, LinkOption.NOFOLLOW_LINKS)){
                    System.out.println("Can not create target dir.");
                } else {
                    if (!Files.exists(targetDir, LinkOption.NOFOLLOW_LINKS)){
                        try {
                            Files.createDirectories(targetDir);
                        } catch (IOException e) {
                            System.out.println("Error creating target directory.");
                        }
                    }
                    File[] filesToCopy = sourceDir.toFile().listFiles();
                    for (File file: filesToCopy){
                        new Thread(new CopyThread(file, targetDir)).start();
                    }
                }
            } else System.out.println("Illegal source dir.");
        }
    }
}
