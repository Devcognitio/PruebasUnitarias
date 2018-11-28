package co.com.devco.devco.service;


import co.com.devco.devco.model.Persona;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.List;

import static co.com.devco.devco.model.EtapaVida.INFANCIA;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import org.apache.logging.log4j.Logger;


public class PersonaServiceTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @InjectMocks
    @Spy
    PersonaService personaService;

    @Mock
    private Logger logger;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCuandoEsUnaEdadValidaEntoncesDeboObtenerElAnioDeNacimiento() throws Exception {
        when(personaService.obtenerAnioActual()).thenReturn(2018);
        int anioNacimiento = personaService.calcularAnioNacimiento(30);
        assertEquals(1988, anioNacimiento);
    }

    @Test
    public void testCuandoLaPersonaEsNulaEntoncesDebeResponderUnaExcepcion() throws Exception {
        thrown.expect(IndexOutOfBoundsException.class);
        thrown.expectMessage("Index: 0, Size: 0");
        List<Object> list = new ArrayList<Object>();
        list.get(0);

    }

    @Test
    public void testCuandoLaPersonaEsNulaEntoncesDebeResponderUnaExcepcion1() throws Exception {
        try {
            List<Object> list = new ArrayList<Object>();
            list.get(0);
            fail();
        } catch(IndexOutOfBoundsException e) {
          //validación de exception
          assertEquals(e.getMessage(), "Index: 0, Size: 0");
        }
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void testCuandoLaPersonaEsNulaEntoncesDebeResponderUnaExcepcion2() throws Exception {
        List<Object> list = new ArrayList<Object>();
        list.get(0);
    }

    @Test
    public void testCuandoCalcularSalarioEsMilEntoncesSalarioEs(){
        ArgumentCaptor<Integer> salarioBasicoDiaCaptor = ArgumentCaptor.forClass(Integer.class);
        int resultado = personaService.calcularSalario(1000);
        verify(personaService).calcularSalarioMes(salarioBasicoDiaCaptor.capture());
        int salarioMes = salarioBasicoDiaCaptor.getValue();
        verify(personaService).calcularSalarioMes(salarioMes);
    }

    @Test
    public void testCuandoSeGuardarUnaPersonaSuEdadSeraCuarenta(){
        doAnswer(new Answer<Void>() {
            @Override
            public Void answer(InvocationOnMock invocationOnMock) throws Throwable {
                Persona persona = invocationOnMock.getArgumentAt(0, Persona.class);
                persona.setEdad(40);
                return null;
            }
        }).when(personaService).establecerEdad(any(Persona.class));
        personaService.guardarPersona("Jennifer", "Perez");
        verify(logger).info("la edad de la persona es {}", 40);
    }



}
