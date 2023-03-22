/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atm;

import java.text.DecimalFormat;

/**
 *
 * @author Eleazar
 */
public class ATMCLASS {
    // Instanciamos las clases necesacia ---<■> (Composision) Dependencia Fuerte
    // Dispensador dispensadorobj = new Dispensador();
    // RanuraDeDeposito ranuaraDepositoObj = new RanuraDeDeposito();
    // Teclado tecladoObj = new Teclado();
    // Pantalla pantallaObj = new Pantalla();

    // Segunda Forma para inicializar los objetos
        
    private Dispensador dispensadorobj;
    private RanuraDeDeposito ranuaraDepositoObj;
    private Teclado tecladoObj;
    private Pantalla pantallaObj;
    private Transaccion transaccionObj;
    private Cuenta cuentaObj;

    ATMCLASS() {
        this.dispensadorobj = new Dispensador();
        this.pantallaObj = new Pantalla();
        this.ranuaraDepositoObj = new RanuraDeDeposito();
        this.tecladoObj = new Teclado();
        this.cuentaObj = new Cuenta();
        
        this.inicializar();
    }

    
        
    
    // Si es una relacion de agregacion (---<>) es cuando el constructor espera un
    // parametro de objeto teclado Ejemplo Nota:Para la agregacion se necesita un
    // constructor
    // Teclado tecladoObj;
    // ATM(Teclado tecladoParametro) {
    // dispensadorobj = new Dispensador();
    // ranuaraDepositoObj = new RanuraDeDeposito();
    // pantallaObj = new Pantalla();
    // this.tecladoObj = tecladoParametro;
    // }

    private void inicializar(){
       int numeroDeCuenta;
        int nip;
        int opcionMenu;
        boolean indicador;
        //El mensaje de bienvenida solo se mostrara una vez
        pantallaObj.mostrarMensajeSaltoLinea("Bienvenido!");
        do {            
            pantallaObj.mostrarMensaje("Ingrese su numero de cuenta:");
            numeroDeCuenta = tecladoObj.recibirEntrada();
            pantallaObj.mostrarMensaje("Ingrese su NIP:");
            nip = tecladoObj.recibirEntrada();
            if (this.autenticar(nip, numeroDeCuenta)){
                indicador = true;
            }else{
                indicador = false;
                pantallaObj.mostrarMensajeSaltoLinea("ERROR: Numero de cuento y/o NIP incorrecto. Por favor digite de nuevo sus credenciales.");
                pantallaObj.mostrarMensajeSaltoLinea("---------------------------------------------------------------------------------------------");
            } 
        } while (indicador == false);
        
        //Separador
        pantallaObj.mostrarMensajeSaltoLinea("---------------------------------------------------------------------------------------------");

        /*Empieza el proceso de la accion del ATM*/
        cuentaObj.setSaldo((float) 50000.35);
        
        do {
            pantallaObj.mostrarMenu();
            opcionMenu = tecladoObj.recibirEntrada();
            pantallaObj.mostrarMensajeSaltoLinea("---------------------------------------------------------------------------------------------");
            pantallaObj.mostrarMensajeSaltoLinea("");
            this.ejecutar(opcionMenu, numeroDeCuenta);
           
        } while (opcionMenu != 4);
        
        
        
        
        
        
        
    }
    
