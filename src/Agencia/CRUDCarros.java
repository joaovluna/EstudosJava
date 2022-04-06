package Agencia;

import Carros.Carro;

import java.util.List;

//CRUD
//Create
//Read
//Update
//Delete
public interface CRUDCarros {

    public void create(Carro T);
    public void read(String marca, String modelo);
    public void update(Carro antigo, Carro atualizado);
    public void delete(String marca, String modelo);


}
