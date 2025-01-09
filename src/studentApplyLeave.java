import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

public class studentApplyLeave extends JFrame implements ActionListener {

    JLabel IDno;
    Choice ctime;
    JDateChooser dcdate;
    JButton submit, cancel;
    String userID;

    studentApplyLeave(String userID) {
        this.userID = userID;

        setSize(500, 550);
        setLocation(400, 100);
        setLayout(null);
        setResizable(false);

        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Apply Leave (Student)");
        heading.setBounds(40, 50, 300, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);

        JLabel lblrollno = new JLabel("Search by Roll Number");
        lblrollno.setBounds(60, 100, 200, 20);
        lblrollno.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(lblrollno);

        IDno = new JLabel(userID);
        IDno.setFont(new Font("Tahoma", Font.PLAIN, 18));
        IDno.setBounds(60, 130, 200, 30);
        add(IDno);

        JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(60, 180, 200, 30);
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lbldate);

        dcdate = new JDateChooser();
        dcdate.setBounds(60, 210, 200, 25);
        add(dcdate);

        JLabel lbltime = new JLabel("Time Duration");
        lbltime.setBounds(60, 260, 200, 20);
        lbltime.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lbltime);

        ctime = new Choice();
        ctime.setBounds(60, 290, 200, 20);
        ctime.add("Full Day");
        ctime.add("Half Day");
        add(ctime);

        submit = new JButton("Submit");
        submit.setBounds(60, 350, 100, 25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(200, 350, 100, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == submit) {
            String ID = IDno.getText();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(dcdate.getDate());
            String duration = ctime.getSelectedItem();

            String query = "insert into studentLeave values('" + ID + "', '" + date + "', '" + duration + "')";

            try {
                if (date.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Date is required");
                }
                else if(ID.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "ID is required");
                }
                else {
                    cnction c = new cnction();
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Leave Confirmed");
                    setVisible(false);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new studentApplyLeave("");
    }
}