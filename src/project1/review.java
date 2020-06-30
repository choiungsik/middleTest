package project1;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class review {

	private JFrame frame;
	int review_count = 3;
	private int R = 242;
	private int G = 242;
	private int B = 242;
	private JTextField text1_name;
	private JTextField text2_name;
	private JTextField text3_name;
	private JTextField text4_name;
	private JTextField text2_title;
	private JTextField text3_title;
	private JTextField text4_title;
	private JTextField text1_cont;
	private JTextField text2_cont;
	private JTextField text3_cont;
	private JTextField text4_cont;

	ReviewDAO dao = new ReviewDAO();
	private JTextField text1_title;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					review window = new review();
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
	public review() {
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

		String path = "C:\\Users\\smhrd\\Downloads\\수업내용정리\\프로젝트자료\\review.png";
		Image image = new ImageIcon(path).getImage();
		String path1 = "C:\\Users\\smhrd\\Downloads\\수업내용정리\\프로젝트자료\\star1.png";
		Image image_star1 = new ImageIcon(path1).getImage();

		String path2 = "C:\\Users\\smhrd\\Downloads\\수업내용정리\\프로젝트자료\\star2.png";
		Image image_star2 = new ImageIcon(path2).getImage();

		String path3 = "C:\\Users\\smhrd\\Downloads\\수업내용정리\\프로젝트자료\\star3.png";
		Image image_star3 = new ImageIcon(path3).getImage();

		String path4 = "C:\\Users\\smhrd\\Downloads\\수업내용정리\\프로젝트자료\\star4.png";
		Image image_star4 = new ImageIcon(path4).getImage();

		String path5 = "C:\\Users\\smhrd\\Downloads\\수업내용정리\\프로젝트자료\\star5.png";
		Image image_star5 = new ImageIcon(path5).getImage();

		JButton btn_member = new JButton("");
		btn_member.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.dispose();
			}
		});
		btn_member.setIcon(new ImageIcon(
				"C:\\Users\\smhrd\\Downloads\\\uC218\uC5C5\uB0B4\uC6A9\uC815\uB9AC\\\uD504\uB85C\uC81D\uD2B8\uC790\uB8CC\\disable_member.PNG"));
		btn_member.setBounds(317, 55, 34, 34);
		frame.getContentPane().add(btn_member);
		btn_member.setBorderPainted(false);
		btn_member.setContentAreaFilled(false);

		JButton btn_review = new JButton("");
		btn_review.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				review.main(null);
			}
		});
		btn_review.setIcon(new ImageIcon(
				"C:\\Users\\smhrd\\Downloads\\\uC218\uC5C5\uB0B4\uC6A9\uC815\uB9AC\\\uD504\uB85C\uC81D\uD2B8\uC790\uB8CC\\enable_review.PNG"));
		btn_review.setBounds(261, 55, 34, 34);
		frame.getContentPane().add(btn_review);
		btn_review.setBorderPainted(false);
		btn_review.setContentAreaFilled(false);

		JButton btn_chat = new JButton("");
		btn_chat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		btn_chat.setIcon(new ImageIcon(
				"C:\\Users\\smhrd\\Downloads\\\uC218\uC5C5\uB0B4\uC6A9\uC815\uB9AC\\\uD504\uB85C\uC81D\uD2B8\uC790\uB8CC\\disable_chat.PNG"));
		btn_chat.setBounds(195, 55, 34, 34);
		frame.getContentPane().add(btn_chat);
		btn_chat.setBorderPainted(false);
		btn_chat.setContentAreaFilled(false);

		JButton btn_picture = new JButton("");
		btn_picture.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		btn_picture.setIcon(new ImageIcon(
				"C:\\Users\\smhrd\\Downloads\\\uC218\uC5C5\uB0B4\uC6A9\uC815\uB9AC\\\uD504\uB85C\uC81D\uD2B8\uC790\uB8CC\\disable_picture.PNG"));
		btn_picture.setBounds(135, 55, 34, 34);
		frame.getContentPane().add(btn_picture);
		btn_picture.setBorderPainted(false);
		btn_picture.setContentAreaFilled(false);

		JButton btn_share = new JButton("");
		btn_share.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		btn_share.setIcon(new ImageIcon(
				"C:\\Users\\smhrd\\Downloads\\\uC218\uC5C5\uB0B4\uC6A9\uC815\uB9AC\\\uD504\uB85C\uC81D\uD2B8\uC790\uB8CC\\disable_share.PNG"));
		btn_share.setBounds(70, 55, 34, 34);
		frame.getContentPane().add(btn_share);
		btn_share.setBorderPainted(false);
		btn_share.setContentAreaFilled(false);

		JButton btn_infor = new JButton("");
		btn_infor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		btn_infor.setIcon(new ImageIcon(
				"C:\\Users\\smhrd\\Downloads\\\uC218\uC5C5\uB0B4\uC6A9\uC815\uB9AC\\\uD504\uB85C\uC81D\uD2B8\uC790\uB8CC\\disable_infor.PNG"));
		btn_infor.setBounds(12, 55, 34, 34);
		frame.getContentPane().add(btn_infor);
		btn_infor.setBorderPainted(false);
		btn_infor.setContentAreaFilled(false);

		text1_name = new JTextField();
		text1_name.setHorizontalAlignment(SwingConstants.RIGHT);
		text1_name.setEditable(false);
		text1_name.setBounds(81, 144, 70, 34);
		frame.getContentPane().add(text1_name);
		text1_name.setColumns(10);
		text1_name.setBackground(new Color(R, G, B));
		text1_name.setBorder(null);

		text2_name = new JTextField();
		text2_name.setHorizontalAlignment(SwingConstants.RIGHT);
		text2_name.setEditable(false);
		text2_name.setColumns(10);
		text2_name.setBounds(83, 240, 70, 34);
		frame.getContentPane().add(text2_name);
		text2_name.setBackground(new Color(R, G, B));
		text2_name.setBorder(null);

		text3_name = new JTextField();
		text3_name.setHorizontalAlignment(SwingConstants.RIGHT);
		text3_name.setEditable(false);
		text3_name.setColumns(10);
		text3_name.setBounds(81, 318, 70, 23);
		frame.getContentPane().add(text3_name);
		text3_name.setBackground(new Color(R, G, B));
		text3_name.setBorder(null);

		text4_name = new JTextField();
		text4_name.setHorizontalAlignment(SwingConstants.RIGHT);
		text4_name.setEditable(false);
		text4_name.setColumns(10);
		text4_name.setBounds(83, 402, 70, 23);
		frame.getContentPane().add(text4_name);
		text4_name.setBackground(new Color(R, G, B));
		text4_name.setBorder(null);

		text1_title = new JTextField();
		text1_title.setEditable(false);
		text1_title.setColumns(10);
		text1_title.setBackground(new Color(242, 242, 242));
		text1_title.setBounds(76, 170, 75, 40);
		frame.getContentPane().add(text1_title);
		text1_title.setBorder(null);

		text2_title = new JTextField();
		text2_title.setEditable(false);
		text2_title.setColumns(10);
		text2_title.setBounds(80, 262, 75, 40);
		frame.getContentPane().add(text2_title);
		text2_title.setBackground(new Color(R, G, B));
		text2_title.setBorder(null);

		text3_title = new JTextField();
		text3_title.setEditable(false);
		text3_title.setColumns(10);
		text3_title.setBounds(82, 339, 75, 40);
		frame.getContentPane().add(text3_title);
		text3_title.setBackground(new Color(R, G, B));
		text3_title.setBorder(null);

		text4_title = new JTextField();
		text4_title.setEditable(false);
		text4_title.setColumns(10);
		text4_title.setBounds(82, 421, 75, 49);
		frame.getContentPane().add(text4_title);
		text4_title.setBackground(new Color(R, G, B));
		text4_title.setBorder(null);

		text1_cont = new JTextField();
		text1_cont.setEditable(false);
		text1_cont.setBounds(151, 170, 207, 43);
		frame.getContentPane().add(text1_cont);
		text1_cont.setColumns(10);
		text1_cont.setBackground(new Color(R, G, B));
		text1_cont.setBorder(null);

		text2_cont = new JTextField();
		text2_cont.setEditable(false);
		text2_cont.setColumns(10);
		text2_cont.setBounds(151, 262, 202, 40);
		frame.getContentPane().add(text2_cont);
		text2_cont.setBackground(new Color(R, G, B));
		text2_cont.setBorder(null);

		text3_cont = new JTextField();
		text3_cont.setEditable(false);
		text3_cont.setColumns(10);
		text3_cont.setBounds(152, 337, 202, 40);
		frame.getContentPane().add(text3_cont);
		text3_cont.setBackground(new Color(R, G, B));
		text3_cont.setBorder(null);

		text4_cont = new JTextField();
		text4_cont.setEditable(false);
		text4_cont.setColumns(10);
		text4_cont.setBounds(153, 422, 202, 40);
		frame.getContentPane().add(text4_cont);
		text4_cont.setBackground(new Color(R, G, B));
		text4_cont.setBorder(null);

		JLabel lbl_star1 = new JLabel("");
		lbl_star1.setBounds(152, 144, 101, 24);
		frame.getContentPane().add(lbl_star1);

		JLabel lbl_star2 = new JLabel("");
		lbl_star2.setBounds(152, 235, 101, 24);
		frame.getContentPane().add(lbl_star2);

		JLabel lbl_star3 = new JLabel("");
		lbl_star3.setBounds(156, 317, 101, 24);
		frame.getContentPane().add(lbl_star3);

		JLabel lbl_star4 = new JLabel("");
		lbl_star4.setBounds(155, 396, 101, 24);
		frame.getContentPane().add(lbl_star4);
