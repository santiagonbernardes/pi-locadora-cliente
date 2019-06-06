/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senaigo.locadora.view;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author pfellype
 */
public class TelaLocacao extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaLocacao
     */
    public TelaLocacao() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBase = new javax.swing.JPanel();
        jPanelLocacao = new javax.swing.JPanel();
        jLabelID = new javax.swing.JLabel();
        jTextFieldID = new javax.swing.JTextField();
        jLabelCliente = new javax.swing.JLabel();
        jComboBoxCliente = new javax.swing.JComboBox<>();
        jLabelVeiculo = new javax.swing.JLabel();
        jComboBoxVeiculo = new javax.swing.JComboBox<>();
        jLabelMotorista = new javax.swing.JLabel();
        jComboBoxMotorista = new javax.swing.JComboBox<>();
        jLabelCNHMotoristaImagem = new javax.swing.JLabel();
        jButtonArquivo = new javax.swing.JButton();
        jLabelQuilometragem = new javax.swing.JLabel();
        jTextFieldQuilometragem = new javax.swing.JTextField();
        jLabelCNHMotorista = new javax.swing.JLabel();
        jLabelDataLocacao = new javax.swing.JLabel();
        jFormattedTextFieldDataLocacao = new javax.swing.JFormattedTextField();
        jLabelDataDevolucao = new javax.swing.JLabel();
        jFormattedTextFieldDataDevolucao = new javax.swing.JFormattedTextField();
        jLabelDataCNH = new javax.swing.JLabel();
        jFormattedTextFieldDataCNH = new javax.swing.JFormattedTextField();
        jLabelSituacao = new javax.swing.JLabel();
        jComboBoxSituacao = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableLista = new javax.swing.JTable();
        jPanelBotoes = new javax.swing.JPanel();
        jButtonNova = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 244, 0));
        setBorder(null);

        jPanelBase.setBackground(new java.awt.Color(255, 255, 255));
        jPanelBase.setForeground(new java.awt.Color(0, 0, 0));

        jPanelLocacao.setBackground(new java.awt.Color(255, 255, 255));
        jPanelLocacao.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Locação", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 18), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanelLocacao.setForeground(new java.awt.Color(0, 0, 0));

        jLabelID.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabelID.setForeground(new java.awt.Color(0, 0, 0));
        jLabelID.setText("ID:");

        jTextFieldID.setEditable(false);
        jTextFieldID.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextFieldID.setForeground(new java.awt.Color(0, 0, 0));

        jLabelCliente.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabelCliente.setForeground(new java.awt.Color(0, 0, 0));
        jLabelCliente.setText("Cliente:");

        jComboBoxCliente.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jComboBoxCliente.setForeground(new java.awt.Color(0, 0, 0));
        jComboBoxCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabelVeiculo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabelVeiculo.setForeground(new java.awt.Color(0, 0, 0));
        jLabelVeiculo.setText("Veículo:");

        jComboBoxVeiculo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jComboBoxVeiculo.setForeground(new java.awt.Color(0, 0, 0));
        jComboBoxVeiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabelMotorista.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabelMotorista.setForeground(new java.awt.Color(0, 0, 0));
        jLabelMotorista.setText("Motorista:");

        jComboBoxMotorista.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jComboBoxMotorista.setForeground(new java.awt.Color(0, 0, 0));
        jComboBoxMotorista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButtonArquivo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButtonArquivo.setForeground(new java.awt.Color(0, 0, 0));
        jButtonArquivo.setText("Arquivo");
        jButtonArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonArquivoActionPerformed(evt);
            }
        });

        jLabelQuilometragem.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabelQuilometragem.setForeground(new java.awt.Color(0, 0, 0));
        jLabelQuilometragem.setText("Quilometragem:");

        jTextFieldQuilometragem.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextFieldQuilometragem.setForeground(new java.awt.Color(0, 0, 0));

        jLabelCNHMotorista.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabelCNHMotorista.setForeground(new java.awt.Color(0, 0, 0));
        jLabelCNHMotorista.setText("CNH Motorista:");

        jLabelDataLocacao.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabelDataLocacao.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDataLocacao.setText("Data Locação:");

        jFormattedTextFieldDataLocacao.setForeground(new java.awt.Color(0, 0, 0));
        try {
            jFormattedTextFieldDataLocacao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldDataLocacao.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jLabelDataDevolucao.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabelDataDevolucao.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDataDevolucao.setText("Data Devolução:");

        jFormattedTextFieldDataDevolucao.setForeground(new java.awt.Color(0, 0, 0));
        try {
            jFormattedTextFieldDataDevolucao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldDataDevolucao.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jLabelDataCNH.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabelDataCNH.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDataCNH.setText("Data de Validade da CNH:");

        jFormattedTextFieldDataCNH.setForeground(new java.awt.Color(0, 0, 0));
        try {
            jFormattedTextFieldDataCNH.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldDataCNH.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jLabelSituacao.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabelSituacao.setForeground(new java.awt.Color(0, 0, 0));
        jLabelSituacao.setText("Situação:");

        jComboBoxSituacao.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jComboBoxSituacao.setForeground(new java.awt.Color(0, 0, 0));
        jComboBoxSituacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanelLocacaoLayout = new javax.swing.GroupLayout(jPanelLocacao);
        jPanelLocacao.setLayout(jPanelLocacaoLayout);
        jPanelLocacaoLayout.setHorizontalGroup(
            jPanelLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLocacaoLayout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(jPanelLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLocacaoLayout.createSequentialGroup()
                        .addGroup(jPanelLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelID)
                            .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addGroup(jPanelLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelCliente)
                            .addComponent(jComboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelLocacaoLayout.createSequentialGroup()
                        .addComponent(jLabelMotorista)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelLocacaoLayout.createSequentialGroup()
                        .addGroup(jPanelLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxMotorista, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelLocacaoLayout.createSequentialGroup()
                                .addGroup(jPanelLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelVeiculo)
                                    .addComponent(jComboBoxVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50)
                                .addGroup(jPanelLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabelDataCNH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jFormattedTextFieldDataCNH)))
                            .addGroup(jPanelLocacaoLayout.createSequentialGroup()
                                .addGroup(jPanelLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jComboBoxSituacao, javax.swing.GroupLayout.Alignment.LEADING, 0, 170, Short.MAX_VALUE)
                                        .addComponent(jLabelQuilometragem, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextFieldQuilometragem, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(jLabelSituacao))
                                .addGap(29, 29, 29)
                                .addGroup(jPanelLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelDataLocacao)
                                    .addComponent(jFormattedTextFieldDataLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(jPanelLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jFormattedTextFieldDataDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelDataDevolucao))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanelLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCNHMotorista)
                    .addComponent(jLabelCNHMotoristaImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanelLocacaoLayout.setVerticalGroup(
            jPanelLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLocacaoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLocacaoLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabelCNHMotoristaImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonArquivo))
                    .addGroup(jPanelLocacaoLayout.createSequentialGroup()
                        .addGroup(jPanelLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelID)
                            .addComponent(jLabelCliente)
                            .addComponent(jLabelCNHMotorista))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabelMotorista)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxMotorista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanelLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelVeiculo)
                            .addComponent(jLabelDataCNH))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextFieldDataCNH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanelLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelQuilometragem)
                            .addComponent(jLabelDataLocacao)
                            .addComponent(jLabelDataDevolucao))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldQuilometragem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextFieldDataLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextFieldDataDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(jLabelSituacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17))
        );

        jTableLista.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTableLista.setForeground(new java.awt.Color(0, 0, 0));
        jTableLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Cliente", "Motorista", "Veículo", "Data da Locação", "Data da Devolução", "Situação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableLista);
        if (jTableLista.getColumnModel().getColumnCount() > 0) {
            jTableLista.getColumnModel().getColumn(0).setResizable(false);
            jTableLista.getColumnModel().getColumn(1).setResizable(false);
            jTableLista.getColumnModel().getColumn(2).setResizable(false);
            jTableLista.getColumnModel().getColumn(3).setResizable(false);
            jTableLista.getColumnModel().getColumn(4).setResizable(false);
            jTableLista.getColumnModel().getColumn(5).setResizable(false);
            jTableLista.getColumnModel().getColumn(6).setResizable(false);
        }

        jPanelBotoes.setBackground(new java.awt.Color(255, 255, 255));
        jPanelBotoes.setForeground(new java.awt.Color(0, 0, 0));

        jButtonNova.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButtonNova.setForeground(new java.awt.Color(0, 0, 0));
        jButtonNova.setText("Nova");
        jButtonNova.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovaActionPerformed(evt);
            }
        });

        jButtonSalvar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButtonSalvar.setForeground(new java.awt.Color(0, 0, 0));
        jButtonSalvar.setText("Salvar");

        jButtonEditar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButtonEditar.setForeground(new java.awt.Color(0, 0, 0));
        jButtonEditar.setText("Editar");

        jButtonCancelar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButtonCancelar.setForeground(new java.awt.Color(0, 0, 0));
        jButtonCancelar.setText("Cancelar");

        javax.swing.GroupLayout jPanelBotoesLayout = new javax.swing.GroupLayout(jPanelBotoes);
        jPanelBotoes.setLayout(jPanelBotoesLayout);
        jPanelBotoesLayout.setHorizontalGroup(
            jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotoesLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jButtonNova, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanelBotoesLayout.setVerticalGroup(
            jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotoesLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNova)
                    .addComponent(jButtonSalvar)
                    .addComponent(jButtonEditar)
                    .addComponent(jButtonCancelar))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelBaseLayout = new javax.swing.GroupLayout(jPanelBase);
        jPanelBase.setLayout(jPanelBaseLayout);
        jPanelBaseLayout.setHorizontalGroup(
            jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBaseLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanelBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelLocacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelBaseLayout.setVerticalGroup(
            jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBaseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jPanelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBase, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNovaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonNovaActionPerformed

    private void jButtonArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonArquivoActionPerformed
        // TODO add your handling code here:
        try {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("Procurar imagem");
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			FileNameExtensionFilter filtro = new FileNameExtensionFilter("Imagem", "jpg", "png");
			fileChooser.setFileFilter(filtro);
			int retorno = fileChooser.showOpenDialog(this);
			if (retorno == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();
				BufferedImage imagemOriginal = ImageIO.read(file);
				//BufferedImage imagemTratada = new BufferedImage(LARGURA_LOGO, ALTURA_LOGO, imagemOriginal.getType());
				//Graphics2D graphics = imagemTratada.createGraphics();
				//graphics.drawImage(imagemOriginal, 0, 0, LARGURA_LOGO, ALTURA_LOGO, null);
				//graphics.dispose();
				//jLabelCNHMotoristaImagem.setIcon(new ImageIcon(imagemTratada));
			}

		} catch (Exception e) {
		}
    }//GEN-LAST:event_jButtonArquivoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonArquivo;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonNova;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JComboBox<String> jComboBoxCliente;
    private javax.swing.JComboBox<String> jComboBoxMotorista;
    private javax.swing.JComboBox<String> jComboBoxSituacao;
    private javax.swing.JComboBox<String> jComboBoxVeiculo;
    private javax.swing.JFormattedTextField jFormattedTextFieldDataCNH;
    private javax.swing.JFormattedTextField jFormattedTextFieldDataDevolucao;
    private javax.swing.JFormattedTextField jFormattedTextFieldDataLocacao;
    private javax.swing.JLabel jLabelCNHMotorista;
    private javax.swing.JLabel jLabelCNHMotoristaImagem;
    private javax.swing.JLabel jLabelCliente;
    private javax.swing.JLabel jLabelDataCNH;
    private javax.swing.JLabel jLabelDataDevolucao;
    private javax.swing.JLabel jLabelDataLocacao;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelMotorista;
    private javax.swing.JLabel jLabelQuilometragem;
    private javax.swing.JLabel jLabelSituacao;
    private javax.swing.JLabel jLabelVeiculo;
    private javax.swing.JPanel jPanelBase;
    private javax.swing.JPanel jPanelBotoes;
    private javax.swing.JPanel jPanelLocacao;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableLista;
    private javax.swing.JTextField jTextFieldID;
    private javax.swing.JTextField jTextFieldQuilometragem;
    // End of variables declaration//GEN-END:variables
}