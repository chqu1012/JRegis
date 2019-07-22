package de.dc.fx.ui.jregis.metro.ui.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.dc.fx.ui.jregis.metro.ui.model.Category;

public class CategoryRepository extends BaseRepository<Category>{

	@Override
	protected Category map(ResultSet resultSet) throws SQLException {
		Category category = new Category();
		category.setId(resultSet.getInt("DOCUMENT_CATEGORY_ID"));
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
		return "INSERT INTO document_category (name, parent_id) VALUES (?,?);";
	}

	@Override
	protected void prepareStatetmentForSave(Category c, PreparedStatement statement) throws SQLException {
		statement.setString(1, c.getName());
		statement.setLong(2, c.getParentId());
	}
}
