package kamauro.strategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import kamauro.strategy.fechamento.Order;
import kamauro.strategy.fechamento.PagamentoPorCreditCard;
import kamauro.strategy.fechamento.PagamentoPorPayPal;
import kamauro.strategy.fechamento.PagamentoStrategy;

public class Main {

    private static Map<Integer, Integer> precoProduto = new HashMap<>();
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Order order = new Order();
    private static PagamentoStrategy strategy;

    static {
        precoProduto.put(1, 2200);
        precoProduto.put(2, 1850);
        precoProduto.put(3, 1100);
        precoProduto.put(4, 890);
    }

    public static void main(String[] args) throws IOException {
        while (!order.isClosed()) {
            int custo;

            String continuarEscolha;
            do {
                System.out.print("\nPor favor, selecione o produto de acordo com o número indicado:" + "\n\n" +
                        "1 - Placa Mãe" + "\n" +
                        "2 - Processador" + "\n" +
                        "3 - Disco Rígido" + "\n" +
                        "4 - Memória" + "\n");
                int escolha = Integer.parseInt(reader.readLine());
                custo = precoProduto.get(escolha);
                System.out.print("Count: ");
                int count = Integer.parseInt(reader.readLine());
                order.setTotalCost(custo * count);
                System.out.print("Deseja continuar selecionando produtos? Y/N: ");
                continuarEscolha = reader.readLine();
            } while (continuarEscolha.equalsIgnoreCase("Y"));

            if (strategy == null) {
                System.out.println("\nPor favor, selecione o método de pagamento:" + "\n\n" +
                        "1 - PalPay" + "\n" +
                        "2 - Credit Card");
                String metodoPagamento = reader.readLine(); 

                if (metodoPagamento.equals("1")) {
                    strategy = new PagamentoPorPayPal();
                } else {
                    strategy = new PagamentoPorCreditCard();
                }
            }
            order.processOrder(strategy);

            System.out.print("Pagando " + order.getTotalCost() + " unidades ou continuar comprando? P/C: ");
            String prosseguir = reader.readLine();
            if (prosseguir.equalsIgnoreCase("P")) {
                if (strategy.pagamento(order.getTotalCost())) {
                    System.out.println("Pagamento realizado com sucesso.");
                } else {
                    System.out.println("Falha! por favor, verifique seus dados.");
                }
                order.setClosed();
            }
        }
    }
    
}
