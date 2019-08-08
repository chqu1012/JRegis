package de.dc.fx.ui.jregis.metro.ui.gen.contacts.dates.model;

public class DatesConstant {
  public static final String SQL_FIND_ALL = "SELECT * FROM Dates ORDER BY ID DESC";
  
  public static final String SQL_FIND_BY_ID = "SELECT * FROM Dates WHERE ID = %s";
  public static final String SQL_INSERT = "INSERT INTO Dates (CONTACT_ID, NAME, DATE) VALUES (?, ?, ?)";
  
  public static final String SQL_MERGE = "MERGE INTO Dates KEY (ID) VALUES (?, ?, ?)";
  
  public static final String SQL_DELETE_BY_ID = "DELETE Dates WHERE ID = ?";
  public static final String SQL_CREATE = "CREATE TABLE IF NOT EXISTS Dates(ID BIGINT AUTO_INCREMENT, CONTACT_ID VARCHAR, NAME VARCHAR, DATE TIMESTAMP);";
}
