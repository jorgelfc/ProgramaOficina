/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.oficina.telas;

/**
 *
 * @author jorgecosta
 */

import java.sql.*;
import br.com.oficina.dal.ModuloConexao;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class TelaUsuario extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaUsuario
     * 
     * 
     */
    // criando as varriaveis ppara conexao ao banco
    
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    
    public TelaUsuario() {
        initComponents();
        conexao = ModuloConexao.conector();
        
    }
    
    private void Consultar(){
       
        String sql ="SELECT * FROM `tbusuario` WHERE `Nome`=?"; 
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1,txtCadUsuario.getText());
            rs=pst.executeQuery();
            if (rs.next()) {
                //As linhas abaixo preenchem os campos com dados do banco de dados.
                txtValorID.setText(rs.getString(1));
                txtCadUsuario.setText(rs.getString(2));
                txtCadFone.setText(rs.getString(3));
                txtCadLogin.setText(rs.getString(4));
                txtCadSenha.setText(rs.getString(5));
                cboUsoPerfil.setSelectedItem(rs.getString(6));
                
            } else {
                JOptionPane.showMessageDialog(null, "Usuario não cadastrado");
                //As linhas abaixo limpam os campos do form.
                txtValorID.setText(null);
                txtCadUsuario.setText(null);
                txtCadFone.setText(null);
                txtCadLogin.setText(null);
                txtCadSenha.setText(null);
                cboUsoPerfil.setSelectedItem(null);
            }
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e);
        }
       
        
    }

    private void cadastrar(){
        //Metodo para adicionar usuario ao banco.
        String sql = "insert into tbusuario( Nome, Fone, Login, Senha, Perfil) values (?,?,?,?,?)";
        try {
            pst=conexao.prepareStatement(sql);
           // pst.setString(1, txtValorID.getText());
            pst.setString(1, txtCadUsuario.getText());
            pst.setString(2, txtCadFone.getText());
            pst.setString(3, txtCadLogin.getText());
            pst.setString(4, txtCadSenha.getText());
            pst.setString(5, cboUsoPerfil.getSelectedItem().toString());
           
            if(txtCadUsuario.getText().isEmpty() && txtCadLogin.getText().isEmpty() && txtCadSenha.getText().isEmpty()){
               JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatorios");
           }
            
            int adicionado = pst.executeUpdate();
                      
            pst.executeUpdate();
           
            if(adicionado >0){
              
                JOptionPane.showMessageDialog(null, "Usuario adicionado com sucesso!");
                txtCadUsuario.setText(null);
                txtCadFone.setText(null);
                txtCadLogin.setText(null);
                txtCadSenha.setText(null);
                cboUsoPerfil.setSelectedItem(null);
                txtValorID.setText(null);
                
            }
                   
                        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "O usuario ja existe");
             txtCadUsuario.setText(null);
                txtCadFone.setText(null);
                txtCadLogin.setText(null);
                txtCadSenha.setText(null);
                cboUsoPerfil.setSelectedItem(null);
                txtValorID.setText(null);
        }
        
        
    }
    
    //Metodo de editar dados do banco.
    
        private void editar(){
            String sql = "update tbusuario set Nome=?, Fone=?, Login=?, Senha=?, Perfil=? where idusuario=?";
            try {
                
                pst=conexao.prepareStatement(sql);
                pst.setString(1, txtCadUsuario.getText());
                pst.setString(2, txtCadFone.getText());
                pst.setString(3, txtCadLogin.getText());
                pst.setString(4, txtCadSenha.getText());
                pst.setString(5, cboUsoPerfil.getSelectedItem().toString());
                pst.setString(6, txtValorID.getText());
                
                
                if(txtCadUsuario.getText().isEmpty() && txtCadLogin.getText().isEmpty() && txtCadSenha.getText().isEmpty()){
               JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatorios");
           }
            
            int editado = pst.executeUpdate();
                      
            pst.executeUpdate();
           
            if(editado >0){
              
                JOptionPane.showMessageDialog(null, "Usuario editado com sucesso!");
                txtCadUsuario.setText(null);
                txtCadFone.setText(null);
                txtCadLogin.setText(null);
                txtCadSenha.setText(null);
                cboUsoPerfil.setSelectedItem(null);
                 txtValorID.setText(null);
                
                
            }
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            
        }
        
        private void deletar(){
            
            //String sql = ""
        }
                
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tblpesquisa = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtValorID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCadUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCadFone = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCadLogin = new javax.swing.JTextField();
        lblCadSenha = new javax.swing.JLabel();
        txtCadSenha = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cboUsoPerfil = new javax.swing.JComboBox<>();
        btnCadastrar = new javax.swing.JButton();
        btnCons = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblUsuario = new javax.swing.JTable();

        tblpesquisa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Idusuario", "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblpesquisa);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setTitle("Usuarios");
        setPreferredSize(new java.awt.Dimension(640, 480));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ID");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        txtValorID.setEditable(false);
        txtValorID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorIDActionPerformed(evt);
            }
        });

        jLabel2.setText("*Nome");

        txtCadUsuario.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtCadUsuarioInputMethodTextChanged(evt);
            }
        });
        txtCadUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCadUsuarioActionPerformed(evt);
            }
        });

        jLabel3.setText("Fone");

        jLabel4.setText("*Login");

        lblCadSenha.setText("*Senha");

        jLabel6.setText("*Perfil");

        cboUsoPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "administrador", "usuario" }));
        cboUsoPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboUsoPerfilActionPerformed(evt);
            }
        });

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnCons.setText("Consultar");
        btnCons.setPreferredSize(new java.awt.Dimension(31, 28));
        btnCons.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsActionPerformed(evt);
            }
        });

        btnEdit.setText("Editar");
        btnEdit.setPreferredSize(new java.awt.Dimension(31, 28));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setText("Deletar");
        btnDelete.setPreferredSize(new java.awt.Dimension(31, 28));

        jLabel5.setText("* Campos obrigatorios!");

        tblUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Idusuario", "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblUsuario);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtValorID, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtCadLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCadUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblCadSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtCadFone, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCadSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(cboUsoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 16, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCons, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtValorID, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCadUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCadFone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCadSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCadLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCadSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboUsoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCons, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                .addContainerGap())
        );

        setBounds(0, 0, 658, 410);
    }// </editor-fold>//GEN-END:initComponents

    private void txtValorIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorIDActionPerformed

    private void btnConsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsActionPerformed
        
        Consultar();
    }//GEN-LAST:event_btnConsActionPerformed

    private void cboUsoPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboUsoPerfilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboUsoPerfilActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        // TODO add your handling code here:
        cadastrar();
        
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void txtCadUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCadUsuarioActionPerformed
        
        
    }//GEN-LAST:event_txtCadUsuarioActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed

        editar();        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditActionPerformed

    private void txtCadUsuarioInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtCadUsuarioInputMethodTextChanged
        // TODO add your handling code here:
       String sql ="SELECT * FROM `tbusuario` WHERE `Nome`=?"; 
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1,txtCadUsuario.getText());
            
            rs = pst.executeQuery();
            if(rs.next()){
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(TelaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtCadUsuarioInputMethodTextChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCons;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    public static javax.swing.JComboBox<String> cboUsoPerfil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblCadSenha;
    private javax.swing.JTable tblUsuario;
    private javax.swing.JTable tblpesquisa;
    private javax.swing.JTextField txtCadFone;
    private javax.swing.JTextField txtCadLogin;
    private javax.swing.JTextField txtCadSenha;
    private javax.swing.JTextField txtCadUsuario;
    private javax.swing.JTextField txtValorID;
    // End of variables declaration//GEN-END:variables
}
