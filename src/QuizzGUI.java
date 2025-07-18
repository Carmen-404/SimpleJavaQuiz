import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizzGUI extends JFrame implements ActionListener {

    private String[] questions = {
            "What does JVM stand for?",
            "Which data type is used to store true/false?",
            "What symbol is used to end a Java statement?"
    };

    private String[][] options = {
            {"Java Very Much", "Java Virtual Machine", "Java Visual Mode"},
            {"int", "String", "boolean"},
            {".", ";", ","}
    };

    private char[] answers = {'b', 'c', 'b'};

    private ButtonGroup[] buttonGroups;
    private JPanel panel;
    private JButton submitButton;

    public QuizzGUI() {
        setTitle("Simple Java Quiz");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        buttonGroups = new ButtonGroup[questions.length];

        for (int i = 0; i < questions.length; i++) {
            JLabel questionLabel = new JLabel((i + 1) + ". " + questions[i]);
            panel.add(questionLabel);

            buttonGroups[i] = new ButtonGroup();

            for (int j = 0; j < options[i].length; j++) {
                JRadioButton optionButton = new JRadioButton((char) ('a' + j) + ") " + options[i][j]);
                optionButton.setActionCommand(String.valueOf((char) ('a' + j)));
                buttonGroups[i].add(optionButton);
                panel.add(optionButton);
            }

            panel.add(Box.createRigidArea(new Dimension(0, 10)));
        }

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        panel.add(submitButton);

        add(new JScrollPane(panel));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int score = 0;
        for (int i = 0; i < questions.length; i++) {
            ButtonModel selectedModel = buttonGroups[i].getSelection();
            if (selectedModel != null) {
                String selectedAnswer = selectedModel.getActionCommand();
                if (selectedAnswer.charAt(0) == answers[i]) {
                    score++;
                }
            }
        }

        JOptionPane.showMessageDialog(this, "🎉 You scored " + score + "/" + questions.length + "!");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new QuizzGUI().setVisible(true);
        });
    }
}