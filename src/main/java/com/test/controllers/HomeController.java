package com.test.controllers;

import org.omg.CORBA.Request;
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
    public String index(){
        return INDEX_PAGE_DIR;
    }

    @RequestMapping(path = INDEX_PAGE_PATH, method = RequestMethod.POST)
    public @ResponseBody String index(Request request){

        return INDEX_PAGE_DIR;
    }

}
