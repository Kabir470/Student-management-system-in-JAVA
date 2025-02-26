
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class studentFeeform extends JFrame implements ActionListener {

    Choice IDno;
    JComboBox cbcourse, cbbranch, cbsemester;
    JLabel labeltotal;
    JButton update, pay, back;
    String userID;
    studentFeeform(String userID) {

        this.userID=userID;
        setSize(900, 500);
        setLocation(220, 80);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/globe.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 50, 500, 300);
        add(image);

        JLabel lblrollnumber = new JLabel("ID:");
        lblrollnumber.setBounds(40, 60, 150, 20);
        lblrollnumber.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblrollnumber);

        JLabel IDno = new JLabel(userID);
        IDno.setBounds(200, 60, 150, 20);
        IDno.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(IDno);


        JLabel lblname = new JLabel("Name");
        lblname.setBounds(40, 100, 150, 20);
        lblname.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblname);

        JLabel labelname = new JLabel();
        labelname.setBounds(200, 100, 150, 20);
        labelname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelname);

        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(40, 140, 150, 20);
        lblfname.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblfname);

        JLabel labelfname = new JLabel();
        labelfname.setBounds(200, 140, 150, 20);
        labelfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelfname);

        try {
            cnction c = new cnction();
            String query = "select * from SignUp where ID='"+userID+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("father_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

                try {
                    cnction c = new cnction();
                    String query = "select * from SignUp where ID='"+userID+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()) {
                        labelname.setText(rs.getString("name"));
                        labelfname.setText(rs.getString("father_name"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }


        JLabel lblcourse = new JLabel("Course");
        lblcourse.setBounds(40, 180, 150, 20);
        lblcourse.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblcourse);

        String course[] = {"BTech", "BBA", "Bsc", "Msc", "MBA", "MCA", "MCom", "MA", "BA"};
        cbcourse = new JComboBox(course);
        cbcourse.setBounds(200, 180, 150, 20);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse);

        JLabel lblbranch = new JLabel("Branch");
        lblbranch.setBounds(40, 220, 150, 20);
        lblbranch.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblbranch);

        String branch[] = {"Computer Science", "Electronics", "Mechanical", "Civil","Law", "IT"};
        cbbranch = new JComboBox(branch);
        cbbranch.setBounds(200, 220, 150, 20);
        cbbranch.setBackground(Color.WHITE);
        add(cbbranch);

        JLabel lblsemester = new JLabel("Semester");
        lblsemester.setBounds(40, 260, 150, 20);
        lblsemester.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblsemester);

        String semester[] = {"Semester1", "Semester2", "Semester3", "Semester4", "Semester5", "Semester6", "Semester7", "Semester8" };
        cbsemester = new JComboBox(semester);
        cbsemester.setBounds(200, 260, 150, 20);
        cbsemester.setBackground(Color.WHITE);
        add(cbsemester);

        JLabel lbltotal = new JLabel("Total Payable");
        lbltotal.setBounds(40, 300, 150, 20);
        lbltotal.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lbltotal);

        labeltotal = new JLabel();
        labeltotal.setBounds(200, 300, 150, 20);
        labeltotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labeltotal);

        update = new JButton("Update");
        update.setBounds(30, 380, 100, 25);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        pay = new JButton("Pay Fee");
        pay.setBounds(150, 380, 100, 25);
        pay.setBackground(Color.BLACK);
        pay.setForeground(Color.WHITE);
        pay.addActionListener(this);
        pay.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(pay);

        back = new JButton("Back");
        back.setBounds(270, 380, 100, 25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(back);

        setVisible(true);
    }

   public void actionPerformed(ActionEvent ae) {
       String ID = userID;

       if (ae.getSource() == update) {
        String course = (String) cbcourse.getSelectedItem();
        String semester = (String) cbsemester.getSelectedItem();
        String branch = (String) cbbranch.getSelectedItem();
        if(ID=="") {
            JOptionPane.showMessageDialog(null, "ID not found");
        }else {
            try {
                cnction c = new cnction();
                ResultSet rs = c.s.executeQuery("SELECT fee_amount FROM fee WHERE course = '" + course + "' AND semester = '" + semester + "' AND branch = '" + branch + "'");
                if (rs.next()) {
                    labeltotal.setText(rs.getString("fee_amount"));
                } else {
                    labeltotal.setText("Fee not found");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    } else if (ae.getSource() == pay) {
        //String ID = userID;
        String course = (String) cbcourse.getSelectedItem();
        String semester = (String) cbsemester.getSelectedItem();
        String branch = (String) cbbranch.getSelectedItem();
        String total = labeltotal.getText();
        if(ID=="") {
            JOptionPane.showMessageDialog(null, "ID not found");
        }else {
            try {
                cnction c = new cnction();
                String query = "INSERT INTO feeForm (ID, course, branch, semester, total) VALUES ('" + ID + "', '" + course + "', '" + branch + "', '" + semester + "', '" + total + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "College fee submitted successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    } else {
        setVisible(false);
    }
}

    public static void main(String[] args) {
        new studentFeeform("");
    }
}