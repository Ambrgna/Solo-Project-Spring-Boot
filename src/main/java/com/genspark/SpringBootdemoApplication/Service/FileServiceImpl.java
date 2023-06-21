package com.genspark.SpringBootdemoApplication.Service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public String handleAppUploadForm(Model model, MultipartFile multipart) {
        String fileName = multipart.getOriginalFilename();

        System.out.println("filename: " + fileName);

        String message = "";

        try {
            S3Util.upload(fileName, multipart.getInputStream());
            message = "Your file has been uploaded successfully!";
        } catch (Exception ex) {
            message = "Error uploading file: " + ex.getMessage();
        }

        model.addAttribute("message", message);
        System.out.println(message);

        return "message";
    }
    @Override
    public String handleImageUploadForm(Model model, MultipartFile multipart) {
        String fileName = multipart.getOriginalFilename();

        System.out.println("filename: " + fileName);

        String message = "";

        try {
            S3Util.uploadImage(fileName, multipart.getInputStream());
            message = "Your file has been uploaded successfully!";
        } catch (Exception ex) {
            message = "Error uploading file: " + ex.getMessage();
        }

        model.addAttribute("message", message);
        System.out.println(message);

        return "message";
    }
}
