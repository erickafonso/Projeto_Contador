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
    
    
    /* ARRUMAR
    public ArrayList<DespesasVO> pesquisarDespesa(String query) throws SQLException{
        DespesasDAO dDAO = DAOFactory.getDespesasDAO();
        return dDAO.buscarDespesa(query);
    }*/
    
}
