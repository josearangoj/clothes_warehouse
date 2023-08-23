package com.cpan228.clothes_warehouse.controller;

import com.cpan228.clothes_warehouse.model.dto.DistributionCentre;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
@Controller
@RequestMapping("/dc")
@CrossOrigin(origins = "http://localhost:8081")
public class DistributionCentreController {
    private RestTemplate restTemplate;

    public DistributionCentreController (RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public String distributionCentres(){
        return "DistributionCentre";
    }

    @ModelAttribute("centres")
    public List<DistributionCentre> getDistributionCentre(){
        return Arrays.asList(restTemplate.getForObject("http://localhost:8081/api/dc", DistributionCentre[].class));
    }
}
