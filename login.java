package Employeee;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class login  implements ActionListener{

    JFrame f;
    JLabel l1,l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2;

    login(){

        f=new JFrame("Login");

        f.setBackground(Color.white);
        f.setLayout(null);

        l1 = new JLabel("Username");
        l1.setBounds(200,50,100,36);
        l1.setForeground(Color.white);
        f.add(l1);
        
        l2 = new JLabel("Password");
        l2.setBounds(200,100,100,36);
        l2.setForeground(Color.white);
        f.add(l2);
 
        t1=new JTextField();
        t1.setBounds(300,50,150,30);
        f.add(t1);

        t2=new JPasswordField();
        t2.setBounds(300,100,150,30);
        f.add(t2);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("Employeee/icons/log1.jpg"));
        JLabel l4 = new JLabel(i4);
        l4.setBounds(0,0,200,200);
        f.add(l4);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Employeee/icons/login.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,600,300);
        f.add(l3);
        
       
        b1 = new JButton("Login");
        b1.setBounds(200,170,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        f.add(b1);

        b2=new JButton("Cancel");
        b2.setBounds(340,170,120,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        f.add(b2);

        b2.addActionListener(this);
        
        f.getContentPane().setBackground(Color.WHITE);

        f.setVisible(true);
        f.setSize(600,300);
        f.setLocation(400,300);

    }

    public void actionPerformed(ActionEvent ae){
    	
    	if(ae.getSource()==b2){
            f.setVisible(false);
            new Front_Page();
        }
    	

        try{
            conn c1 = new conn();
            String u = t1.getText();
            String v = t2.getText();
            
            String q = "select * from login where username='"+u+"' and password='"+v+"'";
            
            ResultSet rs = c1.s.executeQuery(q); 
            if(rs.next()){
                new details().f.setVisible(true);
                f.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(null, "Invalid login");
                f.setVisible(false);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] arg){
        login l=new login();
    }
}