/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Piotrek
 */
@Entity
@Table(name = "kategoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kategoria.findAll", query = "SELECT k FROM Kategoria k")
    , @NamedQuery(name = "Kategoria.findByIDKat", query = "SELECT k FROM Kategoria k WHERE k.iDKat = :iDKat")
    , @NamedQuery(name = "Kategoria.findByNazwa", query = "SELECT k FROM Kategoria k WHERE k.nazwa = :nazwa")})
public class Kategoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Kat")
    private Integer iDKat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 24)
    @Column(name = "Nazwa")
    private String nazwa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDKat")
    private Collection<Uzytkownik> uzytkownikCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDKat")
    private Collection<Produkt> produktCollection;

    public Kategoria() {
    }

    public Kategoria(Integer iDKat) {
        this.iDKat = iDKat;
    }

    public Kategoria(Integer iDKat, String nazwa) {
        this.iDKat = iDKat;
        this.nazwa = nazwa;
    }

    public Integer getIDKat() {
        return iDKat;
    }

    public void setIDKat(Integer iDKat) {
        this.iDKat = iDKat;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @XmlTransient
    public Collection<Uzytkownik> getUzytkownikCollection() {
        return uzytkownikCollection;
    }

    public void setUzytkownikCollection(Collection<Uzytkownik> uzytkownikCollection) {
        this.uzytkownikCollection = uzytkownikCollection;
    }

    @XmlTransient
    public Collection<Produkt> getProduktCollection() {
        return produktCollection;
    }

    public void setProduktCollection(Collection<Produkt> produktCollection) {
        this.produktCollection = produktCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDKat != null ? iDKat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kategoria)) {
            return false;
        }
        Kategoria other = (Kategoria) object;
        if ((this.iDKat == null && other.iDKat != null) || (this.iDKat != null && !this.iDKat.equals(other.iDKat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nazwa;
    }
    
}
