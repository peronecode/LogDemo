package com.perone.logdemo.log;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;

@Slf4j
public class PepeLog {

  public static void info(ResponseEntity<?> response) {
    String logMessage = "\n### Received response \nstatus=\"{}\"\nheaders={}\nbody=\n{}\n";
    log.info(logMessage, response.getStatusCode(), response.getHeaders(), response.getBody());
  }
}