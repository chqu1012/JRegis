package de.dc.fx.ui.jregis.metro.ui.gen.contacts.group.model;

public class ContactGroupConstant {
  public static final String SQL_FIND_ALL = "SELECT * FROM CONTACT_GROUP ORDER BY ID DESC";
  
  public static final String SQL_FIND_BY_ID = "SELECT * FROM CONTACT_GROUP WHERE ID = %s";
  public static final String SQL_INSERT = "INSERT INTO CONTACT_GROUP (NAME, STATUS, COLOR, HOVER_COLOR, CREATED_ON, UPDATED_ON) VALUES (?, ?, ?, ?, ?, ?)";
  
  public static final String SQL_MERGE = "MERGE INTO CONTACT_GROUP KEY (ID) VALUES (?, ?, ?, ?, ?, ?, ?)";
  
  public static final String SQL_DELETE_BY_ID = "DELETE CONTACT_GROUP WHERE ID = ?";
  public static final String SQL_CREATE = "CREATE TABLE IF NOT EXISTS CONTACT_GROUP(ID BIGINT AUTO_INCREMENT, NAME VARCHAR, STATUS BIGINT, COLOR VARCHAR, HOVER_COLOR VARCHAR, CREATED_ON TIMESTAMP, UPDATED_ON TIMESTAMP);";
}
