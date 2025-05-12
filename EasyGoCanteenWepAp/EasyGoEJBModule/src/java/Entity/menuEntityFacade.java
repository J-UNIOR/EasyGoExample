/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author T490
 */
@Stateless
public class menuEntityFacade extends AbstractFacade<menuEntity> implements menuEntityFacadeLocal {

    @PersistenceContext(unitName = "EasyGoEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public menuEntityFacade() {
        super(menuEntity.class);
    }
    
}
