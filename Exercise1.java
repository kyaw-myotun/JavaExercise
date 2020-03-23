package swingExercise;

import java.awt.Font;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Pattern;

import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class CaculateDate {
	class GuiView {
		JFrame jf = new JFrame();
		LocalDate date = LocalDate.now();
	
		public GuiView() {

			JLabel jlb = new JLabel("How many days We Alive");
			JButton jb1 = new JButton("CaculateYear");
			JButton jb2 = new JButton("CaculateDay");
			JButton jb3 = new JButton("Clear");
			JLabel jlb1 = new JLabel("Date Of Brith (yyyy:mm:dd)");
			JTextField jt = new JTextField(20);
			jt.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 25));
			JPanel jp = new JPanel();
			jp.setLayout(new GridLayout(1, 3));
			jp.add(jb1);
			jb1.addActionListener(e -> {
				if (jt.getText().isEmpty()) {
					JOptionPane.showMessageDialog(jf, "Please Enter", "Error", JOptionPane.CANCEL_OPTION);

				} else {

					if (Pattern.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}", jt.getText())) {

						int year = Integer.parseInt(jt.getText().split("-")[0]);
						int month = Integer.parseInt(jt.getText().split("-")[1]);
						int day = Integer.parseInt(jt.getText().split("-")[2]);
						if (year > 0 && month <= 12 && day < 32) {
							Period period = Period.of(date.getYear(), date.getMonthValue(), date.getDayOfMonth());
							Period data = period.minus(Period.of(year, month, day));
							int months=	data.getMonths()< 0?data.getMonths() *-1 :data.getMonths() *1;
							int dayd =data.getDays() <0 ?data.getDays() *-1 :data.getDays();
							JOptionPane
									.showMessageDialog(jf,
											String.format("%d years %d months %d days", data.getYears(),
													months, dayd),
											"Result", JOptionPane.INFORMATION_MESSAGE);
							;
						} else {
							JOptionPane.showMessageDialog(jf, "Please Enter Valid Date(Check)", "Error",
									JOptionPane.WARNING_MESSAGE);
						}

					} else {
						JOptionPane.showMessageDialog(jf, "Please Enter Valid Date(2001-07-04)", "Error",
								JOptionPane.WARNING_MESSAGE);

					}
				}
			});
			jp.add(jb2);
			jb2.addActionListener(e -> {
				if (jt.getText().isEmpty()) {
					JOptionPane.showMessageDialog(jf, "Please Enter", "Error", JOptionPane.CANCEL_OPTION);

				} else {
					if (Pattern.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}", jt.getText())) {

						int year = Integer.parseInt(jt.getText().split("-")[0]);
						int month = Integer.parseInt(jt.getText().split("-")[1]);
						int day = Integer.parseInt(jt.getText().split("-")[2]);
						if (year > 0 && month <= 12 && day < 32) {
							Period period = Period.of(date.getYear(), date.getMonthValue(), date.getDayOfMonth());
							Period data = period.minus(Period.of(year, month, day));
							int months=	data.getMonths()< 0?data.getMonths() *-1 :data.getMonths() *1;
							int dayd =data.getDays() <0 ?data.getDays() *-1 :data.getDays();
							System.out.println(data.getDays());
							int days = data.getYears() * 365 +months * 31 + dayd+data.getYears()/4;
							System.out.println(days);
							JOptionPane.showMessageDialog(jf, String.format("%d Days", days), "Result",
									JOptionPane.INFORMATION_MESSAGE);
							;
						} else {
							JOptionPane.showMessageDialog(jf, "Please Enter Valid Date(2001-07-04)", "Error",
									JOptionPane.WARNING_MESSAGE);
						}

					} else {
						JOptionPane.showMessageDialog(jf, "Please Enter Valid Date(2001-07-04)", "Error",
								JOptionPane.WARNING_MESSAGE);

					}
				}
			});
			jp.add(jb3);
			jb3.addActionListener(e -> {
				jt.setText("");

			});
			JPanel jp1 = new JPanel();
			jp1.setLayout(new GridLayout(1, 2));
			jp1.add(jlb1);
			jp1.add(jt);
			jf.setLayout(new GridLayout(3, 1));

			jf.add(jlb);
			jf.add(jp1);
			jf.add(jp);
			jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jf.setSize(600, 200);
			jf.setVisible(true);

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CaculateDate().new GuiView();
	}

}
