package project1;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

public class meeting {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					meeting window = new meeting();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public meeting() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
	      frame.getContentPane().setBackground(SystemColor.menu);
	      frame.setBounds(100, 100, 393, 592);
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      frame.getContentPane().setLayout(null);
	      
	      String path = "C:\\Users\\smhrd\\Downloads\\수업내용정리\\작업\\javaworkspace\\USS팀\\src\\project1\\icon\\meeting2.png";
	      Image image = new ImageIcon(path).getImage();
	      
	      textField = new JTextField();
	      textField.setBounds(115, 188, 203, 32);
	      frame.getContentPane().add(textField);
	      textField.setColumns(10);
	      
	      textField_1 = new JTextField();
	      textField_1.setBounds(115, 224, 203, 32);
	      frame.getContentPane().add(textField_1);
	      textField_1.setColumns(10);
	      JLabel lblNewLabel = new JLabel(new ImageIcon(image.getScaledInstance(377, 553, image.SCALE_SMOOTH)));
	      lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	      lblNewLabel.setBounds(0, 0, 373, 561);
	      frame.getContentPane().add(lblNewLabel);
	      
	      JTextPane textPane = new JTextPane();
	      textPane.setBounds(36, 289, 294, 109);
	      frame.getContentPane().add(textPane);
	      
	      JComboBox comboBox = new JComboBox();
	      comboBox.setBounds(124, 420, 51, 26);
	      frame.getContentPane().add(comboBox);
	      
	      JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
	      rdbtnNewRadioButton.setBounds(206, 455, 31, 26);
	      frame.getContentPane().add(rdbtnNewRadioButton);
	}
}
