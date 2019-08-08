package de.dc.fx.ui.jregis.metro.ui.gen.contacts.dates.model;

public class DatesConstant {
  public static final String SQL_FIND_ALL = "SELECT * FROM Dates ORDER BY id DESC";
  
  public static final String SQL_FIND_BY_ID = "SELECT * FROM Dates WHERE id = %s";
  public static final String SQL_INSERT = "INSERT INTO Dates (contactId, name, date) VALUES (?, ?, ?)";
  
  public static final String SQL_MERGE = "MERGE INTO Dates KEY (ID) VALUES (?, ?, ?)";
  
  public static final String SQL_DELETE_BY_ID = "DELETE Dates WHERE id = ?";
  public static final String SQL_CREATE = "CREATE TABLE IF NOT EXISTS Dates(ID BIGINT AUTO_INCREMENT, ContactId Long, Name String, Date LocalDateTime);";
}
