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
    public void insertar(Obj obj);
    public void modificar(Obj obj);
    public void eliminar(Obj obj);
    public Obj obtenerPorId(Key key);
    public List<Obj> listar();
}
