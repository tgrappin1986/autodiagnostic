package fr.softway.autodiagnostic.repository;

import fr.softway.autodiagnostic.model.AutoDiagnosticEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AutoDiagnosticRepository extends JpaRepository<AutoDiagnosticEntity, Long> {
    Optional<AutoDiagnosticEntity> findByIdPatient(Long idPatient);
}
