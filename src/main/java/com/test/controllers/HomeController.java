package com.test.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class HomeController {

    private final static String INDEX_PAGE_PATH = "/";
    private final static String INDEX_PAGE_DIR = "pages/index";


    @RequestMapping(path = INDEX_PAGE_PATH, method = RequestMethod.GET)
    public String index(Map<String, Object> model){

        return INDEX_PAGE_DIR;
    }

    @RequestMapping(path = INDEX_PAGE_PATH, method = RequestMethod.POST)
    public @ResponseBody String index(){

        return INDEX_PAGE_DIR;
    }

}
