package com.worldline.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author hasangi.kollure
 *
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PerfectNumberControllerTest {

  @Autowired
  private TestRestTemplate template;

  @Test
  void getHello() throws Exception {
    ResponseEntity<String> response = template.getForEntity("/", String.class);
    assertThat(response.getBody()).isEqualTo("Greetings from Spring Boot!");
  }

  @Test
  void testPerfectNumberValidation() {
    assertThat(getValidationResponse(0)).isFalse();
    assertThat(getValidationResponse(1)).isFalse();
    assertThat(getValidationResponse(2)).isFalse();
    assertThat(getValidationResponse(5)).isFalse();
    assertThat(getValidationResponse(6)).isTrue();
    assertThat(getValidationResponse(28)).isTrue();
    assertThat(getValidationResponse(200)).isFalse();
    assertThat(getValidationResponse(495)).isFalse();
    assertThat(getValidationResponse(496)).isTrue();
    assertThat(getValidationResponse(1000)).isFalse();
    assertThat(getValidationResponse(8128)).isTrue();
  }

  @Test
  void testPerfectNumbersWithinRange() {
    assertThat(getRangeResponse(0, 10)).hasSize(1).containsExactly(6);
    assertThat(getRangeResponse(0, 100)).hasSize(2).containsExactly(6, 28);
    assertThat(getRangeResponse(0, 1000)).hasSize(3).containsExactly(6, 28, 496);
    assertThat(getRangeResponse(0, 10000)).hasSize(4).containsExactly(6, 28, 496, 8128);
  }

  private boolean getValidationResponse(int number) {
    ResponseEntity<Boolean> response = template.getForEntity("/perfect-number/" + number,
        Boolean.class);
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    return response.getBody();
  }

  private List<Integer> getRangeResponse(int start, int end) {
    ResponseEntity<List<Integer>> response = template.exchange(
        "/perfect-numbers?start=" + start + "&end=" + end, HttpMethod.GET, null,
        new ParameterizedTypeReference<List<Integer>>() {
        });
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    return response.getBody();
  }

}
