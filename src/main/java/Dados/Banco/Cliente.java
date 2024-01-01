package Dados.Banco;

import Dados.Banco.TiposDeConta.Conta;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cliente {
    private String nome;
    private Conta conta;
    private String endereco;
    private String cpf;

    public Cliente(String nome,  String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public Cliente(Conta conta) {
        this.conta = conta;
    }

    public Cliente() {

    }
}
