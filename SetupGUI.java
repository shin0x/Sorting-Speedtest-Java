import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SetupGUI extends JFrame implements ActionListener {

    JPanel bottom = new JPanel(new FlowLayout());
    JPanel algorithmsPanel = new JPanel(new FlowLayout());

    JTextField amount = new JTextField("1000", 20);
    JCheckBox[] sortsEnabled = new JCheckBox[5];
    JButton startBtn = new JButton("Start");
    JButton showBtn = new JButton("Show Array");
    int[] numbers;


    public JFrame prepareGUI() {
        //setup window
        JFrame window = new JFrame();
        window.setLayout(new BorderLayout());
        window.setSize(650, 250);
        window.setResizable(true);
        window.setTitle("Sorting Algorithms Speed Comparison");
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);

        //setup window elements
        JLabel title = new JLabel("Sortiervergleich (in ms)", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.PLAIN, 25));
        String[] names = {"Bubble sort", "Selection sort", "Insertion sort", "Quick sort", "Heap sort"};

        for (int i = 0; i < sortsEnabled.length; i++) {
            this.sortsEnabled[i] = new JCheckBox(names[i], true);
            this.sortsEnabled[i].setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            algorithmsPanel.add(this.sortsEnabled[i]);
        }

        bottom.add(amount);
        bottom.add(startBtn);
        bottom.add(showBtn);

        window.add(title, BorderLayout.NORTH);

        window.add(algorithmsPanel, BorderLayout.WEST);
        window.add(bottom, BorderLayout.SOUTH);
        startBtn.addActionListener(this);
        showBtn.addActionListener(this);

        window.setVisible(true);
        return window;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        if(actionEvent.getSource() == startBtn) {
            numbers = new int[Integer.parseInt(amount.getText())];
            for (int i = 0; i < numbers.length; i++)
                numbers[i] = new Random().nextInt(numbers.length);
            insertTime(numbers);
        }
        else if (actionEvent.getSource() == showBtn){
            try {
                createPopup(numbers);
            }
            catch (NullPointerException e){
                JOptionPane.showMessageDialog(null, "Please press the start button first to generate the numbers", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    public void insertTime(int[] numbers) {
        Time time = Comparison.comp(numbers, sortsEnabled[0].isSelected(), sortsEnabled[1].isSelected(), sortsEnabled[2].isSelected(), sortsEnabled[3].isSelected(), sortsEnabled[4].isSelected());
        JOptionPane.showMessageDialog(null,
                "Bubble sort: " + time.bubbleSort + "ms\n" +
                "Selection sort: " + time.selectionSort + "ms\n" +
                "Insertion sort: " + time.insertionSort + "ms\n" +
                "Quick sort: " + time.quickSort + "ms\n" +
                "Heap sort: " + time.heapSort + "ms", "Result", JOptionPane.INFORMATION_MESSAGE);
    }

    private void createPopup(int[] numbers) {
        StringBuilder text = new StringBuilder();

        for (int i=0; i<numbers.length; i++) {
            text.append(" ").append(numbers[i]);
            if(i % 50 == 0){
                text.append("\n");
            }
        }

        JOptionPane.showMessageDialog(null, text.toString(), "Generated Numbers", JOptionPane.INFORMATION_MESSAGE);
    }
}
