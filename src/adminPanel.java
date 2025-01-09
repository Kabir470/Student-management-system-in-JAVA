import javax.accessibility.AccessibleIcon;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class adminPanel extends JFrame implements ActionListener {

    JButton exit,studentleaveButton,addstudent,feestructurebutton,examdetailsbutton, viewstudent,updatestudentbutton;
    JMenuItem studentlv,leavedetails,feeform,viewfeestructure,viewstudentfees,entermarks,viewmark;

    adminPanel() {
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

        JLabel adminpanel = new JLabel("ADMIN PANEL");
        adminpanel.setBounds(205, 30, 400, 50);
        adminpanel.setFont(new Font("quintessential", Font.BOLD, 46));
        adminpanel.setForeground(Color.WHITE);
        label.add(adminpanel);

        addstudent = new JButton("Add Student");
        addstudent.setBounds(380, 110, 160, 30);
        addstudent.addActionListener(this);
        label.add(addstudent);

        viewstudent = new JButton("View Student details");
        viewstudent.setBounds(560, 110, 160, 30);
        viewstudent.addActionListener(this);
        label.add(viewstudent);

        JPopupMenu studentleave = new JPopupMenu();
        leavedetails = new JMenuItem("Leave Details");
        leavedetails.addActionListener(this);
        studentleave.add(leavedetails);

        studentlv = new JMenuItem("Apply Student Leave");
        studentlv.addActionListener(this);
        studentleave.add(studentlv);

         studentleaveButton = new JButton("Student Leave");
        studentleaveButton.setBounds(470, 280, 160, 30);
        studentleaveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                studentleave.show(studentleaveButton, studentleaveButton.getWidth() / 2, studentleaveButton.getHeight() / 2);
            }
        });
        label.add(studentleaveButton);

        JPopupMenu examdetails= new JPopupMenu();
        entermarks= new JMenuItem("Enter Marks");
        entermarks.addActionListener(this);
        examdetails.add(entermarks);

         viewmark= new JMenuItem("View Marks");
         viewmark.addActionListener(this);
        examdetails.add(viewmark);


        examdetailsbutton = new JButton("Examination Details");
        examdetailsbutton.setBounds(380, 210, 160, 30);
        examdetailsbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                examdetails.show(examdetailsbutton,examdetailsbutton.getWidth()/2,examdetailsbutton.getHeight()/2);
            }
        });
        label.add(examdetailsbutton);

        JPopupMenu fee= new JPopupMenu();
         viewfeestructure = new JMenuItem("View Fee Structure");
         viewfeestructure.addActionListener(this);
        fee.add(viewfeestructure);

         feeform= new JMenuItem("Fee Form");
         feeform.addActionListener(this);
        fee.add(feeform);

         viewstudentfees= new JMenuItem("view Student Fees");
         viewstudentfees.addActionListener(this);
        fee.add(viewstudentfees);

        feestructurebutton = new JButton("Fee Structure");
        feestructurebutton.setBounds(560, 210, 160, 30);
        feestructurebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fee.show(feestructurebutton,feestructurebutton.getWidth()/2,feestructurebutton.getHeight()/2);
            }
        });
        label.add(feestructurebutton);



        updatestudentbutton = new JButton("Update Student");
        updatestudentbutton.setBounds(470, 160,160,30);
        updatestudentbutton.addActionListener(this);
        label.add(updatestudentbutton);

        exit = new JButton("EXIT");
        exit.setBounds(380, 340,340,30);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        label.add(exit);



    }

    public void actionPerformed(ActionEvent ae) {
            if(ae.getSource()==addstudent){
                new SignUp().setVisible(true);
            }
            else if(ae.getSource()==viewstudent){
                new viewStudentDetails().setVisible(true);
            }
            else if(ae.getSource()==updatestudentbutton){
                new updateStudentDetails().setVisible(true);
            }
            else if(ae.getSource()==studentlv){
                new studentLeave().setVisible(true);
            }
            else if (ae.getSource()==leavedetails){
                new leaveDetails().setVisible(true);
            }
            else if (ae.getSource()==feeform){
                new feeForm().setVisible(true);
            }
            else if(ae.getSource()==viewfeestructure){
                new feeStructure().setVisible(true);
            }
            else if(ae.getSource()==viewstudentfees){
                new viewStudentFees().setVisible(true);
            }
            else if(ae.getSource()==entermarks){
                new enterStudentMarks().setVisible(true);
            }
            else if(ae.getSource()==viewmark){
                new viewStudentMarks().setVisible(true);
            }
    }

    public static void main(String[] args) {
        new adminPanel();
    }
}
