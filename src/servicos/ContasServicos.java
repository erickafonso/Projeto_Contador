
package servicos;

import dao.DAOFactory;
import dao.ContasDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.ContasVO;

/**
 *
 * @author erick
 */
public class ContasServicos {
    
    public void cadastrarConta(ContasVO cVO) throws SQLException {
        ContasDAO cDAO = DAOFactory.getContasDAO();
        cDAO.cadastrarConta(cVO);
    }//fim do métoso cadastrarCurso
    
    public ArrayList<ContasVO> buscarConta() throws SQLException{
        ContasDAO cDAO = DAOFactory.getContasDAO();
        return cDAO.buscarConta();
    }//fim do método buscarCurso
    
    public ArrayList<ContasVO> filtrarContas(String query) throws SQLException{
        ContasDAO cDAO = DAOFactory.getContasDAO();
        return cDAO.filtrarConta(query);
    }//fim do método filtrarCurso
    
    public void deletarConta( int idConta) throws SQLException{
        ContasDAO cDAO = DAOFactory.getContasDAO();
        cDAO.deletarConta(idConta);
    }//fim do método deletarCurso
    
    public void alterarConta(ContasVO cVO) throws SQLException{
        ContasDAO cDAO = DAOFactory.getContasDAO();
        cDAO.alterarConta(cVO);
    }//fim do método alterarCurso
    
    
    
    
    
}//fecha a classe ProdutoServicos
