import com.sun.mail.imap.protocol.ID;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.IDN;

public class studentPanel extends JFrame implements ActionListener {

    JButton exit,applyleavebutton,viewpersonaldetailsbutton,feestructurebutton,viewexammarksbutton, feeformbutton;
    String userID;

    studentPanel(String userID) {

        this.userID=userID;
        setLayout(null);
        setTitle("Student Database Management System");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bg.jpg"));
        Image i2 = i1.getImage().getScaledInstance(757, 471, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("icons/edu.png"));
        Image i6 = i5.getImage().getScaledInstance(200, 207, Image.SCALE_DEFAULT);
        ImageIcon i7 = new ImageIcon(i6);
        JLabel lebel = new JLabel(i7);
        add(label);
        label.add(lebel);
        setResizable(false);

        lebel.setBounds(70, 110, 210, 210);
        getContentPane().setBackground(Color.white);
        label.setBounds(0, 0, 757, 471);
        setSize(757, 471);
        setVisible(true);
        setLocation(300, 50);

        JLabel adminpanel = new JLabel("STUDENT PANEL");
        adminpanel.setBounds(200, 10, 400, 50);
        adminpanel.setFont(new Font("quintessential", Font.BOLD, 40));
        adminpanel.setForeground(Color.WHITE);
        label.add(adminpanel);

        JLabel IDno= new JLabel("ID:"+userID);
        IDno.setBounds(300,60,200,30);
        IDno.setFont(new Font("quintessential", Font.BOLD, 14));
        IDno.setForeground(Color.WHITE);
        label.add(IDno);

        viewpersonaldetailsbutton = new JButton("View Personal Details");
        viewpersonaldetailsbutton.setBounds(380, 110, 160, 30);
        viewpersonaldetailsbutton.addActionListener(this);
        label.add(viewpersonaldetailsbutton);

        feeformbutton = new JButton("Fee Form");
        feeformbutton.setBounds(560, 110, 160, 30);
        feeformbutton.addActionListener(this);
        label.add(feeformbutton);

        applyleavebutton = new JButton("Apply for a leave");
        applyleavebutton.setBounds(470, 230, 160, 30);
        applyleavebutton.addActionListener(this);
        label.add(applyleavebutton);


        viewexammarksbutton = new JButton("View Exam Marks");
        viewexammarksbutton.setBounds(380, 170, 160, 30);
        viewexammarksbutton.addActionListener(this);
        label.add(viewexammarksbutton);


        feestructurebutton = new JButton("Fee Structure");
        feestructurebutton.setBounds(560, 170, 160, 30);
        feestructurebutton.addActionListener(this);
        label.add(feestructurebutton);


        exit = new JButton("EXIT");
        exit.setBounds(380, 290,340,30);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        label.add(exit);



    }

    public void actionPerformed(ActionEvent ae) {

        if(ae.getSource()==viewpersonaldetailsbutton){
            new viewStudentPersonalDetails(userID).setVisible(true);
        }
        else if(ae.getSource()==applyleavebutton){
            new studentApplyLeave(userID).setVisible(true);
        }
        else if(ae.getSource()==feestructurebutton){
            new feeStructure().setVisible(true);
        }
        else if (ae.getSource()==viewexammarksbutton){
            new marks(userID).setVisible(true);
        }
        else if(ae.getSource()==feeformbutton){
            new studentFeeform(userID).setVisible(true);
        }

    }

    public static void main(String[] args) {
        new studentPanel("");
    }
}
