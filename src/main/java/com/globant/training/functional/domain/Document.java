/**
 * Object that represents a document in Colomnbia
 *
 * For the case of document with no expiration date, its value will be null;
 */
package com.globant.training.functional.domain;
import java.time.LocalDate;

public class Document {
  private final DocumentType type;
  private final String number;
  private final LocalDate issueDate;
  private final LocalDate expirationDate;

  public Document(DocumentType type, String number, LocalDate issueDate, LocalDate expirationDate) {
    this.type = type;
    this.number = number;
    this.issueDate = issueDate;
    this.expirationDate = expirationDate;
  }
  public DocumentType getType() {
    return type;
  }
  public String getNumber() {
    return number;
  }
  public LocalDate getIssueDate() {
    return issueDate;
  }
  public LocalDate getExpirationDate() {
    return expirationDate;
  }
}
