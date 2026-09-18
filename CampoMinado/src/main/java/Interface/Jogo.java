/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author JhéssikLeal
 */
public class Jogo extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Jogo.class.getName());

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
    int quantidadeCasasAbertas=0;
    
    boolean jogoEncerrado= false;
    
    
    
   
    // CONSTRUTOR DA CLASSE/TELA - SEM ELE A TELA NÃO FUNCIONA
    public Jogo() {
        initComponents();
        //definir tamanho para o painel
        painelCampo.setPreferredSize(new Dimension(900,700));
        
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
                
                final int linhaSelecionada= linha;
                final int colunaSelecionada= coluna;        
                //adicionar o evento de clique para abrir as casas
                botao.addActionListener((ActionEvent Evento)->{
                    abrirBotao(linhaSelecionada,colunaSelecionada);
                    
                           });
                
                
                
                //adicionar o botao dentro da matriz
                btnCampos[linha][coluna]=botao;
                // adicionar ele dentro do painel
                painelCampo.add(botao);
                
            }// fim do 2° for
        }// fim do 1° for
        
    }// fim do metodo CriarTabuleiro
    
    public void AdicionarBombas(){
        //Criar uma variavel Random para gerar valores aleatorios
        Random sorteador = new Random();
        int bombasAdicionadas = 0;
        
        while(bombasAdicionadas<quantidadeBombas){
            // sortear o n° da linha e coluna que vai ficar a bomba
            int linha =sorteador.nextInt(10);
            int coluna = sorteador.nextInt(10);
            //verifica se não existe bomba adicionada no local
            if(!bombas[linha][coluna]){
                //adicionar a bomba na matriz
                bombas[linha][coluna]=true;
                bombasAdicionadas++;
            }
        }
        
        
        //fim do adicionarBombas
    }
    
    
    public void IniciarJogo(){
        //chamar o metodo adicionarBombas
        AdicionarBombas();
        
        //depois precisamos inicar os botoes do jogo
        for(int colunas=0;colunas<=9;colunas++){
            for(int linhas=0;linhas<=9;linhas++){
                JButton botao = btnCampos[linhas][colunas];
                botao.setEnabled(true);
                
                
            }//fim do 2° for
        }//fim do 1° for
            btnIniciar.setText("REINICAR");
        
        //fim do iniciar jogo
    }
    
    
    public void abrirBotao(int linha, int coluna){
        // verificar é se o jogo foi finalizado
        if(jogoEncerrado) return;
            
        //verificar se o botao ja foi aberto
        if(abertos[linha][coluna]) return;    
        /*se o jogo ainda estiver rodando e o botão ainda nao tiver sido aberto - então vamos abrir o botão*/
        abertos[linha][coluna]=true;
        quantidadeCasasAbertas++;
        
        // acessar o que tem dentro do botão
        JButton botao = btnCampos[linha][coluna];
        //se no botão tiver uma bomba, então vamos mostrar a bomba a 
        if(bombas[linha][coluna]){
            ImageIcon imgBomba = new ImageIcon(getClass().getResource("/Interface/blast.png"));
            //colocar a imagem no botao
            botao.setIcon(imgBomba);
            return;
        }else{
            ImageIcon imgBandeira = new ImageIcon(getClass().getResource("/Interface/finish.png"));
            botao.setIcon(imgBandeira);
        }


    }// fim do metodo abrirBotao

    
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
        btnIniciar.addActionListener(this::btnIniciarActionPerformed);

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

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        // TODO add your handling code here:
        IniciarJogo();
    }//GEN-LAST:event_btnIniciarActionPerformed

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
