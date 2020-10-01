/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author Guillermo
 */
public class LeerMatriz_Excel {
    
    String matriz[][];
    
    public LeerMatriz_Excel()
    {
        
        
    
    
    }
    
    
    public LeerMatriz_Excel(String nombreArchivo, int numHoja) throws IOException
    {
     HSSFWorkbook archivoExcel = new HSSFWorkbook(new FileInputStream(nombreArchivo));
        //Obtiene la hoja 1
        HSSFSheet hoja = archivoExcel.getSheetAt(numHoja);
        //Obtiene el número de la última fila con datos de la hoja.
        int canFilas = hoja.getLastRowNum()+1;
        this.matriz=new String[canFilas][];
        for (int i = 0; i < canFilas; i++) {
            HSSFRow filas = hoja.getRow(i);
            int cantCol=filas.getLastCellNum();
            this.matriz[i]=new String[cantCol];
            
            
        for(int j=0;j<cantCol;j++)    
        {
     
            String valor=filas.getCell(j).getStringCellValue();
                        
            
            
            this.matriz[i][j]=valor;
        }
     
       }
        
        
    
    }
    
    
    public void imp()
    {
        System.out.println(this.toString());
        
    }
    
    
    @Override
    public String toString()
    {
    String msg="";
        for(String filas[]:this.matriz)
        {
            for(String valor:filas)
                msg+=valor+"\t";
        msg+="\n";
        }
    return msg;
    }

    public String[][] getMatriz() {
        return matriz;
    }
    
    
    
    
    
}


