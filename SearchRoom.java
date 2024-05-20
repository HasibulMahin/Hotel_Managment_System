package Frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class SearchRoom extends JFrame implements ActionListener {
    JCheckBox available;
    jCheckBox bed_type;
    JTable table;
    JButton submit, back;

    SearchRoom() {

        getContentPane().setBackground(Color.White);
        setlayout(null);

        JLabel text = new JLabel("Search of Room");
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        text.setBounds(400, 30, 200, 30);
        add(text);

        JLabel lblbed = new JLabel(" Bed Type:");
        lblbed.setBounds(50, 100, 100, 20);
        add(lblbed);

        bedType = new JComboBox(new String[] { "Single Bed", "Double Bed" });
        bedType.setBounds(150, 100, 150, 25);
        bedType.setBackground(Color.WHITE);
        add(bedType);

        available = new JCheckBox("Only display Available");
        available.setBounds(650, 100, 150, 25);
        available.setBackground(Color.WHITE);
        add(available);

        JLabel room = new JLabel("Room Number");
        room.setBounds(50, 160, 100, 20);
        room.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(room);

        JLabel available = new JLabel("Availability");
        available.setBounds(270, 160, 100, 20);
        available.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(available);

        JLabel clean = new JLabel("Cleaning Status");
        clean.setBounds(450, 160, 120, 20);
        clean.setForeground(Color.WHITE);
        clean.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(clean);

        JLabel Price = new JLabel("Price");
        Price.setBounds(670, 160, 100, 20);
        Price.setForeground(Color.WHITE);
        Price.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(Price);

        checkBox = new JCheckBox("Only Display Available");
        checkBox.setBounds(400, 69, 205, 23);
        checkBox.setForeground(Color.WHITE);
        checkBox.setBackground(new Color(3, 45, 48));
        panel.add(checkBox);

        choice = new Choice();
        choice.add("Single Bed");
        choice.add("Double Bed");
        choice.setBounds(170, 70, 120, 20);
        panel.add(choice);

        table = new JTable();
        table.setBounds(0, 200, 1000, 300);
        table.setBackground(new Color(3, 45, 48));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try {
            con c = new con();
            ResultSet rs = c.s.executeQuery("Select * from room");

            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        submit = new JButton("Search");
        submit.setBounds(300, 520, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setBounds(500, 520, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        panel.add(back);

        setBounds(300, 200, 1000, 600);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == add) {
            try {
                String Q = "select * from Room where bed_type = '" + choice.getSelectedItem() + "'";
                String Q1 = "select * from Room where availability = 'Available'  And bed_type = '"
                        + choice.getSelectedItem() + "'";

                con c = new con();
                ResultSet rs;

                if (available.isSelected()) {
                    ResultSet resultSet1 = c.s.executeQuery(query2);
                } else {

                    rs = conn.s.executeQuery(query1);
                }

                table.setModel(DbUtils.resultSetToTableModel(resultSet1));
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else {
            setVisible(false);
            new reception();
        }

    }

    public static void main(String[] args) {
        new SearchRoom();
    }
}
