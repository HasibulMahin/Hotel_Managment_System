

package Frame;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {

    JLabel user, pass;
    JButton login, signUp;
    JTextField username;
    JPasswordField password;

    public Login() {
        getContentPane().setBackground(Color.WHITE);

        setLayout(null);

        user = new JLabel("Username");
        user.setBounds(70, 40, 100, 30);
        add(user);
        username = new JTextField();
        username.setBounds(170, 40, 150, 30);
        username.setHorizontalAlignment(JTextField.CENTER);
        username.setFont(new Font("Monospace", Font.BOLD, 12));
        add(username);

        pass = new JLabel("Password");
        pass.setBounds(70, 90, 100, 30);
        add(pass);
        password = new JPasswordField();
        password.setBounds(170, 90, 150, 30);
        password.setHorizontalAlignment(JPasswordField.CENTER);
        password.setFont(new Font("Monospace", Font.BOLD, 12));
        add(password);

        login = new JButton("Login");
        login.setBounds(70, 170, 130, 40);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.white);
        add(login);

        signUp = new JButton("Sign Up");
        signUp.setBounds(220, 170, 150, 40);
        signUp.setBackground(Color.BLACK);
        signUp.setForeground(Color.white);
        signUp.addActionListener(this);
        add(signUp);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(230, 230, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(370, 0, 230, 230);
        add(image);

        setBounds(400, 200, 600, 300);
        setVisible(true);

        login.addActionListener(this);
        signUp.addActionListener(this);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == signUp) {
            setVisible(false);
            new Registration();
        }
        if (ae.getSource() == login) {
            String user = username.getText();
            String pass = password.getText();
            String empty = "";
            boolean flag = false;
            JOptionPane jopt = new JOptionPane();

            String result, war;
            war = "Fill up each information";
            result = "Wrong username or password";
            JLabel resLabel = new JLabel(result);
            JLabel warLabel = new JLabel(war);

            resLabel.setFont(new Font("Calibri", Font.BOLD, 15));
            warLabel.setFont(new Font("Calibri", Font.BOLD, 15));

            if (user.isEmpty() == false && pass.isEmpty() == false) {

                try {
                    File file = new File("hello.txt");
                    Scanner scanner = new Scanner(file);

                    while (scanner.hasNextLine()) {
                        empty += scanner.nextLine() + "\n";
                    }

                    scanner.close();

                    // Check if username and password match any registration data
                    if (empty.contains("Username : " + user) && empty.contains("Password : " + pass)) {
                        flag = true;

                    }

                } catch (FileNotFoundException ex) {
                    System.out.println("File not found: " + ex.getMessage());
                }
                if (flag) {

                    new Dashboard();
                    setVisible(false);

                } else {

                    jopt.showMessageDialog(null, resLabel, "Error Found", JOptionPane.OK_CANCEL_OPTION);
                }
                // frame.setVisible(false);
            }

            else {
                jopt.showMessageDialog(null, warLabel, "Empty Found", JOptionPane.OK_CANCEL_OPTION);
            }
        }

    }

}
