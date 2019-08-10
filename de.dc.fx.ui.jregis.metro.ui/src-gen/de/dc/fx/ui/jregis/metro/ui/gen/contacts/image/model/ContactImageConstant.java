package de.dc.fx.ui.jregis.metro.ui.gen.contacts.image.model;

public class ContactImageConstant {
  public static final String SQL_FIND_ALL = "SELECT * FROM ContactImage ORDER BY ID DESC";
  
  public static final String SQL_FIND_BY_ID = "SELECT * FROM ContactImage WHERE ID = %s";
  public static final String SQL_INSERT = "INSERT INTO ContactImage (NAME, CREATED_ON) VALUES (?, ?)";
  
  public static final String SQL_MERGE = "MERGE INTO ContactImage KEY (ID) VALUES (?, ?, ?)";
  
  public static final String SQL_DELETE_BY_ID = "DELETE ContactImage WHERE ID = ?";
  public static final String SQL_CREATE = "CREATE TABLE IF NOT EXISTS ContactImage(ID BIGINT AUTO_INCREMENT, NAME VARCHAR, CREATED_ON TIMESTAMP);";
}
