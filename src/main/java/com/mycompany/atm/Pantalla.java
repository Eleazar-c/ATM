/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atm;

/**
 *
 * @author Eleazar
 */
public class Pantalla {
 
     private String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void mostrarMensaje(String mensaje) {
        System.out.print(mensaje);
    }
    
    public void mostrarMensajeSaltoLinea(String mensaje) {
        System.out.println(mensaje);
    }
    
    public void mostrarMenu(){
            System.out.println("Menu principal");
            System.out.println("    1.Ver mi saldo.");
            System.out.println("    2.Retirar efectivo.");
            System.out.println("    3.Depositar fondos.");
            System.out.println("    4.Salir.");
            System.out.println("Escriba una opcion:");
    }
    
    public void mostrarMenuRetiro(){
        System.out.println("Menu de retiro");
            System.out.println("    1 - $20     4 - $100");
            System.out.println("    2 - $40     5 - $200");
            System.out.println("    3 - $60     6 - Cancelar transaccion");
            System.out.println("Elija un monto de retiro:");
    }
}
