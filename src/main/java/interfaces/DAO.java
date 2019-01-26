/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;

/**
 *
 * @author aarongmx
 * @param <Key>
 * @param <Obj>
 */
public interface DAO<Key, Obj> {
    void insert(Obj obj);
    void update(Obj obj);
    void delete(Obj obj);
    Obj getById(Key key);
    List<Obj> list();
}
