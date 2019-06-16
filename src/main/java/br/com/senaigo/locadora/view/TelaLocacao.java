/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senaigo.locadora.view;

import br.com.senaigo.locadora.controller.ClienteTcpController;
import br.com.senaigo.locadora.controller.LocacaoController;
import br.com.senaigo.locadora.excecoes.ValidacaoException;
import br.com.senaigo.locadora.model.Categoria;
import br.com.senaigo.locadora.model.Cliente;
import br.com.senaigo.locadora.model.Locacao;
import br.com.senaigo.locadora.model.Motorista;
import br.com.senaigo.locadora.model.SituacaoLocacao;
import br.com.senaigo.locadora.model.Veiculo;
import br.com.senaigo.locadora.persistencia.Operacao;
import br.com.senaigo.locadora.utils.DataUtils;
import br.com.senaigo.locadora.utils.Utils;
import br.com.senaigo.locadora.utils.formularioUtils.*;
import br.com.senaigo.locadora.view.componentes.JComboBoxModelCategoria;
import br.com.senaigo.locadora.view.componentes.JComboBoxModelCliente;
import br.com.senaigo.locadora.view.componentes.JComboBoxModelMotorista;
import br.com.senaigo.locadora.view.componentes.JComboBoxModelVeiculo;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pfellype
 */
public class TelaLocacao extends javax.swing.JInternalFrame {

	private List<Cliente> fonteDeDadosClientes;
	private List<Veiculo> fonteDeDadosVeiculos;
	private List<Motorista> fonteDeDadosMotoristas;
	private List<Locacao> fonteDeDadosLocacao;
	private List<SituacaoLocacao> fonteDeDadosSituacoes;
	private List<Categoria> fonteDeDadosCategorias;
	private ClienteTcpController controllerCliente;

	public TelaLocacao() {
		try {
			controllerCliente = new ClienteTcpController();
			inicializeComboBoxes();
			initComponents();
			preenchaGrid();
		} catch (Exception erro) {
			String titulo = "Erro ao abrir tela de locação!";
			Utils.mostreAdvertencia(erro, titulo);
		}
	}

	private void inicializeComboBoxes() {
		try {
			fonteDeDadosClientes = controllerCliente.liste("Cliente");
			fonteDeDadosMotoristas = controllerCliente.liste("Motorista");
			fonteDeDadosVeiculos = controllerCliente.liste("Veiculo");
			fonteDeDadosCategorias = controllerCliente.liste("Categoria");
			fonteDeDadosSituacoes = Arrays.asList(SituacaoLocacao.values());
		} catch (Exception erro) {
			String msg = "Erro ao inicializar combo boxes!";
			Utils.mostreAdvertencia(erro, msg);
		}
	}

	private void preenchaGrid() {
		try {
			atualizeFonteDeDadosLocacao();
			DefaultTableModel tabela = (DefaultTableModel) jTableLista.getModel();
			tabela.setRowCount(0);
			for (Locacao locacao : fonteDeDadosLocacao) {
				Object[] campos = {
						locacao.getId(),
						locacao.getCliente().getNome(),
						locacao.getMotorista().getNome(),
						locacao.getVeiculo().toString(),
						DataUtils.convertaLocalDateParaStringFormatada(locacao.getDataDaLocacao()),
						DataUtils.convertaLocalDateParaStringFormatada(locacao.getDataPrevistaParaDevolucao()),
						locacao.getSituacao().getDescricao()
				};
				tabela.addRow(campos);
			}
		} catch (Exception erro) {
			Utils.mostreAdvertenciaPreenchimentoGrid(erro);
		}


	}

