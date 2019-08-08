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
		return dates;
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
