/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SBP;

import entity.Uzytkownik;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Piotrek
 */
@Stateless
public class UzytkownikFacade extends AbstractFacade<Uzytkownik> {

    @PersistenceContext(unitName = "magazynPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    public Uzytkownik logowanie(String login, String haslo)
    {
       Uzytkownik wynik= new Uzytkownik();
        try {
             TypedQuery<Uzytkownik> q2
                = em.createQuery("SELECT c FROM Uzytkownik c WHERE c.login=:login AND c.haslo=:haslo", Uzytkownik.class).setParameter("login", login).setParameter("haslo", haslo);
            if (q2.getSingleResult() != null) {
                wynik = q2.getSingleResult();
            }
        } catch (NoResultException e) {

            wynik = null;
        }
        return wynik; 
    }
    public UzytkownikFacade() {
        super(Uzytkownik.class);
    }
    public List<Uzytkownik> pokaz(Uzytkownik a)
    {
      int z = a.getIDUzyt();
        TypedQuery<Uzytkownik> query=
                em.createQuery("SELECT a FROM Uzytkownik a WHERE a.iDUzyt =:z",Uzytkownik.class).setParameter("z", z);
        List<Uzytkownik> wynik = query.getResultList();
        return wynik; 
    } 
}
