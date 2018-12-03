package com.docker.ddev.controller;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {
    static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping(value = "/factorial/{number}", method = RequestMethod.GET)
    public ResponseEntity<String> getFactorial(@PathVariable("number") long number) {
        logger.debug("Entering getFactorial with number {}", number);

        logger.info("Calculating factorial for number {}", number);

        if (number < 0) {
            String msg = "Cannot calculate factorial for negative numbers";
            logger.error(msg);
            return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
        }

        if (number > 20) {
            String msg = "Cannot calculate factorial for numbers > 20";
            logger.error(msg);
            return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
        }

        Long fac = calcFactorial(number);
        return new ResponseEntity<String>(Long.toString(fac), HttpStatus.OK);
    }

    private Long calcFactorial(long number) {
        if (number == 1)
            return number;
        return number * calcFactorial(number - 1);
    }
}