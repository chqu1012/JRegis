package de.dc.fx.ui.jregis.metro.ui.gen.calendar.appointment.repository;

import java.sql.*;
import de.dc.fx.ui.jregis.metro.ui.gen.calendar.appointment.model.*;
import java.util.*;
import java.time.*;

public class XAppointmentRepository extends BaseRepository<XAppointment>{

	@Override
	protected XAppointment map(ResultSet resultSet) throws SQLException{
		XAppointment xAppointment = new XAppointment();
		xAppointment.setId(resultSet.getLong("ID"));
		xAppointment.setContactId(resultSet.getLong("CONTACT_ID"));
		xAppointment.setTopic(resultSet.getString("TOPIC"));
		xAppointment.setSummary(resultSet.getString("SUMMARY"));
		xAppointment.setStart(resultSet.getTimestamp("START").toLocalDateTime());
		xAppointment.setEnd(resultSet.getTimestamp("END").toLocalDateTime());
		xAppointment.setAppointmentGroupId(resultSet.getLong("APPOINTMENT_GROUP_ID"));
		return xAppointment;
	}
	
	public List<XAppointment> findAllByContactId(Long contactId){
		return query(String.format("SELECT * FROM X_APPOINTMENT WHERE CONTACT_ID = '%s'", String.valueOf(contactId)));
	}

	public List<XAppointment> findAllByContactIdOrderByAsc(Long contactId){
		return query(String.format("SELECT * FROM X_APPOINTMENT WHERE CONTACT_ID = '%s' ORDER BY CONTACT_ID ASC", String.valueOf(contactId)));
	}

	public List<XAppointment> findAllByContactIdOrderByDesc(Long contactId){
		return query(String.format("SELECT * FROM X_APPOINTMENT WHERE CONTACT_ID = '%s' ORDER BY CONTACT_ID DESC", String.valueOf(contactId)));
	}

	public List<XAppointment> findAllByContactIdLike(Long contactId){
		return query(String.format("SELECT * FROM X_APPOINTMENT WHERE CONTACT_ID like '%%s%'", String.valueOf(contactId)));
	}
	
	public List<XAppointment> findAllByContactIdLikeOrderByAsc(Long contactId){
		return query(String.format("SELECT * FROM X_APPOINTMENT WHERE CONTACT_ID like '%%s%' ORDER BY CONTACT_ID ASC", String.valueOf(contactId)));
	}
	
	public List<XAppointment> findAllByContactIdLikeOrderByDesc(Long contactId){
		return query(String.format("SELECT * FROM X_APPOINTMENT WHERE CONTACT_ID like '%%s%' ORDER BY CONTACT_ID DESC", String.valueOf(contactId)));
	}
	public List<XAppointment> findAllByTopic(String topic){
		return query(String.format("SELECT * FROM X_APPOINTMENT WHERE TOPIC = '%s'", String.valueOf(topic)));
	}

	public List<XAppointment> findAllByTopicOrderByAsc(String topic){
		return query(String.format("SELECT * FROM X_APPOINTMENT WHERE TOPIC = '%s' ORDER BY TOPIC ASC", String.valueOf(topic)));
	}

	public List<XAppointment> findAllByTopicOrderByDesc(String topic){
		return query(String.format("SELECT * FROM X_APPOINTMENT WHERE TOPIC = '%s' ORDER BY TOPIC DESC", String.valueOf(topic)));
	}

	public List<XAppointment> findAllByTopicLike(String topic){
		return query(String.format("SELECT * FROM X_APPOINTMENT WHERE TOPIC like '%%s%'", String.valueOf(topic)));
	}
	
	public List<XAppointment> findAllByTopicLikeOrderByAsc(String topic){
		return query(String.format("SELECT * FROM X_APPOINTMENT WHERE TOPIC like '%%s%' ORDER BY TOPIC ASC", String.valueOf(topic)));
	}
	
