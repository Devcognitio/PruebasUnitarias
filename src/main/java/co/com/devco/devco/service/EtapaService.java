package co.com.devco.devco.service;

import java.util.Arrays;
import java.util.Optional;

import co.com.devco.devco.model.EtapaVida;


public class EtapaService {

    public static EtapaVida obtenerEtapaDeVida(int edad) {
        return Optional.ofNullable(EtapaVida.values())
                .map(etapaVidas -> {
                    return Arrays.stream(etapaVidas)
                            .filter(etapa -> edad >= etapa.getInicio() && edad <= etapa.getFin())
                            .findFirst()
                            .orElse(null);
                }).orElse(null);
    }

}
