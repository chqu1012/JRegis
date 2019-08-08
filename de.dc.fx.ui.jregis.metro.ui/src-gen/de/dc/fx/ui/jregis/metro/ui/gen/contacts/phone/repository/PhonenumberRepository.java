package de.dc.fx.ui.jregis.metro.ui.gen.contacts.phone.repository;

import java.sql.*;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.phone.model.*;
public class PhonenumberRepository extends BaseRepository<Phonenumber>{

	@Override
	protected Phonenumber map(ResultSet resultSet) throws SQLException{
		Phonenumber phonenumber = new Phonenumber();
		phonenumber.setId(resultSet.getLong("ID"));
		phonenumber.setContactId(resultSet.getLong("CONTACT_ID"));
		phonenumber.setName(resultSet.getString("NAME"));
		phonenumber.setNumber(resultSet.getString("NUMBER"));
		phonenumber.setNumberType(resultSet.getString("NUMBER_TYPE"));
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
		return PhonenumberConstant.SQL_INSERT;
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
		return PhonenumberConstant.SQL_MERGE;
	}

	@Override
	protected void prepareStatetmentForUpdate(Phonenumber t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getId());
		statement.setLong(2, t.getContactId());
		statement.setString(3, t.getName());
		statement.setString(4, t.getNumber());
		statement.setString(5, t.getNumberType());
	}

	@Override
	protected String deleteStatement() {
		return PhonenumberConstant.SQL_DELETE_BY_ID;
	}
	
	@Override
	protected void prepapreStatementForDelete(Phonenumber t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getId());
	}
}
