package Frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddRooms extends JFrame implements ActionListener {
    JLabel heading,roomNO,availableRoom,cleanSta,roomPrice,bedType,image;
    JTextField room,price;
    JComboBox availableCombo,cleanCombo,typeCombo;
    JButton Add,cancel;
     public AddRooms(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

         heading = new JLabel("Add Rooms");
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        heading.setBounds(150, 20, 200, 20);
	    add(heading);

        roomNO = new JLabel("Room Number");
        roomNO.setFont(new Font("Tahoma", Font.PLAIN, 16));
        roomNO.setBounds(60, 80, 150, 30);
	    add(roomNO);

        room=new JTextField();
        room.setBounds(200,80,150,30);
        add(room);

        availableRoom = new JLabel("Availability");
        availableRoom.setFont(new Font("Tahoma", Font.PLAIN, 16));
        availableRoom.setBounds(60, 130, 120, 30);
	    add(availableRoom);

        String availableOption[]={"Available","Occupied"} ;
         availableCombo =new JComboBox<>(availableOption);
        availableCombo.setBounds(200,130,150,30);
        availableCombo.setBackground(Color.WHITE);
        add(availableCombo);

        cleanSta = new JLabel("Cleaning Status");
        cleanSta.setFont(new Font("Tahoma", Font.PLAIN, 16));
        cleanSta.setBounds(60, 180, 120, 30);
	    add(cleanSta);

        String cleanOption[]={"Cleaned","Dirty"} ;
         cleanCombo =new JComboBox<>(cleanOption);
         cleanCombo.setBounds(200,180,150,30);
         cleanCombo.setBackground(Color.WHITE);
        add(cleanCombo);

        roomPrice = new JLabel("Price");
        roomPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
        roomPrice.setBounds(60, 230, 120, 30);
	    add(roomPrice);

        price=new JTextField();
        price.setBounds(200,230,150,30);
        add(price);

        bedType = new JLabel("Bed Type");
        bedType.setFont(new Font("Tahoma", Font.PLAIN, 16));
        bedType.setBounds(60, 280, 120, 30);
	    add(bedType);

        String typeOption[]={"Single Bed","Double Bed"} ;
         typeCombo =new JComboBox<>(typeOption);
         typeCombo.setBounds(200,280,150,30);
         typeCombo.setBackground(Color.WHITE);
        add(typeCombo);

        Add =new JButton("Add Room");
        Add.setForeground(Color.WHITE);
        Add.setBackground(Color.BLACK);
        Add.addActionListener(this);
        Add.setBounds(60,350,130,30);
        add(Add);

        cancel =new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.addActionListener(this);
        cancel.setBounds(220,350,130,30);
        add(cancel);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("twelve.jpg"));
        image= new JLabel(i1);
        image.setBounds(400,30,500,300);
        add(image);

        setBounds(260,170,940,470);
        setVisible(true);

    }
    
    public void actionPerformed(ActionEvent ae) {
      if (ae.getSource()==Add) {
        String roomnumber=room.getText();
        String availability=(String) availableCombo.getSelectedItem();
        String status = (String) cleanCombo.getSelectedItem();
        String price1 = price.getText();
        String type =(String) typeCombo.getSelectedItem();
        try {
            String str = "\nINSERT Into room values( '"+roomnumber+"', '"+availability+"', '"+status+"','"+price1+"', '"+type+"')\n";
            FileWriter datafile= new FileWriter("addRooms.txt",true);
            datafile.write(str);
            
            datafile.close();

            JOptionPane.showMessageDialog(null, "New Room Successfully Added");
                this.setVisible(false);
        } catch (Exception e) {
            System.out.println(e);
        }
      }else{
        setVisible(false);
      }
    }
}
