package de.dc.fx.ui.jregis.metro.ui.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import de.dc.fx.ui.jregis.metro.ui.model.IdElement;

public abstract class IdRepository<T extends IdElement> extends BaseRepository<T>{

	public abstract T map(long id, String name, LocalDateTime createdOn, LocalDateTime updatedOn);
	
	public abstract String table();
	
	@Override
	protected T map(ResultSet resultSet) throws SQLException {
		long id = resultSet.getLong("ID");
		String name = resultSet.getString("NAME");
		LocalDateTime createdOn = resultSet.getTimestamp("CREATED_ON").toLocalDateTime();
		LocalDateTime updatedOn = resultSet.getTimestamp("UPDATED_ON").toLocalDateTime();
		return map(id, name, createdOn, updatedOn);
	}

	@Override
	protected String findByIdStatement(long id) {
		return "SELECT * FROM "+table()+" WHERE id="+id;
	}

	@Override
	protected String findAllStatement() {
		return "SELECT * FROM "+table();
	}

	@Override
	protected String saveStatement() {
		return "INSERT INTO "+table()+" (name, created_on, updated_on, status_id) VALUES (?,?,?,?);";
	}

	@Override
	protected void prepareStatetmentForSave(T t, PreparedStatement statement) throws SQLException {
		statement.setString(1, t.getName());
		statement.setTimestamp(2, Timestamp.valueOf(t.getCreatedOn()));
		statement.setTimestamp(3, Timestamp.valueOf(t.getUpdatedOn()));
		statement.setLong(4, t.getStatus());
	}
	
	@Override
	protected String updateStatement() {
		return "MERGE INTO document_history KEY (ID) VALUES (?, ?, ?, ?, ?);";
	}

	@Override
	protected void prepareStatetmentForUpdate(T t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getId());
		statement.setString(2, t.getName());
		statement.setTimestamp(3, Timestamp.valueOf(t.getCreatedOn()));
		statement.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
		statement.setLong(5, t.getStatus());
	}

	@Override
	protected String deleteStatement() {
		return "DELETE "+table()+" WHERE id = ?";
	}

	@Override
	protected void prepapreStatementForDelete(T t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getId());
	}
}
