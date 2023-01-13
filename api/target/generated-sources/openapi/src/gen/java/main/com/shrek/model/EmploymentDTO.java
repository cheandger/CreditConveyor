package com.shrek.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.math.BigDecimal;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * EmploymentDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-01-12T23:37:51.668990300+03:00[Europe/Moscow]")
public class EmploymentDTO {

  /**
   * Gets or Sets employmentStatus
   */
  public enum EmploymentStatusEnum {
    UNEMPLOYED("UNEMPLOYED"),
    
    SELF_EMPLOYED("SELF_EMPLOYED"),
    
    EMPLOYED("EMPLOYED"),
    
    BUSSINESS_OWNER("BUSSINESS_OWNER");

    private String value;

    EmploymentStatusEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static EmploymentStatusEnum fromValue(String value) {
      for (EmploymentStatusEnum b : EmploymentStatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("employmentStatus")
  private EmploymentStatusEnum employmentStatus;

  @JsonProperty("employerINN")
  private String employerINN;

  @JsonProperty("salary")
  private BigDecimal salary;

  /**
   * Gets or Sets position
   */
  public enum PositionEnum {
    WORKER("WORKER"),
    
    MID_MANAGER("MID_MANAGER"),
    
    TOP_MANAGER("TOP_MANAGER"),
    
    OWNER("OWNER");

    private String value;

    PositionEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static PositionEnum fromValue(String value) {
      for (PositionEnum b : PositionEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("position")
  private PositionEnum position;

  @JsonProperty("workExperienceTotal")
  private Integer workExperienceTotal;

  @JsonProperty("workExperienceCurrent")
  private Integer workExperienceCurrent;

  public EmploymentDTO employmentStatus(EmploymentStatusEnum employmentStatus) {
    this.employmentStatus = employmentStatus;
    return this;
  }

  /**
   * Get employmentStatus
   * @return employmentStatus
  */
  
  @Schema(name = "employmentStatus", required = false)
  public EmploymentStatusEnum getEmploymentStatus() {
    return employmentStatus;
  }

  public void setEmploymentStatus(EmploymentStatusEnum employmentStatus) {
    this.employmentStatus = employmentStatus;
  }

  public EmploymentDTO employerINN(String employerINN) {
    this.employerINN = employerINN;
    return this;
  }

  /**
   * Get employerINN
   * @return employerINN
  */
  @Pattern(regexp = "\\d{10}") 
  @Schema(name = "employerINN", required = false)
  public String getEmployerINN() {
    return employerINN;
  }

  public void setEmployerINN(String employerINN) {
    this.employerINN = employerINN;
  }

  public EmploymentDTO salary(BigDecimal salary) {
    this.salary = salary;
    return this;
  }

  /**
   * Get salary
   * @return salary
  */
  @Valid 
  @Schema(name = "salary", required = false)
  public BigDecimal getSalary() {
    return salary;
  }

  public void setSalary(BigDecimal salary) {
    this.salary = salary;
  }

  public EmploymentDTO position(PositionEnum position) {
    this.position = position;
    return this;
  }

  /**
   * Get position
   * @return position
  */
  
  @Schema(name = "position", required = false)
  public PositionEnum getPosition() {
    return position;
  }

  public void setPosition(PositionEnum position) {
    this.position = position;
  }

  public EmploymentDTO workExperienceTotal(Integer workExperienceTotal) {
    this.workExperienceTotal = workExperienceTotal;
    return this;
  }

  /**
   * Get workExperienceTotal
   * @return workExperienceTotal
  */
  
  @Schema(name = "workExperienceTotal", required = false)
  public Integer getWorkExperienceTotal() {
    return workExperienceTotal;
  }

  public void setWorkExperienceTotal(Integer workExperienceTotal) {
    this.workExperienceTotal = workExperienceTotal;
  }

  public EmploymentDTO workExperienceCurrent(Integer workExperienceCurrent) {
    this.workExperienceCurrent = workExperienceCurrent;
    return this;
  }

  /**
   * Get workExperienceCurrent
   * @return workExperienceCurrent
  */
  
  @Schema(name = "workExperienceCurrent", required = false)
  public Integer getWorkExperienceCurrent() {
    return workExperienceCurrent;
  }

  public void setWorkExperienceCurrent(Integer workExperienceCurrent) {
    this.workExperienceCurrent = workExperienceCurrent;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EmploymentDTO employmentDTO = (EmploymentDTO) o;
    return Objects.equals(this.employmentStatus, employmentDTO.employmentStatus) &&
        Objects.equals(this.employerINN, employmentDTO.employerINN) &&
        Objects.equals(this.salary, employmentDTO.salary) &&
        Objects.equals(this.position, employmentDTO.position) &&
        Objects.equals(this.workExperienceTotal, employmentDTO.workExperienceTotal) &&
        Objects.equals(this.workExperienceCurrent, employmentDTO.workExperienceCurrent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(employmentStatus, employerINN, salary, position, workExperienceTotal, workExperienceCurrent);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EmploymentDTO {\n");
    sb.append("    employmentStatus: ").append(toIndentedString(employmentStatus)).append("\n");
    sb.append("    employerINN: ").append(toIndentedString(employerINN)).append("\n");
    sb.append("    salary: ").append(toIndentedString(salary)).append("\n");
    sb.append("    position: ").append(toIndentedString(position)).append("\n");
    sb.append("    workExperienceTotal: ").append(toIndentedString(workExperienceTotal)).append("\n");
    sb.append("    workExperienceCurrent: ").append(toIndentedString(workExperienceCurrent)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

