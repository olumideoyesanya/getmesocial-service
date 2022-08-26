package com.example.getmesocialservice.model;

import com.example.getmesocialservice.validation.ValidName;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Min;

public class Comment {

    @Id
    private String Id;
    private int photoId;
    @Min(value = 5)
    private String message;
    @ValidName
    private String createdBy;
    private String dateCreated;

    public Comment(int photoId, String message, String createdBy, String dateCreated) {
        this.photoId = photoId;
        this.message = message;
        this.createdBy = createdBy;
        this.dateCreated = dateCreated;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }
}
