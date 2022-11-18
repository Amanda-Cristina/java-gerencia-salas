/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Monica
 */
@Entity
@Table(name = "salas")
@NamedQueries({
    @NamedQuery(name = "Salas.findAll", query = "SELECT s FROM Salas s"),
    @NamedQuery(name = "Salas.findById", query = "SELECT s FROM Salas s WHERE s.id = :id"),
    @NamedQuery(name = "Salas.findByDescricao", query = "SELECT s FROM Salas s WHERE s.descricao = :descricao"),
    @NamedQuery(name = "Salas.findByCapacidade", query = "SELECT s FROM Salas s WHERE s.capacidade = :capacidade"),
    @NamedQuery(name = "Salas.findByBloco", query = "SELECT s FROM Salas s WHERE s.bloco = :bloco")})
public class Salas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "descricao")
    private String descricao;
    @Basic(optional = false)
    @Column(name = "capacidade")
    private int capacidade;
    @Column(name = "bloco")
    private String bloco;

    public Salas() {
    }

    public Salas(Integer id) {
        this.id = id;
    }

    public Salas(Integer id, String descricao, int capacidade, String bloco) {
        this.id = id;
        this.descricao = descricao;
        this.capacidade = capacidade;
        this.bloco = bloco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getBloco() {
        return bloco;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salas)) {
            return false;
        }
        Salas other = (Salas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return id + " - " + descricao;
    }
    
}
