package com.example.getmesocialservice.apiResource;

import com.example.getmesocialservice.model.Photo;
import com.example.getmesocialservice.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PhotoResource {

    @Autowired
     private  PhotoService photoService;


    @PostMapping("/photo")
    public Photo savePhoto(@RequestBody Photo photo){

        return photoService.savePhoto(photo);

    }

    public List<Photo> getAllPhotos(){
        return photoService.getAllPhotos();
    }

    @PutMapping
    public Photo updatePhoto(@RequestBody Photo photo){

        return photoService.updatePhoto(photo);

    }

    @DeleteMapping
    public void deletePhoto(@RequestParam(name = "photo") Photo photo){
        photoService.deletePhoto(photo);

    }
}