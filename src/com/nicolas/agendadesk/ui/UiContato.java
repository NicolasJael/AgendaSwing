package com.nicolas.agendadesk.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.nicolas.agendadesk.domain.Contato;
import com.nicolas.agendadesk.gerenciador.GerenciadorCont;

public class UiContato {

	private JFrame frmAgendadesk;
	private JTextField txtCod;
	private JTextField txtNome;
	private JTextField txtTelefone;

	/**
	 * Create the application.
	 * 
	 * @throws IOException
	 */
	public UiContato() throws IOException {

		initialize();
		GerenciadorCont.lerArq();
		List<Contato> contatos = GerenciadorCont.getContatos();
		if (!contatos.isEmpty()) {
			Contato contato = contatos.get(0);
			preecher(contato);
		}
	}

	private void preecher(Contato contato) {

		txtCod.setText(contato.getCodigo() + "");
		txtNome.setText(contato.getNome());
		txtTelefone.setText(contato.getTelefone());
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frmAgendadesk = new JFrame();
		frmAgendadesk.setTitle("AgendaDesk");
		frmAgendadesk.setBounds(100, 100, 450, 315);
		frmAgendadesk.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel pnlMenu = new JPanel();
		frmAgendadesk.getContentPane().add(pnlMenu, BorderLayout.EAST);
		pnlMenu.setLayout(new GridLayout(10, 1, 0, 0));

		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		pnlMenu.add(btnNovo);

		JButton btnAlterar = new JButton("Alterar");
		pnlMenu.add(btnAlterar);

		JLabel lblNewLabel = new JLabel("");
		pnlMenu.add(lblNewLabel);

		JButton btnSalvar = new JButton("Salvar");
		pnlMenu.add(btnSalvar);

		JButton btnCancelar = new JButton("Cancelar");
		pnlMenu.add(btnCancelar);

		JLabel lblNewLabel_1 = new JLabel("");
		pnlMenu.add(lblNewLabel_1);

		JButton btnApagar = new JButton("Apagar");

		pnlMenu.add(btnApagar);

		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		JLabel lblNewLabel_2 = new JLabel("");
		pnlMenu.add(lblNewLabel_2);
		pnlMenu.add(btnFechar);

		JPanel pnlTitulo = new JPanel();
		frmAgendadesk.getContentPane().add(pnlTitulo, BorderLayout.NORTH);

		JLabel lblTilulo = new JLabel("Contatos");
		pnlTitulo.add(lblTilulo);

		JPanel pnlNavegador = new JPanel();
		frmAgendadesk.getContentPane().add(pnlNavegador, BorderLayout.SOUTH);

		JButton btnPrimeiro = new JButton("<<");
		pnlNavegador.add(btnPrimeiro);

		JButton bntAnterior = new JButton("<");
		pnlNavegador.add(bntAnterior);

		JButton btnProximo = new JButton(">");
		pnlNavegador.add(btnProximo);

		JButton btnUltimo = new JButton(">>");
		pnlNavegador.add(btnUltimo);

		JPanel pnlControles = new JPanel();
		frmAgendadesk.getContentPane().add(pnlControles, BorderLayout.CENTER);
		pnlControles.setLayout(null);

		JLabel lblCodigo = new JLabel("Código:");
		lblCodigo.setBounds(10, 11, 46, 14);
		pnlControles.add(lblCodigo);

		txtCod = new JTextField();
		txtCod.setBounds(6, 31, 122, 28);
		pnlControles.add(txtCod);
		txtCod.setColumns(10);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 71, 55, 16);
		pnlControles.add(lblNome);

		txtNome = new JTextField();
		txtNome.setBounds(6, 99, 122, 28);
		pnlControles.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(10, 139, 55, 16);
		pnlControles.add(lblTelefone);

		txtTelefone = new JTextField();
		txtTelefone.setBounds(6, 162, 122, 28);
		pnlControles.add(txtTelefone);
		txtTelefone.setColumns(10);
	}

	public void setVisible(boolean b) {

		frmAgendadesk.setVisible(true);
	}
}
