package com.worldline.service;

import java.util.List;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

/**
 *
 * @author hasangi.kollure
 *
 */
@Service
public class PerfectNumberService {

  /**
   * Validate if the given number is a perfect number
   *
   * @param number
   * @return true if the number is perfect. False otherwise
   */
  public boolean isValidPerfectNumber(int number) {
    if (number == 0) {
      return false;
    }

    int sum = 0;
    for (int a = 1; a <= number / 2; a++) {
      if (number % a == 0) {
        sum += a;
      }
    }
    return sum == number;
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
  public List<Integer> getPerfectNumbersWithinRange(int start, int end) {
    return IntStream.range(start, end).boxed().filter(this::isValidPerfectNumber).toList();
  }

}
