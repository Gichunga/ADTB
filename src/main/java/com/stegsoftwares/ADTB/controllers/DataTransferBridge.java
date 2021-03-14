package com.gwazasoftwares.ADTB.controllers;

import com.gwazasoftwares.ADTB.models.HealthFacility;
import com.gwazasoftwares.ADTB.services.GenericPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataTransferBridge {

    @Autowired
    private GenericPostService genericService;


    @PostMapping("/facilities")
    public String postHealthFacility(@RequestBody HealthFacility healthFacility){

        //this method posts data to kmhfl
       // HealthFacility response =   genericService.postHealthFacility(healthFacility);

        //this method gets data returned by kmhfl and posts it to  local db
        HealthFacility responseFromKMHFL = genericService.postHealthFacilityToLocalDB(healthFacility);

        if(!responseFromKMHFL.equals(null)){
            genericService.transferDataToDhis2(responseFromKMHFL);
        }else{

            //Show error to user
        }

        return  "success";
    }
}
