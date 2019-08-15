package de.dc.fx.ui.jregis.metro.ui.gen.contacts.group.repository;

import java.sql.*;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.group.model.*;
import java.util.*;
import java.time.*;

public class ContactGroupRepository extends BaseRepository<ContactGroup>{

	@Override
	protected ContactGroup map(ResultSet resultSet) throws SQLException{
		ContactGroup contactGroup = new ContactGroup();
		contactGroup.setId(resultSet.getLong("ID"));
		contactGroup.setName(resultSet.getString("NAME"));
		contactGroup.setStatus(resultSet.getInt("STATUS"));
		contactGroup.setCreatedOn(resultSet.getTimestamp("CREATED_ON").toLocalDateTime());
		contactGroup.setUpdatedOn(resultSet.getTimestamp("UPDATED_ON").toLocalDateTime());
		return contactGroup;
	}
	
	public void updateName(long id, java.lang.String name) {
		queryExecute("UPDATE CONTACT_GROUP SET NAME ='"+name+"' WHERE ID = "+id);
	}
	
	public void deleteByName(java.lang.String name) {
		queryExecute("DELETE CONTACT_GROUP WHERE NAME = '"+name+"'");
	}
	
	public List<ContactGroup> findAllByName(String name){
		return query(String.format("SELECT * FROM CONTACT_GROUP WHERE NAME = '%s'", String.valueOf(name)));
	}

	public List<ContactGroup> findAllByNameOrderByAsc(String name){
		return query(String.format("SELECT * FROM CONTACT_GROUP WHERE NAME = '%s' ORDER BY NAME ASC", String.valueOf(name)));
	}

	public List<ContactGroup> findAllByNameOrderByDesc(String name){
		return query(String.format("SELECT * FROM CONTACT_GROUP WHERE NAME = '%s' ORDER BY NAME DESC", String.valueOf(name)));
	}

	public List<ContactGroup> findAllByNameLike(String name){
		return query(String.format("SELECT * FROM CONTACT_GROUP WHERE NAME like '%%s%'", String.valueOf(name)));
	}
	
	public List<ContactGroup> findAllByNameLikeOrderByAsc(String name){
		return query(String.format("SELECT * FROM CONTACT_GROUP WHERE NAME like '%%s%' ORDER BY NAME ASC", String.valueOf(name)));
	}
	
	public List<ContactGroup> findAllByNameLikeOrderByDesc(String name){
		return query(String.format("SELECT * FROM CONTACT_GROUP WHERE NAME like '%%s%' ORDER BY NAME DESC", String.valueOf(name)));
	}
	public void updateStatus(long id, java.lang.Integer status) {
		queryExecute("UPDATE CONTACT_GROUP SET STATUS ='"+status+"' WHERE ID = "+id);
	}
	
	public void deleteByStatus(java.lang.Integer status) {
		queryExecute("DELETE CONTACT_GROUP WHERE STATUS = '"+status+"'");
	}
	
	public List<ContactGroup> findAllByStatus(Integer status){
		return query(String.format("SELECT * FROM CONTACT_GROUP WHERE STATUS = '%s'", String.valueOf(status)));
	}

	public List<ContactGroup> findAllByStatusOrderByAsc(Integer status){
		return query(String.format("SELECT * FROM CONTACT_GROUP WHERE STATUS = '%s' ORDER BY STATUS ASC", String.valueOf(status)));
	}

	public List<ContactGroup> findAllByStatusOrderByDesc(Integer status){
		return query(String.format("SELECT * FROM CONTACT_GROUP WHERE STATUS = '%s' ORDER BY STATUS DESC", String.valueOf(status)));
	}

	public List<ContactGroup> findAllByStatusLike(Integer status){
		return query(String.format("SELECT * FROM CONTACT_GROUP WHERE STATUS like '%%s%'", String.valueOf(status)));
	}
	
	public List<ContactGroup> findAllByStatusLikeOrderByAsc(Integer status){
		return query(String.format("SELECT * FROM CONTACT_GROUP WHERE STATUS like '%%s%' ORDER BY STATUS ASC", String.valueOf(status)));
	}
	
	public List<ContactGroup> findAllByStatusLikeOrderByDesc(Integer status){
		return query(String.format("SELECT * FROM CONTACT_GROUP WHERE STATUS like '%%s%' ORDER BY STATUS DESC", String.valueOf(status)));
	}
	public void updateCreatedOn(long id, java.time.LocalDateTime createdOn) {
		queryExecute("UPDATE CONTACT_GROUP SET CREATED_ON ='"+createdOn+"' WHERE ID = "+id);
	}
	
	public void deleteByCreatedOn(java.time.LocalDateTime createdOn) {
		queryExecute("DELETE CONTACT_GROUP WHERE CREATED_ON = '"+createdOn+"'");
	}
	
	public List<ContactGroup> findAllByCreatedOn(LocalDateTime createdOn){
		return query(String.format("SELECT * FROM CONTACT_GROUP WHERE CREATED_ON = '%s'", String.valueOf(createdOn)));
	}

