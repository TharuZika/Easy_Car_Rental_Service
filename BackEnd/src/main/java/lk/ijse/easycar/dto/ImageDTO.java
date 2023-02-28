package lk.ijse.easycar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class ImageDTO {
    private String imageId;
    private String imageType;
    private MultipartFile imageFile;
    private String imageUrl;
}
