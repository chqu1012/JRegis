package de.dc.fx.ui.jregis.metro.ui.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DocumentNameRepository extends BaseRepository<String>{

	@Override
	protected String map(ResultSet resultSet) throws SQLException {
		return resultSet.getString("NAME");
	}

	@Override
	protected String findByIdStatement(long id) {
		return "SELECT * FROM document_name_suggestion WHERE id="+id;
	}

	@Override
	protected String findAllStatement() {
		return "SELECT * FROM document_name_suggestion ORDER BY name";
	}

	@Override
	protected String saveStatement() {
		return "INSERT INTO document_name_suggestion(name) VALUES(?)";
	}

	@Override
	protected void prepareStatetmentForSave(String t, PreparedStatement statement) throws SQLException {
		statement.setString(1, t);
	}

	@Override
	protected String updateStatement() {
		return "MERGE INTO document_name_suggestion KEY (ID) VALUES (?)";
	}

	@Override
	protected void prepareStatetmentForUpdate(String t, PreparedStatement statement) throws SQLException {
		statement.setString(1, t);
	}

}
