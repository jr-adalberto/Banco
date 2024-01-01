package Dados.Banco.FormaDePagamento;

import Dados.Banco.Cliente;
import Dados.Banco.TiposDeConta.ContaCorrente;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Pix extends ContaCorrente {

    private String chavePix;
    private double saldo;

    public Pix(Cliente cliente, String chavePix, double saldo) {
        super(cliente);
        this.chavePix = chavePix;
        this.saldo = saldo;
    }

    public void realizarTransferencia(String chaveDestino, double valor) {
        if (valor <= 0) {
            System.out.println("Erro: Valor da transferência deve ser maior que zero.");
            return;
        }

        if (valor > saldo) {
            System.out.println("Erro: Saldo insuficiente para realizar a transferência de " + valor + ".");
            return;
        }

        System.out.println("Transferência de " + valor + " para " + chaveDestino + " realizada com sucesso.");
        saldo -= valor;
    }

}
