package de.dc.fx.ui.jregis.metro.ui.gen.contacts.address.model;

public class AddressConstant {
  public static final String SQL_FIND_ALL = "SELECT * FROM Address ORDER BY id DESC";
  
  public static final String SQL_FIND_BY_ID = "SELECT * FROM Address WHERE id = %s";
  public static final String SQL_INSERT = "INSERT INTO Address (contactId, street, country, state, zipCode) VALUES (?, ?, ?, ?, ?)";
  
  public static final String SQL_MERGE = "MERGE INTO Address KEY (ID) VALUES (?, ?, ?, ?, ?)";
  
  public static final String SQL_DELETE_BY_ID = "DELETE Address WHERE id = ?";
  public static final String SQL_CREATE = "CREATE TABLE IF NOT EXISTS Address(ID BIGINT AUTO_INCREMENT, ContactId Long, Street String, Country String, State String, ZipCode Integer);";
}
