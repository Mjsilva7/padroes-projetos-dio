package kamauro.strategy.fechamento;

/**
 * Interface comum para todas as estratégias
 */

public interface PagamentoStrategy {

    boolean pagamento(int pagamento);
    void detalhePagamento();    
}