//		text1_name.setText(dao.reviewselect().toString().);

		try {

			text1_name.setText(dao.reviewNameSelect(0));

			text1_title.setText(dao.reviewTitleSelect(0));

			text1_cont.setText(dao.reviewContSelect(0));

			text2_name.setText(dao.reviewNameSelect(1));

			text2_title.setText(dao.reviewTitleSelect(1));

			text2_cont.setText(dao.reviewContSelect(1));

			text3_name.setText(dao.reviewNameSelect(2));

			text3_title.setText(dao.reviewTitleSelect(2));

			text3_cont.setText(dao.reviewContSelect(2));

			text4_name.setText(dao.reviewNameSelect(3));

			text4_title.setText(dao.reviewTitleSelect(3));

			text4_cont.setText(dao.reviewContSelect(3));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("널값생김");
		}

		JLabel lblNewLabel = new JLabel(new ImageIcon(image.getScaledInstance(370, 553, image.SCALE_SMOOTH)));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 373, 561);
		frame.getContentPane().add(lblNewLabel);

		JLabel lbl1_block = new JLabel();
		JLabel lbl_main = new JLabel(new ImageIcon(image.getScaledInstance(370, 553, image.SCALE_SMOOTH)));
		lbl_main.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_main.setBounds(0, 0, 373, 561);
		frame.getContentPane().add(lbl_main);

		int star1 = dao.reviewStarSelect(0);
		starMake(image_star1, image_star2, image_star3, image_star4, image_star5, lbl_star1, star1);
		int star2 = dao.reviewStarSelect(1);
		starMake(image_star1, image_star2, image_star3, image_star4, image_star5, lbl_star2, star2);
		int star3 = dao.reviewStarSelect(2);
		starMake(image_star1, image_star2, image_star3, image_star4, image_star5, lbl_star3, star3);
		
		
		int star4 = dao.reviewStarSelect(3);
		starMake(image_star1, image_star2, image_star3, image_star4, image_star5, lbl_star4, star4);

		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 373, 561);
		frame.getContentPane().add(lblNewLabel);

	}

	private void starMake(Image image_star1, Image image_star2, Image image_star3, Image image_star4, Image image_star5,
			JLabel lbl_star1, int star1) {
		if (star1 == 1) {
			lbl_star1.setIcon(new ImageIcon(image_star1.getScaledInstance(94, 24, image_star1.SCALE_SMOOTH)));
		} else if (star1 == 2) {
			lbl_star1.setIcon(new ImageIcon(image_star2.getScaledInstance(93, 22, image_star2.SCALE_SMOOTH)));
		} else if (star1 == 3) {
			lbl_star1.setIcon(new ImageIcon(image_star3.getScaledInstance(92, 19, image_star3.SCALE_SMOOTH)));
		} else if (star1 == 4) {
			lbl_star1.setIcon(new ImageIcon(image_star4.getScaledInstance(90, 21, image_star4.SCALE_SMOOTH)));
		} else if (star1 == 5) {
			lbl_star1.setIcon(new ImageIcon(image_star5.getScaledInstance(92, 21, image_star5.SCALE_SMOOTH)));
		}
	}
}
