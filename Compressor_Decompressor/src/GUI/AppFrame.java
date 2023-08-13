package GUI;

import comp_decomp.compressor;
import comp_decomp.decompressor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class AppFrame implements ActionListener {

    JButton compressButton;
    JButton decompressButton;

    JFrame frame;

    AppFrame() {

        compressButton = new JButton("Select file to be compressed");
        compressButton.setBounds(20, 200, 200, 30);
        compressButton.addActionListener(this);

        decompressButton = new JButton("Select file to decompress");
        decompressButton.setBounds(750, 200, 200, 30);
        decompressButton.addActionListener(this);

        frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(1000, 500);
        frame.setLayout(null);
        frame.setVisible(true);

        frame.add(compressButton);
        frame.add(decompressButton);
        frame.getContentPane().setBackground(Color.DARK_GRAY);

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == compressButton) {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try {
                    compressor.method(file);
                } catch (Exception ee) {
                    JOptionPane.showMessageDialog(null, ee.toString());
                }
            }
        }

        if (e.getSource() == decompressButton) {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try {
                    decompressor.method(file);
                } catch (Exception ee) {
                    JOptionPane.showMessageDialog(null, ee.toString());
                }
            }
        }
    }
}
