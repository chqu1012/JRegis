package de.dc.fx.ui.jregis.metro.ui.gen.contacts.phone.repository;

import java.sql.*;
import java.time.LocalDateTime;

import de.dc.fx.ui.jregis.metro.ui.gen.contacts.phone.model.*;
public class PhonenumberRepository extends BaseRepository<Phonenumber>{

	@Override
	protected Phonenumber map(ResultSet resultSet) throws SQLException{
		Phonenumber phonenumber = new Phonenumber();
		phonenumber.setContactId(resultSet.getLong("ContactId"));
		phonenumber.setName(resultSet.getString("Name"));
		phonenumber.setNumber(resultSet.getString("Number"));
		phonenumber.setNumberType(resultSet.getString("NumberType"));
		return phonenumber;
	}

	@Override
	protected String findAllStatement() {
		return PhonenumberConstant.SQL_FIND_ALL;
	}
	
	@Override
	protected String findByIdStatement(long id) {
		return String.format(PhonenumberConstant.SQL_FIND_BY_ID, id);
	}

	@Override
	protected String saveStatement() {
		return "INSERT INTO phonenumber (ContactId, Name, Number, NumberType) VALUES (?, ?, ?, ?);";
	}

	@Override
	protected void prepareStatetmentForSave(Phonenumber t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getContactId());
		statement.setString(2, t.getName());
		statement.setString(3, t.getNumber());
		statement.setString(4, t.getNumberType());
	}

	@Override
	protected String updateStatement() {
		return "MERGE INTO phonenumber KEY (ID) VALUES ( ?, ?, ?);";
	}

	@Override
	protected void prepareStatetmentForUpdate(Phonenumber t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getContactId());
		statement.setString(2, t.getName());
		statement.setString(3, t.getNumber());
		statement.setString(4, t.getNumberType());
	}

	@Override
	protected String deleteStatement() {
		return "DELETE phonenumber WHERE id = ?";
	}
	
	@Override
	protected void prepapreStatementForDelete(Phonenumber t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getId());
	}
}
