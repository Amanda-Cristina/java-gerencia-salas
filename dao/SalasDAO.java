/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entidades.Salas;
import java.util.List;
import jpaControllers.SalasJpaController;
import jpaControllers.exceptions.NonexistentEntityException;

/**
 *
 * @author Monica
 */
public class SalasDAO extends ClasseDAO<Salas, SalasJpaController>{
    SalasJpaController objetoJPA;

    public SalasDAO() {
        this.objetoJPA = new SalasJpaController(getEmf());
    }
    
    public void inserir(Salas sala) throws Exception{
        objetoJPA.create(sala);
    }
    
    public void editar(Salas sala) throws Exception{
        objetoJPA.edit(sala);
    }
    
    public void excluir(Integer chave) throws NonexistentEntityException{
        objetoJPA.destroy(chave);
    }
    
    public Salas consultar(Integer chave) throws NonexistentEntityException{
        Salas sala = objetoJPA.findSalas(chave);
        if(sala == null){
            throw new NonexistentEntityException("Sala "+chave+" não cadastrada");
        }
        return sala;
    }
    
    public List<Salas> consultarTodos(){
        return objetoJPA.findSalasEntities();
    }
  
  
}
