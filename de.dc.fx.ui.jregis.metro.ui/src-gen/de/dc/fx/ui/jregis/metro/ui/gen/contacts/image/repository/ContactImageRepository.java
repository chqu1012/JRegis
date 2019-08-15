package de.dc.fx.ui.jregis.metro.ui.gen.contacts.image.repository;

import java.sql.*;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.image.model.*;
import java.util.*;
import java.time.*;

public class ContactImageRepository extends BaseRepository<ContactImage>{

	@Override
	protected ContactImage map(ResultSet resultSet) throws SQLException{
		ContactImage contactImage = new ContactImage();
		contactImage.setId(resultSet.getLong("ID"));
		contactImage.setName(resultSet.getString("NAME"));
		contactImage.setStatus(resultSet.getInt("STATUS"));
		contactImage.setCreatedOn(resultSet.getTimestamp("CREATED_ON").toLocalDateTime());
		contactImage.setUpdatedOn(resultSet.getTimestamp("UPDATED_ON").toLocalDateTime());
		return contactImage;
	}
	
	public void updateName(long id, java.lang.String name) {
		queryExecute("UPDATE CONTACT_IMAGE SET NAME ='"+name+"' WHERE ID = "+id);
	}
	
	public void deleteByName(java.lang.String name) {
		queryExecute("DELETE CONTACT_IMAGE WHERE NAME = '"+name+"'");
	}
	
	public List<ContactImage> findAllByName(String name){
		return query(String.format("SELECT * FROM CONTACT_IMAGE WHERE NAME = '%s'", String.valueOf(name)));
	}

	public List<ContactImage> findAllByNameOrderByAsc(String name){
		return query(String.format("SELECT * FROM CONTACT_IMAGE WHERE NAME = '%s' ORDER BY NAME ASC", String.valueOf(name)));
	}

	public List<ContactImage> findAllByNameOrderByDesc(String name){
		return query(String.format("SELECT * FROM CONTACT_IMAGE WHERE NAME = '%s' ORDER BY NAME DESC", String.valueOf(name)));
	}

	public List<ContactImage> findAllByNameLike(String name){
		return query(String.format("SELECT * FROM CONTACT_IMAGE WHERE NAME like '%%s%'", String.valueOf(name)));
	}
	
	public List<ContactImage> findAllByNameLikeOrderByAsc(String name){
		return query(String.format("SELECT * FROM CONTACT_IMAGE WHERE NAME like '%%s%' ORDER BY NAME ASC", String.valueOf(name)));
	}
	
	public List<ContactImage> findAllByNameLikeOrderByDesc(String name){
		return query(String.format("SELECT * FROM CONTACT_IMAGE WHERE NAME like '%%s%' ORDER BY NAME DESC", String.valueOf(name)));
	}
	public void updateStatus(long id, java.lang.Integer status) {
		queryExecute("UPDATE CONTACT_IMAGE SET STATUS ='"+status+"' WHERE ID = "+id);
	}
	
	public void deleteByStatus(java.lang.Integer status) {
		queryExecute("DELETE CONTACT_IMAGE WHERE STATUS = '"+status+"'");
	}
	
	public List<ContactImage> findAllByStatus(Integer status){
		return query(String.format("SELECT * FROM CONTACT_IMAGE WHERE STATUS = '%s'", String.valueOf(status)));
	}

	public List<ContactImage> findAllByStatusOrderByAsc(Integer status){
		return query(String.format("SELECT * FROM CONTACT_IMAGE WHERE STATUS = '%s' ORDER BY STATUS ASC", String.valueOf(status)));
	}

	public List<ContactImage> findAllByStatusOrderByDesc(Integer status){
		return query(String.format("SELECT * FROM CONTACT_IMAGE WHERE STATUS = '%s' ORDER BY STATUS DESC", String.valueOf(status)));
	}

	public List<ContactImage> findAllByStatusLike(Integer status){
		return query(String.format("SELECT * FROM CONTACT_IMAGE WHERE STATUS like '%%s%'", String.valueOf(status)));
	}
	
	public List<ContactImage> findAllByStatusLikeOrderByAsc(Integer status){
		return query(String.format("SELECT * FROM CONTACT_IMAGE WHERE STATUS like '%%s%' ORDER BY STATUS ASC", String.valueOf(status)));
	}
	
	public List<ContactImage> findAllByStatusLikeOrderByDesc(Integer status){
		return query(String.format("SELECT * FROM CONTACT_IMAGE WHERE STATUS like '%%s%' ORDER BY STATUS DESC", String.valueOf(status)));
	}
	public void updateCreatedOn(long id, java.time.LocalDateTime createdOn) {
		queryExecute("UPDATE CONTACT_IMAGE SET CREATED_ON ='"+createdOn+"' WHERE ID = "+id);
	}
	
	public void deleteByCreatedOn(java.time.LocalDateTime createdOn) {
		queryExecute("DELETE CONTACT_IMAGE WHERE CREATED_ON = '"+createdOn+"'");
	}
	
	public List<ContactImage> findAllByCreatedOn(LocalDateTime createdOn){
		return query(String.format("SELECT * FROM CONTACT_IMAGE WHERE CREATED_ON = '%s'", String.valueOf(createdOn)));
	}

