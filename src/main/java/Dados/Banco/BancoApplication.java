package Dados.Banco;


import Dados.Banco.Excecoes.TratamentoExcecoes;
import Dados.Banco.TiposDeConta.Conta;
import Dados.Banco.TiposDeConta.ContaCorrente;
import Dados.Banco.TiposDeConta.ContaPoupanca;

public class BancoApplication {

    public static void main(String[] args) {

        //criando conta depositando e transferindo valor
        Cliente adalberto = new Cliente();
        adalberto.setNome("Adalberto");

        Conta cc = new ContaCorrente(adalberto);
        cc.depositar(100);
        Conta poupanca = new ContaPoupanca(adalberto);

        cc.transferir(100, poupanca);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();


        //criacao de banco e listagem de clientes
        Banco meuBanco = new Banco();

        Cliente cliente1 = new Cliente("João", "123.456.789-01");
        Cliente cliente2 = new Cliente("Maria", "987.654.321-09");

        meuBanco.adicionarCliente(cliente1);
        meuBanco.adicionarCliente(cliente2);

        meuBanco.listarClientes();


        //tratamento de erros
        try {
            cc.sacar(1200.0); // Saldo insuficiente para saque
        } catch (TratamentoExcecoes e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            cc.depositar(-200.0); // Tentativa de depósito com valor negativo
        } catch (TratamentoExcecoes e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            cc.transferir(1500.0, poupanca); // Saldo insuficiente para transferência
        } catch (TratamentoExcecoes e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            cc.transferir(200.0, null); // Tentativa de transferência para conta inexistente
        } catch (TratamentoExcecoes e) {
            System.out.println("Erro: " + e.getMessage());
        }


    }

}
