/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.text.*;

/**
 *
 * @author 181700028
 * @since 06/03/2024
 * @version 1.0
 */
public class Conversao {
    MaskFormatter jftfData;
    //esse metodo é responsavel por substituir a virgula por ponto,
    //caso o usuario digite errado.
    public static String converterVirgulaPonto(String c){
        return c.replaceAll(",", ".");
    }//fecha o metodo converterVirgulaPonto
    
    
    
    //coloca todas as Strings em caixa alta
    public static String converterTudoMai(String c){
        return c.toUpperCase();
    }//fecha metodo converterTudoMai
    
    //coloca todas as Strings em caixa baixa
    public static String converterTudoMin(String c){
        return c.toLowerCase();
    }//fecha metodo converterTudoMin
    
    /*
    metodo que verifica se o usuario digitou apenas
    letras maiusculas ou minusculas;
    no minimo 6 e no maximo 50 caracteres
    */
    public static boolean verificarTexto(String c){
        
        return c.matches("^[a-zA-záÁéÉíÍóÓúÚçÇãÃõÕ ]{6,50}$");
    }//fecha metodo verificarTexto
    
    
    /*
    metodo que verifica se o usuario digitou apenas
    numero de 0 a 9 com no minimo 6 e no maximo 8
    digitos*/
    public static boolean verificarNumero(String c){
        
        return c.matches("^[0-9]{6,8}$");
    }//fecha metodo verificarTexto
    public static boolean verificarNumeroCom(String c){
        
        return c.matches("^[0-9]{6,8}$");
    }//fecha metodo verificarTexto
    public static boolean verificarNumeroComVi(String c){
        
        return c.matches("^[0.01-9.99]{6,8}$");
    }//fecha metodo verificarTexto
    
    public static String dataFormaterToDB(Date dataCrua){
        
        try{
        SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
        String data = dataFormatada.format(dataCrua);

        return data;
    }   catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Erro ao converter data! Conversao dataConverter" + e.getMessage() );
    return null;    
    }
    }
    public static boolean verficadorNumero(String data){
    try {
            int valor = Integer.parseInt(data);
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Insira um valor válido!");
            return false;
        }
    
    }
}//fecha classe Conversao
