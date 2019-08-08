package de.dc.fx.ui.jregis.metro.ui.gen.contacts.phone.repository;

import java.sql.*;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.phone.model.*;
import java.util.*;
import java.time.*;

public class PhonenumberRepository extends BaseRepository<Phonenumber>{

	@Override
	protected Phonenumber map(ResultSet resultSet) throws SQLException{
		Phonenumber phonenumber = new Phonenumber();
		phonenumber.setId(resultSet.getLong("ID"));
		phonenumber.setContactId(resultSet.getLong("CONTACT_ID"));
		phonenumber.setName(resultSet.getString("NAME"));
		phonenumber.setNumber(resultSet.getString("NUMBER"));
		phonenumber.setNumberType(resultSet.getString("NUMBER_TYPE"));
		return phonenumber;
	}
	
	public List<Phonenumber> findAllByContactId(Long contactId){
		return query(String.format("SELECT * FROM PHONENUMBER WHERE CONTACT_ID = '%s'", String.valueOf(contactId)));
	}

	public List<Phonenumber> findAllByContactIdOrderByAsc(Long contactId){
		return query(String.format("SELECT * FROM PHONENUMBER WHERE CONTACT_ID = '%s' ORDER BY CONTACT_ID ASC", String.valueOf(contactId)));
	}

	public List<Phonenumber> findAllByContactIdOrderByDesc(Long contactId){
		return query(String.format("SELECT * FROM PHONENUMBER WHERE CONTACT_ID = '%s' ORDER BY CONTACT_ID DESC", String.valueOf(contactId)));
	}

	public List<Phonenumber> findAllByContactIdLike(Long contactId){
		return query(String.format("SELECT * FROM PHONENUMBER WHERE CONTACT_ID like '%%s%'", String.valueOf(contactId)));
	}
	
	public List<Phonenumber> findAllByContactIdLikeOrderByAsc(Long contactId){
		return query(String.format("SELECT * FROM PHONENUMBER WHERE CONTACT_ID like '%%s%' ORDER BY CONTACT_ID ASC", String.valueOf(contactId)));
	}
	
	public List<Phonenumber> findAllByContactIdLikeOrderByDesc(Long contactId){
		return query(String.format("SELECT * FROM PHONENUMBER WHERE CONTACT_ID like '%%s%' ORDER BY CONTACT_ID DESC", String.valueOf(contactId)));
	}
	public List<Phonenumber> findAllByName(String name){
		return query(String.format("SELECT * FROM PHONENUMBER WHERE NAME = '%s'", String.valueOf(name)));
	}

	public List<Phonenumber> findAllByNameOrderByAsc(String name){
		return query(String.format("SELECT * FROM PHONENUMBER WHERE NAME = '%s' ORDER BY NAME ASC", String.valueOf(name)));
	}

	public List<Phonenumber> findAllByNameOrderByDesc(String name){
		return query(String.format("SELECT * FROM PHONENUMBER WHERE NAME = '%s' ORDER BY NAME DESC", String.valueOf(name)));
	}

	public List<Phonenumber> findAllByNameLike(String name){
		return query(String.format("SELECT * FROM PHONENUMBER WHERE NAME like '%%s%'", String.valueOf(name)));
	}
	
	public List<Phonenumber> findAllByNameLikeOrderByAsc(String name){
		return query(String.format("SELECT * FROM PHONENUMBER WHERE NAME like '%%s%' ORDER BY NAME ASC", String.valueOf(name)));
	}
	
	public List<Phonenumber> findAllByNameLikeOrderByDesc(String name){
		return query(String.format("SELECT * FROM PHONENUMBER WHERE NAME like '%%s%' ORDER BY NAME DESC", String.valueOf(name)));
	}
	public List<Phonenumber> findAllByNumber(String number){
		return query(String.format("SELECT * FROM PHONENUMBER WHERE NUMBER = '%s'", String.valueOf(number)));
	}

