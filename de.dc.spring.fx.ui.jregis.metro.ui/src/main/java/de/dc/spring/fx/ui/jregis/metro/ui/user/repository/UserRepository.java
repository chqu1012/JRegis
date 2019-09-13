package de.dc.spring.fx.ui.jregis.metro.ui.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.dc.spring.fx.ui.jregis.metro.ui.user.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
}
