package com.perone.logdemo.log;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;

public class PepeLog {

  private final Logger log;
  private final ObjectMapper objectMapper;

  public PepeLog(Class<?> clazz) {
    this.log = LoggerFactory.getLogger(clazz);
    this.objectMapper = new ObjectMapper().setAnnotationIntrospector(new SensitiveLogIntrospector());
  }

  public static PepeLog getLogger(Class<?> clazz) {
    return new PepeLog(clazz);
  }

  public void info(ResponseEntity<?> response) {
    String logMessage = "\n### Received response \nstatus=\"{}\"\nheaders={}\nbody=\n{}\n";
    String body;
    try {
      body = objectMapper.writeValueAsString(response.getBody());
    } catch (JsonProcessingException e) {
      body = e.getMessage();
    }

    log.info(logMessage, response.getStatusCode(), response.getHeaders(), body);
  }

  public void info(Object value) {
    String logMessage = "\n### Loggin value: \n{}\n";
    String body;
    try {
      body = objectMapper.writeValueAsString(value);
    } catch (JsonProcessingException e) {
      body = e.getMessage();
    }

    log.info(logMessage, body);
  }

  public void error(ResponseEntity<?> response) {
    String logMessage = "\n### Received response \nstatus=\"{}\"\nheaders={}\nbody=\n{}\n";
    log.error(logMessage, response.getStatusCode(), response.getHeaders(), response.getBody());
  }
}