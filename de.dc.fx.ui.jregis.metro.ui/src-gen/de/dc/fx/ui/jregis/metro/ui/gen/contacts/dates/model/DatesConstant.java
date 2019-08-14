package de.dc.fx.ui.jregis.metro.ui.gen.contacts.dates.model;

public class DatesConstant {
  public static final String SQL_FIND_ALL = "SELECT * FROM DATES ORDER BY ID DESC";
  
  public static final String SQL_FIND_BY_ID = "SELECT * FROM DATES WHERE ID = %s";
  public static final String SQL_INSERT = "INSERT INTO DATES (CONTACT_ID, NAME, DATE, STATUS, CREATED_ON, UPDATED_ON) VALUES (?, ?, ?, ?, ?, ?)";
  
  public static final String SQL_MERGE = "MERGE INTO DATES KEY (ID) VALUES (?, ?, ?, ?, ?, ?, ?)";
  
  public static final String SQL_DELETE_BY_ID = "DELETE DATES WHERE ID = ?";
  public static final String SQL_CREATE = "CREATE TABLE IF NOT EXISTS DATES(ID BIGINT AUTO_INCREMENT, CONTACT_ID VARCHAR, NAME VARCHAR, DATE TIMESTAMP, STATUS BIGINT, CREATED_ON TIMESTAMP, UPDATED_ON TIMESTAMP);";
}
