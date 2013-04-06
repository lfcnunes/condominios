/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lp.condominios.models;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Pedro
 */
@Entity
@Table(name = "apartamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Apartamento.findAll", query = "SELECT a FROM Apartamento a"),
    @NamedQuery(name = "Apartamento.findById", query = "SELECT a FROM Apartamento a WHERE a.id = :id"),
    @NamedQuery(name = "Apartamento.findByNporta", query = "SELECT a FROM Apartamento a WHERE a.nporta = :nporta"),
    @NamedQuery(name = "Apartamento.findByQuartos", query = "SELECT a FROM Apartamento a WHERE a.quartos = :quartos"),
    @NamedQuery(name = "Apartamento.findByOcupacao", query = "SELECT a FROM Apartamento a WHERE a.ocupacao = :ocupacao"),
    @NamedQuery(name = "Apartamento.findByIdproprietario", query = "SELECT a FROM Apartamento a WHERE a.idproprietario = :idproprietario")})
public class Apartamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nporta")
    private Integer nporta;
    @Column(name = "quartos")
    private Integer quartos;
    @Column(name = "ocupacao")
    private Integer ocupacao;
    @Column(name = "idproprietario")
    private Integer idproprietario;

    public Apartamento() {
    }

    public Apartamento(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNporta() {
        return nporta;
    }

    public void setNporta(Integer nporta) {
        this.nporta = nporta;
    }

    public Integer getQuartos() {
        return quartos;
    }

    public void setQuartos(Integer quartos) {
        this.quartos = quartos;
    }

    public Integer getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(Integer ocupacao) {
        this.ocupacao = ocupacao;
    }

    public Integer getIdproprietario() {
        return idproprietario;
    }

    public void setIdproprietario(Integer idproprietario) {
        this.idproprietario = idproprietario;
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
        if (!(object instanceof Apartamento)) {
            return false;
        }
        Apartamento other = (Apartamento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getNporta() + " / Quartos: " + this.getQuartos();
    }
    
}
