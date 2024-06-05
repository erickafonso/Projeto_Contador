/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dao.DespesasDAO;
import dao.DAOFactory;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.DespesasVO;

/**
 *
 * @author erick
 */
public class DespesasServicos {
    public void cadastrarDespesas(DespesasVO dVO) throws SQLException {
        DespesasDAO dDAO = DAOFactory.getDespesasDAO();
        dDAO.cadastrarDespesa(dVO);
    }
    public ArrayList<DespesasVO> buscarDespesa() throws SQLException{
        DespesasDAO dDAO = DAOFactory.getDespesasDAO();
        return dDAO.buscarDespesa();
    }
    public ArrayList<DespesasVO> filtrarProduto(String query) throws SQLException{
        DespesasDAO dDAO = DAOFactory.getDespesasDAO();
        return dDAO.filtrarDespesa(query);
    }
    
        public void deletarDespesa( int idDespesa) throws SQLException{
        DespesasDAO dDAO = DAOFactory.getDespesasDAO();
        dDAO.deletarDespesa(idDespesa);
    }//fim do método deletarProduto
    
    public void alterarDespesa(DespesasVO dVO) throws SQLException{
        DespesasDAO dDAO = DAOFactory.getDespesasDAO();
        dDAO.alterarDespesa(dVO);
    }//fim do método alterarProduto
    /* ARRUMAR
    public ArrayList<DespesasVO> pesquisarDespesa(String query) throws SQLException{
        DespesasDAO dDAO = DAOFactory.getDespesasDAO();
        return dDAO.buscarDespesa(query);
    }*/
    
}
