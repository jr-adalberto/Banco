package Dados.Banco.TiposDeConta;

import Dados.Banco.Cliente;

public class ContaCorrente extends Conta {


    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        super.transferir(valor, contaDestino);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("Extrato Conta Poupanca ===");
        imprimirInfosComuns();
    }

}
