package de.dc.fx.ui.jregis.metro.ui.gen.contacts.email.repository;

import java.sql.*;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.email.model.*;
public class EmailRepository extends BaseRepository<Email>{

	@Override
	protected Email map(ResultSet resultSet) throws SQLException{
		Email email = new Email();
		email.setId(resultSet.getLong("ID"));
		email.setContactId(resultSet.getLong("CONTACT_ID"));
		email.setName(resultSet.getString("NAME"));
		email.setAddress(resultSet.getString("ADDRESS"));
		return email;
	}

	@Override
	protected String findAllStatement() {
		return EmailConstant.SQL_FIND_ALL;
	}
	
	@Override
	protected String findByIdStatement(long id) {
		return String.format(EmailConstant.SQL_FIND_BY_ID, id);
	}

	@Override
	protected String saveStatement() {
		return EmailConstant.SQL_INSERT;
	}

	@Override
	protected void prepareStatetmentForSave(Email t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getContactId());
		statement.setString(2, t.getName());
		statement.setString(3, t.getAddress());
	}

	@Override
	protected String updateStatement() {
		return EmailConstant.SQL_MERGE;
	}

	@Override
	protected void prepareStatetmentForUpdate(Email t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getId());
		statement.setLong(2, t.getContactId());
		statement.setString(3, t.getName());
		statement.setString(4, t.getAddress());
	}

	@Override
	protected String deleteStatement() {
		return EmailConstant.SQL_DELETE_BY_ID;
	}
	
	@Override
	protected void prepapreStatementForDelete(Email t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getId());
	}
}
