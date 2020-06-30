package firstproject;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class 남여비율 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					남여비율 window = new 남여비율();
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
	public 남여비율() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private Object[] arr;

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 805, 733);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);

		JPanel panel = new JPanel();
		panel.setBackground(Color.white);
		springLayout.putConstraint(SpringLayout.NORTH, panel, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 413, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, 775, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(panel);

		ReadCSV csv = new ReadCSV();
		ArrayList<MaleVO> list = csv.getList();

		// ===========================================================================================================
		DefaultPieDataset dataset = new DefaultPieDataset();// 남여 비율
		int male = 0;
		int female = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getSex().equals("male")) {
				male++;
				dataset.setValue(list.get(i).getSex(), male);
			} else {
				female++;
				dataset.setValue(list.get(i).getSex(), female);
			}
		}

		JFreeChart pieChart = ChartFactory.createPieChart("남녀비율", dataset, true, true, true);
		Font f = new Font("Gulim", Font.BOLD, 14);

		pieChart.getTitle().setFont(f);

		PiePlot plot2 = (PiePlot) pieChart.getPlot();
		plot2.setLabelFont(f);

		// 려진 그래프를 차트패널에 올리기
//		ChartPanel chartPanel = new ChartPanel(barChart);
		ChartPanel chartPanel = new ChartPanel(pieChart);
		chartPanel.setBackground(new Color(255, 255, 255));
		panel.add(chartPanel);

		// 그래프 크기조절
		// 너비, 높이
		chartPanel.setPreferredSize(new java.awt.Dimension(300, 400));
		panel.add(chartPanel);
//===========================================================================================================

		DefaultCategoryDataset dataset2 = new DefaultCategoryDataset(); // 연령대 참여비율

		int twenty = 0;
		int thirty = 0;
		int forty = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getAge() < 30) {
				twenty++;
			} else if (list.get(i).getAge() < 40) {
				thirty++;
			} else {
				forty++;
			}
		}
		dataset2.addValue(twenty, "20", "20대");
		dataset2.addValue(thirty, "30", "30대");
		dataset2.addValue(forty, "40", "40대");

//		System.out.println(ten + ", " + twenty + ", " + thirty + ", " + forty);

		JFreeChart barChart2 = ChartFactory.createBarChart("연령별 참여비율", "나이대", "참여횟수", dataset2,
				PlotOrientation.VERTICAL, true, true, true);
		Font f2 = new Font("Gulim", Font.BOLD, 14);

		barChart2.getTitle().setFont(f2);

		// x축 y축 한글적용
		CategoryPlot plot1 = barChart2.getCategoryPlot();
		// x축
		plot1.getDomainAxis().setLabelFont(f);
		plot1.getDomainAxis().setTickLabelFont(f);
		// y축
		plot1.getRangeAxis().setLabelFont(f);
		plot1.getRangeAxis().setTickLabelFont(f);

		PiePlot plot21 = (PiePlot) pieChart.getPlot();
		plot21.setLabelFont(f);

		ChartPanel chartPanel2 = new ChartPanel(barChart2);
		chartPanel2.setBackground(new Color(255, 255, 255));
		panel.add(chartPanel2);

		// 그래프 크기조절
		// 너비, 높이
		chartPanel2.setPreferredSize(new java.awt.Dimension(300, 400));
		panel.add(chartPanel2);
//===========================================================================================================

//		DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
//		for (int i = 0; i < list.size(); i++) {
//			dataset1.addValue(1, "연령대", "참여횟수");
//
//		}
//
//		JFreeChart chart = ChartFactory.createBarChart3D("연령별 모임 참여비율", "연령대", "참여횟수", dataset1,
//				PlotOrientation.HORIZONTAL, true, true, false);
//		panel.add(chart);
//		chart.getPlot();

	}

}
