package haui.doan.stores.dto.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class AdvertiseRequest {

    private Long id;

    private Long imageId;

    private MultipartFile image;

    private String link;

    private String content;

    private int status;
}
