package de.dc.fx.ui.jregis.metro.ui.repository;

import java.time.LocalDateTime;

import de.dc.fx.ui.jregis.metro.ui.model.Role;

public class RoleRepository extends IdRepository<Role>{

	@Override
	public Role map(long id, String name, LocalDateTime createdOn, LocalDateTime updatedOn) {
		Role role = new Role(name, LocalDateTime.now(), LocalDateTime.now());
		role.setId(id);
		return role;
	}

	@Override
	public String table() {
		return Role.class.getSimpleName().toLowerCase();
	}

}
