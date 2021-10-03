package com.perone.logdemo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perone.logdemo.log.annotation.SensitiveLog;
import lombok.Getter;

@Getter
public class ModelSubclass {

  @JsonProperty("city")
  private String city;
  @SensitiveLog
  @JsonProperty("zipCode")
  private String zipCode;
}