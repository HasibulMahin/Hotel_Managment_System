package Frame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Reception extends JFrame implements ActionListener{
    JButton newCustomer,rooms,department,allEmployee,customer,manager,checkout,update,updateRoom,pickUp,searchRooms,logout;
    JLabel image;


    public Reception(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        newCustomer=new JButton("New Customer Form");
        newCustomer.setBackground(Color.BLACK);
        newCustomer.setForeground(Color.WHITE);
        newCustomer.addActionListener(this);
        newCustomer.setBounds(10,30,200,30);
        add(newCustomer);

        rooms=new JButton("Rooms");
        rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.WHITE);
        rooms.setBounds(10,70,200,30);
        add(rooms);

        department=new JButton("Department");
        department.setBackground(Color.BLACK);
        department.setForeground(Color.WHITE);
        department.setBounds(10,110,200,30);
        add(department);

        department=new JButton("Department");
        department.setBackground(Color.BLACK);
        department.setForeground(Color.WHITE);
        department.setBounds(10,110,200,30);
        add(department);

        allEmployee=new JButton("All Employees");
        allEmployee.setBackground(Color.BLACK);
        allEmployee.setForeground(Color.WHITE);
        allEmployee.setBounds(10,150,200,30);
        add(allEmployee);

        customer=new JButton("Customers Info ");
        customer.setBackground(Color.BLACK);
        customer.setForeground(Color.WHITE);
        customer.setBounds(10,190,200,30);
        add(customer);

        manager=new JButton("Manager Info ");
        manager.setBackground(Color.BLACK);
        manager.setForeground(Color.WHITE);
        manager.setBounds(10,230,200,30);
        add(manager);

        checkout=new JButton("Checkout");
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.setBounds(10,270,200,30);
        add(checkout);

        update=new JButton("Update Status");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(10,310,200,30);
        add(update);

        updateRoom=new JButton("Update Room Status");
        updateRoom.setBackground(Color.BLACK);
        updateRoom.setForeground(Color.WHITE);
        updateRoom.setBounds(10,350,200,30);
        add(updateRoom);

        pickUp=new JButton("PickUp Service");
        pickUp.setBackground(Color.BLACK);
        pickUp.setForeground(Color.WHITE);
        pickUp.setBounds(10,390,200,30);
        add(pickUp);

        searchRooms=new JButton("Search Room");
        searchRooms.setBackground(Color.BLACK);
        searchRooms.setForeground(Color.WHITE);
        searchRooms.setBounds(10,430,200,30);
        add(searchRooms);

        logout=new JButton("Logout");
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        logout.setBounds(10,470,200,30);
        add(logout);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("fourth.jpg"));
        image=new JLabel(i1);
        image.setBounds(250,30,500,470);
        add(image);



        setBounds(350,170,800,570);

        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==newCustomer){
            setVisible(false);
            new AddCustomer();
        }
    }
    
}
