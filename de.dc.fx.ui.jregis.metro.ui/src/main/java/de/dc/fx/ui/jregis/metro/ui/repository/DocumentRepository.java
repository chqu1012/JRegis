package de.dc.fx.ui.jregis.metro.ui.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import de.dc.fx.ui.jregis.metro.ui.model.Document;

public class DocumentRepository extends BaseRepository<Document>{

	@Override
	protected Document map(ResultSet resultSet) throws SQLException{
		String name = resultSet.getString("NAME");
		String description = resultSet.getString("DESCRIPTION");
		String url = resultSet.getString("URL");
		int categoryId = resultSet.getInt("CATEGORY_ID");
		int id = resultSet.getInt("ID");
		int status = resultSet.getInt("STATUS_ID");
		LocalDateTime createdOn = resultSet.getTimestamp("CREATED_ON").toLocalDateTime();
		LocalDateTime updatedOn = resultSet.getTimestamp("UPDATED_ON").toLocalDateTime();
		
		Document document = new Document(id, name, createdOn, updatedOn, categoryId, description, url);
		document.setStatus(status);
		return document;
	}

	@Override
	protected String findAllStatement() {
		return "SELECT * FROM document ORDER BY id DESC";
	}
	
	@Override
	protected String findByIdStatement(long id) {
		return "SELECT * FROM document WHERE id = "+id;
	}

	@Override
	protected String saveStatement() {
		return "INSERT INTO document (category_id, description, name, created_on, updated_on, url, status_id) VALUES (?,?,?,?,?,?,?);";
	}

	@Override
	protected void prepareStatetmentForSave(Document t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getCategoryId());
		statement.setString(2, t.getDescription());
		statement.setString(3, t.getName());
		statement.setTimestamp(4, Timestamp.valueOf(t.getCreatedOn()));
		statement.setTimestamp(5, Timestamp.valueOf(t.getUpdatedOn()));
		statement.setString(6, "");
		statement.setLong(7, t.getStatus());
	}

	@Override
	protected String updateStatement() {
		return "MERGE INTO document KEY (ID) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
	}

	@Override
	protected void prepareStatetmentForUpdate(Document t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getId());
		statement.setString(2, t.getDescription());
		statement.setString(3, t.getName());
		statement.setTimestamp(4, Timestamp.valueOf(t.getCreatedOn()));
		statement.setTimestamp(5, Timestamp.valueOf(t.getUpdatedOn()));
		statement.setString(6, "");
		statement.setLong(7, t.getCategoryId());
		statement.setLong(8, t.getStatus());
	}

	@Override
	protected String deleteStatement() {
		return "UPDATE document SET status_id=? WHERE id = ?";
	}
	
	@Override
	protected void prepapreStatementForDelete(Document t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getStatus());
		statement.setLong(2, t.getId());
	}
}
