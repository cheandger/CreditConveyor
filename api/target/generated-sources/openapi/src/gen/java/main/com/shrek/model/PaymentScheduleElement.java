package com.shrek.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * PaymentScheduleElement
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-01-12T14:01:51.506279800+03:00[Europe/Moscow]")
public class PaymentScheduleElement {

  @JsonProperty("number")
  private Integer number;

  @JsonProperty("date")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate date;

  @JsonProperty("totalPayment")
  private BigDecimal totalPayment;

  @JsonProperty("interestPayment")
  private BigDecimal interestPayment;

  @JsonProperty("debtPayment")
  private BigDecimal debtPayment;

  @JsonProperty("remainingDebt")
  private BigDecimal remainingDebt;

  public PaymentScheduleElement number(Integer number) {
    this.number = number;
    return this;
  }

  /**
   * Get number
   * @return number
  */
  
  @Schema(name = "number", required = false)
  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }

  public PaymentScheduleElement date(LocalDate date) {
    this.date = date;
    return this;
  }

  /**
   * Get date
   * @return date
  */
  @Valid @Pattern(regexp = "^((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$") 
  @Schema(name = "date", required = false)
  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public PaymentScheduleElement totalPayment(BigDecimal totalPayment) {
    this.totalPayment = totalPayment;
    return this;
  }

  /**
   * Get totalPayment
   * @return totalPayment
  */
  @Valid 
  @Schema(name = "totalPayment", required = false)
  public BigDecimal getTotalPayment() {
    return totalPayment;
  }

  public void setTotalPayment(BigDecimal totalPayment) {
    this.totalPayment = totalPayment;
  }

  public PaymentScheduleElement interestPayment(BigDecimal interestPayment) {
    this.interestPayment = interestPayment;
    return this;
  }

  /**
   * Get interestPayment
   * @return interestPayment
  */
  @Valid 
  @Schema(name = "interestPayment", required = false)
  public BigDecimal getInterestPayment() {
    return interestPayment;
  }

  public void setInterestPayment(BigDecimal interestPayment) {
    this.interestPayment = interestPayment;
  }

  public PaymentScheduleElement debtPayment(BigDecimal debtPayment) {
    this.debtPayment = debtPayment;
    return this;
  }

  /**
   * Get debtPayment
   * @return debtPayment
  */
  @Valid 
  @Schema(name = "debtPayment", required = false)
  public BigDecimal getDebtPayment() {
    return debtPayment;
  }

  public void setDebtPayment(BigDecimal debtPayment) {
    this.debtPayment = debtPayment;
  }

  public PaymentScheduleElement remainingDebt(BigDecimal remainingDebt) {
    this.remainingDebt = remainingDebt;
    return this;
  }

  /**
   * Get remainingDebt
   * @return remainingDebt
  */
  @Valid 
  @Schema(name = "remainingDebt", required = false)
  public BigDecimal getRemainingDebt() {
    return remainingDebt;
  }

  public void setRemainingDebt(BigDecimal remainingDebt) {
    this.remainingDebt = remainingDebt;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentScheduleElement paymentScheduleElement = (PaymentScheduleElement) o;
    return Objects.equals(this.number, paymentScheduleElement.number) &&
        Objects.equals(this.date, paymentScheduleElement.date) &&
        Objects.equals(this.totalPayment, paymentScheduleElement.totalPayment) &&
        Objects.equals(this.interestPayment, paymentScheduleElement.interestPayment) &&
        Objects.equals(this.debtPayment, paymentScheduleElement.debtPayment) &&
        Objects.equals(this.remainingDebt, paymentScheduleElement.remainingDebt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(number, date, totalPayment, interestPayment, debtPayment, remainingDebt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentScheduleElement {\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    totalPayment: ").append(toIndentedString(totalPayment)).append("\n");
    sb.append("    interestPayment: ").append(toIndentedString(interestPayment)).append("\n");
    sb.append("    debtPayment: ").append(toIndentedString(debtPayment)).append("\n");
    sb.append("    remainingDebt: ").append(toIndentedString(remainingDebt)).append("\n");
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

