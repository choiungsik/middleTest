package project1;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class meetin {

	private JFrame frame;
	private JTextField meet_id;
	private JTextField meet_image;
	int meetID = 0;
	String memID = "";
	String meetName = "";
	int personnel = 4;
	String meetInter = "";
	ButtonGroup group2 = new ButtonGroup();
	JButton btn_sport;
	JButton btn_music;
	JButton btn_art;
	JButton btn_study;

	meetingDAO dao = new meetingDAO();
	private JTextField text_path;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					meetin window = new meetin();
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
	public meetin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.menu);
		frame.setBounds(100, 100, 358, 592);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 370, 584);
		frame.getContentPane().add(panel);

		String path = "C:\\Users\\smhrd\\Downloads\\수업내용정리\\프로젝트자료\\모임생성.png";
		Image image = new ImageIcon(path).getImage();
		panel.setLayout(null);

		JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (comboBox.getSelectedIndex() == 0) {
					personnel = 4;
				} else if (comboBox.getSelectedIndex() == 1) {
					personnel = 8;
				} else if (comboBox.getSelectedIndex() == 2) {
					personnel = 12;
				} else if (comboBox.getSelectedIndex() == 3) {
					personnel = 16;
				} else if (comboBox.getSelectedIndex() == 4) {
					personnel = 20;
				}
			}
		});

		JButton btn_makeMeeting = new JButton("");
		btn_makeMeeting.setIcon(new ImageIcon(
				"C:\\Users\\smhrd\\Downloads\\\uC218\uC5C5\uB0B4\uC6A9\uC815\uB9AC\\\uD504\uB85C\uC81D\uD2B8\uC790\uB8CC\\making.PNG"));
		btn_makeMeeting.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				meetName = meet_id.getText();

				meetingVO vo = new meetingVO(meetName, personnel, meetInter);
				dao.joinMeeting(vo);

				frame.dispose();
			}
		});
		btn_makeMeeting.setBounds(121, 450, 97, 37);
		panel.add(btn_makeMeeting);

		JTextPane text_cont = new JTextPane();
		text_cont.setFont(new Font("굴림", Font.PLAIN, 15));
		text_cont.setBounds(33, 256, 263, 101);
		panel.add(text_cont);

		meet_id = new JTextField();
		meet_id.setFont(new Font("굴림", Font.PLAIN, 15));
		meet_id.setBounds(104, 166, 184, 29);
		panel.add(meet_id);
		meet_id.setColumns(10);

		text_path = new JTextField();
		text_path.setBounds(102, 198, 186, 29);
		panel.add(text_path);
		text_path.setColumns(10);

		JButton btn_picture = new JButton("");
		btn_picture.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					ImageProcessingProgram.main(null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btn_picture.setIcon(new ImageIcon(
				"C:\\Users\\smhrd\\Downloads\\\uC218\uC5C5\uB0B4\uC6A9\uC815\uB9AC\\\uD504\uB85C\uC81D\uD2B8\uC790\uB8CC\\picture.PNG"));
		btn_picture.setBounds(295, 195, 47, 29);
		panel.add(btn_picture);
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "4", "8", "12", "16", "20" }));
		comboBox.setBackground(UIManager.getColor("Button.background"));
		comboBox.setBounds(113, 372, 47, 29);
		panel.add(comboBox);

		btn_sport = new JButton("");
		btn_sport.setForeground(UIManager.getColor("Button.background"));
		btn_sport.setBackground(UIManager.getColor("Button.background"));
		btn_sport.setIcon(new ImageIcon(
				"C:\\Users\\smhrd\\Downloads\\\uC218\uC5C5\uB0B4\uC6A9\uC815\uB9AC\\\uD504\uB85C\uC81D\uD2B8\uC790\uB8CC\\sport2.PNG"));
		btn_sport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_study.setVisible(true);
				btn_art.setVisible(true);
				btn_music.setVisible(true);
				btn_sport.setVisible(false);
				meetInter = "sport";
			}
		});
		panel.add(btn_sport);
		btn_sport.setBounds(234, 87, 40, 37);
		btn_sport.setBorderPainted(false);
		btn_sport.setContentAreaFilled(false);

		btn_music = new JButton("");
		btn_music.setForeground(UIManager.getColor("Button.background"));
		btn_music.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btn_study.setVisible(true);
				btn_art.setVisible(true);
				btn_sport.setVisible(true);
				btn_music.setVisible(false);
				meetInter = "music";
			}
		});
		btn_music.setIcon(new ImageIcon(
				"C:\\Users\\smhrd\\Downloads\\\uC218\uC5C5\uB0B4\uC6A9\uC815\uB9AC\\\uD504\uB85C\uC81D\uD2B8\uC790\uB8CC\\music2.PNG"));
		btn_music.setBackground(UIManager.getColor("Button.background"));
		panel.add(btn_music);
		btn_music.setBounds(70, 87, 40, 37);
		btn_music.setBorderPainted(false);
		btn_music.setContentAreaFilled(false);

		btn_art = new JButton("");
		btn_art.setIcon(new ImageIcon(
				"C:\\Users\\smhrd\\Downloads\\\uC218\uC5C5\uB0B4\uC6A9\uC815\uB9AC\\\uD504\uB85C\uC81D\uD2B8\uC790\uB8CC\\art2.PNG"));
		btn_art.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_study.setVisible(true);
				btn_sport.setVisible(true);
				btn_music.setVisible(true);
				btn_art.setVisible(false);
				meetInter = "art";
			}
		});
		panel.add(btn_art);
		btn_art.setBounds(178, 87, 40, 37);
		btn_art.setBorderPainted(false);
		btn_art.setContentAreaFilled(false);

		btn_study = new JButton("");
		btn_study.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btn_sport.setVisible(true);
				btn_music.setVisible(true);
				btn_art.setVisible(true);
				btn_study.setVisible(false);
				meetInter = "study";
			}
		});
		btn_study.setIcon(new ImageIcon(
				"C:\\Users\\smhrd\\Downloads\\\uC218\uC5C5\uB0B4\uC6A9\uC815\uB9AC\\\uD504\uB85C\uC81D\uD2B8\uC790\uB8CC\\strudy2.PNG"));
		btn_study.setBounds(126, 87, 40, 37);
		panel.add(btn_study);
		btn_study.setBorderPainted(false);
		btn_study.setContentAreaFilled(false);

		JRadioButton rdb_secreat = new JRadioButton("New radio button");
		rdb_secreat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		rdb_secreat.setBounds(198, 407, 20, 23);
		panel.add(rdb_secreat);

		JRadioButton rdb_come = new JRadioButton("New radio button");
		rdb_come.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		rdb_come.setBounds(122, 407, 20, 23);
		panel.add(rdb_come);

		ButtonGroup group = new ButtonGroup();
		group.add(rdb_come);
		group.add(rdb_secreat);

		group2.add(btn_study);
		group2.add(btn_art);
		group2.add(btn_sport);
		group2.add(btn_music);

		JLabel lbl_image = new JLabel(new ImageIcon(
				"C:\\Users\\smhrd\\Downloads\\\uC218\uC5C5\uB0B4\uC6A9\uC815\uB9AC\\\uD504\uB85C\uC81D\uD2B8\uC790\uB8CC\\\uBAA8\uC7842.PNG"));
		lbl_image.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				text_path.setText(ImageProcessingProgram.getPath());

			}
		});
		lbl_image.setBounds(0, 0, 343, 502);
		panel.add(lbl_image);

		meet_image = new JTextField();
		meet_image.setFont(new Font("굴림", Font.PLAIN, 15));
		meet_image.setBounds(104, 198, 184, 29);
		panel.add(meet_image);
		meet_image.setColumns(10);
		btn_study.setBorderPainted(false);
		btn_study.setContentAreaFilled(false);

	}

}
