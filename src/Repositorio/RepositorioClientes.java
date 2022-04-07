package Repositorio;

import Carros.Carro;
import Clientes.Cliente;
import Observer.Observador;
import Observer.Sujeito;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;

public class RepositorioClientes implements Observador {
    Collection<Cliente> clientes;

    public RepositorioClientes() {
        clientes = new ArrayList<>();
    }

    public void create(Cliente T) {
        clientes.add(T);
        System.out.println("Cliente cadastrado com sucesso");
    }

    public void read(String id) {

        boolean flag = false;

        for (Cliente cliente : clientes) {
            if (cliente.getId().toLowerCase(Locale.ROOT).equals(id.toLowerCase(Locale.ROOT))) {
                flag = true;
                System.out.printf("%1s%10s%15s%20s\n",
                        cliente.getNome(),
                        cliente.getId(),
                        cliente.getIdade(),
                        cliente.getEmail());
            }
        }
        if (!flag) {
            System.out.printf("%1s%10s%15s%20s\n", "X", "X", "X", "X");
            System.out.println("Cliente não existe");
        }
    }

    public void update(Cliente antigo, Cliente novo) {
        if (clientes.contains(antigo) && antigo != null) {
            antigo.setNome(novo.getNome());
            antigo.setId(novo.getId());
            antigo.setIdade(novo.getIdade());
            antigo.setEmail(novo.getEmail());
            System.out.println("Cliente atualizado");


        } else {
            System.out.println("Cliente não existe, impossível atualizar");
        }

    }

    public void delete(String id) {
        Cliente c = null;
        boolean flag = false;
        if (clientes.isEmpty()) {
            System.out.println("Não há carros para remover");
        } else {
            for (Cliente cliente : clientes) {
                if (cliente.getId().toLowerCase(Locale.ROOT).equals(id.toLowerCase(Locale.ROOT))) {
                    c = cliente;
                    flag = true;
                }
            }
        }
        if (flag && !clientes.isEmpty()) {
            clientes.remove(c);
            System.out.println("----------------------------DELETADO------------------------------------");
            System.out.printf("%1s%10s%15s%20s\n", "Nome", "ID", "Idade", "Email");
            System.out.printf("%1s%10s%15s%20s\n",
                    c.getNome(),
                    c.getId(),
                    c.getIdade(),
                    c.getEmail());
        } else {
            System.out.println("Impossível deletar: Cliente não existe");
        }
    }

    public void seeAll() {

        System.out.println("-------------------------------TODOS--------------------------------------");
        System.out.printf("%1s%10s%15s%20s\n", "Nome", "ID", "Idade", "Email");
        for (Cliente cliente : clientes) {
            System.out.printf("%1s%10s%15s%20s\n",
                    cliente.getNome(),
                    cliente.getId(),
                    cliente.getIdade(),
                    cliente.getEmail());

        }
    }

    public Cliente searchCliente(String id) {
        Cliente c = null;
        boolean flag = false;

        for (Cliente cliente : clientes) {
            if (cliente.getId().toLowerCase(Locale.ROOT).equals(id.toLowerCase(Locale.ROOT))) {
                flag = true;

                c = cliente;
            }
        }
        return c;
    }


    @Override
    public void atualizar(Sujeito s) { //informa aos clientes a chegada de novo carro
        Carro acao = (Carro) s;

        notificarClientes(acao);

    }

    private void notificarClientes(Carro acao) {

        System.out.println("-------------------------------NOTIFICA--------------------------------------");

        for (Cliente cliente : clientes) {

            System.out.println("Enviando para: "+ cliente.getEmail() +" VENHA CONFERIR O NOVO "+acao.getModelo()+" DA "+ acao.getMarca()+" QUE CHEGOU");

        }

        System.out.println(" Olá, venha conferir o novo "+acao.getModelo().toUpperCase(Locale.ROOT)+" da "+ acao.getMarca().toUpperCase(Locale.ROOT)+" que chegou ");

    }
}
