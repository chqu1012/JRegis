package de.dc.fx.ui.jregis.metro.ui.gen.contacts.phone.model;

public class PhonenumberConstant {
  public static final String SQL_FIND_ALL = "SELECT * FROM PHONENUMBER ORDER BY ID DESC";
  
  public static final String SQL_FIND_BY_ID = "SELECT * FROM PHONENUMBER WHERE ID = %s";
  public static final String SQL_INSERT = "INSERT INTO PHONENUMBER (CONTACT_ID, NAME, NUMBER, NUMBER_TYPE, STATUS, CREATED_ON, UPDATED_ON) VALUES (?, ?, ?, ?, ?, ?, ?)";
  
  public static final String SQL_MERGE = "MERGE INTO PHONENUMBER KEY (ID) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
  
  public static final String SQL_DELETE_BY_ID = "DELETE PHONENUMBER WHERE ID = ?";
  public static final String SQL_CREATE = "CREATE TABLE IF NOT EXISTS PHONENUMBER(ID BIGINT AUTO_INCREMENT, CONTACT_ID VARCHAR, NAME VARCHAR, NUMBER VARCHAR, NUMBER_TYPE VARCHAR, STATUS BIGINT, CREATED_ON TIMESTAMP, UPDATED_ON TIMESTAMP);";
}
