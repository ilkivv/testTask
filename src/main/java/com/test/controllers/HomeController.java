package com.test.controllers;

import com.test.classes.ExcelDocument;
import com.test.entities.Penalty;
import com.test.intarfaces.PenaltyRepository;
import com.test.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    private final static String INDEX_PAGE_PATH = "/";
    private final static String POST_SEARCH_DATA_INFO_PATH = "/search-info";
    private final static String POST_GENERATE_REPORT_PATH = "/generate-report";

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
        List penaltiesByCarOrUser = carService.getPenalties(requestBody.get("stateNumber"), requestBody.get("fullName"));
        return new ResponseEntity<>(penaltiesByCarOrUser, HttpStatus.OK);
    }

    @RequestMapping(path = POST_GENERATE_REPORT_PATH, method = RequestMethod.GET)
    public ModelAndView generateReport(){
        List<Penalty> penalties = penaltyRepository.rating();
        return new ModelAndView(new ExcelDocument(penalties));
    }
}
