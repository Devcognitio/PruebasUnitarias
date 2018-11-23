package co.com.devco.devco.service;


import co.com.devco.devco.model.EtapaVida;

public class ActividadService {

    private static String[] actividadesInfancia = {"Correr", "Saltar", "Ir a piscina", "Llorar"};
    private static String[] actividadesJoven = {"Correr", "Saltar", "Ir a piscina", "Estudia en colegio", "Escucha musica"};
    private static String[] actividadesAdolescencia = {"Estudia en universidad", "Sale de compras", "Apuesta"};
    private static String[] actividadesJuevntud = {"Estudia en universidad", "Trabaja", "Sale a comer con amigos"};
    private static String[] actividadesAdulto = {"Programa", "Enferma", "Cuida su familia"};
    private static String[] actividadesAnciano = {"Sale a la playa", "Compra bienes", "Cuida su nietos"};

    public static String[] obtenerActividades(EtapaVida etapaVida) {
        switch (etapaVida) {
            case INFANCIA:
                return actividadesInfancia;
            case JOVEN:
                return actividadesJoven;
            case ADOLESCENCIA:
                return actividadesAdolescencia;
            case JUVENTUD:
                return actividadesJuevntud;
            case ADULTO:
                return actividadesAdulto;
            case ANCIANO:
                return actividadesAnciano;
            default:
                return null;
        }
    }
}
