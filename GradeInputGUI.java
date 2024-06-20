import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class GradeInputGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Save Data");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Enter the data");
        userLabel.setBounds(10, 10, 100, 25);
        panel.add(userLabel);

        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(10, 40, 260, 100);
        panel.add(scrollPane);

        JButton saveButton = new JButton("Save");
        saveButton.setBounds(10, 150, 80, 25);
        panel.add(saveButton);
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] lines = textArea.getText().split("\n");
                try (DataOutputStream output = new DataOutputStream(new FileOutputStream("grades.dat"))) {
                    double total = 0;
                    int count = 0;
                    for (String line : lines) {
                        String[] parts = line.split(" ");
                        output.writeUTF(parts[0]); 
                        int grade = Integer.parseInt(parts[1]);
                        output.writeInt(grade);
                        total += grade;
                        count++;
                    }
                    double average = total / count;
                    output.writeDouble(average);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
