package de.dc.fx.ui.jregis.metro.ui.gen.contacts.email.model;

public class EmailConstant {
  public static final String SQL_FIND_ALL = "SELECT * FROM Email ORDER BY ID DESC";
  
  public static final String SQL_FIND_BY_ID = "SELECT * FROM Email WHERE ID = %s";
  public static final String SQL_INSERT = "INSERT INTO Email (CONTACT_ID, NAME, ADDRESS) VALUES (?, ?, ?)";
  
  public static final String SQL_MERGE = "MERGE INTO Email KEY (ID) VALUES (?, ?, ?, ?)";
  
  public static final String SQL_DELETE_BY_ID = "DELETE Email WHERE ID = ?";
  public static final String SQL_CREATE = "CREATE TABLE IF NOT EXISTS Email(ID BIGINT AUTO_INCREMENT, CONTACT_ID VARCHAR, NAME VARCHAR, ADDRESS VARCHAR);";
}
