package Dados.Banco.Metodos;

import Dados.Banco.TiposDeConta.Conta;

public interface IConta {

    void sacar(double valor);

    void depositar(double valor);

    void transferir (double valor, Conta contaDestino);

    void imprimirExtrato();

}
