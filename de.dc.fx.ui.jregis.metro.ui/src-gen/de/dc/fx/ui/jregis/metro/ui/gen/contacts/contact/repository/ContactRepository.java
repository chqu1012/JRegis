package de.dc.fx.ui.jregis.metro.ui.gen.contacts.contact.repository;

import java.sql.*;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.contact.model.*;
public class ContactRepository extends BaseRepository<Contact>{

	@Override
	protected Contact map(ResultSet resultSet) throws SQLException{
		Contact contact = new Contact();
		contact.setId(resultSet.getLong("ID"));
		contact.setFirstname(resultSet.getString("FIRSTNAME"));
		contact.setLastname(resultSet.getString("LASTNAME"));
		contact.setUsername(resultSet.getString("USERNAME"));
		contact.setContactImageId(resultSet.getLong("CONTACT_IMAGE_ID"));
		return contact;
	}

	@Override
	protected String findAllStatement() {
		return ContactConstant.SQL_FIND_ALL;
	}
	
	@Override
	protected String findByIdStatement(long id) {
		return String.format(ContactConstant.SQL_FIND_BY_ID, id);
	}

	@Override
	protected String saveStatement() {
		return ContactConstant.SQL_INSERT;
	}

	@Override
	protected void prepareStatetmentForSave(Contact t, PreparedStatement statement) throws SQLException {
		statement.setString(1, t.getFirstname());
		statement.setString(2, t.getLastname());
		statement.setString(3, t.getUsername());
		statement.setLong(4, t.getContactImageId());
	}

	@Override
	protected String updateStatement() {
		return ContactConstant.SQL_MERGE;
	}

	@Override
	protected void prepareStatetmentForUpdate(Contact t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getId());
		statement.setString(2, t.getFirstname());
		statement.setString(3, t.getLastname());
		statement.setString(4, t.getUsername());
		statement.setLong(5, t.getContactImageId());
	}

	@Override
	protected String deleteStatement() {
		return ContactConstant.SQL_DELETE_BY_ID;
	}
	
	@Override
	protected void prepapreStatementForDelete(Contact t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getId());
	}
}
