package de.dc.fx.ui.jregis.metro.ui.gen.contacts.phone.model;

public class PhonenumberConstant {
  public static final String SQL_FIND_ALL = "SELECT * FROM Phonenumber ORDER BY id DESC";
  
  public static final String SQL_FIND_BY_ID = "SELECT * FROM Phonenumber WHERE id = %s";
  public static final String SQL_INSERT = "INSERT INTO Phonenumber (contactId, name, number, numberType) VALUES (?, ?, ?, ?)";
  
  public static final String SQL_MERGE = "MERGE INTO Phonenumber KEY (ID) VALUES (?, ?, ?, ?)";
  
  public static final String SQL_DELETE_BY_ID = "DELETE Phonenumber WHERE id = ?";
  public static final String SQL_CREATE = "CREATE TABLE IF NOT EXISTS Phonenumber(ID BIGINT AUTO_INCREMENT, ContactId Long, Name String, Number String, NumberType String);";
}
