/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atm;

/**
 *
 * @author Eleazar
 */
/*Una clase abstracta son clases que no se pueden instanciar*/
public abstract class Transaccion{
    
    private float monto;
  
    public void Transaccion(){
         /*polimorfismo: es un objeto que se puede comportar de forma diferentes Nota: Se puede usar polimorfismo unicamente cuando se tiene herencia.*/
        //Ejemplo:
        //Retiro retiroObj =new Retiro();
        //retiroObj.ejecutar();
        /*
        Transaccion transaccionobj1 = new Deposito();
        Transaccion transaccionobj2 = new Retiro(); 
        
        /*Areglos*/
        /*
        Retiro [] arregloRetiro = new Retiro();
        arregloRetiro[0]= new Retiro();
        arregloRetiro[1]= new Retiro();

        Transaccion [] arregloTransaccion = new Transaccion(2)
        arregloTransaccion[0]= new Retiro();
        arregloTransaccion[1]= new Deposito();
        */
    }
    
    public void ejecutar(){
        
    }
    
    public float consultar(){
         return 0;
    }
    

    public float getMonto() {
        return monto;
        //System.out.println("Se asigna una monto a la variablre monto");
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }
}
