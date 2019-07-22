package de.dc.fx.ui.jregis.metro.ui.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import de.dc.fx.ui.jregis.metro.ui.model.Document;

public class DocumentRepository extends BaseRepository<Document>{

	@Override
	protected Document map(ResultSet resultSet) throws SQLException{
		Document document = new Document();
		document.setName(resultSet.getString("NAME"));
		document.setDescription(resultSet.getString("DESCRIPTION"));
		document.setCategoryId(resultSet.getInt("CATEGORY_ID"));
		document.setId(resultSet.getInt("ID"));
		document.setCreatedOn(Timestamp.valueOf(resultSet.getNString("CREATED_ON")));
		document.setUpdatedOn(Timestamp.valueOf(resultSet.getNString("UPDATED_ON")));
		return document;
	}

	@Override
	protected String findAllStatement() {
		return "SELECT * FROM document ORDER BY id DESC";
	}
	
	@Override
	protected String findByIdStatement(int id) {
		return "SELECT * FROM document WHERE id = "+id;
	}

	@Override
	protected String saveStatement() {
		return "INSERT INTO document (category_id, description, name, created_on, updated_on, url) VALUES (?,?,?,?,?,?);";
	}

	@Override
	protected void prepareStatetmentForSave(Document t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getCategoryId());
		statement.setString(2, t.getDescription());
		statement.setString(3, t.getName());
		statement.setTimestamp(4, t.getCreatedOn());
		statement.setTimestamp(5, t.getUpdatedOn());
		statement.setString(6, "");
	}
}
