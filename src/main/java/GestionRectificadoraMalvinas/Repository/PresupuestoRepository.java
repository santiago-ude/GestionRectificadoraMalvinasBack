package GestionRectificadoraMalvinas.Repository;

import GestionRectificadoraMalvinas.Model.Presupuesto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PresupuestoRepository extends JpaRepository<Presupuesto, Integer> {
}
