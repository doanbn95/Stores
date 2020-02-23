package haui.doan.stores.service;

import haui.doan.stores.config.ImageStorage;
import haui.doan.stores.constant.CommonConstants;
import haui.doan.stores.dto.request.ImageRequest;
import haui.doan.stores.persistenct.domain.Image;
import haui.doan.stores.persistenct.repository.ImageRepository;
import haui.doan.stores.utils.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
@Slf4j
public class ImageServiceImpl implements ImageService {


    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private ImageStorage imageStorage;

    @Override
    public void initDataStorage() {
        if (Files.exists(Path.of(imageStorage.getPath()))) {
            log.error("Driectory is create");
        } else {
            try {
                Files.createDirectory(Path.of(imageStorage.getPath()));
            } catch (IOException e) {
                log.error("fail create directory directory");
                throw new RuntimeException(e.getMessage());
            }
        }
    }

    @Override
    public Image saveImage(ImageRequest request) {
        boolean checkFile = FileUtils.checkFileNullOrEmpty(request.getImage());
        if (checkFile) {
            log.error("Fail file upload null");
            return getImageDefault();
        } else {
            String name = FileUtils.store(request.getImage(), Path.of(imageStorage.getPath()));
            String url = new StringBuilder("/").append(imageStorage.getPath()).append("/").append(name).toString();
            Image image = new Image();
            image.setName(name);
            image.setUrl(url);
            image.setContext("admin");
            return imageRepository.save(image);
        }
    }

    @Override
    public Image updateImage(ImageRequest request) {
        Image flag = imageRepository.getOne(request.getId());

        if (request.getImage()==null||FileUtils.checkFileNullOrEmpty(request.getImage())) {
            return flag;
        } else {
            //xoa anh
            try {
                Files.deleteIfExists(Path.of(flag.getUrl()));
            } catch (IOException e) {
                log.error("delete image error");
            }
            String name = FileUtils.store(request.getImage(), Path.of(imageStorage.getPath()));
            String url = new StringBuilder("/").append(imageStorage.getPath()).append("/").append(name).toString();
            flag.setUrl(url);
            flag.setName(name);
            return imageRepository.save(flag);
        }
    }

    @Override
    public Image deleteImage(Long id) {
        Image image = imageRepository.getOne(id);
        try {
            Files.deleteIfExists(Path.of(image.getUrl()));
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        image.setName(CommonConstants.IMAGE_DEFAULT.NAME);
        image.setUrl(CommonConstants.IMAGE_DEFAULT.URL);
        return imageRepository.save(image);
    }

    @Override
    public Image getImageDefault() {
        Image flag = imageRepository.findImageByNameIs(CommonConstants.IMAGE_DEFAULT.NAME);
        if (flag == null) {
            flag.setName(CommonConstants.IMAGE_DEFAULT.NAME);
            flag.setUrl(CommonConstants.IMAGE_DEFAULT.URL);
            flag.setContext(CommonConstants.IMAGE_DEFAULT.CONTENT);
        }
        return imageRepository.save(flag);
    }


}
