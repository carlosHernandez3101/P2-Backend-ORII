package com.edu.unicauca.orii.core.mobility.infrastructure.adapters.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BusinessRuleException extends BaseException {

  public BusinessRuleException(int status, String message) {
    super(status, message);
  }
}