	public List<XAppointment> findAllByTopicLikeOrderByDesc(String topic){
		return query(String.format("SELECT * FROM X_APPOINTMENT WHERE TOPIC like '%%s%' ORDER BY TOPIC DESC", String.valueOf(topic)));
	}
	public List<XAppointment> findAllBySummary(String summary){
		return query(String.format("SELECT * FROM X_APPOINTMENT WHERE SUMMARY = '%s'", String.valueOf(summary)));
	}

	public List<XAppointment> findAllBySummaryOrderByAsc(String summary){
		return query(String.format("SELECT * FROM X_APPOINTMENT WHERE SUMMARY = '%s' ORDER BY SUMMARY ASC", String.valueOf(summary)));
	}

	public List<XAppointment> findAllBySummaryOrderByDesc(String summary){
		return query(String.format("SELECT * FROM X_APPOINTMENT WHERE SUMMARY = '%s' ORDER BY SUMMARY DESC", String.valueOf(summary)));
	}

	public List<XAppointment> findAllBySummaryLike(String summary){
		return query(String.format("SELECT * FROM X_APPOINTMENT WHERE SUMMARY like '%%s%'", String.valueOf(summary)));
	}
	
	public List<XAppointment> findAllBySummaryLikeOrderByAsc(String summary){
		return query(String.format("SELECT * FROM X_APPOINTMENT WHERE SUMMARY like '%%s%' ORDER BY SUMMARY ASC", String.valueOf(summary)));
	}
	
	public List<XAppointment> findAllBySummaryLikeOrderByDesc(String summary){
		return query(String.format("SELECT * FROM X_APPOINTMENT WHERE SUMMARY like '%%s%' ORDER BY SUMMARY DESC", String.valueOf(summary)));
	}
	public List<XAppointment> findAllByStart(LocalDateTime start){
		return query(String.format("SELECT * FROM X_APPOINTMENT WHERE START = '%s'", String.valueOf(start)));
	}

	public List<XAppointment> findAllByStartOrderByAsc(LocalDateTime start){
		return query(String.format("SELECT * FROM X_APPOINTMENT WHERE START = '%s' ORDER BY START ASC", String.valueOf(start)));
	}

	public List<XAppointment> findAllByStartOrderByDesc(LocalDateTime start){
		return query(String.format("SELECT * FROM X_APPOINTMENT WHERE START = '%s' ORDER BY START DESC", String.valueOf(start)));
	}

	public List<XAppointment> findAllByStartLike(LocalDateTime start){
		return query(String.format("SELECT * FROM X_APPOINTMENT WHERE START like '%%s%'", String.valueOf(start)));
	}
	
	public List<XAppointment> findAllByStartLikeOrderByAsc(LocalDateTime start){
		return query(String.format("SELECT * FROM X_APPOINTMENT WHERE START like '%%s%' ORDER BY START ASC", String.valueOf(start)));
	}
	
	public List<XAppointment> findAllByStartLikeOrderByDesc(LocalDateTime start){
		return query(String.format("SELECT * FROM X_APPOINTMENT WHERE START like '%%s%' ORDER BY START DESC", String.valueOf(start)));
	}
	public List<XAppointment> findAllByEnd(LocalDateTime end){
		return query(String.format("SELECT * FROM X_APPOINTMENT WHERE END = '%s'", String.valueOf(end)));
	}

	public List<XAppointment> findAllByEndOrderByAsc(LocalDateTime end){
		return query(String.format("SELECT * FROM X_APPOINTMENT WHERE END = '%s' ORDER BY END ASC", String.valueOf(end)));
	}

	public List<XAppointment> findAllByEndOrderByDesc(LocalDateTime end){
		return query(String.format("SELECT * FROM X_APPOINTMENT WHERE END = '%s' ORDER BY END DESC", String.valueOf(end)));
	}

	public List<XAppointment> findAllByEndLike(LocalDateTime end){
		return query(String.format("SELECT * FROM X_APPOINTMENT WHERE END like '%%s%'", String.valueOf(end)));
	}
	
