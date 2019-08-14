package de.dc.fx.ui.jregis.metro.ui.gen.contacts.dates.repository;

import java.sql.*;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.dates.model.*;
import java.util.*;
import java.time.*;

public class DatesRepository extends BaseRepository<Dates>{

	@Override
	protected Dates map(ResultSet resultSet) throws SQLException{
		Dates dates = new Dates();
		dates.setId(resultSet.getLong("ID"));
		dates.setContactId(resultSet.getLong("CONTACT_ID"));
		dates.setName(resultSet.getString("NAME"));
		dates.setDate(resultSet.getTimestamp("DATE").toLocalDateTime());
		dates.setStatus(resultSet.getInt("STATUS"));
		dates.setCreatedOn(resultSet.getTimestamp("CREATED_ON").toLocalDateTime());
		dates.setUpdatedOn(resultSet.getTimestamp("UPDATED_ON").toLocalDateTime());
		return dates;
	}
	
	public void updateContactId(long id, java.lang.Long contactId) {
		query("UPDATE DATES SET CONTACT_ID ='"+contactId+"' WHERE ID = "+id);
	}
	
	public List<Dates> findAllByContactId(Long contactId){
		return query(String.format("SELECT * FROM DATES WHERE CONTACT_ID = '%s'", String.valueOf(contactId)));
	}

	public List<Dates> findAllByContactIdOrderByAsc(Long contactId){
		return query(String.format("SELECT * FROM DATES WHERE CONTACT_ID = '%s' ORDER BY CONTACT_ID ASC", String.valueOf(contactId)));
	}

	public List<Dates> findAllByContactIdOrderByDesc(Long contactId){
		return query(String.format("SELECT * FROM DATES WHERE CONTACT_ID = '%s' ORDER BY CONTACT_ID DESC", String.valueOf(contactId)));
	}

	public List<Dates> findAllByContactIdLike(Long contactId){
		return query(String.format("SELECT * FROM DATES WHERE CONTACT_ID like '%%s%'", String.valueOf(contactId)));
	}
	
	public List<Dates> findAllByContactIdLikeOrderByAsc(Long contactId){
		return query(String.format("SELECT * FROM DATES WHERE CONTACT_ID like '%%s%' ORDER BY CONTACT_ID ASC", String.valueOf(contactId)));
	}
	
	public List<Dates> findAllByContactIdLikeOrderByDesc(Long contactId){
		return query(String.format("SELECT * FROM DATES WHERE CONTACT_ID like '%%s%' ORDER BY CONTACT_ID DESC", String.valueOf(contactId)));
	}
	public void updateName(long id, java.lang.String name) {
		query("UPDATE DATES SET NAME ='"+name+"' WHERE ID = "+id);
	}
	
	public List<Dates> findAllByName(String name){
		return query(String.format("SELECT * FROM DATES WHERE NAME = '%s'", String.valueOf(name)));
	}

	public List<Dates> findAllByNameOrderByAsc(String name){
		return query(String.format("SELECT * FROM DATES WHERE NAME = '%s' ORDER BY NAME ASC", String.valueOf(name)));
	}

	public List<Dates> findAllByNameOrderByDesc(String name){
		return query(String.format("SELECT * FROM DATES WHERE NAME = '%s' ORDER BY NAME DESC", String.valueOf(name)));
	}

	public List<Dates> findAllByNameLike(String name){
		return query(String.format("SELECT * FROM DATES WHERE NAME like '%%s%'", String.valueOf(name)));
	}
	
	public List<Dates> findAllByNameLikeOrderByAsc(String name){
		return query(String.format("SELECT * FROM DATES WHERE NAME like '%%s%' ORDER BY NAME ASC", String.valueOf(name)));
	}
	
	public List<Dates> findAllByNameLikeOrderByDesc(String name){
		return query(String.format("SELECT * FROM DATES WHERE NAME like '%%s%' ORDER BY NAME DESC", String.valueOf(name)));
	}
	public void updateDate(long id, java.time.LocalDateTime date) {
		query("UPDATE DATES SET DATE ='"+date+"' WHERE ID = "+id);
	}
	
