package co.com.devco.devco.service;

import co.com.devco.devco.model.Persona;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class PersonaServiceparameterizedTest {

    private Object[] parametersToTestAdd() {

        return new Object[]{null,
                            new Persona("Jennifer", "", 0),
                            new Persona("", "Perez", 0)};
    }

    @Test
    @Parameters(method = "parametersToTestAdd")
    public void testCuandoElNombreDeLaPersonaEsRequeridoEntonces(Persona p) {
        try {
            PersonaService service = new PersonaService();
            service.presentarPersona(p);
        }catch (Exception ex){
            Assert.assertTrue(ex instanceof Exception);
        }
    }

}
