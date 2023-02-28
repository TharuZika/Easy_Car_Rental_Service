package lk.ijse.easycar.service.impl;

import lk.ijse.easycar.dto.ImageDTO;
import lk.ijse.easycar.entity.Image;
import lk.ijse.easycar.repo.ImageRepo;
import lk.ijse.easycar.service.ImageService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Service
@Transactional
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveImage(ImageDTO dto) {
        repo.save(mapper.map(dto, Image.class));
    }

    @Override
    public void deleteImage(String id) {
        repo.deleteById(id);
    }

    @Override
    public ArrayList<ImageDTO> getAllImages() {
        ArrayList<ImageDTO> allList=mapper.map(repo.findAll(),new TypeToken<ArrayList<ImageDTO>>(){}.getType());
        return allList;
    }

    @Override
    public ImageDTO findImageById(String imageId) {
        Optional<Image> byId = repo.findById(imageId);
        return mapper.map(byId, ImageDTO.class);
    }
}
