
package servicos;

import dao.DAOFactory;
import dao.UsuariosDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.UsuariosVO;

/**
 *
 * @author erick
 */
public class UsuariosServicos {
    
    public void cadastrarUsuario(UsuariosVO uVO) throws SQLException {
        UsuariosDAO uDAO = DAOFactory.getUsuariosDAO();
        uDAO.cadastrarUsuario(uVO);
    }//fim do métoso cadastrarCurso
    
    public ArrayList<UsuariosVO> buscarUsuario() throws SQLException{
        UsuariosDAO uDAO = DAOFactory.getUsuariosDAO();
        return uDAO.buscarUsuario();
    }//fim do método buscarCurso
    /*ARRUMAR
    public ArrayList<UsuariosVO> filtrarUsuarios(String query) throws SQLException{
        UsuariosDAO uDAO = DAOFactory.getUsuariosDAO();
        return uDAO.filtrarUsuario(query);
    }//fim do método filtrarCurso
    */
    public void deletarUsuario( int idUsuario) throws SQLException{
        UsuariosDAO uDAO = DAOFactory.getUsuariosDAO();
        uDAO.deletarUsuario(idUsuario);
    }//fim do método deletarCurso
    
    public void alterarUsuario(UsuariosVO uVO) throws SQLException{
        UsuariosDAO uDAO = DAOFactory.getUsuariosDAO();
        uDAO.alterarUsuario(uVO);
    }//fim do método alterarCurso
    
    
    
    
    
}//fecha a classe ProdutoServicos