	private void atualizeFonteDeDadosLocacao() {
		try {
			fonteDeDadosLocacao = controllerCliente.liste("Locacao");
		} catch (Exception erro) {
			Utils.mostreAdvertenciaPreenchimentoGrid(erro);
		}
	}

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
        jButtonFotoCNH = new javax.swing.JButton();
        jLabelQuilometragem = new javax.swing.JLabel();
        jTextFieldQuilometragem = new javax.swing.JTextField();
        jLabelCNHMotorista = new javax.swing.JLabel();
        jLabelDataLocacao = new javax.swing.JLabel();
        jFormattedTextFieldDataLocacao = new javax.swing.JFormattedTextField();
        jLabelDataDevolucao = new javax.swing.JLabel();
        jFormattedTextFieldDataPrevistaDevolucao = new javax.swing.JFormattedTextField();
        jLabelDataCNH = new javax.swing.JLabel();
        jFormattedTextFieldDataCNH = new javax.swing.JFormattedTextField();
        jLabelSituacao = new javax.swing.JLabel();
        jComboBoxSituacao = new javax.swing.JComboBox<>();
        jComboBoxSituacao.setSelectedIndex(-1);
        jCheckBoxEMotorista = new javax.swing.JCheckBox();
        jLabelNumeroCNH = new javax.swing.JLabel();
        jLabelCategoria = new javax.swing.JLabel();
        jComboBoxCategoria = new javax.swing.JComboBox<>();
        jFormattedTextFieldCnh = new javax.swing.JFormattedTextField();
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
        jTextFieldID.setEnabled(false);

        jLabelCliente.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabelCliente.setForeground(new java.awt.Color(0, 0, 0));
        jLabelCliente.setText("Cliente:");

