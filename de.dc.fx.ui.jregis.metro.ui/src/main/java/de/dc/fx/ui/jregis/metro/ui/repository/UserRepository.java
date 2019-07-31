package de.dc.fx.ui.jregis.metro.ui.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import de.dc.fx.ui.jregis.metro.ui.model.User;

public class UserRepository extends BaseRepository<User> {

	@Override
	protected User map(ResultSet resultSet) throws SQLException{
		User user = new User();
		user.setAddress(resultSet.getString("ADDRESS"));
		user.setBirthday(resultSet.getTimestamp("BIRTHDAY").toLocalDateTime());
		user.setCity(resultSet.getString("CITY"));
		user.setCountry(resultSet.getString("COUNTRY"));
		user.setCreatedOn(resultSet.getTimestamp("CREATED_ON").toLocalDateTime());
		user.setEmail(resultSet.getString("EMAIL"));
		user.setFirstname(resultSet.getString("FIRSTNAME"));
		user.setId(resultSet.getLong("ID"));
		user.setLastname(resultSet.getString("LASTNAME"));
		user.setMobile(resultSet.getString("MOBILE"));
		user.setPassword(resultSet.getString("PASSWORD"));
		user.setState(resultSet.getString("STATE"));
		user.setUpdatedOn(resultSet.getTimestamp("UPDATED_ON").toLocalDateTime());
		user.setUsername(resultSet.getString("USERNAME"));
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
		return "INSERT INTO user (address, birthday, city, country, createdOn, email, firstname, lastname, mobile, password, state, updatedOn, username) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);";
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
	}

	@Override
	protected String updateStatement() {
		return "MERGE INTO user KEY (ID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
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
