package kamauro.strategy.fechamento;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import kamauro.strategy.model.CreditCard;



public class PagamentoPorCreditCard implements PagamentoStrategy{

    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private CreditCard cartao;

    /**
     * Collect credit card data.
     */
    @Override
    public void detalhePagamento() {
        try {
            System.out.print("Número do cartão: ");
            String numero = READER.readLine();
            System.out.print("Validade do cartão 'mm/yy': ");
            String data = READER.readLine();
            System.out.print("Código CVV: ");
            String cvv = READER.readLine();
            cartao = new CreditCard(numero, data, cvv);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Após a validação do cartão podemos cobrar no cartão de crédito do cliente.
     */
    @Override
    public boolean pagamento(int valorPagamento) {
        if (cartaoPresente()) {
            System.out.println("Pagando " + valorPagamento + " usando cartão de crédito.");
            cartao.setValor(cartao.getValor() - valorPagamento);
            return true;
        } else {
            return false;
        }
    }

    private boolean cartaoPresente() {
        return cartao != null;
    }
    
}
