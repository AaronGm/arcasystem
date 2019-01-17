/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

/**
 *
 * @author aarongmx
 */
public class ExcepcionGeneral extends RuntimeException {

    public ExcepcionGeneral() {
        this("Ocurrio una excepción");
    }

    public ExcepcionGeneral( String message ) {
        super(message);
    }
}
