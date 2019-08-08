package de.dc.fx.ui.jregis.metro.ui.gen.contacts.dates.repository;

import java.sql.*;
import java.time.LocalDateTime;

import de.dc.fx.ui.jregis.metro.ui.gen.contacts.dates.model.*;
public class DatesRepository extends BaseRepository<Dates>{

	@Override
	protected Dates map(ResultSet resultSet) throws SQLException{
		Dates dates = new Dates();
		dates.setContactId(resultSet.getLong("ContactId"));
		dates.setName(resultSet.getString("Name"));
		dates.setDate(resultSet.getTimestamp("Date").toLocalDateTime());
		return dates;
	}

	@Override
	protected String findAllStatement() {
		return DatesConstant.SQL_FIND_ALL;
	}
	
	@Override
	protected String findByIdStatement(long id) {
		return String.format(DatesConstant.SQL_FIND_BY_ID, id);
	}

	@Override
	protected String saveStatement() {
		return "INSERT INTO dates (ContactId, Name, Date) VALUES (?, ?, ?);";
	}

	@Override
	protected void prepareStatetmentForSave(Dates t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getContactId());
		statement.setString(2, t.getName());
		statement.setTimestamp(3, Timestamp.valueOf(t.getDate()));
	}

	@Override
	protected String updateStatement() {
		return "MERGE INTO dates KEY (ID) VALUES ( ?, ?);";
	}

	@Override
	protected void prepareStatetmentForUpdate(Dates t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getContactId());
		statement.setString(2, t.getName());
		statement.setTimestamp(3, Timestamp.valueOf(t.getDate()));
	}

	@Override
	protected String deleteStatement() {
		return "DELETE dates WHERE id = ?";
	}
	
	@Override
	protected void prepapreStatementForDelete(Dates t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getId());
	}
}
