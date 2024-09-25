package com.edu.unicauca.orii.core.mobility.infrastructure.adapters.exception.common;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Domain to manage field errors.
 *
 * @author JulianRuano
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiErrorDto implements Serializable {
  private String field;
  private String message;
}
