package de.dc.fx.ui.jregis.metro.ui.gen.calendar.group.repository;

import java.sql.*;
import de.dc.fx.ui.jregis.metro.ui.gen.calendar.group.model.*;
import java.util.*;
import java.time.*;

public class XAppointmentGroupRepository extends BaseRepository<XAppointmentGroup>{

	@Override
	protected XAppointmentGroup map(ResultSet resultSet) throws SQLException{
		XAppointmentGroup xAppointmentGroup = new XAppointmentGroup();
		xAppointmentGroup.setId(resultSet.getLong("ID"));
		xAppointmentGroup.setAppointmentId(resultSet.getLong("APPOINTMENT_ID"));
		xAppointmentGroup.setTopic(resultSet.getString("TOPIC"));
		xAppointmentGroup.setSummary(resultSet.getString("SUMMARY"));
		xAppointmentGroup.setStart(resultSet.getTimestamp("START").toLocalDateTime());
		xAppointmentGroup.setEnd(resultSet.getTimestamp("END").toLocalDateTime());
		xAppointmentGroup.setAppointmentGroupId(resultSet.getInt("APPOINTMENT_GROUP_ID"));
		return xAppointmentGroup;
	}
	
	public List<XAppointmentGroup> findAllByAppointmentId(Long appointmentId){
		return query(String.format("SELECT * FROM X_APPOINTMENT_GROUP WHERE APPOINTMENT_ID = '%s'", String.valueOf(appointmentId)));
	}

	public List<XAppointmentGroup> findAllByAppointmentIdOrderByAsc(Long appointmentId){
		return query(String.format("SELECT * FROM X_APPOINTMENT_GROUP WHERE APPOINTMENT_ID = '%s' ORDER BY APPOINTMENT_ID ASC", String.valueOf(appointmentId)));
	}

	public List<XAppointmentGroup> findAllByAppointmentIdOrderByDesc(Long appointmentId){
		return query(String.format("SELECT * FROM X_APPOINTMENT_GROUP WHERE APPOINTMENT_ID = '%s' ORDER BY APPOINTMENT_ID DESC", String.valueOf(appointmentId)));
	}

	public List<XAppointmentGroup> findAllByAppointmentIdLike(Long appointmentId){
		return query(String.format("SELECT * FROM X_APPOINTMENT_GROUP WHERE APPOINTMENT_ID like '%%s%'", String.valueOf(appointmentId)));
	}
	
	public List<XAppointmentGroup> findAllByAppointmentIdLikeOrderByAsc(Long appointmentId){
		return query(String.format("SELECT * FROM X_APPOINTMENT_GROUP WHERE APPOINTMENT_ID like '%%s%' ORDER BY APPOINTMENT_ID ASC", String.valueOf(appointmentId)));
	}
	
	public List<XAppointmentGroup> findAllByAppointmentIdLikeOrderByDesc(Long appointmentId){
		return query(String.format("SELECT * FROM X_APPOINTMENT_GROUP WHERE APPOINTMENT_ID like '%%s%' ORDER BY APPOINTMENT_ID DESC", String.valueOf(appointmentId)));
	}
	public List<XAppointmentGroup> findAllByTopic(String topic){
		return query(String.format("SELECT * FROM X_APPOINTMENT_GROUP WHERE TOPIC = '%s'", String.valueOf(topic)));
	}

	public List<XAppointmentGroup> findAllByTopicOrderByAsc(String topic){
		return query(String.format("SELECT * FROM X_APPOINTMENT_GROUP WHERE TOPIC = '%s' ORDER BY TOPIC ASC", String.valueOf(topic)));
	}

	public List<XAppointmentGroup> findAllByTopicOrderByDesc(String topic){
		return query(String.format("SELECT * FROM X_APPOINTMENT_GROUP WHERE TOPIC = '%s' ORDER BY TOPIC DESC", String.valueOf(topic)));
	}

	public List<XAppointmentGroup> findAllByTopicLike(String topic){
		return query(String.format("SELECT * FROM X_APPOINTMENT_GROUP WHERE TOPIC like '%%s%'", String.valueOf(topic)));
	}
	
	public List<XAppointmentGroup> findAllByTopicLikeOrderByAsc(String topic){
		return query(String.format("SELECT * FROM X_APPOINTMENT_GROUP WHERE TOPIC like '%%s%' ORDER BY TOPIC ASC", String.valueOf(topic)));
	}
	
