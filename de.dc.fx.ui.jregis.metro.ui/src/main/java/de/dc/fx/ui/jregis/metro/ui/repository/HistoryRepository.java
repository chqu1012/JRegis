package de.dc.fx.ui.jregis.metro.ui.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import de.dc.fx.ui.jregis.metro.ui.model.History;

public class HistoryRepository extends BaseRepository<History>{

	@Override
	protected History map(ResultSet resultSet) throws SQLException {
		String name = resultSet.getString("NAME");
		String files = resultSet.getString("FILES");
		Long id= resultSet.getLong("ID");
		Long documentId= resultSet.getLong("DOCUMENT_ID");
		LocalDateTime createdOn= resultSet.getTimestamp("CREATED_ON").toLocalDateTime();
		LocalDateTime updatedOn= resultSet.getTimestamp("UPDATED_ON").toLocalDateTime();
		History history = new History(name, documentId, createdOn, updatedOn, files);
		history.setId(id);
		return history;
	}

	@Override
	protected String findByIdStatement(long id) {
		return "SELECT * FROM document_history WHERE document_history_id="+id;
	}

	@Override
	protected String findAllStatement() {
		return "SELECT * FROM document_history";
	}

	@Override
	protected String saveStatement() {
		return "INSERT INTO document_history (document_id, files, name, created_on, updated_on) VALUES (?,?,?,?,?);";
	}

	@Override
	protected void prepareStatetmentForSave(History t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getDocumentId());
		statement.setString(2, t.getFiles());
		statement.setString(3, t.getName());
		statement.setTimestamp(4, Timestamp.valueOf(t.getCreatedOn()));
		statement.setTimestamp(5, Timestamp.valueOf(t.getUpdatedOn()));
	}
	
	@Override
	protected String updateStatement() {
		return "MERGE INTO document_history KEY (ID) VALUES (?, ?, ?, ?, ?, ?);";
	}

	@Override
	protected void prepareStatetmentForUpdate(History t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getId());
		statement.setLong(2, t.getDocumentId());
		statement.setString(3, t.getFiles());
		statement.setString(4, t.getName());
		statement.setTimestamp(5, Timestamp.valueOf(t.getCreatedOn()));
		statement.setTimestamp(6, Timestamp.valueOf(LocalDateTime.now()));
	}

	@Override
	protected String deleteStatement() {
		return "DELETE FROM document_history WHERE id = ?";
	}

	@Override
	protected void prepapreStatementForDelete(History t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getId());
	}
}
