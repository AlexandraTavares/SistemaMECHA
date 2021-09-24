package classe_de_conexao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.TitledBorder;

public class tela_de_acesso extends JFrame {

	private JPanel contentPane;
	private JTextField tfUsuario;
	private JPasswordField pfSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tela_de_acesso frame = new tela_de_acesso();
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
	public tela_de_acesso() {
		setResizable(false);
		setTitle("Tela de Acesso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 351);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUsurio = new JLabel("Usu\u00E1rio");
		lblUsurio.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUsurio.setBounds(20, 74, 75, 56);
		contentPane.add(lblUsurio);

		JLabel pflSenha = new JLabel("Senha");
		pflSenha.setFont(new Font("Tahoma", Font.BOLD, 16));
		pflSenha.setBounds(20, 130, 75, 74);
		contentPane.add(pflSenha);

		tfUsuario = new JTextField();
		tfUsuario.setBounds(105, 86, 326, 36);
		contentPane.add(tfUsuario);
		tfUsuario.setColumns(10);

		pfSenha = new JPasswordField();
		pfSenha.setBounds(105, 151, 326, 36);
		contentPane.add(pfSenha);

		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblLogin.setBounds(182, 11, 88, 56);
		contentPane.add(lblLogin);

		JPanel panel = new JPanel();
		panel.setBorder(
				new TitledBorder(null, "Entrar para o Menu", TitledBorder.CENTER, TitledBorder.TOP, null, Color.WHITE));
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(20, 226, 411, 74);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(145, 27, 121, 36);
		panel.add(btnEntrar);
		btnEntrar.setBackground(Color.GRAY);
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					Connection con = Conexao.faz_conexao();
					String sql = "select *from dado_senhas where usuario=? and senha=?";
					PreparedStatement stmt = con.prepareStatement(sql);
					stmt.setString(1, tfUsuario.getText());
					stmt.setString(2, new String(pfSenha.getPassword()));
					ResultSet rs = stmt.executeQuery();
					if (rs.next()) {
						Tela_menu exibir = new Tela_menu();
						exibir.setVisible(true);
						setVisible(false);

					} else {
						JOptionPane.showMessageDialog(null, "Acesso negado");
					}
					stmt.close();
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEntrar.setForeground(Color.BLACK);
	}

	protected Connection faz_conexao() {
		return null;
	}
}
