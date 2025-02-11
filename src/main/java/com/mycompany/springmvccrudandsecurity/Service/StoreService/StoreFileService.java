/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.springmvccrudandsecurity.Service;

import jakarta.mail.Multipart;
import jakarta.servlet.ServletContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author khuye
 */
@Service
public class StoreFileService {
    @Autowired
    private ServletContext servletContext;
    
    private String sRootLocation;
    private Path pRootLocation;
    private Path destinationFile;
    
    public boolean store(MultipartFile file, String fileName, String extFile){
        if(file.isEmpty()){
            throw new StoreFileException("Can not store an empty file");
        }
        
        if(!file.getContentType().contains("image")){
//            throw new StoreFileException("Invalid Type");
              return false;
        }
        
        if(file.getOriginalFilename().trim().length() == 0){
//            throw new StoreFileException("Can not store this file");
              return false;

        }
        
        sRootLocation = servletContext.getRealPath("resources/images");
        pRootLocation = Paths.get(sRootLocation);
        destinationFile = pRootLocation.resolve(Paths.get(fileName + extFile)).normalize().toAbsolutePath();
        if(!destinationFile.getParent().equals(this.pRootLocation.toAbsolutePath())){
//            throw new StoreFileException("Parent directory is invalid");
            return false;
        }
        System.out.println(destinationFile.toString());
        try {
            InputStream is = file.getInputStream();
            Files.copy(is, destinationFile, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            return false;
        }
        
        return true;
    }
    
    public void deleteFile(String fileName){
        File file = new  File(sRootLocation + "\\" + fileName);
        try {
            System.out.println("\\" + sRootLocation + "\\" + fileName);
            file.delete();
        } catch (Exception e) {
        }
    }
}
