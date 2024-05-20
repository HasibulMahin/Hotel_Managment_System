
package Frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Hotel extends JFrame implements ActionListener {

    public Hotel(){
        setSize(1024, 535);
        setLocation(200, 110);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("464303942.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1024, 535);
        add(image); 
        JLabel text = new JLabel("Hotel Management System");
        text.setBounds(40, 390, 1000, 90);
        text.setForeground(Color.white);
        text.setFont(new Font("serif", Font.BOLD,50 ));
        image.add(text);

        JButton start = new JButton("Start");
        start.setBounds(390,240 , 160, 60);
        start.setForeground(Color.WHITE);
        start.setBackground(Color.DARK_GRAY);
        start.addActionListener(this);
        start.setFont(new Font("serif", Font.PLAIN,18 ));
        image.add(start);
        
        setVisible(true);
        while (true) {
            text.setVisible(false);
            try{
                Thread.sleep(500);
            }catch(Exception e){
                e.printStackTrace();
            }
            text.setVisible(true);
            try{
                Thread.sleep(500);
            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }
    public void actionPerformed (ActionEvent ae){
        setVisible(false);
        new Login();

    }
    

}
