
package servicos;

import dao.DAOFactory;
import dao.FormasPagamentosDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import modelo.FormasPagamentosVO;


/**
 *
 * @author erick
 */
public class FormasPagamentosServicos {
    
    public void cadastrarFormaPagamento(FormasPagamentosVO fVO) throws SQLException {
        FormasPagamentosDAO fDAO = DAOFactory.getFormasPagamentosDAO();
        fDAO.cadastrarFormaPagamento(fVO);
    }//fim do métoso cadastrarCurso
    
    public ArrayList<FormasPagamentosVO> buscarFormaPagamento() throws SQLException{
        FormasPagamentosDAO fDAO = DAOFactory.getFormasPagamentosDAO();
        return fDAO.buscarFormaPagamento();
    }//fim do método buscarCurso
    /*ARRUMAR
    public ArrayList<UsuariosVO> filtrarUsuarios(String query) throws SQLException{
        UsuariosDAO uDAO = DAOFactory.getUsuariosDAO();
        return uDAO.filtrarUsuario(query);
    }//fim do método filtrarCurso
    */
    public void deletarFormaPagamento( int idFormaPagamento) throws SQLException{
        FormasPagamentosDAO fDAO = DAOFactory.getFormasPagamentosDAO();
        fDAO.deletarFormaPagamento(idFormaPagamento);
    }//fim do método deletarCurso
    
    public void alterarUsuario(FormasPagamentosVO fVO) throws SQLException{
        FormasPagamentosDAO fDAO = DAOFactory.getFormasPagamentosDAO();
        fDAO.alterarFormaPagamento(fVO);
    }//fim do método alterarCurso
    
    
    
    
    
}//fecha a classe ProdutoServicos
