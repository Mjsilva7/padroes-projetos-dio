package kamauro.strategy.fechamento;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Estratégia concreta. Implementa o método de pagamento PayPal.
 */

public class PagamentoPorPayPal implements PagamentoStrategy {

    private static final Map<String, String> DATA_BASE = new HashMap<>();
    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private String email;
    private String senha;
    private boolean assinatura;

    static {
        DATA_BASE.put("mauricio1978", "mauricio@email.com");
        DATA_BASE.put("qwerty", "kamauro@amazon.eu");
    }

    /**
     * Coletar dados dos clientes.
     */
    @Override
    public void detalhePagamento() {
        try {
            while (!assinatura) {
                System.out.print("Entre com o usuário de email: ");
                email = READER.readLine();
                System.out.print("Digite sua senha: ");
                senha = READER.readLine();
                if (verify()) {
                    System.out.println("A verificação foi bem-sucedida.");
                } else {
                    System.out.println("e-mail ou senha incorretos!");
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private boolean verify() {
        setAssinatura(email.equals(DATA_BASE.get(senha)));
        return assinatura;
    }

    /**
     * Salve os dados do cliente para futuras tentativas de compra.
     */
    @Override
    public boolean pagamento(int pagamento) {
        if (assinatura) {
            System.out.println("Pagando " + pagamento + " Usando PayPal.");
            return true;
        } else {
            return false;
        }
    }

    private void setAssinatura(boolean assinatura) {
        this.assinatura = assinatura;
    }
    
}
