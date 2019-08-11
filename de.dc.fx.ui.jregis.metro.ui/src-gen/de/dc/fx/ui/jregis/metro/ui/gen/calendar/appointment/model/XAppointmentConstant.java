package de.dc.fx.ui.jregis.metro.ui.gen.calendar.appointment.model;

public class XAppointmentConstant {
  public static final String SQL_FIND_ALL = "SELECT * FROM XAppointment ORDER BY ID DESC";
  
  public static final String SQL_FIND_BY_ID = "SELECT * FROM XAppointment WHERE ID = %s";
  public static final String SQL_INSERT = "INSERT INTO XAppointment (CONTACT_ID, TOPIC, SUMMARY, START, END, APPOINTMENT_GROUP_ID) VALUES (?, ?, ?, ?, ?, ?)";
  
  public static final String SQL_MERGE = "MERGE INTO XAppointment KEY (ID) VALUES (?, ?, ?, ?, ?, ?, ?)";
  
  public static final String SQL_DELETE_BY_ID = "DELETE XAppointment WHERE ID = ?";
  public static final String SQL_CREATE = "CREATE TABLE IF NOT EXISTS XAppointment(ID BIGINT AUTO_INCREMENT, CONTACT_ID VARCHAR, TOPIC VARCHAR, SUMMARY VARCHAR, START TIMESTAMP, END TIMESTAMP, APPOINTMENT_GROUP_ID VARCHAR);";
}
