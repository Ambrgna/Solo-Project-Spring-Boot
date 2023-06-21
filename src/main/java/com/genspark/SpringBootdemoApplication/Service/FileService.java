package com.genspark.SpringBootdemoApplication.Service;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    String handleAppUploadForm(Model model, MultipartFile multipart);
    String handleImageUploadForm(Model model, MultipartFile multipart);
}