	public List<Dates> findAllByDate(LocalDateTime date){
		return query(String.format("SELECT * FROM DATES WHERE DATE = '%s'", String.valueOf(date)));
	}

	public List<Dates> findAllByDateOrderByAsc(LocalDateTime date){
		return query(String.format("SELECT * FROM DATES WHERE DATE = '%s' ORDER BY DATE ASC", String.valueOf(date)));
	}

	public List<Dates> findAllByDateOrderByDesc(LocalDateTime date){
		return query(String.format("SELECT * FROM DATES WHERE DATE = '%s' ORDER BY DATE DESC", String.valueOf(date)));
	}

	public List<Dates> findAllByDateLike(LocalDateTime date){
		return query(String.format("SELECT * FROM DATES WHERE DATE like '%%s%'", String.valueOf(date)));
	}
	
	public List<Dates> findAllByDateLikeOrderByAsc(LocalDateTime date){
		return query(String.format("SELECT * FROM DATES WHERE DATE like '%%s%' ORDER BY DATE ASC", String.valueOf(date)));
	}
	
	public List<Dates> findAllByDateLikeOrderByDesc(LocalDateTime date){
		return query(String.format("SELECT * FROM DATES WHERE DATE like '%%s%' ORDER BY DATE DESC", String.valueOf(date)));
	}
	public void updateStatus(long id, java.lang.Integer status) {
		query("UPDATE DATES SET STATUS ='"+status+"' WHERE ID = "+id);
	}
	
	public List<Dates> findAllByStatus(Integer status){
		return query(String.format("SELECT * FROM DATES WHERE STATUS = '%s'", String.valueOf(status)));
	}

	public List<Dates> findAllByStatusOrderByAsc(Integer status){
		return query(String.format("SELECT * FROM DATES WHERE STATUS = '%s' ORDER BY STATUS ASC", String.valueOf(status)));
	}

	public List<Dates> findAllByStatusOrderByDesc(Integer status){
		return query(String.format("SELECT * FROM DATES WHERE STATUS = '%s' ORDER BY STATUS DESC", String.valueOf(status)));
	}

	public List<Dates> findAllByStatusLike(Integer status){
		return query(String.format("SELECT * FROM DATES WHERE STATUS like '%%s%'", String.valueOf(status)));
	}
	
	public List<Dates> findAllByStatusLikeOrderByAsc(Integer status){
		return query(String.format("SELECT * FROM DATES WHERE STATUS like '%%s%' ORDER BY STATUS ASC", String.valueOf(status)));
	}
	
	public List<Dates> findAllByStatusLikeOrderByDesc(Integer status){
		return query(String.format("SELECT * FROM DATES WHERE STATUS like '%%s%' ORDER BY STATUS DESC", String.valueOf(status)));
	}
	public void updateCreatedOn(long id, java.time.LocalDateTime createdOn) {
		query("UPDATE DATES SET CREATED_ON ='"+createdOn+"' WHERE ID = "+id);
	}
	
	public List<Dates> findAllByCreatedOn(LocalDateTime createdOn){
		return query(String.format("SELECT * FROM DATES WHERE CREATED_ON = '%s'", String.valueOf(createdOn)));
	}

	public List<Dates> findAllByCreatedOnOrderByAsc(LocalDateTime createdOn){
		return query(String.format("SELECT * FROM DATES WHERE CREATED_ON = '%s' ORDER BY CREATED_ON ASC", String.valueOf(createdOn)));
	}

	public List<Dates> findAllByCreatedOnOrderByDesc(LocalDateTime createdOn){
		return query(String.format("SELECT * FROM DATES WHERE CREATED_ON = '%s' ORDER BY CREATED_ON DESC", String.valueOf(createdOn)));
	}

	public List<Dates> findAllByCreatedOnLike(LocalDateTime createdOn){
		return query(String.format("SELECT * FROM DATES WHERE CREATED_ON like '%%s%'", String.valueOf(createdOn)));
	}
	
