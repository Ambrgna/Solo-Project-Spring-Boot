package com.genspark.SpringBootdemoApplication.Controller;

import com.genspark.SpringBootdemoApplication.Entity.Item;
import com.genspark.SpringBootdemoApplication.Service.FileService;
import com.genspark.SpringBootdemoApplication.Service.S3Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class FileController {
    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public String handleAppUploadForm(Model model,
                                   @RequestParam("file") MultipartFile multipart) {
        return this.fileService.handleAppUploadForm(model, multipart);
    }

    @PostMapping("/upload/image")
    public String handleImageUploadForm(Model model,
                                   @RequestParam("file") MultipartFile multipart) {
        return this.fileService.handleImageUploadForm(model, multipart);
    }
}
