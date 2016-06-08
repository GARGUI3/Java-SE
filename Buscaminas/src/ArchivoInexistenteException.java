/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author gargui3
 */
public class ArchivoInexistenteException extends Exception {

    /**
     * Creates a new instance of <code>ArchivoInexistenteException</code>
     * without detail message.
     */
    public ArchivoInexistenteException() {
    }

    /**
     * Constructs an instance of <code>ArchivoInexistenteException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public ArchivoInexistenteException(String msg) {
        super(msg);
    }
}