        jComboBoxCliente.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jComboBoxCliente.setForeground(new java.awt.Color(0, 0, 0));
        jComboBoxCliente.setModel(new JComboBoxModelCliente(fonteDeDadosClientes)
        );
        jComboBoxCliente.setEnabled(false);
        jComboBoxCliente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxClienteItemStateChanged(evt);
            }
        });

        jLabelVeiculo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabelVeiculo.setForeground(new java.awt.Color(0, 0, 0));
        jLabelVeiculo.setText("Veículo:");

        jComboBoxVeiculo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jComboBoxVeiculo.setForeground(new java.awt.Color(0, 0, 0));
        jComboBoxVeiculo.setModel(new JComboBoxModelVeiculo(fonteDeDadosVeiculos));
        jComboBoxVeiculo.setEnabled(false);
        jComboBoxVeiculo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxVeiculoItemStateChanged(evt);
            }
        });

        jLabelMotorista.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabelMotorista.setForeground(new java.awt.Color(0, 0, 0));
        jLabelMotorista.setText("Motorista:");

        jComboBoxMotorista.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jComboBoxMotorista.setForeground(new java.awt.Color(0, 0, 0));
        jComboBoxMotorista.setModel(new JComboBoxModelMotorista(fonteDeDadosMotoristas)
        );
        jComboBoxMotorista.setEnabled(false);

        jLabelCNHMotoristaImagem.setEnabled(false);

        jButtonFotoCNH.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButtonFotoCNH.setForeground(new java.awt.Color(0, 0, 0));
        jButtonFotoCNH.setText("Foto da CNH");
        jButtonFotoCNH.setEnabled(false);
        jButtonFotoCNH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFotoCNHActionPerformed(evt);
            }
        });

        jLabelQuilometragem.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabelQuilometragem.setForeground(new java.awt.Color(0, 0, 0));
        jLabelQuilometragem.setText("Quilometragem:");

        jTextFieldQuilometragem.setEditable(false);
        jTextFieldQuilometragem.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextFieldQuilometragem.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldQuilometragem.setEnabled(false);

        jLabelCNHMotorista.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabelCNHMotorista.setForeground(new java.awt.Color(0, 0, 0));
        jLabelCNHMotorista.setText("CNH Motorista:");

        jLabelDataLocacao.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabelDataLocacao.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDataLocacao.setText("Data Locação:");

        jFormattedTextFieldDataLocacao.setEditable(false);
        jFormattedTextFieldDataLocacao.setForeground(new java.awt.Color(0, 0, 0));
        try {
            jFormattedTextFieldDataLocacao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldDataLocacao.setEnabled(false);
        jFormattedTextFieldDataLocacao.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jLabelDataDevolucao.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabelDataDevolucao.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDataDevolucao.setText("Data Prevista Devolução:");

        jFormattedTextFieldDataPrevistaDevolucao.setEditable(false);
        jFormattedTextFieldDataPrevistaDevolucao.setForeground(new java.awt.Color(0, 0, 0));
        try {
            jFormattedTextFieldDataPrevistaDevolucao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldDataPrevistaDevolucao.setEnabled(false);
        jFormattedTextFieldDataPrevistaDevolucao.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jLabelDataCNH.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabelDataCNH.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDataCNH.setText("Data de Validade da CNH:");

        jFormattedTextFieldDataCNH.setEditable(false);
        jFormattedTextFieldDataCNH.setForeground(new java.awt.Color(0, 0, 0));
        try {
            jFormattedTextFieldDataCNH.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldDataCNH.setEnabled(false);
        jFormattedTextFieldDataCNH.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jLabelSituacao.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabelSituacao.setForeground(new java.awt.Color(0, 0, 0));
        jLabelSituacao.setText("Situação:");

        jComboBoxSituacao.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jComboBoxSituacao.setForeground(new java.awt.Color(0, 0, 0));
        jComboBoxSituacao.setModel(new DefaultComboBoxModel(fonteDeDadosSituacoes.toArray()));
        jComboBoxSituacao.setEnabled(false);

        jCheckBoxEMotorista.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jCheckBoxEMotorista.setForeground(new java.awt.Color(0, 0, 0));
        jCheckBoxEMotorista.setText("É motorista");
        jCheckBoxEMotorista.setEnabled(false);
        jCheckBoxEMotorista.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxEMotoristaItemStateChanged(evt);
            }
        });

        jLabelNumeroCNH.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabelNumeroCNH.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNumeroCNH.setText("Número da CNH:");

        jLabelCategoria.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabelCategoria.setForeground(new java.awt.Color(0, 0, 0));
        jLabelCategoria.setText("Categoria:");

        jComboBoxCategoria.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jComboBoxCategoria.setForeground(new java.awt.Color(0, 0, 0));
        jComboBoxCategoria.setModel(new JComboBoxModelCategoria(fonteDeDadosCategorias));
        jComboBoxCategoria.setEnabled(false);
        jComboBoxCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxCategoriaItemStateChanged(evt);
            }
        });

        jFormattedTextFieldCnh.setEditable(false);
        try {
            jFormattedTextFieldCnh.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldCnh.setEnabled(false);

        javax.swing.GroupLayout jPanelLocacaoLayout = new javax.swing.GroupLayout(jPanelLocacao);
        jPanelLocacao.setLayout(jPanelLocacaoLayout);
        jPanelLocacaoLayout.setHorizontalGroup(
            jPanelLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLocacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLocacaoLayout.createSequentialGroup()
                        .addGroup(jPanelLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelLocacaoLayout.createSequentialGroup()
                                .addComponent(jLabelVeiculo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanelLocacaoLayout.createSequentialGroup()
                                .addComponent(jComboBoxVeiculo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(91, 91, 91)))
                        .addGroup(jPanelLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFormattedTextFieldDataPrevistaDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDataDevolucao))
                        .addGap(127, 127, 127))
                    .addGroup(jPanelLocacaoLayout.createSequentialGroup()
                        .addComponent(jLabelMotorista)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelDataLocacao)
                        .addGap(90, 90, 90))
                    .addGroup(jPanelLocacaoLayout.createSequentialGroup()
                        .addGroup(jPanelLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelLocacaoLayout.createSequentialGroup()
                                .addGroup(jPanelLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelSituacao)
                                    .addComponent(jComboBoxSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(62, 62, 62)
                                .addGroup(jPanelLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabelQuilometragem, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldQuilometragem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanelLocacaoLayout.createSequentialGroup()
                                .addComponent(jComboBoxMotorista, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(jFormattedTextFieldDataLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelLocacaoLayout.createSequentialGroup()
                        .addGroup(jPanelLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelLocacaoLayout.createSequentialGroup()
                                .addGroup(jPanelLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabelDataCNH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jFormattedTextFieldDataCNH, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanelLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelCategoria)
                                    .addComponent(jComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanelLocacaoLayout.createSequentialGroup()
                                .addGroup(jPanelLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelID)
                                    .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(jPanelLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelLocacaoLayout.createSequentialGroup()
                                        .addComponent(jComboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBoxEMotorista))
                                    .addComponent(jLabelCliente))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)))
                .addGroup(jPanelLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCNHMotorista)
                    .addComponent(jLabelCNHMotoristaImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonFotoCNH, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNumeroCNH)
                    .addComponent(jFormattedTextFieldCnh, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanelLocacaoLayout.setVerticalGroup(
            jPanelLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLocacaoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelID)
                    .addComponent(jLabelCliente)
                    .addComponent(jLabelNumeroCNH))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxEMotorista)
                    .addComponent(jFormattedTextFieldCnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMotorista)
                    .addComponent(jLabelCNHMotorista)
                    .addComponent(jLabelDataLocacao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLocacaoLayout.createSequentialGroup()
                        .addComponent(jLabelCNHMotoristaImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonFotoCNH))
                    .addGroup(jPanelLocacaoLayout.createSequentialGroup()
                        .addGroup(jPanelLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxMotorista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextFieldDataLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelDataCNH)
                            .addComponent(jLabelCategoria))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jFormattedTextFieldDataCNH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelLocacaoLayout.createSequentialGroup()
                                .addComponent(jLabelVeiculo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelLocacaoLayout.createSequentialGroup()
                                .addComponent(jLabelDataDevolucao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFormattedTextFieldDataPrevistaDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(38, 38, 38)
                        .addGroup(jPanelLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelLocacaoLayout.createSequentialGroup()
                                .addComponent(jLabelSituacao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelLocacaoLayout.createSequentialGroup()
                                .addComponent(jLabelQuilometragem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldQuilometragem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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
        jButtonNova.setText("Nova Locação");
        jButtonNova.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovaActionPerformed(evt);
            }
        });

        jButtonSalvar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButtonSalvar.setForeground(new java.awt.Color(0, 0, 0));
        jButtonSalvar.setText("Efetuar Locação");
        jButtonSalvar.setEnabled(false);
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonEditar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButtonEditar.setForeground(new java.awt.Color(0, 0, 0));
        jButtonEditar.setText("Editar");
        jButtonEditar.setEnabled(false);

        jButtonCancelar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButtonCancelar.setForeground(new java.awt.Color(0, 0, 0));
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setEnabled(false);
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

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
                .addComponent(jButtonSalvar)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jPanelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
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
		jComboBoxCliente.setEnabled(true);
		jFormattedTextFieldDataCNH.setEnabled(true);
		jFormattedTextFieldDataCNH.setEditable(true);
		jComboBoxCategoria.setEnabled(true);
		jFormattedTextFieldDataPrevistaDevolucao.setEnabled(true);
		jFormattedTextFieldDataPrevistaDevolucao.setEditable(true);
		jButtonFotoCNH.setEnabled(true);
		jLabelCNHMotoristaImagem.setEnabled(true);
		LocalDate dataHoje = LocalDate.now();
                String dataConvertida = DataUtils.convertaLocalDateParaStringFormatada(dataHoje);
		jFormattedTextFieldDataLocacao.setText(dataConvertida);
                jFormattedTextFieldDataLocacao.setValue(dataConvertida);
		jComboBoxSituacao.setSelectedItem(SituacaoLocacao.ABERTO);
                jButtonNova.setEnabled(false);
                jButtonCancelar.setEnabled(true);
                jButtonSalvar.setEnabled(true);
	}//GEN-LAST:event_jButtonNovaActionPerformed

	private void jButtonFotoCNHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFotoCNHActionPerformed
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
				int largura = jLabelCNHMotoristaImagem.getWidth();
				int altura = jLabelCNHMotoristaImagem.getHeight();
				BufferedImage imagemTratada = new BufferedImage(largura, altura, imagemOriginal.getType());
				Graphics2D graphics = imagemTratada.createGraphics();
				graphics.drawImage(imagemOriginal, 0, 0, largura, altura, null);
				graphics.dispose();
				jLabelCNHMotoristaImagem.setIcon(new ImageIcon(imagemTratada));
			}

		} catch (Exception e) {
		}
	}//GEN-LAST:event_jButtonFotoCNHActionPerformed

	private void jComboBoxClienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxClienteItemStateChanged
		int index = jComboBoxCliente.getSelectedIndex();
		Cliente clienteSelecionado = jComboBoxCliente.getItemAt(index);
		if (clienteSelecionado != null) {
			boolean deveHabilitarCheckBox = !clienteSelecionado.getCpf().isEmpty();
			jCheckBoxEMotorista.setEnabled(deveHabilitarCheckBox);
			jCheckBoxEMotorista.setSelected(false);
			jComboBoxMotorista.setEnabled(true);
		}
	}//GEN-LAST:event_jComboBoxClienteItemStateChanged

	private void jCheckBoxEMotoristaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxEMotoristaItemStateChanged
		boolean ehMotorista = jCheckBoxEMotorista.isSelected();
		jFormattedTextFieldCnh.setEnabled(ehMotorista);
		jFormattedTextFieldCnh.setEditable(ehMotorista);
		jComboBoxMotorista.setEnabled(!ehMotorista);
		jComboBoxMotorista.setSelectedIndex(-1);
		if (!ehMotorista) {
			jFormattedTextFieldCnh.setText("");
			jFormattedTextFieldCnh.setValue(null);
		}
	}//GEN-LAST:event_jCheckBoxEMotoristaItemStateChanged

	private void jComboBoxCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxCategoriaItemStateChanged
		int index = jComboBoxCategoria.getSelectedIndex();
		Categoria categoriaSelecionada = jComboBoxCategoria.getItemAt(index);

		if (categoriaSelecionada != null) {
			List<Veiculo> veiculosFiltrados = new ArrayList<>();
			for (Veiculo veiculo : fonteDeDadosVeiculos) {
				if (veiculo.getCategoria().equals(categoriaSelecionada)) {
					veiculosFiltrados.add(veiculo);
				}
			}
			jComboBoxVeiculo.setModel(new JComboBoxModelVeiculo(veiculosFiltrados));
			jComboBoxVeiculo.setEnabled(true);
		}
	}//GEN-LAST:event_jComboBoxCategoriaItemStateChanged

	private void jComboBoxVeiculoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxVeiculoItemStateChanged
		int index = jComboBoxVeiculo.getSelectedIndex();
		Veiculo veiculoSelecionado = jComboBoxVeiculo.getItemAt(index);
		if (veiculoSelecionado != null) {
			String kmAtual = String.valueOf(veiculoSelecionado.getKmAtual());
			jTextFieldQuilometragem.setText(kmAtual);
		}
	}//GEN-LAST:event_jComboBoxVeiculoItemStateChanged

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        try {
            CampoId campoId = new CampoId(jLabelID, jTextFieldID);
            CampoComboBox<Cliente> comboCliente = new CampoComboBox<>(jLabelCliente, jComboBoxCliente);
            CampoDeTexto campoCnh = new CampoDeTexto(jLabelCNHMotorista, jFormattedTextFieldCnh, jCheckBoxEMotorista.isSelected());
            CampoComboBox<Motorista> comboMotorista = new CampoComboBox<>(jLabelMotorista, jComboBoxMotorista, !jCheckBoxEMotorista.isSelected());
            CampoData campoDataLocacao = new CampoData(jLabelDataLocacao, jFormattedTextFieldDataLocacao, true);
            CampoData campoValidadeCnh = new CampoData(jLabelDataCNH, jFormattedTextFieldDataCNH, true);
            CampoComboBox<Veiculo> comboVeiculo = new CampoComboBox(jLabelVeiculo, jComboBoxVeiculo);
            CampoData campoDataPrevistaDev = new CampoData(jLabelDataDevolucao, jFormattedTextFieldDataPrevistaDevolucao, true);
            CampoDeTexto campoKm = new CampoDeTexto(jLabelQuilometragem, jTextFieldQuilometragem, true, ValidacaoTexto.CARRO_KM);            
            CampoComImagem campoImagem = new CampoComImagem(jLabelCNHMotoristaImagem, "Locações");
            
            
            Locacao locacao = new Locacao();
            locacao.setId(campoId.getDadosDoCampo());
            Cliente cliente = (Cliente) comboCliente.getDadosDoCampo();
            locacao.setCliente(cliente);
            locacao.setVeiculo((Veiculo) comboVeiculo.getDadosDoCampo());
            
            
            Motorista motorista;
            if(jCheckBoxEMotorista.isSelected()) {
                valideCnhUnica(campoCnh);
                motorista = new Motorista(cliente, campoCnh.getDadosDoCampo());                       
            } else {
                motorista = (Motorista) comboMotorista.getDadosDoCampo();
            }
            locacao.setMotorista(motorista);
            locacao.setDataDaLocacao(DataUtils.convertaStringParaLocalDate(campoDataLocacao.getDadosDoCampo()));
            locacao.setDataPrevistaParaDevolucao(DataUtils.convertaStringParaLocalDate(campoDataPrevistaDev.getDadosDoCampo()));
            locacao.setKmVeiculoLocacao(Utils.convertaStringParaInt(campoKm.getDadosDoCampo()));
            locacao.setDataVencimentoCnh(DataUtils.convertaStringParaLocalDate(campoValidadeCnh.getDadosDoCampo()));
            locacao.setCaminhoParaArquivoCnh(campoImagem.obtenhaCaminhoParaArquivo());
            LocacaoController controller = new LocacaoController(locacao, controllerCliente);
            
            String msgConfirmacao = controller.obtenhaRelatorioPgtoLocacao();
            
            int escolha = JOptionPane.showConfirmDialog(null, msgConfirmacao, "Efetuar pagamento?", JOptionPane.YES_NO_OPTION);

            if(escolha == JOptionPane.YES_OPTION){
                Operacao operacao = locacao.getId() == 0 ? Operacao.INCLUIR : Operacao.ALTERAR;
                controller.execute(locacao, operacao);
                campoImagem.salveArquivo();
            }
        } catch (ValidacaoException erro) {
            Utils.mostreAdvertenciaValidacao(erro);
        } catch (Exception erro) {
            Utils.mostreAdvertencia(erro,"Erro ao efetuar uma locação de veículos!");
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed


    private void valideCnhUnica(CampoDeTexto campoCnh) throws ValidacaoException {
        String numeroCnh = campoCnh.getDadosDoCampo();
        for(Motorista motorista : fonteDeDadosMotoristas) {
            if(motorista.getCnh().equals(numeroCnh)) {
                String msg = "O motorista " + motorista.getNome() + " já está cadastrado com este número de CNH!";
                throw new ValidacaoException(msg);
            }
        }             
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonFotoCNH;
    private javax.swing.JButton jButtonNova;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JCheckBox jCheckBoxEMotorista;
    private javax.swing.JComboBox<Categoria> jComboBoxCategoria;
    private javax.swing.JComboBox<Cliente> jComboBoxCliente;
    private javax.swing.JComboBox<Motorista> jComboBoxMotorista;
    private javax.swing.JComboBox<String> jComboBoxSituacao;
    private javax.swing.JComboBox<Veiculo> jComboBoxVeiculo;
    private javax.swing.JFormattedTextField jFormattedTextFieldCnh;
    private javax.swing.JFormattedTextField jFormattedTextFieldDataCNH;
    private javax.swing.JFormattedTextField jFormattedTextFieldDataLocacao;
    private javax.swing.JFormattedTextField jFormattedTextFieldDataPrevistaDevolucao;
    private javax.swing.JLabel jLabelCNHMotorista;
    private javax.swing.JLabel jLabelCNHMotoristaImagem;
    private javax.swing.JLabel jLabelCategoria;
    private javax.swing.JLabel jLabelCliente;
    private javax.swing.JLabel jLabelDataCNH;
    private javax.swing.JLabel jLabelDataDevolucao;
    private javax.swing.JLabel jLabelDataLocacao;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelMotorista;
    private javax.swing.JLabel jLabelNumeroCNH;
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
