package de.dc.spring.fx.ui.jregis.metro.ui.gen.calendar.appointment.repository;

import de.dc.spring.fx.ui.jregis.metro.ui.gen.calendar.appointment.model.*;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XAppointmentRepository extends JpaRepository<XAppointment, Long>{
}
