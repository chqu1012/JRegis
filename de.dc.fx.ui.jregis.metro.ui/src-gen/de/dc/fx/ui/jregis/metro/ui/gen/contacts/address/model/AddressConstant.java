package de.dc.fx.ui.jregis.metro.ui.gen.contacts.address.model;

public class AddressConstant {
  public static final String SQL_FIND_ALL = "SELECT * FROM Address ORDER BY ID DESC";
  
  public static final String SQL_FIND_BY_ID = "SELECT * FROM Address WHERE ID = %s";
  public static final String SQL_INSERT = "INSERT INTO Address (CONTACT_ID, ADDRESS_TYPE, STREET, COUNTRY, STATE, ZIP_CODE) VALUES (?, ?, ?, ?, ?, ?)";
  
  public static final String SQL_MERGE = "MERGE INTO Address KEY (ID) VALUES (?, ?, ?, ?, ?, ?, ?)";
  
  public static final String SQL_DELETE_BY_ID = "DELETE Address WHERE ID = ?";
  public static final String SQL_CREATE = "CREATE TABLE IF NOT EXISTS Address(ID BIGINT AUTO_INCREMENT, CONTACT_ID VARCHAR, ADDRESS_TYPE VARCHAR, STREET VARCHAR, COUNTRY VARCHAR, STATE VARCHAR, ZIP_CODE BIGINT);";
}
