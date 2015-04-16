package Grupul.Thucy.suing;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

import Grupul.Thucy.Testul;

public class Suing extends JFrame {

    public Suing() {
        initUI();
    }

    private void initUI() {

        JButton quitButton = new JButton("Quit");

        quitButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                // System.exit(0);
                System.out.println("actiunee");
                Testul t = new Testul();
                t.searching_by_keyword_apple_should_display_the_corresponding_article();
            }
        });

        createLayout(quitButton);
        setTitle("Quit button");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createLayout(JComponent... arg) {

        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);

        gl.setHorizontalGroup(gl.createSequentialGroup().addComponent(arg[0]));

        gl.setVerticalGroup(gl.createSequentialGroup().addComponent(arg[0]));
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            public void run() {
                Suing ex = new Suing();
                ex.setVisible(true);
            }
        });
    }

}
