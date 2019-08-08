package de.dc.fx.ui.jregis.metro.ui.gen.contacts.email.repository;

import java.sql.*;
import java.time.LocalDateTime;

import de.dc.fx.ui.jregis.metro.ui.gen.contacts.email.model.*;
public class EmailRepository extends BaseRepository<Email>{

	@Override
	protected Email map(ResultSet resultSet) throws SQLException{
		Email email = new Email();
		email.setContactId(resultSet.getLong("ContactId"));
		email.setName(resultSet.getString("Name"));
		email.setEmail(resultSet.getString("Email"));
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
		return "INSERT INTO email (ContactId, Name, Email) VALUES (?, ?, ?);";
	}

	@Override
	protected void prepareStatetmentForSave(Email t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getContactId());
		statement.setString(2, t.getName());
		statement.setString(3, t.getEmail());
	}

	@Override
	protected String updateStatement() {
		return "MERGE INTO email KEY (ID) VALUES ( ?, ?);";
	}

	@Override
	protected void prepareStatetmentForUpdate(Email t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getContactId());
		statement.setString(2, t.getName());
		statement.setString(3, t.getEmail());
	}

	@Override
	protected String deleteStatement() {
		return "DELETE email WHERE id = ?";
	}
	
	@Override
	protected void prepapreStatementForDelete(Email t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getId());
	}
}
