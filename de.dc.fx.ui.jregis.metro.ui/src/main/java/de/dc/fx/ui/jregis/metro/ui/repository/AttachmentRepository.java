package de.dc.fx.ui.jregis.metro.ui.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import de.dc.fx.ui.jregis.metro.ui.model.Attachment;
import de.dc.fx.ui.jregis.metro.ui.model.AttachmentStatus;

public class AttachmentRepository extends BaseRepository<Attachment>{

	@Override
	protected Attachment map(ResultSet resultSet) throws SQLException {
		String name = resultSet.getString("NAME");
		LocalDateTime createdOn = resultSet.getTimestamp("CREATED_ON").toLocalDateTime();
		LocalDateTime updatedOn = resultSet.getTimestamp("UPDATED_ON").toLocalDateTime();
		long historyId = resultSet.getLong("HISTORY_ID");
		long statusId = resultSet.getLong("STATUS_ID");
		long id = resultSet.getLong("ID");
		
		Attachment attachment = new Attachment(name, createdOn, updatedOn, historyId );
		attachment.setStatus(statusId);
		attachment.setId(id);
		return attachment;
	}

	@Override
	protected String findByIdStatement(long id) {
		return "SELECT * FROM document_attachment WHERE id = "+id;
	}

	@Override
	protected String findAllStatement() {
		return "SELECT * FROM document_attachment ORDER BY name ASC";
	}

	@Override
	protected String saveStatement() {
		return "INSERT INTO document_attachment (name, history_id, created_on, updated_on, status_id) VALUES (?,?,?,?,?);";
	}

	@Override
	protected String deleteStatement() {
		return "UPDATE document_attachment SET status_id=? WHERE id = ?";
	}

	@Override
	protected String updateStatement() {
		return "MERGE INTO document_attachment KEY (ID) VALUES (?, ?, ?, ?, ?, ?);";
	}

	@Override
	protected void prepareStatetmentForSave(Attachment c, PreparedStatement statement) throws SQLException {
		statement.setString(1, c.getName());
		statement.setLong(2, c.getHistoryId());
		statement.setTimestamp(3, Timestamp.valueOf(c.getCreatedOn()));
		statement.setTimestamp(4, Timestamp.valueOf(c.getUpdatedOn()));		
		statement.setLong(5, c.getStatus());		
	}

	@Override
	protected void prepareStatetmentForUpdate(Attachment c, PreparedStatement statement) throws SQLException {
		statement.setLong(1, c.getId());		
		statement.setString(2, c.getName());
		statement.setLong(3, c.getHistoryId());
		statement.setTimestamp(4, Timestamp.valueOf(c.getCreatedOn()));
		statement.setTimestamp(5, Timestamp.valueOf(c.getUpdatedOn()));		
		statement.setLong(6, c.getStatus());		
	}

	@Override
	protected void prepapreStatementForDelete(Attachment t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, AttachmentStatus.DELETE.getStatusValue());		
		statement.setLong(2, t.getId());		
	}

}
