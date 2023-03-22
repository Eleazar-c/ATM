/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atm;

/**
 *
 * @author Eleazar
 */
public class Cuenta {
     private static float saldo;
    private int numeroDeCuenta;
    private int nip;
    private static float saldoRetenido;

   

    
    public void Cuenta(){
        
    }
    // Metodo de asociacion ----------
    Cliente clienteObj;

    public Cliente gerCliente() {
        return this.clienteObj;
    }

    public void setCliente(Cliente cliente) {
        this.clienteObj = cliente;
    }

    // Metodos Getters y Setters
    public float getSaldo() {// Obtener el valor
        return saldo;
    }

    public void setSaldo(float saldo) {// Setear un valor
        this.saldo = saldo;
    }

    public int getNumeroDeCuenta() {
        return numeroDeCuenta;
    }

    public void setNumeroDeCuenta(int numeroDeCuenta) {
            this.numeroDeCuenta = numeroDeCuenta;
    }

    public int getNip() {
        return nip;
    }

    public void setNip(int nip) {
        this.nip = nip;
    }
    
     public float getSaldoRetenido() {
        return saldoRetenido;
    }

    public void setSaldoRetenido(float saldoRetenido) {
        Cuenta.saldoRetenido = saldoRetenido;
    }

    // Fin de los Getters y Setters

    /*
    // inicializa el estado del objeto
    Cuenta(String nombre) {
        System.out.print("Este es una ejemplo del constructor");
    }
*/
    public void acreditar(float monto) {
        this.saldo = this.saldo+Float.valueOf(monto);
    }

    public void debitar(float monto) {
        this.saldo = this.saldo-Float.valueOf(monto);
    }

    public float consultar(Transaccion transaccionobj) {
         return transaccionobj.consultar();
    }
    public float consultar(int numeroDeCuenta) {
        return 0.0f;
    }
    
    
     /*la sobre carga de metodos es cuando tenemos un metodos con el mismos nombre pero con diferente firma en la misma clase
        Puede ocurrir independiente mente de la herencia*/
        /*Ejemplo*/
    public void consultar(){
        System.out.println("Se invoca a consultar");
    }
    
    
}
