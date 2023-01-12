package com.shrek.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.shrek.model.EmploymentDTO;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * ScoringDataDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-01-12T14:01:51.506279800+03:00[Europe/Moscow]")
public class ScoringDataDTO {

  @JsonProperty("amount")
  private BigDecimal amount;

  @JsonProperty("term")
  private Integer term;

  @JsonProperty("firstName")
  private String firstName;

  @JsonProperty("lastName")
  private String lastName;

  @JsonProperty("middleName")
  private String middleName;

  /**
   * Gets or Sets gender
   */
  public enum GenderEnum {
    MALE("MALE"),
    
    FEMALE("FEMALE"),
    
    NON_BINARY("NON_BINARY");

    private String value;

    GenderEnum(String value) {
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
    public static GenderEnum fromValue(String value) {
      for (GenderEnum b : GenderEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("gender")
  private GenderEnum gender;

  @JsonProperty("birthdate")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate birthdate;

  @JsonProperty("passportSeries")
  private String passportSeries;

  @JsonProperty("passportNumber")
  private String passportNumber;

  @JsonProperty("passportIssueDate")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate passportIssueDate;

  @JsonProperty("passportIssueBranch")
  private String passportIssueBranch;

  /**
   * Gets or Sets maritalStatus
   */
  public enum MaritalStatusEnum {
    MARRIED("MARRIED"),
    
    DIVORCED("DIVORCED"),
    
    SINGLE("SINGLE"),
    
    WIDOW_WIDOWER("WIDOW_WIDOWER");

    private String value;

    MaritalStatusEnum(String value) {
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
    public static MaritalStatusEnum fromValue(String value) {
      for (MaritalStatusEnum b : MaritalStatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("maritalStatus")
  private MaritalStatusEnum maritalStatus;

  @JsonProperty("dependentAmount")
  private Integer dependentAmount;

  @JsonProperty("employment")
  @Valid
  private List<EmploymentDTO> employment = new ArrayList<>();

  @JsonProperty("account")
  private String account;

  @JsonProperty("isInsuranceEnabled")
  private Boolean isInsuranceEnabled;

  @JsonProperty("isSalaryClient")
  private Boolean isSalaryClient;

  public ScoringDataDTO amount(BigDecimal amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Get amount
   * minimum: 10000
   * @return amount
  */
  @NotNull @Valid @DecimalMin("10000") 
  @Schema(name = "amount", required = true)
  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public ScoringDataDTO term(Integer term) {
    this.term = term;
    return this;
  }

  /**
   * Get term
   * minimum: 6
   * @return term
  */
  @NotNull @Min(6) 
  @Schema(name = "term", required = true)
  public Integer getTerm() {
    return term;
  }

  public void setTerm(Integer term) {
    this.term = term;
  }

  public ScoringDataDTO firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * Get firstName
   * @return firstName
  */
  @NotNull @Pattern(regexp = "[a-zA-Zа-яА-Я]{2,30}") 
  @Schema(name = "firstName", required = true)
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public ScoringDataDTO lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Get lastName
   * @return lastName
  */
  @NotNull @Pattern(regexp = "[a-zA-Zа-яА-Я]{2,30}") 
  @Schema(name = "lastName", required = true)
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public ScoringDataDTO middleName(String middleName) {
    this.middleName = middleName;
    return this;
  }

  /**
   * Get middleName
   * @return middleName
  */
  @Pattern(regexp = "[a-zA-Zа-яА-Я]{2,30}") 
  @Schema(name = "middleName", required = false)
  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public ScoringDataDTO gender(GenderEnum gender) {
    this.gender = gender;
    return this;
  }

  /**
   * Get gender
   * @return gender
  */
  @NotNull 
  @Schema(name = "gender", required = true)
  public GenderEnum getGender() {
    return gender;
  }

  public void setGender(GenderEnum gender) {
    this.gender = gender;
  }

  public ScoringDataDTO birthdate(LocalDate birthdate) {
    this.birthdate = birthdate;
    return this;
  }

  /**
   * Get birthdate
   * @return birthdate
  */
  @NotNull @Valid @Pattern(regexp = "^((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$") 
  @Schema(name = "birthdate", required = true)
  public LocalDate getBirthdate() {
    return birthdate;
  }

  public void setBirthdate(LocalDate birthdate) {
    this.birthdate = birthdate;
  }

  public ScoringDataDTO passportSeries(String passportSeries) {
    this.passportSeries = passportSeries;
    return this;
  }

  /**
   * Get passportSeries
   * @return passportSeries
  */
  @NotNull @Pattern(regexp = "\\d{4}") 
  @Schema(name = "passportSeries", required = true)
  public String getPassportSeries() {
    return passportSeries;
  }

  public void setPassportSeries(String passportSeries) {
    this.passportSeries = passportSeries;
  }

  public ScoringDataDTO passportNumber(String passportNumber) {
    this.passportNumber = passportNumber;
    return this;
  }

  /**
   * Get passportNumber
   * @return passportNumber
  */
  @NotNull @Pattern(regexp = "\\d{6}") 
  @Schema(name = "passportNumber", required = true)
  public String getPassportNumber() {
    return passportNumber;
  }

  public void setPassportNumber(String passportNumber) {
    this.passportNumber = passportNumber;
  }

  public ScoringDataDTO passportIssueDate(LocalDate passportIssueDate) {
    this.passportIssueDate = passportIssueDate;
    return this;
  }

  /**
   * Get passportIssueDate
   * @return passportIssueDate
  */
  @NotNull @Valid @Pattern(regexp = "^((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$") 
  @Schema(name = "passportIssueDate", required = true)
  public LocalDate getPassportIssueDate() {
    return passportIssueDate;
  }

  public void setPassportIssueDate(LocalDate passportIssueDate) {
    this.passportIssueDate = passportIssueDate;
  }

  public ScoringDataDTO passportIssueBranch(String passportIssueBranch) {
    this.passportIssueBranch = passportIssueBranch;
    return this;
  }

  /**
   * Get passportIssueBranch
   * @return passportIssueBranch
  */
  @NotNull 
  @Schema(name = "passportIssueBranch", required = true)
  public String getPassportIssueBranch() {
    return passportIssueBranch;
  }

  public void setPassportIssueBranch(String passportIssueBranch) {
    this.passportIssueBranch = passportIssueBranch;
  }

  public ScoringDataDTO maritalStatus(MaritalStatusEnum maritalStatus) {
    this.maritalStatus = maritalStatus;
    return this;
  }

  /**
   * Get maritalStatus
   * @return maritalStatus
  */
  @NotNull 
  @Schema(name = "maritalStatus", required = true)
  public MaritalStatusEnum getMaritalStatus() {
    return maritalStatus;
  }

  public void setMaritalStatus(MaritalStatusEnum maritalStatus) {
    this.maritalStatus = maritalStatus;
  }

  public ScoringDataDTO dependentAmount(Integer dependentAmount) {
    this.dependentAmount = dependentAmount;
    return this;
  }

  /**
   * Get dependentAmount
   * @return dependentAmount
  */
  @NotNull 
  @Schema(name = "dependentAmount", required = true)
  public Integer getDependentAmount() {
    return dependentAmount;
  }

  public void setDependentAmount(Integer dependentAmount) {
    this.dependentAmount = dependentAmount;
  }

  public ScoringDataDTO employment(List<EmploymentDTO> employment) {
    this.employment = employment;
    return this;
  }

  public ScoringDataDTO addEmploymentItem(EmploymentDTO employmentItem) {
    this.employment.add(employmentItem);
    return this;
  }

  /**
   * Get employment
   * @return employment
  */
  @NotNull @Valid 
  @Schema(name = "employment", required = true)
  public List<EmploymentDTO> getEmployment() {
    return employment;
  }

  public void setEmployment(List<EmploymentDTO> employment) {
    this.employment = employment;
  }

  public ScoringDataDTO account(String account) {
    this.account = account;
    return this;
  }

  /**
   * Get account
   * @return account
  */
  @NotNull 
  @Schema(name = "account", required = true)
  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }

  public ScoringDataDTO isInsuranceEnabled(Boolean isInsuranceEnabled) {
    this.isInsuranceEnabled = isInsuranceEnabled;
    return this;
  }

  /**
   * Get isInsuranceEnabled
   * @return isInsuranceEnabled
  */
  @NotNull 
  @Schema(name = "isInsuranceEnabled", required = true)
  public Boolean getIsInsuranceEnabled() {
    return isInsuranceEnabled;
  }

  public void setIsInsuranceEnabled(Boolean isInsuranceEnabled) {
    this.isInsuranceEnabled = isInsuranceEnabled;
  }

  public ScoringDataDTO isSalaryClient(Boolean isSalaryClient) {
    this.isSalaryClient = isSalaryClient;
    return this;
  }

  /**
   * Get isSalaryClient
   * @return isSalaryClient
  */
  @NotNull 
  @Schema(name = "isSalaryClient", required = true)
  public Boolean getIsSalaryClient() {
    return isSalaryClient;
  }

  public void setIsSalaryClient(Boolean isSalaryClient) {
    this.isSalaryClient = isSalaryClient;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ScoringDataDTO scoringDataDTO = (ScoringDataDTO) o;
    return Objects.equals(this.amount, scoringDataDTO.amount) &&
        Objects.equals(this.term, scoringDataDTO.term) &&
        Objects.equals(this.firstName, scoringDataDTO.firstName) &&
        Objects.equals(this.lastName, scoringDataDTO.lastName) &&
        Objects.equals(this.middleName, scoringDataDTO.middleName) &&
        Objects.equals(this.gender, scoringDataDTO.gender) &&
        Objects.equals(this.birthdate, scoringDataDTO.birthdate) &&
        Objects.equals(this.passportSeries, scoringDataDTO.passportSeries) &&
        Objects.equals(this.passportNumber, scoringDataDTO.passportNumber) &&
        Objects.equals(this.passportIssueDate, scoringDataDTO.passportIssueDate) &&
        Objects.equals(this.passportIssueBranch, scoringDataDTO.passportIssueBranch) &&
        Objects.equals(this.maritalStatus, scoringDataDTO.maritalStatus) &&
        Objects.equals(this.dependentAmount, scoringDataDTO.dependentAmount) &&
        Objects.equals(this.employment, scoringDataDTO.employment) &&
        Objects.equals(this.account, scoringDataDTO.account) &&
        Objects.equals(this.isInsuranceEnabled, scoringDataDTO.isInsuranceEnabled) &&
        Objects.equals(this.isSalaryClient, scoringDataDTO.isSalaryClient);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, term, firstName, lastName, middleName, gender, birthdate, passportSeries, passportNumber, passportIssueDate, passportIssueBranch, maritalStatus, dependentAmount, employment, account, isInsuranceEnabled, isSalaryClient);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ScoringDataDTO {\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    term: ").append(toIndentedString(term)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    middleName: ").append(toIndentedString(middleName)).append("\n");
    sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
    sb.append("    birthdate: ").append(toIndentedString(birthdate)).append("\n");
    sb.append("    passportSeries: ").append(toIndentedString(passportSeries)).append("\n");
    sb.append("    passportNumber: ").append(toIndentedString(passportNumber)).append("\n");
    sb.append("    passportIssueDate: ").append(toIndentedString(passportIssueDate)).append("\n");
    sb.append("    passportIssueBranch: ").append(toIndentedString(passportIssueBranch)).append("\n");
    sb.append("    maritalStatus: ").append(toIndentedString(maritalStatus)).append("\n");
    sb.append("    dependentAmount: ").append(toIndentedString(dependentAmount)).append("\n");
    sb.append("    employment: ").append(toIndentedString(employment)).append("\n");
    sb.append("    account: ").append(toIndentedString(account)).append("\n");
    sb.append("    isInsuranceEnabled: ").append(toIndentedString(isInsuranceEnabled)).append("\n");
    sb.append("    isSalaryClient: ").append(toIndentedString(isSalaryClient)).append("\n");
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

