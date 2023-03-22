/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atm;

/**
 *
 * @author Eleazar
 */
public class Deposito extends Transaccion {
 
     private float monto;

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }
    
    public void ejecutar(){
        
        //super.ejecutar();/*Con esto hacemos que se ejecute la clase padre y despues se ejecute la clase hijo. Nota Los parametros deben de estar en el mismo orden*/
        //System.out.println("Se ejecuta el metodo de ejecutar() de la clase Retiro.");
        
        Cuenta cuentaObj = new Cuenta();
        cuentaObj.acreditar(this.monto);
        float saldoRetenido = cuentaObj.getSaldoRetenido();
        cuentaObj.setSaldoRetenido(saldoRetenido+this.monto);
        
       
    }
}
