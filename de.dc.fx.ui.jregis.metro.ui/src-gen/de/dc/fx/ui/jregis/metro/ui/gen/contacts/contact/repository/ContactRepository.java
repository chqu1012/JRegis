package de.dc.fx.ui.jregis.metro.ui.gen.contacts.contact.repository;

import java.sql.*;
import java.time.LocalDateTime;

import de.dc.fx.ui.jregis.metro.ui.gen.contacts.contact.model.*;
public class ContactRepository extends BaseRepository<Contact>{

	@Override
	protected Contact map(ResultSet resultSet) throws SQLException{
		Contact contact = new Contact();
		contact.setFirstname(resultSet.getString("Firstname"));
		contact.setLastname(resultSet.getString("Lastname"));
		contact.setAccount(resultSet.getString("Account"));
		contact.setAvatarId(resultSet.getLong("AvatarId"));
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
		return "INSERT INTO contact (Firstname, Lastname, Account, AvatarId) VALUES (?, ?, ?, ?);";
	}

	@Override
	protected void prepareStatetmentForSave(Contact t, PreparedStatement statement) throws SQLException {
		statement.setString(1, t.getFirstname());
		statement.setString(2, t.getLastname());
		statement.setString(3, t.getAccount());
		statement.setLong(4, t.getAvatarId());
	}

	@Override
	protected String updateStatement() {
		return "MERGE INTO contact KEY (ID) VALUES ( ?, ?, ?);";
	}

	@Override
	protected void prepareStatetmentForUpdate(Contact t, PreparedStatement statement) throws SQLException {
		statement.setString(1, t.getFirstname());
		statement.setString(2, t.getLastname());
		statement.setString(3, t.getAccount());
		statement.setLong(4, t.getAvatarId());
	}

	@Override
	protected String deleteStatement() {
		return "DELETE contact WHERE id = ?";
	}
	
	@Override
	protected void prepapreStatementForDelete(Contact t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getId());
	}
}
