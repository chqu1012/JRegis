package de.dc.fx.ui.jregis.metro.ui.gen.contacts.contact.model;

public class ContactConstant {
  public static final String SQL_FIND_ALL = "SELECT * FROM Contact ORDER BY id DESC";
  
  public static final String SQL_FIND_BY_ID = "SELECT * FROM Contact WHERE id = %s";
  public static final String SQL_INSERT = "INSERT INTO Contact (firstname, lastname, username, contactImageId) VALUES (?, ?, ?, ?)";
  
  public static final String SQL_MERGE = "MERGE INTO Contact KEY (ID) VALUES (?, ?, ?, ?)";
  
  public static final String SQL_DELETE_BY_ID = "DELETE Contact WHERE id = ?";
  public static final String SQL_CREATE = "CREATE TABLE IF NOT EXISTS Contact(ID BIGINT AUTO_INCREMENT, Firstname String, Lastname String, Username String, ContactImageId Long);";
}
