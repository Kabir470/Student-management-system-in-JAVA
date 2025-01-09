import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class marks extends JFrame implements ActionListener {

    String userID;
    JComboBox cbsemester;
    JButton cancel;
    Choice semesterno;

    marks(String userID) {
        this.userID = userID;

        setSize(500, 600);
        setLocation(380, 60);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Student Mark Sheet");
        heading.setBounds(150, 40, 500, 25);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);

        JLabel lblrollno = new JLabel("ID: " + userID);
        lblrollno.setBounds(60, 100, 500, 20);
        lblrollno.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblrollno);

        JLabel lblsemester = new JLabel("Semester: ");
        lblsemester.setBounds(60, 130, 500, 20);
        lblsemester.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblsemester);

//        String semester[] = {"1st Semester", "2nd Semester", "3rd Semester", "4th Semester", "5th Semester", "6th Semester", "7th Semester", "8th Semester" };
//        cbsemester = new JComboBox(semester);
//        cbsemester.setBounds(150, 130, 120, 20);
//        cbsemester.setBackground(Color.WHITE);
//        add(cbsemester);

        semesterno = new Choice();
        semesterno.setBounds(150, 130, 120, 20);
        add(semesterno);
        try
        {
            cnction cnn=new cnction();
            ResultSet rs= cnn.s.executeQuery("select * from marks");
            while (rs.next()){
                semesterno.add(rs.getString("semester"));
            }
        }catch (Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null,"Error: "+e);
        }

        JLabel sub1 = new JLabel();
        sub1.setBounds(100, 200, 500, 20);
        sub1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub1);

        JLabel sub2 = new JLabel();
        sub2.setBounds(100, 230, 500, 20);
        sub2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub2);

        JLabel sub3 = new JLabel();
        sub3.setBounds(100, 260, 500, 20);
        sub3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub3);

        JLabel sub4 = new JLabel();
        sub4.setBounds(100, 290, 500, 20);
        sub4.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub4);

        JLabel sub5 = new JLabel();
        sub5.setBounds(100, 320, 500, 20);
        sub5.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub5);


        try {

            cnction c = new cnction();
            ResultSet rs1 = c.s.executeQuery("select * from subject where ID = '" + userID + "' and semester = '" + semesterno.getSelectedItem() + "'");

            while (rs1.next()) {
                sub1.setText(rs1.getString("subject1"));
                sub2.setText(rs1.getString("subject2"));
                sub3.setText(rs1.getString("subject3"));
                sub4.setText(rs1.getString("subject4"));
                sub5.setText(rs1.getString("subject5"));
            }

            ResultSet rs2 = c.s.executeQuery("select * from marks where ID = '" + userID + "' and semester = '" + semesterno.getSelectedItem() + "'");
            while (rs2.next()) {
                sub1.setText(sub1.getText() + "------------" + rs2.getString("marks1"));
                sub2.setText(sub2.getText() + "------------" + rs2.getString("marks2"));
                sub3.setText(sub3.getText() + "------------" + rs2.getString("marks3"));
                sub4.setText(sub4.getText() + "------------" + rs2.getString("marks4"));
                sub5.setText(sub5.getText() + "------------" + rs2.getString("marks5"));

                //cbsemester.setText("Semester:  " + rs2.getString("semester"));
            }
//            else {
//                JLabel error = new JLabel("Marks have not been published");
//                error.setBounds(80, 270, 500, 20);
//                error.setFont(new Font("Arial",Font.BOLD,18));
//                add(error);
//            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }

        cancel = new JButton("Back");
        cancel.setBounds(180, 500, 120, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);



        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
    }

    public static void main(String[] args) {
        new marks("");  // Example ID
    }
}
