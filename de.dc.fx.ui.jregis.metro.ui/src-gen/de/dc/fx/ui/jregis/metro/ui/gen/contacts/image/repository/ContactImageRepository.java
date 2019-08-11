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
		contactImage.setCreatedOn(resultSet.getTimestamp("CREATED_ON").toLocalDateTime());
		return contactImage;
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
		statement.setTimestamp(2, Timestamp.valueOf(t.getCreatedOn()));
	}

	@Override
	protected String updateStatement() {
		return ContactImageConstant.SQL_MERGE;
	}

	@Override
	protected void prepareStatetmentForUpdate(ContactImage t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getId());
		statement.setString(2, t.getName());
		statement.setTimestamp(3, Timestamp.valueOf(t.getCreatedOn()));
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
