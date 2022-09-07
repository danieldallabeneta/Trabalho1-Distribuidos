package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author danie
 */
public class Tela extends javax.swing.JFrame {

    private static String ip;
    private static int porta;

    /**
     * Creates new form tela
     */
    public Tela(String ip, int porta) {
        this.ip = ip;
        this.porta = porta;
        initComponents();
        acaoConfirmar();
        acaoFechar();
    }

    private void acaoConfirmar() {
        btConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String opcao = cbOpcao.getItemAt(cbOpcao.getSelectedIndex());
                switch (opcao) {
                    case "Selecione...":
                        JOptionPane.showMessageDialog(null, "Selecione uma opção válida");
                        break;
                    case "Incluir Pessoa":
                        TelaCadastrarPessoa cadastro = new TelaCadastrarPessoa(ip, porta, "");;
                        cadastro.setVisible(true);
                        break;
                    case "Incluir Vaga":
                        TelaCadastroVaga vaga = new TelaCadastroVaga(ip, porta, "");
                        vaga.setVisible(true);
                        break;
                    case "Se candidatar a uma Vaga":
                        TelaCandidatar candidatar = new TelaCandidatar(ip, porta);
                        candidatar.setVisible(true);
                        break;
                    case "Excluir Pessoa":
                        TelaExcluirPessoa excluirPessoa = new TelaExcluirPessoa(ip, porta);
                        excluirPessoa.setVisible(true);
                        break;
                    case "Excluir Vaga":
                        TelaExcluirVaga excluirVaga = new TelaExcluirVaga(ip, porta);
                        excluirVaga.setVisible(true);
                        break;
                    case "Listar Pessoas":
                        TelaListarPessoas listarPessoas = new TelaListarPessoas(ip, porta);
                        listarPessoas.setVisible(true);
                        break;
                    case "Listar Vagas":
                        TelaListarVagas listarVagas = new TelaListarVagas(ip, porta);
                        listarVagas.setVisible(true);
                        break;
                    case "Alterar Pessoa":
                        TelaVisualizarPessoa visualizar = new TelaVisualizarPessoa(ip, porta);
                        visualizar.setVisible(true);
                        break;
                    case "Alterar Vaga":
                        TelaVisualizarVaga visualizarVaga = new TelaVisualizarVaga(ip, porta);
                        visualizarVaga.setVisible(true);
                        break;
                }
            }
        });
    }
    
    private void acaoFechar() {
        btFechar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dispose();
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtDescricao = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cbOpcao = new javax.swing.JComboBox<>();
        btConfirmar = new javax.swing.JButton();
        btFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtDescricao.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jtDescricao.setText("Seleciona a opção que deseja executar!");
        jtDescricao.setToolTipText("");
        jtDescricao.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Opção:");

        cbOpcao.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbOpcao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "Incluir Pessoa", "Incluir Vaga", "Se candidatar a uma Vaga", "Excluir Pessoa", "Excluir Vaga", "Listar Pessoas", "Listar Vagas", "Alterar Pessoa", "Alterar Vaga" }));

        btConfirmar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btConfirmar.setText("Confirmar");

        btFechar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btFechar.setText("Fechar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbOpcao, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jtDescricao))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(btConfirmar)
                        .addGap(71, 71, 71)
                        .addComponent(btFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtDescricao)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbOpcao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btConfirmar)
                    .addComponent(btFechar))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btConfirmar;
    private javax.swing.JButton btFechar;
    private javax.swing.JComboBox<String> cbOpcao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jtDescricao;
    // End of variables declaration//GEN-END:variables

}
