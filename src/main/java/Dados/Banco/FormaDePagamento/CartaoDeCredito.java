package Dados.Banco.FormaDePagamento;

import Dados.Banco.Cliente;
import Dados.Banco.TiposDeConta.ContaCorrente;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartaoDeCredito extends ContaCorrente {

    private String numeroCartao;
    private double limite;
    private double saldoDevido;

    public CartaoDeCredito(Cliente cliente) {
        super(cliente);
    }

    public CartaoDeCredito(Cliente cliente, String numeroCartao, double limite, double saldoDevido) {
        super(cliente);
        this.numeroCartao = numeroCartao;
        this.limite = limite;
        this.saldoDevido = saldoDevido;
    }

    public void realizarCompra(double valor) {
        if (valor < 0) {
            System.out.println("Erro: Valor da compra não pode ser negativo.");
            return;
        }

        if (valor > limite - saldoDevido) {
            System.out.println("Erro: Limite de crédito excedido para a compra de " + valor + ".");
            return;
        }

        saldoDevido += valor;
        System.out.println("Compra de " + valor + " realizada com sucesso. Saldo devido: " + saldoDevido);
    }

    public void realizarPagamento(double valor) {
        if (valor < 0) {
            System.out.println("Erro: Valor do pagamento não pode ser negativo.");
            return;
        }

        if (valor > saldoDevido) {
            System.out.println("Erro: Valor do pagamento excede o saldo devido.");
            return;
        }

        saldoDevido -= valor;
        System.out.println("Pagamento de " + valor + " realizado com sucesso. Saldo devido: " + saldoDevido);
    }

}
