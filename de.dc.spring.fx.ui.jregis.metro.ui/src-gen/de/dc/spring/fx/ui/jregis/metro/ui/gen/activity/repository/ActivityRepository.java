package de.dc.spring.fx.ui.jregis.metro.ui.gen.activity.repository;

import de.dc.spring.fx.ui.jregis.metro.ui.gen.activity.model.*;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long>{
}
