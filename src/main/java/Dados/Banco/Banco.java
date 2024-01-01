package Dados.Banco;

import Dados.Banco.TiposDeConta.Conta;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Banco {
    private String nome;
    private List<Cliente> clientes;

    public Banco() {
        this.clientes = new ArrayList<>();
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void listarClientes() {
        System.out.println("Lista de Clientes:");

        for (Cliente cliente : clientes) {
            System.out.println("Nome: " + cliente.getNome() + ", CPF: " + cliente.getCpf());
        }
    }
}
