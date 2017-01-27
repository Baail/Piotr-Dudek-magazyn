/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SBP;

import entity.Produkt;
import entity.Uzytkownik;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Piotrek
 */
@Stateless
public class ProduktFacade extends AbstractFacade<Produkt> {

    @PersistenceContext(unitName = "magazynPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProduktFacade() {
        super(Produkt.class);
    }
    

 public List<Produkt> pokaz(Uzytkownik a)
    {
      int z = a.getIDKat().getIDKat();
        TypedQuery<Produkt> query=
                em.createQuery("SELECT a FROM Produkt a WHERE a.iDKat.iDKat =:z",Produkt.class).setParameter("z", z);
        List<Produkt> wynik = query.getResultList();
        return wynik; 
    }
}