    public void ejecutar(int opocion, int numeroDeCuenta){
        
        switch (opocion) {
            case 1:
                this.mostrarSaldo(numeroDeCuenta);
                break;
            case 2:
                this.retirar();
                break;
            case 3:
                 pantallaObj.mostrarMensajeSaltoLinea("Digite el monto que desea depositar.");
                 pantallaObj.mostrarMensaje("Nota: Si desea cancelar la transaccion favor de digital el numero 0: ");
                int montoDepositar = tecladoObj.recibirEntrada();
                if (montoDepositar != 0){
                    this.depositar(montoDepositar);                   
                }else{
                    pantallaObj.mostrarMensajeSaltoLinea("Transaccion cancelada.");
                    pantallaObj.mostrarMensajeSaltoLinea("---------------------------------------------------------------------------------------------");
                    pantallaObj.mostrarMensajeSaltoLinea("");
                }
            case 4:
                pantallaObj.mostrarMensajeSaltoLinea("Que tenga un buen dia!");
                break;
            default:
                pantallaObj.mostrarMensajeSaltoLinea("NOTA: Debe selecionar una opcion que aparesca en la pantalla");
                pantallaObj.mostrarMensajeSaltoLinea("---------------------------------------------------------------------------------------------");
                break;
        }
    }
    public void depositar(int monto) {
       
        int confirmacion =0;
        float montoDepositar = monto / 100;
        
            if (montoDepositar < 0){
                pantallaObj.mostrarMensajeSaltoLinea("  ERROR: El monto a depositar no puede ser menor a cero. Transaccion cancelada.");
                pantallaObj.mostrarMensajeSaltoLinea("---------------------------------------------------------------------------------------------");
                pantallaObj.mostrarMensajeSaltoLinea("");
            }else{
                pantallaObj.mostrarMensajeSaltoLinea("Favor introduccior el sobre en la ranura de deposito, tiempo estimado de respuesta 2 minutos.");
                pantallaObj.mostrarMensajeSaltoLinea("  1.Cuando introdusca el sobre favor de digitar el numero 1");
                pantallaObj.mostrarMensajeSaltoLinea("  2.Si desea cancelar digite cualquier numero.");
                pantallaObj.mostrarMensajeSaltoLinea("---------------------------------------------------------------------------------------------");

                confirmacion = tecladoObj.recibirEntrada();
                if (confirmacion == 1){
                    acreditar(montoDepositar);
                }else{
                    pantallaObj.mostrarMensajeSaltoLinea("Transaccion Cancelada");
                    pantallaObj.mostrarMensajeSaltoLinea("---------------------------------------------------------------------------------------------");
                    pantallaObj.mostrarMensajeSaltoLinea("");
                }
            }
            

    }

    public void acreditar(float monto) {
         //Polimorfismo
        Transaccion transaccionoDepositoObj = new Deposito();
        transaccionoDepositoObj.setMonto(monto);
        transaccionoDepositoObj.ejecutar();
        
        pantallaObj.mostrarMensajeSaltoLinea(String.format("Deposito realizado con exito por la cantidad de: %s", new DecimalFormat(",###.00").format(monto)) );
        pantallaObj.mostrarMensajeSaltoLinea("NOTA:El dinero depositado no esta disponible, hasta que el banco realice la verificacion.");
        pantallaObj.mostrarMensajeSaltoLinea("---------------------------------------------------------------------------------------------");
        pantallaObj.mostrarMensajeSaltoLinea("");
    }

    public void mostrarSaldo(int numeroDeCuenta) {
        float saldo  = cuentaObj.getSaldo();
        float saldoFlotante = cuentaObj.getSaldoRetenido();
        pantallaObj.mostrarMensajeSaltoLinea("---------------------------------------------------------------------------------------------");
        pantallaObj.mostrarMensajeSaltoLinea(String.format("El saldo de su cuenta es: %s", new DecimalFormat(",###.00").format(saldo)));
        pantallaObj.mostrarMensajeSaltoLinea(String.format("El saldo flotante es: %s", new DecimalFormat(",###.00").format(saldoFlotante)));
        pantallaObj.mostrarMensajeSaltoLinea(String.format("El saldo disponible es: %s", new DecimalFormat(",###.00").format((saldo-saldoFlotante))));
        pantallaObj.mostrarMensajeSaltoLinea("---------------------------------------------------------------------------------------------");
        pantallaObj.mostrarMensajeSaltoLinea("");
    }

