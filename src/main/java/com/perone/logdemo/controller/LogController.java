package com.perone.logdemo.controller;

import com.perone.logdemo.log.PepeLog;
import com.perone.logdemo.model.ModelResponse;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@Controller
public class LogController {

  @Autowired
  private RestTemplate restTemplate;

  @GetMapping("/execute")
  public ResponseEntity<ModelResponse> execute() {
    String url = "https://run.mocky.io/v3/73100d29-a969-4eaf-ba18-1e3b9d84cc72";
    ResponseEntity<ModelResponse> response = restTemplate.getForEntity(url, ModelResponse.class);

    PepeLog.info(response);

    if (response.getStatusCode().equals(HttpStatus.OK)) {
      if (Objects.nonNull(response.getBody())) {
        return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
      } else {
        throw new InternalError("Could perform the request. No request body was found.");
      }
    } else {
      throw new HttpServerErrorException(response.getStatusCode());
    }
  }
}