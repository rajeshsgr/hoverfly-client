package com.raj.nola.hoverflyclient.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
public class StudentClientController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    Environment env;


    @GetMapping("/students-client")
    public String invoke() {

        System.out.println("inside TestController::invoke()-->"+ Arrays.toString(env.getActiveProfiles()));
        String url = "http://localhost:8080/api/students";
        String response = restTemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<String>() {
                }).getBody();

        System.out.println("Actual Response : " + response);
        return response;
    }

}
