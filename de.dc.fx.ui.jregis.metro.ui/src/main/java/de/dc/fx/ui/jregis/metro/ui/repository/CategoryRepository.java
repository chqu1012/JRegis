package de.dc.fx.ui.jregis.metro.ui.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import de.dc.fx.ui.jregis.metro.ui.model.Category;

public class CategoryRepository extends BaseRepository<Category> {

	@Override
	protected Category map(ResultSet resultSet) throws SQLException {
		Category category = new Category();
		category.setId(resultSet.getInt("ID"));
		category.setName(resultSet.getString("NAME"));
		category.setParentId(resultSet.getInt("PARENT_ID"));
		return category;
	}

	@Override
	protected String findByIdStatement(long id) {
		return "SELECT * FROM document_category WHERE id=" + id;
	}

	@Override
	protected String findAllStatement() {
		return "SELECT * FROM document_category ORDER BY name ASC";
	}

	@Override
	protected String saveStatement() {
		return "INSERT INTO document_category (name, parent_id, created_on, updated_on) VALUES (?,?,?,?);";
	}

	@Override
	protected void prepareStatetmentForSave(Category c, PreparedStatement statement) throws SQLException {
		statement.setString(1, c.getName());
		statement.setLong(2, c.getParentId());
		statement.setTimestamp(3, Timestamp.valueOf(c.getCreatedOn()));
		statement.setTimestamp(4, Timestamp.valueOf(c.getUpdatedOn()));
	}

	@Override
	protected String updateStatement() {
		return "MERGE INTO document_category KEY (ID) VALUES (?, ?, ?, ?, ?);";
	}

	@Override
	protected void prepareStatetmentForUpdate(Category c, PreparedStatement statement) throws SQLException {
		statement.setLong(1, c.getId());
		statement.setString(2, c.getName());
		statement.setLong(3, c.getParentId());
		statement.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
		statement.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));
	}
}
