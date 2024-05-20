package Frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.FileWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

@SuppressWarnings("unused")
public class Registration extends JFrame implements ActionListener {
    JLabel Register, user, email, phone, pass;
    JButton register, back;
    JTextField Password, phoneNum, emailID, username;

    public Registration() {
        getContentPane().setBackground(Color.WHITE);

        setLayout(null);

        Register = new JLabel("Register Now");
        Register.setBounds(550, 20, 230, 40);
        Register.setForeground(Color.ORANGE);
        Register.setFont(new Font("Bold", Font.PLAIN, 28));
        add(Register);

        user = new JLabel("Username");
        user.setBounds(500, 80, 100, 30);
        user.setForeground(Color.WHITE);
        add(user);
        username = new JTextField();
        username.setBounds(600, 80, 150, 30);
        add(username);

        email = new JLabel("Email");
        email.setBounds(500, 130, 100, 30);
        email.setForeground(Color.WHITE);
        add(email);
        emailID = new JTextField();
        emailID.setBounds(600, 130, 150, 30);
        add(emailID);

        phone = new JLabel("Phone");
        phone.setBounds(500, 180, 100, 30);
        phone.setForeground(Color.WHITE);
        add(phone);
        phoneNum = new JTextField();
        phoneNum.setBounds(600, 180, 150, 30);
        add(phoneNum);

        pass = new JLabel("Password");
        pass.setBounds(500, 230, 100, 30);
        pass.setForeground(Color.WHITE);
        add(pass);
        Password = new JTextField();
        Password.setBounds(600, 230, 150, 30);
        add(Password);

        register = new JButton("Register");
        register.setBounds(500, 280, 130, 40);
        register.setBackground(Color.BLACK);
        register.setForeground(Color.white);
        register.addActionListener(this);
        add(register);

        back = new JButton("Back");
        back.setBounds(650, 280, 130, 40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        ImageIcon a1 = new ImageIcon(ClassLoader.getSystemResource("registration2.jpg"));
        Image a2 = a1.getImage().getScaledInstance(864, 360, Image.SCALE_DEFAULT);
        ImageIcon a3 = new ImageIcon(a2);
        JLabel image1 = new JLabel(a3);
        image1.setBounds(0, 0, 864, 360);
        add(image1);

        setBounds(260, 200, 864, 380);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == back) {

            new Login();
            setVisible(false);
        }
        if (ae.getSource() == register) {

            String user = username.getText();
            String email = emailID.getText();
            String phone = phoneNum.getText();
            String pass = Password.getText();

            JOptionPane jopt = new JOptionPane();

            String war;
            war = "Fill up each information";

            JLabel warLabel = new JLabel(war);

            warLabel.setFont(new Font("Calibri", Font.BOLD, 15));

            if (user.isEmpty() == false && email.isEmpty() == false && phone.isEmpty() == false
                    && pass.isEmpty() == false) {
                String info = "\n\nUsername : " + user + "\nEmail : " + email + "\n" +

                        "Phone No : " + phone + "\n" + "Password : " + pass + "\n";

                jopt.showMessageDialog(null, "Registered Successfully");
                try {

                    FileWriter iofile = new FileWriter("hello.txt",true);
                    iofile.write(info);
                    iofile.close();
                } catch (Exception ex) {
                    System.out.println(ex);
                }
                new Login();
                setVisible(false);

            } else {
                jopt.showMessageDialog(null, "Please fill up all the information");
            }

        }

    }
}