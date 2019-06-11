package br.com.senaigo.locadora.view;

import br.com.senaigo.locadora.controller.ClienteTcpController;
import br.com.senaigo.locadora.excecoes.ValidacaoException;
import br.com.senaigo.locadora.interfaces.FormularioPadrao;
import br.com.senaigo.locadora.model.*;
import br.com.senaigo.locadora.persistencia.Operacao;
import br.com.senaigo.locadora.utils.Utils;
import br.com.senaigo.locadora.utils.formularioUtils.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TelaCarro extends javax.swing.JInternalFrame implements FormularioPadrao {

	private final ClienteTcpController controller;
	private List<Veiculo> fonteDeDadosVeiculo;
	private List<Categoria> fonteDeDadosCategoria;
	private List<Modelo> fonteDeDadosModelo;
	private ControleFormularioPadrao formulario;

	public TelaCarro() throws IOException {
		controller = new ClienteTcpController();
		inicializeFontesDeDadosCombo();
		initComponents();
		formulario = new ControleFormularioPadrao(this);
		preenchaGrid();
		formulario.configureFormularioParaNavegacao();
	}

	private void inicializeFontesDeDadosCombo() {
		try {
			fonteDeDadosModelo = controller.liste("Modelo");
			fonteDeDadosCategoria = controller.liste("Categoria");
		} catch (Exception e) {
                        String titulo = "Erro ao carregar combo boxes!";
			Utils.mostreAdvertencia(e, titulo);
		}
	}

	private void preenchaGrid() {
		try {
			atualizeFonteDeDadosVeiculo();
			DefaultTableModel tabela = (DefaultTableModel) jTableLista.getModel();
			tabela.setRowCount(0);
			for (Veiculo veiculo : fonteDeDadosVeiculo) {
				Object[] campos = {
						veiculo.getId(),
						veiculo.getPlaca(),
						veiculo.getRenavam(),
						veiculo.getAnoFabricacao(),
						"R$ " + Utils.convertaFloatParaStringComDuasCasasDecimais(veiculo.getValorCompra()),
						veiculo.getKmAtual(),
						veiculo.getCategoria().getNome(),
						veiculo.getEstado().getDescricao(),
						veiculo.getModelo().getNome()
				};
				tabela.addRow(campos);
			}
		} catch (Exception erro) {
			Utils.mostreAdvertenciaPreenchimentoGrid(erro);
		}
	}


	private void atualizeFonteDeDadosVeiculo() {
		try {
			fonteDeDadosVeiculo = controller.liste("Veiculo");
		} catch (Exception erro) {
			String titulo = "Erro do preencher fonte de dados de veículos!";
			Utils.mostreAdvertencia(erro, titulo);
		}
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jPanelBase = new javax.swing.JPanel();
		jPanelCarro = new javax.swing.JPanel();
		jLabelPlaca = new javax.swing.JLabel();
		jLabelRENAVAM = new javax.swing.JLabel();
		jLabelAno = new javax.swing.JLabel();
		jLabelValorCompra = new javax.swing.JLabel();
		jTextFieldValorCompra = new javax.swing.JTextField();
		jLabelQuilometragem = new javax.swing.JLabel();
		jTextFieldQuilometragem = new javax.swing.JTextField();
		jLabelCategoria = new javax.swing.JLabel();
		jLabelEstado = new javax.swing.JLabel();
		jComboBoxCategoria = new javax.swing.JComboBox<>();
		jComboBoxEstado = new javax.swing.JComboBox<>();
		jLabelModelo = new javax.swing.JLabel();
		jComboBoxModelo = new javax.swing.JComboBox<>();
		jLabelID = new javax.swing.JLabel();
		jTextFieldID = new javax.swing.JTextField();
		jButtonSalvar = new javax.swing.JButton();
		jButtonCancelar = new javax.swing.JButton();
		jFormattedTextFieldPlaca = new javax.swing.JFormattedTextField();
		jFormattedTextFieldRenavam = new javax.swing.JFormattedTextField();
		jFormattedTextFieldAno = new javax.swing.JFormattedTextField();
		jPanelBotoes = new javax.swing.JPanel();
		jButtonNovo = new javax.swing.JButton();
		jButtonEditar = new javax.swing.JButton();
		jScrollPaneTabela = new javax.swing.JScrollPane();
		jTableLista = new javax.swing.JTable();

		setBackground(new java.awt.Color(255, 244, 0));
		setBorder(null);

		jPanelBase.setBackground(new java.awt.Color(255, 255, 255));

		jPanelCarro.setBackground(new java.awt.Color(255, 255, 255));
		jPanelCarro.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Carro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 18), new java.awt.Color(0, 0, 0))); // NOI18N

		jLabelPlaca.setBackground(new java.awt.Color(255, 255, 255));
		jLabelPlaca.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
		jLabelPlaca.setForeground(new java.awt.Color(0, 0, 0));
		jLabelPlaca.setText("Placa:");

		jLabelRENAVAM.setBackground(new java.awt.Color(255, 255, 255));
		jLabelRENAVAM.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
		jLabelRENAVAM.setForeground(new java.awt.Color(0, 0, 0));
		jLabelRENAVAM.setText("Renavam:");

		jLabelAno.setBackground(new java.awt.Color(255, 255, 255));
		jLabelAno.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
		jLabelAno.setForeground(new java.awt.Color(0, 0, 0));
		jLabelAno.setText("Ano:");

		jLabelValorCompra.setBackground(new java.awt.Color(255, 255, 255));
		jLabelValorCompra.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
		jLabelValorCompra.setForeground(new java.awt.Color(0, 0, 0));
		jLabelValorCompra.setText("Valor de Compra:");

		jTextFieldValorCompra.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
		jTextFieldValorCompra.setForeground(new java.awt.Color(0, 0, 0));

		jLabelQuilometragem.setBackground(new java.awt.Color(255, 255, 255));
		jLabelQuilometragem.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
		jLabelQuilometragem.setForeground(new java.awt.Color(0, 0, 0));
		jLabelQuilometragem.setText("Quilometragem:");

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

		jLabelModelo.setBackground(new java.awt.Color(255, 255, 255));
		jLabelModelo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
		jLabelModelo.setForeground(new java.awt.Color(0, 0, 0));
		jLabelModelo.setText("Modelo:");

		jComboBoxModelo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
		jComboBoxModelo.setForeground(new java.awt.Color(0, 0, 0));
		jComboBoxModelo.setModel(new DefaultComboBoxModel(fonteDeDadosModelo.toArray()));

		jLabelID.setBackground(new java.awt.Color(255, 255, 255));
		jLabelID.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
		jLabelID.setForeground(new java.awt.Color(0, 0, 0));
		jLabelID.setText("ID:");

		jTextFieldID.setEditable(false);
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

		try {
			jFormattedTextFieldPlaca.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("UUU-####")));
		} catch (java.text.ParseException ex) {
			ex.printStackTrace();
		}

		try {
			jFormattedTextFieldRenavam.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###########")));
		} catch (java.text.ParseException ex) {
			ex.printStackTrace();
		}

		try {
			jFormattedTextFieldAno.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
		} catch (java.text.ParseException ex) {
			ex.printStackTrace();
		}

		javax.swing.GroupLayout jPanelCarroLayout = new javax.swing.GroupLayout(jPanelCarro);
		jPanelCarro.setLayout(jPanelCarroLayout);
		jPanelCarroLayout.setHorizontalGroup(
				jPanelCarroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanelCarroLayout.createSequentialGroup()
								.addContainerGap(46, Short.MAX_VALUE)
								.addGroup(jPanelCarroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(jPanelCarroLayout.createSequentialGroup()
												.addGroup(jPanelCarroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabelCategoria)
														.addComponent(jComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
												.addGroup(jPanelCarroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabelEstado)
														.addComponent(jComboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addGroup(jPanelCarroLayout.createSequentialGroup()
												.addGroup(jPanelCarroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabelID)
														.addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGroup(jPanelCarroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(jPanelCarroLayout.createSequentialGroup()
																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(jLabelPlaca)
																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 164, Short.MAX_VALUE))
														.addGroup(jPanelCarroLayout.createSequentialGroup()
																.addGap(18, 18, 18)
																.addComponent(jFormattedTextFieldPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
												.addGroup(jPanelCarroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabelRENAVAM)
														.addComponent(jFormattedTextFieldRenavam, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGap(95, 95, 95)))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
								.addGroup(jPanelCarroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(jPanelCarroLayout.createSequentialGroup()
												.addGroup(jPanelCarroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabelAno)
														.addComponent(jFormattedTextFieldAno, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addGroup(jPanelCarroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabelValorCompra)
														.addComponent(jTextFieldValorCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addGroup(jPanelCarroLayout.createSequentialGroup()
												.addGap(0, 117, Short.MAX_VALUE)
												.addGroup(jPanelCarroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
														.addComponent(jLabelModelo)
														.addComponent(jComboBoxModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
								.addGroup(jPanelCarroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
										.addComponent(jTextFieldQuilometragem, javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jLabelQuilometragem, javax.swing.GroupLayout.Alignment.LEADING))
								.addContainerGap(51, Short.MAX_VALUE))
						.addGroup(jPanelCarroLayout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
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
														.addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jFormattedTextFieldPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jFormattedTextFieldRenavam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addComponent(jLabelID)
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCarroLayout.createSequentialGroup()
												.addComponent(jLabelPlaca)
												.addGap(38, 38, 38))
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCarroLayout.createSequentialGroup()
												.addComponent(jLabelRENAVAM)
												.addGap(34, 34, 34))
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCarroLayout.createSequentialGroup()
												.addComponent(jLabelValorCompra)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addGroup(jPanelCarroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jTextFieldValorCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jFormattedTextFieldAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCarroLayout.createSequentialGroup()
												.addComponent(jLabelAno)
												.addGap(34, 34, 34)))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
								.addGroup(jPanelCarroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabelModelo)
										.addComponent(jLabelEstado)
										.addComponent(jLabelCategoria))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(jPanelCarroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jComboBoxModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

		javax.swing.GroupLayout jPanelBotoesLayout = new javax.swing.GroupLayout(jPanelBotoes);
		jPanelBotoes.setLayout(jPanelBotoesLayout);
		jPanelBotoesLayout.setHorizontalGroup(
				jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanelBotoesLayout.createSequentialGroup()
								.addComponent(jButtonNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1062, Short.MAX_VALUE)
								.addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
		);
		jPanelBotoesLayout.setVerticalGroup(
				jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanelBotoesLayout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jButtonNovo)
										.addComponent(jButtonEditar))
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);

		jTableLista.setForeground(new java.awt.Color(0, 0, 0));
		jTableLista.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][]{

				},
				new String[]{
						"ID", "Placa", "Renavam", "Ano", "Valor de Compra", "Quilometragem", "Categoria", "Estado", "Modelo"
				}
		) {
			boolean[] canEdit = new boolean[]{
					false, false, false, false, false, false, false, false, false
			};

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jTableLista.setGridColor(new java.awt.Color(255, 255, 255));
		jTableLista.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		jTableLista.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jTableListaMouseClicked(evt);
			}
		});
		jScrollPaneTabela.setViewportView(jTableLista);
		if (jTableLista.getColumnModel().getColumnCount() > 0) {
			jTableLista.getColumnModel().getColumn(0).setResizable(false);
			jTableLista.getColumnModel().getColumn(0).setPreferredWidth(50);
			jTableLista.getColumnModel().getColumn(1).setPreferredWidth(200);
			jTableLista.getColumnModel().getColumn(2).setResizable(false);
			jTableLista.getColumnModel().getColumn(6).setPreferredWidth(400);
			jTableLista.getColumnModel().getColumn(7).setPreferredWidth(400);
		}

		javax.swing.GroupLayout jPanelBaseLayout = new javax.swing.GroupLayout(jPanelBase);
		jPanelBase.setLayout(jPanelBaseLayout);
		jPanelBaseLayout.setHorizontalGroup(
				jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanelBaseLayout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jPanelBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jScrollPaneTabela)
										.addComponent(jPanelCarro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		jPanelBaseLayout.setVerticalGroup(
				jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanelBaseLayout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jPanelCarro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jPanelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jScrollPaneTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
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
		formulario.configureFormularioParaEntradaDeDados();
	}//GEN-LAST:event_jButtonNovoActionPerformed

	private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
		try {
			CampoId campoId = new CampoId(jLabelID, jTextFieldID);
			CampoDeTexto campoPlaca = new CampoDeTexto(jLabelPlaca, jFormattedTextFieldPlaca, true);
			CampoDeTexto campoRenavam = new CampoDeTexto(jLabelRENAVAM, jFormattedTextFieldRenavam, true);
			CampoDeTexto campoAno = new CampoDeTexto(jLabelAno, jFormattedTextFieldAno, true);
			CampoDinheiro campoValor = new CampoDinheiro(jLabelValorCompra, jTextFieldValorCompra, true, ValidacaoFloat.SETE_DIGITOS);
			CampoDeTexto campoKm = new CampoDeTexto(jLabelQuilometragem, jTextFieldQuilometragem, true, ValidacaoTexto.CARRO_KM);
			CampoComboBox<Categoria> campoCategoria = new CampoComboBox<>(jLabelCategoria, jComboBoxCategoria);
			CampoComboBox<Estado> campoEstado = new CampoComboBox<>(jLabelEstado, jComboBoxEstado);
			CampoComboBox<Modelo> campoModelo = new CampoComboBox<>(jLabelModelo, jComboBoxModelo);

			valideRenavamUnico(campoRenavam.getDadosDoCampo(), campoId.getDadosDoCampo());

			Veiculo veiculo = new Veiculo();
			veiculo.setId(campoId.getDadosDoCampo());
			veiculo.setPlaca(campoPlaca.getDadosDoCampo());
			veiculo.setRenavam(Utils.convertaStringParaLong(campoRenavam.getDadosDoCampo()));
			veiculo.setAnoFabricacao(Utils.convertaStringParaInt(campoAno.getDadosDoCampo()));
			veiculo.setValorCompra(Utils.convertaStringParaFloat(campoValor.getDadosDoCampo()));
			veiculo.setKmAtual(Utils.convertaStringParaInt(campoKm.getDadosDoCampo()));
			veiculo.setCategoria((Categoria) campoCategoria.getDadosDoCampo());
			veiculo.setEstado((Estado) campoEstado.getDadosDoCampo());
			veiculo.setModelo((Modelo) campoModelo.getDadosDoCampo());

			Operacao operacao = veiculo.getId() == 0 ? Operacao.INCLUIR : Operacao.ALTERAR;

			controller.execute(veiculo, operacao);

			preenchaGrid();
			formulario.configureFormularioParaNavegacao();
		} catch (ValidacaoException erro) {
			Utils.mostreAdvertenciaValidacao(erro);
		} catch (Exception erro) {
			Utils.mostreAdvertencia(erro, "Erro ao salvar veículo!");
		}
	}//GEN-LAST:event_jButtonSalvarActionPerformed

	private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
		boolean podeModificarComponentes = formulario.confirmeApagarFormulario();
		if (podeModificarComponentes) {
			formulario.configureFormularioParaNavegacao();
		}

	}//GEN-LAST:event_jButtonCancelarActionPerformed

	private void valideRenavamUnico(String renavamEmTexto, int id) throws ValidacaoException {
		long renavam = Utils.convertaStringParaLong(renavamEmTexto);
		for (Veiculo veiculo : fonteDeDadosVeiculo) {
			boolean renavamIgual = veiculo.getRenavam() == renavam;
			boolean idsDiferentes = veiculo.getId() != id;
			if (renavamIgual && idsDiferentes) {
				String mensagem = "O renavam do veículo é único. " +
						"O renavam " + renavamEmTexto + " já está cadastrado. " +
						"Informe um renavam não cadastrado.";
				throw new ValidacaoException(mensagem);
			}
		}
	}

	private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
		try {
			boolean podeModificarComponentes = formulario.confirmeApagarFormulario();

			if (podeModificarComponentes) {
				int indexDoVeiculo = jTableLista.getSelectedRow();
				formulario.configureFormularioParaEntradaDeDados();
				Veiculo veiculo = fonteDeDadosVeiculo.get(indexDoVeiculo);
				jTextFieldID.setText(String.valueOf(veiculo.getId()));
				jFormattedTextFieldPlaca.setText(veiculo.getPlaca());
				jFormattedTextFieldPlaca.setValue(veiculo.getPlaca());
				jFormattedTextFieldRenavam.setText(String.valueOf(veiculo.getRenavam()));
				jFormattedTextFieldRenavam.setValue(String.valueOf(veiculo.getRenavam()));
				jFormattedTextFieldAno.setText(String.valueOf(veiculo.getAnoFabricacao()));
				jFormattedTextFieldAno.setValue(String.valueOf(veiculo.getAnoFabricacao()));
				String valorCompra = Utils.convertaFloatParaStringComDuasCasasDecimais(veiculo.getValorCompra());
				jTextFieldValorCompra.setText(valorCompra);
				jTextFieldQuilometragem.setText(String.valueOf(veiculo.getKmAtual()));
				jComboBoxCategoria.setSelectedItem(veiculo.getCategoria());
				jComboBoxEstado.setSelectedItem(veiculo.getEstado());
				jComboBoxModelo.setSelectedItem(veiculo.getModelo());
			}
		} catch (Exception erro) {
			Utils.mostreAdvertenciaTelaEdicao(erro);
		}
	}//GEN-LAST:event_jButtonEditarActionPerformed

	private void jTableListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableListaMouseClicked
		formulario.configureConformeInteracaoComGrid();
	}//GEN-LAST:event_jTableListaMouseClicked


	@Override
	public JButton obtenhaBotaoSalvar() {
		return this.jButtonSalvar;
	}

	@Override
	public JButton obtenhaBotaoEditar() {
		return this.jButtonEditar;
	}

	@Override
	public JButton obtenhaBotaoCancelar() {
		return this.jButtonCancelar;
	}

	@Override
	public JButton obtenhaBotaoNovo() {
		return this.jButtonNovo;
	}

	@Override
	public JTable obtenhaGrid() {
		return this.jTableLista;
	}

	@Override
	public JTextField obtenhaCampoId() {
		return this.jTextFieldID;
	}

	@Override
	public List<JTextField> obtenhaCamposDoFormularioSemCampoId() {
		List<JTextField> camposDoFormularioSemCampoId = new ArrayList<>();
		camposDoFormularioSemCampoId.add(this.jFormattedTextFieldAno);
		camposDoFormularioSemCampoId.add(this.jFormattedTextFieldPlaca);
		camposDoFormularioSemCampoId.add(this.jTextFieldQuilometragem);
		camposDoFormularioSemCampoId.add(this.jFormattedTextFieldRenavam);
		camposDoFormularioSemCampoId.add(this.jTextFieldValorCompra);
		return camposDoFormularioSemCampoId;
	}

	@Override
	public List<JComboBox> obtenhaComboBoxesDoFormulario() {
		List<JComboBox> comboBoxesDoFormulario = new ArrayList<>();
		comboBoxesDoFormulario.add(this.jComboBoxCategoria);
		comboBoxesDoFormulario.add(this.jComboBoxEstado);
		comboBoxesDoFormulario.add(this.jComboBoxModelo);
		return comboBoxesDoFormulario;
	}


	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jButtonCancelar;
	private javax.swing.JButton jButtonEditar;
	private javax.swing.JButton jButtonNovo;
	private javax.swing.JButton jButtonSalvar;
	private javax.swing.JComboBox<String> jComboBoxCategoria;
	private javax.swing.JComboBox<String> jComboBoxEstado;
	private javax.swing.JComboBox<String> jComboBoxModelo;
	private javax.swing.JFormattedTextField jFormattedTextFieldAno;
	private javax.swing.JFormattedTextField jFormattedTextFieldPlaca;
	private javax.swing.JFormattedTextField jFormattedTextFieldRenavam;
	private javax.swing.JLabel jLabelAno;
	private javax.swing.JLabel jLabelCategoria;
	private javax.swing.JLabel jLabelEstado;
	private javax.swing.JLabel jLabelID;
	private javax.swing.JLabel jLabelModelo;
	private javax.swing.JLabel jLabelPlaca;
	private javax.swing.JLabel jLabelQuilometragem;
	private javax.swing.JLabel jLabelRENAVAM;
	private javax.swing.JLabel jLabelValorCompra;
	private javax.swing.JPanel jPanelBase;
	private javax.swing.JPanel jPanelBotoes;
	private javax.swing.JPanel jPanelCarro;
	private javax.swing.JScrollPane jScrollPaneTabela;
	private javax.swing.JTable jTableLista;
	private javax.swing.JTextField jTextFieldID;
	private javax.swing.JTextField jTextFieldQuilometragem;
	private javax.swing.JTextField jTextFieldValorCompra;
	// End of variables declaration//GEN-END:variables
}
