package kamauro.strategy.model;

public class CreditCard {

    private int valor;
    private String numero;
    private String data;
    private String cvv;

    public CreditCard(String numero, String data, String cvv) {
        this.valor = 100_000;
        this.numero = numero;
        this.data = data;
        this.cvv = cvv;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
    
}
