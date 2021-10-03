package com.perone.logdemo.log;

import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.NopAnnotationIntrospector;
import com.perone.logdemo.log.annotation.SensitiveLog;

public class SensitiveLogIntrospector extends NopAnnotationIntrospector {

  @Override
  public Object findSerializer(Annotated am) {
    if (am.getAnnotation(SensitiveLog.class) != null) {
      return new SensitiveLogSerializer();
    }

    return null;
  }
}