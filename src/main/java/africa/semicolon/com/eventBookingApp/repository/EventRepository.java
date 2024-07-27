package africa.semicolon.com.eventBookingApp.repository;

import africa.semicolon.com.eventBookingApp.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

}
