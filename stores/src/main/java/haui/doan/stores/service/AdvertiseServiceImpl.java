package haui.doan.stores.service;

import haui.doan.stores.dto.request.AdvertiseRequest;
import haui.doan.stores.dto.request.ImageRequest;
import haui.doan.stores.dto.response.AdvertiseResponse;
import haui.doan.stores.persistenct.domain.Advertise;
import haui.doan.stores.persistenct.domain.Image;
import haui.doan.stores.persistenct.repository.AdvertiseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdvertiseServiceImpl implements AdvertiseService {

    private final ImageService imageService;
    private final AdvertiseRepository advertiseRepository;

    @Autowired
    public AdvertiseServiceImpl(ImageService imageService, AdvertiseRepository advertiseRepository) {
        this.imageService = imageService;
        this.advertiseRepository = advertiseRepository;
    }

    @Override
    public void createAdvertise(AdvertiseRequest request) {
        Advertise advertise = new Advertise();
        advertise.setId(request.getId());
        advertise.setContent(request.getContent());
        advertise.setLink(request.getLink());
        advertise.setStatus(request.getStatus());
        //Image
        ImageRequest imageRequest = new ImageRequest();
        imageRequest.setId(request.getImageId());
        imageRequest.setImage(request.getImage());
        Image image = imageService.saveImage(imageRequest);

        advertise.setImageId(image.getId());
        advertise.setImage(image);
        advertiseRepository.save(advertise);
    }

    @Override
    public void updateAdvertise(AdvertiseRequest request) {
        Advertise advertise = advertiseRepository.getOne(request.getId());
        advertise.setLink(request.getLink());
        advertise.setContent(request.getContent());
        advertise.setStatus(request.getStatus());
        //Image Request
        ImageRequest imageRequest = new ImageRequest();
        imageRequest.setId(request.getImageId());
        imageRequest.setImage(request.getImage());
        Image image = imageService.updateImage(imageRequest);

        advertise.setImageId(image.getId());
        advertise.setImage(image);
        advertiseRepository.save(advertise);
    }

    @Override
    public void deleteAdvertise(Long id) {
        Advertise advertise = advertiseRepository.getOne(id);
        advertiseRepository.delete(advertise);
    }

    @Override
    public AdvertiseResponse editAdvertise(Long id) {
        Advertise advertise = advertiseRepository.getOne(id);
        AdvertiseResponse response = new AdvertiseResponse();
        response.setId(advertise.getId());
        response.setImageId(advertise.getImageId());
        response.setLink(advertise.getLink());
        response.setContent(advertise.getContent());
        response.setStatus(advertise.getStatus());
        response.setImage(advertise.getImage().getUrl());
        return response;
    }

    @Override
    public List<AdvertiseResponse> findAdvertises() {
        List<Advertise> advertises = advertiseRepository.findAll();
        List<AdvertiseResponse> advertiseResponses = new ArrayList<>();
        advertises.forEach(advertise -> {
            AdvertiseResponse response = new AdvertiseResponse();
            response.setId(advertise.getId());
            response.setImageId(advertise.getImageId());
            response.setLink(advertise.getLink());
            response.setContent(advertise.getContent());
            response.setStatus(advertise.getStatus());
            response.setImage(advertise.getImage().getUrl());
            advertiseResponses.add(response);
        });
        return advertiseResponses;
    }
}
