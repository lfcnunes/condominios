/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lp.condominios.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Pedro
 */
@Entity
@Table(name = "movimento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movimento.findAll", query = "SELECT m FROM Movimento m"),
    @NamedQuery(name = "Movimento.findById", query = "SELECT m FROM Movimento m WHERE m.id = :id"),
    @NamedQuery(name = "Movimento.findByDescricao", query = "SELECT m FROM Movimento m WHERE m.descricao = :descricao"),
    @NamedQuery(name = "Movimento.findByIdapartamento", query = "SELECT m FROM Movimento m WHERE m.idapartamento = :idapartamento"),
    @NamedQuery(name = "Movimento.findByValor", query = "SELECT m FROM Movimento m WHERE m.valor = :valor"),
    @NamedQuery(name = "Movimento.findByData", query = "SELECT m FROM Movimento m WHERE m.data = :data"),
    @NamedQuery(name = "Movimento.findByMes", query = "SELECT m FROM Movimento m WHERE m.mes = :mes"),
    @NamedQuery(name = "Movimento.findByAno", query = "SELECT m FROM Movimento m WHERE m.ano = :ano")})
public class Movimento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "idapartamento")
    private Integer idapartamento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private BigDecimal valor;
    @Column(name = "data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Column(name = "mes")
    private Integer mes;
    @Column(name = "ano")
    private Integer ano;

    public Movimento() {
    }

    public Movimento(Integer id) {
        this.id = id;
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

    public Integer getIdapartamento() {
        return idapartamento;
    }

    public void setIdapartamento(Integer idapartamento) {
        this.idapartamento = idapartamento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
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
        if (!(object instanceof Movimento)) {
            return false;
        }
        Movimento other = (Movimento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lp.condominios.models.Movimento[ id=" + id + " ]";
    }
    
}
