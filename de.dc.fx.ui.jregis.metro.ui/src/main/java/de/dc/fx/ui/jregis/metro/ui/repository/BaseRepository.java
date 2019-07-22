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

public abstract class BaseRepository<T> {

	private Logger log = Logger.getLogger(getClass().getSimpleName());

	private Connection connection;

	private List<T> cachedList = new ArrayList<>();
	
	public BaseRepository() {
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			log.log(Level.SEVERE, "Failed to load H2 driver!", e);
		}
	}

	public Optional<T> findById(int id) {
		if (cachedList.isEmpty()) {
			return Optional.ofNullable(forceFindBy(id));
		}
		return Optional.ofNullable(forceFindBy(id));
	}
	
	public List<T> findAll() {
		if (cachedList.isEmpty()) {
			cachedList = forceFindAll();
		}
		return cachedList;
	}
	
	public List<T> forceFindAll() {
		List<T> tempList = new ArrayList<>();
		PreparedStatement statement;
		try {
			connection = DriverManager.getConnection("jdbc:h2:file:./data/reg_db;DB_CLOSE_ON_EXIT=true;", "SA", "SA");
			statement = connection.prepareStatement(findAllStatement()+orderBy());
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				tempList.add(map(resultSet));
			}
			statement.close();
		} catch (SQLException e) {
			log.log(Level.SEVERE, "Failed to query: " + findAllStatement(), e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				log.log(Level.SEVERE, "Failed to create H2 connection!", e);
			}
		}
		return tempList;
	}

	public T forceFindBy(int id) {
		PreparedStatement statement;
		try {
			connection = DriverManager.getConnection("jdbc:h2:file:./data/reg_db;DB_CLOSE_ON_EXIT=true;", "SA", "SA");
			statement = connection.prepareStatement(findByIdStatement(id));
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				T result = map(resultSet);
				statement.close();
				return result;
			}
		} catch (SQLException e) {
			log.log(Level.SEVERE, "Failed to query: " + findByIdStatement(id), e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				log.log(Level.SEVERE, "Failed to create H2 connection!", e);
			}
		}
		return null;
	}

	protected abstract T map(ResultSet resultSet) throws SQLException;
	
	protected abstract String findByIdStatement(int id);

	protected abstract String findAllStatement();
	
	protected abstract String saveStatement();
	
	protected abstract void prepareStatetmentForSave(T t, PreparedStatement statement) throws SQLException;
	
	public String orderBy() {
		return StringUtils.EMPTY;
	}
	
	public void save(T t) {
		PreparedStatement statement;
		try {
			connection = DriverManager.getConnection("jdbc:h2:file:./data/reg_db;DB_CLOSE_ON_EXIT=true;", "SA", "SA");
			statement = connection.prepareStatement(saveStatement());
			prepareStatetmentForSave(t, statement);
			statement.execute();
		} catch (SQLException e) {
			log.log(Level.SEVERE, "Failed to query: " + saveStatement(), e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				log.log(Level.SEVERE, "Failed to create H2 connection!", e);
			}
		}
	}
	
	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			log.log(Level.SEVERE, "Failed to close H2 connection!", e);
		}
	}
}
