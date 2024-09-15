package fr.softway.autodiagnostic.api;

import fr.softway.autodiagnostic.model.UniteMedicale;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AutoDiagnosticEntityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testObtenirDiagnostic() throws Exception {
        MvcResult mvcResult = mockMvc
            .perform(get("/autodiagnostic/151515"))
            .andExpect(status().isOk())
            .andReturn();

        assertTrue(
        mvcResult.getResponse().getContentAsString().equals(UniteMedicale.CARDIOLOGIE.name())
            || mvcResult.getResponse().getContentAsString().equals(UniteMedicale.TRAUMATOLOGIE.name())
            || mvcResult.getResponse().getContentAsString().equals(UniteMedicale.CARDIOLOGIE.name()+", "+UniteMedicale.TRAUMATOLOGIE.name())
        );
    }
}
