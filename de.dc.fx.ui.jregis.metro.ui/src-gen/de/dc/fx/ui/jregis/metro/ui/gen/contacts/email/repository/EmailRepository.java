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
		email.setStatus(resultSet.getInt("STATUS"));
		email.setCreatedOn(resultSet.getTimestamp("CREATED_ON").toLocalDateTime());
		email.setUpdatedOn(resultSet.getTimestamp("UPDATED_ON").toLocalDateTime());
		return email;
	}
	
	public void updateContactId(long id, java.lang.Long contactId) {
		queryExecute("UPDATE EMAIL SET CONTACT_ID ='"+contactId+"' WHERE ID = "+id);
	}
	
	public void deleteByContactId(java.lang.Long contactId) {
		queryExecute("DELETE EMAIL WHERE CONTACT_ID = '"+contactId+"'");
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
	public void updateName(long id, java.lang.String name) {
		queryExecute("UPDATE EMAIL SET NAME ='"+name+"' WHERE ID = "+id);
	}
	
	public void deleteByName(java.lang.String name) {
		queryExecute("DELETE EMAIL WHERE NAME = '"+name+"'");
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
	public void updateAddress(long id, java.lang.String address) {
		queryExecute("UPDATE EMAIL SET ADDRESS ='"+address+"' WHERE ID = "+id);
	}
	
	public void deleteByAddress(java.lang.String address) {
		queryExecute("DELETE EMAIL WHERE ADDRESS = '"+address+"'");
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
	public void updateStatus(long id, java.lang.Integer status) {
		queryExecute("UPDATE EMAIL SET STATUS ='"+status+"' WHERE ID = "+id);
	}
	
	public void deleteByStatus(java.lang.Integer status) {
		queryExecute("DELETE EMAIL WHERE STATUS = '"+status+"'");
	}
	
	public List<Email> findAllByStatus(Integer status){
		return query(String.format("SELECT * FROM EMAIL WHERE STATUS = '%s'", String.valueOf(status)));
	}

	public List<Email> findAllByStatusOrderByAsc(Integer status){
		return query(String.format("SELECT * FROM EMAIL WHERE STATUS = '%s' ORDER BY STATUS ASC", String.valueOf(status)));
	}

	public List<Email> findAllByStatusOrderByDesc(Integer status){
		return query(String.format("SELECT * FROM EMAIL WHERE STATUS = '%s' ORDER BY STATUS DESC", String.valueOf(status)));
	}

	public List<Email> findAllByStatusLike(Integer status){
		return query(String.format("SELECT * FROM EMAIL WHERE STATUS like '%%s%'", String.valueOf(status)));
	}
	
	public List<Email> findAllByStatusLikeOrderByAsc(Integer status){
		return query(String.format("SELECT * FROM EMAIL WHERE STATUS like '%%s%' ORDER BY STATUS ASC", String.valueOf(status)));
	}
	
	public List<Email> findAllByStatusLikeOrderByDesc(Integer status){
		return query(String.format("SELECT * FROM EMAIL WHERE STATUS like '%%s%' ORDER BY STATUS DESC", String.valueOf(status)));
	}
	public void updateCreatedOn(long id, java.time.LocalDateTime createdOn) {
		queryExecute("UPDATE EMAIL SET CREATED_ON ='"+createdOn+"' WHERE ID = "+id);
	}
	
	public void deleteByCreatedOn(java.time.LocalDateTime createdOn) {
		queryExecute("DELETE EMAIL WHERE CREATED_ON = '"+createdOn+"'");
	}
	
	public List<Email> findAllByCreatedOn(LocalDateTime createdOn){
		return query(String.format("SELECT * FROM EMAIL WHERE CREATED_ON = '%s'", String.valueOf(createdOn)));
	}

	public List<Email> findAllByCreatedOnOrderByAsc(LocalDateTime createdOn){
		return query(String.format("SELECT * FROM EMAIL WHERE CREATED_ON = '%s' ORDER BY CREATED_ON ASC", String.valueOf(createdOn)));
	}

	public List<Email> findAllByCreatedOnOrderByDesc(LocalDateTime createdOn){
		return query(String.format("SELECT * FROM EMAIL WHERE CREATED_ON = '%s' ORDER BY CREATED_ON DESC", String.valueOf(createdOn)));
	}

	public List<Email> findAllByCreatedOnLike(LocalDateTime createdOn){
		return query(String.format("SELECT * FROM EMAIL WHERE CREATED_ON like '%%s%'", String.valueOf(createdOn)));
	}
	
	public List<Email> findAllByCreatedOnLikeOrderByAsc(LocalDateTime createdOn){
		return query(String.format("SELECT * FROM EMAIL WHERE CREATED_ON like '%%s%' ORDER BY CREATED_ON ASC", String.valueOf(createdOn)));
	}
	
	public List<Email> findAllByCreatedOnLikeOrderByDesc(LocalDateTime createdOn){
		return query(String.format("SELECT * FROM EMAIL WHERE CREATED_ON like '%%s%' ORDER BY CREATED_ON DESC", String.valueOf(createdOn)));
	}
	public void updateUpdatedOn(long id, java.time.LocalDateTime updatedOn) {
		queryExecute("UPDATE EMAIL SET UPDATED_ON ='"+updatedOn+"' WHERE ID = "+id);
	}
	
	public void deleteByUpdatedOn(java.time.LocalDateTime updatedOn) {
		queryExecute("DELETE EMAIL WHERE UPDATED_ON = '"+updatedOn+"'");
	}
	
	public List<Email> findAllByUpdatedOn(LocalDateTime updatedOn){
		return query(String.format("SELECT * FROM EMAIL WHERE UPDATED_ON = '%s'", String.valueOf(updatedOn)));
	}

	public List<Email> findAllByUpdatedOnOrderByAsc(LocalDateTime updatedOn){
		return query(String.format("SELECT * FROM EMAIL WHERE UPDATED_ON = '%s' ORDER BY UPDATED_ON ASC", String.valueOf(updatedOn)));
	}

	public List<Email> findAllByUpdatedOnOrderByDesc(LocalDateTime updatedOn){
		return query(String.format("SELECT * FROM EMAIL WHERE UPDATED_ON = '%s' ORDER BY UPDATED_ON DESC", String.valueOf(updatedOn)));
	}

	public List<Email> findAllByUpdatedOnLike(LocalDateTime updatedOn){
		return query(String.format("SELECT * FROM EMAIL WHERE UPDATED_ON like '%%s%'", String.valueOf(updatedOn)));
	}
	
	public List<Email> findAllByUpdatedOnLikeOrderByAsc(LocalDateTime updatedOn){
		return query(String.format("SELECT * FROM EMAIL WHERE UPDATED_ON like '%%s%' ORDER BY UPDATED_ON ASC", String.valueOf(updatedOn)));
	}
	
	public List<Email> findAllByUpdatedOnLikeOrderByDesc(LocalDateTime updatedOn){
		return query(String.format("SELECT * FROM EMAIL WHERE UPDATED_ON like '%%s%' ORDER BY UPDATED_ON DESC", String.valueOf(updatedOn)));
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
		statement.setInt(4, t.getStatus());
		statement.setTimestamp(5, Timestamp.valueOf(t.getCreatedOn()));
		statement.setTimestamp(6, Timestamp.valueOf(t.getUpdatedOn()));
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
		statement.setInt(5, t.getStatus());
		statement.setTimestamp(6, Timestamp.valueOf(t.getCreatedOn()));
		statement.setTimestamp(7, Timestamp.valueOf(t.getUpdatedOn()));
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
