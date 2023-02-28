package lk.ijse.easycar.controller;

import lk.ijse.easycar.dto.ImageDTO;
import lk.ijse.easycar.repo.ImageRepo;
import lk.ijse.easycar.service.ImageService;
import lk.ijse.easycar.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

@RestController
@CrossOrigin
@RequestMapping("/image")
public class ImageController {

    @Autowired
    private ImageRepo repo;

    @Autowired
    private ImageService service;

    @PostMapping(path = "/save", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseUtil saveImage(ImageDTO imgDTO, @RequestPart("imageFile") MultipartFile file1) {
        try {
            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
            File uploadsDir = new File(projectPath + "/uploads");
            uploadsDir.mkdir();
            file1.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + file1.getOriginalFilename()));

            imgDTO.setImageUrl("uploads/"+file1.getOriginalFilename());
            service.saveImage(imgDTO);

        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            return new ResponseUtil("Ok", "Successfully Saved", null);
        }
        return new ResponseUtil("Ok", "Successfully Saved", null);
    }

    @DeleteMapping(path = "/delete")
    public ResponseUtil deleteImage(String imageId){
        service.deleteImage(imageId);
        return new ResponseUtil("Ok", "Successfully Image Deleted", null);
    }

    @GetMapping(path = "/getall")
    public ResponseUtil getAllImages(){
        return new ResponseUtil("Ok", "Successfully loaded!", service.getAllImages());
    }

    @GetMapping(path = "/findimage")
    public ResponseUtil findImageById(String imageId){
        return new ResponseUtil("Ok", "Successfully loaded!", service.findImageById(imageId));
    }


}
