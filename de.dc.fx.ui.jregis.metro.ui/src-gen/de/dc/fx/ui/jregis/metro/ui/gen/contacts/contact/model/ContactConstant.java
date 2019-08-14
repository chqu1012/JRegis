package de.dc.fx.ui.jregis.metro.ui.gen.contacts.contact.model;

public class ContactConstant {
  public static final String SQL_FIND_ALL = "SELECT * FROM CONTACT ORDER BY ID DESC";
  
  public static final String SQL_FIND_BY_ID = "SELECT * FROM CONTACT WHERE ID = %s";
  public static final String SQL_INSERT = "INSERT INTO CONTACT (FIRSTNAME, LASTNAME, USERNAME, CONTACT_IMAGE_ID, STATUS, CREATED_ON, UPDATED_ON) VALUES (?, ?, ?, ?, ?, ?, ?)";
  
  public static final String SQL_MERGE = "MERGE INTO CONTACT KEY (ID) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
  
  public static final String SQL_DELETE_BY_ID = "DELETE CONTACT WHERE ID = ?";
  public static final String SQL_CREATE = "CREATE TABLE IF NOT EXISTS CONTACT(ID BIGINT AUTO_INCREMENT, FIRSTNAME VARCHAR, LASTNAME VARCHAR, USERNAME VARCHAR, CONTACT_IMAGE_ID VARCHAR, STATUS BIGINT, CREATED_ON TIMESTAMP, UPDATED_ON TIMESTAMP);";
}
