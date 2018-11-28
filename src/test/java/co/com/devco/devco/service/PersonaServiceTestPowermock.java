package co.com.devco.devco.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static co.com.devco.devco.model.EtapaVida.INFANCIA;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest({EtapaService.class, ActividadService.class})
public class PersonaServiceTestPowermock {

    @Before
    public void initMocks() {
        mockStatic(ActividadService.class, EtapaService.class);
    }

    @Test
    public void testCuandoMiEdadEsCeroEntoncesElArregloDeberiTenerLlorar() {
        String[] actividadesInfancia = {"Correr", "Saltar", "Ir a piscina", "Llorar"};
        when(EtapaService.obtenerEtapaDeVida(anyInt())).thenReturn(INFANCIA);
        when(ActividadService.obtenerActividades(INFANCIA)).thenReturn(actividadesInfancia);
        PersonaService service = new PersonaService();
        String[] resultado = service.obtenerActividadesPorEdad(0);
        Assert.assertTrue(resultado.length > 0);
    }
}
