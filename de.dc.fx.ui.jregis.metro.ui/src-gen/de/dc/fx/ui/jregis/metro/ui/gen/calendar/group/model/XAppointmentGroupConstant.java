package de.dc.fx.ui.jregis.metro.ui.gen.calendar.group.model;

public class XAppointmentGroupConstant {
  public static final String SQL_FIND_ALL = "SELECT * FROM X_APPOINTMENT_GROUP ORDER BY ID DESC";
  
  public static final String SQL_FIND_BY_ID = "SELECT * FROM X_APPOINTMENT_GROUP WHERE ID = %s";
  public static final String SQL_INSERT = "INSERT INTO X_APPOINTMENT_GROUP (APPOINTMENT_ID, TOPIC, SUMMARY, START, END, APPOINTMENT_GROUP_ID) VALUES (?, ?, ?, ?, ?, ?)";
  
  public static final String SQL_MERGE = "MERGE INTO X_APPOINTMENT_GROUP KEY (ID) VALUES (?, ?, ?, ?, ?, ?, ?)";
  
  public static final String SQL_DELETE_BY_ID = "DELETE X_APPOINTMENT_GROUP WHERE ID = ?";
  public static final String SQL_CREATE = "CREATE TABLE IF NOT EXISTS X_APPOINTMENT_GROUP(ID BIGINT AUTO_INCREMENT, APPOINTMENT_ID VARCHAR, TOPIC VARCHAR, SUMMARY VARCHAR, START TIMESTAMP, END TIMESTAMP, APPOINTMENT_GROUP_ID BIGINT);";
}
