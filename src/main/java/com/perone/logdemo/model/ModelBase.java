package com.perone.logdemo.model;

import com.perone.logdemo.model.annotation.Sensitive;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import lombok.SneakyThrows;

public abstract class ModelBase implements Serializable {

  @SneakyThrows
  @Override
  public final String toString() {
    StringBuilder toStringSB = new StringBuilder();
    toStringSB.append(this.getClass().getName()).append("[");

    Object value;
    Field[] fields = this.getClass().getDeclaredFields();
    for (Field field : fields) {
      toStringSB.append(field.getName()).append("=");

      if (!Modifier.isPublic(field.getModifiers())) {
        field.setAccessible(true);
      }

      if (field.isAnnotationPresent(Sensitive.class)) {
        value = "***";
      } else {
        value = field.get(this);
      }

      toStringSB.append(value);
      toStringSB.append(", ");
    }

    toStringSB = new StringBuilder(toStringSB.substring(0, toStringSB.length() - 2));
    toStringSB.append("]");
    return toStringSB.toString();
  }
}