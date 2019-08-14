package de.dc.fx.ui.jregis.metro.ui.gen.contacts.dates.model;

public class DatesConstant {
  public static final String SQL_FIND_ALL = "SELECT * FROM DATES ORDER BY ID DESC";
  
  public static final String SQL_FIND_BY_ID = "SELECT * FROM DATES WHERE ID = %s";
  public static final String SQL_INSERT = "INSERT INTO DATES (CONTACT_ID, NAME, DATE) VALUES (?, ?, ?)";
  
  public static final String SQL_MERGE = "MERGE INTO DATES KEY (ID) VALUES (?, ?, ?, ?)";
  
  public static final String SQL_DELETE_BY_ID = "DELETE DATES WHERE ID = ?";
  public static final String SQL_CREATE = "CREATE TABLE IF NOT EXISTS DATES(ID BIGINT AUTO_INCREMENT, DATES VARCHAR, DATES VARCHAR, DATES TIMESTAMP);";
}
