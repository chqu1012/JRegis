package de.dc.fx.ui.jregis.metro.ui.gen.contacts.contact.repository;

import java.sql.*;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.contact.model.*;
import java.util.*;
import java.time.*;

public class ContactRepository extends BaseRepository<Contact>{

	@Override
	protected Contact map(ResultSet resultSet) throws SQLException{
		Contact contact = new Contact();
		contact.setId(resultSet.getLong("ID"));
		contact.setFirstname(resultSet.getString("FIRSTNAME"));
		contact.setLastname(resultSet.getString("LASTNAME"));
		contact.setUsername(resultSet.getString("USERNAME"));
		contact.setContactImageId(resultSet.getLong("CONTACT_IMAGE_ID"));
		return contact;
	}
	
	public List<Contact> findAllByFirstname(String firstname){
		return query(String.format("SELECT * FROM CONTACT WHERE FIRSTNAME = '%s'", String.valueOf(firstname)));
	}

	public List<Contact> findAllByFirstnameOrderByAsc(String firstname){
		return query(String.format("SELECT * FROM CONTACT WHERE FIRSTNAME = '%s' ORDER BY FIRSTNAME ASC", String.valueOf(firstname)));
	}

	public List<Contact> findAllByFirstnameOrderByDesc(String firstname){
		return query(String.format("SELECT * FROM CONTACT WHERE FIRSTNAME = '%s' ORDER BY FIRSTNAME DESC", String.valueOf(firstname)));
	}

	public List<Contact> findAllByFirstnameLike(String firstname){
		return query(String.format("SELECT * FROM CONTACT WHERE FIRSTNAME like '%%s%'", String.valueOf(firstname)));
	}
	
	public List<Contact> findAllByFirstnameLikeOrderByAsc(String firstname){
		return query(String.format("SELECT * FROM CONTACT WHERE FIRSTNAME like '%%s%' ORDER BY FIRSTNAME ASC", String.valueOf(firstname)));
	}
	
	public List<Contact> findAllByFirstnameLikeOrderByDesc(String firstname){
		return query(String.format("SELECT * FROM CONTACT WHERE FIRSTNAME like '%%s%' ORDER BY FIRSTNAME DESC", String.valueOf(firstname)));
	}
	public List<Contact> findAllByLastname(String lastname){
		return query(String.format("SELECT * FROM CONTACT WHERE LASTNAME = '%s'", String.valueOf(lastname)));
	}

	public List<Contact> findAllByLastnameOrderByAsc(String lastname){
		return query(String.format("SELECT * FROM CONTACT WHERE LASTNAME = '%s' ORDER BY LASTNAME ASC", String.valueOf(lastname)));
	}

	public List<Contact> findAllByLastnameOrderByDesc(String lastname){
		return query(String.format("SELECT * FROM CONTACT WHERE LASTNAME = '%s' ORDER BY LASTNAME DESC", String.valueOf(lastname)));
	}

	public List<Contact> findAllByLastnameLike(String lastname){
		return query(String.format("SELECT * FROM CONTACT WHERE LASTNAME like '%%s%'", String.valueOf(lastname)));
	}
	
	public List<Contact> findAllByLastnameLikeOrderByAsc(String lastname){
		return query(String.format("SELECT * FROM CONTACT WHERE LASTNAME like '%%s%' ORDER BY LASTNAME ASC", String.valueOf(lastname)));
	}
	
	public List<Contact> findAllByLastnameLikeOrderByDesc(String lastname){
		return query(String.format("SELECT * FROM CONTACT WHERE LASTNAME like '%%s%' ORDER BY LASTNAME DESC", String.valueOf(lastname)));
	}
	public List<Contact> findAllByUsername(String username){
		return query(String.format("SELECT * FROM CONTACT WHERE USERNAME = '%s'", String.valueOf(username)));
	}

	public List<Contact> findAllByUsernameOrderByAsc(String username){
		return query(String.format("SELECT * FROM CONTACT WHERE USERNAME = '%s' ORDER BY USERNAME ASC", String.valueOf(username)));
	}

