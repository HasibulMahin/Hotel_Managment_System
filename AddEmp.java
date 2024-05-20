package Frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddEmp extends JFrame implements ActionListener{
    
    JLabel Lblname,Lblage,Lblgender,Lbljob,Lblsalaary,Lblphone,Lblemail,image;
    JTextField name1,age1,salaary1,phone1,email1;
    JRadioButton male,female;
    JButton submit;
    ImageIcon i1,i3;
    Image i2;
    ButtonGroup bg;
    @SuppressWarnings("rawtypes")
    JComboBox job;
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public AddEmp(){
        setLayout(null);

        Lblname=new JLabel("NAME");
        Lblname.setBounds(60, 30, 120, 30);
        Lblname.setFont(new Font("tahoma",Font.PLAIN,17));
        add(Lblname);

        name1=new JTextField();
        name1.setBounds(200, 30, 150,30);
        add(name1);

        Lblage=new JLabel("AGE");
        Lblage.setBounds(60, 80, 120, 30);
        Lblage.setFont(new Font("tahoma",Font.PLAIN,17));
        add(Lblage);

        age1=new JTextField();
        age1.setBounds(200, 80, 150,30);
        add(age1);

        Lblgender=new JLabel("GENDER");
        Lblgender.setBounds(60, 130, 120, 30);
        Lblgender.setFont(new Font("tahoma",Font.PLAIN,17));
        add(Lblgender);

        male=new JRadioButton("Male");
        male.setBounds(200,130,70,30);
        male.setFont(new Font("Tahoma",Font.PLAIN,14));
        male.setBackground(Color.WHITE);
        add(male);

        female=new JRadioButton("Female");
        female.setBounds(280,130,70,30);
        female.setFont(new Font("Tahoma",Font.PLAIN,14));
        female.setBackground(Color.WHITE);
        add(female);

        bg=new ButtonGroup();
        bg.add(male);
        bg.add(female);


        Lbljob=new JLabel("JOB");
        Lbljob.setBounds(60, 180, 120, 30);
        Lbljob.setFont(new Font("tahoma",Font.PLAIN,17));
        add(Lbljob);

        String str[] = {"Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Chefs","Waiter/Waitress","Manager","Accountant" };
         job = new JComboBox(str);
         job.setBounds(200,180,150,30);
         job.setBackground(Color.WHITE);
         add(job);

         Lblsalaary=new JLabel("SALAARY");
         Lblsalaary.setBounds(60, 230, 120, 30);
         Lblsalaary.setFont(new Font("tahoma",Font.PLAIN,17));
        add(Lblsalaary);

        salaary1=new JTextField();
        salaary1.setBounds(200, 230, 150,30);
        add(salaary1);

        Lblphone=new JLabel("PHONE");
        Lblphone.setBounds(60, 280, 120, 30);
        Lblphone.setFont(new Font("tahoma",Font.PLAIN,17));
        add(Lblphone);

        phone1=new JTextField();
        phone1.setBounds(200, 280, 150,30);
        add(phone1);

        Lblemail=new JLabel("EMAIL");
        Lblemail.setBounds(60, 330, 120, 30);
        Lblemail.setFont(new Font("tahoma",Font.PLAIN,17));
        add(Lblemail);

        email1=new JTextField();
        email1.setBounds(200, 330, 150,30);
        add(email1);

        submit=new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setBounds(200,390,150,30);
        add(submit);

        i1 = new ImageIcon(ClassLoader.getSystemResource("tenth.jpg"));
        i2=i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        i3=new ImageIcon(i2);
        image=new JLabel(i3);
        image.setBounds(380,60,450,370);
        add(image);





        getContentPane().setBackground(Color.WHITE);
        setBounds(300, 170, 850, 540);
        setVisible(true);


    }
    public void actionPerformed(ActionEvent ae){
        String name =name1.getText();
        String age =age1.getText();
        String salaary =salaary1.getText();
        String phone =phone1.getText();
        String email =email1.getText();

        String gender=null;
        if(male.isSelected()){
            gender="Male";
        }else if(female.isSelected()){
            gender="female";
        }
        
        String job1=(String) job.getSelectedItem();
        try {
            
            String addAll = "\nINSERT INTO employee values( '"+name+"', '"+age+"', '"+gender+"','"+job1+"',"+salaary+"', '"+phone+"','"+email+"')\n";
            FileWriter datafile= new FileWriter("data1.txt",true);
            datafile.write(addAll);
            
            datafile.close();
             JOptionPane.showMessageDialog(null,"Employee Added");
                        setVisible(false);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
        
    }
   
    