	public List<XAppointmentGroup> findAllByTopicLikeOrderByDesc(String topic){
		return query(String.format("SELECT * FROM X_APPOINTMENT_GROUP WHERE TOPIC like '%%s%' ORDER BY TOPIC DESC", String.valueOf(topic)));
	}
	public List<XAppointmentGroup> findAllBySummary(String summary){
		return query(String.format("SELECT * FROM X_APPOINTMENT_GROUP WHERE SUMMARY = '%s'", String.valueOf(summary)));
	}

	public List<XAppointmentGroup> findAllBySummaryOrderByAsc(String summary){
		return query(String.format("SELECT * FROM X_APPOINTMENT_GROUP WHERE SUMMARY = '%s' ORDER BY SUMMARY ASC", String.valueOf(summary)));
	}

	public List<XAppointmentGroup> findAllBySummaryOrderByDesc(String summary){
		return query(String.format("SELECT * FROM X_APPOINTMENT_GROUP WHERE SUMMARY = '%s' ORDER BY SUMMARY DESC", String.valueOf(summary)));
	}

	public List<XAppointmentGroup> findAllBySummaryLike(String summary){
		return query(String.format("SELECT * FROM X_APPOINTMENT_GROUP WHERE SUMMARY like '%%s%'", String.valueOf(summary)));
	}
	
	public List<XAppointmentGroup> findAllBySummaryLikeOrderByAsc(String summary){
		return query(String.format("SELECT * FROM X_APPOINTMENT_GROUP WHERE SUMMARY like '%%s%' ORDER BY SUMMARY ASC", String.valueOf(summary)));
	}
	
	public List<XAppointmentGroup> findAllBySummaryLikeOrderByDesc(String summary){
		return query(String.format("SELECT * FROM X_APPOINTMENT_GROUP WHERE SUMMARY like '%%s%' ORDER BY SUMMARY DESC", String.valueOf(summary)));
	}
	public List<XAppointmentGroup> findAllByStart(LocalDateTime start){
		return query(String.format("SELECT * FROM X_APPOINTMENT_GROUP WHERE START = '%s'", String.valueOf(start)));
	}

	public List<XAppointmentGroup> findAllByStartOrderByAsc(LocalDateTime start){
		return query(String.format("SELECT * FROM X_APPOINTMENT_GROUP WHERE START = '%s' ORDER BY START ASC", String.valueOf(start)));
	}

	public List<XAppointmentGroup> findAllByStartOrderByDesc(LocalDateTime start){
		return query(String.format("SELECT * FROM X_APPOINTMENT_GROUP WHERE START = '%s' ORDER BY START DESC", String.valueOf(start)));
	}

	public List<XAppointmentGroup> findAllByStartLike(LocalDateTime start){
		return query(String.format("SELECT * FROM X_APPOINTMENT_GROUP WHERE START like '%%s%'", String.valueOf(start)));
	}
	
	public List<XAppointmentGroup> findAllByStartLikeOrderByAsc(LocalDateTime start){
		return query(String.format("SELECT * FROM X_APPOINTMENT_GROUP WHERE START like '%%s%' ORDER BY START ASC", String.valueOf(start)));
	}
	
	public List<XAppointmentGroup> findAllByStartLikeOrderByDesc(LocalDateTime start){
		return query(String.format("SELECT * FROM X_APPOINTMENT_GROUP WHERE START like '%%s%' ORDER BY START DESC", String.valueOf(start)));
	}
	public List<XAppointmentGroup> findAllByEnd(LocalDateTime end){
		return query(String.format("SELECT * FROM X_APPOINTMENT_GROUP WHERE END = '%s'", String.valueOf(end)));
	}

	public List<XAppointmentGroup> findAllByEndOrderByAsc(LocalDateTime end){
		return query(String.format("SELECT * FROM X_APPOINTMENT_GROUP WHERE END = '%s' ORDER BY END ASC", String.valueOf(end)));
	}

	public List<XAppointmentGroup> findAllByEndOrderByDesc(LocalDateTime end){
		return query(String.format("SELECT * FROM X_APPOINTMENT_GROUP WHERE END = '%s' ORDER BY END DESC", String.valueOf(end)));
	}

	public List<XAppointmentGroup> findAllByEndLike(LocalDateTime end){
		return query(String.format("SELECT * FROM X_APPOINTMENT_GROUP WHERE END like '%%s%'", String.valueOf(end)));
	}
	