	public List<Dates> findAllByCreatedOnLikeOrderByAsc(LocalDateTime createdOn){
		return query(String.format("SELECT * FROM DATES WHERE CREATED_ON like '%%s%' ORDER BY CREATED_ON ASC", String.valueOf(createdOn)));
	}
	
	public List<Dates> findAllByCreatedOnLikeOrderByDesc(LocalDateTime createdOn){
		return query(String.format("SELECT * FROM DATES WHERE CREATED_ON like '%%s%' ORDER BY CREATED_ON DESC", String.valueOf(createdOn)));
	}
	public void updateUpdatedOn(long id, java.time.LocalDateTime updatedOn) {
		query("UPDATE DATES SET UPDATED_ON ='"+updatedOn+"' WHERE ID = "+id);
	}
	
	public List<Dates> findAllByUpdatedOn(LocalDateTime updatedOn){
		return query(String.format("SELECT * FROM DATES WHERE UPDATED_ON = '%s'", String.valueOf(updatedOn)));
	}

	public List<Dates> findAllByUpdatedOnOrderByAsc(LocalDateTime updatedOn){
		return query(String.format("SELECT * FROM DATES WHERE UPDATED_ON = '%s' ORDER BY UPDATED_ON ASC", String.valueOf(updatedOn)));
	}

	public List<Dates> findAllByUpdatedOnOrderByDesc(LocalDateTime updatedOn){
		return query(String.format("SELECT * FROM DATES WHERE UPDATED_ON = '%s' ORDER BY UPDATED_ON DESC", String.valueOf(updatedOn)));
	}

	public List<Dates> findAllByUpdatedOnLike(LocalDateTime updatedOn){
		return query(String.format("SELECT * FROM DATES WHERE UPDATED_ON like '%%s%'", String.valueOf(updatedOn)));
	}
	
	public List<Dates> findAllByUpdatedOnLikeOrderByAsc(LocalDateTime updatedOn){
		return query(String.format("SELECT * FROM DATES WHERE UPDATED_ON like '%%s%' ORDER BY UPDATED_ON ASC", String.valueOf(updatedOn)));
	}
	
	public List<Dates> findAllByUpdatedOnLikeOrderByDesc(LocalDateTime updatedOn){
		return query(String.format("SELECT * FROM DATES WHERE UPDATED_ON like '%%s%' ORDER BY UPDATED_ON DESC", String.valueOf(updatedOn)));
	}
	
	@Override
	protected String findAllStatement() {
		return DatesConstant.SQL_FIND_ALL;
	}
	
	@Override
	protected String findByIdStatement(long id) {
		return String.format(DatesConstant.SQL_FIND_BY_ID, id);
	}

	@Override
	protected String saveStatement() {
		return DatesConstant.SQL_INSERT;
	}

	@Override
	protected void prepareStatetmentForSave(Dates t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getContactId());
		statement.setString(2, t.getName());
		statement.setTimestamp(3, Timestamp.valueOf(t.getDate()));
		statement.setInt(4, t.getStatus());
		statement.setTimestamp(5, Timestamp.valueOf(t.getCreatedOn()));
		statement.setTimestamp(6, Timestamp.valueOf(t.getUpdatedOn()));
	}

	@Override
	protected String updateStatement() {
		return DatesConstant.SQL_MERGE;
	}

	@Override
	protected void prepareStatetmentForUpdate(Dates t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getId());
		statement.setLong(2, t.getContactId());
		statement.setString(3, t.getName());
		statement.setTimestamp(4, Timestamp.valueOf(t.getDate()));
		statement.setInt(5, t.getStatus());
		statement.setTimestamp(6, Timestamp.valueOf(t.getCreatedOn()));
		statement.setTimestamp(7, Timestamp.valueOf(t.getUpdatedOn()));
	}

	@Override
	protected String deleteStatement() {
		return DatesConstant.SQL_DELETE_BY_ID;
	}
	
	@Override
	protected void prepapreStatementForDelete(Dates t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getId());
	}
}
