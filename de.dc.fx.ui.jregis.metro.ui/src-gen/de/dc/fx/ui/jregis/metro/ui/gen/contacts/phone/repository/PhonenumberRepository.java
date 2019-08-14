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
		phonenumber.setStatus(resultSet.getInt("STATUS"));
		phonenumber.setCreatedOn(resultSet.getTimestamp("CREATED_ON").toLocalDateTime());
		phonenumber.setUpdatedOn(resultSet.getTimestamp("UPDATED_ON").toLocalDateTime());
		return phonenumber;
	}
	
	public void updateContactId(long id, java.lang.Long contactId) {
		query("UPDATE PHONENUMBER SET CONTACT_ID ='"+contactId+"' WHERE ID = "+id);
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
	public void updateName(long id, java.lang.String name) {
		query("UPDATE PHONENUMBER SET NAME ='"+name+"' WHERE ID = "+id);
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
	public void updateNumber(long id, java.lang.String number) {
		query("UPDATE PHONENUMBER SET NUMBER ='"+number+"' WHERE ID = "+id);
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
	public void updateNumberType(long id, java.lang.String numberType) {
		query("UPDATE PHONENUMBER SET NUMBER_TYPE ='"+numberType+"' WHERE ID = "+id);
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
	public void updateStatus(long id, java.lang.Integer status) {
		query("UPDATE PHONENUMBER SET STATUS ='"+status+"' WHERE ID = "+id);
	}
	
	public List<Phonenumber> findAllByStatus(Integer status){
		return query(String.format("SELECT * FROM PHONENUMBER WHERE STATUS = '%s'", String.valueOf(status)));
	}

	public List<Phonenumber> findAllByStatusOrderByAsc(Integer status){
		return query(String.format("SELECT * FROM PHONENUMBER WHERE STATUS = '%s' ORDER BY STATUS ASC", String.valueOf(status)));
	}

	public List<Phonenumber> findAllByStatusOrderByDesc(Integer status){
		return query(String.format("SELECT * FROM PHONENUMBER WHERE STATUS = '%s' ORDER BY STATUS DESC", String.valueOf(status)));
	}

	public List<Phonenumber> findAllByStatusLike(Integer status){
		return query(String.format("SELECT * FROM PHONENUMBER WHERE STATUS like '%%s%'", String.valueOf(status)));
	}
	
	public List<Phonenumber> findAllByStatusLikeOrderByAsc(Integer status){
		return query(String.format("SELECT * FROM PHONENUMBER WHERE STATUS like '%%s%' ORDER BY STATUS ASC", String.valueOf(status)));
	}
	
	public List<Phonenumber> findAllByStatusLikeOrderByDesc(Integer status){
		return query(String.format("SELECT * FROM PHONENUMBER WHERE STATUS like '%%s%' ORDER BY STATUS DESC", String.valueOf(status)));
	}
	public void updateCreatedOn(long id, java.time.LocalDateTime createdOn) {
		query("UPDATE PHONENUMBER SET CREATED_ON ='"+createdOn+"' WHERE ID = "+id);
	}
	
	public List<Phonenumber> findAllByCreatedOn(LocalDateTime createdOn){
		return query(String.format("SELECT * FROM PHONENUMBER WHERE CREATED_ON = '%s'", String.valueOf(createdOn)));
	}

	public List<Phonenumber> findAllByCreatedOnOrderByAsc(LocalDateTime createdOn){
		return query(String.format("SELECT * FROM PHONENUMBER WHERE CREATED_ON = '%s' ORDER BY CREATED_ON ASC", String.valueOf(createdOn)));
	}

	public List<Phonenumber> findAllByCreatedOnOrderByDesc(LocalDateTime createdOn){
		return query(String.format("SELECT * FROM PHONENUMBER WHERE CREATED_ON = '%s' ORDER BY CREATED_ON DESC", String.valueOf(createdOn)));
	}

	public List<Phonenumber> findAllByCreatedOnLike(LocalDateTime createdOn){
		return query(String.format("SELECT * FROM PHONENUMBER WHERE CREATED_ON like '%%s%'", String.valueOf(createdOn)));
	}
	
	public List<Phonenumber> findAllByCreatedOnLikeOrderByAsc(LocalDateTime createdOn){
		return query(String.format("SELECT * FROM PHONENUMBER WHERE CREATED_ON like '%%s%' ORDER BY CREATED_ON ASC", String.valueOf(createdOn)));
	}
	
	public List<Phonenumber> findAllByCreatedOnLikeOrderByDesc(LocalDateTime createdOn){
		return query(String.format("SELECT * FROM PHONENUMBER WHERE CREATED_ON like '%%s%' ORDER BY CREATED_ON DESC", String.valueOf(createdOn)));
	}
	public void updateUpdatedOn(long id, java.time.LocalDateTime updatedOn) {
		query("UPDATE PHONENUMBER SET UPDATED_ON ='"+updatedOn+"' WHERE ID = "+id);
	}
	
	public List<Phonenumber> findAllByUpdatedOn(LocalDateTime updatedOn){
		return query(String.format("SELECT * FROM PHONENUMBER WHERE UPDATED_ON = '%s'", String.valueOf(updatedOn)));
	}

	public List<Phonenumber> findAllByUpdatedOnOrderByAsc(LocalDateTime updatedOn){
		return query(String.format("SELECT * FROM PHONENUMBER WHERE UPDATED_ON = '%s' ORDER BY UPDATED_ON ASC", String.valueOf(updatedOn)));
	}

	public List<Phonenumber> findAllByUpdatedOnOrderByDesc(LocalDateTime updatedOn){
		return query(String.format("SELECT * FROM PHONENUMBER WHERE UPDATED_ON = '%s' ORDER BY UPDATED_ON DESC", String.valueOf(updatedOn)));
	}

	public List<Phonenumber> findAllByUpdatedOnLike(LocalDateTime updatedOn){
		return query(String.format("SELECT * FROM PHONENUMBER WHERE UPDATED_ON like '%%s%'", String.valueOf(updatedOn)));
	}
	
	public List<Phonenumber> findAllByUpdatedOnLikeOrderByAsc(LocalDateTime updatedOn){
		return query(String.format("SELECT * FROM PHONENUMBER WHERE UPDATED_ON like '%%s%' ORDER BY UPDATED_ON ASC", String.valueOf(updatedOn)));
	}
	
	public List<Phonenumber> findAllByUpdatedOnLikeOrderByDesc(LocalDateTime updatedOn){
		return query(String.format("SELECT * FROM PHONENUMBER WHERE UPDATED_ON like '%%s%' ORDER BY UPDATED_ON DESC", String.valueOf(updatedOn)));
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
		statement.setInt(5, t.getStatus());
		statement.setTimestamp(6, Timestamp.valueOf(t.getCreatedOn()));
		statement.setTimestamp(7, Timestamp.valueOf(t.getUpdatedOn()));
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
		statement.setInt(6, t.getStatus());
		statement.setTimestamp(7, Timestamp.valueOf(t.getCreatedOn()));
		statement.setTimestamp(8, Timestamp.valueOf(t.getUpdatedOn()));
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
