import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PopupGUI {
    public PopupGUI(String message) {
        final String[] statusText = {"Status: Off", "Status: On"};
        // Create a new JFrame
        JFrame frame = new JFrame("Copy2Keystroke");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a new JLabel for the message
        JLabel statusLabel = new JLabel(statusText[0]);
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Create a start button
        JButton startButton = new JButton("Start");
        startButton.setAlignmentX(JButton.LEFT);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                statusLabel.setText(statusText[1]);
                boolean returnedValue = ClipboardMonitor.start();
                System.out.println(returnedValue);
            }
        });

        // Create a stop button
        JButton stopButton = new JButton("Stop");
        stopButton.setAlignmentX(JButton.RIGHT);
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                statusLabel.setText(statusText[0]);
                boolean returnedValue = ClipboardMonitor.stop();
                System.out.println(returnedValue);
            }
        });
        // Create a new JPanel for the button
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);

        // Add the label and button panel to the frame
        frame.add(statusLabel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Set the size of the frame and make it visible
        frame.setSize(300, 100);
        frame.setVisible(true);
    }
}