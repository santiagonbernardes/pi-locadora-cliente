package br.com.senaigo.locadora.view;

import br.com.senaigo.locadora.controller.ClienteTcpController;
import br.com.senaigo.locadora.excecoes.ValidacaoException;
import br.com.senaigo.locadora.interfaces.FormularioPadrao;
import br.com.senaigo.locadora.model.*;
import br.com.senaigo.locadora.persistencia.Operacao;
import br.com.senaigo.locadora.utils.DataUtils;
import br.com.senaigo.locadora.utils.Utils;
import br.com.senaigo.locadora.utils.formularioUtils.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TelaPessoaFisica extends javax.swing.JInternalFrame implements FormularioPadrao {

	private final ClienteTcpController controller;
	private List<Cliente> fonteDeDadosPessoaFisica;
	private List<EstadosBrasil> fonteDeDadosEstadosBrasil;
	private ControleFormularioPadrao formulario;

	public TelaPessoaFisica() throws IOException {
		controller = new ClienteTcpController();
		inicializeFontesDeDadosCombo();
		initComponents();
		formulario = new ControleFormularioPadrao(this);
		preenchaGrid();
		formulario.configureFormularioParaNavegacao();
	}

	public void inicializeFontesDeDadosCombo() {
		fonteDeDadosEstadosBrasil = Arrays.asList(EstadosBrasil.values());
	}

	private void preenchaGrid() {
		try {
			atualizeFonteDeDadosPessoaFisica();
			DefaultTableModel tabela = (DefaultTableModel) jTableLista.getModel();
			tabela.setRowCount(0);
			for (Cliente cliente : fonteDeDadosPessoaFisica) {
				Object[] campos = {
						cliente.getId(),
						cliente.getNome(),
						cliente.getCpf(),
						DataUtils.convertaLocalDateParaStringFormatada(cliente.getDataNascimento()),
						cliente.getEndereco().getCidade(),
						cliente.getEndereco().getEstado().getNome(),
						cliente.getTelefonePrincipal(),
						cliente.getTelefoneAlternativo(),
						cliente.getEmail()
				};
				tabela.addRow(campos);
			}
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "Erro ao " + Operacao.LISTAR + " Modelo: " + erro.getMessage());
		}
	}

	private void atualizeFonteDeDadosPessoaFisica() {
		try {
			List<Cliente> apenasClientesPessoaFisica = new ArrayList<>();
			List<Cliente> listaComTodosOsClientes = controller.liste("Cliente");
			for (Cliente cliente : listaComTodosOsClientes) {
				if (cliente.getCnpj().isEmpty()) {
					apenasClientesPessoaFisica.add(cliente);
				}
			}
			this.fonteDeDadosPessoaFisica = apenasClientesPessoaFisica;
		} catch (Exception erro) {
			Utils.mostreAdvertenciaPreenchimentoGrid(erro);
		}
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jPanelBase = new javax.swing.JPanel();
		jPanelDadosGerais = new javax.swing.JPanel();
		jLabelID = new javax.swing.JLabel();
		jTextFieldID = new javax.swing.JTextField();
		jLabelCPF = new javax.swing.JLabel();
		jLabelNome = new javax.swing.JLabel();
		jTextFieldNome = new javax.swing.JTextField();
		jLabelAniversario = new javax.swing.JLabel();
		jFormattedTextFieldCpf = new javax.swing.JFormattedTextField();
		jFormattedTextFieldDataNascimento = new javax.swing.JFormattedTextField();
		jPanelDadosDeEndereco = new javax.swing.JPanel();
		jLabelCEP = new javax.swing.JLabel();
		jLabelLogradouro = new javax.swing.JLabel();
		jTextFieldLogradouro = new javax.swing.JTextField();
		jLabelNumero = new javax.swing.JLabel();
		jTextFieldNumero = new javax.swing.JTextField();
		jLabelComplemento = new javax.swing.JLabel();
		jTextFieldComplemento = new javax.swing.JTextField();
		jLabelBairro = new javax.swing.JLabel();
		jTextFieldBairro = new javax.swing.JTextField();
		jLabelCidade = new javax.swing.JLabel();
		jLabelUF = new javax.swing.JLabel();
		jTextFieldCidade = new javax.swing.JTextField();
		jComboBoxUF = new javax.swing.JComboBox<>();
		jFormattedTextFieldCep = new javax.swing.JFormattedTextField();
		jPanelContato = new javax.swing.JPanel();
		jLabelTelefone = new javax.swing.JLabel();
		jLabelTelefoneCel = new javax.swing.JLabel();
		jLabelEmail = new javax.swing.JLabel();
		jTextFieldEmail = new javax.swing.JTextField();
		jFormattedTextFieldTelefonePrincipal = new javax.swing.JFormattedTextField();
		jFormattedTextFieldTelefoneCelular = new javax.swing.JFormattedTextField();
		jPanelBotoes = new javax.swing.JPanel();
		jButtonEditar = new javax.swing.JButton();
		jButtonCancelar = new javax.swing.JButton();
		jButtonSalvar = new javax.swing.JButton();
		jButtonNovo = new javax.swing.JButton();
		jScrollPaneTabela = new javax.swing.JScrollPane();
		jTableLista = new javax.swing.JTable();

		setBackground(new java.awt.Color(255, 244, 0));
		setBorder(null);

		jPanelBase.setBackground(new java.awt.Color(255, 255, 255));

		jPanelDadosGerais.setBackground(new java.awt.Color(255, 255, 255));
		jPanelDadosGerais.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Dados Gerais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 18), new java.awt.Color(0, 0, 0))); // NOI18N
		jPanelDadosGerais.setForeground(new java.awt.Color(0, 0, 0));

		jLabelID.setBackground(new java.awt.Color(255, 255, 255));
		jLabelID.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
		jLabelID.setForeground(new java.awt.Color(0, 0, 0));
		jLabelID.setText("ID");

		jTextFieldID.setEditable(false);
		jTextFieldID.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

		jLabelCPF.setBackground(new java.awt.Color(255, 255, 255));
		jLabelCPF.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
		jLabelCPF.setForeground(new java.awt.Color(0, 0, 0));
		jLabelCPF.setText("CPF");

		jLabelNome.setBackground(new java.awt.Color(255, 255, 255));
		jLabelNome.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
		jLabelNome.setForeground(new java.awt.Color(0, 0, 0));
		jLabelNome.setText("Nome");

		jTextFieldNome.setBackground(new java.awt.Color(254, 254, 160));
		jTextFieldNome.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
		jTextFieldNome.setForeground(new java.awt.Color(0, 0, 0));

		jLabelAniversario.setBackground(new java.awt.Color(255, 255, 255));
		jLabelAniversario.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
		jLabelAniversario.setForeground(new java.awt.Color(0, 0, 0));
		jLabelAniversario.setText("Data de Nascimento");

		try {
			jFormattedTextFieldCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
		} catch (java.text.ParseException ex) {
			ex.printStackTrace();
		}

		try {
			jFormattedTextFieldDataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
		} catch (java.text.ParseException ex) {
			ex.printStackTrace();
		}

		javax.swing.GroupLayout jPanelDadosGeraisLayout = new javax.swing.GroupLayout(jPanelDadosGerais);
		jPanelDadosGerais.setLayout(jPanelDadosGeraisLayout);
		jPanelDadosGeraisLayout.setHorizontalGroup(
				jPanelDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanelDadosGeraisLayout.createSequentialGroup()
								.addGap(30, 30, 30)
								.addGroup(jPanelDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(jPanelDadosGeraisLayout.createSequentialGroup()
												.addGroup(jPanelDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabelID)
														.addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGap(54, 54, 54)
												.addGroup(jPanelDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabelCPF)
														.addComponent(jFormattedTextFieldCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
												.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGroup(jPanelDadosGeraisLayout.createSequentialGroup()
												.addGroup(jPanelDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabelNome)
														.addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 1035, javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGap(18, 21, Short.MAX_VALUE)
												.addGroup(jPanelDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
														.addComponent(jLabelAniversario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(jFormattedTextFieldDataNascimento))
												.addGap(32, 32, 32))))
		);
		jPanelDadosGeraisLayout.setVerticalGroup(
				jPanelDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanelDadosGeraisLayout.createSequentialGroup()
								.addGroup(jPanelDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabelID)
										.addComponent(jLabelCPF))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(jPanelDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jFormattedTextFieldCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(jPanelDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jLabelAniversario)
										.addComponent(jLabelNome))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(jPanelDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jFormattedTextFieldDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
		);

		jPanelDadosDeEndereco.setBackground(new java.awt.Color(255, 255, 255));
		jPanelDadosDeEndereco.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Dados de Endereço", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 18), new java.awt.Color(0, 0, 0))); // NOI18N
		jPanelDadosDeEndereco.setForeground(new java.awt.Color(0, 0, 0));

		jLabelCEP.setBackground(new java.awt.Color(255, 255, 255));
		jLabelCEP.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
		jLabelCEP.setForeground(new java.awt.Color(0, 0, 0));
		jLabelCEP.setText("CEP");

		jLabelLogradouro.setBackground(new java.awt.Color(255, 255, 255));
		jLabelLogradouro.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
		jLabelLogradouro.setForeground(new java.awt.Color(0, 0, 0));
		jLabelLogradouro.setText("Logradouro");

		jTextFieldLogradouro.setBackground(new java.awt.Color(254, 254, 160));
		jTextFieldLogradouro.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
		jTextFieldLogradouro.setForeground(new java.awt.Color(0, 0, 0));

		jLabelNumero.setBackground(new java.awt.Color(255, 255, 255));
		jLabelNumero.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
		jLabelNumero.setForeground(new java.awt.Color(0, 0, 0));
		jLabelNumero.setText("Nº");

		jTextFieldNumero.setBackground(new java.awt.Color(255, 255, 255));
		jTextFieldNumero.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
		jTextFieldNumero.setForeground(new java.awt.Color(0, 0, 0));

		jLabelComplemento.setBackground(new java.awt.Color(255, 255, 255));
		jLabelComplemento.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
		jLabelComplemento.setForeground(new java.awt.Color(0, 0, 0));
		jLabelComplemento.setText("Complemento");

		jTextFieldComplemento.setBackground(new java.awt.Color(255, 255, 255));
		jTextFieldComplemento.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
		jTextFieldComplemento.setForeground(new java.awt.Color(0, 0, 0));

		jLabelBairro.setBackground(new java.awt.Color(255, 255, 255));
		jLabelBairro.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
		jLabelBairro.setForeground(new java.awt.Color(0, 0, 0));
		jLabelBairro.setText("Bairro");

		jTextFieldBairro.setBackground(new java.awt.Color(254, 254, 160));
		jTextFieldBairro.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
		jTextFieldBairro.setForeground(new java.awt.Color(0, 0, 0));

		jLabelCidade.setBackground(new java.awt.Color(255, 255, 255));
		jLabelCidade.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
		jLabelCidade.setForeground(new java.awt.Color(0, 0, 0));
		jLabelCidade.setText("Cidade");

		jLabelUF.setBackground(new java.awt.Color(255, 255, 255));
		jLabelUF.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
		jLabelUF.setForeground(new java.awt.Color(0, 0, 0));
		jLabelUF.setText("UF");

		jTextFieldCidade.setBackground(new java.awt.Color(255, 255, 255));
		jTextFieldCidade.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
		jTextFieldCidade.setForeground(new java.awt.Color(0, 0, 0));

		jComboBoxUF.setBackground(new java.awt.Color(255, 255, 255));
		jComboBoxUF.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
		jComboBoxUF.setForeground(new java.awt.Color(0, 0, 0));
		jComboBoxUF.setModel(new DefaultComboBoxModel(fonteDeDadosEstadosBrasil.toArray()));

		try {
			jFormattedTextFieldCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
		} catch (java.text.ParseException ex) {
			ex.printStackTrace();
		}

		javax.swing.GroupLayout jPanelDadosDeEnderecoLayout = new javax.swing.GroupLayout(jPanelDadosDeEndereco);
		jPanelDadosDeEndereco.setLayout(jPanelDadosDeEnderecoLayout);
		jPanelDadosDeEnderecoLayout.setHorizontalGroup(
				jPanelDadosDeEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanelDadosDeEnderecoLayout.createSequentialGroup()
								.addContainerGap(83, Short.MAX_VALUE)
								.addGroup(jPanelDadosDeEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
										.addGroup(jPanelDadosDeEnderecoLayout.createSequentialGroup()
												.addGroup(jPanelDadosDeEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabelCEP)
														.addComponent(jFormattedTextFieldCep, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addGroup(jPanelDadosDeEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabelLogradouro)
														.addComponent(jTextFieldLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 832, javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addGroup(jPanelDadosDeEnderecoLayout.createSequentialGroup()
												.addGroup(jPanelDadosDeEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
														.addComponent(jLabelCidade)
														.addComponent(jLabelComplemento)
														.addComponent(jTextFieldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jTextFieldComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addGroup(jPanelDadosDeEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabelBairro)
														.addComponent(jLabelUF)
														.addComponent(jComboBoxUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jTextFieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE))))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
								.addGroup(jPanelDadosDeEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jLabelNumero)
										.addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addContainerGap(84, Short.MAX_VALUE))
		);
		jPanelDadosDeEnderecoLayout.setVerticalGroup(
				jPanelDadosDeEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanelDadosDeEnderecoLayout.createSequentialGroup()
								.addGroup(jPanelDadosDeEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabelCEP)
										.addComponent(jLabelLogradouro)
										.addComponent(jLabelNumero))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(jPanelDadosDeEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jTextFieldLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jFormattedTextFieldCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(jPanelDadosDeEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabelComplemento)
										.addComponent(jLabelBairro))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(jPanelDadosDeEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jTextFieldComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jTextFieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(jPanelDadosDeEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabelCidade)
										.addComponent(jLabelUF))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(jPanelDadosDeEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jTextFieldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jComboBoxUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(24, 24, 24))
		);

		jPanelContato.setBackground(new java.awt.Color(255, 255, 255));
		jPanelContato.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Dados de Contato", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 18), new java.awt.Color(0, 0, 0))); // NOI18N
		jPanelContato.setForeground(new java.awt.Color(0, 0, 0));

		jLabelTelefone.setBackground(new java.awt.Color(255, 255, 255));
		jLabelTelefone.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
		jLabelTelefone.setForeground(new java.awt.Color(0, 0, 0));
		jLabelTelefone.setText("Telefone");

		jLabelTelefoneCel.setBackground(new java.awt.Color(255, 255, 255));
		jLabelTelefoneCel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
		jLabelTelefoneCel.setForeground(new java.awt.Color(0, 0, 0));
		jLabelTelefoneCel.setText("Telefone Cel");

		jLabelEmail.setBackground(new java.awt.Color(255, 255, 255));
		jLabelEmail.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
		jLabelEmail.setForeground(new java.awt.Color(0, 0, 0));
		jLabelEmail.setText("E-mail");

		jTextFieldEmail.setBackground(new java.awt.Color(255, 255, 255));
		jTextFieldEmail.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
		jTextFieldEmail.setForeground(new java.awt.Color(0, 0, 0));

		try {
			jFormattedTextFieldTelefonePrincipal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
		} catch (java.text.ParseException ex) {
			ex.printStackTrace();
		}

		try {
			jFormattedTextFieldTelefoneCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
		} catch (java.text.ParseException ex) {
			ex.printStackTrace();
		}

		javax.swing.GroupLayout jPanelContatoLayout = new javax.swing.GroupLayout(jPanelContato);
		jPanelContato.setLayout(jPanelContatoLayout);
		jPanelContatoLayout.setHorizontalGroup(
				jPanelContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanelContatoLayout.createSequentialGroup()
								.addContainerGap()
								.addGroup(jPanelContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jLabelTelefone)
										.addComponent(jFormattedTextFieldTelefonePrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(123, 123, 123)
								.addGroup(jPanelContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jLabelTelefoneCel)
										.addComponent(jFormattedTextFieldTelefoneCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(jPanelContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jLabelEmail)
										.addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(53, 53, 53))
		);
		jPanelContatoLayout.setVerticalGroup(
				jPanelContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanelContatoLayout.createSequentialGroup()
								.addGroup(jPanelContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabelTelefone)
										.addComponent(jLabelTelefoneCel)
										.addComponent(jLabelEmail))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(jPanelContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jFormattedTextFieldTelefonePrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jFormattedTextFieldTelefoneCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
		);

		jPanelBotoes.setBackground(new java.awt.Color(255, 255, 255));
		jPanelBotoes.setForeground(new java.awt.Color(0, 0, 0));

		jButtonEditar.setBackground(new java.awt.Color(255, 255, 255));
		jButtonEditar.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
		jButtonEditar.setForeground(new java.awt.Color(0, 0, 0));
		jButtonEditar.setText("Editar");
		jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonEditarActionPerformed(evt);
			}
		});

		jButtonCancelar.setBackground(new java.awt.Color(255, 255, 255));
		jButtonCancelar.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
		jButtonCancelar.setForeground(new java.awt.Color(0, 0, 0));
		jButtonCancelar.setText("Cancelar");
		jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonCancelarActionPerformed(evt);
			}
		});

		jButtonSalvar.setBackground(new java.awt.Color(255, 255, 255));
		jButtonSalvar.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
		jButtonSalvar.setForeground(new java.awt.Color(0, 0, 0));
		jButtonSalvar.setText("Salvar");
		jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonSalvarActionPerformed(evt);
			}
		});

		jButtonNovo.setBackground(new java.awt.Color(255, 255, 255));
		jButtonNovo.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
		jButtonNovo.setForeground(new java.awt.Color(0, 0, 0));
		jButtonNovo.setText("Novo");
		jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonNovoActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanelBotoesLayout = new javax.swing.GroupLayout(jPanelBotoes);
		jPanelBotoes.setLayout(jPanelBotoesLayout);
		jPanelBotoesLayout.setHorizontalGroup(
				jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBotoesLayout.createSequentialGroup()
								.addComponent(jButtonNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 412, Short.MAX_VALUE)
								.addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 412, Short.MAX_VALUE)
								.addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
		);
		jPanelBotoesLayout.setVerticalGroup(
				jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanelBotoesLayout.createSequentialGroup()
								.addGap(0, 0, Short.MAX_VALUE)
								.addGroup(jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jButtonEditar)
										.addComponent(jButtonCancelar)
										.addComponent(jButtonSalvar)
										.addComponent(jButtonNovo)))
		);

		jTableLista.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][]{

				},
				new String[]{
						"Id", "Nome", "CPF", "Data de Nascimento", "Cidade", "Estado", "Telefone", "Telefone Celular", "E-mail"
				}
		) {
			boolean[] canEdit = new boolean[]{
					false, false, false, false, false, false, false, false, true
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

		javax.swing.GroupLayout jPanelBaseLayout = new javax.swing.GroupLayout(jPanelBase);
		jPanelBase.setLayout(jPanelBaseLayout);
		jPanelBaseLayout.setHorizontalGroup(
				jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanelBaseLayout.createSequentialGroup()
								.addContainerGap()
								.addGroup(jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jPanelDadosGerais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jPanelDadosDeEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jPanelContato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jPanelBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jScrollPaneTabela, javax.swing.GroupLayout.Alignment.TRAILING))
								.addContainerGap())
		);
		jPanelBaseLayout.setVerticalGroup(
				jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanelBaseLayout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jPanelDadosGerais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jPanelDadosDeEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jPanelContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(jPanelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addComponent(jScrollPaneTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
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

	private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
		try {
			CampoId campoId = new CampoId(jLabelID, jTextFieldID);
			CampoDeTexto campoNome = new CampoDeTexto(jLabelNome, jTextFieldNome, true, ValidacaoTexto.NOME_COMPLETO_PADRAO);
			CampoData campoData = new CampoData(jLabelAniversario, jFormattedTextFieldDataNascimento, true);
			CampoDeTexto campoCpf = new CampoDeTexto(jLabelCPF, jFormattedTextFieldCpf, true);
			CampoDeTexto campoCep = new CampoDeTexto(jLabelCEP, jFormattedTextFieldCep, true);
			CampoDeTexto campoLogradouro = new CampoDeTexto(jLabelLogradouro, jTextFieldLogradouro, true, ValidacaoTexto.LOGRADOURO);
			CampoDeTexto campoNumero = new CampoDeTexto(jLabelNumero, jTextFieldNumero, false, ValidacaoTexto.NUMERO_ENDERECO);
			CampoDeTexto campoComplemento = new CampoDeTexto(jLabelComplemento, jTextFieldComplemento, false, ValidacaoTexto.COMPLEMENTO_ENDERECO);
			CampoDeTexto campoBairro = new CampoDeTexto(jLabelBairro, jTextFieldBairro, true, ValidacaoTexto.BAIRRO_ENDERECO);
			CampoDeTexto campoCidade = new CampoDeTexto(jLabelCidade, jTextFieldCidade, true, ValidacaoTexto.CIDADE);
			CampoComboBox<EstadosBrasil> campoEstadoBrasil = new CampoComboBox<>(jLabelUF, jComboBoxUF);
			CampoDeTexto campoTelefone = new CampoDeTexto(jLabelTelefone, jFormattedTextFieldTelefonePrincipal, false);
			CampoDeTexto campoTelefoneCel = new CampoDeTexto(jLabelTelefoneCel, jFormattedTextFieldTelefoneCelular, false);
			CampoEmail campoEmail = new CampoEmail(jLabelEmail, jTextFieldEmail, false);

			valideUmTelefoneObrigatorio(campoTelefone, campoTelefoneCel);
			valideCpfUnico(campoCpf, campoId);

			Cliente cliente = new Cliente();
			cliente.setId(campoId.getDadosDoCampo());
			cliente.setNome(campoNome.getDadosDoCampo());
			cliente.setCpf(campoCpf.getDadosDoCampo());
			LocalDate data = DataUtils.convertaStringParaLocalDate(campoData.getDadosDoCampo());
			cliente.setDataNascimento(data);
			Endereco endereco = new Endereco();
			endereco.setLogradouro(campoLogradouro.getDadosDoCampo());
			endereco.setBairro(campoBairro.getDadosDoCampo());
			endereco.setComplemento(campoComplemento.getDadosDoCampo());
			endereco.setNumero(campoNumero.getDadosDoCampo());
			endereco.setCep(campoCep.getDadosDoCampo());
			endereco.setCidade(campoCidade.getDadosDoCampo());
			endereco.setEstado((EstadosBrasil) campoEstadoBrasil.getDadosDoCampo());
			cliente.setEndereco(endereco);
			Telefone telefonePrincipal = Telefone.obtenhaInstancia(campoTelefone.getDadosDoCampo());
			Telefone telefoneCelular = Telefone.obtenhaInstancia(campoTelefoneCel.getDadosDoCampo());
			cliente.setTelefonePrincipal(telefonePrincipal);
			cliente.setTelefoneAlternativo(telefoneCelular);
			cliente.setEmail(campoEmail.getDadosDoCampo());

			Operacao operacao = cliente.getId() == 0 ? Operacao.INCLUIR : Operacao.ALTERAR;

			controller.execute(cliente, operacao);

			preenchaGrid();
			formulario.configureFormularioParaNavegacao();

		} catch (ValidacaoException erroDeValidacao) {
			Utils.mostreAdvertenciaValidacao(erroDeValidacao);
		} catch (Exception erro) {
			Utils.mostreAdvertencia(erro, "Erro ao salvar Pessoa Física!");
		}
	}//GEN-LAST:event_jButtonSalvarActionPerformed

	private void valideUmTelefoneObrigatorio(CampoDeTexto campoTelefone, CampoDeTexto campoTelefoneCel) throws ValidacaoException {
		if (campoTelefone.getDadosDoCampo().isEmpty() && campoTelefoneCel.getDadosDoCampo().isEmpty()) {
			throw new ValidacaoException("Informe ao menos um número de telefone!");
		}
	}

	private void valideCpfUnico(CampoDeTexto campoCpf, CampoId campoId) throws ValidacaoException {
		String cpfInformado = campoCpf.getDadosDoCampo();
		int id = campoId.getDadosDoCampo();
		for (Cliente cliente : fonteDeDadosPessoaFisica) {
			boolean nomesIguais = cliente.getCpf().equals(cpfInformado);
			boolean idsDiferentes = cliente.getId() != id;
			if (nomesIguais && idsDiferentes) {
				throw new ValidacaoException("O CPF é único. Já existe um CPF " + campoCpf.getDadosDoCampo() + " cadastrado. " +
						"Informe um CPF não cadastrado.");
			}
		}

	}

	private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
		boolean podeModificarComponentes = formulario.confirmeApagarFormulario();
		if (podeModificarComponentes) {
			formulario.configureFormularioParaNavegacao();
		}
	}//GEN-LAST:event_jButtonCancelarActionPerformed

	private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
		boolean podeModificarComponentes = formulario.confirmeApagarFormulario();

		if (podeModificarComponentes) {
			int indexDoObjeto = jTableLista.getSelectedRow();
			formulario.configureFormularioParaEntradaDeDados();
			Cliente cliente = fonteDeDadosPessoaFisica.get(indexDoObjeto);
			jTextFieldID.setText(String.valueOf(cliente.getId()));
			jTextFieldNome.setText(cliente.getNome());
			jFormattedTextFieldCpf.setText(cliente.getCpf());
			jFormattedTextFieldCpf.setValue(cliente.getCpf());
			jFormattedTextFieldDataNascimento.setText(DataUtils.convertaLocalDateParaStringFormatada(cliente.getDataNascimento()));
			jFormattedTextFieldDataNascimento.setValue(DataUtils.convertaLocalDateParaStringFormatada(cliente.getDataNascimento()));
			jFormattedTextFieldCep.setText(cliente.getEndereco().getCep());
			jFormattedTextFieldCep.setValue(cliente.getEndereco().getCep());
			jTextFieldLogradouro.setText(cliente.getEndereco().getLogradouro());
			jTextFieldNumero.setText(cliente.getEndereco().getNumero());
			jTextFieldComplemento.setText(cliente.getEndereco().getComplemento());
			jTextFieldBairro.setText(cliente.getEndereco().getBairro());
			jTextFieldCidade.setText(cliente.getEndereco().getCidade());
			jComboBoxUF.setSelectedItem(cliente.getEndereco().getEstado());
			jFormattedTextFieldTelefonePrincipal.setText(cliente.getTelefonePrincipal().toString());
			jFormattedTextFieldTelefonePrincipal.setValue(cliente.getTelefonePrincipal().toString());
			jFormattedTextFieldTelefoneCelular.setText(cliente.getTelefoneAlternativo().toString());
			jFormattedTextFieldTelefoneCelular.setValue(cliente.getTelefoneAlternativo().toString());
			jTextFieldEmail.setText(cliente.getEmail());
		}
	}//GEN-LAST:event_jButtonEditarActionPerformed

	private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
		formulario.configureFormularioParaEntradaDeDados();
	}//GEN-LAST:event_jButtonNovoActionPerformed

	private void jTableListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableListaMouseClicked
		formulario.configureConformeInteracaoComGrid();
	}//GEN-LAST:event_jTableListaMouseClicked

	@Override
	public JButton obtenhaBotaoSalvar() {
		return jButtonSalvar;
	}

	@Override
	public JButton obtenhaBotaoEditar() {
		return jButtonEditar;
	}

	@Override
	public JButton obtenhaBotaoCancelar() {
		return jButtonCancelar;
	}

	@Override
	public JButton obtenhaBotaoNovo() {
		return jButtonNovo;
	}

	@Override
	public JTable obtenhaGrid() {
		return jTableLista;
	}

	@Override
	public JTextField obtenhaCampoId() {
		return jTextFieldID;
	}

	@Override
	public List<JTextField> obtenhaCamposDoFormularioSemCampoId() {
		List<JTextField> camposDoFormularioSemCampoId = new ArrayList<>();
		camposDoFormularioSemCampoId.add(this.jTextFieldNome);
		camposDoFormularioSemCampoId.add(this.jFormattedTextFieldCpf);
		camposDoFormularioSemCampoId.add(this.jFormattedTextFieldDataNascimento);
		camposDoFormularioSemCampoId.add(this.jFormattedTextFieldCep);
		camposDoFormularioSemCampoId.add(this.jTextFieldLogradouro);
		camposDoFormularioSemCampoId.add(this.jTextFieldNumero);
		camposDoFormularioSemCampoId.add(this.jTextFieldComplemento);
		camposDoFormularioSemCampoId.add(this.jTextFieldCidade);
		camposDoFormularioSemCampoId.add(this.jTextFieldBairro);
		camposDoFormularioSemCampoId.add(this.jFormattedTextFieldTelefonePrincipal);
		camposDoFormularioSemCampoId.add(this.jFormattedTextFieldTelefoneCelular);
		camposDoFormularioSemCampoId.add(this.jTextFieldEmail);

		return camposDoFormularioSemCampoId;
	}

	@Override
	public List<JComboBox> obtenhaComboBoxesDoFormulario() {
		List<JComboBox> comboBoxesDoFormulario = new ArrayList<>();
		comboBoxesDoFormulario.add(jComboBoxUF);

		return comboBoxesDoFormulario;
	}


	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jButtonCancelar;
	private javax.swing.JButton jButtonEditar;
	private javax.swing.JButton jButtonNovo;
	private javax.swing.JButton jButtonSalvar;
	private javax.swing.JComboBox<String> jComboBoxUF;
	private javax.swing.JFormattedTextField jFormattedTextFieldCep;
	private javax.swing.JFormattedTextField jFormattedTextFieldCpf;
	private javax.swing.JFormattedTextField jFormattedTextFieldDataNascimento;
	private javax.swing.JFormattedTextField jFormattedTextFieldTelefoneCelular;
	private javax.swing.JFormattedTextField jFormattedTextFieldTelefonePrincipal;
	private javax.swing.JLabel jLabelAniversario;
	private javax.swing.JLabel jLabelBairro;
	private javax.swing.JLabel jLabelCEP;
	private javax.swing.JLabel jLabelCPF;
	private javax.swing.JLabel jLabelCidade;
	private javax.swing.JLabel jLabelComplemento;
	private javax.swing.JLabel jLabelEmail;
	private javax.swing.JLabel jLabelID;
	private javax.swing.JLabel jLabelLogradouro;
	private javax.swing.JLabel jLabelNome;
	private javax.swing.JLabel jLabelNumero;
	private javax.swing.JLabel jLabelTelefone;
	private javax.swing.JLabel jLabelTelefoneCel;
	private javax.swing.JLabel jLabelUF;
	private javax.swing.JPanel jPanelBase;
	private javax.swing.JPanel jPanelBotoes;
	private javax.swing.JPanel jPanelContato;
	private javax.swing.JPanel jPanelDadosDeEndereco;
	private javax.swing.JPanel jPanelDadosGerais;
	private javax.swing.JScrollPane jScrollPaneTabela;
	private javax.swing.JTable jTableLista;
	private javax.swing.JTextField jTextFieldBairro;
	private javax.swing.JTextField jTextFieldCidade;
	private javax.swing.JTextField jTextFieldComplemento;
	private javax.swing.JTextField jTextFieldEmail;
	private javax.swing.JTextField jTextFieldID;
	private javax.swing.JTextField jTextFieldLogradouro;
	private javax.swing.JTextField jTextFieldNome;
	private javax.swing.JTextField jTextFieldNumero;
	// End of variables declaration//GEN-END:variables


}
