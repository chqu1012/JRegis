package de.dc.fx.ui.jregis.metro.ui.gen.contacts.address.model;

public class AddressConstant {
  public static final String SQL_FIND_ALL = "SELECT * FROM ADDRESS ORDER BY ID DESC";
  
  public static final String SQL_FIND_BY_ID = "SELECT * FROM ADDRESS WHERE ID = %s";
  public static final String SQL_INSERT = "INSERT INTO ADDRESS (CONTACT_ID, ADDRESS_TYPE, STREET, COUNTRY, STATE, ZIP_CODE, STATUS, CREATED_ON, UPDATED_ON) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
  
  public static final String SQL_MERGE = "MERGE INTO ADDRESS KEY (ID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
  
  public static final String SQL_DELETE_BY_ID = "DELETE ADDRESS WHERE ID = ?";
  public static final String SQL_CREATE = "CREATE TABLE IF NOT EXISTS ADDRESS(ID BIGINT AUTO_INCREMENT, CONTACT_ID VARCHAR, ADDRESS_TYPE VARCHAR, STREET VARCHAR, COUNTRY VARCHAR, STATE VARCHAR, ZIP_CODE BIGINT, STATUS BIGINT, CREATED_ON TIMESTAMP, UPDATED_ON TIMESTAMP);";
}
