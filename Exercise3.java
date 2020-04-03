import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;

public class SwingTextCOlor {
	class Start {
		JTextArea jt;

		Highlighter.HighlightPainter redPainter = new DefaultHighlighter.DefaultHighlightPainter(Color.RED);
		Highlighter.HighlightPainter greenPainter = new DefaultHighlighter.DefaultHighlightPainter(Color.GREEN);;
		Highlighter.HighlightPainter bluePainter = new DefaultHighlighter.DefaultHighlightPainter(Color.BLUE);

		public Start() {
			JFrame jf = new JFrame();
			jt = new JTextArea();
			jt.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));

			JTextField jtf = new JTextField();
			jtf.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
			JRadioButton red = new JRadioButton("RED");
			red.addActionListener(a -> {
				highlight(redPainter, jtf.getText());

			});
			JRadioButton green = new JRadioButton("GREEN");
			green.addActionListener(a -> {
				highlight(greenPainter, jtf.getText());

			});
			JRadioButton blue = new JRadioButton("BLUE");
			blue.addActionListener(a -> {
				highlight(bluePainter, jtf.getText());
			});
			ButtonGroup bg = new ButtonGroup();

			JPanel jp = new JPanel();
			jp.setLayout(new GridLayout(4, 1));
			jp.add(jtf);
			jp.add(red);
			jp.add(green);
			jp.add(blue);

			GridLayout jw = new GridLayout(1, 2, 100, 100);

			jf.setLayout(jw);
			jf.add(jt);
			jf.add(jp);
			bg.add(red);
			bg.add(green);
			bg.add(blue);
			jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jf.setSize(1200, 800);
			jf.setVisible(true);

		}

		public void highlight(HighlightPainter h, String text) {
			Highlighter highlight = jt.getHighlighter();
			try {

				Pattern p = Pattern.compile(text);
				Matcher m = p.matcher(jt.getText());
				Highlighter.Highlight highlights[] = highlight.getHighlights();

				while (m.find()) {

					for (Highlighter.Highlight textHig : highlights) {
						if (textHig.getStartOffset() == m.start() && textHig.getEndOffset() == m.end()) {
							highlight.removeHighlight(textHig);
						}

					}
					highlight.addHighlight(m.start(), m.end(), h);

				}

			} catch (BadLocationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SwingTextCOlor().new Start();
	}

}
