package de.dc.fx.ui.jregis.metro.ui.gen.contacts.address.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import de.dc.fx.ui.jregis.metro.ui.gen.contacts.address.model.Address;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.address.model.AddressConstant;
public class AddressRepository extends BaseRepository<Address>{

	@Override
	protected Address map(ResultSet resultSet) throws SQLException{
		Address address = new Address();
		address.setId(resultSet.getLong("ID"));
		address.setContactId(resultSet.getLong("CONTACT_ID"));
		address.setStreet(resultSet.getString("STREET"));
		address.setCountry(resultSet.getString("COUNTRY"));
		address.setState(resultSet.getString("STATE"));
		address.setZipCode(resultSet.getInt("ZIP_CODE"));
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

	public List<Address> findAllByContactId(Long contactId){
		return query("SELECT * FROM ADDRESS WHERE CONTACT_ID = "+contactId);
	}
	
	@Override
	protected String saveStatement() {
		return AddressConstant.SQL_INSERT;
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
		return AddressConstant.SQL_MERGE;
	}

	@Override
	protected void prepareStatetmentForUpdate(Address t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getId());
		statement.setLong(2, t.getContactId());
		statement.setString(3, t.getStreet());
		statement.setString(4, t.getCountry());
		statement.setString(5, t.getState());
		statement.setInt(6, t.getZipCode());
	}

	@Override
	protected String deleteStatement() {
		return AddressConstant.SQL_DELETE_BY_ID;
	}
	
	@Override
	protected void prepapreStatementForDelete(Address t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getId());
	}
}