	public List<ContactImage> findAllByCreatedOnOrderByAsc(LocalDateTime createdOn){
		return query(String.format("SELECT * FROM CONTACT_IMAGE WHERE CREATED_ON = '%s' ORDER BY CREATED_ON ASC", String.valueOf(createdOn)));
	}

	public List<ContactImage> findAllByCreatedOnOrderByDesc(LocalDateTime createdOn){
		return query(String.format("SELECT * FROM CONTACT_IMAGE WHERE CREATED_ON = '%s' ORDER BY CREATED_ON DESC", String.valueOf(createdOn)));
	}

	public List<ContactImage> findAllByCreatedOnLike(LocalDateTime createdOn){
		return query(String.format("SELECT * FROM CONTACT_IMAGE WHERE CREATED_ON like '%%s%'", String.valueOf(createdOn)));
	}
	
	public List<ContactImage> findAllByCreatedOnLikeOrderByAsc(LocalDateTime createdOn){
		return query(String.format("SELECT * FROM CONTACT_IMAGE WHERE CREATED_ON like '%%s%' ORDER BY CREATED_ON ASC", String.valueOf(createdOn)));
	}
	
	public List<ContactImage> findAllByCreatedOnLikeOrderByDesc(LocalDateTime createdOn){
		return query(String.format("SELECT * FROM CONTACT_IMAGE WHERE CREATED_ON like '%%s%' ORDER BY CREATED_ON DESC", String.valueOf(createdOn)));
	}
	public void updateUpdatedOn(long id, java.time.LocalDateTime updatedOn) {
		queryExecute("UPDATE CONTACT_IMAGE SET UPDATED_ON ='"+updatedOn+"' WHERE ID = "+id);
	}
	
	public void deleteByUpdatedOn(java.time.LocalDateTime updatedOn) {
		queryExecute("DELETE CONTACT_IMAGE WHERE UPDATED_ON = '"+updatedOn+"'");
	}
	
	public List<ContactImage> findAllByUpdatedOn(LocalDateTime updatedOn){
		return query(String.format("SELECT * FROM CONTACT_IMAGE WHERE UPDATED_ON = '%s'", String.valueOf(updatedOn)));
	}

	public List<ContactImage> findAllByUpdatedOnOrderByAsc(LocalDateTime updatedOn){
		return query(String.format("SELECT * FROM CONTACT_IMAGE WHERE UPDATED_ON = '%s' ORDER BY UPDATED_ON ASC", String.valueOf(updatedOn)));
	}

	public List<ContactImage> findAllByUpdatedOnOrderByDesc(LocalDateTime updatedOn){
		return query(String.format("SELECT * FROM CONTACT_IMAGE WHERE UPDATED_ON = '%s' ORDER BY UPDATED_ON DESC", String.valueOf(updatedOn)));
	}

	public List<ContactImage> findAllByUpdatedOnLike(LocalDateTime updatedOn){
		return query(String.format("SELECT * FROM CONTACT_IMAGE WHERE UPDATED_ON like '%%s%'", String.valueOf(updatedOn)));
	}
	
	public List<ContactImage> findAllByUpdatedOnLikeOrderByAsc(LocalDateTime updatedOn){
		return query(String.format("SELECT * FROM CONTACT_IMAGE WHERE UPDATED_ON like '%%s%' ORDER BY UPDATED_ON ASC", String.valueOf(updatedOn)));
	}
	
	public List<ContactImage> findAllByUpdatedOnLikeOrderByDesc(LocalDateTime updatedOn){
		return query(String.format("SELECT * FROM CONTACT_IMAGE WHERE UPDATED_ON like '%%s%' ORDER BY UPDATED_ON DESC", String.valueOf(updatedOn)));
	}
	
	@Override
	protected String findAllStatement() {
		return ContactImageConstant.SQL_FIND_ALL;
	}
	
	@Override
	protected String findByIdStatement(long id) {
		return String.format(ContactImageConstant.SQL_FIND_BY_ID, id);
	}

	@Override
	protected String saveStatement() {
		return ContactImageConstant.SQL_INSERT;
	}

	@Override
	protected void prepareStatetmentForSave(ContactImage t, PreparedStatement statement) throws SQLException {
		statement.setString(1, t.getName());
		statement.setInt(2, t.getStatus());
		statement.setTimestamp(3, Timestamp.valueOf(t.getCreatedOn()));
		statement.setTimestamp(4, Timestamp.valueOf(t.getUpdatedOn()));
	}

	@Override
	protected String updateStatement() {
		return ContactImageConstant.SQL_MERGE;
	}

	@Override
	protected void prepareStatetmentForUpdate(ContactImage t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getId());
		statement.setString(2, t.getName());
		statement.setInt(3, t.getStatus());
		statement.setTimestamp(4, Timestamp.valueOf(t.getCreatedOn()));
		statement.setTimestamp(5, Timestamp.valueOf(t.getUpdatedOn()));
	}

	@Override
	protected String deleteStatement() {
		return ContactImageConstant.SQL_DELETE_BY_ID;
	}
	
	@Override
	protected void prepapreStatementForDelete(ContactImage t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getId());
	}
}
