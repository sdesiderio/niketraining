package cost.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cost.management.entities.Contratto;

@Repository
@Transactional
public interface ContrattoRepository extends JpaRepository<Contratto, Integer>{

}
