package forms.user;



//

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import dto.UserDTO;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;

import services.user.User;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateUserForm extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JLabel lblUserNameTip;
	private JLabel lblPSWTip;

	private User user;
	private JPasswordField newpasswordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateUserForm frame = new UpdateUserForm("root");
				
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private static void setFrameLoaction(JFrame frame) {
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

		int width = screen.width;
		int height = screen.height;

		int left = (width - frame.getSize().width) / 2;
		int top = (height - frame.getSize().height) / 2;

		frame.setLocation(left, top);

	}

	/**
	 * Create the frame.
	 */
	public UpdateUserForm(final String user_name) {
		setTitle("\u4FEE\u6539\u5BC6\u7801");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 519, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 10));

		JPanel bar = new JPanel();
		FlowLayout fl_bar = (FlowLayout) bar.getLayout();
		fl_bar.setVgap(20);
		fl_bar.setAlignment(FlowLayout.CENTER);
		bar.setBackground(new Color(135, 206, 235));
		panel.add(bar, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel(
				"\u7535\u5382\u804C\u5DE5\u57F9\u8BAD\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setForeground(new Color(0, 128, 0));
		lblNewLabel.setFont(new Font("��������", Font.PLAIN, 25));
		bar.add(lblNewLabel);

		JPanel body = new JPanel();
		panel.add(body, BorderLayout.CENTER);
		body.setLayout(null);

		// �����ť�¼��Ĵ����߼�
		JButton btnLogin = new JButton("\u4FEE\u6539");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (validateUser()) {
					// ���ͨ���﷨��֤��������ж��û��Ƿ�Ϊ�Ϸ��û�
					user = new User(user_name, new String(
							passwordField.getPassword()));
					if (user.findUser()){
						UserDTO userDTO = new UserDTO(user_name,newpasswordField.getText());
							System.out.println("�����޸�");
							user.updateUser(userDTO);
							JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
							
							passwordField.setText("");
							newpasswordField.setText("");
					}
						
					else
						JOptionPane.showMessageDialog(null, "ԭ�����������");

				} else
					JOptionPane.showMessageDialog(null, "�ʺŲ�����");
			}
		});

		btnLogin.setBounds(102, 172, 93, 32);
		body.add(btnLogin);

		JButton btnCancle = new JButton("\u53D6\u6D88");
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.exit(0);
				//setVisible(false);
				dispose();
			}
		});
		btnCancle.setBounds(268, 172, 93, 32);
		body.add(btnCancle);
		JLabel lblNewLabel_2 = new JLabel("\u65E7\u5BC6\u7801\uFF1A");
		lblNewLabel_2.setBounds(102, 48, 54, 15);
		body.add(lblNewLabel_2);

		lblUserNameTip = new JLabel("\u8BF7\u8F93\u5165\u65E7\u5BC6\u7801");
		lblUserNameTip.setForeground(new Color(220, 20, 60));
		lblUserNameTip.setBounds(351, 48, 140, 15);
		body.add(lblUserNameTip);

		lblPSWTip = new JLabel("\u8BF7\u8F93\u5165\u65B0\u5BC6\u7801");
		lblPSWTip.setForeground(new Color(220, 20, 60));
		lblPSWTip.setBounds(351, 112, 140, 15);
		body.add(lblPSWTip);

		passwordField = new JPasswordField();
		passwordField.setBounds(165, 39, 176, 32);
		body.add(passwordField);
		
		JLabel lablNewPsd = new JLabel("\u65B0\u5BC6\u7801\uFF1A");
		lablNewPsd.setBounds(102, 112, 54, 15);
		body.add(lablNewPsd);
		
		newpasswordField = new JPasswordField();
		newpasswordField.setBounds(161, 103, 180, 32);
		body.add(newpasswordField);
	}

	/*
	 * ���û���¼��Ϣ���﷨���������֤
	 */
	private boolean validateUser() {
		boolean result = true;

		if (new String(passwordField.getPassword()).isEmpty()) {
			this.lblPSWTip.setText("����������!");
			result = result && false;
		}
		return result;
	}
}

