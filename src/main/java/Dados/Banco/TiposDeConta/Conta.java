package Dados.Banco.TiposDeConta;

import Dados.Banco.Cliente;
import Dados.Banco.Excecoes.TratamentoExcecoes;
import Dados.Banco.Metodos.IConta;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Conta implements IConta {

    private static int SEQUENCIAL = 1;

    private static final int AGENCIA_PADRAO = 1;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    public Conta(double saldo, Cliente cliente) {
        this.saldo = saldo;
        this.cliente = cliente;
    }

    protected int agencia;
    protected int numero;
    protected double saldo;
    private Cliente cliente;

    public Conta(double saldo, String joao) {
    }

    void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }

    @Override
    public void sacar(double valor) {
        if (valor < 0) {
            throw new TratamentoExcecoes("Valor de saque não pode ser negativo.");
        }
        if (valor > saldo) {
            throw new TratamentoExcecoes("Saldo insuficiente para saque de " + valor + ".");
        }
        saldo -= valor;
        System.out.println("Saque de " + valor + " realizado. Novo saldo: " + saldo);
    }

    public void calcularJuros() {
        double taxaJuros = 0;
        saldo += saldo * (taxaJuros / 100);
        System.out.println("Juros calculados. Novo saldo: " + saldo);
    }


    @Override
    public void depositar(double valor) {
        if (valor < 0) {
            throw new TratamentoExcecoes("Valor de depósito não pode ser negativo.");
        }
        saldo += valor;
        System.out.println("Depósito de " + valor + " realizado. Novo saldo: " + saldo);
    }


    @Override
    public void transferir(double valor, Conta contaDestino) {
        if (valor < 0) {
            throw new TratamentoExcecoes("Valor de transferência não pode ser negativo.");
        }
        if (valor > saldo) {
            throw new TratamentoExcecoes("Saldo insuficiente para transferência de " + valor + ".");
        }
        if (contaDestino == null) {
            throw new TratamentoExcecoes("Conta destino não existe.");
        }

        saldo -= valor;
        contaDestino.depositar(valor);
        System.out.println("Transferência de " + valor + " realizada para a conta " + contaDestino.getNumero());
    }
}
