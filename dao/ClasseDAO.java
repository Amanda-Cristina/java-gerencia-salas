/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import jpaControllers.exceptions.NonexistentEntityException;

/**
 *
 * @author Monica
 */
public abstract class ClasseDAO<T1, T2> {

    private EntityManagerFactory emf;
    protected T2 objetoJPA;

    public ClasseDAO() {
        emf = Persistence.createEntityManagerFactory("AS33J-2021PU");
    }

    public abstract void inserir(T1 objeto) throws Exception;
    
    public  abstract void editar(T1 sala) throws Exception;
    
    public abstract T1 consultar(Integer chave) throws NonexistentEntityException;
  
    public abstract void excluir(Integer chave) throws NonexistentEntityException;
    
    public abstract List<T1> consultarTodos() throws NonexistentEntityException;

//    public Salas consultar(Integer chave) throws NonexistentEntityException{
//        T2 sala = objetoJPA.findSalas(chave);
//        if(sala == null){
//            throw new NonexistentEntityException("Sala "+chave+" não cadastrada");
//        }
//        return sala;
//    }

    /**
     * @return the emf
     */
    public EntityManagerFactory getEmf() {
        return emf;
    }
}
