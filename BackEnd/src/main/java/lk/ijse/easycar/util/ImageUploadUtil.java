package lk.ijse.easycar.util;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class ImageUploadUtil {
    public static void saveImg(String fullPathWithFileName, MultipartFile multipartFile){
        Path uploadDir = Paths.get(fullPathWithFileName);

        InputStream inputStream = null;
        try{
            inputStream = multipartFile.getInputStream();
            Files.copy(inputStream,uploadDir, StandardCopyOption.REPLACE_EXISTING);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
