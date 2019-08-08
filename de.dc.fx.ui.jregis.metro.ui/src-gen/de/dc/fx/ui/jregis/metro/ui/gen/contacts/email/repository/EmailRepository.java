package de.dc.fx.ui.jregis.metro.ui.gen.contacts.email.repository;

import java.sql.*;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.email.model.*;
import java.util.*;
import java.time.*;

public class EmailRepository extends BaseRepository<Email>{

	@Override
	protected Email map(ResultSet resultSet) throws SQLException{
		Email email = new Email();
		email.setId(resultSet.getLong("ID"));
		email.setContactId(resultSet.getLong("CONTACT_ID"));
		email.setName(resultSet.getString("NAME"));
		email.setAddress(resultSet.getString("ADDRESS"));
		return email;
	}
	
	public List<Email> findAllByContactId(Long contactId){
		return query(String.format("SELECT * FROM EMAIL WHERE CONTACT_ID = '%s'", String.valueOf(contactId)));
	}

	public List<Email> findAllByContactIdOrderByAsc(Long contactId){
		return query(String.format("SELECT * FROM EMAIL WHERE CONTACT_ID = '%s' ORDER BY CONTACT_ID ASC", String.valueOf(contactId)));
	}

	public List<Email> findAllByContactIdOrderByDesc(Long contactId){
		return query(String.format("SELECT * FROM EMAIL WHERE CONTACT_ID = '%s' ORDER BY CONTACT_ID DESC", String.valueOf(contactId)));
	}

	public List<Email> findAllByContactIdLike(Long contactId){
		return query(String.format("SELECT * FROM EMAIL WHERE CONTACT_ID like '%%s%'", String.valueOf(contactId)));
	}
	
	public List<Email> findAllByContactIdLikeOrderByAsc(Long contactId){
		return query(String.format("SELECT * FROM EMAIL WHERE CONTACT_ID like '%%s%' ORDER BY CONTACT_ID ASC", String.valueOf(contactId)));
	}
	
	public List<Email> findAllByContactIdLikeOrderByDesc(Long contactId){
		return query(String.format("SELECT * FROM EMAIL WHERE CONTACT_ID like '%%s%' ORDER BY CONTACT_ID DESC", String.valueOf(contactId)));
	}
	public List<Email> findAllByName(String name){
		return query(String.format("SELECT * FROM EMAIL WHERE NAME = '%s'", String.valueOf(name)));
	}

	public List<Email> findAllByNameOrderByAsc(String name){
		return query(String.format("SELECT * FROM EMAIL WHERE NAME = '%s' ORDER BY NAME ASC", String.valueOf(name)));
	}

	public List<Email> findAllByNameOrderByDesc(String name){
		return query(String.format("SELECT * FROM EMAIL WHERE NAME = '%s' ORDER BY NAME DESC", String.valueOf(name)));
	}

	public List<Email> findAllByNameLike(String name){
		return query(String.format("SELECT * FROM EMAIL WHERE NAME like '%%s%'", String.valueOf(name)));
	}
	
	public List<Email> findAllByNameLikeOrderByAsc(String name){
		return query(String.format("SELECT * FROM EMAIL WHERE NAME like '%%s%' ORDER BY NAME ASC", String.valueOf(name)));
	}
	
	public List<Email> findAllByNameLikeOrderByDesc(String name){
		return query(String.format("SELECT * FROM EMAIL WHERE NAME like '%%s%' ORDER BY NAME DESC", String.valueOf(name)));
	}
	public List<Email> findAllByAddress(String address){
		return query(String.format("SELECT * FROM EMAIL WHERE ADDRESS = '%s'", String.valueOf(address)));
	}

	public List<Email> findAllByAddressOrderByAsc(String address){
		return query(String.format("SELECT * FROM EMAIL WHERE ADDRESS = '%s' ORDER BY ADDRESS ASC", String.valueOf(address)));
	}

	public List<Email> findAllByAddressOrderByDesc(String address){
		return query(String.format("SELECT * FROM EMAIL WHERE ADDRESS = '%s' ORDER BY ADDRESS DESC", String.valueOf(address)));
	}

	public List<Email> findAllByAddressLike(String address){
		return query(String.format("SELECT * FROM EMAIL WHERE ADDRESS like '%%s%'", String.valueOf(address)));
	}
	
	public List<Email> findAllByAddressLikeOrderByAsc(String address){
		return query(String.format("SELECT * FROM EMAIL WHERE ADDRESS like '%%s%' ORDER BY ADDRESS ASC", String.valueOf(address)));
	}
	
	public List<Email> findAllByAddressLikeOrderByDesc(String address){
		return query(String.format("SELECT * FROM EMAIL WHERE ADDRESS like '%%s%' ORDER BY ADDRESS DESC", String.valueOf(address)));
	}
	
	@Override
	protected String findAllStatement() {
		return EmailConstant.SQL_FIND_ALL;
	}
	
	@Override
	protected String findByIdStatement(long id) {
		return String.format(EmailConstant.SQL_FIND_BY_ID, id);
	}

	@Override
	protected String saveStatement() {
		return EmailConstant.SQL_INSERT;
	}

	@Override
	protected void prepareStatetmentForSave(Email t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getContactId());
		statement.setString(2, t.getName());
		statement.setString(3, t.getAddress());
	}

	@Override
	protected String updateStatement() {
		return EmailConstant.SQL_MERGE;
	}

	@Override
	protected void prepareStatetmentForUpdate(Email t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getId());
		statement.setLong(2, t.getContactId());
		statement.setString(3, t.getName());
		statement.setString(4, t.getAddress());
	}

	@Override
	protected String deleteStatement() {
		return EmailConstant.SQL_DELETE_BY_ID;
	}
	
	@Override
	protected void prepapreStatementForDelete(Email t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getId());
	}
}
