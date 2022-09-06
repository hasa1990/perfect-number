package com.worldline.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author hasangi.kollure
 *
 */
@SpringBootTest
public class PerfectNumberServiceTest {

  @Autowired
  private PerfectNumberService service;

  @Test
  void testPerfectNumberValidation() {
    assertThat(service.isValidPerfectNumber(0)).isFalse();
    assertThat(service.isValidPerfectNumber(1)).isFalse();
    assertThat(service.isValidPerfectNumber(2)).isFalse();
    assertThat(service.isValidPerfectNumber(5)).isFalse();
    assertThat(service.isValidPerfectNumber(6)).isTrue();
    assertThat(service.isValidPerfectNumber(28)).isTrue();
    assertThat(service.isValidPerfectNumber(200)).isFalse();
    assertThat(service.isValidPerfectNumber(495)).isFalse();
    assertThat(service.isValidPerfectNumber(496)).isTrue();
    assertThat(service.isValidPerfectNumber(1000)).isFalse();
    assertThat(service.isValidPerfectNumber(8128)).isTrue();
  }

  @Test
  void testPerfectNumbersWithinRange() {
    assertThat(service.getPerfectNumbersWithinRange(0, 10)).hasSize(1).containsExactly(6);
    assertThat(service.getPerfectNumbersWithinRange(0, 100)).hasSize(2).containsExactly(6, 28);
    assertThat(service.getPerfectNumbersWithinRange(0, 1000)).hasSize(3).containsExactly(6, 28, 496);
    assertThat(service.getPerfectNumbersWithinRange(0, 10000)).hasSize(4).containsExactly(6, 28, 496, 8128);
  }

}
