package haui.doan.stores.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;


public class FileUtils {
    public static String store(MultipartFile file, Path root) {
        Long timeNow = Instant.now().getEpochSecond();
        try {
            String newFileName = timeNow + "-" + file.getOriginalFilename();
            Files.copy(file.getInputStream(),
                    root.resolve(newFileName));
            return newFileName;
        } catch (Exception e) {
            throw new RuntimeException("FAIL!");
        }
    }

    public void init(Path root) {
        try {
            Files.createDirectory(root);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize storage!");
        }
    }

    public static boolean checkFileNullOrEmpty(MultipartFile file) {
        return file.isEmpty() || file.getSize() == 0 || file == null;
    }

}