	public List<XAppointmentGroup> findAllByEndLikeOrderByAsc(LocalDateTime end){
		return query(String.format("SELECT * FROM X_APPOINTMENT_GROUP WHERE END like '%%s%' ORDER BY END ASC", String.valueOf(end)));
	}
	
	public List<XAppointmentGroup> findAllByEndLikeOrderByDesc(LocalDateTime end){
		return query(String.format("SELECT * FROM X_APPOINTMENT_GROUP WHERE END like '%%s%' ORDER BY END DESC", String.valueOf(end)));
	}
	public List<XAppointmentGroup> findAllByAppointmentGroupId(Integer appointmentGroupId){
		return query(String.format("SELECT * FROM X_APPOINTMENT_GROUP WHERE APPOINTMENT_GROUP_ID = '%s'", String.valueOf(appointmentGroupId)));
	}

	public List<XAppointmentGroup> findAllByAppointmentGroupIdOrderByAsc(Integer appointmentGroupId){
		return query(String.format("SELECT * FROM X_APPOINTMENT_GROUP WHERE APPOINTMENT_GROUP_ID = '%s' ORDER BY APPOINTMENT_GROUP_ID ASC", String.valueOf(appointmentGroupId)));
	}

	public List<XAppointmentGroup> findAllByAppointmentGroupIdOrderByDesc(Integer appointmentGroupId){
		return query(String.format("SELECT * FROM X_APPOINTMENT_GROUP WHERE APPOINTMENT_GROUP_ID = '%s' ORDER BY APPOINTMENT_GROUP_ID DESC", String.valueOf(appointmentGroupId)));
	}

	public List<XAppointmentGroup> findAllByAppointmentGroupIdLike(Integer appointmentGroupId){
		return query(String.format("SELECT * FROM X_APPOINTMENT_GROUP WHERE APPOINTMENT_GROUP_ID like '%%s%'", String.valueOf(appointmentGroupId)));
	}
	
	public List<XAppointmentGroup> findAllByAppointmentGroupIdLikeOrderByAsc(Integer appointmentGroupId){
		return query(String.format("SELECT * FROM X_APPOINTMENT_GROUP WHERE APPOINTMENT_GROUP_ID like '%%s%' ORDER BY APPOINTMENT_GROUP_ID ASC", String.valueOf(appointmentGroupId)));
	}
	
	public List<XAppointmentGroup> findAllByAppointmentGroupIdLikeOrderByDesc(Integer appointmentGroupId){
		return query(String.format("SELECT * FROM X_APPOINTMENT_GROUP WHERE APPOINTMENT_GROUP_ID like '%%s%' ORDER BY APPOINTMENT_GROUP_ID DESC", String.valueOf(appointmentGroupId)));
	}
	
	@Override
	protected String findAllStatement() {
		return XAppointmentGroupConstant.SQL_FIND_ALL;
	}
	
	@Override
	protected String findByIdStatement(long id) {
		return String.format(XAppointmentGroupConstant.SQL_FIND_BY_ID, id);
	}

	@Override
	protected String saveStatement() {
		return XAppointmentGroupConstant.SQL_INSERT;
	}

	@Override
	protected void prepareStatetmentForSave(XAppointmentGroup t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getAppointmentId());
		statement.setString(2, t.getTopic());
		statement.setString(3, t.getSummary());
		statement.setTimestamp(4, Timestamp.valueOf(t.getStart()));
		statement.setTimestamp(5, Timestamp.valueOf(t.getEnd()));
		statement.setInt(6, t.getAppointmentGroupId());
	}

	@Override
	protected String updateStatement() {
		return XAppointmentGroupConstant.SQL_MERGE;
	}

	@Override
	protected void prepareStatetmentForUpdate(XAppointmentGroup t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getId());
		statement.setLong(2, t.getAppointmentId());
		statement.setString(3, t.getTopic());
		statement.setString(4, t.getSummary());
		statement.setTimestamp(5, Timestamp.valueOf(t.getStart()));
		statement.setTimestamp(6, Timestamp.valueOf(t.getEnd()));
		statement.setInt(7, t.getAppointmentGroupId());
	}

	@Override
	protected String deleteStatement() {
		return XAppointmentGroupConstant.SQL_DELETE_BY_ID;
	}
	
	@Override
	protected void prepapreStatementForDelete(XAppointmentGroup t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getId());
	}
}
