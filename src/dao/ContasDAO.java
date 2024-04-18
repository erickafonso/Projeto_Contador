package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.ContasVO;
import persistencia.ConexaoBanco;

/**
 *
 * @author cralves
 */
public class ContasDAO {

    public void cadastrarConta(ContasVO cVO) throws SQLException {
        Connection con = new ConexaoBanco().getConexao();

        try {
            String sql = "INSERT INTO conta VALUES (null, ?, ?, ?, ?, ? )";
            //String sql = "INSERT INTO curso (nome , duracao , valor ) VALUES(?,?,?) ";

            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, cVO.getNome());
            pstm.setDouble(2, cVO.getValor());
            pstm.setString(3, cVO.getDataPagamento());
            pstm.setString(4, cVO.getDataVencimento());
            pstm.setString(5, cVO.getDescricao());

            pstm.execute();
            pstm.close();

        } catch (SQLException se) {
            throw new SQLException("Erro no Cadastro!" + se);
        } finally {
            con.close();
        }//fim do try catch finally

    }//fim do método cadastrarProduto

    public ArrayList<ContasVO> buscarConta() throws SQLException {
        Connection con = new ConexaoBanco().getConexao();

        try {
            String sql = "Select * from conta";
            PreparedStatement pstm = con.prepareStatement(sql);

            ResultSet rs = pstm.executeQuery();
            ArrayList<ContasVO> contasList = new ArrayList<>();

            while (rs.next()) {
                ContasVO cVO = new ContasVO();

                cVO.setIdConta(rs.getInt("idConta"));
                cVO.setNome(rs.getString("nome"));

                cVO.setValor(rs.getDouble("valor"));
                cVO.setDataPagamento(rs.getString("dataPagamento"));
                cVO.setDataPagamento(rs.getString("dataVencimento"));
                cVO.setDescricao(rs.getString("descricao"));                
                contasList.add(cVO);
            }//fim do while
            pstm.close();

            return contasList;

        } catch (SQLException se) {
            throw new SQLException("Erro ao buscar conta! " + se.getMessage());
        } finally {
            con.close();
        }
    }//fim do método buscarProduto

    public ArrayList<ContasVO> filtrarConta(String query) throws SQLException {
        Connection con = new ConexaoBanco().getConexao();

        try {
            String sql = "select * from conta" + query;
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            ArrayList<ContasVO> contasList = new ArrayList<>();

            while (rs.next()) {
                ContasVO cVO = new ContasVO();

                cVO.setIdConta(rs.getInt("idConta"));
                cVO.setNome(rs.getString("nome"));
                cVO.setValor(rs.getDouble("valor"));
                cVO.setDataPagamento(rs.getString("dataPagamento"));
                cVO.setDataPagamento(rs.getString("dataVencimento"));
                cVO.setDescricao(rs.getString("descricao"));  
                contasList.add(cVO);
            }//fim do while

            pstm.close();

            return contasList;

        } catch (SQLException se) {
            throw new SQLException("Erro ao filtrar conta! " + se.getMessage());
        } finally {
            con.close();
        }//fim da finally        
    }//fim do método filtrarProduto

    public void deletarConta(int idConta) throws SQLException {
        Connection con = new ConexaoBanco().getConexao();

        try {
            String sql = "delete from conta where idDespesa = ?";
            //String sql = "delete from curso where idCurso = ?";
            PreparedStatement pstm = con.prepareStatement(sql);

            pstm.setInt(0, idConta);
            //pstm.setInt(1, idCurso);
            pstm.execute();
            pstm.close();
        } catch (SQLException se) {
            throw new SQLException("Erro ao deletar curso! ContaDAO " + se.getMessage());
        } finally {
            con.close();
        }//fim da finally
    }//fecha o método detelarProduto

    public void alterarConta(ContasVO cVO) throws SQLException {
        Connection con = new ConexaoBanco().getConexao();

        try {
            String sql;
            sql = "Update conta set "
                    + "nome = ' " + cVO.getNome() + " ', "
                    + "valor = " + cVO.getValor() + ", "
                    + "dataPagamento = " + cVO.getDataPagamento() + ", "
                    + "dataVencimento = " + cVO.getDataVencimento() + ", "
                    + "descricao = " + cVO.getDescricao() + ", "
                    + " where idConta= " + cVO.getIdConta() + " ";

            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.executeUpdate();
            pstm.close();

        } catch (SQLException se) {
            throw new SQLException("Erro ao Alterar Conta! " + se.getMessage());
        } finally {
            con.close();
        }//fim do Try catch finally
    }//fecha o método alterarProduto

}//fecha a classe ProdutoDAO
