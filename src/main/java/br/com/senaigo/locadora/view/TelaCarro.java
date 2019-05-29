/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senaigo.locadora.view;

import br.com.senaigo.locadora.controller.ClienteTcpController;
import br.com.senaigo.locadora.model.Categoria;
import br.com.senaigo.locadora.model.Estado;
import br.com.senaigo.locadora.model.Modelo;
import br.com.senaigo.locadora.model.Veiculo;
import br.com.senaigo.locadora.persistencia.Operacao;
import java.io.IOException;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pfellype
 */
public class TelaCarro extends javax.swing.JInternalFrame {
    
    private ClienteTcpController controller;
    private List<Veiculo> fonteDeDadosVeiculo;
    private List<Categoria> fonteDeDadosCategoria;
    private List<Modelo> fonteDeDadosModelo;    

    /**
     * Creates new form TelaCarro
     */
    public TelaCarro() throws IOException {
        controller = new ClienteTcpController();
        inicializeFontesDeDadosCombo();
        initComponents();
        preenchaGrid();
    }
    
    private void inicializeFontesDeDadosCombo() {
        try {
            fonteDeDadosVeiculo = controller.liste("Veiculo");
            fonteDeDadosModelo = controller.liste("Modelo");
            fonteDeDadosCategoria = controller.liste("Categoria");            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao inicializar fontes de dados: " + e.getMessage());
        }
    }
    
