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
    @PostMapping("/upload/pdf")
    public String handleUploadPDF(Model model,
                                      @RequestParam("file") MultipartFile multipart) {
        return this.fileService.handleUploadPDF(model, multipart);
    }

    @PostMapping("/upload/jpg")
    public String handleUploadImage(Model model,
                                   @RequestParam("file") MultipartFile multipart) {
        return this.fileService.handleUploadImage(model, multipart);
    }
}
