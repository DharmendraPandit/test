package com.example.utility;

public enum ProductMessages {
  SEARCHING_CRITERIA("search criteria category/region cannot be empty"),
  brand("brand"),
  price("price"),
  color("color"),
  size("size"),
  GROUPBY_INVALID("groupBy is invalid");

  private String message;

  ProductMessages(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
