package de.dc.fx.ui.jregis.metro.ui.gen.contacts.email.model;

public class EmailConstant {
  public static final String SQL_FIND_ALL = "SELECT * FROM EMAIL ORDER BY ID DESC";
  
  public static final String SQL_FIND_BY_ID = "SELECT * FROM EMAIL WHERE ID = %s";
  public static final String SQL_INSERT = "INSERT INTO EMAIL (CONTACT_ID, NAME, ADDRESS, STATUS, CREATED_ON, UPDATED_ON) VALUES (?, ?, ?, ?, ?, ?)";
  
  public static final String SQL_MERGE = "MERGE INTO EMAIL KEY (ID) VALUES (?, ?, ?, ?, ?, ?, ?)";
  
  public static final String SQL_DELETE_BY_ID = "DELETE EMAIL WHERE ID = ?";
  public static final String SQL_CREATE = "CREATE TABLE IF NOT EXISTS EMAIL(ID BIGINT AUTO_INCREMENT, CONTACT_ID VARCHAR, NAME VARCHAR, ADDRESS VARCHAR, STATUS BIGINT, CREATED_ON TIMESTAMP, UPDATED_ON TIMESTAMP);";
}
