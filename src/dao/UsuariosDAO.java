/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.UsuariosVO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import persistencia.ConexaoBanco;

/**
 *
 * @author 181700028
 */
public class UsuariosDAO {
    
    public void cadastrarUsuario(UsuariosVO uVO) throws SQLException{
        
        Connection con =new ConexaoBanco().getConexao();
        try{
            String sql = "insert into usuario values (null, ?, ?, ?, ?)";
            PreparedStatement pstm= con.prepareStatement(sql);
            pstm.setString(1, uVO.getNome());
            pstm.setString(2, uVO.getEmail());
            pstm.setString(3, uVO.getSenha());
            pstm.setString(4, uVO.getLogin());

            
            
            pstm.execute();
            pstm.close();
            
        }catch(SQLException se){
            throw new SQLException("Erro ao cadastrar Usuario(DAO)! " + se.getMessage());
        }finally{
            con.close();
        }
        
        
    }
    public ArrayList<UsuariosVO> buscarUsuario() throws SQLException{
        
        Connection con =new ConexaoBanco().getConexao();
        try{
            String sql= "Select * from usuario";
            PreparedStatement pstm= con.prepareStatement(sql);
            ResultSet rs= pstm.executeQuery();
            ArrayList<UsuariosVO> usuariosList =new ArrayList<>();
            
            while(rs.next()){
                UsuariosVO uVO=new UsuariosVO();
                uVO.setIdUsuario(rs.getInt("idUsuario"));
                uVO.setNome(rs.getString("nome"));
                uVO.setEmail(rs.getString("email"));
                uVO.setSenha(rs.getString("senha"));    
                uVO.setLogin(rs.getString("login"));
                
                
                usuariosList.add(uVO);
                
            }
            
            pstm.close();
            return usuariosList;
            
        }catch(SQLException se){
            throw new SQLException("Erro ao buscar Usuario(DAO)! " + se.getMessage());
        }finally{
            con.close();
        }
        
        
    }
    
    
   public ArrayList<UsuariosVO> pesquisarUsuario(String query) throws SQLException{
       Connection con = new ConexaoBanco().getConexao();
       
       try {
           String sql = " Select * from usuario " + query;
           PreparedStatement pstm = con.prepareStatement(sql);
           ResultSet rs = pstm.executeQuery();
           ArrayList<UsuariosVO> usuariosList = new ArrayList<>();
           UsuariosVO uVO = new UsuariosVO();
           
           while(rs.next()){
               uVO.setIdUsuario(rs.getInt("idUsuario"));
                uVO.setNome(rs.getString("nome"));
                uVO.setEmail(rs.getString("email"));
                uVO.setSenha(rs.getString("senha"));    
                uVO.setLogin(rs.getString("login"));
               
               /*aVO.setCodCli(rs.getInt("idcliente"));
               aVO.setNome(rs.getString("nome"));
               aVO.setCPF(rs.getString("cpf"));
               aVO.setEmail(rs.getString("email"));
               aVO.setFone(rs.getString("fone"));
               aVO.setEndereco(rs.getString("endereco"));
               aVO.setCEP(rs.getString("cep"));
               aVO.setBairro(rs.getString("bairro"));
               aVO.setUf(rs.getString("uf"));   */
             
               usuariosList.add(uVO);
           }//fim do while
           
           pstm.close();
           return usuariosList;
                      
       } catch (SQLException se) {
           throw new SQLException( "Erro ao pesquisar usuario! " + se);
       }finally{
           con.close();
       }//fim do finally
       
   }//fim do método pesquisar
   
       public void deletarUsuario(int idUsuario) throws SQLException {
        Connection con = new ConexaoBanco().getConexao();

        try {
            String sql = "delete from usuario where idUsuario= ?";
            //String sql = "delete from curso where idCurso = ?";
            PreparedStatement pstm = con.prepareStatement(sql);

            pstm.setInt(0, idUsuario);
            //pstm.setInt(1, idCurso);
            pstm.execute();
            pstm.close();
        } catch (SQLException se) {
            throw new SQLException("Erro ao deletar usuario! UsuariosDAO " + se.getMessage());
        } finally {
            con.close();
        }//fim da finally
    }//fecha o método detelarProduto

    public void alterarUsuario(UsuariosVO uVO) throws SQLException {
        Connection con = new ConexaoBanco().getConexao();

        try {
            String sql;
            sql = "Update usuario set "
                    + "nome = ' " + uVO.getNome() + " ', "
                    + "email = " + uVO.getEmail() + ", "
                    + "login= " + uVO.getLogin() + ", "
                    + "senha = " + uVO.getSenha() + ", "
                    + " where idUsuario= " + uVO.getIdUsuario() + " ";

            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.executeUpdate();
            pstm.close();

        } catch (SQLException se) {
            throw new SQLException("Erro ao Alterar Usuario! " + se.getMessage());
        } finally {
            con.close();
        }//fim do Try catch finally
    }//fecha o método alterarProduto
    
}
