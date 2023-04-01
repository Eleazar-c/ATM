package com.mycompany.atm;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Eleazar
 */
public class BaseDeDatos {
    //por medio de la clasae File podemos representar archivos
    File fileObj = new File("Cuenta.txt");
    //Escribir dentro del archivo
    public void escribir(){
        try {
            //si solo usamos solo el fw para escribir, el fw va a escribir de una vez al archivo
            FileWriter fw = new FileWriter(fileObj);
            
            //Guarda los datosen memoria, y de ultimo los escribre (esto sirve para temas de eficencia)
            BufferedWriter bw = new BufferedWriter(fw);
            
            //Escribimos el contenido del archivo
            //bw.write("Hola Mundo");  //Escritura con fw.write("Hola Mundo");
            
            //numero de cuenta, nip,saldo,saldo flotante
            bw.write("12345|23456|123.00|0.00");
            bw.newLine(); //Salto de linea  "Enter"
            bw.write("98765|13579|1000.00|33.00");
            bw.newLine(); //Salto de linea  "Enter"
            //Cerramos el archivo
            bw.close();
        } catch (IOException ex) {
            //Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex.getMessage());
        }
    }
    
    public void leer(){
        try {
            FileReader fr = new FileReader(fileObj);
            BufferedReader br = new BufferedReader(fr);
            //Leer un linea completa del archivo
                //System.out.println(br.readLine()); //Ejemplo lee una linea del archivo

            //Para leer todas las lineas del archivo utilizamos un bucle
            String LineaArchivo;
            while ((LineaArchivo  = br.readLine()) != null) {                
                System.out.println(LineaArchivo);
            }
            
            br.close();
        } catch (FileNotFoundException ex) { //Captura errores FileNotFoundException
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) { // Captura erores IOException
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void agregarDatos(){
        try {
            //Indicamos que vamos agregar datos al archivo y para indicarle que vamos agregar le pasamos un segundo parametro de tipo booleano (True)
            FileWriter fw = new FileWriter(fileObj,true);
            
            BufferedWriter bw = new BufferedWriter(fw);
            
            //numero de cuenta, nip,saldo,saldo flotante
            bw.write("88888|23456|123.00|0.00");
            bw.newLine(); //Salto de linea  "Enter"
            bw.write("99999|13579|1000.00|33.00");
            bw.newLine(); //Salto de linea  "Enter"
            //Cerramos el archivo
            bw.close();
        } catch (IOException ex) {
            //Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex.getMessage());
        }
    }
    
    public void eliminar(){
        String numeroCuentaAEliminar = "88888";
        
        
        try {
            //1. Creamos una copia del archivo que represente la copia del archivo original
            File cpFileObj = new File("CopiaCuentas.txt");
        
            FileWriter fw = new FileWriter(cpFileObj);
            BufferedWriter bw =new  BufferedWriter(fw);
            
            FileReader rf = new FileReader(fileObj);
            BufferedReader br = new BufferedReader(rf);
            String LineaArchivo;
            while ((LineaArchivo  = br.readLine()) != null) {   
                if(!LineaArchivo.startsWith(numeroCuentaAEliminar)){
                    bw.write(LineaArchivo); 
                    bw.newLine();
                }
            }
            
            bw.close();
            br.close();
            
            //Renombramos el nuevo archivo con el nombre del archivo original
            cpFileObj.renameTo(fileObj);
        } catch (IOException ex) {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
