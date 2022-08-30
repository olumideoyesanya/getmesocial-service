package com.example.getmesocialservice.apiResource;

import com.amazonaws.services.cloudtrail.model.InvalidTokenException;
import com.amazonaws.services.s3.Headers;
import com.amazonaws.services.s3.model.S3Object;
import com.example.getmesocialservice.service.FileService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/api/files")
public class FileResource {

    @Autowired
    private FileService fileService;

    @PostMapping
    public boolean upload(@Parameter(
            description = "files to be uploaded",
            content = @Content(mediaType = MediaType.MULTIPART_FORM_DATA_VALUE)
    ) @RequestPart(value = "files", required = true) MultipartFile file) throws InvalidTokenException, IOException {
        return fileService.upload(file);
    }

    @GetMapping("/view")
    public void view(@RequestParam(name = "Key") String key, HttpServletResponse response) throws IOException {
        S3Object object = fileService.getFile(key);
        response.setContentType(object.getObjectMetadata().getContentType());
        response.getOutputStream().write(object.getObjectContent().readAllBytes());
    }

    @GetMapping("/download")
    public ResponseEntity<ByteArrayResource> download(@RequestParam(name = "Key") String key) throws IOException {
        S3Object object = fileService.getFile(key);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(object.getObjectMetadata().getContentType()))
                .header(Headers.CONTENT_DISPOSITION, "attachment; filename=\"" + key + "\"")
                .body(new ByteArrayResource(object.getObjectContent().readAllBytes()));

    }

    @DeleteMapping
    public void delete(@RequestParam(name = "Key") String key){
        fileService.deleteFile(key);

    }


}
