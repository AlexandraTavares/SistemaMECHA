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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
import javafx.scene.control.SelectionMode;
import com.sun.glass.ui.EventLoop.State;
import com.mysql.jdbc.StringUtils.SearchMode;
import java.awt.List;
import javax.swing.JRadioButton;
import javax.swing.DropMode;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

public class Tela_pedido extends JFrame {
	private JPanel contentPane;
	private JTextField tf5;
	private JTextField tf3;
	private JTextField tf2;
	private JTextField tf10;
	private JTextField tf7;
	private JTextField tf6;
	private JTextField tf8;
	private JTextField tf0;
	private JTextField tf9;
	private JTextField txtVitria;
	private JTextField txtRenan;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_pedido frame = new Tela_pedido();
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
	public Tela_pedido() {
		setTitle("Cadastro Cliente");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 705, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Label tf11 = new Label("T\u00C9CNICO");
		tf11.setFont(new Font("Dialog", Font.BOLD, 15));
		tf11.setBounds(30, 313, 77, 22);
		contentPane.add(tf11);

		Label tf22 = new Label("NOME");
		tf22.setFont(new Font("Dialog", Font.BOLD, 15));
		tf22.setBounds(30, 70, 56, 22);
		contentPane.add(tf22);

		Label tf33 = new Label("EQUIPAMENTO");
		tf33.setFont(new Font("Dialog", Font.BOLD, 15));
		tf33.setBounds(30, 159, 132, 22);
		contentPane.add(tf33);

		Label tf44 = new Label("ENDERE\u00C7O");
		tf44.setFont(new Font("Dialog", Font.BOLD, 15));
		tf44.setBounds(30, 115, 105, 22);
		contentPane.add(tf44);

		tf5 = new JTextField();
		tf5.setBounds(172, 115, 497, 22);
		contentPane.add(tf5);
		tf5.setColumns(10);

		tf3 = new JTextField();
		tf3.setBounds(172, 159, 497, 22);
		contentPane.add(tf3);
		tf3.setColumns(10);

		tf2 = new JTextField();
		tf2.setBounds(172, 70, 497, 22);
		contentPane.add(tf2);
		tf2.setColumns(10);

		Label label = new Label("N\u00BA OS");
		label.setFont(new Font("Dialog", Font.BOLD, 15));
		label.setBounds(30, 21, 56, 22);
		contentPane.add(label);

		tf10 = new JTextField();
		tf10.setEditable(false);
		tf10.setColumns(10);
		tf10.setBounds(92, 21, 62, 22);
		contentPane.add(tf10);

		Label label_1 = new Label("DATA");
		label_1.setFont(new Font("Dialog", Font.BOLD, 15));
		label_1.setBounds(191, 21, 56, 22);
		contentPane.add(label_1);

		tf7 = new JTextField();
		tf7.setEditable(false);
		tf7.setColumns(10);
		tf7.setBounds(253, 21, 186, 22);
		contentPane.add(tf7);

		Label label_2 = new Label("DEFEITO");
		label_2.setFont(new Font("Dialog", Font.BOLD, 15));
		label_2.setBounds(30, 201, 77, 22);
		contentPane.add(label_2);

		Label label_3 = new Label("VALOR");
		label_3.setFont(new Font("Dialog", Font.BOLD, 15));
		label_3.setBounds(468, 21, 62, 22);
		contentPane.add(label_3);

		tf6 = new JTextField();
		tf6.setEditable(false);
		tf6.setColumns(10);
		tf6.setBounds(564, 21, 105, 22);
		contentPane.add(tf6);

		Label label_5 = new Label("CPF");
		label_5.setFont(new Font("Dialog", Font.BOLD, 15));
		label_5.setBounds(30, 272, 62, 22);
		contentPane.add(label_5);

		tf8 = new JTextField();
		tf8.setColumns(10);
		tf8.setBounds(172, 272, 239, 20);
		contentPane.add(tf8);

		JTextArea tf4 = new JTextArea();
		tf4.setBounds(172, 201, 497, 50);
		contentPane.add(tf4);

		tf0 = new JTextField();
		tf0.setColumns(10);
		tf0.setBounds(172, 313, 239, 20);
		contentPane.add(tf0);

		Label label_4 = new Label("T\u00C9CNICOS DISPON\u00CDVEIS:");
		label_4.setFont(new Font("Dialog", Font.BOLD, 15));
		label_4.setBounds(453, 272, 186, 22);
		contentPane.add(label_4);

		tf9 = new JTextField();
		tf9.setHorizontalAlignment(SwingConstants.CENTER);
		tf9.setText("Alexandra");
		tf9.setToolTipText("Alexandra Vit\u00F3ria Renan");
		tf9.setEditable(false);
		tf9.setColumns(10);
		tf9.setBounds(453, 313, 62, 22);
		contentPane.add(tf9);

		txtVitria = new JTextField();
		txtVitria.setToolTipText("Alexandra Vit\u00F3ria Renan");
		txtVitria.setText("Vit\u00F3ria");
		txtVitria.setHorizontalAlignment(SwingConstants.CENTER);
		txtVitria.setEditable(false);
		txtVitria.setColumns(10);
		txtVitria.setBounds(525, 313, 56, 22);
		contentPane.add(txtVitria);

		txtRenan = new JTextField();
		txtRenan.setToolTipText("Alexandra Vit\u00F3ria Renan");
		txtRenan.setText("Renan");
		txtRenan.setHorizontalAlignment(SwingConstants.CENTER);
		txtRenan.setEditable(false);
		txtRenan.setColumns(10);
		txtRenan.setBounds(591, 313, 56, 22);
		contentPane.add(txtRenan);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Novo Pedido", TitledBorder.CENTER,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(30, 357, 323, 55);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnSalvar = new JButton("NOVO PEDIDO");
		btnSalvar.setBounds(96, 15, 125, 29);
		panel.add(btnSalvar);
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSalvar.setBackground(Color.GRAY);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					Connection con = Conexao.faz_conexao();
					String sql = "insert into clientepedido( nome, equip, defeito, endereco, valor, tecnico, status, cpf2) value (?, ?, ?, ?, ?, ?, ?, ?)";
					PreparedStatement stmt = con.prepareStatement(sql);
					stmt.setString(1, tf2.getText());
					stmt.setString(2, tf3.getText());
					stmt.setString(3, tf4.getText());
					stmt.setString(4, tf5.getText());
					stmt.setString(5, tf6.getText());
					stmt.setString(6, tf9.getText());
					stmt.setString(7, tf10.getText());
					stmt.setString(8, tf8.getText());

					JOptionPane.showMessageDialog(null, "Pedido Realizado!");
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
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(342, 357, 323, 55);
		contentPane.add(panel_1);

		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setBounds(99, 15, 125, 29);
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
