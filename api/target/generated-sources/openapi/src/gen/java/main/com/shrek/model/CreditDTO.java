package com.shrek.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.shrek.model.PaymentScheduleElement;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * CreditDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-01-12T14:01:51.506279800+03:00[Europe/Moscow]")
public class CreditDTO {

  @JsonProperty("amount")
  private BigDecimal amount;

  @JsonProperty("term")
  private Integer term;

  @JsonProperty("monthlyPayment")
  private BigDecimal monthlyPayment;

  @JsonProperty("rate")
  private BigDecimal rate;

  @JsonProperty("psk")
  private BigDecimal psk;

  @JsonProperty("isInsuranceEnabled")
  private Boolean isInsuranceEnabled;

  @JsonProperty("isSalaryClient")
  private Boolean isSalaryClient;

  @JsonProperty("paymentSchedule")
  @Valid
  private List<PaymentScheduleElement> paymentSchedule = null;

  public CreditDTO amount(BigDecimal amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Get amount
   * minimum: 10000
   * @return amount
  */
  @Valid @DecimalMin("10000") 
  @Schema(name = "amount", required = false)
  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public CreditDTO term(Integer term) {
    this.term = term;
    return this;
  }

  /**
   * Get term
   * minimum: 6
   * @return term
  */
  @Min(6) 
  @Schema(name = "term", required = false)
  public Integer getTerm() {
    return term;
  }

  public void setTerm(Integer term) {
    this.term = term;
  }

  public CreditDTO monthlyPayment(BigDecimal monthlyPayment) {
    this.monthlyPayment = monthlyPayment;
    return this;
  }

  /**
   * Get monthlyPayment
   * @return monthlyPayment
  */
  @Valid 
  @Schema(name = "monthlyPayment", required = false)
  public BigDecimal getMonthlyPayment() {
    return monthlyPayment;
  }

  public void setMonthlyPayment(BigDecimal monthlyPayment) {
    this.monthlyPayment = monthlyPayment;
  }

  public CreditDTO rate(BigDecimal rate) {
    this.rate = rate;
    return this;
  }

  /**
   * Get rate
   * @return rate
  */
  @Valid 
  @Schema(name = "rate", required = false)
  public BigDecimal getRate() {
    return rate;
  }

  public void setRate(BigDecimal rate) {
    this.rate = rate;
  }

  public CreditDTO psk(BigDecimal psk) {
    this.psk = psk;
    return this;
  }

  /**
   * Get psk
   * @return psk
  */
  @Valid 
  @Schema(name = "psk", required = false)
  public BigDecimal getPsk() {
    return psk;
  }

  public void setPsk(BigDecimal psk) {
    this.psk = psk;
  }

  public CreditDTO isInsuranceEnabled(Boolean isInsuranceEnabled) {
    this.isInsuranceEnabled = isInsuranceEnabled;
    return this;
  }

  /**
   * Get isInsuranceEnabled
   * @return isInsuranceEnabled
  */
  
  @Schema(name = "isInsuranceEnabled", required = false)
  public Boolean getIsInsuranceEnabled() {
    return isInsuranceEnabled;
  }

  public void setIsInsuranceEnabled(Boolean isInsuranceEnabled) {
    this.isInsuranceEnabled = isInsuranceEnabled;
  }

  public CreditDTO isSalaryClient(Boolean isSalaryClient) {
    this.isSalaryClient = isSalaryClient;
    return this;
  }

  /**
   * Get isSalaryClient
   * @return isSalaryClient
  */
  
  @Schema(name = "isSalaryClient", required = false)
  public Boolean getIsSalaryClient() {
    return isSalaryClient;
  }

  public void setIsSalaryClient(Boolean isSalaryClient) {
    this.isSalaryClient = isSalaryClient;
  }

  public CreditDTO paymentSchedule(List<PaymentScheduleElement> paymentSchedule) {
    this.paymentSchedule = paymentSchedule;
    return this;
  }

  public CreditDTO addPaymentScheduleItem(PaymentScheduleElement paymentScheduleItem) {
    if (this.paymentSchedule == null) {
      this.paymentSchedule = new ArrayList<>();
    }
    this.paymentSchedule.add(paymentScheduleItem);
    return this;
  }

  /**
   * Get paymentSchedule
   * @return paymentSchedule
  */
  @Valid 
  @Schema(name = "paymentSchedule", required = false)
  public List<PaymentScheduleElement> getPaymentSchedule() {
    return paymentSchedule;
  }

  public void setPaymentSchedule(List<PaymentScheduleElement> paymentSchedule) {
    this.paymentSchedule = paymentSchedule;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreditDTO creditDTO = (CreditDTO) o;
    return Objects.equals(this.amount, creditDTO.amount) &&
        Objects.equals(this.term, creditDTO.term) &&
        Objects.equals(this.monthlyPayment, creditDTO.monthlyPayment) &&
        Objects.equals(this.rate, creditDTO.rate) &&
        Objects.equals(this.psk, creditDTO.psk) &&
        Objects.equals(this.isInsuranceEnabled, creditDTO.isInsuranceEnabled) &&
        Objects.equals(this.isSalaryClient, creditDTO.isSalaryClient) &&
        Objects.equals(this.paymentSchedule, creditDTO.paymentSchedule);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, term, monthlyPayment, rate, psk, isInsuranceEnabled, isSalaryClient, paymentSchedule);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreditDTO {\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    term: ").append(toIndentedString(term)).append("\n");
    sb.append("    monthlyPayment: ").append(toIndentedString(monthlyPayment)).append("\n");
    sb.append("    rate: ").append(toIndentedString(rate)).append("\n");
    sb.append("    psk: ").append(toIndentedString(psk)).append("\n");
    sb.append("    isInsuranceEnabled: ").append(toIndentedString(isInsuranceEnabled)).append("\n");
    sb.append("    isSalaryClient: ").append(toIndentedString(isSalaryClient)).append("\n");
    sb.append("    paymentSchedule: ").append(toIndentedString(paymentSchedule)).append("\n");
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

