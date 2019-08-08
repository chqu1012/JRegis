package de.dc.fx.ui.jregis.metro.ui.gen.contacts.phone.model;

public class PhonenumberConstant {
  public static final String SQL_FIND_ALL = "SELECT * FROM Phonenumber ORDER BY ID DESC";
  
  public static final String SQL_FIND_BY_ID = "SELECT * FROM Phonenumber WHERE ID = %s";
  public static final String SQL_INSERT = "INSERT INTO Phonenumber (CONTACT_ID, NAME, NUMBER, NUMBER_TYPE) VALUES (?, ?, ?, ?)";
  
  public static final String SQL_MERGE = "MERGE INTO Phonenumber KEY (ID) VALUES (?, ?, ?, ?)";
  
  public static final String SQL_DELETE_BY_ID = "DELETE Phonenumber WHERE ID = ?";
  public static final String SQL_CREATE = "CREATE TABLE IF NOT EXISTS Phonenumber(ID BIGINT AUTO_INCREMENT, CONTACT_ID VARCHAR, NAME VARCHAR, NUMBER VARCHAR, NUMBER_TYPE VARCHAR);";
}
