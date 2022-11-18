/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bancoDados;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import jpaControllers.SalasJpaController;
import jpaControllers.exceptions.NonexistentEntityException;

/**
 *
 * @author Monica
 */
public class SalasDAO {
    EntityManagerFactory emf;
    SalasJpaController objetoJPA;

    public SalasDAO() {
        emf = Persistence.createEntityManagerFactory("AS33J-2021PU");
        objetoJPA = new SalasJpaController(emf);
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
}
