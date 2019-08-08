package de.dc.fx.ui.jregis.metro.ui.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.lang.StringUtils;

import de.dc.fx.ui.jregis.metro.ui.model.IdElement;

public abstract class GenericIdBaseRepository<T extends IdElement> {

	private Logger log = Logger.getLogger(getClass().getSimpleName());

	protected List<T> cachedList = new ArrayList<>();

	public GenericIdBaseRepository() {
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			log.log(Level.SEVERE, "Failed to load H2 driver!", e);
		}
	}

	public abstract String getJdbcUrl();
	
	public Optional<T> findById(long id) {
		if (cachedList.isEmpty()) {
			return Optional.ofNullable(forceFindBy(id));
		}
		return cachedList.stream().filter(e->e.getId()==id).findFirst();
	}

	public List<T> findAll() {
		if (cachedList.isEmpty()) {
			cachedList = forceFindAll();
		}
		return cachedList;
	}

	public List<T> forceFindAll() {
		List<T> tempList = new ArrayList<>();
		try (Connection connection = DriverManager.getConnection(getJdbcUrl(),"SA", "SA");
				PreparedStatement statement = connection.prepareStatement(findAllStatement() + orderBy());
				ResultSet resultSet = statement.executeQuery()) {
			while (resultSet.next()) {
				tempList.add(map(resultSet));
			}
		} catch (SQLException e) {
			log.log(Level.SEVERE, "Failed to query: " + findAllStatement(), e);
		}
		return tempList;
	}

	public T forceFindBy(long id) {
		try (Connection conn = DriverManager.getConnection(getJdbcUrl(), "SA","SA");
				PreparedStatement statement = conn.prepareStatement(findByIdStatement(id));
				ResultSet resultSet = statement.executeQuery();) {
			if (resultSet.next()) {
				return map(resultSet);
			}
		} catch (SQLException e) {
			log.log(Level.SEVERE, "Failed to query: " + findByIdStatement(id), e);
		}
		return null;
	}

	protected abstract T map(ResultSet resultSet) throws SQLException;

	protected abstract String findByIdStatement(long id);

	protected abstract String findAllStatement();

	protected abstract String saveStatement();

	protected abstract String deleteStatement();

	protected abstract String updateStatement();

	protected abstract void prepareStatetmentForSave(T t, PreparedStatement statement) throws SQLException;

	protected abstract void prepareStatetmentForUpdate(T t, PreparedStatement statement) throws SQLException;

	protected abstract void prepapreStatementForDelete(T t, PreparedStatement statement) throws SQLException;

	public String orderBy() {
		return StringUtils.EMPTY;
	}

	public void delete(T t) {
		try (Connection connection = DriverManager.getConnection(getJdbcUrl(),"SA", "SA"); 
				PreparedStatement statement = connection.prepareStatement(deleteStatement())) {
			prepapreStatementForDelete(t, statement);
			statement.execute();
			cachedList.remove(t);
			log.log(Level.ALL, "Delete attachment: " + deleteStatement());
		} catch (SQLException e) {
			log.log(Level.SEVERE, "Failed to query: " + saveStatement(), e);
		}
	}

	public long save(T t) {
		try (Connection connection = DriverManager.getConnection(getJdbcUrl(), "SA", "SA"); 
				PreparedStatement statement = connection.prepareStatement(saveStatement())) {
			prepareStatetmentForSave(t, statement);
			cachedList.add(t);
			statement.execute();

			ResultSet rs = statement.getGeneratedKeys();
			while (rs.next()) {
				return rs.getLong(1);
			}
			log.log(Level.ALL, "Save attachment: " + saveStatement());
		} catch (SQLException e) {
			log.log(Level.SEVERE, "Failed to query: " + saveStatement(), e);
		}
		return -1;
	}

	public long update(T t) {
		try (Connection connection = DriverManager.getConnection(getJdbcUrl(), "SA", "SA"); 
				PreparedStatement statement = connection.prepareStatement(updateStatement())) {
			prepareStatetmentForUpdate(t, statement);
			statement.execute();

			ResultSet rs = statement.getGeneratedKeys();
			while (rs.next()) {
				return rs.getLong(1);
			}
			log.log(Level.ALL, "Update attachment: " + updateStatement());
		} catch (SQLException e) {
			log.log(Level.SEVERE, "Failed to query: " + updateStatement(), e);
		}
		return -1;
	}
}
