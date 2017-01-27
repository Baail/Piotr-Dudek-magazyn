/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SBP;

import entity.Produkt;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    
}
