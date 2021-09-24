package classe_de_conexao;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Label;
import java.awt.Font;

public class Tela_menu extends JFrame {

	JMenuBar barra = new JMenuBar();
	JMenu menu1 = new JMenu("Opçôes");
	JMenu menu2 = new JMenu("Cadastrar");
	JMenu menu3 = new JMenu("Histórico");
	JMenu menu4 = new JMenu("Sair");
	JMenuItem item1 = new JMenuItem("Encerrar sess\u00E3o");
	JMenuItem item2 = new JMenuItem("Cliente");
	JMenuItem item4 = new JMenuItem("Novo Usuário");
	JMenuItem item5 = new JMenuItem("Emitir Histórico");
	private JPanel contentPane;
	private final JMenu item33 = new JMenu("Funcion\u00E1rio");
	private final JMenuItem fitem1 = new JMenuItem("Lista de Clientes");
	private final JMenuItem fitem2 = new JMenuItem("Atualizar Servi\u00E7o");
	private JLabel label;

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
	public Tela_menu() {
		setResizable(false);
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 705, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		barra.setBounds(0, 0, 699, 47);
		contentPane.add(barra);
		menu1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		barra.add(menu1);
		menu2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		barra.add(menu2);
		menu3.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		barra.add(menu3);
		menu4.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		barra.add(menu4);
		menu4.add(item1);

		JMenu item22 = new JMenu("Cliente");
		menu1.add(item22);

		JMenuItem citem1 = new JMenuItem("Cadastrar Cliente");
		citem1.setHorizontalAlignment(SwingConstants.LEFT);
		item22.add(citem1);

		JMenuItem citem2 = new JMenuItem("Novo Pedido");
		citem2.setHorizontalAlignment(SwingConstants.LEFT);
		item22.add(citem2);

		JMenuItem citem3 = new JMenuItem("Status");
		citem3.setHorizontalAlignment(SwingConstants.LEFT);
		item22.add(citem3);

		menu1.add(item33);
		fitem1.setHorizontalAlignment(SwingConstants.LEFT);

		item33.add(fitem1);
		fitem2.setHorizontalAlignment(SwingConstants.LEFT);

		item33.add(fitem2);
		menu2.add(item4);
		menu3.add(item5);
		label = new JLabel("");
		label.setBounds(0, 104, 699, 253);
		Image img = new ImageIcon(this.getClass().getResource("/java.png")).getImage();
		label.setIcon(new ImageIcon(img));
		contentPane.add(label);

		item1.addActionListener(new ActionListener() {
			public void actionPerfomed(ActionEvent e) {
				System.exit(0);
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				System.exit(0);
			}
		});
		citem1.addActionListener(new ActionListener() {
			public void actionPerfomed(ActionEvent e) {
				try {
					Tela_cliente frame = new Tela_cliente();
					frame.setVisible(true);
					dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				try {
					Tela_cliente frame = new Tela_cliente();
					frame.setVisible(true);
					dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		citem2.addActionListener(new ActionListener() {
			public void actionPerfomed(ActionEvent e) {
				try {
					Tela_pedido frame = new Tela_pedido();
					frame.setVisible(true);
					dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				try {
					Tela_pedido frame = new Tela_pedido();
					frame.setVisible(true);
					dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		citem3.addActionListener(new ActionListener() {
			public void actionPerfomed(ActionEvent e) {
				try {
					Tela_status frame = new Tela_status();
					frame.setVisible(true);
					dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				try {
					Tela_status frame = new Tela_status();
					frame.setVisible(true);
					dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		item4.addActionListener(new ActionListener() {
			public void actionPerfomed(ActionEvent e) {
				try {
					Tela_cadastro frame = new Tela_cadastro();
					frame.setVisible(true);
					dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				try {
					Tela_cadastro frame = new Tela_cadastro();
					frame.setVisible(true);
					dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		item5.addActionListener(new ActionListener() {
			public void actionPerfomed(ActionEvent e) {
				try {
					tela_historico frame = new tela_historico();
					frame.setVisible(true);
					dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				try {
					tela_historico frame = new tela_historico();
					frame.setVisible(true);
					dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		fitem2.addActionListener(new ActionListener() {
			public void actionPerfomed(ActionEvent e) {
				try {
					Tela_atualizar frame = new Tela_atualizar();
					frame.setVisible(true);
					dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				try {
					Tela_atualizar frame = new Tela_atualizar();
					frame.setVisible(true);
					dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		fitem1.addActionListener(new ActionListener() {
			public void actionPerfomed(ActionEvent e) {
				try {
					Tela_listar frame = new Tela_listar();
					frame.setVisible(true);
					dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				try {
					Tela_listar frame = new Tela_listar();
					frame.setVisible(true);
					dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
	}
}
