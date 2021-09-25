package com.perone.logdemo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perone.logdemo.model.annotation.Sensitive;
import lombok.Getter;

@Getter
public class ModelSubclass extends ModelBase {

  @JsonProperty("city")
  private String city;
  @Sensitive
  @JsonProperty("zipCode")
  private String zipCode;
}