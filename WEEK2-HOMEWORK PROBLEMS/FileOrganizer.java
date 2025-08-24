import java.io.*;
import java.util.*;

public class FileOrganizer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String dirPath = sc.nextLine();
        File dir = new File(dirPath);
        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("Invalid directory.");
            return;
        }
        File[] files = dir.listFiles();
        if (files == null) {
            System.out.println("No files found.");
            return;
        }
        for (File file : files) {
            if (file.isFile()) {
                String name = file.getName();
                int idx = name.lastIndexOf('.');
                String ext = (idx == -1) ? "others" : name.substring(idx + 1);
                File newDir = new File(dirPath + "/" + ext);
                if (!newDir.exists()) newDir.mkdir();
                file.renameTo(new File(newDir, name));
            }
        }
        System.out.println("Files organized by extension.");
    }
}
