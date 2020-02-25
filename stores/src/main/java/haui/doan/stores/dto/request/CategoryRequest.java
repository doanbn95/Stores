package haui.doan.stores.dto.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CategoryRequest {

    private Long id;

    @Size(max = 30)
    private String name;

    private String content;

    private Long imageId;

    private MultipartFile image;

    private int status;

    private int deleted;

    private String nameOld;

}
