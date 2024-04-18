
package dao;

/**
 *
 * @author cralves
 */
public class DAOFactory {
    //Instanciando o objeto a classe ProdutoDAO
    private static DespesasDAO despesasDAO = new DespesasDAO();
    
    //Fazendo uma cópia dos métodos da classe ProdutoDAO e 
    //disponibilizar para a classe que solicitar
    public static DespesasDAO getDespesasDAO(){
        return despesasDAO;
    }//fim do método getProdutoDAO
    
    //Instanciando o objeto a classe ProdutoDAO
    private static ContasDAO contasDAO = new ContasDAO();
    
    //Fazendo uma cópia dos métodos da classe ProdutoDAO e 
    //disponibilizar para a classe que solicitar
    public static ContasDAO getContasDAO(){
        return contasDAO;
    }//fim do método getProdutoDAO
    
    //Instanciando o objeto a classe ClientesDAO
    private static UsuariosDAO usuariosDAO = new UsuariosDAO();
    
    //Fazendo uma cópia dos métodos da classe ClientesDAO e 
    //disponibilizar para a classe que solicitar
    public static UsuariosDAO getUsuariosDAO(){
        return usuariosDAO;
    }//fim do método ClientesDAO
}//fecha a classe DAOFactory
