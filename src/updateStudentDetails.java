import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.*;
import java.sql.ResultSet;
import java.util.Scanner;

public class updateStudentDetails extends JFrame implements ActionListener {

    JLabel IDfieldlabel;
    JButton cancel, update;
    JTextField maritalField,birthcerfield,namefield, fnamefield, mnamefield, nationalfield, presentaddfield, IDfield, perphonefield, emerphonefield, emailfield, bloodfield;
    JRadioButton male,married,unmarried, female;
    JDateChooser addDate,dateChooser;
    Choice IDno;
    long currentID;

    public updateStudentDetails() {
        setLayout(null);
        setResizable(false);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setSize(800, 650);
        setLocation(250, 10);
        setVisible(true);

        JLabel formno = new JLabel("Update Student Details");
        formno.setFont(new Font("Arial", Font.BOLD, 20));
        formno.setBounds(290, 20, 600, 40);
        add(formno);

        JLabel name = new JLabel("Name: ");
        name.setFont(new Font("Arial", Font.BOLD, 13));
        name.setBounds(40, 120, 100, 30);
        add(name);

        JLabel namefieldlabel = new JLabel();
        namefieldlabel.setBounds(185, 125, 200, 22);
        namefieldlabel.setFont(new Font("tahoma", Font.PLAIN, 13));
        add(namefieldlabel);

        JLabel bloodgroup = new JLabel("Blood group: ");
        bloodgroup.setFont(new Font("Arial", Font.BOLD, 13));
        bloodgroup.setBounds(410, 120, 100, 30);
        add(bloodgroup);

        JLabel bloodfieldlabel = new JLabel();
        bloodfieldlabel.setBounds(550, 125, 200, 22);
        bloodfieldlabel.setFont(new Font("tahoma", Font.PLAIN, 13));
        add(bloodfieldlabel);

        JLabel fathername = new JLabel("Father's name: ");
        fathername.setFont(new Font("Arial", Font.BOLD, 13));
        fathername.setBounds(40, 160, 100, 30);
        add(fathername);

        JLabel fnamefieldlabel = new JLabel();
        fnamefieldlabel.setBounds(185, 165, 200, 22);
        fnamefieldlabel.setFont(new Font("tahoma", Font.PLAIN, 13));
        add(fnamefieldlabel);

        JLabel father_occup= new JLabel("Father's occupation: ");
        father_occup.setFont(new Font("Arial", Font.BOLD,13));
        father_occup.setBounds(410,160,200,30);
        add(father_occup);

        JLabel focclabel= new JLabel();
        focclabel.setBounds(550,160,200,22);
        focclabel.setFont(new Font("tahoma",Font.PLAIN,13));
        focclabel.setBackground(Color.LIGHT_GRAY);
        focclabel.setForeground(Color.BLACK);
        add(focclabel);

        JLabel mname = new JLabel("Mother's name: ");
        mname.setFont(new Font("Arial", Font.BOLD, 13));
        mname.setBounds(40, 200, 200, 30);
        add(mname);

        JLabel mnamefieldlabel = new JLabel();
        mnamefieldlabel.setBounds(185, 200, 200, 22);
        mnamefieldlabel.setFont(new Font("tahoma", Font.PLAIN, 12));
        add(mnamefieldlabel);

        JLabel religion= new JLabel("Religion: ");
        religion.setFont(new Font("Arial", Font.BOLD,13));
        religion.setBounds(410,200,200,30);
        add(religion);

       JLabel religioncombolabel= new JLabel();
        religioncombolabel.setBounds(550,205,200,22);
        religioncombolabel.setFont(new Font("tahoma",Font.PLAIN,12));
        add(religioncombolabel);

        JLabel birth = new JLabel("Date Of Birth: ");
        birth.setFont(new Font("Arial", Font.BOLD, 13));
        birth.setBounds(40, 240, 100, 30);
        add(birth);

        JLabel dateChooserlabel = new JLabel();
        dateChooserlabel.setBounds(185, 245, 200, 22);
        dateChooserlabel.setFont(new Font("tahoma",Font.PLAIN,12));
        add(dateChooserlabel);

        JLabel addmdate= new JLabel("Admission date: ");
        addmdate.setFont(new Font("Arial", Font.BOLD,13));
        addmdate.setBounds(410,240,200,30);
        add(addmdate);

        JLabel addDatelabel= new JLabel();
        addDatelabel.setBounds(550,240,200,22);
        addDatelabel.setFont(new Font("tahoma",Font.PLAIN,12));
        add(addDatelabel);

        JLabel gender = new JLabel("Gender: ");
        gender.setFont(new Font("Arial", Font.BOLD, 13));
        gender.setBounds(40, 280, 100, 30);
        add(gender);

        JLabel gndr = new JLabel();
        gndr.setBounds(185, 280, 70, 30);
        gndr.setFont(new Font("tahoma",Font.PLAIN,12));
        add(gndr);


        JLabel marital= new JLabel("Marital status: ");
        marital.setFont(new Font("Arial", Font.BOLD,13));
        marital.setBounds(40,320,100,30);
        add(marital);

        JLabel mrtl= new JLabel();
        mrtl.setFont(new Font("tahoma", Font.PLAIN,13));
        mrtl.setBounds(185,320,200,22);
        add(mrtl);


        JLabel Nationality = new JLabel("Nationality: ");
        Nationality.setFont(new Font("Arial", Font.BOLD, 13));
        Nationality.setBounds(410, 280, 100, 30);
        add(Nationality);

        JLabel nationalfieldlabel = new JLabel();
        nationalfieldlabel.setBounds(550, 285, 200, 22);
        nationalfieldlabel.setFont(new Font("tahoma", Font.PLAIN, 12));
        add(nationalfieldlabel);

        JLabel presadd = new JLabel("Present address: ");
        presadd.setFont(new Font("Arial", Font.BOLD, 13));
        presadd.setBounds(40, 360, 200, 30);
        add(presadd);

        presentaddfield = new JTextField();
        presentaddfield.setBounds(185, 365, 565, 22);
        presentaddfield.setFont(new Font("tahoma", Font.PLAIN, 12));
        add(presentaddfield);

        JLabel ID = new JLabel("ID: ");
        ID.setFont(new Font("Arial", Font.BOLD, 13));
        ID.setBounds(40, 400, 200, 30);
        add(ID);

        IDfieldlabel = new JLabel();
        IDfieldlabel.setBounds(185, 405, 200, 22);
        IDfieldlabel.setFont(new Font("tahoma", Font.PLAIN, 12));
        //IDfieldlabel.setEditable(false);
        add(IDfieldlabel);

        JLabel perphone = new JLabel("Personal phone no: ");
        perphone.setFont(new Font("Arial", Font.BOLD, 13));
        perphone.setBounds(40, 440, 200, 30);
        add(perphone);

        perphonefield = new JTextField();
        perphonefield.setBounds(185, 445, 200, 22);
        perphonefield.setFont(new Font("tahoma", Font.PLAIN, 12));
        add(perphonefield);

        JLabel birthcertificate= new JLabel("Birth cer/NID no: ");
        birthcertificate.setFont(new Font("Arial", Font.BOLD,13));
        birthcertificate.setBounds(410,440,200,30);
        add(birthcertificate);



        JLabel birthcerfieldlabel= new JLabel();
        birthcerfieldlabel.setBounds(550,445,200,22);
        birthcerfieldlabel.setFont(new Font("tahoma",Font.PLAIN,12));
        add(birthcerfieldlabel);


        JLabel emerphone = new JLabel("Emergency phone no: ");
        emerphone.setFont(new Font("Arial", Font.BOLD, 13));
        emerphone.setBounds(410, 320, 200, 30);
        add(emerphone);

        emerphonefield = new JTextField();
        emerphonefield.setBounds(550, 325, 200, 22);
        emerphonefield.setFont(new Font("tahoma", Font.PLAIN, 12));
        add(emerphonefield);

        JLabel email = new JLabel("Email address: ");
        email.setFont(new Font("Arial", Font.BOLD, 13));
        email.setBounds(410, 400, 200, 30);
        add(email);

        emailfield = new JTextField();
        emailfield.setBounds(550, 405, 200, 22);
        emailfield.setFont(new Font("tahoma", Font.PLAIN, 12));
        add(emailfield);

        JLabel studentsearchbox = new JLabel("Enter the ID:");
        studentsearchbox.setBounds(250, 60, 80, 30);
        studentsearchbox.setFont(new Font("Arial", Font.BOLD, 13));
        add(studentsearchbox);

        IDno= new Choice();
        IDno.setBounds(350, 65, 150, 30);
        add(IDno);

        try
        {
            cnction cnn=new cnction();
            ResultSet rs= cnn.s.executeQuery("select * from SignUp");
            while (rs.next()){
                IDno.add(rs.getString("ID"));
            }
        }catch (Exception e){
            System.out.println(e);
        }

        IDno.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                try{
                    cnction c= new cnction();
                    String query= "select * from SignUp where ID='"+IDno.getSelectedItem()+"' ";
                    ResultSet rs= c.s.executeQuery(query);
                    while(rs.next()){
                        namefieldlabel.setText(rs.getString("name"));
                        fnamefieldlabel.setText(rs.getString("father_name"));
                        mnamefieldlabel.setText(rs.getString("mother_name"));
                        dateChooserlabel.setText(rs.getString("DoB"));
                        presentaddfield.setText(rs.getString("present_add"));
                        IDfieldlabel.setText(rs.getString("ID"));
                        perphonefield.setText(rs.getString("personal_phone"));
                        bloodfieldlabel.setText(rs.getString("blood_group"));
                        focclabel.setText(rs.getString("father_occupation"));
                        addDatelabel.setText(rs.getString("admission_date"));
                        nationalfieldlabel.setText(rs.getString("nationality"));
                        emerphonefield.setText(rs.getString("emergency_phone"));
                        emailfield.setText(rs.getString("email"));
                        birthcerfieldlabel.setText(rs.getString("birth_cer_or_NID"));
                        religioncombolabel.setText(rs.getString("religion"));
                        gndr.setText(rs.getString("gender"));
                        mrtl.setText(rs.getString("marital_status"));
                    }
                }catch(Exception e){
                    System.out.println(e);
                }
            }
        });



        update= new JButton("Update");
        update.setBounds(630, 530, 120, 30);
        update.setFont(new Font("Arial", Font.BOLD, 13));
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        update.addActionListener(this);
        add(update);

        cancel = new JButton("Cancel");
        cancel.setBounds(40, 530, 120, 30);
        cancel.setFont(new Font("Arial", Font.BOLD, 13));
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);






    }

    public void actionPerformed(ActionEvent ae) {
        String ID= IDfieldlabel.getText();
        String present_add = presentaddfield.getText();
        String personal_phone = perphonefield.getText();
        String emergency_phone = emerphonefield.getText();

        String email = emailfield.getText();


        if (ae.getSource() == cancel) {
            setVisible(false);
        } else {

            try {
                if (present_add.equals("")) {
                    JOptionPane.showMessageDialog(null, "Present address is required");
                } else if (personal_phone.equals("")) {
                    JOptionPane.showMessageDialog(null, "Personal phone no is required");
                } else if (emergency_phone.equals("")) {
                    JOptionPane.showMessageDialog(null, "Emergency phone no is required");
                } else if (email.equals("")) {
                    JOptionPane.showMessageDialog(null, "Email is required");
                } else {
                    cnction c = new cnction();
                    String query = "update SignUp set present_add= '" + present_add + "',personal_phone= '" + personal_phone + "', emergency_phone='" + emergency_phone + "',email='" + email + "' where ID= '"+ID+"'";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Student details has been updated successfully");
                    setVisible(false);
                }


            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }


    public static void main(String[] args) {
        new updateStudentDetails();
    }
}
