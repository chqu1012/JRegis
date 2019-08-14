package de.dc.fx.ui.jregis.metro.ui.gen.calendar.appointment.model;

public class XAppointmentConstant {
  public static final String SQL_FIND_ALL = "SELECT * FROM X_APPOINTMENT ORDER BY ID DESC";
  
  public static final String SQL_FIND_BY_ID = "SELECT * FROM X_APPOINTMENT WHERE ID = %s";
  public static final String SQL_INSERT = "INSERT INTO X_APPOINTMENT (CONTACT_ID, TOPIC, SUMMARY, START, END, APPOINTMENT_GROUP_ID) VALUES (?, ?, ?, ?, ?, ?)";
  
  public static final String SQL_MERGE = "MERGE INTO X_APPOINTMENT KEY (ID) VALUES (?, ?, ?, ?, ?, ?, ?)";
  
  public static final String SQL_DELETE_BY_ID = "DELETE X_APPOINTMENT WHERE ID = ?";
  public static final String SQL_CREATE = "CREATE TABLE IF NOT EXISTS X_APPOINTMENT(ID BIGINT AUTO_INCREMENT, X__APPOINTMENT VARCHAR, X__APPOINTMENT VARCHAR, X__APPOINTMENT VARCHAR, X__APPOINTMENT TIMESTAMP, X__APPOINTMENT TIMESTAMP, X__APPOINTMENT VARCHAR);";
}
