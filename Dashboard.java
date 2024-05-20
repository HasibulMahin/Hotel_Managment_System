package Frame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Dashboard extends JFrame implements ActionListener {
    public Dashboard(){
        setBounds(0,0 , 1555, 1000);
        setLayout(null);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("replace.jpg"));
        Image i2 =i1.getImage().getScaledInstance(1500, 850, Image.SCALE_DEFAULT); 
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0,1500, 850);
        add(image);
        JLabel text = new JLabel("RMAR Groups Welcomes YOU");
        text.setBounds(460, 80, 1060, 55);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Tahoma", Font.PLAIN, 38));
        image.add(text);

        JMenuBar mb = new JMenuBar();
        mb.setBounds(0, 0, 1500, 30);
        image.add(mb);

        JMenu hotel = new JMenu("Hotel Management");
        hotel.setForeground(Color.RED );
        mb.add(hotel);

        JMenuItem reception = new JMenuItem("RECEPTION");
        reception.setBackground(Color.red);
        reception.setForeground(Color.WHITE );
        reception.addActionListener(this );
        hotel.add(reception);

        JMenu admin = new JMenu("ADMIN");
        admin.setForeground(Color.BLUE);
        mb.add(admin);

        JMenuItem addEmployee = new JMenuItem("ADD EMPLOYEE");
        addEmployee.setBackground(Color.LIGHT_GRAY);
        addEmployee.addActionListener(this);
        admin.add(addEmployee);

        JMenuItem addrooms = new JMenuItem("ADD ROOMS");
        addrooms.setBackground(Color.GRAY);
        addrooms.addActionListener(this);
        admin.add(addrooms);

        JMenuItem addDrivers = new JMenuItem("ADD DRIVERS");
        addDrivers.setBackground(Color.LIGHT_GRAY);
        addDrivers.addActionListener(this);
        admin.add(addDrivers);


        setVisible(true);
    }public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("ADD EMPLOYEE")){
            new AddEmp();
        }else if(ae.getActionCommand().equals("ADD ROOMS")){
             new AddRooms();
        }else if(ae.getActionCommand().equals("ADD DRIVERS")){
            new AddDriver();

        }else if(ae.getActionCommand().equals("RECEPTION")){
            new Reception();

        }
        
    }


    
}
