/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.FormasPagamentosVO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import persistencia.ConexaoBanco;

/**
 *
 * @author 181700028
 */
public class FormasPagamentosDAO {
    
    public void cadastrarFormaPagamento(FormasPagamentosVO fVO) throws SQLException{
        
        Connection con =new ConexaoBanco().getConexao();
        try{
            String sql = "insert into formaPagamento values (null, ?)";
            PreparedStatement pstm= con.prepareStatement(sql);
            pstm.setString(1, fVO.getNome());


            
            
            pstm.execute();
            pstm.close();
            
        }catch(SQLException se){
            throw new SQLException("Erro ao cadastrar Forma de Pagamento(DAO)! " + se.getMessage());
        }finally{
            con.close();
        }
        
        
    }
    public ArrayList<FormasPagamentosVO> buscarFormaPagamento() throws SQLException{
        
        Connection con =new ConexaoBanco().getConexao();
        try{
            String sql= "Select * from formaPagamento";
            PreparedStatement pstm= con.prepareStatement(sql);
            ResultSet rs= pstm.executeQuery();
            ArrayList<FormasPagamentosVO> formasPagamentosList =new ArrayList<>();
            
            while(rs.next()){
                FormasPagamentosVO fVO=new FormasPagamentosVO();
                fVO.setIdFormaPagamento(rs.getInt("idFormaPagamento"));
                fVO.setNome(rs.getString("nome"));

                
                
                formasPagamentosList.add(fVO);
                
            }
            
            pstm.close();
            return formasPagamentosList;
            
        }catch(SQLException se){
            throw new SQLException("Erro ao buscar formasPagamentos(DAO)! " + se.getMessage());
        }finally{
            con.close();
        }
        
        
    }
    
    
   public ArrayList<FormasPagamentosVO> pesquisarFormaPagamento(String query) throws SQLException{
       Connection con = new ConexaoBanco().getConexao();
       
       try {
           String sql = " Select * from formaPagamento " + query;
           PreparedStatement pstm = con.prepareStatement(sql);
           ResultSet rs = pstm.executeQuery();
           ArrayList<FormasPagamentosVO> formasPagamentosList = new ArrayList<>();
           FormasPagamentosVO fVO = new FormasPagamentosVO();
           
           while(rs.next()){
               fVO.setIdFormaPagamento(rs.getInt("idFormaPagamento"));
                fVO.setNome(rs.getString("nome"));

               
               /*aVO.setCodCli(rs.getInt("idcliente"));
               aVO.setNome(rs.getString("nome"));
               aVO.setCPF(rs.getString("cpf"));
               aVO.setEmail(rs.getString("email"));
               aVO.setFone(rs.getString("fone"));
               aVO.setEndereco(rs.getString("endereco"));
               aVO.setCEP(rs.getString("cep"));
               aVO.setBairro(rs.getString("bairro"));
               aVO.setUf(rs.getString("uf"));   */
             
               formasPagamentosList.add(fVO);
           }//fim do while
           
           pstm.close();
           return formasPagamentosList;
                      
       } catch (SQLException se) {
           throw new SQLException( "Erro ao pesquisar forma de pagamento! " + se);
       }finally{
           con.close();
       }//fim do finally
       
   }//fim do método pesquisar
   
       public void deletarFormaPagamento(int idFormaPagamento) throws SQLException {
        Connection con = new ConexaoBanco().getConexao();

        try {
            String sql = "delete from formaPagamento where idFormaPagamento= ?";
            //String sql = "delete from curso where idCurso = ?";
            PreparedStatement pstm = con.prepareStatement(sql);

            pstm.setInt(0, idFormaPagamento);
            //pstm.setInt(1, idCurso);
            pstm.execute();
            pstm.close();
        } catch (SQLException se) {
            throw new SQLException("Erro ao deletar categoria! UsuariosDAO " + se.getMessage());
        } finally {
            con.close();
        }//fim da finally
    }//fecha o método detelarProduto

    public void alterarFormaPagamento(FormasPagamentosVO fVO) throws SQLException {
        Connection con = new ConexaoBanco().getConexao();

        try {
            String sql;
            sql = "Update formaPagamento set "
                    + "nome = ' " + fVO.getNome() + " ', "

                    + " where idFormaPagamento= " + fVO.getIdFormaPagamento() + " ";

            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.executeUpdate();
            pstm.close();

        } catch (SQLException se) {
            throw new SQLException("Erro ao Alterar Forma de Pagamento! " + se.getMessage());
        } finally {
            con.close();
        }//fim do Try catch finally
    }//fecha o método alterarProduto
    
       public ResultSet listarPerfil(){
       Connection con = new ConexaoBanco().getConexao();
       
       try {
           String sql = "Select * from formaPagamento order by nome; ";
           PreparedStatement pstm = con.prepareStatement(sql);
           
           return pstm.executeQuery();
           
       } catch (SQLException se) {
           JOptionPane.showMessageDialog(
                   null,
                   "Erro formaPagamentoDAO.listarPerfil " + se.getMessage());
           return null;
       }//fim do try catch
       
   }//fim do método listarPerfil
}
