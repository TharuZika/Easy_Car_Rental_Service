package lk.ijse.easycar.util;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class ImageSearchUtil {
    boolean b = false;
    public boolean searchImg(String path, String imageName){
        b = false;

        try {
            Files.list(Paths.get(path)).forEach(img -> {
                if (img.getFileName().toString().startsWith(imageName)){
                    System.out.println("Image Founded");
                    b = true;
                    return;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return b;
    }
}
