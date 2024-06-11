/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.CategoriasVO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import persistencia.ConexaoBanco;

/**
 *
 * @author 181700028
 */
public class CategoriasDAO {
    
    public void cadastrarCategoria(CategoriasVO cVO) throws SQLException{
        
        Connection con =new ConexaoBanco().getConexao();
        try{
            String sql = "insert into categoria values (null, ?)";
            PreparedStatement pstm= con.prepareStatement(sql);
            pstm.setString(1, cVO.getNome());


            
            
            pstm.execute();
            pstm.close();
            
        }catch(SQLException se){
            throw new SQLException("Erro ao cadastrar Categoria(DAO)! " + se.getMessage());
        }finally{
            con.close();
        }
        
        
    }
    public ArrayList<CategoriasVO> buscarCategoria() throws SQLException{
        
        Connection con =new ConexaoBanco().getConexao();
        try{
            String sql= "Select * from categoria";
            PreparedStatement pstm= con.prepareStatement(sql);
            ResultSet rs= pstm.executeQuery();
            ArrayList<CategoriasVO> categoriasList =new ArrayList<>();
            
            while(rs.next()){
                CategoriasVO cVO=new CategoriasVO();
                cVO.setIdCategoria(rs.getInt("idCategoria"));
                cVO.setNome(rs.getString("nome"));

                
                
                categoriasList.add(cVO);
                
            }
            
            pstm.close();
            return categoriasList;
            
        }catch(SQLException se){
            throw new SQLException("Erro ao buscar Categoria(DAO)! " + se.getMessage());
        }finally{
            con.close();
        }
        
        
    }
    
    
   public ArrayList<CategoriasVO> pesquisarCategoria(String query) throws SQLException{
       Connection con = new ConexaoBanco().getConexao();
       
       try {
           String sql = " Select * from categoria " + query;
           PreparedStatement pstm = con.prepareStatement(sql);
           ResultSet rs = pstm.executeQuery();
           ArrayList<CategoriasVO> categoriasList = new ArrayList<>();
           CategoriasVO cVO = new CategoriasVO();
           
           while(rs.next()){
               cVO.setIdCategoria(rs.getInt("idCategoria"));
                cVO.setNome(rs.getString("nome"));

               
               /*aVO.setCodCli(rs.getInt("idcliente"));
               aVO.setNome(rs.getString("nome"));
               aVO.setCPF(rs.getString("cpf"));
               aVO.setEmail(rs.getString("email"));
               aVO.setFone(rs.getString("fone"));
               aVO.setEndereco(rs.getString("endereco"));
               aVO.setCEP(rs.getString("cep"));
               aVO.setBairro(rs.getString("bairro"));
               aVO.setUf(rs.getString("uf"));   */
             
               categoriasList.add(cVO);
           }//fim do while
           
           pstm.close();
           return categoriasList;
                      
       } catch (SQLException se) {
           throw new SQLException( "Erro ao pesquisar categoria! " + se);
       }finally{
           con.close();
       }//fim do finally
       
   }//fim do método pesquisar
   
       public void deletarCategoria(int idCategoria) throws SQLException {
        Connection con = new ConexaoBanco().getConexao();

        try {
            String sql = "delete from categoria where idCategoria= ?";
            //String sql = "delete from curso where idCurso = ?";
            PreparedStatement pstm = con.prepareStatement(sql);

            pstm.setInt(1, idCategoria);
            //pstm.setInt(1, idCurso);
            pstm.execute();
            pstm.close();
        } catch (SQLException se) {
            throw new SQLException("Erro ao deletar categoria! CategoriasDAO " + se.getMessage());
        } finally {
            con.close();
        }//fim da finally
    }//fecha o método detelarProduto

    public void alterarCategoria(CategoriasVO cVO) throws SQLException {
        Connection con = new ConexaoBanco().getConexao();

        try {
            String sql;
            sql = "Update categoria set "
                    + "nome = ' " + cVO.getNome() + " ' "

                    + " where idCategoria= " + cVO.getIdCategoria() + " ;";

            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.executeUpdate();
            pstm.close();

        } catch (SQLException se) {
            throw new SQLException("Erro ao Alterar Categoria! " + se.getMessage());
        } finally {
            con.close();
        }//fim do Try catch finally
    }//fecha o método alterarProduto
    
       public ResultSet listarPerfil(){
       Connection con = new ConexaoBanco().getConexao();
       
       try {
           String sql = "Select * from categoria order by nome; ";
           PreparedStatement pstm = con.prepareStatement(sql);
           
           return pstm.executeQuery();
           
       } catch (SQLException se) {
           JOptionPane.showMessageDialog(
                   null,
                   "Erro categoriaDAO.listarPerfil " + se.getMessage());
           return null;
       }//fim do try catch
       
   }//fim do método listarPerfil
       
             public ResultSet retornaId(String nome){
       Connection con = new ConexaoBanco().getConexao();
       
       try {
           String sql = "Select idCategoria from categoria where nome= ?; ";
           PreparedStatement pstm = con.prepareStatement(sql);
           pstm.setString(1, nome);
           return pstm.executeQuery();
           
       } catch (SQLException se) {
           JOptionPane.showMessageDialog(
                   null,
                   "Erro categoriaDAO.retornaID " + se.getMessage());
           return null;
       }//fim do try catch
       
   }//fim do método listarPerfil
}
