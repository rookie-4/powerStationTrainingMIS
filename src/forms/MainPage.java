package forms;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
//import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JLabel;

import javax.swing.ImageIcon;
import javax.swing.JDialog;

import forms.depart.DepartForm;
import forms.employee.AddEmployee;
import forms.employee.EmployeeMainForm;
import forms.employee.SelectDepForm;
import forms.scores.AddScores;
import forms.scores.ScoresMainForm;
import forms.training.AddTrainingForm;
import forms.training.TrainingMainForm;
import forms.user.AddUserForm;
import forms.user.UpdateUserForm;
//import services.depart.Depart;
import util.CommUtil;

//import javax.swing.border.LineBorder;
//import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
//import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
public class MainPage extends JFrame {

	private JPanel contentPane;
//	private JTable table;
//	private Vector<Vector<Object>> tableDatas;
//	private Vector<String> colums;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage("root");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
//	private static void setFrameLoaction(JFrame frame) {
//		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
//
//		int width = screen.width;
//		int height = screen.height;
//		
//		int left = (width - frame.getSize().width) / 2;
//		int top = (height - frame.getSize().height) / 2;
//		frame.setLocation(left, top);
//
//	}
	/**
	 * Create the frame.
	 */
	public MainPage(final String user_name) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 838, 512);
		CommUtil.setFrameLoaction(this);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		//ϵͳ����
		JMenu menu = new JMenu("\u7CFB\u7EDF\u7BA1\u7406");
		menuBar.add(menu);
		
		//ע�����û�
		JMenuItem menuItem = new JMenuItem("\u65B0\u589E\u7528\u6237");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//�������û�����
				
