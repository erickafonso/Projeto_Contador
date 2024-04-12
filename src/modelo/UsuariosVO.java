/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author 182310022
 */
public class UsuariosVO {
    private int idUsuario;
    private String nome;
    private String email;
    private String senha;
    private ArrayList<String> categorias;
    private ArrayList<String> formaPagamento;

    private ArrayList<ContasVO> contas;
    private ArrayList<DespesasVO> despesas;
}
