package com.perone.logdemo.controller;

import com.perone.logdemo.model.ModelResponse;
import java.util.Objects;
import lombok.CustomLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@Controller
@CustomLog
public class LogController {

  @Autowired
  private RestTemplate restTemplate;

  @GetMapping("/execute")
  public ResponseEntity<ModelResponse> execute() {
    String url = "https://run.mocky.io/v3/3ed37421-e6b2-459b-8852-bafa7a0e4832";
    ResponseEntity<ModelResponse> response = restTemplate.getForEntity(url, ModelResponse.class);
    log.info(response);

    if (response.getStatusCode().equals(HttpStatus.OK)) {
      if (Objects.nonNull(response.getBody())) {
        log.info(response.getBody());

        return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
      } else {
        throw new InternalError("Could perform the request. No request body was found.");
      }
    } else {
      throw new HttpServerErrorException(response.getStatusCode());
    }
  }
}