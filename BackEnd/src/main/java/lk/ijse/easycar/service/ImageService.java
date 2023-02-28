package lk.ijse.easycar.service;

import lk.ijse.easycar.dto.ImageDTO;
import lk.ijse.easycar.entity.Image;

import java.util.ArrayList;

public interface ImageService {

    public void saveImage(ImageDTO dto);

    public void deleteImage(String id);

    public ArrayList<ImageDTO> getAllImages();

    public ImageDTO findImageById(String imageId);
}