	public List<Phonenumber> findAllByNumberOrderByAsc(String number){
		return query(String.format("SELECT * FROM PHONENUMBER WHERE NUMBER = '%s' ORDER BY NUMBER ASC", String.valueOf(number)));
	}

	public List<Phonenumber> findAllByNumberOrderByDesc(String number){
		return query(String.format("SELECT * FROM PHONENUMBER WHERE NUMBER = '%s' ORDER BY NUMBER DESC", String.valueOf(number)));
	}

	public List<Phonenumber> findAllByNumberLike(String number){
		return query(String.format("SELECT * FROM PHONENUMBER WHERE NUMBER like '%%s%'", String.valueOf(number)));
	}
	
	public List<Phonenumber> findAllByNumberLikeOrderByAsc(String number){
		return query(String.format("SELECT * FROM PHONENUMBER WHERE NUMBER like '%%s%' ORDER BY NUMBER ASC", String.valueOf(number)));
	}
	
	public List<Phonenumber> findAllByNumberLikeOrderByDesc(String number){
		return query(String.format("SELECT * FROM PHONENUMBER WHERE NUMBER like '%%s%' ORDER BY NUMBER DESC", String.valueOf(number)));
	}
	public List<Phonenumber> findAllByNumberType(String numberType){
		return query(String.format("SELECT * FROM PHONENUMBER WHERE NUMBER_TYPE = '%s'", String.valueOf(numberType)));
	}

	public List<Phonenumber> findAllByNumberTypeOrderByAsc(String numberType){
		return query(String.format("SELECT * FROM PHONENUMBER WHERE NUMBER_TYPE = '%s' ORDER BY NUMBER_TYPE ASC", String.valueOf(numberType)));
	}

	public List<Phonenumber> findAllByNumberTypeOrderByDesc(String numberType){
		return query(String.format("SELECT * FROM PHONENUMBER WHERE NUMBER_TYPE = '%s' ORDER BY NUMBER_TYPE DESC", String.valueOf(numberType)));
	}

	public List<Phonenumber> findAllByNumberTypeLike(String numberType){
		return query(String.format("SELECT * FROM PHONENUMBER WHERE NUMBER_TYPE like '%%s%'", String.valueOf(numberType)));
	}
	
	public List<Phonenumber> findAllByNumberTypeLikeOrderByAsc(String numberType){
		return query(String.format("SELECT * FROM PHONENUMBER WHERE NUMBER_TYPE like '%%s%' ORDER BY NUMBER_TYPE ASC", String.valueOf(numberType)));
	}
	
	public List<Phonenumber> findAllByNumberTypeLikeOrderByDesc(String numberType){
		return query(String.format("SELECT * FROM PHONENUMBER WHERE NUMBER_TYPE like '%%s%' ORDER BY NUMBER_TYPE DESC", String.valueOf(numberType)));
	}
	
	@Override
	protected String findAllStatement() {
		return PhonenumberConstant.SQL_FIND_ALL;
	}
	
	@Override
	protected String findByIdStatement(long id) {
		return String.format(PhonenumberConstant.SQL_FIND_BY_ID, id);
	}

	@Override
	protected String saveStatement() {
		return PhonenumberConstant.SQL_INSERT;
	}

	@Override
	protected void prepareStatetmentForSave(Phonenumber t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getContactId());
		statement.setString(2, t.getName());
		statement.setString(3, t.getNumber());
		statement.setString(4, t.getNumberType());
	}

	@Override
	protected String updateStatement() {
		return PhonenumberConstant.SQL_MERGE;
	}

	@Override
	protected void prepareStatetmentForUpdate(Phonenumber t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getId());
		statement.setLong(2, t.getContactId());
		statement.setString(3, t.getName());
		statement.setString(4, t.getNumber());
		statement.setString(5, t.getNumberType());
	}

	@Override
	protected String deleteStatement() {
		return PhonenumberConstant.SQL_DELETE_BY_ID;
	}
	
	@Override
	protected void prepapreStatementForDelete(Phonenumber t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getId());
	}
}
