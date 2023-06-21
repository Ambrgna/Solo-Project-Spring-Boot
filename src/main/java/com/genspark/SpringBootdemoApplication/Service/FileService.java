package com.genspark.SpringBootdemoApplication.Service;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    String handleUploadPDF(Model model, MultipartFile multipart);

    String handleUploadImage(Model model, MultipartFile multipart);
}
