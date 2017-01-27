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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Piotrek
 */
@Entity
@Table(name = "uzytkownik")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Uzytkownik.findAll", query = "SELECT u FROM Uzytkownik u")
    , @NamedQuery(name = "Uzytkownik.findByIDUzyt", query = "SELECT u FROM Uzytkownik u WHERE u.iDUzyt = :iDUzyt")
    , @NamedQuery(name = "Uzytkownik.findByLogin", query = "SELECT u FROM Uzytkownik u WHERE u.login = :login")
    , @NamedQuery(name = "Uzytkownik.findByHaslo", query = "SELECT u FROM Uzytkownik u WHERE u.haslo = :haslo")
    , @NamedQuery(name = "Uzytkownik.findByImie", query = "SELECT u FROM Uzytkownik u WHERE u.imie = :imie")
    , @NamedQuery(name = "Uzytkownik.findByNazwisko", query = "SELECT u FROM Uzytkownik u WHERE u.nazwisko = :nazwisko")})
public class Uzytkownik implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Uzyt")
    private Integer iDUzyt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 6, max = 24)
    @Column(name = "Login")
    private String login;
    @Basic(optional = false)
    @NotNull
    @Size(min = 6, max = 24)
    @Column(name = "Haslo")
    private String haslo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 24)
    @Column(name = "Imie")
    private String imie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 24)
    @Column(name = "Nazwisko")
    private String nazwisko;
    @JoinColumn(name = "ID_Kat", referencedColumnName = "ID_Kat")
    @ManyToOne(optional = false)
    private Kategoria iDKat;

    public Uzytkownik() {
    }

    public Uzytkownik(Integer iDUzyt) {
        this.iDUzyt = iDUzyt;
    }

    public Uzytkownik(Integer iDUzyt, String login, String haslo, String imie, String nazwisko) {
        this.iDUzyt = iDUzyt;
        this.login = login;
        this.haslo = haslo;
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public Integer getIDUzyt() {
        return iDUzyt;
    }

    public void setIDUzyt(Integer iDUzyt) {
        this.iDUzyt = iDUzyt;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
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
        hash += (iDUzyt != null ? iDUzyt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Uzytkownik)) {
            return false;
        }
        Uzytkownik other = (Uzytkownik) object;
        if ((this.iDUzyt == null && other.iDUzyt != null) || (this.iDUzyt != null && !this.iDUzyt.equals(other.iDUzyt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return imie+nazwisko;
    }
    
}
