package com.perone.logdemo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.perone.logdemo.model.annotation.Sensitive;
import lombok.Getter;

@Getter
public class ModelResponse extends ModelBase {

  @JsonSerialize
  @JsonProperty("id")
  private Integer id;
  @JsonProperty("name")
  private String name;
  @Sensitive
  @JsonProperty("phone")
  private String phone;
  @Sensitive
  @JsonProperty("password")
  private String password;
  @JsonProperty("subclass")
  private ModelSubclass subclass;
}