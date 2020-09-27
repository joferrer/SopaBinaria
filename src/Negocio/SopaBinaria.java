/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Modelo.Bit;

/**
 *
 * @author madar
 */
public class SopaBinaria {
    
    private Bit mySopaBinaria[][];

    public SopaBinaria() {
    }
    
     public SopaBinaria(String rutaArchivoExcel) {
         
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
        
        
        return 0;
    }
    
    
    public int getCuantasVeces_Vertical(int decimal)
    {
        return 0;
    }
    
    
    
    public int getCuantasVeces_Diagonal(int decimal)
    {
        return 0;
    }
    
    public String convertirDecimalABinarioManual(int decimal) {
	if (decimal <= 0) {
		return "0";
	}
	StringBuilder binario = new StringBuilder();
	while (decimal > 0) {
		short residuo = (short) (decimal % 2);
		decimal = decimal / 2;
		// Insertar el dígito al inicio de la cadena
		binario.insert(0, String.valueOf(residuo));
	}
	return binario.toString();
}
}
