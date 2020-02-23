package haui.doan.stores.service;

import haui.doan.stores.dto.request.ImageRequest;
import haui.doan.stores.persistenct.domain.Image;

public interface ImageService {

    void initDataStorage();

    Image saveImage(ImageRequest request);

    Image updateImage(ImageRequest request);

    Image deleteImage(Long id);

    Image getImageDefault();

}
