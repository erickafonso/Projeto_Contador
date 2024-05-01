/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import dao.CategoriasDAO;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import modelo.ContasVO;
import servicos.ContasServicos;
import dao.FormasPagamentosDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import modelo.CategoriasVO;
import modelo.FormasPagamentosVO;

/**
 *
 * @author 182310022
 */
public class GUIcadastroContas extends javax.swing.JInternalFrame {

    /** Creates new form GUIcadastroDespesa */
    public GUIcadastroContas() {
        initComponents();
        PreencherComboBoxFormaPagamento();
        PreencherComboBoxCategoria();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jtfNomeConta = new javax.swing.JTextField();
        jtfValorConta = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfDataPagamentoConta = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jcbCategoriaConta = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jbtnOpenCategoria = new javax.swing.JButton();
        jcbFormaPagamentoConta = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jtbPago = new javax.swing.JToggleButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaDescricao = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jbtCadastrar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jtfDataVencimentoConta = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);

        jtfNomeConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNomeContaActionPerformed(evt);
            }
        });

        jLabel1.setText("NOME");

        jLabel2.setText("VALOR");

        jLabel3.setText("DATA DE PAGAMENTO:");

        jcbCategoriaConta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));

        jLabel4.setText("CATEGORIA");

        jbtnOpenCategoria.setText("+");
        jbtnOpenCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnOpenCategoriaActionPerformed(evt);
            }
        });

        jcbFormaPagamentoConta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));

        jLabel5.setText("FORMA DE PAGAMENTO");

        jButton2.setText("+");

        jtbPago.setText("NÃO PAGO");

        jLabel6.setText("INFORMAR PAGAMENTO:");

        jtaDescricao.setColumns(20);
        jtaDescricao.setRows(5);
        jScrollPane1.setViewportView(jtaDescricao);

        jLabel7.setText("DESCRIÇÃO:");

        jLabel8.setText("DD/MM/AAAA");

        jbtCadastrar.setText("CADASTRAR");
        jbtCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtCadastrarActionPerformed(evt);
            }
        });

        jButton3.setText("GET");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel9.setText("DATA DE PAGAMENTO:");

        jLabel10.setText("DD/MM/AAAA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5)))
                                .addGap(49, 49, 49)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtbPago)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jcbCategoriaConta, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(26, 26, 26)
                                                .addComponent(jbtnOpenCategoria))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jcbFormaPagamentoConta, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(26, 26, 26)
                                                .addComponent(jButton2)))
                                        .addGap(91, 91, 91)
                                        .addComponent(jButton3))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel7))
                                .addGap(55, 55, 55)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1)
                                    .addComponent(jtfValorConta)
                                    .addComponent(jtfNomeConta, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(49, 49, 49)
                                        .addComponent(jtfDataPagamentoConta, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(49, 49, 49)
                                        .addComponent(jtfDataVencimentoConta, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(405, 405, 405)
                        .addComponent(jbtCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(261, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfNomeConta, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfValorConta, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfDataPagamentoConta, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfDataVencimentoConta, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbCategoriaConta, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jbtnOpenCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbFormaPagamentoConta, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtbPago)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addComponent(jbtCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cadastrar() {
        try {
            ContasVO cVO = new ContasVO();
            cVO.setNome(jtfNomeConta.getText());
            
            cVO.setValor(Double.parseDouble(jtfValorConta.getText()));
            cVO.setDescricao(jtaDescricao.getText());
            
            
            String dataCrua = jtfDataPagamentoConta.getText();
            SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
            Date data = dataFormatada.parse(dataCrua);
            cVO.setDataPagamento(data);

            
            String categoriaSelect = jcbCategoriaConta.getSelectedItem().toString();
            CategoriasDAO cDAO = new CategoriasDAO();
            ArrayList<CategoriasVO> categoriasList  = cDAO.buscarCategoria();
            int categoriaID = getIdCategoria(categoriasList , categoriaSelect);
            System.out.println("");
            cVO.setCategoria(categoriaID);
            
           
            //cVO.setCategoria(rsc.getInt(1));
            //System.out.println(rsc.getInt(0));
            
            String formapagamentoSelect = jcbFormaPagamentoConta.getSelectedItem().toString();
            FormasPagamentosDAO fpDAO = new FormasPagamentosDAO();
            ArrayList<FormasPagamentosVO> formasPagamentosList  = fpDAO.buscarFormaPagamento();
            
            int formaPagamentoID = getIdFormaPagamento(formasPagamentosList, formapagamentoSelect);
            cVO.setFormaPagamento(formaPagamentoID);

            

            
            
            
            /*
        Temos que enviar o objeto pVO para o banco.
        Assim a instrução sql da DAO ( ProdutoDAO) foi
        copiada na ProdutoServicos, que tem uma cópia dos métodos
             */
            ContasServicos cs = servicos.ServicosFactory.getContasServicos();

            //Chamando o método
            cs.cadastrarConta(cVO);

            //Retorno para o usuário
            JOptionPane.showMessageDialog(
                    null,
                    "Forma de Pagamento Cadastrado com sucesso! ");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Erro! GUICadastroConta " + e.getMessage());
        }//fecha o try catch

    }//fim do método cadastrar
    
        //Variável para armazenar o idperfil que é chave estrangeira na tabela login
    public int getIdCategoria(ArrayList<CategoriasVO> list , String nome){
        int numero = 1;
        for(CategoriasVO element : list ){
                    if(element.getNome().equals(nome)){
                        numero = element.getIdCategoria();
                    }
                }
        
    return numero; }
    
    public int getIdFormaPagamento(ArrayList<FormasPagamentosVO> list , String nome){
        int numero = 1;
        for(FormasPagamentosVO element : list ){
                    if(element.getNome().equals(nome)){
                        numero = element.getIdFormaPagamento();
                    }
                }
        
    return numero; }
            
    Vector<FormasPagamentosVO> codFormaPagamento = new Vector<FormasPagamentosVO>();
    Vector<Integer> codCategoria = new Vector<Integer>();

   
        
    
    
    public void PreencherComboBoxFormaPagamento(){
        
        try {
            FormasPagamentosDAO fpDAO = new FormasPagamentosDAO();
            ResultSet rs = fpDAO.listarPerfil();
            
            while(rs.next()){
                FormasPagamentosVO fpVO = new FormasPagamentosVO();
                fpVO.setIdFormaPagamento(rs.getInt(1));
                fpVO.setNome(rs.getString(2));
                codFormaPagamento.addElement(fpVO);
                //codFormaPagamento.addElement(rs.getInt(1));
                jcbFormaPagamentoConta.addItem(rs.getString(2));                
            }//fim do while
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Erro GuiLogin.restaurarPerfilComboBox " + e.getMessage());
        }//fim do try catch
        
    }//fim do método restaurarPerfilComboBox
    
    public void PreencherComboBoxCategoria(){
        
        try {
            CategoriasDAO cDAO = new CategoriasDAO();
            ResultSet rs = cDAO.listarPerfil();
            
            while(rs.next()){

                codCategoria.addElement(rs.getInt(1));
                jcbCategoriaConta.addItem(rs.getString(2));                
            }//fim do while
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Erro GuiLogin.restaurarPerfilComboBox " + e.getMessage());
        }//fim do try catch
        
    }//fim do método restaurarPerfilComboBox
    
    
 
    private void jtfNomeContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNomeContaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNomeContaActionPerformed

    private void jbtCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCadastrarActionPerformed
        cadastrar();
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtCadastrarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
     String categoriaSelect = jcbFormaPagamentoConta.getSelectedItem().toString();
        System.out.println(categoriaSelect);
        FormasPagamentosDAO cDAO = new FormasPagamentosDAO();
            ArrayList<FormasPagamentosVO> categoriasList;
        try {
            categoriasList = cDAO.buscarFormaPagamento();
            int categoriaID = getIdFormaPagamento(categoriasList , categoriaSelect);
            System.out.println(categoriaID);
        } catch (SQLException ex) {
            Logger.getLogger(GUIcadastroContas.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
    

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jbtnOpenCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnOpenCategoriaActionPerformed
       JDesktopPane desktopPane = getDesktopPane();
       GUIcadastroCategoria ccat = new GUIcadastroCategoria();
       desktopPane.add(ccat);
       ccat.toFront();
       ccat.setVisible(true);
        JInternalFrame[] allFrames = desktopPane.getAllFrames();
        for (JInternalFrame frame : allFrames) {
            System.out.println(frame.getTitle());
            /*if (frame.getTitle().equals("The Frame Title")) {
                // Perform your actions here
                frame.toFront();
                frame.setVisible(true);
            }*/
        }
    }//GEN-LAST:event_jbtnOpenCategoriaActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton jbtCadastrar;
    private javax.swing.JButton jbtnOpenCategoria;
    private javax.swing.JComboBox<String> jcbCategoriaConta;
    private javax.swing.JComboBox<String> jcbFormaPagamentoConta;
    private javax.swing.JTextArea jtaDescricao;
    private javax.swing.JToggleButton jtbPago;
    private javax.swing.JTextField jtfDataPagamentoConta;
    private javax.swing.JTextField jtfDataVencimentoConta;
    private javax.swing.JTextField jtfNomeConta;
    private javax.swing.JTextField jtfValorConta;
    // End of variables declaration//GEN-END:variables

}