    public void retirar() {
        
        int montoRetiro;
        String mensaje;
        //this.transaccionObj = new Retiro();
        int opcion;
        do {            
            pantallaObj.mostrarMenuRetiro();
            opcion = tecladoObj.recibirEntrada();
            pantallaObj.mostrarMensajeSaltoLinea("---------------------------------------------------------------------------------------------");
                    pantallaObj.mostrarMensajeSaltoLinea("");
             switch (opcion) {
                case 1 -> {
                    montoRetiro = 20;
                    mensaje="";
                    break;
                }
                case 2 -> {
                     montoRetiro = 40;
                     mensaje=".Por favor seleccione un monto más pequeño";
                    break;
                }
                case 3 -> {
                    montoRetiro = 60;
                    mensaje=".Por favor seleccione un monto más pequeño";
                    break;
                }
                case 4 -> {
                      montoRetiro = 100;
                      mensaje=".Por favor seleccione un monto más pequeño";
                    break;
                }
                case 5 -> {
                     montoRetiro = 200;
                     mensaje=".Por favor seleccione un monto más pequeño";
                    break;
                }
                case 6 -> {
                     montoRetiro = 0;
                     mensaje ="";
                    break;
                }
                default -> {
                    montoRetiro=0;
                    mensaje ="";

                    pantallaObj.mostrarMensajeSaltoLinea("NOTA: Debe selecionar una opcion que aparesca en la pantalla");
                    pantallaObj.mostrarMensajeSaltoLinea("---------------------------------------------------------------------------------------------");
                    pantallaObj.mostrarMensajeSaltoLinea("");
                }
            }
             
             if (montoRetiro != 0){
                //comienza el proceso de debito
                //Se verifica si la cuenta del cliente tiene el saldo disponible para retirar
                if (montoRetiro <= cuentaObj.getSaldo()){
                    //Se verifica si el ATM tiene el saldo disponible para dicha transaccion
                    float saldoAtm = dispensadorobj.getEfectivoDisponible();
                    if ((saldoAtm- montoRetiro) < 0){
                        pantallaObj.mostrarMensajeSaltoLinea(String.format("Actualmente el ATM no tiene el fondo disponible que desea retirar. Monto Actual del ATM (%s),%s", new DecimalFormat(",###.00").format(saldoAtm),mensaje));
                        pantallaObj.mostrarMensajeSaltoLinea("---------------------------------------------------------------------------------------------");
                        pantallaObj.mostrarMensajeSaltoLinea("");
                    }else{  
                        debitar(montoRetiro);
                        opcion = 6;
                    }                    
                }else{
                    pantallaObj.mostrarMensajeSaltoLinea("El monto a retirar es mayor al saldo disponible de la cuenta.");
                    pantallaObj.mostrarMensajeSaltoLinea("---------------------------------------------------------------------------------------------");
                    pantallaObj.mostrarMensajeSaltoLinea("");
                }
            }      
        } while (opcion != 6);
       
         
    }

    public void debitar(int monto) {
        //Polimorfismo
        Transaccion transaccionRetiroObj = new Retiro(); 
        float montoRetirar = Float.valueOf(monto);
         //si el ATM tiene los fondos disponibles procede a descontar de la cuenta
         float saldoAtm = dispensadorobj.getEfectivoDisponible();
        transaccionRetiroObj.setMonto(montoRetirar);
        transaccionRetiroObj.ejecutar();
        //Despues descuenta el efectivo del ATM
        dispensadorobj.setEfectivoDisponible((int) (saldoAtm-monto));
        //mostramos el mensaje para que el cliente retire su efectivo
        pantallaObj.mostrarMensajeSaltoLinea("Dinero disponible en el dispensador, favor de tomarlo.");
        pantallaObj.mostrarMensajeSaltoLinea("---------------------------------------------------------------------------------------------");
        pantallaObj.mostrarMensajeSaltoLinea("");
    }
    
    public boolean autenticar(int nip, int numero){
        boolean Valor = true;
        if((numero > 9999 && numero < 100000) && (nip > 9999 && nip < 100000)){
            cuentaObj.setNumeroDeCuenta(numero);
            cuentaObj.setNip(nip);
         }else{
           Valor = false;
        }
        return Valor;
    }

}
