package classe_de_conexao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTable;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JEditorPane;
import java.awt.ScrollPane;
import java.awt.Panel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class Tela_atualizar extends JFrame {

	private JPanel contentPane;
	private JTextField tf5;
	private JTextField tf3;
	private JTextField tf2;
	private JTextField tf4;
	private JTextField tf1;
	private JTextField tf7;
	private JTextField tf6;
	private final JPanel panel = new JPanel();
	private JTextField tfbusca;
	private JTextField tf10;
	private JTable dbDados;
	private JTextField tf8;
	private JTextField tf9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_atualizar frame = new Tela_atualizar();
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
	public Tela_atualizar() {
		setTitle("Atualizar Pedido");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 704, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Label label = new Label("N\u00BA OS");
		label.setBounds(24, 15, 46, 23);
		label.setFont(new Font("Dialog", Font.BOLD, 12));
		contentPane.add(label);

		tf1 = new JTextField();
		tf1.setBounds(76, 18, 53, 20);
		tf1.setEditable(false);
		tf1.setColumns(10);
		contentPane.add(tf1);

		Label label_1 = new Label("DATA");
		label_1.setBounds(145, 15, 36, 23);
		label_1.setFont(new Font("Dialog", Font.BOLD, 12));
		contentPane.add(label_1);

		tf7 = new JTextField();
		tf7.setBounds(189, 18, 151, 20);
		tf7.setEditable(false);
		tf7.setColumns(10);
		contentPane.add(tf7);

		Label label_3 = new Label("VALOR");
		label_3.setBounds(535, 15, 46, 23);
		label_3.setFont(new Font("Dialog", Font.BOLD, 12));
		contentPane.add(label_3);

		tf6 = new JTextField();
		tf6.setBounds(587, 18, 86, 20);
		tf6.setColumns(10);
		contentPane.add(tf6);

		Label tf22 = new Label("NOME");
		tf22.setBounds(24, 44, 48, 23);
		tf22.setFont(new Font("Dialog", Font.BOLD, 12));
		contentPane.add(tf22);

		tf2 = new JTextField();
		tf2.setEditable(false);
		tf2.setBounds(154, 47, 519, 20);
		contentPane.add(tf2);
		tf2.setColumns(10);

		Label tf44 = new Label("ENDERE\u00C7O");
		tf44.setBounds(24, 73, 76, 23);
		tf44.setFont(new Font("Dialog", Font.BOLD, 12));
		contentPane.add(tf44);

		tf5 = new JTextField();
		tf5.setEditable(false);
		tf5.setBounds(154, 76, 519, 20);
		contentPane.add(tf5);
		tf5.setColumns(10);

		Label tf33 = new Label("EQUIPAMENTO");
		tf33.setBounds(24, 102, 98, 23);
		tf33.setFont(new Font("Dialog", Font.BOLD, 12));
		contentPane.add(tf33);

		tf3 = new JTextField();
		tf3.setBounds(154, 107, 519, 20);
		contentPane.add(tf3);
		tf3.setColumns(10);

		Label label_2 = new Label("DEFEITO");
		label_2.setBounds(24, 146, 61, 23);
		label_2.setFont(new Font("Dialog", Font.BOLD, 12));
		contentPane.add(label_2);

		tf4 = new JTextField();
		tf4.setBounds(154, 138, 519, 50);
		contentPane.add(tf4);

		Label tf11 = new Label("T\u00C9CNICO");
		tf11.setBounds(24, 201, 64, 23);
		tf11.setFont(new Font("Dialog", Font.BOLD, 12));
		contentPane.add(tf11);
		panel.setForeground(Color.BLACK);
		panel.setBounds(24, 355, 156, 58);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Abrir OS", TitledBorder.CENTER,
				TitledBorder.TOP, null, null));
		panel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnAbrirOs = new JButton("ABRIR");
		btnAbrirOs.setBounds(10, 24, 83, 23);
		panel.add(btnAbrirOs);
		btnAbrirOs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					Connection con = Conexao.faz_conexao();
					String sql = "select *from clientepedido where id=?";
					PreparedStatement stmt = con.prepareStatement(sql);
					stmt.setString(1, tfbusca.getText());
					ResultSet rs = stmt.executeQuery();

					while (rs.next()) {
						tf1.setText(rs.getString("id"));
						tf2.setText(rs.getString("nome"));
						tf3.setText(rs.getString("equip"));
						tf4.setText(rs.getString("defeito"));
						tf5.setText(rs.getString("endereco"));
						tf6.setText(rs.getString("valor"));
						tf7.setText(rs.getString("data"));
						tf8.setText(rs.getString("tecnico"));

					}
					rs.close();
					con.close();

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		btnAbrirOs.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAbrirOs.setBackground(Color.GRAY);

		tfbusca = new JTextField();
		tfbusca.setColumns(10);
		tfbusca.setBounds(97, 25, 49, 22);
		panel.add(tfbusca);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(179, 355, 115, 58);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Listar Pedidos",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBackground(Color.LIGHT_GRAY);

		JButton button_1 = new JButton("LISTAR");
		button_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_1.setBackground(Color.LIGHT_GRAY);
		button_1.setBounds(390, 24, 95, 23);
		panel_1.add(button_1);

		JButton btnListar = new JButton("LISTAR");
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
		btnListar.setBounds(10, 24, 95, 23);
		panel_1.add(btnListar);
		btnListar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnListar.setBackground(Color.GRAY);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(293, 355, 132, 58);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Atualizar Pedidos",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBackground(Color.LIGHT_GRAY);

		JButton button = new JButton("LISTAR");
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		button.setBackground(Color.LIGHT_GRAY);
		button.setBounds(390, 24, 95, 23);
		panel_2.add(button);

		JButton btnAtualizar = new JButton("ATUALIZAR");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Connection con = Conexao.faz_conexao();
					String sql = "update clientepedido set nome=?, equip=?, defeito=?, endereco=?, valor=?, tecnico=? , status=?, cpf2=? where id=?";

					PreparedStatement stmt = con.prepareStatement(sql);

					stmt.setString(1, tf2.getText());
					stmt.setString(2, tf3.getText());
					stmt.setString(3, tf4.getText());
					stmt.setString(4, tf5.getText());
					stmt.setString(5, tf6.getText());
					stmt.setString(6, tf8.getText());
					stmt.setString(7, tf10.getText());
					stmt.setString(8, tf9.getText());
					stmt.setString(9, tf1.getText());

					stmt.execute();
					stmt.close();
					con.close();
					JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		btnAtualizar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAtualizar.setBackground(Color.GRAY);
		btnAtualizar.setBounds(10, 24, 112, 23);
		panel_2.add(btnAtualizar);

		JPanel panel_3 = new JPanel();
		panel_3.setForeground(new Color(0, 0, 0));
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Excluir ", TitledBorder.CENTER,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBackground(Color.LIGHT_GRAY);
		panel_3.setBounds(425, 355, 124, 58);
		contentPane.add(panel_3);

		JButton button_2 = new JButton("LISTAR");
		button_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_2.setBackground(Color.LIGHT_GRAY);
		button_2.setBounds(390, 24, 95, 23);
		panel_3.add(button_2);

		JButton btnExcluir = new JButton("EXCLUIR");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (tf1.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Informe a OS!");
				} else {
					try {

						Connection con = Conexao.faz_conexao();

						String Sql = "Delete from clientepedido where id=?";

						PreparedStatement stmt = con.prepareStatement(Sql);

						stmt.setString(1, tf1.getText());

						stmt.execute();
						stmt.close();
						con.close();

						JOptionPane.showMessageDialog(null, "Excluido!");
						tf1.setText("");
						tf2.setText("");
						tf3.setText("");
						tf4.setText("");
						tf5.setText("");
						tf6.setText("");
						tf7.setText("");
						tf8.setText("");
						tf9.setText("");
						tf10.setText("");

					} catch (SQLException el) {
						// Todo Auto-generated catch block

						el.printStackTrace();
					}
				}
			}
		});

		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnExcluir.setBackground(Color.GRAY);
		btnExcluir.setBounds(10, 24, 103, 23);
		panel_3.add(btnExcluir);

		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setForeground(Color.WHITE);
		panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Voltar", TitledBorder.CENTER,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_4.setBackground(Color.LIGHT_GRAY);
		panel_4.setBounds(549, 355, 124, 58);
		contentPane.add(panel_4);

		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setBounds(10, 23, 104, 24);
		panel_4.add(btnVoltar);
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

		Label label_4 = new Label("STATUS");
		label_4.setFont(new Font("Dialog", Font.BOLD, 12));
		label_4.setBounds(378, 201, 64, 23);
		contentPane.add(label_4);

		tf10 = new JTextField();
		tf10.setColumns(10);
		tf10.setBounds(459, 204, 214, 20);
		contentPane.add(tf10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 235, 649, 109);
		contentPane.add(scrollPane);

		dbDados = new JTable();
		dbDados.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null, null, null, null },
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

		tf8 = new JTextField();
		tf8.setEditable(false);
		tf8.setColumns(10);
		tf8.setBounds(158, 204, 182, 20);
		contentPane.add(tf8);

		Label label_5 = new Label("CPF");
		label_5.setFont(new Font("Dialog", Font.BOLD, 12));
		label_5.setBounds(354, 15, 30, 23);
		contentPane.add(label_5);

		tf9 = new JTextField();
		tf9.setEditable(false);
		tf9.setColumns(10);
		tf9.setBounds(386, 18, 143, 20);
		contentPane.add(tf9);
	}
}
