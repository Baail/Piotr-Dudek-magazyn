/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Piotrek
 */
@Entity
@Table(name = "produkt")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produkt.findAll", query = "SELECT p FROM Produkt p")
    , @NamedQuery(name = "Produkt.findByIDProd", query = "SELECT p FROM Produkt p WHERE p.iDProd = :iDProd")
    , @NamedQuery(name = "Produkt.findByNazwa", query = "SELECT p FROM Produkt p WHERE p.nazwa = :nazwa")
    , @NamedQuery(name = "Produkt.findByCena", query = "SELECT p FROM Produkt p WHERE p.cena = :cena")
    , @NamedQuery(name = "Produkt.findByIlosc", query = "SELECT p FROM Produkt p WHERE p.ilosc = :ilosc")})
public class Produkt implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Prod")
    private Integer iDProd;
    @Size(max = 24)
    @Column(name = "Nazwa")
    private String nazwa;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Cena")
    private Double cena;
    @Column(name = "Ilosc")
    private Integer ilosc;
    @JoinColumn(name = "ID_Kat", referencedColumnName = "ID_Kat")
    @ManyToOne(optional = false)
    private Kategoria iDKat;

    public Produkt() {
    }

    public Produkt(Integer iDProd) {
        this.iDProd = iDProd;
    }

    public Integer getIDProd() {
        return iDProd;
    }

    public void setIDProd(Integer iDProd) {
        this.iDProd = iDProd;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    public Integer getIlosc() {
        return ilosc;
    }

    public void setIlosc(Integer ilosc) {
        this.ilosc = ilosc;
    }

    public Kategoria getIDKat() {
        return iDKat;
    }

    public void setIDKat(Kategoria iDKat) {
        this.iDKat = iDKat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDProd != null ? iDProd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produkt)) {
            return false;
        }
        Produkt other = (Produkt) object;
        if ((this.iDProd == null && other.iDProd != null) || (this.iDProd != null && !this.iDProd.equals(other.iDProd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Produkt[ iDProd=" + iDProd + " ]";
    }
    
}
