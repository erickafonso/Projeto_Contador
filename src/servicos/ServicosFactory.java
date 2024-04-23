package servicos;

/**
 *
 * @author cralves
 */
public class ServicosFactory {

    private static ContasServicos contasServicos = new ContasServicos();

    public static ContasServicos getContasServicos() {
        return contasServicos;
    }//fim do método getProdutoServicos
    
    private static FormasPagamentosServicos formaspagamentosServicos = new FormasPagamentosServicos();

    public static FormasPagamentosServicos getFormasPagamentosServicos() {
        return formaspagamentosServicos;
    }//fim do método getProdutoServicos
    
    private static CategoriasServicos categoriasServicos = new CategoriasServicos();

    public static CategoriasServicos getCategoriasServicos() {
        return categoriasServicos;
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
