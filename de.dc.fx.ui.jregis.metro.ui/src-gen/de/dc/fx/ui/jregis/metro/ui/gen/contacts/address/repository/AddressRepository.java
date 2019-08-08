package de.dc.fx.ui.jregis.metro.ui.gen.contacts.address.repository;

import java.sql.*;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.address.model.*;
import java.util.*;
import java.time.*;

public class AddressRepository extends BaseRepository<Address>{

	@Override
	protected Address map(ResultSet resultSet) throws SQLException{
		Address address = new Address();
		address.setId(resultSet.getLong("ID"));
		address.setContactId(resultSet.getLong("CONTACT_ID"));
		address.setAddressType(resultSet.getString("ADDRESS_TYPE"));
		address.setStreet(resultSet.getString("STREET"));
		address.setCountry(resultSet.getString("COUNTRY"));
		address.setState(resultSet.getString("STATE"));
		address.setZipCode(resultSet.getInt("ZIP_CODE"));
		return address;
	}
	
	public List<Address> findAllByContactId(Long contactId){
		return query(String.format("SELECT * FROM ADDRESS WHERE CONTACT_ID = '%s'", String.valueOf(contactId)));
	}

	public List<Address> findAllByContactIdOrderByAsc(Long contactId){
		return query(String.format("SELECT * FROM ADDRESS WHERE CONTACT_ID = '%s' ORDER BY CONTACT_ID ASC", String.valueOf(contactId)));
	}

	public List<Address> findAllByContactIdOrderByDesc(Long contactId){
		return query(String.format("SELECT * FROM ADDRESS WHERE CONTACT_ID = '%s' ORDER BY CONTACT_ID DESC", String.valueOf(contactId)));
	}

	public List<Address> findAllByContactIdLike(Long contactId){
		return query(String.format("SELECT * FROM ADDRESS WHERE CONTACT_ID like '%%s%'", String.valueOf(contactId)));
	}
	
	public List<Address> findAllByContactIdLikeOrderByAsc(Long contactId){
		return query(String.format("SELECT * FROM ADDRESS WHERE CONTACT_ID like '%%s%' ORDER BY CONTACT_ID ASC", String.valueOf(contactId)));
	}
	
	public List<Address> findAllByContactIdLikeOrderByDesc(Long contactId){
		return query(String.format("SELECT * FROM ADDRESS WHERE CONTACT_ID like '%%s%' ORDER BY CONTACT_ID DESC", String.valueOf(contactId)));
	}
	public List<Address> findAllByAddressType(String addressType){
		return query(String.format("SELECT * FROM ADDRESS WHERE ADDRESS_TYPE = '%s'", String.valueOf(addressType)));
	}

	public List<Address> findAllByAddressTypeOrderByAsc(String addressType){
		return query(String.format("SELECT * FROM ADDRESS WHERE ADDRESS_TYPE = '%s' ORDER BY ADDRESS_TYPE ASC", String.valueOf(addressType)));
	}

	public List<Address> findAllByAddressTypeOrderByDesc(String addressType){
		return query(String.format("SELECT * FROM ADDRESS WHERE ADDRESS_TYPE = '%s' ORDER BY ADDRESS_TYPE DESC", String.valueOf(addressType)));
	}

	public List<Address> findAllByAddressTypeLike(String addressType){
		return query(String.format("SELECT * FROM ADDRESS WHERE ADDRESS_TYPE like '%%s%'", String.valueOf(addressType)));
	}
	
	public List<Address> findAllByAddressTypeLikeOrderByAsc(String addressType){
		return query(String.format("SELECT * FROM ADDRESS WHERE ADDRESS_TYPE like '%%s%' ORDER BY ADDRESS_TYPE ASC", String.valueOf(addressType)));
	}
	
	public List<Address> findAllByAddressTypeLikeOrderByDesc(String addressType){
		return query(String.format("SELECT * FROM ADDRESS WHERE ADDRESS_TYPE like '%%s%' ORDER BY ADDRESS_TYPE DESC", String.valueOf(addressType)));
	}
	public List<Address> findAllByStreet(String street){
		return query(String.format("SELECT * FROM ADDRESS WHERE STREET = '%s'", String.valueOf(street)));
	}

	public List<Address> findAllByStreetOrderByAsc(String street){
		return query(String.format("SELECT * FROM ADDRESS WHERE STREET = '%s' ORDER BY STREET ASC", String.valueOf(street)));
	}

	public List<Address> findAllByStreetOrderByDesc(String street){
		return query(String.format("SELECT * FROM ADDRESS WHERE STREET = '%s' ORDER BY STREET DESC", String.valueOf(street)));
	}

	public List<Address> findAllByStreetLike(String street){
		return query(String.format("SELECT * FROM ADDRESS WHERE STREET like '%%s%'", String.valueOf(street)));
	}
	
	public List<Address> findAllByStreetLikeOrderByAsc(String street){
		return query(String.format("SELECT * FROM ADDRESS WHERE STREET like '%%s%' ORDER BY STREET ASC", String.valueOf(street)));
	}
	
	public List<Address> findAllByStreetLikeOrderByDesc(String street){
		return query(String.format("SELECT * FROM ADDRESS WHERE STREET like '%%s%' ORDER BY STREET DESC", String.valueOf(street)));
	}
	public List<Address> findAllByCountry(String country){
		return query(String.format("SELECT * FROM ADDRESS WHERE COUNTRY = '%s'", String.valueOf(country)));
	}

