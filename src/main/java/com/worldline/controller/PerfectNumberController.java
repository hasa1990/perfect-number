package com.worldline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.worldline.service.PerfectNumberService;

/**
 *
 * @author hasangi.kollure
 *
 */
@RestController
public class PerfectNumberController {

  @Autowired
  private PerfectNumberService service;

  @GetMapping(value = "/", produces = "application/json")
  public String hello() {
    return "Greetings from Spring Boot!";
  }

  /**
   * Validate if the given number is a perfect number
   *
   * @param number
   * @return true if the number is perfect. False otherwise
   */
  @GetMapping(value = "/perfect-number/{number}", produces = "application/json")
  public boolean validatePerfectNumber(@PathVariable("number")
  int number) {
    return service.isValidPerfectNumber(number);
  }

  /**
   * Provides a list of perfect numbers within start (inclusive) and end (exclusive) range
   *
   * @param start
   *          start value (inclusive)
   * @param end
   *          end value (exclusive)
   * @return List of perfect numbers
   */
  @GetMapping(value = "/perfect-numbers", produces = "application/json")
  public List<Integer> getPerfectNumbersWithinRange(@RequestParam("start")
  int start, @RequestParam("end")
  int end) {
    return service.getPerfectNumbersWithinRange(start, end);
  }

}
