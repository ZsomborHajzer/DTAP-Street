package com.ZsomborSebastian.JabberPoint;
import com.ZsomborSebastian.JabberPoint.Styles.BlackTextStyle;
import com.ZsomborSebastian.JabberPoint.Styles.BlueHeadingStyle;
import com.ZsomborSebastian.JabberPoint.Styles.Style;
import com.ZsomborSebastian.JabberPoint.Styles.StylesFactory;

import javax.swing.*;

public class JabberPoint
{
    public static void main(String[] args)
    {
        StylesFactory factory = new StylesFactory();
        Style blackText = new BlackTextStyle();
        Style blueText = new BlueHeadingStyle();
        System.out.println(blackText.getFontName() + blackText.getColor());
        System.out.println(blueText.getFontName() + blueText.getColor());

        JFrame frame = new JFrame("Simple GUI Example");
        JLabel label = new JLabel("Hello, World!");
        JButton button = new JButton("Click Me");

        button.addActionListener(e -> label.setText("Button Clicked!"));

        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(button);

        frame.add(panel);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}


