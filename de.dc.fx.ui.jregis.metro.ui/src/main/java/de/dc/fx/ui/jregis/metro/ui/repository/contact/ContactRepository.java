package de.dc.fx.ui.jregis.metro.ui.repository.contact;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.dc.fx.ui.jregis.metro.ui.model.contact.Contact;
import de.dc.fx.ui.jregis.metro.ui.repository.GenericIdBaseRepository;

public class ContactRepository extends GenericIdBaseRepository<Contact>{

	@Override
	public String getJdbcUrl() {
		return "jdbc:h2:file:./data/ContactRepository;DB_CLOSE_ON_EXIT=true;";
	}

	@Override
	protected Contact map(ResultSet resultSet) throws SQLException {
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
	protected void prepareStatetmentForSave(Contact t, PreparedStatement statement) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void prepareStatetmentForUpdate(Contact t, PreparedStatement statement) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void prepapreStatementForDelete(Contact t, PreparedStatement statement) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
