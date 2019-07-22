package de.dc.fx.ui.jregis.metro.ui.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import de.dc.fx.ui.jregis.metro.ui.model.Category;

public class CategoryRepository extends BaseRepository<Category>{

	@Override
	protected Category map(ResultSet resultSet) throws SQLException {
		Category category = new Category();
		category.setId(resultSet.getInt("ID"));
		category.setName(resultSet.getString("NAME"));
		category.setParentId(resultSet.getInt("PARENT_ID"));
		return category;
	}

	@Override
	protected String findByIdStatement(int id) {
		return "SELECT * FROM document_category WHERE document_category_id="+id;
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
}