package de.dc.fx.ui.jregis.metro.ui.gen.calendar.group.model;

public class XAppointmentGroupConstant {
  public static final String SQL_FIND_ALL = "SELECT * FROM XAppointmentGroup ORDER BY ID DESC";
  
  public static final String SQL_FIND_BY_ID = "SELECT * FROM XAppointmentGroup WHERE ID = %s";
  public static final String SQL_INSERT = "INSERT INTO XAppointmentGroup (APPOINTMENT_ID, TOPIC, SUMMARY, START, END, APPOINTMENT_GROUP_ID) VALUES (?, ?, ?, ?, ?, ?)";
  
  public static final String SQL_MERGE = "MERGE INTO XAppointmentGroup KEY (ID) VALUES (?, ?, ?, ?, ?, ?, ?)";
  
  public static final String SQL_DELETE_BY_ID = "DELETE XAppointmentGroup WHERE ID = ?";
  public static final String SQL_CREATE = "CREATE TABLE IF NOT EXISTS XAppointmentGroup(ID BIGINT AUTO_INCREMENT, APPOINTMENT_ID VARCHAR, TOPIC VARCHAR, SUMMARY VARCHAR, START TIMESTAMP, END TIMESTAMP, APPOINTMENT_GROUP_ID BIGINT);";
}
