package com.crawler.controller;

import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



/**
 * Created by admin on 16/11/17.
 */
@RestController
public class HealthController {

    private static final Logger logger = Logger.getLogger(HealthController.class);


    @RequestMapping(value = "/health", method = RequestMethod.GET)
    public ResponseEntity<?> health() {
        return ResponseEntity.ok("ok");
    }



}
