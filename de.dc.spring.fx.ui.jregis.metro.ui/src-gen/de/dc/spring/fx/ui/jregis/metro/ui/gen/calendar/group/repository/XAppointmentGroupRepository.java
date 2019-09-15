package de.dc.spring.fx.ui.jregis.metro.ui.gen.calendar.group.repository;

import de.dc.spring.fx.ui.jregis.metro.ui.gen.calendar.group.model.*;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XAppointmentGroupRepository extends JpaRepository<XAppointmentGroup, Long>{
}
