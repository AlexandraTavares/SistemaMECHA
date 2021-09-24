package classe_de_conexao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Label;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import java.awt.Font;
import javax.swing.UIManager;

public class Tela_cadastro extends JFrame {

	private JPanel contentPane;
	private JTextField tfUsuario;
	private JTextField tfSenha;
	private JTextField tfNUsuario;
	private JTextField tfNSenha;
	private JTextField tfCSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_cadastro frame = new Tela_cadastro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela_cadastro() {
		setTitle("Cadastro");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 705, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Label label = new Label("Usu\u00E1rio ADM");
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		label.setBounds(31, 35, 147, 33);
		contentPane.add(label);

		Label label_1 = new Label("Senha ADM");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_1.setBounds(31, 100, 147, 33);
		contentPane.add(label_1);

		Label label_2 = new Label("Novo usu\u00E1rio");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_2.setBounds(31, 164, 147, 33);
		contentPane.add(label_2);

		Label label_3 = new Label("Senha do novo usu\u00E1rio");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_3.setBounds(31, 228, 238, 33);
		contentPane.add(label_3);

		tfUsuario = new JTextField();
		tfUsuario.setBounds(275, 38, 386, 33);
		contentPane.add(tfUsuario);
		tfUsuario.setColumns(10);

		tfSenha = new JTextField();
		tfSenha.setBounds(275, 100, 386, 33);
		contentPane.add(tfSenha);
		tfSenha.setColumns(10);

		tfNUsuario = new JTextField();
		tfNUsuario.setBounds(275, 164, 386, 33);
		contentPane.add(tfNUsuario);
		tfNUsuario.setColumns(10);

		Label label_4 = new Label("Confirmar senha");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_4.setBounds(31, 291, 171, 33);
		contentPane.add(label_4);

		tfNSenha = new JTextField();
		tfNSenha.setBounds(275, 291, 386, 33);
		contentPane.add(tfNSenha);

		tfCSenha = new JTextField();
		tfCSenha.setBounds(275, 228, 386, 33);
		contentPane.add(tfCSenha);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Salvar Cadastro",
				TitledBorder.CENTER, TitledBorder.TOP, null, Color.WHITE));
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(31, 342, 310, 64);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnSalvar = new JButton("SALVAR");
		btnSalvar.setBounds(105, 25, 108, 28);
		panel.add(btnSalvar);
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSalvar.setBackground(Color.GRAY);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (tfNUsuario.getText().equals("") || tfNSenha.getText().equals(""))

				{

					JOptionPane.showMessageDialog(null, "Usuário/Senha em branco");

				} else {

					try {
						Connection con = Conexao.faz_conexao();

						String sql = "insert into dado_senhas(usuario, senha) value (?, ?)";
						PreparedStatement stmt = con.prepareStatement(sql);
						stmt.setString(1, tfNUsuario.getText());
						stmt.setString(2, tfNSenha.getText());

						stmt.execute();
						stmt.close();
						con.close();
						JOptionPane.showMessageDialog(null, "Cadastro realizado!");

						tfCSenha.setText("");
						tfUsuario.setText("");
						tfSenha.setText("");
						tfNUsuario.setText("");
						tfNSenha.setText("");

					} catch (SQLException e) {
						e.printStackTrace();
					}

				}

			}
		});

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Voltar para o Menu",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(339, 342, 321, 64);
		contentPane.add(panel_1);

		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setBounds(110, 24, 108, 29);
		panel_1.add(btnVoltar);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					Tela_menu frame = new Tela_menu();
					frame.setVisible(true);
					dispose();

				} catch (Exception e1) {
					e1.printStackTrace();

				}

			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVoltar.setBackground(Color.GRAY);
	}
}