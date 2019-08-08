package de.dc.fx.ui.jregis.metro.ui.gen.contacts.email.model;

public class EmailConstant {
  public static final String SQL_FIND_ALL = "SELECT * FROM Email ORDER BY id DESC";
  
  public static final String SQL_FIND_BY_ID = "SELECT * FROM Email WHERE id = %s";
  public static final String SQL_INSERT = "INSERT INTO Email (contactId, name, email) VALUES (?, ?, ?)";
  
  public static final String SQL_MERGE = "MERGE INTO Email KEY (ID) VALUES (?, ?, ?)";
  
  public static final String SQL_DELETE_BY_ID = "DELETE Email WHERE id = ?";
  public static final String SQL_CREATE = "CREATE TABLE IF NOT EXISTS Email(ID BIGINT AUTO_INCREMENT, ContactId Long, Name String, Email String);";
}
