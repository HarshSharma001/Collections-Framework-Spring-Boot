package com.collectionsframework.businessLogic;

import org.springframework.context.annotation.Scope;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileInputStream;
@Component
@Scope(value = "singleton")
public class DownloadFileService {


    public ResponseEntity<InputStreamResource> downloadFile(){
        ModelAndView mav = new ModelAndView();
        try{
            File file = new File("src/main/resources/Collections.jar");
            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Collections.jar");
            headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
            headers.add("Pragma", "no-cache");
            headers.add("Expires", "0");

            return ResponseEntity.ok()
                    .headers(headers)
                    .contentLength(file.length())
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(resource);

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
