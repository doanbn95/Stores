package haui.doan.stores.dto.response;

import lombok.Data;

@Data
public class CategoryResponse {

    private Long id;

    private String name;

    private String content;

    private Long imageId;

    private String imageUrl;

    private int status;

    private int deleted;

    private int size;

    private String nameOld;
}
