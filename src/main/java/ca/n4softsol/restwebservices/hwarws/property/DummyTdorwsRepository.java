package ca.n4softsol.restwebservices.hwarws.property;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DummyTdorwsRepository extends JpaRepository<DummyTdorws, Long> {	

}
