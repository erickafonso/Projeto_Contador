package servicos;

/**
 *
 * @author cralves
 */
public class ServicosFactory {

    private static ContasServicos cursoServicos = new ContasServicos();

    public static ContasServicos getCursoServicos() {
        return cursoServicos;
    }//fim do método getProdutoServicos
    
    
    

    private static DespesasServicos despesasServicos = new DespesasServicos();

    public static DespesasServicos getDespesasSevicos() {
        return despesasServicos;
    }//fim do método getClientesServicos
    
    private static UsuariosServicos usuariosServicos = new UsuariosServicos();

    public static UsuariosServicos getUsuariosSevicos() {
        return usuariosServicos;
    }//fim do método getClientesServicos
}//fecha a classe ServicosFactory
