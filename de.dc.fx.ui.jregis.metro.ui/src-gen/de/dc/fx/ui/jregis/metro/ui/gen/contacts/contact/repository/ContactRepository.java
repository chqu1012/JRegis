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
		contact.setStatus(resultSet.getInt("STATUS"));
		contact.setCreatedOn(resultSet.getTimestamp("CREATED_ON").toLocalDateTime());
		contact.setUpdatedOn(resultSet.getTimestamp("UPDATED_ON").toLocalDateTime());
		return contact;
	}
	
	public void updateFirstname(long id, java.lang.String firstname) {
		queryExecute("UPDATE CONTACT SET FIRSTNAME ='"+firstname+"' WHERE ID = "+id);
	}
	
	public void deleteByFirstname(java.lang.String firstname) {
		queryExecute("DELETE CONTACT WHERE FIRSTNAME = '"+firstname+"'");
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
	public void updateLastname(long id, java.lang.String lastname) {
		queryExecute("UPDATE CONTACT SET LASTNAME ='"+lastname+"' WHERE ID = "+id);
	}
	
	public void deleteByLastname(java.lang.String lastname) {
		queryExecute("DELETE CONTACT WHERE LASTNAME = '"+lastname+"'");
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
	public void updateUsername(long id, java.lang.String username) {
		queryExecute("UPDATE CONTACT SET USERNAME ='"+username+"' WHERE ID = "+id);
	}
	
	public void deleteByUsername(java.lang.String username) {
		queryExecute("DELETE CONTACT WHERE USERNAME = '"+username+"'");
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
	public void updateContactImageId(long id, java.lang.Long contactImageId) {
		queryExecute("UPDATE CONTACT SET CONTACT_IMAGE_ID ='"+contactImageId+"' WHERE ID = "+id);
	}
	
	public void deleteByContactImageId(java.lang.Long contactImageId) {
		queryExecute("DELETE CONTACT WHERE CONTACT_IMAGE_ID = '"+contactImageId+"'");
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
	public void updateStatus(long id, java.lang.Integer status) {
		queryExecute("UPDATE CONTACT SET STATUS ='"+status+"' WHERE ID = "+id);
	}
	
	public void deleteByStatus(java.lang.Integer status) {
		queryExecute("DELETE CONTACT WHERE STATUS = '"+status+"'");
	}
	
	public List<Contact> findAllByStatus(Integer status){
		return query(String.format("SELECT * FROM CONTACT WHERE STATUS = '%s'", String.valueOf(status)));
	}

	public List<Contact> findAllByStatusOrderByAsc(Integer status){
		return query(String.format("SELECT * FROM CONTACT WHERE STATUS = '%s' ORDER BY STATUS ASC", String.valueOf(status)));
	}

	public List<Contact> findAllByStatusOrderByDesc(Integer status){
		return query(String.format("SELECT * FROM CONTACT WHERE STATUS = '%s' ORDER BY STATUS DESC", String.valueOf(status)));
	}

	public List<Contact> findAllByStatusLike(Integer status){
		return query(String.format("SELECT * FROM CONTACT WHERE STATUS like '%%s%'", String.valueOf(status)));
	}
	
	public List<Contact> findAllByStatusLikeOrderByAsc(Integer status){
		return query(String.format("SELECT * FROM CONTACT WHERE STATUS like '%%s%' ORDER BY STATUS ASC", String.valueOf(status)));
	}
	
	public List<Contact> findAllByStatusLikeOrderByDesc(Integer status){
		return query(String.format("SELECT * FROM CONTACT WHERE STATUS like '%%s%' ORDER BY STATUS DESC", String.valueOf(status)));
	}
	public void updateCreatedOn(long id, java.time.LocalDateTime createdOn) {
		queryExecute("UPDATE CONTACT SET CREATED_ON ='"+createdOn+"' WHERE ID = "+id);
	}
	
	public void deleteByCreatedOn(java.time.LocalDateTime createdOn) {
		queryExecute("DELETE CONTACT WHERE CREATED_ON = '"+createdOn+"'");
	}
	
	public List<Contact> findAllByCreatedOn(LocalDateTime createdOn){
		return query(String.format("SELECT * FROM CONTACT WHERE CREATED_ON = '%s'", String.valueOf(createdOn)));
	}

	public List<Contact> findAllByCreatedOnOrderByAsc(LocalDateTime createdOn){
		return query(String.format("SELECT * FROM CONTACT WHERE CREATED_ON = '%s' ORDER BY CREATED_ON ASC", String.valueOf(createdOn)));
	}

	public List<Contact> findAllByCreatedOnOrderByDesc(LocalDateTime createdOn){
		return query(String.format("SELECT * FROM CONTACT WHERE CREATED_ON = '%s' ORDER BY CREATED_ON DESC", String.valueOf(createdOn)));
	}

	public List<Contact> findAllByCreatedOnLike(LocalDateTime createdOn){
		return query(String.format("SELECT * FROM CONTACT WHERE CREATED_ON like '%%s%'", String.valueOf(createdOn)));
	}
	
	public List<Contact> findAllByCreatedOnLikeOrderByAsc(LocalDateTime createdOn){
		return query(String.format("SELECT * FROM CONTACT WHERE CREATED_ON like '%%s%' ORDER BY CREATED_ON ASC", String.valueOf(createdOn)));
	}
	
	public List<Contact> findAllByCreatedOnLikeOrderByDesc(LocalDateTime createdOn){
		return query(String.format("SELECT * FROM CONTACT WHERE CREATED_ON like '%%s%' ORDER BY CREATED_ON DESC", String.valueOf(createdOn)));
	}
	public void updateUpdatedOn(long id, java.time.LocalDateTime updatedOn) {
		queryExecute("UPDATE CONTACT SET UPDATED_ON ='"+updatedOn+"' WHERE ID = "+id);
	}
	
	public void deleteByUpdatedOn(java.time.LocalDateTime updatedOn) {
		queryExecute("DELETE CONTACT WHERE UPDATED_ON = '"+updatedOn+"'");
	}
	
	public List<Contact> findAllByUpdatedOn(LocalDateTime updatedOn){
		return query(String.format("SELECT * FROM CONTACT WHERE UPDATED_ON = '%s'", String.valueOf(updatedOn)));
	}

	public List<Contact> findAllByUpdatedOnOrderByAsc(LocalDateTime updatedOn){
		return query(String.format("SELECT * FROM CONTACT WHERE UPDATED_ON = '%s' ORDER BY UPDATED_ON ASC", String.valueOf(updatedOn)));
	}

	public List<Contact> findAllByUpdatedOnOrderByDesc(LocalDateTime updatedOn){
		return query(String.format("SELECT * FROM CONTACT WHERE UPDATED_ON = '%s' ORDER BY UPDATED_ON DESC", String.valueOf(updatedOn)));
	}

	public List<Contact> findAllByUpdatedOnLike(LocalDateTime updatedOn){
		return query(String.format("SELECT * FROM CONTACT WHERE UPDATED_ON like '%%s%'", String.valueOf(updatedOn)));
	}
	
	public List<Contact> findAllByUpdatedOnLikeOrderByAsc(LocalDateTime updatedOn){
		return query(String.format("SELECT * FROM CONTACT WHERE UPDATED_ON like '%%s%' ORDER BY UPDATED_ON ASC", String.valueOf(updatedOn)));
	}
	
	public List<Contact> findAllByUpdatedOnLikeOrderByDesc(LocalDateTime updatedOn){
		return query(String.format("SELECT * FROM CONTACT WHERE UPDATED_ON like '%%s%' ORDER BY UPDATED_ON DESC", String.valueOf(updatedOn)));
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
		statement.setInt(5, t.getStatus());
		statement.setTimestamp(6, Timestamp.valueOf(t.getCreatedOn()));
		statement.setTimestamp(7, Timestamp.valueOf(t.getUpdatedOn()));
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
		statement.setInt(6, t.getStatus());
		statement.setTimestamp(7, Timestamp.valueOf(t.getCreatedOn()));
		statement.setTimestamp(8, Timestamp.valueOf(t.getUpdatedOn()));
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
