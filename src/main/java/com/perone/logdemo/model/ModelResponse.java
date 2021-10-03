package com.perone.logdemo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perone.logdemo.log.annotation.SensitiveLog;
import lombok.Getter;

@Getter
public class ModelResponse {

  @JsonProperty("id")
  private Integer id;
  @JsonProperty("name")
  private String name;
  @SensitiveLog
  @JsonProperty("phone")
  private String phone;
  @SensitiveLog
  @JsonProperty("password")
  private String password;
  @JsonProperty("subclass")
  private ModelSubclass subclass;
}