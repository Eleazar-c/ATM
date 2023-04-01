/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.atm;

/**
 *
 * @author Eleazar
 */
public class ATM {

    public static void main(String[] args) {
        
        //ATMCLASS atmObj = new ATMCLASS();
        
        BaseDeDatos bd = new BaseDeDatos();
        //bd.escribir();
        //bd.leer();
        //bd.agregarDatos();
        bd.eliminar();
        /*
        ATM atm = new ATM();
        Cuenta cuenta = new Cuenta("Miguel");
        cuenta.acreditar(0);
        cuenta.consultar(0);
        // cuenta.nip;
        cuenta.setNumeroDeCuenta(1512543);
        // cuenta.saldo;

        // Cuando es una relacion de agregacion
        // ATM atm = new ATM(new Teclado());
        
        
        */
            

    }
}