//				EventQueue.invokeLater(new Runnable() {
//					public void run() {
//						try {
//							MainUserForm frame = new MainUserForm();
//							setFrameLoaction(frame);
//							frame.main(null);
//						} catch (Exception e) {
//							e.printStackTrace();
//						}
//					}
//				});	
				AddUserForm emf = new AddUserForm();
				contentPane.removeAll();
				contentPane.add(emf);
				emf.setVisible(true);
				try {
					emf.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				};
			
		});
		menu.add(menuItem);
		
		
		//�޸��û�����
		JMenuItem menuItem_9 = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		menuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateUserForm emf = new UpdateUserForm(user_name);
				contentPane.removeAll();
				contentPane.add(emf);
				emf.setVisible(true);
				try {
					emf.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		menu.add(menuItem_9);
		
		//�˳�ϵͳ
		JMenuItem exitNewMenuItem = new JMenuItem("\u9000\u51FA\u7CFB\u7EDF");
		menu.add(exitNewMenuItem);
		exitNewMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int i=JOptionPane.showConfirmDialog(null,"�Ƿ�Ҫ�˳���ϵͳ","�˳�ѡ��",
						JOptionPane.YES_NO_CANCEL_OPTION);
				if(i==0) {
					dispose();
					System.exit(0);
				}
			}	
		});

		//��ѵ�ƻ�
		JMenu menu_1 = new JMenu("\u57F9\u8BAD\u8BA1\u5212\u7BA1\u7406");
		menuBar.add(menu_1);		
		
		//��ѵ�ƻ�������
		JMenuItem mntmNewMenuItem = new JMenuItem("\u65B0\u589E");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddTrainingForm addTrin = new AddTrainingForm();
				addTrin.setVisible(true);
			}
		});
		menu_1.add(mntmNewMenuItem);
		
		//��ѵ�ƻ�����ѯ
		JMenuItem menuItem_1 = new JMenuItem("\u67E5\u8BE2");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrainingMainForm emf = new TrainingMainForm();
				contentPane.removeAll();
				contentPane.add(emf);
				emf.setVisible(true);
				try {
					emf.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		menu_1.add(menuItem_1);
		
		//��ѵ�ƻ����޸�
		JMenuItem menuItem_2 = new JMenuItem("\u4FEE\u6539");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrainingMainForm emf = new TrainingMainForm();
				contentPane.removeAll();
				contentPane.add(emf);
				emf.setVisible(true);
				try {
					emf.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		menu_1.add(menuItem_2);
		
		JMenu menu_2 = new JMenu("\u57F9\u8BAD\u6210\u7EE9\u7BA1\u7406");
		menuBar.add(menu_2);
		
		JMenuItem menuItem_3 = new JMenuItem("\u65B0\u589E");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//��������
				AddScores addscores = new AddScores();
				addscores.setVisible(true);
			}
		});
		menu_2.add(menuItem_3);
		
		JMenuItem menuItem_5 = new JMenuItem("\u67E5\u8BE2");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//������ѯ
				ScoresMainForm emf = new ScoresMainForm();
				contentPane.removeAll();
				contentPane.add(emf);
				emf.setVisible(true);
				try {
					emf.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		menu_2.add(menuItem_5);
		
		JMenuItem menuItem_4 = new JMenuItem("\u4FEE\u6539");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//�ɼ��޸�
				ScoresMainForm emf = new ScoresMainForm();
				contentPane.removeAll();
				contentPane.add(emf);
				emf.setVisible(true);
				try {
					emf.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		menu_2.add(menuItem_4);
		
		JMenu menu_3 = new JMenu("\u5B66\u5458\u7BA1\u7406");
		menuBar.add(menu_3);
		
		JMenuItem menuItem_6 = new JMenuItem("\u65B0\u589E\u57F9\u8BAD\u5B66\u5458");
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//����ѧԱ
				AddEmployee addEmp = new AddEmployee();
				CommUtil.setDialogLoaction(addEmp);
				addEmp.setVisible(true);
				
			}
		});
		menu_3.add(menuItem_6);
		
		JMenuItem menuItem_7 = new JMenuItem("\u5B66\u5458\u4FE1\u606F\u67E5\u8BE2");
		menuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ѧԱ����
				EmployeeMainForm emf = new EmployeeMainForm();
				contentPane.removeAll();
				contentPane.add(emf);
				emf.setVisible(true);
				try {
					emf.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		menu_3.add(menuItem_7);
		
		JMenuItem menuItem_8 = new JMenuItem("\u5B66\u5458\u4FE1\u606F\u4FEE\u6539");
		menuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeeMainForm emf = new EmployeeMainForm();
				contentPane.removeAll();
				contentPane.add(emf);
				emf.setVisible(true);
				try {
					emf.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		menu_3.add(menuItem_8);
		
		JMenu menu_4 = new JMenu("\u90E8\u95E8\u7BA1\u7406");
		menuBar.add(menu_4);
		
		JMenuItem menuItem_10 = new JMenuItem("\u90E8\u95E8\u67E5\u8BE2");
		menuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//��ѯ����
				SelectDepForm addEmp = new SelectDepForm();
				addEmp.setVisible(true);
			}
		});
		menu_4.add(menuItem_10);
		
		JMenuItem menuItem_11 = new JMenuItem("\u90E8\u95E8\u4FEE\u6539");
		menuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//����������
				DepartForm emf = new DepartForm();
				contentPane.removeAll();
				contentPane.add(emf);
				emf.setVisible(true);
				try {
					emf.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		menu_4.add(menuItem_11);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		//ͼƬ
//		JLabel lblNewLabel = new JLabel("");
//		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
//		panel_1.add(lblNewLabel, BorderLayout.NORTH);
//		lblNewLabel.setIcon(new ImageIcon(MainPage.class.getResource("/images/bg.png")));
		
//		JScrollPane scrollPane = new JScrollPane();
		
	
//		table = new JTable();
//		 colums = new Vector<String>();
//			colums.add("�ƻ����");
//			colums.add("�ƻ�����");
//			colums.add("�ص�");
//			colums.add("�绰");
//			colums.add("ʱ��");
//			tableDatas = new Depart().getAllDeparts();
//			DefaultTableModel tableModel = new DefaultTableModel(tableDatas,colums);
//			RowSorter sorter = new TableRowSorter<DefaultTableModel>(tableModel);
//			table.setRowHeight(30);
//			table.setRowSorter(sorter);
//			table.setModel(tableModel);

//			{
//			Class[] columnTypes = new Class[] {
//				String.class, String.class, String.class, Object.class, Object.class
//			};
//			public Class getColumnClass(int columnIndex) {
//				return columnTypes[columnIndex];
//			}
//		});
//		table.getColumnModel().getColumn(1).setPreferredWidth(114);
//			scrollPane.setColumnHeaderView(table);
//			panel_1.add(scrollPane, BorderLayout.CENTER);
	}

}
