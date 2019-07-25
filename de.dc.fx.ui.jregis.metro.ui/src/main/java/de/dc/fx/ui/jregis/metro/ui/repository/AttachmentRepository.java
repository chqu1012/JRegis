package de.dc.fx.ui.jregis.metro.ui.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.dc.fx.ui.jregis.metro.ui.model.Attachment;

public class AttachmentRepository extends BaseRepository<Attachment>{

	@Override
	protected Attachment map(ResultSet resultSet) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String findByIdStatement(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String findAllStatement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String saveStatement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String deleteStatement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String updateStatement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void prepareStatetmentForSave(Attachment t, PreparedStatement statement) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void prepareStatetmentForUpdate(Attachment t, PreparedStatement statement) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void prepapreStatementForDelete(Attachment t, PreparedStatement statement) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
