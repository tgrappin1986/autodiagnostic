package fr.softway.autodiagnostic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class AutoDiagnosticEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private Long idPatient;

    private int indexSante;

    private String unitesAVisiter;

    public AutoDiagnosticEntity() {}

    public AutoDiagnosticEntity(Long idPatient, int indexSante) {
        this.idPatient = idPatient;
        this.indexSante = indexSante;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Long idPatient) {
        this.idPatient = idPatient;
    }

    public int getIndexSante() {
        return indexSante;
    }

    public void setIndexSante(int indexSante) {
        this.indexSante = indexSante;
    }

    public String getUnitesAVisiter() {
        return unitesAVisiter;
    }

    public void setUnitesAVisiter(String unitesAVisiter) {
        this.unitesAVisiter = unitesAVisiter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AutoDiagnosticEntity that = (AutoDiagnosticEntity) o;
        return indexSante == that.indexSante && Objects.equals(id, that.id) && Objects.equals(idPatient, that.idPatient) && Objects.equals(unitesAVisiter, that.unitesAVisiter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idPatient, indexSante, unitesAVisiter);
    }

    @Override
    public String toString() {
        return "AutoDiagnostic{" +
                "id=" + id +
                ", idPatient=" + idPatient +
                ", indexSante=" + indexSante +
                ", unitesAVisiter='" + unitesAVisiter + '\'' +
                '}';
    }
}
