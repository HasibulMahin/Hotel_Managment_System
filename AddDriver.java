package Frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
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

public class AddDriver extends JFrame implements ActionListener {
    JLabel heading,driverName,ageD,cleanSta,roomPrice,carModel,image,availableDriver,carComapany,location;
    Image i2;
    JTextField nameR,Company,ageR,modelC,locationD;
    JComboBox availableCombo,typeCombo,ageCombo,genderCombo;
    JButton Add,cancel;
    ImageIcon i1,i3;
     public AddDriver(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

         heading = new JLabel("Add Drivers");
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        heading.setBounds(150, 10, 200, 20);
	    add(heading);

        driverName = new JLabel("Name");
        driverName.setFont(new Font("Tahoma", Font.PLAIN, 16));
        driverName.setBounds(60, 70, 150, 30);
	    add(driverName);

        nameR=new JTextField();
        nameR.setBounds(200,70,150,30);
        add(nameR);

        ageD = new JLabel("Age");
        ageD.setFont(new Font("Tahoma", Font.PLAIN, 16));
        ageD.setBounds(60, 110, 120, 30);
	    add(ageD);

        ageR=new JTextField();
        ageR.setBounds(200,110,150,30);
        add(ageR);

        cleanSta = new JLabel("Gender");
        cleanSta.setFont(new Font("Tahoma", Font.PLAIN, 16));
        cleanSta.setBounds(60, 150, 120, 30);
	    add(cleanSta);

        String cleanOption[]={"Male","Female"} ;
         genderCombo =new JComboBox<>(cleanOption);
         genderCombo.setBounds(200,150,150,30);
         genderCombo.setBackground(Color.WHITE);
        add(genderCombo);

        carComapany = new JLabel("Car Company");
        carComapany.setFont(new Font("Tahoma", Font.PLAIN, 16));
        carComapany.setBounds(60, 190, 120, 30);
	    add(carComapany);

        Company=new JTextField();
        Company.setBounds(200,190,150,30);
        add(Company);

        carModel = new JLabel("Car Model");
        carModel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        carModel.setBounds(60, 230, 120, 30);
	    add(carModel);

        modelC=new JTextField();
        modelC.setBounds(200,230,150,30);
        add(modelC);

        availableDriver = new JLabel("Available");
        availableDriver.setFont(new Font("Tahoma", Font.PLAIN, 16));
        availableDriver.setBounds(60, 270, 120, 30);
	    add(availableDriver);
       
        String driverOption[]={"Available","Busy"} ;
        availableCombo =new JComboBox<>(driverOption);
        availableCombo.setBounds(200,270,150,30);
        availableCombo.setBackground(Color.WHITE);
        add(availableCombo);

        location = new JLabel("Location");
        location.setFont(new Font("Tahoma", Font.PLAIN, 16));
        location.setBounds(60, 310, 120, 30);
	    add(location);

        locationD=new JTextField();
        locationD.setBounds(200,310,150,30);
        add(locationD);


        Add =new JButton("Add Driver");
        Add.setForeground(Color.WHITE);
        Add.setBackground(Color.BLACK);
        Add.addActionListener(this);
        Add.setBounds(60,370,130,30);
        add(Add);

        cancel =new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.addActionListener(this);
        cancel.setBounds(220,370,130,30);
        add(cancel);

        i1=new ImageIcon(ClassLoader.getSystemResource("eleven.jpg"));
        i2=i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        i3=new ImageIcon(i2);
        image= new JLabel(i3);
        image.setBounds(420,50,500,300);
        add(image);

        setBounds(260,170,980,470);
        setVisible(true);

    }
    
    public void actionPerformed(ActionEvent ae) {
      if (ae.getSource()==Add) {
        String name=nameR.getText();
        String age=ageR.getText();
        String gender = (String) genderCombo.getSelectedItem();
        String company1 = Company.getText();
        String brand =carModel.getText();
        String available=(String) availableCombo.getSelectedItem();;
        String loction=locationD.getText();
        try {
            String driverr = "\nINSERT Into driver values( '"+name+"', '"+age+"', '"+gender+"','"+company1+"', '"+brand+"','"+available+"','"+loction+"')\n";
            FileWriter datafile= new FileWriter("addDriver.txt",true);
            datafile.write(driverr);
            
            datafile.close();

            JOptionPane.showMessageDialog(null, "New driver Successfully Added");
                this.setVisible(false);
        } catch (Exception e) {
            System.out.println(e);
        }
      }else{
        setVisible(false);
      }
    }
}

