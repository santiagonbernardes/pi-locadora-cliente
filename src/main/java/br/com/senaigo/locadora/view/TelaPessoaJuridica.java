package br.com.senaigo.locadora.view;

import br.com.senaigo.locadora.view.formulario.ControleFormularioPadrao;
import br.com.senaigo.locadora.controller.ClienteTcpController;
import br.com.senaigo.locadora.excecoes.ValidacaoException;
import br.com.senaigo.locadora.interfaces.FormularioPadrao;
import br.com.senaigo.locadora.model.*;
import br.com.senaigo.locadora.persistencia.Operacao;
import br.com.senaigo.locadora.utils.DataUtils;
import br.com.senaigo.locadora.utils.Utils;
import br.com.senaigo.locadora.utils.formularioUtils.CampoComboBox;
import br.com.senaigo.locadora.utils.formularioUtils.CampoData;
import br.com.senaigo.locadora.utils.formularioUtils.CampoDeTexto;
import br.com.senaigo.locadora.utils.formularioUtils.CampoEmail;
import br.com.senaigo.locadora.utils.formularioUtils.CampoId;
import br.com.senaigo.locadora.utils.formularioUtils.ValidacaoTexto;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TelaPessoaJuridica extends javax.swing.JInternalFrame implements FormularioPadrao {

	private ClienteTcpController controller;
	private List<Cliente> fonteDeDadosPessoaJuridica;
	private List<EstadosBrasil> fonteDeDadosEstadosBrasil;
	private ControleFormularioPadrao formulario;


	public TelaPessoaJuridica() throws IOException {
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
			atualizeFonteDeDadosPessoaJuridica();
			DefaultTableModel tabela = (DefaultTableModel) jTableLista.getModel();
			tabela.setRowCount(0);
			for (Cliente cliente : fonteDeDadosPessoaJuridica) {
				Object[] campos = {
						cliente.getId(),
						cliente.getNomeFantasia(),
						cliente.getRazaoSocial(),
						cliente.getCnpj(),
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

	private void atualizeFonteDeDadosPessoaJuridica() {
		try {
			List<Cliente> apenasClientesPessoaJuridica = new ArrayList<>();
			List<Cliente> listaComTodosOsClientes = controller.liste("Cliente");
			for (Cliente cliente : listaComTodosOsClientes) {
				if (cliente.getCpf().isEmpty()) {
					apenasClientesPessoaJuridica.add(cliente);
				}
			}
			this.fonteDeDadosPessoaJuridica = apenasClientesPessoaJuridica;
		} catch (Exception erro) {
            String titulo = "Erro do preencher fonte de dados de pessoas jurídicas!";
            Utils.mostreAdvertencia(erro, titulo);
		}
	}

	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBase = new javax.swing.JPanel();
        jPanelDadosGerais = new javax.swing.JPanel();
        jLabelID = new javax.swing.JLabel();
        jTextFieldID = new javax.swing.JTextField();
        jLabelCnpj = new javax.swing.JLabel();
        jLabelNomeFantasia = new javax.swing.JLabel();
        jTextFieldNomeFantasia = new javax.swing.JTextField();
        jLabelRazaoSocial = new javax.swing.JLabel();
        jTextFieldRazaoSocial = new javax.swing.JTextField();
        jFormattedTextFieldCnpj = new javax.swing.JFormattedTextField();
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
        jFormattedTextFieldTelefone = new javax.swing.JFormattedTextField();
        jFormattedTextFieldCelular = new javax.swing.JFormattedTextField();
        jPanelBotoes = new javax.swing.JPanel();
        jButtonEditar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jButtonNovo = new javax.swing.JButton();
        jScrollPaneTabela = new javax.swing.JScrollPane();
        jTableLista = new javax.swing.JTable();

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

        jLabelCnpj.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCnpj.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabelCnpj.setForeground(new java.awt.Color(0, 0, 0));
        jLabelCnpj.setText("CNPJ:");

        jLabelNomeFantasia.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNomeFantasia.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabelNomeFantasia.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNomeFantasia.setText("Nome Fantasia");

        jTextFieldNomeFantasia.setBackground(new java.awt.Color(254, 254, 160));
        jTextFieldNomeFantasia.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextFieldNomeFantasia.setForeground(new java.awt.Color(0, 0, 0));

        jLabelRazaoSocial.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabelRazaoSocial.setText("Razão Social");

        jTextFieldRazaoSocial.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        try {
            jFormattedTextFieldCnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanelDadosGeraisLayout = new javax.swing.GroupLayout(jPanelDadosGerais);
        jPanelDadosGerais.setLayout(jPanelDadosGeraisLayout);
        jPanelDadosGeraisLayout.setHorizontalGroup(
            jPanelDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosGeraisLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanelDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDadosGeraisLayout.createSequentialGroup()
                        .addGroup(jPanelDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelID)
                            .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54)
                        .addGroup(jPanelDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelCnpj)
                            .addComponent(jFormattedTextFieldCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDadosGeraisLayout.createSequentialGroup()
                                .addComponent(jLabelRazaoSocial)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 885, Short.MAX_VALUE))
                            .addComponent(jTextFieldRazaoSocial)))
                    .addGroup(jPanelDadosGeraisLayout.createSequentialGroup()
                        .addGroup(jPanelDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNomeFantasia)
                            .addComponent(jTextFieldNomeFantasia, javax.swing.GroupLayout.PREFERRED_SIZE, 1035, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(43, 43, 43))
        );
        jPanelDadosGeraisLayout.setVerticalGroup(
            jPanelDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosGeraisLayout.createSequentialGroup()
                .addGroup(jPanelDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDadosGeraisLayout.createSequentialGroup()
                        .addGroup(jPanelDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelID)
                            .addComponent(jLabelCnpj))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadosGeraisLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabelRazaoSocial)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldRazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jFormattedTextFieldCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextFieldID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelNomeFantasia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextFieldNomeFantasia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addContainerGap(86, Short.MAX_VALUE)
                .addGroup(jPanelDadosDeEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanelDadosDeEnderecoLayout.createSequentialGroup()
                        .addGroup(jPanelDadosDeEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelCEP)
                            .addComponent(jFormattedTextFieldCep, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addGroup(jPanelDadosDeEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNumero)
                    .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(88, Short.MAX_VALUE))
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
            jFormattedTextFieldTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jFormattedTextFieldCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
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
                    .addComponent(jFormattedTextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72)
                .addGroup(jPanelContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTelefoneCel)
                    .addComponent(jFormattedTextFieldCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(jFormattedTextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 180, Short.MAX_VALUE)
                .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 180, Short.MAX_VALUE)
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
            new Object [][] {

            },
            new String [] {
                "Id", "Nome Fantasia", "Razão Social", "CNPJ", "Cidade", "Estado", "Telefone", "Telefone Celular", "E-mail"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
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
            jTableLista.getColumnModel().getColumn(0).setPreferredWidth(70);
            jTableLista.getColumnModel().getColumn(2).setPreferredWidth(400);
            jTableLista.getColumnModel().getColumn(3).setPreferredWidth(150);
            jTableLista.getColumnModel().getColumn(4).setPreferredWidth(150);
            jTableLista.getColumnModel().getColumn(5).setPreferredWidth(200);
            jTableLista.getColumnModel().getColumn(6).setPreferredWidth(70);
        }

        javax.swing.GroupLayout jPanelBaseLayout = new javax.swing.GroupLayout(jPanelBase);
        jPanelBase.setLayout(jPanelBaseLayout);
        jPanelBaseLayout.setHorizontalGroup(
            jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBaseLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneTabela)
                    .addComponent(jPanelDadosGerais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelDadosDeEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelContato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

	private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        try{
            boolean podeModificarComponentes = formulario.confirmeApagarFormulario();

            if (podeModificarComponentes) {
                int indexDoObjeto = jTableLista.getSelectedRow();
                formulario.configureFormularioParaEntradaDeDados();
                Cliente cliente = fonteDeDadosPessoaJuridica.get(indexDoObjeto);
                jTextFieldID.setText(String.valueOf(cliente.getId()));
                jFormattedTextFieldCnpj.setText(cliente.getCnpj());
                jFormattedTextFieldCnpj.setValue(cliente.getCnpj());
                jTextFieldRazaoSocial.setText(cliente.getRazaoSocial());
                jTextFieldNomeFantasia.setText(cliente.getNomeFantasia());
                jFormattedTextFieldCep.setText(cliente.getEndereco().getCep());
                jFormattedTextFieldCep.setValue(cliente.getEndereco().getCep());
                jTextFieldLogradouro.setText(cliente.getEndereco().getLogradouro());
                jTextFieldNumero.setText(cliente.getEndereco().getNumero());
                jTextFieldComplemento.setText(cliente.getEndereco().getComplemento());
                jTextFieldBairro.setText(cliente.getEndereco().getBairro());
                jTextFieldCidade.setText(cliente.getEndereco().getCidade());
                jComboBoxUF.setSelectedItem(cliente.getEndereco().getEstado());
                jFormattedTextFieldTelefone.setText(cliente.getTelefonePrincipal().toString());
                jFormattedTextFieldTelefone.setValue(cliente.getTelefonePrincipal().toString());
                jFormattedTextFieldCelular.setText(cliente.getTelefoneAlternativo().toString());
                jFormattedTextFieldCelular.setValue(cliente.getTelefoneAlternativo().toString());
                jTextFieldEmail.setText(cliente.getEmail());
            }
        } catch (Exception erro) {
            Utils.mostreAdvertenciaTelaEdicao(erro);
        }
	}//GEN-LAST:event_jButtonEditarActionPerformed

	private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
		boolean podeModificarComponentes = formulario.confirmeApagarFormulario();
		if (podeModificarComponentes) {
			formulario.configureFormularioParaNavegacao();
		}
	}//GEN-LAST:event_jButtonCancelarActionPerformed

	private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
		try {
			CampoId campoId = new CampoId(jLabelID, jTextFieldID);
			CampoDeTexto campoCnpj = new CampoDeTexto(jLabelCnpj, jFormattedTextFieldCnpj, true);
			CampoDeTexto campoRazaoSocial = new CampoDeTexto(jLabelRazaoSocial, jTextFieldRazaoSocial, true, ValidacaoTexto.RAZAO_SOCIAL);
			CampoDeTexto campoNomeFantasia = new CampoDeTexto(jLabelNomeFantasia, jTextFieldNomeFantasia, false, ValidacaoTexto.RAZAO_SOCIAL);
			CampoDeTexto campoCep = new CampoDeTexto(jLabelCEP, jFormattedTextFieldCep, true);
			CampoDeTexto campoLogradouro = new CampoDeTexto(jLabelLogradouro, jTextFieldLogradouro, true, ValidacaoTexto.LOGRADOURO);
			CampoDeTexto campoNumero = new CampoDeTexto(jLabelNumero, jTextFieldNumero, false, ValidacaoTexto.NUMERO_ENDERECO);
			CampoDeTexto campoComplemento = new CampoDeTexto(jLabelComplemento, jTextFieldComplemento, false, ValidacaoTexto.COMPLEMENTO_ENDERECO);
			CampoDeTexto campoBairro = new CampoDeTexto(jLabelBairro, jTextFieldBairro, true, ValidacaoTexto.BAIRRO_ENDERECO);
			CampoDeTexto campoCidade = new CampoDeTexto(jLabelCidade, jTextFieldCidade, true, ValidacaoTexto.CIDADE);
			CampoComboBox<EstadosBrasil> campoEstadoBrasil = new CampoComboBox<>(jLabelUF, jComboBoxUF);
			CampoDeTexto campoTelefone = new CampoDeTexto(jLabelTelefone, jFormattedTextFieldTelefone, false);
			CampoDeTexto campoTelefoneCel = new CampoDeTexto(jLabelTelefoneCel, jFormattedTextFieldCelular, false);
			CampoEmail campoEmail = new CampoEmail(jLabelEmail, jTextFieldEmail, false);

			valideUmTelefoneObrigatorio(campoTelefone, campoTelefoneCel);
			valideCnpjUnico(campoCnpj, campoId);

			Cliente cliente = new Cliente();
			cliente.setId(campoId.getDadosDoCampo());
			cliente.setCnpj(campoCnpj.getDadosDoCampo());
			cliente.setRazaoSocial(campoRazaoSocial.getDadosDoCampo());
			cliente.setNomeFantasia(campoNomeFantasia.getDadosDoCampo());
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
			Utils.mostreAdvertencia(erro, "Erro ao salvar Pessoa Jurídica!");
		}
	}//GEN-LAST:event_jButtonSalvarActionPerformed

	private void valideUmTelefoneObrigatorio(CampoDeTexto campoTelefone, CampoDeTexto campoTelefoneCel) throws ValidacaoException {
		if (campoTelefone.getDadosDoCampo().isEmpty() && campoTelefoneCel.getDadosDoCampo().isEmpty()) {
			throw new ValidacaoException("Informe ao menos um número de telefone!");
		}
	}

	private void valideCnpjUnico(CampoDeTexto campoCnpj, CampoId campoId) throws ValidacaoException {
		String cnpjInformado = campoCnpj.getDadosDoCampo();
		int id = campoId.getDadosDoCampo();
		for (Cliente cliente : fonteDeDadosPessoaJuridica) {
			boolean nomesIguais = cliente.getCnpj().equals(cnpjInformado);
			boolean idsDiferentes = cliente.getId() != id;
			if (nomesIguais && idsDiferentes) {
				throw new ValidacaoException("O CNPJ é único. Já existe um CNPJ " + campoCnpj.getDadosDoCampo() + " cadastrado. " +
						"Informe um CNPJ não cadastrado.");
			}
		}

	}

	private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
		formulario.configureFormularioParaEntradaDeDados();
	}//GEN-LAST:event_jButtonNovoActionPerformed

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
		camposDoFormularioSemCampoId.add(this.jTextFieldRazaoSocial);
		camposDoFormularioSemCampoId.add(this.jTextFieldNomeFantasia);
		camposDoFormularioSemCampoId.add(this.jFormattedTextFieldCnpj);
		camposDoFormularioSemCampoId.add(this.jFormattedTextFieldCep);
		camposDoFormularioSemCampoId.add(this.jTextFieldLogradouro);
		camposDoFormularioSemCampoId.add(this.jTextFieldNumero);
		camposDoFormularioSemCampoId.add(this.jTextFieldComplemento);
		camposDoFormularioSemCampoId.add(this.jTextFieldCidade);
		camposDoFormularioSemCampoId.add(this.jTextFieldBairro);
		camposDoFormularioSemCampoId.add(this.jFormattedTextFieldTelefone);
		camposDoFormularioSemCampoId.add(this.jFormattedTextFieldCelular);
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
    private javax.swing.JFormattedTextField jFormattedTextFieldCelular;
    private javax.swing.JFormattedTextField jFormattedTextFieldCep;
    private javax.swing.JFormattedTextField jFormattedTextFieldCnpj;
    private javax.swing.JFormattedTextField jFormattedTextFieldTelefone;
    private javax.swing.JLabel jLabelBairro;
    private javax.swing.JLabel jLabelCEP;
    private javax.swing.JLabel jLabelCidade;
    private javax.swing.JLabel jLabelCnpj;
    private javax.swing.JLabel jLabelComplemento;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelLogradouro;
    private javax.swing.JLabel jLabelNomeFantasia;
    private javax.swing.JLabel jLabelNumero;
    private javax.swing.JLabel jLabelRazaoSocial;
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
    private javax.swing.JTextField jTextFieldNomeFantasia;
    private javax.swing.JTextField jTextFieldNumero;
    private javax.swing.JTextField jTextFieldRazaoSocial;
    // End of variables declaration//GEN-END:variables
}
