package de.dc.fx.ui.jregis.metro.ui.gen.contacts.dates.repository;

import java.sql.*;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.dates.model.*;
public class DatesRepository extends BaseRepository<Dates>{

	@Override
	protected Dates map(ResultSet resultSet) throws SQLException{
		Dates dates = new Dates();
		dates.setId(resultSet.getLong("ID"));
		dates.setContactId(resultSet.getLong("CONTACT_ID"));
		dates.setName(resultSet.getString("NAME"));
		dates.setDate(resultSet.getTimestamp("DATE").toLocalDateTime());
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
		return DatesConstant.SQL_INSERT;
	}

	@Override
	protected void prepareStatetmentForSave(Dates t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getContactId());
		statement.setString(2, t.getName());
		statement.setTimestamp(3, Timestamp.valueOf(t.getDate()));
	}

	@Override
	protected String updateStatement() {
		return DatesConstant.SQL_MERGE;
	}

	@Override
	protected void prepareStatetmentForUpdate(Dates t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getId());
		statement.setLong(2, t.getContactId());
		statement.setString(3, t.getName());
		statement.setTimestamp(4, Timestamp.valueOf(t.getDate()));
	}

	@Override
	protected String deleteStatement() {
		return DatesConstant.SQL_DELETE_BY_ID;
	}
	
	@Override
	protected void prepapreStatementForDelete(Dates t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getId());
	}
}
