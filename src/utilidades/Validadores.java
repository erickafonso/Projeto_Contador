/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;
import javax.swing.JTextField;
/**
 *
 * @author 182310022
 */
public class Validadores {
    public boolean TextFieldVazio(JTextField textfield){
        if(textfield.getText().trim().isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }
}
