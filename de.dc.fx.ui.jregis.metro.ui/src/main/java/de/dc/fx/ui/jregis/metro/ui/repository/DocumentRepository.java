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
		document.setCategoryId(resultSet.getInt("CATEGORY_ID"));
		document.setId(resultSet.getInt("DOCUMENTATION_ID"));
		document.setTimestamp(Timestamp.valueOf(resultSet.getNString("timestamp")));
		return document;
	}

	@Override
	protected String findAllStatement() {
		return "SELECT * FROM document ORDER BY documentation_id DESC";
	}
	
	@Override
	protected String findByIdStatement(int id) {
		return "SELECT * FROM document WHERE documentation_id = "+id;
	}

	@Override
	protected String saveStatement() {
		return "INSERT INTO document (category_id, description, name, timestamp, url) VALUES (?,?,?);";
	}

	@Override
	protected void prepareStatetmentForSave(Document t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getCategoryId());
		statement.setString(2, "");
		statement.setString(3, t.getName());
		statement.setTimestamp(4, t.getTimestamp());
		statement.setString(5, "");
	}
}
