package fr.softway.autodiagnostic.service;

import fr.softway.autodiagnostic.model.UniteMedicale;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AutoDiagnosticEntityServiceTest {

    @Autowired
    private AutoDiagnosticService autoDiagnosticService;

    @Test
    @DisplayName("Une valeur d'indexSanté multiple de 3 doit indiquer l'unité médicale de Cardiologie")
    void traiterDonneesDiagnostic_Cardiologie() {
        String unitesMedicalesAVisiter = autoDiagnosticService.traiterDonnees(43562983L, 33);
        assertEquals(UniteMedicale.CARDIOLOGIE.name(), unitesMedicalesAVisiter);
    }

    @Test
    @DisplayName("Une valeur d'indexSanté multiple de 5 doit indiquer l'unité médicale de Traumatologie")
    void traiterDonneesDiagnostic_Traumatologie() {
        String unitesMedicalesAVisiter = autoDiagnosticService.traiterDonnees(43562983L,55);
        assertEquals(UniteMedicale.TRAUMATOLOGIE.name(), unitesMedicalesAVisiter);
    }

    @Test
    @DisplayName("Une valeur d'indexSanté multiple de 3 et de 5 doit indiquer les unités médicales de Cardiologie et de Traumatologie, séparées par une virgule")
    void traiterDonneesDiagnostic_CardiologieEtTraumatologie() {
        String unitesMedicalesAVisiter = autoDiagnosticService.traiterDonnees(43562983L, 15);
        assertEquals(UniteMedicale.CARDIOLOGIE.name()+", "+UniteMedicale.TRAUMATOLOGIE, unitesMedicalesAVisiter);
    }
}
