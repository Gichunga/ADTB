package com.gwazasoftwares.ADTB.controllers;


import com.gwazasoftwares.ADTB.models.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {



    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/quotes")
    public Quote getQuotes(){
        Quote quote = restTemplate.getForObject(
                "https://gturnquist-quoters.cfapps.io/api/random", Quote.class);

        return  quote;
    }




}
