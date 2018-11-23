package co.com.devco.devco.model;

public enum EtapaVida {
    INFANCIA(0, 6),
    JOVEN(7, 12),
    ADOLESCENCIA(13, 20),
    JUVENTUD(21, 25),
    ADULTO(26, 60),
    ANCIANO(61,200);

    private int inicio;
    private int fin;

    EtapaVida(int inicio, int fin){
        this.inicio = inicio;
        this.fin = fin;
    }

    public int getInicio() {
        return inicio;
    }

    public int getFin() {
        return fin;
    }
}
