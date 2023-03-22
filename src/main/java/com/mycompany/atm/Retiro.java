/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atm;

/**
 *
 * @author Eleazar
 */
public class Retiro extends Transaccion{
    /*La sobre escritura de herencia solo se permite cuando solamente estan heredando
    La sobre escritura de metodos es el proceso de modificar un metodo de la clase padre ejemplo:*/
    private float monto;

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }
    
    /*La firma de una metodo es el nombre y el tipo de su parametros ejecutar(),ejecutar(int,String), ejecutar(int)*/
    
    public void ejecutar(){
        
        //super.ejecutar();/*Con esto hacemos que se ejecute la clase padre y despues se ejecute la clase hijo. Nota Los parametros deben de estar en el mismo orden*/
        //System.out.println("Se ejecuta el metodo de ejecutar() de la clase Retiro.");
        
        Cuenta cuentaObj = new Cuenta();
        cuentaObj.debitar(this.monto);
       
    }
    
   
       
}
