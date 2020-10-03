/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Modelo.Bit;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author madar
 */
public class SopaBinaria {
    
    private Bit mySopaBinaria[][];
    
    private ArrayList<int[]> posciones ;

    public SopaBinaria() {
    }
    

     public SopaBinaria(String rutaArchivoExcel, int pHoja) throws IOException, Exception  {    

         HSSFWorkbook archivoExcel = new HSSFWorkbook(new FileInputStream(rutaArchivoExcel));
        //Obtiene la hoja 1
        HSSFSheet hoja = archivoExcel.getSheetAt(pHoja);
        //Obtiene el número de la última fila con datos de la hoja.
        int canFilas = hoja.getLastRowNum() + 1;
        this.mySopaBinaria = new Bit[canFilas][];
        for (int i = 0; i < canFilas; i++) {
            HSSFRow filas = hoja.getRow(i);
            int cantCol = filas.getLastCellNum();
            this.mySopaBinaria[i] = new Bit[cantCol];

            for (int j = 0; j < cantCol; j++) {

                String valor = filas.getCell(j).getStringCellValue();
                
                

                Bit nuevo = new Bit();
                switch (valor) {
                    case "0":
                        nuevo.setValor(false);
                        this.mySopaBinaria[i][j] = nuevo;
                        break;

                    case "1":
                        nuevo.setValor(true);
                        this.mySopaBinaria[i][j] = nuevo;
                        break;
                        
                    default:
                        throw new Exception("Hay valores en la matriz diferentes a 0 o 1: "+"  "+valor);
                        

                }

            }

        }
    }
    /**
     * Metodo que convierte un entero en un array de objetos de tipo Bit. 
     * Es la representación en binario del entero ingresado.
     * @param decimal
     * @return Array de objetos tipo Bit
     */
    private Bit[] obtenerDecimalEnBits(int decimal){
    
        String numero=Integer.toBinaryString(decimal);
        Bit binario[]= new Bit [numero.length()];
        
        for (int i =0; i<numero.length();i++) {
            if(numero.charAt(i)=='1')
                binario[i]=new Bit(true);  
            
            else binario[i]=new Bit(false);
        }
        
        return binario;
    }
    public int getCuantasVeces_Horizontal(int decimal)
    {
        Bit numero[]=obtenerDecimalEnBits(decimal);
        
        boolean encontro=false;
        
        int contador=0;
        
        //Busque hacia la derecha
        for (int[] pos : this.posciones) {
          
           if(pos[1]+numero.length-1 < this.mySopaBinaria[pos[0]].length){
               int iNumero=0;
               for(int i=pos[1];i<numero.length;i++){
                  
                   //System.out.println(i+" , "+iNumero+" , "+pos[0]);
                   if(!mySopaBinaria[pos[0]][i].equals(numero[iNumero]))
                       break;
                   
                   else iNumero++;
                   
                   if(iNumero==numero.length-1){
                       encontro=true;
                       System.out.println("ASASA"+pos[0]+" , "+i);
                       contador++;
                   }
                   
               }
           }
           
            //i>=0
           if(pos[1]-(numero.length-1) >=0){
               System.out.println("***************************");
               int iNumero=0;
               for(int i=pos[1];i>=pos[1]-(numero.length-1);i--){
                   if(!mySopaBinaria[pos[0]][i].equals(numero[iNumero]))
                       break;
                   
                   if(iNumero==numero.length-1){
                       encontro=true;
                       contador++;
                       System.out.println("Reves"+pos[0]+" , "+i);
                   }
                   iNumero++;
               }
           }
           
        }
        
        
        return contador;
    }
    
    
    public int getCuantasVeces_Vertical(int decimal)
    {
        Bit numero[]=obtenerDecimalEnBits(decimal);
        
        boolean encontro=false;
        
        int contador=0;
        
        //Busque hacia la derecha
        for (int[] pos : this.posciones) {
          
           if(pos[0]+numero.length-1 < this.mySopaBinaria.length){
               int iNumero=0;
               for(int i=pos[0];i < this.mySopaBinaria.length;i++){
                  
                   if(!mySopaBinaria[pos[0]][i].equals(numero[iNumero]))
                       break;
                   
                   if(iNumero==numero.length-1){
                       encontro=true;
                       contador++;
                   }
                   iNumero++;
               }
           }
           
            
           if(pos[1]-(numero.length-1) >=0){
               System.out.println("***************************");
               int iNumero=0;
               for(int i=pos[1];i>=0;i--){
                   if(!mySopaBinaria[pos[0]][i].equals(numero[iNumero]))
                       break;
                   
                   if(iNumero==numero.length-1){
                       encontro=true;
                       contador++;
                   }
                   iNumero++;
               }
           }
           
        }
        
        
        return contador;
    }
    
    
    
    public int getCuantasVeces_Diagonal(int decimal)
    {
        return 0;
    }
    
    
     public String[][] getMatrizEnString() {

        String matrizEnString[][] = new String[this.mySopaBinaria.length][];
        String valor = "0";
        for (int i = 0; i < mySopaBinaria.length; i++) {
            matrizEnString[i] = new String[this.mySopaBinaria[i].length];
            for (int j = 0; j < matrizEnString[i].length; j++) {
                switch (this.mySopaBinaria[i][j].toString()) {
                    case "1":
                        valor = "1";
                        matrizEnString[i][j] = valor;
                        break;

                    case "0":
                        matrizEnString[i][j] = valor;
                        break;

                }
            }

        }
        return matrizEnString;
    }
    
    public Bit[][] getMatriz() {
        return this.mySopaBinaria;
    }
    public String toString()
    {
    String msg="";
        for( Bit filas[]:this.mySopaBinaria)
        {
            for(Bit valor: filas)
                msg+=valor.toString()+"\t";
        msg+="\n";
        }
        
    return msg;
    }
    
    public String buscar(int decimal){
    
        System.out.println(toString());
        String msg="";
        String decimalBinario ="";
        Bit numero[]= this.obtenerDecimalEnBits(decimal);
        
        buscarUnos();
        
        
        for (Bit bit : numero) {
            decimalBinario+=bit.toString();
        }
        int cuantasVecesTotal=this.getCuantasVeces_Diagonal(decimal)+
                this.getCuantasVeces_Horizontal(decimal);
        msg="Se econtro el numero decimal "+decimal+" en binario: "+decimalBinario+
                " "+cuantasVecesTotal+" veces en la sopa binaria.";
        return msg;
    
    }
    
    private void buscarUnos(){
    
    this.posciones = new ArrayList <int[]>();
        
        for (int i = 0; i < this.mySopaBinaria.length; i++) {
            for (int j = 0; j < this.mySopaBinaria[i].length; j++) {
                
                int pos []= new int [2];
                pos[0]=i;
                pos[1]=j;
                
                //System.out.println(pos[0]+","+pos[1]);
                if(this.mySopaBinaria[i][j].isValor()){
                    this.posciones.add(pos);
                }
                //System.out.println(this.mySopaBinaria[i][j].isValor());
                
            }
            
        }
        
    }
    
    private void buscarUnosPrueba(){
        for (int i =0;i<this.posciones.size();i++) {
            int pos[]=this.posciones.get(i);
            System.out.println(pos[0]+","+pos[1]);
            
            
        }
    }
            

   
}
