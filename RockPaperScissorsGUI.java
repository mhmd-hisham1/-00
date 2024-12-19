import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class RockPaperScissorsGUI {

    private JFrame frame; // النافذة الرئيسية
    private JLabel messageLabel, resultLabel, computerChoiceLabel;
    private Random random = new Random();
    private String[] options = {"Rock", "Paper", "Scissors"}; // خيارات اللعبة

    public RockPaperScissorsGUI() {
        // إنشاء الإطار الرئيسي
        frame = new JFrame("Rock, Paper, Scissors");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(4, 1));

        // رسالة الترحيب
        messageLabel = new JLabel("Choose Rock, Paper, or Scissors:", JLabel.CENTER);
        frame.add(messageLabel);

        // أزرار اللعبة
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        JButton rockButton = new JButton("Rock");
        JButton paperButton = new JButton("Paper");
        JButton scissorsButton = new JButton("Scissors");
        buttonPanel.add(rockButton);
        buttonPanel.add(paperButton);
        buttonPanel.add(scissorsButton);
        frame.add(buttonPanel);

        // لعرض اختيار الكمبيوتر
        computerChoiceLabel = new JLabel("", JLabel.CENTER);
        frame.add(computerChoiceLabel);

        // لعرض النتيجة
        resultLabel = new JLabel("", JLabel.CENTER);
        frame.add(resultLabel);

        // الأحداث عند الضغط على الأزرار
        rockButton.addActionListener(e -> playGame("Rock"));
        paperButton.addActionListener(e -> playGame("Paper"));
        scissorsButton.addActionListener(e -> playGame("Scissors"));

        // عرض النافذة
        frame.setVisible(true);
    }

    private void playGame(String playerChoice) {
        // اختيار الكمبيوتر عشوائيًا
        String computerChoice = options[random.nextInt(3)];
        computerChoiceLabel.setText("Computer chose: " + computerChoice);

        // تحديد الفائز
        String result;
        if (playerChoice.equals(computerChoice)) {
            result = "It's a tie!";
        } else if (
                (playerChoice.equals("Rock") && computerChoice.equals("Scissors")) ||
                        (playerChoice.equals("Paper") && computerChoice.equals("Rock")) ||
                        (playerChoice.equals("Scissors") && computerChoice.equals("Paper"))
        ) {
            result = "You win!";
        } else {
            result = "You lose!";
        }

        // عرض النتيجة
        resultLabel.setText(result);
    }

    public static void main(String[] args) {
        new RockPaperScissorsGUI(); // تشغيل اللعبة
    }
}
