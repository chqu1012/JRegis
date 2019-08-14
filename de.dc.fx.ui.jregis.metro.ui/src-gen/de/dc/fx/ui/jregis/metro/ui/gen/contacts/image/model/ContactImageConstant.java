package de.dc.fx.ui.jregis.metro.ui.gen.contacts.image.model;

public class ContactImageConstant {
  public static final String SQL_FIND_ALL = "SELECT * FROM CONTACT_IMAGE ORDER BY ID DESC";
  
  public static final String SQL_FIND_BY_ID = "SELECT * FROM CONTACT_IMAGE WHERE ID = %s";
  public static final String SQL_INSERT = "INSERT INTO CONTACT_IMAGE (NAME, STATUS, CREATED_ON, UPDATED_ON) VALUES (?, ?, ?, ?)";
  
  public static final String SQL_MERGE = "MERGE INTO CONTACT_IMAGE KEY (ID) VALUES (?, ?, ?, ?, ?)";
  
  public static final String SQL_DELETE_BY_ID = "DELETE CONTACT_IMAGE WHERE ID = ?";
  public static final String SQL_CREATE = "CREATE TABLE IF NOT EXISTS CONTACT_IMAGE(ID BIGINT AUTO_INCREMENT, NAME VARCHAR, STATUS BIGINT, CREATED_ON TIMESTAMP, UPDATED_ON TIMESTAMP);";
}
