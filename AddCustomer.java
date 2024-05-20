package Frame;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.sql.Date;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddCustomer extends JFrame implements ActionListener{
  
    
    JLabel text,userID,userNumber,userName,userGender,userCountry,userRoom,userTime,userChecking,userDeposite;
    JTextField number,name,country,deposite;
    JComboBox comboId,croom;
    JRadioButton rmale,rfemale;
    
    JButton add,back;

    public AddCustomer() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        text=new JLabel("NEW CUSTOMER FORM");
        text.setBounds(100,20,300,30);
        text.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(text);

        userID=new JLabel("ID");
        userID.setBounds(35,80,100,20);
        userID.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(userID);

        String options[]={"Passport","Driving License","Voter-ID Card"};
        comboId=new JComboBox<>(options);
        comboId.setBounds(200,80,150,25);
        comboId.setBackground(Color.WHITE);
        add(comboId);

        userNumber=new JLabel("Number");
        userNumber.setBounds(35,120,100,20);
        userNumber.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(userNumber);

        number=new JTextField();
        number.setBounds(200,120,150,25);
        add(number);

        userName=new JLabel("Name");
        userName.setBounds(35,160,100,20);
        userName.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(userName);

        name=new JTextField();
        name.setBounds(200,160,150,25);
        add(name);

        userGender=new JLabel("Gender");
        userGender.setBounds(35,200,100,20);
        userGender.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(userGender);

        rmale=new JRadioButton("Male");
        rmale.setBackground(Color.WHITE);
        rmale.setBounds(200,200,60,25);
        add(rmale);

        rfemale=new JRadioButton("Female");
        rfemale.setBackground(Color.WHITE);
        rfemale.setBounds(270,200,100,25);
        add(rfemale);

        userCountry=new JLabel("Country");
        userCountry.setBounds(35,240,100,20);
        userCountry.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(userCountry);

        country=new JTextField();
        country.setBounds(200,240,150,25);
        add(country);

        userRoom=new JLabel("Room Number");
        userRoom.setBounds(35,280,150,20);
        userRoom.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(userRoom);

        String[] roomtype={"101","102","103","104","105","106","107","108","109","110"};
        croom=new JComboBox<>(roomtype);
        

        /*try {
            
            String query="Select * form room";
            FileWriter datafile= new FileWriter("addRooms.txt");
            datafile.write(query);
            ResultSet rs=datafile.append(query);
        
        } catch (Exception e) {
            // TODO: handle exception
        }*/
        croom.setBounds(200,280,150,25);
        add(croom);

        userTime=new JLabel("Checking Time");
        userTime.setBounds(35,320,150,20);
        userTime.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(userTime);

        Date date=new Date(ALLBITS);

        userChecking=new JLabel(""+date);
        userChecking.setBounds(200,320,150,25);
        userChecking.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(userChecking);

        userDeposite=new JLabel("Deposite");
        userDeposite.setBounds(35,360,100,20);
        userDeposite.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(userDeposite);

        deposite=new JTextField();
        deposite.setBounds(200,360,150,25);
        add(deposite);

        add=new JButton("Add");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(50,410,120,30);
        add.addActionListener(this);
        add(add);

        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(200,410,120,30);
        back.addActionListener(this);
        add(back);

        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("fifth.png"));
                Image i3 = i1.getImage().getScaledInstance(300, 400,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l1 = new JLabel(i2);
                l1.setBounds(400,50,300,400);
                add(l1);


        setBounds(350,200,800,550);
        setVisible(true);
    }

    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==add){
            String id=(String) comboId.getSelectedItem();
            String number1=number.getText();
            String name1=name.getText();
            String gender1=null;
            String country1=country.getText();
            String room1=(String)croom.getSelectedItem();
            String time1=userChecking.getText();

            String deposite1 = deposite.getText();

            if(rmale.isSelected()){
                gender1="Male";

            }else{
                gender1="Female";
            }
            try {
                String str = "\nINSERT Into Customer values( '"+id+"', '"+number1+"', '"+name1+"','"+gender1+"', '"+country1+"','"+room1+"','"+time1+"','"+deposite1+"')";
                String str2 = "\nUpdate room set availability= 'Occupied' Where room number  = '"+room1+"'";
                FileWriter datafile= new FileWriter("addCustomer.txt",true);
            
                datafile.write(str);
                datafile.write(str2);
            
            datafile.close();
             JOptionPane.showMessageDialog(null, "New Customer Successfully Added");
                this.setVisible(false);
                new Reception();
            } catch (Exception e) {
                System.out.println(e);
            }
        }else if(ae.getSource()==back){
            this.setVisible(false);
                new Reception();
        }
       
    }
    
}
