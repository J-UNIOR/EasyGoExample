/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author T490
 */
@Local
public interface menuEntityFacadeLocal {

    void create(menuEntity menuEntity);

    void edit(menuEntity menuEntity);

    void remove(menuEntity menuEntity);

    menuEntity find(Object id);

    List<menuEntity> findAll();

    List<menuEntity> findRange(int[] range);

    int count();
    
}
