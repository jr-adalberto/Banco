package Dados.Banco.TiposDeConta;

import Dados.Banco.Cliente;

public class ContaInvestimento extends Conta {
    private double saldo;
    private double taxaJuros;

    public ContaInvestimento(Cliente cliente, double saldo, double taxaJuros) {
        super(cliente);
        this.saldo = saldo;
        this.taxaJuros = taxaJuros;
    }

    public void investir(double valor) {
        if (valor <= 0) {
            System.out.println("Erro: Valor de investimento deve ser maior que zero.");
            return;
        }

        saldo += valor;
        System.out.println("Investimento de " + valor + " realizado com sucesso. Novo saldo: " + saldo);
    }

    public void calcularJuros() {
        saldo += saldo * (taxaJuros / 100);
        System.out.println("Juros calculados. Novo saldo: " + saldo);
    }

    public void resgatarInvestimento() {
        System.out.println("Resgate de investimento de " + saldo + " realizado com sucesso.");
        saldo = 0;
    }

    @Override
    public void imprimirExtrato() {

    }
}
