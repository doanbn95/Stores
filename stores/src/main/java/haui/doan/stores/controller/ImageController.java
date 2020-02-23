package haui.doan.stores.controller;

import haui.doan.stores.dto.request.ImageRequest;
import haui.doan.stores.persistenct.domain.Image;
import haui.doan.stores.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/admin/image")
public class ImageController {

    @Autowired
    private ImageService service;

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<Image> saveImage(@Valid ImageRequest request) {
        Image respone = service.saveImage(request);
        return new ResponseEntity<>(respone, HttpStatus.OK);
    }

    @PostMapping("/update")
    @ResponseBody
    public ResponseEntity<Image> updateImage(@Valid ImageRequest request) {
        Image respone = service.updateImage(request);
        return new ResponseEntity<>(respone, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Image> delete(@PathVariable("id") Long id) {
        Image respone = service.deleteImage(id);
        return new ResponseEntity<>(respone, HttpStatus.OK);
    }
}
