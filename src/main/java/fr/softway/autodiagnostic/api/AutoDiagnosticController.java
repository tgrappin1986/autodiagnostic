package fr.softway.autodiagnostic.api;

import fr.softway.autodiagnostic.service.AutoDiagnosticService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutoDiagnosticController {

    static final Logger log =
            LoggerFactory.getLogger(AutoDiagnosticController.class);

    @Autowired
    private AutoDiagnosticService autoDiagnosticService;

    @GetMapping("/autodiagnostic/{idPatient}")
    @ResponseBody
    String obtenirDiagnostic(@PathVariable Long idPatient) {
        log.info("idPatient: {}", idPatient);
        int indexSante = autoDiagnosticService.obtenirIndexSante(idPatient);
        return autoDiagnosticService.traiterDonnees(idPatient, indexSante);
    }

}
