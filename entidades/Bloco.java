/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package entidades;

/**
 *
 * @author Monica
 */
public enum Bloco {
    C(1,"Bloco C"), 
    D(2,"Bloco D"), 
    E(3,"Blocod E"), 
    F(4,"Bloco F"), 
    G(5,"Bloco G");
    private int id;
    private String descricao;
    
    Bloco(int id, String descricao){
        this.id=id;
        this.descricao= descricao;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }
    
}
