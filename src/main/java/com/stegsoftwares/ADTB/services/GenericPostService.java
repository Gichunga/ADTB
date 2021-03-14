package com.gwazasoftwares.ADTB.services;

import com.gwazasoftwares.ADTB.dbs.HealthFacilityRepository;
import com.gwazasoftwares.ADTB.interfaces.OnDataPosted;
import com.gwazasoftwares.ADTB.models.HealthFacility;
import com.gwazasoftwares.ADTB.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Service
public class GenericPostService {

    private String KMHFL_BASE_URL ="http://api.kmhfltest.health.go.ke";
    private String FACILITIES_URL = KMHFL_BASE_URL + "/api/facilities/facilities/";
    private String AUTH_URL = KMHFL_BASE_URL + "/api/rest-auth/login/";
    private String DHIS2_SIMULATOR = "http://localhost:9000/facilities";

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private HealthFacilityRepository healthFacilityRepository;


    public String authenticate(@RequestBody User user) {

        return "key";
    }

    public HealthFacility postHealthFacility(HealthFacility healthFacility){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<HealthFacility> request = new HttpEntity<>(headers);
        HealthFacility respone =restTemplate.postForObject(FACILITIES_URL, request , HealthFacility.class );

       return  respone;
    }

    public String  postResponseToDhis2(HealthFacility response) {
        return  "success";
    }

    public HealthFacility postHealthFacilityToLocalDB(HealthFacility healthFacility) {
        healthFacilityRepository.save(healthFacility);
        return healthFacilityRepository.findById(healthFacility.getName()).get();
    }

    public String transferDataToDhis2(HealthFacility healthFacility) {

        /**
         *
         * Setting up data to be sent to REST service
         *
         */
        Map<String, String> vars = new HashMap<>();
        vars.put("id", "JS01");
        /**
         *
         * Doing the REST call and then displaying the data/user object
         *
         */
        try
        {
            /*
                This is code to post and return a user object
             */
            RestTemplate rt = new RestTemplate();
//            rt.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
//            rt.getMessageConverters().add(new StringHttpMessageConverter());
            String uri = new String(DHIS2_SIMULATOR);
            //HealthFacility healthFacility = new HealthFacility();

            HealthFacility returns = rt.postForObject(uri, healthFacility, HealthFacility.class, vars);
            //LOGGER.debug("User:  " + u.toString());
        }
        catch (HttpClientErrorException e) {
            System.out.println("HTTP ERROR" + e.getResponseBodyAsString());

        }
        catch(Exception e)
        {
            System.out.println("ERROR " + e.getMessage());
        }


//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity<HealthFacility> request = new HttpEntity<>(headers);
//        HealthFacility respone =restTemplate.postForObject(DHIS2_SIMULATOR, request , HealthFacility.class );

        return  "Data replicated to dhis2 server";
    }
}
