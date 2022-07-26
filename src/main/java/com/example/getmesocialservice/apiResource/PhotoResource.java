package com.example.getmesocialservice.apiResource;

import com.example.getmesocialservice.model.Album;
import com.example.getmesocialservice.model.Comment;
import com.example.getmesocialservice.model.Photo;
import com.example.getmesocialservice.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PhotoResource {

    @Autowired
     private  PhotoService photoService;


    @PostMapping("/photo")
    public Photo savePhoto(@RequestBody @Valid Photo photo){

        return photoService.savePhoto(photo);

    }
    @GetMapping
    public List<Photo> getAllPhotos(){
        return photoService.getAllPhotos();
    }

    @GetMapping("/get-by-id")
    public List<Photo> getById(@RequestParam(name = "id") String id){
        return photoService.getById(id);
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