	public List<Address> findAllByCountryOrderByAsc(String country){
		return query(String.format("SELECT * FROM ADDRESS WHERE COUNTRY = '%s' ORDER BY COUNTRY ASC", String.valueOf(country)));
	}

	public List<Address> findAllByCountryOrderByDesc(String country){
		return query(String.format("SELECT * FROM ADDRESS WHERE COUNTRY = '%s' ORDER BY COUNTRY DESC", String.valueOf(country)));
	}

	public List<Address> findAllByCountryLike(String country){
		return query(String.format("SELECT * FROM ADDRESS WHERE COUNTRY like '%%s%'", String.valueOf(country)));
	}
	
	public List<Address> findAllByCountryLikeOrderByAsc(String country){
		return query(String.format("SELECT * FROM ADDRESS WHERE COUNTRY like '%%s%' ORDER BY COUNTRY ASC", String.valueOf(country)));
	}
	
	public List<Address> findAllByCountryLikeOrderByDesc(String country){
		return query(String.format("SELECT * FROM ADDRESS WHERE COUNTRY like '%%s%' ORDER BY COUNTRY DESC", String.valueOf(country)));
	}
	public List<Address> findAllByState(String state){
		return query(String.format("SELECT * FROM ADDRESS WHERE STATE = '%s'", String.valueOf(state)));
	}

	public List<Address> findAllByStateOrderByAsc(String state){
		return query(String.format("SELECT * FROM ADDRESS WHERE STATE = '%s' ORDER BY STATE ASC", String.valueOf(state)));
	}

	public List<Address> findAllByStateOrderByDesc(String state){
		return query(String.format("SELECT * FROM ADDRESS WHERE STATE = '%s' ORDER BY STATE DESC", String.valueOf(state)));
	}

	public List<Address> findAllByStateLike(String state){
		return query(String.format("SELECT * FROM ADDRESS WHERE STATE like '%%s%'", String.valueOf(state)));
	}
	
	public List<Address> findAllByStateLikeOrderByAsc(String state){
		return query(String.format("SELECT * FROM ADDRESS WHERE STATE like '%%s%' ORDER BY STATE ASC", String.valueOf(state)));
	}
	
	public List<Address> findAllByStateLikeOrderByDesc(String state){
		return query(String.format("SELECT * FROM ADDRESS WHERE STATE like '%%s%' ORDER BY STATE DESC", String.valueOf(state)));
	}
	public List<Address> findAllByZipCode(Integer zipCode){
		return query(String.format("SELECT * FROM ADDRESS WHERE ZIP_CODE = '%s'", String.valueOf(zipCode)));
	}

	public List<Address> findAllByZipCodeOrderByAsc(Integer zipCode){
		return query(String.format("SELECT * FROM ADDRESS WHERE ZIP_CODE = '%s' ORDER BY ZIP_CODE ASC", String.valueOf(zipCode)));
	}

	public List<Address> findAllByZipCodeOrderByDesc(Integer zipCode){
		return query(String.format("SELECT * FROM ADDRESS WHERE ZIP_CODE = '%s' ORDER BY ZIP_CODE DESC", String.valueOf(zipCode)));
	}

	public List<Address> findAllByZipCodeLike(Integer zipCode){
		return query(String.format("SELECT * FROM ADDRESS WHERE ZIP_CODE like '%%s%'", String.valueOf(zipCode)));
	}
	
	public List<Address> findAllByZipCodeLikeOrderByAsc(Integer zipCode){
		return query(String.format("SELECT * FROM ADDRESS WHERE ZIP_CODE like '%%s%' ORDER BY ZIP_CODE ASC", String.valueOf(zipCode)));
	}
	
	public List<Address> findAllByZipCodeLikeOrderByDesc(Integer zipCode){
		return query(String.format("SELECT * FROM ADDRESS WHERE ZIP_CODE like '%%s%' ORDER BY ZIP_CODE DESC", String.valueOf(zipCode)));
	}
	
	@Override
	protected String findAllStatement() {
		return AddressConstant.SQL_FIND_ALL;
	}
	
	@Override
	protected String findByIdStatement(long id) {
		return String.format(AddressConstant.SQL_FIND_BY_ID, id);
	}

	@Override
	protected String saveStatement() {
		return AddressConstant.SQL_INSERT;
	}

	@Override
	protected void prepareStatetmentForSave(Address t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getContactId());
		statement.setString(2, t.getAddressType());
		statement.setString(3, t.getStreet());
		statement.setString(4, t.getCountry());
		statement.setString(5, t.getState());
		statement.setInt(6, t.getZipCode());
	}

	@Override
	protected String updateStatement() {
		return AddressConstant.SQL_MERGE;
	}

	@Override
	protected void prepareStatetmentForUpdate(Address t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getId());
		statement.setLong(2, t.getContactId());
		statement.setString(3, t.getAddressType());
		statement.setString(4, t.getStreet());
		statement.setString(5, t.getCountry());
		statement.setString(6, t.getState());
		statement.setInt(7, t.getZipCode());
	}

	@Override
	protected String deleteStatement() {
		return AddressConstant.SQL_DELETE_BY_ID;
	}
	
	@Override
	protected void prepapreStatementForDelete(Address t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getId());
	}
}
