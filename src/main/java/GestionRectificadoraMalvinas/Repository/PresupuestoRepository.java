package GestionRectificadoraMalvinas.Repository;

import GestionRectificadoraMalvinas.Model.Presupuesto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
public interface PresupuestoRepository extends JpaRepository<Presupuesto, Long> {
}
