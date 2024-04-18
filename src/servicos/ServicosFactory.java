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
    
    
    

    private static DespesasServicos alunosServicos = new DespesasServicos();

    public static DespesasServicos getAlunosSevicos() {
        return alunosServicos;
    }//fim do método getClientesServicos

}//fecha a classe ServicosFactory
