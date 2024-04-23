
package servicos;

import dao.DAOFactory;
import dao.CategoriasDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import modelo.CategoriasVO;


/**
 *
 * @author erick
 */
public class CategoriasServicos {
    
    public void cadastrarCategoria(CategoriasVO cVO) throws SQLException {
        CategoriasDAO cDAO = DAOFactory.getCategoriasDAO();
        cDAO.cadastrarCategoria(cVO);
    }//fim do métoso cadastrarCurso
    
    public ArrayList<CategoriasVO> buscarCategoria() throws SQLException{
        CategoriasDAO cDAO = DAOFactory.getCategoriasDAO();
        return cDAO.buscarCategoria();
    }//fim do método buscarCurso
    /*ARRUMAR
    public ArrayList<UsuariosVO> filtrarUsuarios(String query) throws SQLException{
        UsuariosDAO uDAO = DAOFactory.getUsuariosDAO();
        return uDAO.filtrarUsuario(query);
    }//fim do método filtrarCurso
    */
    public void deletarCategoria( int idCategoria) throws SQLException{
        CategoriasDAO cDAO = DAOFactory.getCategoriasDAO();
        cDAO.deletarCategoria(idCategoria);
    }//fim do método deletarCurso
    
    public void alterarCategoria(CategoriasVO cVO) throws SQLException{
        CategoriasDAO cDAO = DAOFactory.getCategoriasDAO();
        cDAO.alterarCategoria(cVO);
    }//fim do método alterarCurso
    
    
    
    
    
}//fecha a classe ProdutoServicos
