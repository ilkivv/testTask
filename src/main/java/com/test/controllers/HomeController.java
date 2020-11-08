package com.test.controllers;

import com.test.intarfaces.CarRepository;
import com.test.intarfaces.PenaltyRepository;
import com.test.intarfaces.UserRepository;
import com.test.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    private final static String INDEX_PAGE_PATH = "/";
    private final static String POST_SEARCH_DATA_INFO_PATH = "/search-info";
    private final static String POST_GENERATE_REPORT_PATH = "/search-info";

    private final static String INDEX_PAGE_DIR = "pages/index";

    private final PenaltyRepository penaltyRepository;

    private final CarService carService;

    public HomeController(PenaltyRepository penaltyRepository, CarService carService) {
        this.penaltyRepository = penaltyRepository;
        this.carService = carService;
    }

    @RequestMapping(path = INDEX_PAGE_PATH, method = RequestMethod.GET)
    public String index(){
        return INDEX_PAGE_DIR;
    }

    @RequestMapping(path = POST_SEARCH_DATA_INFO_PATH, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<List<?>> search(@RequestBody Map<String, String> requestBody){
        List penalties = carService.getPenalties(requestBody.get("fullName"), requestBody.get("stateNumber"));
        return new ResponseEntity<>(penalties, HttpStatus.OK);
    }

//    @RequestMapping(path = POST_GENERATE_REPORT_PATH, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public @ResponseBody ResponseEntity<List<?>> generateReport(){
//
//        List commonPenalties = penaltyRepository.findAll();
//
//        return new ResponseEntity<>(commonPenalties, HttpStatus.OK);
//    }
}