    private void preenchaGrid() {
		try {
			atualizeFonteDeDadosVeiculo();
			DefaultTableModel tabela = obtenhaGrid();
			tabela.setRowCount(0);
			for (Veiculo veiculo : fonteDeDadosVeiculo) {
				Object[] campos = {
					veiculo.getId(),
					veiculo.getPlaca(),
					veiculo.getCategoria().getNome(),
                                        veiculo.getEstado().getDescricao()
				};
				tabela.addRow(campos);
			}
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "Erro ao " + Operacao.LISTAR + " Veiculo: " + erro.getMessage());
		}
	}
    
    private DefaultTableModel obtenhaGrid() {
		return (DefaultTableModel) jTableLista.getModel();
	}
    
    private void atualizeFonteDeDadosVeiculo() {
		try {
			fonteDeDadosModelo = controller.liste("Veiculo");
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "Erro do preencher fonte de dados de veículo: " + erro.getMessage());
		}
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
        jPanelCarro = new javax.swing.JPanel();
        jLabelPlaca = new javax.swing.JLabel();
        jTextFieldPlaca = new javax.swing.JTextField();
        jLabelRENAVAM = new javax.swing.JLabel();
        jTextFieldRENAVAM = new javax.swing.JTextField();
        jLabelAno = new javax.swing.JLabel();
        jTextFieldAno = new javax.swing.JTextField();
        jLabelValorCompra = new javax.swing.JLabel();
        jTextFieldValorCompra = new javax.swing.JTextField();
        jLabelQuilometragem = new javax.swing.JLabel();
        jTextFieldQuilometragem = new javax.swing.JTextField();
        jLabelCategoria = new javax.swing.JLabel();
        jLabelEstado = new javax.swing.JLabel();
        jComboBoxCategoria = new javax.swing.JComboBox<>();
        jComboBoxEstado = new javax.swing.JComboBox<>();
        jLabelMarca = new javax.swing.JLabel();
        jLabelModelo = new javax.swing.JLabel();
        jComboBoxMarca = new javax.swing.JComboBox<>();
        jComboBoxModelo = new javax.swing.JComboBox<>();
        jLabelID = new javax.swing.JLabel();
        jTextFieldID = new javax.swing.JTextField();
        jButtonSalvar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jPanelBotoes = new javax.swing.JPanel();
        jButtonNovo = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableLista = new javax.swing.JTable();

        jPanelBase.setBackground(new java.awt.Color(255, 255, 255));

        jPanelCarro.setBackground(new java.awt.Color(255, 255, 255));
        jPanelCarro.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Carro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 18), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabelPlaca.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPlaca.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabelPlaca.setForeground(new java.awt.Color(0, 0, 0));
        jLabelPlaca.setText("Placa:");

        jTextFieldPlaca.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextFieldPlaca.setForeground(new java.awt.Color(0, 0, 0));

        jLabelRENAVAM.setBackground(new java.awt.Color(255, 255, 255));
        jLabelRENAVAM.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabelRENAVAM.setForeground(new java.awt.Color(0, 0, 0));
        jLabelRENAVAM.setText("RENAVAM:");

        jTextFieldRENAVAM.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextFieldRENAVAM.setForeground(new java.awt.Color(0, 0, 0));

        jLabelAno.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAno.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabelAno.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAno.setText("Ano:");

        jTextFieldAno.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextFieldAno.setForeground(new java.awt.Color(0, 0, 0));

        jLabelValorCompra.setBackground(new java.awt.Color(255, 255, 255));
        jLabelValorCompra.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabelValorCompra.setForeground(new java.awt.Color(0, 0, 0));
        jLabelValorCompra.setText("Valor de Compra:");

        jTextFieldValorCompra.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextFieldValorCompra.setForeground(new java.awt.Color(0, 0, 0));

        jLabelQuilometragem.setBackground(new java.awt.Color(255, 255, 255));
        jLabelQuilometragem.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabelQuilometragem.setForeground(new java.awt.Color(0, 0, 0));
        jLabelQuilometragem.setText("Última Quilometragem:");

        jTextFieldQuilometragem.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextFieldQuilometragem.setForeground(new java.awt.Color(0, 0, 0));

        jLabelCategoria.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCategoria.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabelCategoria.setForeground(new java.awt.Color(0, 0, 0));
        jLabelCategoria.setText("Categoria:");

        jLabelEstado.setBackground(new java.awt.Color(255, 255, 255));
        jLabelEstado.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabelEstado.setForeground(new java.awt.Color(0, 0, 0));
        jLabelEstado.setText("Estado:");

        jComboBoxCategoria.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jComboBoxCategoria.setForeground(new java.awt.Color(0, 0, 0));
        jComboBoxCategoria.setModel(new DefaultComboBoxModel(fonteDeDadosCategoria.toArray()));

        jComboBoxEstado.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jComboBoxEstado.setForeground(new java.awt.Color(0, 0, 0));
        jComboBoxEstado.setModel(new DefaultComboBoxModel(Estado.values()));

        jLabelMarca.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMarca.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabelMarca.setForeground(new java.awt.Color(0, 0, 0));
        jLabelMarca.setText("Marca:");

        jLabelModelo.setBackground(new java.awt.Color(255, 255, 255));
        jLabelModelo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabelModelo.setForeground(new java.awt.Color(0, 0, 0));
        jLabelModelo.setText("Modelo:");

        jComboBoxMarca.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jComboBoxMarca.setForeground(new java.awt.Color(0, 0, 0));
        jComboBoxMarca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBoxModelo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jComboBoxModelo.setForeground(new java.awt.Color(0, 0, 0));
        jComboBoxModelo.setModel(new DefaultComboBoxModel(fonteDeDadosModelo.toArray()));

        jLabelID.setBackground(new java.awt.Color(255, 255, 255));
        jLabelID.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabelID.setForeground(new java.awt.Color(0, 0, 0));
        jLabelID.setText("ID:");

        jTextFieldID.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextFieldID.setForeground(new java.awt.Color(0, 0, 0));

        jButtonSalvar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonSalvar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButtonSalvar.setForeground(new java.awt.Color(0, 0, 0));
        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonCancelar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonCancelar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButtonCancelar.setForeground(new java.awt.Color(0, 0, 0));
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelCarroLayout = new javax.swing.GroupLayout(jPanelCarro);
        jPanelCarro.setLayout(jPanelCarroLayout);
        jPanelCarroLayout.setHorizontalGroup(
            jPanelCarroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCarroLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelCarroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCarroLayout.createSequentialGroup()
                        .addGroup(jPanelCarroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelCategoria)
                            .addComponent(jComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                        .addGroup(jPanelCarroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelEstado)
                            .addComponent(jComboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelCarroLayout.createSequentialGroup()
                        .addGroup(jPanelCarroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelID)
                            .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelCarroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelPlaca)
                            .addComponent(jTextFieldPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelCarroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelRENAVAM)
                            .addComponent(jTextFieldRENAVAM, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(jPanelCarroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCarroLayout.createSequentialGroup()
                        .addGroup(jPanelCarroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelMarca)
                            .addComponent(jComboBoxMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                        .addGroup(jPanelCarroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanelCarroLayout.createSequentialGroup()
                                .addComponent(jLabelModelo)
                                .addGap(189, 189, 189))
                            .addComponent(jComboBoxModelo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanelCarroLayout.createSequentialGroup()
                        .addGroup(jPanelCarroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldAno, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelAno))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelCarroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelValorCompra)
                            .addComponent(jTextFieldValorCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelCarroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextFieldQuilometragem, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelQuilometragem, javax.swing.GroupLayout.Alignment.LEADING))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelCarroLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelCarroLayout.setVerticalGroup(
            jPanelCarroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCarroLayout.createSequentialGroup()
                .addGroup(jPanelCarroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCarroLayout.createSequentialGroup()
                        .addComponent(jLabelQuilometragem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelCarroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldQuilometragem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabelID)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCarroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelCarroLayout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addComponent(jTextFieldPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabelPlaca))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCarroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelCarroLayout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addComponent(jTextFieldRENAVAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabelRENAVAM))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCarroLayout.createSequentialGroup()
                        .addComponent(jLabelValorCompra)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldValorCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCarroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelCarroLayout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addComponent(jTextFieldAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabelAno)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanelCarroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelModelo)
                    .addComponent(jLabelMarca)
                    .addComponent(jLabelEstado)
                    .addComponent(jLabelCategoria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCarroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanelCarroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalvar)
                    .addComponent(jButtonCancelar))
                .addGap(0, 18, Short.MAX_VALUE))
        );

        jPanelBotoes.setBackground(new java.awt.Color(255, 255, 255));

        jButtonNovo.setBackground(new java.awt.Color(255, 255, 255));
        jButtonNovo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButtonNovo.setForeground(new java.awt.Color(0, 0, 0));
        jButtonNovo.setText("Novo");
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });

        jButtonEditar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonEditar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButtonEditar.setForeground(new java.awt.Color(0, 0, 0));
        jButtonEditar.setText("Editar");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonExcluir.setBackground(new java.awt.Color(255, 255, 255));
        jButtonExcluir.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButtonExcluir.setForeground(new java.awt.Color(0, 0, 0));
        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBotoesLayout = new javax.swing.GroupLayout(jPanelBotoes);
        jPanelBotoes.setLayout(jPanelBotoesLayout);
        jPanelBotoesLayout.setHorizontalGroup(
            jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonNovo)
                .addGap(524, 524, 524)
                .addComponent(jButtonEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonExcluir)
                .addContainerGap())
        );
        jPanelBotoesLayout.setVerticalGroup(
            jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNovo)
                    .addComponent(jButtonEditar)
                    .addComponent(jButtonExcluir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTableLista.setForeground(new java.awt.Color(0, 0, 0));
        jTableLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Placa", "Categoria", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableLista.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jTableLista);
        if (jTableLista.getColumnModel().getColumnCount() > 0) {
            jTableLista.getColumnModel().getColumn(0).setResizable(false);
            jTableLista.getColumnModel().getColumn(0).setPreferredWidth(70);
            jTableLista.getColumnModel().getColumn(1).setResizable(false);
            jTableLista.getColumnModel().getColumn(1).setPreferredWidth(200);
            jTableLista.getColumnModel().getColumn(2).setResizable(false);
            jTableLista.getColumnModel().getColumn(2).setPreferredWidth(400);
            jTableLista.getColumnModel().getColumn(3).setResizable(false);
            jTableLista.getColumnModel().getColumn(3).setPreferredWidth(400);
        }

        javax.swing.GroupLayout jPanelBaseLayout = new javax.swing.GroupLayout(jPanelBase);
        jPanelBase.setLayout(jPanelBaseLayout);
        jPanelBaseLayout.setHorizontalGroup(
            jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBaseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelCarro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanelBaseLayout.setVerticalGroup(
            jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBaseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelCarro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonExcluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JComboBox<String> jComboBoxCategoria;
    private javax.swing.JComboBox<String> jComboBoxEstado;
    private javax.swing.JComboBox<String> jComboBoxMarca;
    private javax.swing.JComboBox<String> jComboBoxModelo;
    private javax.swing.JLabel jLabelAno;
    private javax.swing.JLabel jLabelCategoria;
    private javax.swing.JLabel jLabelEstado;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelMarca;
    private javax.swing.JLabel jLabelModelo;
    private javax.swing.JLabel jLabelPlaca;
    private javax.swing.JLabel jLabelQuilometragem;
    private javax.swing.JLabel jLabelRENAVAM;
    private javax.swing.JLabel jLabelValorCompra;
    private javax.swing.JPanel jPanelBase;
    private javax.swing.JPanel jPanelBotoes;
    private javax.swing.JPanel jPanelCarro;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableLista;
    private javax.swing.JTextField jTextFieldAno;
    private javax.swing.JTextField jTextFieldID;
    private javax.swing.JTextField jTextFieldPlaca;
    private javax.swing.JTextField jTextFieldQuilometragem;
    private javax.swing.JTextField jTextFieldRENAVAM;
    private javax.swing.JTextField jTextFieldValorCompra;
    // End of variables declaration//GEN-END:variables
}
