package kamauro.strategy.fechamento;

/**
 * Ordem de aula. Não sabe qual forma de pagamento (estratégia) concreta o usuário possui
 * escolhido. Ele usa interface de estratégia comum para delegar a coleta de dados de pagamento
 * para objeto de estratégia. Ele pode ser usado para salvar pedidos no banco de dados.
 */

public class Order {

    private int totalCost = 0;
    private boolean isClosed = false;

    public void processOrder(PagamentoStrategy strategy) {
        strategy.detalhePagamento();
    }

    public void setTotalCost(int cost) {
        this.totalCost += cost;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed() {
        isClosed = true;
    }
    
}
