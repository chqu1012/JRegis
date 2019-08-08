package de.dc.fx.ui.jregis.metro.ui.gen.contacts.contact.model;

public class ContactConstant {
  public static final String SQL_FIND_ALL = "SELECT * FROM Contact ORDER BY ID DESC";
  
  public static final String SQL_FIND_BY_ID = "SELECT * FROM Contact WHERE ID = %s";
  public static final String SQL_INSERT = "INSERT INTO Contact (FIRSTNAME, LASTNAME, USERNAME, CONTACT_IMAGE_ID) VALUES (?, ?, ?, ?)";
  
  public static final String SQL_MERGE = "MERGE INTO Contact KEY (ID) VALUES (?, ?, ?, ?)";
  
  public static final String SQL_DELETE_BY_ID = "DELETE Contact WHERE ID = ?";
  public static final String SQL_CREATE = "CREATE TABLE IF NOT EXISTS Contact(ID BIGINT AUTO_INCREMENT, FIRSTNAME VARCHAR, LASTNAME VARCHAR, USERNAME VARCHAR, CONTACT_IMAGE_ID VARCHAR);";
}