	public List<Contact> findAllByUsernameOrderByDesc(String username){
		return query(String.format("SELECT * FROM CONTACT WHERE USERNAME = '%s' ORDER BY USERNAME DESC", String.valueOf(username)));
	}

	public List<Contact> findAllByUsernameLike(String username){
		return query(String.format("SELECT * FROM CONTACT WHERE USERNAME like '%%s%'", String.valueOf(username)));
	}
	
	public List<Contact> findAllByUsernameLikeOrderByAsc(String username){
		return query(String.format("SELECT * FROM CONTACT WHERE USERNAME like '%%s%' ORDER BY USERNAME ASC", String.valueOf(username)));
	}
	
	public List<Contact> findAllByUsernameLikeOrderByDesc(String username){
		return query(String.format("SELECT * FROM CONTACT WHERE USERNAME like '%%s%' ORDER BY USERNAME DESC", String.valueOf(username)));
	}
	public List<Contact> findAllByContactImageId(Long contactImageId){
		return query(String.format("SELECT * FROM CONTACT WHERE CONTACT_IMAGE_ID = '%s'", String.valueOf(contactImageId)));
	}

	public List<Contact> findAllByContactImageIdOrderByAsc(Long contactImageId){
		return query(String.format("SELECT * FROM CONTACT WHERE CONTACT_IMAGE_ID = '%s' ORDER BY CONTACT_IMAGE_ID ASC", String.valueOf(contactImageId)));
	}

	public List<Contact> findAllByContactImageIdOrderByDesc(Long contactImageId){
		return query(String.format("SELECT * FROM CONTACT WHERE CONTACT_IMAGE_ID = '%s' ORDER BY CONTACT_IMAGE_ID DESC", String.valueOf(contactImageId)));
	}

	public List<Contact> findAllByContactImageIdLike(Long contactImageId){
		return query(String.format("SELECT * FROM CONTACT WHERE CONTACT_IMAGE_ID like '%%s%'", String.valueOf(contactImageId)));
	}
	
	public List<Contact> findAllByContactImageIdLikeOrderByAsc(Long contactImageId){
		return query(String.format("SELECT * FROM CONTACT WHERE CONTACT_IMAGE_ID like '%%s%' ORDER BY CONTACT_IMAGE_ID ASC", String.valueOf(contactImageId)));
	}
	
	public List<Contact> findAllByContactImageIdLikeOrderByDesc(Long contactImageId){
		return query(String.format("SELECT * FROM CONTACT WHERE CONTACT_IMAGE_ID like '%%s%' ORDER BY CONTACT_IMAGE_ID DESC", String.valueOf(contactImageId)));
	}
	
	@Override
	protected String findAllStatement() {
		return ContactConstant.SQL_FIND_ALL;
	}
	
	@Override
	protected String findByIdStatement(long id) {
		return String.format(ContactConstant.SQL_FIND_BY_ID, id);
	}

	@Override
	protected String saveStatement() {
		return ContactConstant.SQL_INSERT;
	}

	@Override
	protected void prepareStatetmentForSave(Contact t, PreparedStatement statement) throws SQLException {
		statement.setString(1, t.getFirstname());
		statement.setString(2, t.getLastname());
		statement.setString(3, t.getUsername());
		statement.setLong(4, t.getContactImageId());
	}

	@Override
	protected String updateStatement() {
		return ContactConstant.SQL_MERGE;
	}

	@Override
	protected void prepareStatetmentForUpdate(Contact t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getId());
		statement.setString(2, t.getFirstname());
		statement.setString(3, t.getLastname());
		statement.setString(4, t.getUsername());
		statement.setLong(5, t.getContactImageId());
	}

	@Override
	protected String deleteStatement() {
		return ContactConstant.SQL_DELETE_BY_ID;
	}
	
	@Override
	protected void prepapreStatementForDelete(Contact t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getId());
	}
}
