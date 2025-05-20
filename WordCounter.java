import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WordCounter extends JFrame implements ActionListener {

    JTextArea textArea;
    JButton countButton;
    JLabel resultLabel;

    public WordCounter() {
        setTitle("Word Counter");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Text area
        textArea = new JTextArea();
        textArea.setLineWrap(true);            
        textArea.setWrapStyleWord(true); 
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Button and result
        countButton = new JButton("Count Words");
        countButton.addActionListener(this);

        resultLabel = new JLabel("Word Count: 0");

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        bottomPanel.add(countButton);
        bottomPanel.add(resultLabel);

        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = textArea.getText().trim();
        if (text.isEmpty()) {
            resultLabel.setText("Word Count: 0");
        } else {
            String[] words = text.split("\\s+");
            resultLabel.setText("Word Count: " + words.length);
        }
    }

    public static void main(String[] args) {
        new WordCounter();
    }
}

