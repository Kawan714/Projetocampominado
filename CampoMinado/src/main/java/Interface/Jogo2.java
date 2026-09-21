/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;

/**
 *
 * @author JhéssikLeal
 */
public class Jogo2 extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Jogo2.class.getName());

    // É O LOCAL ONDE CRIAMOS AS NOSSAS VARIAVEIS
  
    // JButton precisa da importação da sua biblioteca
    // btnCampos é o nome da variavel - (você que escolhe)
    // matriz com - 10 linhas e 10 colunas
    JButton [][] btnCampos = new JButton[10][10];
    
    //MATRIZ PARA GUARDAR AS BOMBAS - true p/ bomba, false p/ numero
    boolean [][] bombas = new boolean [10][10];
    
    // MATRIZ PARA GUARDAR OS CAMPOS QUE FOREM ABERTOS
    boolean [][] abertos = new boolean[10][10];
    
    int quantidadeBombas = 15;
    boolean jogoEncerrado= false;
    
    
    
   
    // CONSTRUTOR DA CLASSE/TELA - SEM ELE A TELA NÃO FUNCIONA
    public Jogo2() {
        initComponents();
        CriarTabuleiro();
    }
    
    
    // CRIAR AS NOSSA FUNÇÕES/METODOS
    
    public void CriarTabuleiro(){
        // definir que o painel será divido em 10 linhas e 10 colunas
        // com altura 2px e largura 2px
        painelCampo.setLayout(new GridLayout(10,10,2,2));
        
        for(int coluna=0;coluna<=9;coluna++){
            for(int linha=0;linha<=9;linha++){
                // váriavel botão para guardar os dados provisorios
                JButton botao = new JButton();
                botao.setFont(new Font("Arial",Font.BOLD,16));// fonte
                botao.setBackground(new Color(255,192,230));// cor de fundo
                botao.setForeground(Color.WHITE);// cor de texto
                
                // remover marcas do botão que vem por padrão
                botao.setFocusPainted(false);
                botao.setEnabled(false);
                
                //adicionar o botao dentro da matriz
                btnCampos[linha][coluna]=botao;
                // adicionar ele dentro do painel
                painelCampo.add(botao);
                
            }// fim do 2° for
        }// fim do 1° for
        
    }// fim do metodo CriarTabuleiro
    
    
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        titulo = new javax.swing.JLabel();
        btnIniciar = new javax.swing.JButton();
        tfTempo = new javax.swing.JTextField();
        painelCampo = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titulo.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 0, 204));
        titulo.setText("Campo Minado");

        btnIniciar.setBackground(new java.awt.Color(255, 51, 204));
        btnIniciar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnIniciar.setForeground(new java.awt.Color(255, 255, 255));
        btnIniciar.setText("INICIAR");

        tfTempo.setEditable(false);
        tfTempo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        tfTempo.setText("00:00");

        painelCampo.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout painelCampoLayout = new javax.swing.GroupLayout(painelCampo);
        painelCampo.setLayout(painelCampoLayout);
        painelCampoLayout.setHorizontalGroup(
            painelCampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 972, Short.MAX_VALUE)
        );
        painelCampoLayout.setVerticalGroup(
            painelCampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 563, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(216, 216, 216)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnIniciar, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                            .addComponent(tfTempo)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(painelCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(titulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tfTempo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(painelCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Jogo().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel painelCampo;
    private javax.swing.JTextField tfTempo;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
