package com.collectionsframework.controller;

import com.collectionsframework.businessLogic.DataStructureHandler;
import com.collectionsframework.businessLogic.DownloadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class FrontController {
    @Autowired
    private DataStructureHandler handler;
    @Autowired
    private DownloadFileService fileDownloader;

    @RequestMapping(path = "/collections")
    public ModelAndView getHomepage(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Homepage");
        return mav;
    }

    @GetMapping(path = "/download")
    public ResponseEntity download(){
        return fileDownloader.downloadFile();
    }

    @GetMapping(path = "aboutMe")
    public ModelAndView aboutMe(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("AboutMe");
        return mav;
    }

    @RequestMapping(path = "/testApi")
    public ModelAndView testAPI(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("TestAPI");
        return mav;
    }

    @PostMapping(path = "/add")
    public ModelAndView add(@RequestParam("dataStructure") String type, @RequestParam("add_element") int element){
        handler.verifyDataStructure(type);
        handler.addElement(element);
        Object[] arr = handler.getCurrentDataStructure();
        String dsa_name = type.substring(0, 1).toUpperCase() + type.substring(1);

        ModelAndView mav = new ModelAndView();
        mav.addObject("dsa_name", dsa_name);
        mav.addObject("dsa", arr);
        mav.setViewName("TestAPI");
        return mav;
    }


    @PostMapping(path = "/remove")
    public ModelAndView remove(@RequestParam("dataStructure") String type, @RequestParam("delete_element") int element){
        handler.verifyDataStructure(type);
        String error = handler.removeElement(element);
        Object[] arr = handler.getCurrentDataStructure();
        String dsa_name = type.substring(0, 1).toUpperCase() + type.substring(1);

        ModelAndView mav = new ModelAndView();
        if(error.length() == 0){
            mav.addObject("dsa_name", dsa_name);
            mav.addObject("dsa", arr);
            mav.setViewName("TestAPI");
            return mav;
        }
        else{
            mav.addObject("errorMessage", error);
            mav.setViewName("Error");
            return mav;
        }
    }


    @PostMapping(path = "/max")
    public ModelAndView getMax(@RequestParam("dataStructure") String type){
        handler.verifyDataStructure(type);
        Object[] arr = handler.getCurrentDataStructure();
        String dsa_name = type.substring(0, 1).toUpperCase() + type.substring(1);

        ModelAndView mav = new ModelAndView();
        mav.addObject("dsa_name", dsa_name);
        mav.addObject("maxElement", handler.getMaxElement());
        mav.addObject("dsa", arr);
        mav.setViewName("TestAPI");
        return mav;
    }


    @PostMapping(path = "/search")
    public ModelAndView search(@RequestParam("dataStructure") String type, @RequestParam("searching_element") int element){
        handler.verifyDataStructure(type);
        Object[] arr = handler.getCurrentDataStructure();
        String dsa_name = type.substring(0, 1).toUpperCase() + type.substring(1);

        ModelAndView mav = new ModelAndView();
        mav.addObject("dsa_name", dsa_name);
        mav.addObject("elementFound", handler.searchElement(element));
        mav.addObject("dsa", arr);
        mav.setViewName("TestAPI");
        return mav;
    }


    @PostMapping(path = "/size")
    public ModelAndView getSize(@RequestParam("dataStructure") String type){
        handler.verifyDataStructure(type);
        Object[] arr = handler.getCurrentDataStructure();
        String dsa_name = type.substring(0, 1).toUpperCase() + type.substring(1);

        ModelAndView mav = new ModelAndView();
        mav.addObject("dsa_name", dsa_name);
        mav.addObject("size", handler.getSize());
        mav.addObject("dsa", arr);
        mav.setViewName("TestAPI");
        return mav;
    }


    @PostMapping(path = "/sort")
    public ModelAndView sort(@RequestParam("dataStructure") String type){
        handler.verifyDataStructure(type);
        String error = handler.sortDataStructure();
        Object[] arr = handler.getCurrentDataStructure();
        String dsa_name = type.substring(0, 1).toUpperCase() + type.substring(1);

        ModelAndView mav = new ModelAndView();
        if(error.length() == 0){
            mav.addObject("dsa_name", dsa_name);
            mav.addObject("dsa", arr);
            mav.setViewName("TestAPI");
            return mav;
        }
        else{
            mav.addObject("errorMessage", error);
            mav.setViewName("Error");
            return mav;
        }
    }
}
