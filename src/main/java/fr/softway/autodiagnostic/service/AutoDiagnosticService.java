package fr.softway.autodiagnostic.service;

import fr.softway.autodiagnostic.model.AutoDiagnosticEntity;
import fr.softway.autodiagnostic.model.UniteMedicale;
import fr.softway.autodiagnostic.repository.AutoDiagnosticRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AutoDiagnosticService {

    static final Logger log =
            LoggerFactory.getLogger(AutoDiagnosticService.class);

    @Autowired
    private AutoDiagnosticRepository autoDiagnosticRepository;

    /**
     *
     * @param idPatient identifiant du patient
     * @return un entier multiple de 3, de 5 ou de 3 et de 5,  correspondant à l'index santé du patient
     */
    public int obtenirIndexSante(Long idPatient) {
        AutoDiagnosticEntity autoDiagnostic;
        List<Integer> data = Arrays.asList(33, 55, 15);
        int indexSante = data.get(new Random().nextInt(3));
        Optional<AutoDiagnosticEntity> autoDiagnosticOptional = autoDiagnosticRepository.findByIdPatient(idPatient);
        autoDiagnostic = autoDiagnosticOptional.orElseGet(() -> new AutoDiagnosticEntity(idPatient, indexSante));
        autoDiagnosticRepository.save(autoDiagnostic);
        log.info("indexSante: {}", indexSante);
        return indexSante;
        //  return client.get()
        //      .url("https://example.com/{id}", id)
        //      .retrieve().bodyToMono(xxxx.class);

    }

    /**
     *
     * @param indexSante index santé du patient
     * @return une chaîne décrivant l'unité médicale ou les unités médicales à visiter selon le diagnostic
     */
    public String traiterDonnees(Long idPatient, int indexSante) {
        List<String> unitesMedicales = new ArrayList<>();
        if (0 == indexSante%3)
            unitesMedicales.add(UniteMedicale.CARDIOLOGIE.name());
        if (0 == indexSante%5)
            unitesMedicales.add(UniteMedicale.TRAUMATOLOGIE.name());
        String unitesMedicalesAVisiter = String.join(", ", unitesMedicales);
        log.info("unitesMedicales: {}", unitesMedicalesAVisiter);
        Optional<AutoDiagnosticEntity> autoDiagnosticOptional = autoDiagnosticRepository.findByIdPatient(idPatient);
        autoDiagnosticOptional.ifPresent(diagnostic -> {
            diagnostic.setUnitesAVisiter(unitesMedicalesAVisiter);
            autoDiagnosticRepository.save(diagnostic);
        });
        return unitesMedicalesAVisiter;
    }
}