	public List<XAppointment> findAllByEndLikeOrderByAsc(LocalDateTime end){
		return query(String.format("SELECT * FROM X_APPOINTMENT WHERE END like '%%s%' ORDER BY END ASC", String.valueOf(end)));
	}
	
	public List<XAppointment> findAllByEndLikeOrderByDesc(LocalDateTime end){
		return query(String.format("SELECT * FROM X_APPOINTMENT WHERE END like '%%s%' ORDER BY END DESC", String.valueOf(end)));
	}
	public List<XAppointment> findAllByAppointmentGroupId(Long appointmentGroupId){
		return query(String.format("SELECT * FROM X_APPOINTMENT WHERE APPOINTMENT_GROUP_ID = '%s'", String.valueOf(appointmentGroupId)));
	}

	public List<XAppointment> findAllByAppointmentGroupIdOrderByAsc(Long appointmentGroupId){
		return query(String.format("SELECT * FROM X_APPOINTMENT WHERE APPOINTMENT_GROUP_ID = '%s' ORDER BY APPOINTMENT_GROUP_ID ASC", String.valueOf(appointmentGroupId)));
	}

	public List<XAppointment> findAllByAppointmentGroupIdOrderByDesc(Long appointmentGroupId){
		return query(String.format("SELECT * FROM X_APPOINTMENT WHERE APPOINTMENT_GROUP_ID = '%s' ORDER BY APPOINTMENT_GROUP_ID DESC", String.valueOf(appointmentGroupId)));
	}

	public List<XAppointment> findAllByAppointmentGroupIdLike(Long appointmentGroupId){
		return query(String.format("SELECT * FROM X_APPOINTMENT WHERE APPOINTMENT_GROUP_ID like '%%s%'", String.valueOf(appointmentGroupId)));
	}
	
	public List<XAppointment> findAllByAppointmentGroupIdLikeOrderByAsc(Long appointmentGroupId){
		return query(String.format("SELECT * FROM X_APPOINTMENT WHERE APPOINTMENT_GROUP_ID like '%%s%' ORDER BY APPOINTMENT_GROUP_ID ASC", String.valueOf(appointmentGroupId)));
	}
	
	public List<XAppointment> findAllByAppointmentGroupIdLikeOrderByDesc(Long appointmentGroupId){
		return query(String.format("SELECT * FROM X_APPOINTMENT WHERE APPOINTMENT_GROUP_ID like '%%s%' ORDER BY APPOINTMENT_GROUP_ID DESC", String.valueOf(appointmentGroupId)));
	}
	
	@Override
	protected String findAllStatement() {
		return XAppointmentConstant.SQL_FIND_ALL;
	}
	
	@Override
	protected String findByIdStatement(long id) {
		return String.format(XAppointmentConstant.SQL_FIND_BY_ID, id);
	}

	@Override
	protected String saveStatement() {
		return XAppointmentConstant.SQL_INSERT;
	}

	@Override
	protected void prepareStatetmentForSave(XAppointment t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getContactId());
		statement.setString(2, t.getTopic());
		statement.setString(3, t.getSummary());
		statement.setTimestamp(4, Timestamp.valueOf(t.getStart()));
		statement.setTimestamp(5, Timestamp.valueOf(t.getEnd()));
		statement.setLong(6, t.getAppointmentGroupId());
	}

	@Override
	protected String updateStatement() {
		return XAppointmentConstant.SQL_MERGE;
	}

	@Override
	protected void prepareStatetmentForUpdate(XAppointment t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getId());
		statement.setLong(2, t.getContactId());
		statement.setString(3, t.getTopic());
		statement.setString(4, t.getSummary());
		statement.setTimestamp(5, Timestamp.valueOf(t.getStart()));
		statement.setTimestamp(6, Timestamp.valueOf(t.getEnd()));
		statement.setLong(7, t.getAppointmentGroupId());
	}

	@Override
	protected String deleteStatement() {
		return XAppointmentConstant.SQL_DELETE_BY_ID;
	}
	
	@Override
	protected void prepapreStatementForDelete(XAppointment t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getId());
	}
}
