package lk.ijse.easycar.util;

import lk.ijse.easycar.dto.ImageDTO;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class imageDownloadUtil {
    private Path foundImg = null;

    private void searchImg(Path path, String imgName){
        foundImg = null;
        try {
            Files.list(path).forEach(img ->{
                if (img.getFileName().toString().startsWith(imgName)){
                    System.out.println("Image Founded");
                    foundImg = img;
                    return;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Resource getImgResource(ImageDTO imageDTO){
        String pathDir = null;
        Path path = null;

        switch (imageDTO.getImageType()){
            case "car":
                pathDir = "C:\\Users\\ASUS\\Documents\\GDSE60\\Advanced API\\AAD CourseWork\\Easy_car_rental_private_limited\\BackEnd\\src\\main\\resources\\static\\Images\\carImages";
                path = Paths.get(pathDir);
                String imageName = imageDTO.getImageId()+imageDTO.getImageView()+".jpeg";
                searchImg(path, imageName);
                break;

            case "nic":
                pathDir = "C:\\Users\\ASUS\\Documents\\GDSE60\\Advanced API\\AAD CourseWork\\Easy_car_rental_private_limited\\BackEnd\\src\\main\\resources\\static\\Images\\userImages";
                path = Paths.get(pathDir + "/" + imageDTO.getImageId() + imageDTO.getImageType() + ".jpeg");
                break;
        }

        try{
            if (foundImg != null){
                return new UrlResource(foundImg.toUri());
            }
        }catch (MalformedURLException e){
            e.printStackTrace();
        }

        return null;
    }

}
