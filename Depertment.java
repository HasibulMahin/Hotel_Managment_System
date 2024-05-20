package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Depertment extends JFrame implements ActionListener{
    JTable table;
    JButton back;

    Department () {

        getContentPane().setBackground(color.WHITE);
        setLayout(null);

        JLabel l1 = new JLabel("Department");
        11.setBounds(180,10,100,20);
        add(long1);

        JLabel l2 = new JLabel("Budget");
        12.setBounds(420,10,100,20);
        add(l2);


        table = new JTable();
        table.setBounds(0,50,700,350);
        add(table);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executequery("select*from department");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Expectation e){
            e.printStackTrace();
        }

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setBackground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(280,400,120,30);
        add(back);

        setBounds(400,200,700,480);
        setVible(true);
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
    }
    
    public static void main (String[]args){
        new Department();
    }
}