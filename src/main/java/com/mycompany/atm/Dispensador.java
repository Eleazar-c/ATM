/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atm;

/**
 *
 * @author Eleazar
 */
public class Dispensador {
    
    private static int efectivoDisponible ;

    public int getEfectivoDisponible() {
        return efectivoDisponible;
    }

    public void setEfectivoDisponible(int efectivoDisponible) {
        Dispensador.efectivoDisponible = efectivoDisponible;
    }
    

    public void entregarEfectivo(int monto) {
        this.setEfectivoDisponible((this.getEfectivoDisponible()-monto));
    }
    
}
