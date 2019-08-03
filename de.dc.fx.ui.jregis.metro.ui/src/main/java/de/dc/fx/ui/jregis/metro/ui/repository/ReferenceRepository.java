package de.dc.fx.ui.jregis.metro.ui.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

import de.dc.fx.ui.jregis.metro.ui.model.Category;
import de.dc.fx.ui.jregis.metro.ui.model.Reference;

public class ReferenceRepository extends BaseRepository<Reference> {

	@Override
	protected Reference map(ResultSet resultSet) throws SQLException {
		LocalDateTime createdOn = resultSet.getTimestamp("CREATED_ON").toLocalDateTime();
		LocalDateTime updatedOn = resultSet.getTimestamp("UPDATED_ON").toLocalDateTime();
		long id = resultSet.getLong("ID");
		long firstId = resultSet.getLong("FIRST_ID");
		long secondId = resultSet.getLong("SECOND_ID");
		long referenceTypeId = resultSet.getLong("REFERENCE_TYPE_ID");

		Reference reference = new Reference(createdOn, updatedOn, referenceTypeId, firstId, secondId);
		reference.setId(id);
		return reference;
	}

	@Override
	public Optional<Reference> findById(long id) {
		if (!cachedList.isEmpty()) {
			return cachedList.stream().filter(e->e.getId()==id).findFirst();
		}
		return super.findById(id);
	}
	
	@Override
	protected String findByIdStatement(long id) {
		return "SELECT * FROM reference WHERE id=" + id;
	}

	@Override
	protected String findAllStatement() {
		return "SELECT * FROM reference ORDER BY id ASC";
	}

	@Override
	protected String saveStatement() {
		return "INSERT INTO reference (reference_type_id, first_id, second_id, created_on, updated_on) VALUES (?,?,?,?,?);";
	}

	@Override
	protected void prepareStatetmentForSave(Reference c, PreparedStatement statement) throws SQLException {
		statement.setLong(1, c.getReferenceTypeId());
		statement.setLong(2, c.getFirstId());
		statement.setLong(3, c.getSecondId());
		statement.setTimestamp(4, Timestamp.valueOf(c.getCreatedOn()));
		statement.setTimestamp(5, Timestamp.valueOf(c.getUpdatedOn()));
	}

	@Override
	protected String updateStatement() {
		return "MERGE INTO reference KEY (ID) VALUES (?, ?, ?, ?, ?,?);";
	}

	@Override
	protected void prepareStatetmentForUpdate(Reference c, PreparedStatement statement) throws SQLException {
		statement.setLong(1, c.getId());
		statement.setLong(2, c.getReferenceTypeId());
		statement.setLong(3, c.getFirstId());
		statement.setLong(4, c.getSecondId());
		statement.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));
		statement.setTimestamp(6, Timestamp.valueOf(LocalDateTime.now()));
	}

	@Override
	protected String deleteStatement() {
		return "DELETE FROM reference WHERE id = ?";
	}

	@Override
	protected void prepapreStatementForDelete(Reference t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getId());
	}
}