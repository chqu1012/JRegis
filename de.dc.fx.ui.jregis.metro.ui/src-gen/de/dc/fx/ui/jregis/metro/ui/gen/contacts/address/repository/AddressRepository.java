package de.dc.fx.ui.jregis.metro.ui.gen.contacts.address.repository;

import java.sql.*;
import java.time.LocalDateTime;

import de.dc.fx.ui.jregis.metro.ui.gen.contacts.address.model.*;
public class AddressRepository extends BaseRepository<Address>{

	@Override
	protected Address map(ResultSet resultSet) throws SQLException{
		Address address = new Address();
		address.setContactId(resultSet.getLong("ContactId"));
		address.setStreet(resultSet.getString("Street"));
		address.setCountry(resultSet.getString("Country"));
		address.setState(resultSet.getString("State"));
		address.setZipCode(resultSet.getInt("ZipCode"));
		return address;
	}

	@Override
	protected String findAllStatement() {
		return AddressConstant.SQL_FIND_ALL;
	}
	
	@Override
	protected String findByIdStatement(long id) {
		return String.format(AddressConstant.SQL_FIND_BY_ID, id);
	}

	@Override
	protected String saveStatement() {
		return "INSERT INTO address (ContactId, Street, Country, State, ZipCode) VALUES (?, ?, ?, ?, ?);";
	}

	@Override
	protected void prepareStatetmentForSave(Address t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getContactId());
		statement.setString(2, t.getStreet());
		statement.setString(3, t.getCountry());
		statement.setString(4, t.getState());
		statement.setInt(5, t.getZipCode());
	}

	@Override
	protected String updateStatement() {
		return "MERGE INTO address KEY (ID) VALUES ( ?, ?, ?, ?);";
	}

	@Override
	protected void prepareStatetmentForUpdate(Address t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getContactId());
		statement.setString(2, t.getStreet());
		statement.setString(3, t.getCountry());
		statement.setString(4, t.getState());
		statement.setInt(5, t.getZipCode());
	}

	@Override
	protected String deleteStatement() {
		return "DELETE address WHERE id = ?";
	}
	
	@Override
	protected void prepapreStatementForDelete(Address t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getId());
	}
}
