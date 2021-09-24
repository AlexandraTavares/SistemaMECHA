package classe_de_conexao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Label;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

public class Tela_cliente extends JFrame {
	private JPanel contentPane;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JTextField tf4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_menu frame = new Tela_menu();
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
	public Tela_cliente() {
		setTitle("Cadastro Cliente");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 705, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Label tf11 = new Label("NOME");
		tf11.setFont(new Font("Tahoma", Font.BOLD, 25));
		tf11.setBounds(30, 38, 77, 29);
		contentPane.add(tf11);

		Label tf22 = new Label("CPF");
		tf22.setFont(new Font("Tahoma", Font.BOLD, 25));
		tf22.setBounds(30, 98, 62, 39);
		contentPane.add(tf22);

		Label tf33 = new Label("TELEFONE");
		tf33.setFont(new Font("Tahoma", Font.BOLD, 25));
		tf33.setBounds(30, 165, 147, 22);
		contentPane.add(tf33);

		Label tf44 = new Label("ENDERE\u00C7O");
		tf44.setFont(new Font("Tahoma", Font.BOLD, 25));
		tf44.setBounds(30, 225, 156, 22);
		contentPane.add(tf44);

		tf1 = new JTextField();
		tf1.setBounds(214, 38, 439, 29);
		contentPane.add(tf1);
		tf1.setColumns(10);

		tf2 = new JTextField();
		tf2.setBounds(214, 98, 439, 29);
		contentPane.add(tf2);
		tf2.setColumns(10);

		tf3 = new JTextField();
		tf3.setBounds(214, 158, 439, 29);
		contentPane.add(tf3);
		tf3.setColumns(10);

		tf4 = new JTextField();
		tf4.setBounds(214, 218, 439, 29);
		contentPane.add(tf4);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Salvar Cadastro",
				TitledBorder.CENTER, TitledBorder.TOP, null, Color.WHITE));
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(30, 296, 311, 78);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnSalvar = new JButton("CADASTRAR");
		btnSalvar.setBounds(95, 28, 124, 39);
		panel.add(btnSalvar);
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSalvar.setBackground(Color.GRAY);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					Connection con = Conexao.faz_conexao();
					String sql = "insert into cliente(nome, cpf, telefone, endereco) value (?, ?, ?, ?)";
					PreparedStatement stmt = con.prepareStatement(sql);
					stmt.setString(1, tf1.getText());
					stmt.setString(2, tf2.getText());
					stmt.setString(3, tf3.getText());
					stmt.setString(4, tf4.getText());

					JOptionPane.showMessageDialog(null, "Cadastro Realizado;");
					stmt.execute();
					stmt.close();
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Voltar para o Menu",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(340, 296, 311, 78);
		contentPane.add(panel_1);

		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setBounds(95, 28, 124, 39);
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
