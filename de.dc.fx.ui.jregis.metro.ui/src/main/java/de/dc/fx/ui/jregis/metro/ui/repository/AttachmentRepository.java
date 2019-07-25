package de.dc.fx.ui.jregis.metro.ui.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import de.dc.fx.ui.jregis.metro.ui.model.Attachment;

public class AttachmentRepository extends BaseRepository<Attachment>{

	@Override
	protected Attachment map(ResultSet resultSet) throws SQLException {
		String name = resultSet.getString("NAME");
		LocalDateTime createdOn = resultSet.getTimestamp("CREATED_ON").toLocalDateTime();
		LocalDateTime updatedOn = resultSet.getTimestamp("UPDATED_ON").toLocalDateTime();
		long documentId = resultSet.getLong("DOCUMENT_ID");
		
		return new Attachment(name, createdOn, updatedOn, documentId );
	}

	@Override
	protected String findByIdStatement(long id) {
		return "SELECT * FROM document_files WHERE id = "+id;
	}

	@Override
	protected String findAllStatement() {
		return "SELECT * FROM document_files ORDER BY name ASC";
	}

	@Override
	protected String saveStatement() {
		return "INSERT INTO document_files (name, document_id, created_on, updated_on) VALUES (?,?,?,?);";
	}

	@Override
	protected String deleteStatement() {
		return "DELETE FROM document_files WHERE id = ?";
	}

	@Override
	protected String updateStatement() {
		return "MERGE INTO document_files KEY (ID) VALUES (?, ?, ?, ?);";
	}

	@Override
	protected void prepareStatetmentForSave(Attachment c, PreparedStatement statement) throws SQLException {
		statement.setString(1, c.getName());
		statement.setLong(2, c.getDocumentId());
		statement.setTimestamp(3, Timestamp.valueOf(c.getCreatedOn()));
		statement.setTimestamp(4, Timestamp.valueOf(c.getUpdatedOn()));		
	}

	@Override
	protected void prepareStatetmentForUpdate(Attachment t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getId());		
	}

	@Override
	protected void prepapreStatementForDelete(Attachment t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getId());		
	}

}
