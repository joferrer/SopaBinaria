/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Modelo.Bit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author madar
 */
public class SopaBinaria {

    private Bit mySopaBinaria[][];

    private int[][] posicionesSolucion;

    private int[][] solucionesHorizontal;

    private int[][] solucionesVerticales;

    private int[][] solucionesInclinada;

    FileOutputStream elFichero;
    //private ArrayList<int[]> posciones;
    //private ArrayList<int[]> solucionHorizontal;

    public SopaBinaria() {
    }

    public SopaBinaria(String rutaArchivoExcel, int pHoja) throws IOException, Exception {

        int contadorUnos = 0;
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
                        contadorUnos++;
                        break;

                    default:
                        throw new Exception("Hay valores en la matriz diferentes a 0 o 1: " + "  " + valor);

                }

            }

        }
        this.posicionesSolucion = new int[contadorUnos][2];

    }

    /**
     * Metodo que convierte un entero en un array de objetos de tipo Bit. Es la
     * representación en binario del entero ingresado.
     *
     * @param decimal
     * @return Array de objetos tipo Bit
     */
    private Bit[] obtenerDecimalEnBits(int decimal) {

        String numero = Integer.toBinaryString(decimal);
        Bit binario[] = new Bit[numero.length()];

        for (int i = 0; i < numero.length(); i++) {
            if (numero.charAt(i) == '1') {
                binario[i] = new Bit(true);
            } else {
                binario[i] = new Bit(false);
            }
        }

        return binario;
    }

    public int getCuantasVeces_Horizontal(int decimal) {
        int tamano = this.mySopaBinaria.length * this.mySopaBinaria[0].length;
        this.solucionesHorizontal = new int[tamano * 2][this.posicionesSolucion[0].length];
        int contador = 0;
        Bit numero[] = obtenerDecimalEnBits(decimal);
        int iNumero = 0;
        for (int[] pos : this.posicionesSolucion) {
            //Busque hacia la derecha
            if (pos[1] + numero.length - 1 < this.mySopaBinaria[pos[0]].length) {
                iNumero = 0;
                for (int i = pos[1]; i < pos[1] + numero.length; i++) {
                    if (!mySopaBinaria[pos[0]][i].equals(numero[iNumero])) {
                        break;//Rompe en el momento que una de los bits no se igual al buscado
                    }
                    if (iNumero == numero.length - 1) {
                        agregarPos(pos, i, contador, 1);
                        contador++;
                    }
                    iNumero++;
                }
            }
            //Busque hacia la izquierda
            if (pos[1] - (numero.length - 1) >= 0) {
                iNumero = 0;
                for (int i = pos[1]; i >= pos[1] - (numero.length - 1); i--) {
                    if (!mySopaBinaria[pos[0]][i].equals(numero[iNumero])) {
                        break; //Rompe en el momento que una de los bits no se igual al buscado
                    }
                    if (iNumero == numero.length - 1) {
                        agregarPos(pos, i, contador, 1);
                        contador++;
                    }
                    iNumero++;
                }
            }
        }

        return contador;
    }

    /**
     * Este metodo agrega la posición inicial y final de los bits que encontró
     * como respuesta
     *
     * @param pos
     * @param i
     */
    private void agregarPos(int[] pos, int i, int contador, int tipo) {

        int fin[] = new int[2];
        fin[0] = pos[0];
        fin[1] = i;
        switch (tipo) {
            case 1:
                this.solucionesHorizontal[2 * contador] = pos;
                this.solucionesHorizontal[2 * contador + 1] = fin;
                break;

            case 2:
                this.solucionesVerticales[2 * contador] = pos;
                this.solucionesVerticales[2 * contador + 1] = fin;
                break;

            case 3:
                this.solucionesInclinada[2 * contador] = pos;
                this.solucionesInclinada[2 * contador + 1] = fin;
                break;

        }
    }

    public int getCuantasVeces_Vertical(int decimal) {
        int tamano = this.mySopaBinaria.length * this.mySopaBinaria[0].length;
        this.solucionesVerticales = new int[tamano * 2][this.posicionesSolucion[0].length];
        int contador = 0;
        Bit numero[] = obtenerDecimalEnBits(decimal);
        int iNumero = 0;
        for (int[] pos : this.posicionesSolucion) {
            //Busque hacia abajo
            if (pos[0] + numero.length - 1 < this.mySopaBinaria.length) {
                iNumero = 0;
                for (int i = pos[0]; i < pos[0] + numero.length; i++) {
                    if (!mySopaBinaria[i][pos[1]].equals(numero[iNumero])) {
                        break;//Rompe en el momento que una de los bits no se igual al buscado
                    }
                    if (iNumero == numero.length - 1) {
                        agregarPos(pos, i, contador, 2);
                        contador++;
                    }
                    iNumero++;
                }
            }
            //Busque hacia arriba
            if (pos[0] - (numero.length - 1) >= 0) {
                iNumero = 0;
                for (int i = pos[0]; i >= pos[0] - (numero.length - 1); i--) {
                    if (!mySopaBinaria[i][pos[1]].equals(numero[iNumero])) {
                        break; //Rompe en el momento que una de los bits no se igual al buscado
                    }
                    if (iNumero == numero.length - 1) {
                        agregarPos(pos, i, contador, 2);
                        contador++;
                    }
                    iNumero++;
                }
            }
        }

        return contador;
    }

    public int getCuantasVeces_Diagonal(int decimal) {
        int tamano = this.mySopaBinaria.length * this.mySopaBinaria[0].length;
        this.solucionesInclinada = new int[tamano * 4][this.posicionesSolucion[0].length];
        int contador = 0;
        Bit numero[] = obtenerDecimalEnBits(decimal);
        int iNumero = 0;
        for (int[] pos : this.posicionesSolucion) {
            //Busque hacia abajo a la derecha
            if (pos[0] + numero.length - 1 < this.mySopaBinaria.length
                    && pos[1] + numero.length - 1 < this.mySopaBinaria[pos[0]].length) {
                iNumero = 0;
                int j = pos[0];

                for (int i = pos[1]; i < pos[1] + numero.length; i++) {

                    if (!mySopaBinaria[j][i].equals(numero[iNumero])) {
                        break;//Rompe en el momento que una de los bits no se igual al buscado
                    }
                    if (iNumero == numero.length - 1) {
                        agregarPos(pos, i, contador, 3);
                        contador++;
                    }
                    iNumero++;
                    j++;

                }
            }
            //Busque hacia arriba a la izquierda

            if (pos[0] - (numero.length - 1) >= 0 && pos[1] - (numero.length - 1) >= 0) {
                iNumero = 0;

                int j = pos[0];
                for (int i = pos[1]; i >= pos[1] - (numero.length - 1)
                        && j >= pos[0] - (numero.length - 1); i--) {
                    if (!mySopaBinaria[j][i].equals(numero[iNumero])) {
                        break; //Rompe en el momento que una de los bits no se igual al buscado
                    }
                    if (iNumero == numero.length - 1) {
                        agregarPos(pos, i, contador, 3);
                        contador++;
                    }
                    iNumero++;
                    j--;

                }
            }
            //Abajo a la izquierda
            if (pos[0] + numero.length - 1 < this.mySopaBinaria.length
                    && pos[1] - (numero.length - 1) >= 0) {
                iNumero = 0;
                int j = pos[1];
                //pos[0] + numero.length - 1 < this.mySopaBinaria.length Abajo
                //pos[1] - (numero.length - 1) >= 0 Izquierda
                //int i = pos[0]; i < pos[0] + numero.length; i++
                for (int i = pos[0]; i < pos[0] + numero.length; i++) {

                    if (!mySopaBinaria[i][j].equals(numero[iNumero])) {
                        break;//Rompe en el momento que una de los bits no se igual al buscado
                    }
                    if (iNumero == numero.length - 1) {
                        agregarPos(pos, i, contador, 3);
                        contador++;
                    }
                    iNumero++;
                    j--;

                }
            }
            //Busque hacia arriba a la derecha
            //pos[0] - (numero.length - 1) >= 0 Arriba
            //pos[1] + numero.length - 1 < this.mySopaBinaria[pos[0]].length Derecha

            if (pos[0] - (numero.length - 1) >= 0 && pos[1] + numero.length - 1 < this.mySopaBinaria[pos[0]].length) {
                iNumero = 0;
                int j = pos[1];
                //i < pos[1] + numero.length Derecha
                for (int i = pos[0]; i >= pos[0] - (numero.length - 1); i--) {
                    if (!mySopaBinaria[i][j].equals(numero[iNumero])) {
                        break; //Rompe en el momento que una de los bits no se igual al buscado
                    }
                    if (iNumero == numero.length - 1) {
                        agregarPos(pos, i, contador, 3);
                        contador++;
                    }
                    iNumero++;
                    j++;

                }
            }
        }

        return contador;
    }

    public String[][] getMatrizEnString() {

        String matrizEnString[][] = new String[this.mySopaBinaria.length][this.mySopaBinaria[0].length];
        String valor = "0";
        for (int i = 0; i < mySopaBinaria.length; i++) {
            matrizEnString[i] = new String[this.mySopaBinaria[i].length];
            for (int j = 0; j < matrizEnString[i].length; j++) {
                valor = this.mySopaBinaria[i][j].toString();
                matrizEnString[i][j] = valor;
            }

        }
        return matrizEnString;
    }

    public Bit[][] getMatriz() {
        return this.mySopaBinaria;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        String msg = "";
        for (Bit filas[] : this.mySopaBinaria) {
            for (Bit valor : filas) {
                msg += valor.toString() + "\t";
            }
            msg += "\n";
        }

        return msg;
    }

    public String buscar(int decimal) throws IOException {

        System.out.println(toString());
        String msg = "";
        String decimalBinario = "";
        Bit numero[] = this.obtenerDecimalEnBits(decimal);

        buscarUnos();

        for (Bit bit : numero) {
            decimalBinario += bit.toString();
        }
        int contador = 0;
        switch (decimal) {
            case 1: //Caso en el que se busque el numero 1
                contador = this.posicionesSolucion.length;
                break;
            case 0: //Caso en el que se busque el numero 0
                contador = (mySopaBinaria.length * mySopaBinaria[0].length) - this.posicionesSolucion.length;
                break;
            default:
                contador = this.getCuantasVeces_Diagonal(decimal)
                        + this.getCuantasVeces_Horizontal(decimal)
                        + this.getCuantasVeces_Vertical(decimal);

        }
        if (esCapicua(numero)) {
            contador = contador / 2;
        }
        if (contador == 1) {
            msg = "Se econtro el numero decimal " + decimal + " en binario : " + decimalBinario + "\n" + contador + " vez en la sopa binaria.";
        } else {
            msg = "Se econtro el numero decimal " + decimal + " en binario : " + decimalBinario + "\n" + contador + " veces en la sopa binaria.";
        }
        buscarUnosPrueba(3);//Si se trata de 1 o 0 toca usar la lista soluciones.
        return msg;

    }

    /**
     * Busca todas las casillas que contengan "1"
     */
    private void buscarUnos() {

        int k = 0;
        for (int i = 0; i < this.mySopaBinaria.length; i++) {
            for (int j = 0; j < this.mySopaBinaria[i].length; j++) {

                int pos[] = new int[2];
                pos[0] = i;
                pos[1] = j;
                if (this.mySopaBinaria[i][j].isValor()) {
                    this.posicionesSolucion[k] = pos;
                    k++;
                }
            }

        }

    }

    private boolean esCapicua(Bit numero[]) {

        boolean capicua = false;
        for (int i = 0; i < numero.length / 2; i++) {
            Bit reves = numero[numero.length - 1 - i];
            capicua = numero[i].equals(reves);
            if (capicua == false) {
                break;
            }
        }
        return capicua;
    }

    private void buscarUnosPrueba(int caso) {
        switch (caso) {
            case 1:
                for (int i = 0; i < this.solucionesHorizontal.length; i++) {
                    int pos[] = this.solucionesHorizontal[i];
                    System.out.println(pos[0] + "," + pos[1]);
                }
                break;

            case 2:
                for (int i = 0; i < this.solucionesVerticales.length; i++) {
                    int pos[] = this.solucionesVerticales[i];
                    System.out.println(pos[0] + "," + pos[1]);

                }
                break;
            case 3:
                for (int i = 0; i < this.solucionesInclinada.length; i++) {
                    int pos[] = this.solucionesInclinada[i];
                    System.out.println(pos[0] + "," + pos[1]);

                }
                break;

        }

    }

    public void resaltarLista(int lista) {
        int soluciones[][] = new int[1000][2];
        int iSol=0;
        for (int i = 0; i < this.solucionesHorizontal.length; i++) {
            int pos1[] = this.solucionesHorizontal[i];
            int pos2[] = this.solucionesHorizontal[i + 1];
            int menor;
            int limite;
            if (pos1[1] < pos2[1]) {
                menor = pos1[1];
                limite = pos2[1];
            } else {
                menor = pos2[1];
                limite = pos1[1];
            }
            for (int j = menor; j < limite; j++) {
                this.mySopaBinaria[pos1[0]][j].setMarcado(true);
                int nuevaPos[]=new int [2];
                nuevaPos[0]=pos1[0];
                nuevaPos[1]=j;
                soluciones[i]=nuevaPos;
                
            }
            this.mySopaBinaria[pos1[0]][limite].setMarcado(true);
            int nuevaPos2[]=new int [2];
                nuevaPos2[0]=pos1[0];
                nuevaPos2[1]=limite;
                soluciones[i]=nuevaPos2;         
            i++;
            iSol++;
        }
    }
}
