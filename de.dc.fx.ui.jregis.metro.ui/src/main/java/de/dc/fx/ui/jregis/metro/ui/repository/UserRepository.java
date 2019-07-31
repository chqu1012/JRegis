package de.dc.fx.ui.jregis.metro.ui.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import de.dc.fx.ui.jregis.metro.ui.model.User;

public class UserRepository extends BaseRepository<User> {

	@Override
	protected User map(ResultSet resultSet) throws SQLException{
		String address = resultSet.getString("ADDRESS");
		LocalDateTime createdOn = resultSet.getTimestamp("CREATED_ON").toLocalDateTime();
		String city = resultSet.getString("CITY");
		String country = resultSet.getString("COUNTRY");
		LocalDateTime birthday = resultSet.getTimestamp("BIRTHDAY").toLocalDateTime();
		String email = resultSet.getString("EMAIL");
		String firstname = resultSet.getString("FIRSTNAME");
		long id = resultSet.getLong("ID");
		String lastname = resultSet.getString("LASTNAME");
		String mobile = resultSet.getString("MOBILE");
		String password = resultSet.getString("PASSWORD");
		String state = resultSet.getString("STATE");
		LocalDateTime updatedOn = resultSet.getTimestamp("UPDATED_ON").toLocalDateTime();
		String username = resultSet.getString("USERNAME");
		String name = resultSet.getString("NAME");
		long roleId = resultSet.getLong("ROLE_ID");
		long statusId = resultSet.getLong("STATUS_ID");
		
		User user = new User(name , createdOn, updatedOn, username, password, firstname, lastname, email, address, city, state, country, mobile, birthday);
		user.setRoleId(roleId);
		user.setStatus(statusId);
		user.setId(id);
		return user;
	}

	@Override
	protected String findAllStatement() {
		return "SELECT * FROM user ORDER BY id DESC";
	}
	
	@Override
	protected String findByIdStatement(long id) {
		return "SELECT * FROM user WHERE id = "+id;
	}

	@Override
	protected String saveStatement() {
		return "INSERT INTO user (address, birthday, city, country, created_on, email, firstname, lastname, mobile, password, state, updated_on, username, name, role_id, status_id) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
	}

	@Override
	protected void prepareStatetmentForSave(User t, PreparedStatement statement) throws SQLException {
		statement.setString(1, t.getAddress());
		statement.setTimestamp(2, Timestamp.valueOf(t.getBirthday()));
		statement.setString(3, t.getCity());
		statement.setString(4, t.getCountry());
		statement.setTimestamp(5, Timestamp.valueOf(t.getCreatedOn()));
		statement.setString(6, t.getEmail());
		statement.setString(7, t.getFirstname());
		statement.setString(8, t.getLastname());
		statement.setString(9, t.getMobile());
		statement.setString(10, t.getPassword());
		statement.setString(11, t.getState());
		statement.setTimestamp(12, Timestamp.valueOf(t.getUpdatedOn()));
		statement.setString(13, t.getUsername());
		statement.setString(14, t.getName());
		statement.setLong(15, t.getRoleId());
		statement.setLong(16, t.getStatus());
	}

	@Override
	protected String updateStatement() {
		return "MERGE INTO user KEY (ID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
	}

	@Override
	protected void prepareStatetmentForUpdate(User t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getId());
		statement.setString(2, t.getAddress());
		statement.setTimestamp(3, Timestamp.valueOf(t.getBirthday()));
		statement.setString(4, t.getCity());
		statement.setString(5, t.getCountry());
		statement.setTimestamp(6, Timestamp.valueOf(t.getCreatedOn()));
		statement.setString(7, t.getEmail());
		statement.setString(8, t.getFirstname());
		statement.setString(9, t.getLastname());
		statement.setString(10, t.getMobile());
		statement.setString(11, t.getPassword());
		statement.setString(12, t.getState());
		statement.setTimestamp(13, Timestamp.valueOf(t.getUpdatedOn()));
		statement.setString(14, t.getUsername());
		statement.setString(15, t.getName());
		statement.setLong(16, t.getRoleId());
		statement.setLong(17, t.getStatus());
	}

	@Override
	protected String deleteStatement() {
		return "DELETE user WHERE id = ?";
	}
	
	@Override
	protected void prepapreStatementForDelete(User t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getId());
	}
}
