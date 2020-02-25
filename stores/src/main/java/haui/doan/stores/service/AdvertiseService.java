package haui.doan.stores.service;

import haui.doan.stores.dto.request.AdvertiseRequest;
import haui.doan.stores.dto.response.AdvertiseResponse;

import java.util.List;

public interface AdvertiseService {
    void createAdvertise(AdvertiseRequest request);

    void updateAdvertise(AdvertiseRequest request);

    void deleteAdvertise(Long id);

    AdvertiseResponse editAdvertise(Long id);

    List<AdvertiseResponse> findAdvertises();
}