	public List<ContactGroup> findAllByCreatedOnOrderByAsc(LocalDateTime createdOn){
		return query(String.format("SELECT * FROM CONTACT_GROUP WHERE CREATED_ON = '%s' ORDER BY CREATED_ON ASC", String.valueOf(createdOn)));
	}

	public List<ContactGroup> findAllByCreatedOnOrderByDesc(LocalDateTime createdOn){
		return query(String.format("SELECT * FROM CONTACT_GROUP WHERE CREATED_ON = '%s' ORDER BY CREATED_ON DESC", String.valueOf(createdOn)));
	}

	public List<ContactGroup> findAllByCreatedOnLike(LocalDateTime createdOn){
		return query(String.format("SELECT * FROM CONTACT_GROUP WHERE CREATED_ON like '%%s%'", String.valueOf(createdOn)));
	}
	
	public List<ContactGroup> findAllByCreatedOnLikeOrderByAsc(LocalDateTime createdOn){
		return query(String.format("SELECT * FROM CONTACT_GROUP WHERE CREATED_ON like '%%s%' ORDER BY CREATED_ON ASC", String.valueOf(createdOn)));
	}
	
	public List<ContactGroup> findAllByCreatedOnLikeOrderByDesc(LocalDateTime createdOn){
		return query(String.format("SELECT * FROM CONTACT_GROUP WHERE CREATED_ON like '%%s%' ORDER BY CREATED_ON DESC", String.valueOf(createdOn)));
	}
	public void updateUpdatedOn(long id, java.time.LocalDateTime updatedOn) {
		queryExecute("UPDATE CONTACT_GROUP SET UPDATED_ON ='"+updatedOn+"' WHERE ID = "+id);
	}
	
	public void deleteByUpdatedOn(java.time.LocalDateTime updatedOn) {
		queryExecute("DELETE CONTACT_GROUP WHERE UPDATED_ON = '"+updatedOn+"'");
	}
	
	public List<ContactGroup> findAllByUpdatedOn(LocalDateTime updatedOn){
		return query(String.format("SELECT * FROM CONTACT_GROUP WHERE UPDATED_ON = '%s'", String.valueOf(updatedOn)));
	}

	public List<ContactGroup> findAllByUpdatedOnOrderByAsc(LocalDateTime updatedOn){
		return query(String.format("SELECT * FROM CONTACT_GROUP WHERE UPDATED_ON = '%s' ORDER BY UPDATED_ON ASC", String.valueOf(updatedOn)));
	}

	public List<ContactGroup> findAllByUpdatedOnOrderByDesc(LocalDateTime updatedOn){
		return query(String.format("SELECT * FROM CONTACT_GROUP WHERE UPDATED_ON = '%s' ORDER BY UPDATED_ON DESC", String.valueOf(updatedOn)));
	}

	public List<ContactGroup> findAllByUpdatedOnLike(LocalDateTime updatedOn){
		return query(String.format("SELECT * FROM CONTACT_GROUP WHERE UPDATED_ON like '%%s%'", String.valueOf(updatedOn)));
	}
	
	public List<ContactGroup> findAllByUpdatedOnLikeOrderByAsc(LocalDateTime updatedOn){
		return query(String.format("SELECT * FROM CONTACT_GROUP WHERE UPDATED_ON like '%%s%' ORDER BY UPDATED_ON ASC", String.valueOf(updatedOn)));
	}
	
	public List<ContactGroup> findAllByUpdatedOnLikeOrderByDesc(LocalDateTime updatedOn){
		return query(String.format("SELECT * FROM CONTACT_GROUP WHERE UPDATED_ON like '%%s%' ORDER BY UPDATED_ON DESC", String.valueOf(updatedOn)));
	}
	
	@Override
	protected String findAllStatement() {
		return ContactGroupConstant.SQL_FIND_ALL;
	}
	
	@Override
	protected String findByIdStatement(long id) {
		return String.format(ContactGroupConstant.SQL_FIND_BY_ID, id);
	}

	@Override
	protected String saveStatement() {
		return ContactGroupConstant.SQL_INSERT;
	}

	@Override
	protected void prepareStatetmentForSave(ContactGroup t, PreparedStatement statement) throws SQLException {
		statement.setString(1, t.getName());
		statement.setInt(2, t.getStatus());
		statement.setTimestamp(3, Timestamp.valueOf(t.getCreatedOn()));
		statement.setTimestamp(4, Timestamp.valueOf(t.getUpdatedOn()));
	}

	@Override
	protected String updateStatement() {
		return ContactGroupConstant.SQL_MERGE;
	}

	@Override
	protected void prepareStatetmentForUpdate(ContactGroup t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getId());
		statement.setString(2, t.getName());
		statement.setInt(3, t.getStatus());
		statement.setTimestamp(4, Timestamp.valueOf(t.getCreatedOn()));
		statement.setTimestamp(5, Timestamp.valueOf(t.getUpdatedOn()));
	}

	@Override
	protected String deleteStatement() {
		return ContactGroupConstant.SQL_DELETE_BY_ID;
	}
	
	@Override
	protected void prepapreStatementForDelete(ContactGroup t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getId());
	}
}
