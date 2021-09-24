package classe_de_conexao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;

public class Tela_status extends JFrame {

	private JPanel contentPane;
	private JTextField tf5;
	private JTextField tf4;
	private JTextField tf3;
	private JTextField tf2;
	private JTextField tf1;
	private JTextField tf7;
	private JTextField tf6;
	private final JPanel panel = new JPanel();
	private JTextField tfbusca;
	private JTextField tf10;
	private JTextField tf8;
	private JTextField tf9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_status frame = new Tela_status();
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
	public Tela_status() {
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
		label.setFont(new Font("Dialog", Font.BOLD, 15));
		contentPane.add(label);

		tf1 = new JTextField();
		tf1.setBounds(76, 18, 39, 20);
		tf1.setEditable(false);
		tf1.setColumns(10);
		contentPane.add(tf1);

		Label label_1 = new Label("DATA");
		label_1.setBounds(133, 15, 46, 23);
		label_1.setFont(new Font("Dialog", Font.BOLD, 15));
		contentPane.add(label_1);

		tf7 = new JTextField();
		tf7.setBounds(181, 18, 169, 20);
		tf7.setEditable(false);
		tf7.setColumns(10);
		contentPane.add(tf7);

		Label label_3 = new Label("VALOR");
		label_3.setBounds(535, 15, 56, 23);
		label_3.setFont(new Font("Dialog", Font.BOLD, 15));
		contentPane.add(label_3);

		tf6 = new JTextField();
		tf6.setEditable(false);
		tf6.setBounds(597, 18, 76, 20);
		tf6.setColumns(10);
		contentPane.add(tf6);

		Label tf22 = new Label("NOME");
		tf22.setBounds(24, 55, 48, 23);
		tf22.setFont(new Font("Dialog", Font.BOLD, 15));
		contentPane.add(tf22);

		tf2 = new JTextField();
		tf2.setEditable(false);
		tf2.setBounds(154, 58, 519, 20);
		contentPane.add(tf2);
		tf2.setColumns(10);

		Label tf44 = new Label("ENDERE\u00C7O");
		tf44.setBounds(24, 96, 91, 23);
		tf44.setFont(new Font("Dialog", Font.BOLD, 15));
		contentPane.add(tf44);

		tf5 = new JTextField();
		tf5.setEditable(false);
		tf5.setBounds(154, 99, 519, 20);
		contentPane.add(tf5);
		tf5.setColumns(10);

		Label tf33 = new Label("EQUIPAMENTO");
		tf33.setBounds(24, 132, 124, 23);
		tf33.setFont(new Font("Dialog", Font.BOLD, 15));
		contentPane.add(tf33);

		tf3 = new JTextField();
		tf3.setEditable(false);
		tf3.setBounds(154, 135, 519, 20);
		contentPane.add(tf3);
		tf3.setColumns(10);

		Label label_2 = new Label("DEFEITO");
		label_2.setBounds(24, 172, 76, 23);
		label_2.setFont(new Font("Dialog", Font.BOLD, 15));
		contentPane.add(label_2);

		Label tf11 = new Label("T\u00C9CNICO");
		tf11.setBounds(24, 285, 76, 23);
		tf11.setFont(new Font("Dialog", Font.BOLD, 15));
		contentPane.add(tf11);
		panel.setForeground(Color.BLACK);
		panel.setBounds(24, 337, 326, 76);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Colocar CPF", TitledBorder.CENTER,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel);
		panel.setLayout(null);

		tfbusca = new JTextField();
		tfbusca.setColumns(10);
		tfbusca.setBounds(139, 27, 177, 28);
		panel.add(tfbusca);

		JButton btnAbrirOs = new JButton("ABRIR");
		btnAbrirOs.setBounds(20, 26, 109, 28);
		panel.add(btnAbrirOs);
		btnAbrirOs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					Connection con = Conexao.faz_conexao();
					String sql = "select *from clientepedido where cpf2=?";
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
						tf10.setText(rs.getString("status"));
						tf9.setText(rs.getString("cpf2"));

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

		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setForeground(Color.WHITE);
		panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Voltar para o Menu",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_4.setBackground(Color.LIGHT_GRAY);
		panel_4.setBounds(347, 337, 326, 76);
		contentPane.add(panel_4);

		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setBounds(101, 26, 125, 28);
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
		label_4.setFont(new Font("Dialog", Font.BOLD, 15));
		label_4.setBounds(24, 244, 64, 23);
		contentPane.add(label_4);

		tf10 = new JTextField();
		tf10.setEditable(false);
		tf10.setColumns(10);
		tf10.setBounds(154, 247, 519, 20);
		contentPane.add(tf10);

		tf8 = new JTextField();
		tf8.setEditable(false);
		tf8.setColumns(10);
		tf8.setBounds(154, 285, 519, 20);
		contentPane.add(tf8);

		Label label_5 = new Label("CPF");
		label_5.setFont(new Font("Dialog", Font.BOLD, 15));
		label_5.setBounds(354, 15, 32, 23);
		contentPane.add(label_5);

		tf9 = new JTextField();
		tf9.setEditable(false);
		tf9.setColumns(10);
		tf9.setBounds(392, 18, 137, 20);
		contentPane.add(tf9);

		tf4 = new JTextField();
		tf4.setEditable(false);
		tf4.setColumns(10);
		tf4.setBounds(154, 175, 519, 50);
		contentPane.add(tf4);
	}
}