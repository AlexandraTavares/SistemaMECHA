package classe_de_conexao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class tela_historico extends JFrame {

	private JPanel contentPane;
	private JTable dbDados;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tela_historico frame = new tela_historico();
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
	public tela_historico() {
		setTitle("Hist\u00F3rico");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 704, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(24, 343, 326, 70);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Emitir Hist\u00F3rico",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBackground(Color.LIGHT_GRAY);

		JButton button_1 = new JButton("LISTAR");
		button_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_1.setBackground(Color.LIGHT_GRAY);
		button_1.setBounds(390, 24, 95, 23);
		panel_1.add(button_1);

		JButton btnListar = new JButton("EMITIR");
		btnListar.setBounds(108, 21, 104, 29);
		panel_1.add(btnListar);
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Connection con = Conexao.faz_conexao();
					String sql = "select *from clientepedido";
					PreparedStatement stmt = con.prepareStatement(sql);
					ResultSet rs = stmt.executeQuery();
					DefaultTableModel modelo = (DefaultTableModel) dbDados.getModel();
					modelo.setNumRows(0);
					while (rs.next()) {
						modelo.addRow(new Object[] { rs.getString("id"), rs.getString("nome"), rs.getString("equip"),
								rs.getString("defeito"), rs.getString("endereco"), rs.getString("valor"),
								rs.getString("data"), rs.getString("tecnico"), rs.getString("status"),
								rs.getString("cpf2") });

					}
					rs.close();
					con.close();

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		btnListar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnListar.setBackground(Color.GRAY);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 33, 649, 289);
		contentPane.add(scrollPane);

		dbDados = new JTable();
		dbDados.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null }, },
				new String[] { "OS", "NOME", "EQUIPAMENTO", "DEFEITO", "ENDERE\u00C7O", "VALOR", "DATA", "TECNICO",
						"STATUS", "CPF" }) {
			boolean[] columnEditables = new boolean[] { false, true, true, true, true, true, true, true, true, true };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(dbDados);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Voltar para o Menu",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(347, 343, 326, 70);
		contentPane.add(panel);

		JButton button = new JButton("LISTAR");
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		button.setBackground(Color.LIGHT_GRAY);
		button.setBounds(390, 24, 95, 23);
		panel.add(button);

		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setBounds(108, 21, 104, 29);
		panel.add(btnVoltar);
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
