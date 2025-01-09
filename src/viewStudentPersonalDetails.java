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

public class viewStudentPersonalDetails extends JFrame implements ActionListener {

    JButton back, home;

    long currentID;

    String userID;
    public viewStudentPersonalDetails(String userID) {
        this.userID=userID;
        setLayout(null);
        setResizable(false);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setSize(800, 650);
        setLocation(250, 10);
        setVisible(true);

        JLabel formno = new JLabel("View Personal Details");
        formno.setFont(new Font("Arial", Font.BOLD, 20));
        formno.setBounds(290, 20, 600, 40);
        add(formno);

        JLabel name = new JLabel("Name: ");
        name.setFont(new Font("Arial", Font.BOLD, 13));
        name.setBounds(40, 120, 100, 30);
        add(name);

        JLabel namefieldlabel = new JLabel();
        namefieldlabel.setBounds(185, 120, 200, 30);
        namefieldlabel.setFont(new Font("tahoma", Font.PLAIN, 13));
        add(namefieldlabel);

        JLabel bloodgroup = new JLabel("Blood group: ");
        bloodgroup.setFont(new Font("Arial", Font.BOLD, 13));
        bloodgroup.setBounds(410, 120, 100, 30);
        add(bloodgroup);

        JLabel bloodfieldlabel = new JLabel();
        bloodfieldlabel.setBounds(550, 120, 200, 30);
        bloodfieldlabel.setFont(new Font("tahoma", Font.PLAIN, 13));
        add(bloodfieldlabel);

        JLabel fathername = new JLabel("Father's name: ");
        fathername.setFont(new Font("Arial", Font.BOLD, 13));
        fathername.setBounds(40, 160, 100, 30);
        add(fathername);

        JLabel fnamefieldlabel = new JLabel();
        fnamefieldlabel.setBounds(185, 160, 200, 30);
        fnamefieldlabel.setFont(new Font("tahoma", Font.PLAIN, 13));
        add(fnamefieldlabel);

        JLabel father_occup= new JLabel("Father's occupation: ");
        father_occup.setFont(new Font("Arial", Font.BOLD,13));
        father_occup.setBounds(410,160,200,30);
        add(father_occup);

        JLabel focclabel= new JLabel();
        focclabel.setBounds(550,160,200,30);
        focclabel.setFont(new Font("tahoma",Font.PLAIN,13));
        focclabel.setBackground(Color.LIGHT_GRAY);
        focclabel.setForeground(Color.BLACK);
        add(focclabel);

        JLabel mname = new JLabel("Mother's name: ");
        mname.setFont(new Font("Arial", Font.BOLD, 13));
        mname.setBounds(40, 200, 200, 30);
        add(mname);

        JLabel mnamefieldlabel = new JLabel();
        mnamefieldlabel.setBounds(185, 200, 200, 30);
        mnamefieldlabel.setFont(new Font("tahoma", Font.PLAIN, 13));
        add(mnamefieldlabel);

        JLabel religion= new JLabel("Religion: ");
        religion.setFont(new Font("Arial", Font.BOLD,13));
        religion.setBounds(410,200,200,30);
        add(religion);

        JLabel religioncombolabel= new JLabel();
        religioncombolabel.setBounds(550,200,200,30);
        religioncombolabel.setFont(new Font("tahoma",Font.PLAIN,13));
        add(religioncombolabel);

        JLabel birth = new JLabel("Date Of Birth: ");
        birth.setFont(new Font("Arial", Font.BOLD, 13));
        birth.setBounds(40, 240, 100, 30);
        add(birth);

        JLabel dateChooserlabel = new JLabel();
        dateChooserlabel.setBounds(185, 240, 200, 30);
        dateChooserlabel.setFont(new Font("tahoma",Font.PLAIN,13));
        add(dateChooserlabel);

        JLabel addmdate= new JLabel("Admission date: ");
        addmdate.setFont(new Font("Arial", Font.BOLD,13));
        addmdate.setBounds(410,240,200,30);
        add(addmdate);

        JLabel addDatelabel= new JLabel();
        addDatelabel.setBounds(550,240,200,30);
        addDatelabel.setFont(new Font("tahoma",Font.PLAIN,13));
        add(addDatelabel);

        JLabel gender = new JLabel("Gender: ");
        gender.setFont(new Font("Arial", Font.BOLD, 13));
        gender.setBounds(40, 280, 100, 30);
        add(gender);

        JLabel gndr = new JLabel();
        gndr.setBounds(185, 280, 70, 30);
        gndr.setFont(new Font("tahoma",Font.PLAIN,13));
        add(gndr);


        JLabel marital= new JLabel("Marital status: ");
        marital.setFont(new Font("Arial", Font.BOLD,13));
        marital.setBounds(40,320,100,30);
        add(marital);

        JLabel mrtl= new JLabel();
        mrtl.setFont(new Font("tahoma", Font.PLAIN,13));
        mrtl.setBounds(185,320,200,30);
        add(mrtl);


        JLabel Nationality = new JLabel("Nationality: ");
        Nationality.setFont(new Font("Arial", Font.BOLD, 13));
        Nationality.setBounds(410, 280, 100, 30);
        add(Nationality);

        JLabel nationalfieldlabel = new JLabel();
        nationalfieldlabel.setBounds(550, 280, 200, 30);
        nationalfieldlabel.setFont(new Font("tahoma", Font.PLAIN, 13));
        add(nationalfieldlabel);

        JLabel presadd = new JLabel("Present address: ");
        presadd.setFont(new Font("Arial", Font.BOLD, 13));
        presadd.setBounds(40, 360, 200, 30);
        add(presadd);

       JLabel presentaddfield = new JLabel();
        presentaddfield.setBounds(185, 360, 565, 30);
        presentaddfield.setFont(new Font("tahoma", Font.PLAIN, 13));
        add(presentaddfield);

        JLabel ID = new JLabel("ID: ");
        ID.setFont(new Font("Arial", Font.BOLD, 13));
        ID.setBounds(40, 400, 200, 30);
        add(ID);

        JLabel IDfieldlabel = new JLabel();
        IDfieldlabel.setBounds(185, 400, 200, 30);
        IDfieldlabel.setFont(new Font("tahoma", Font.PLAIN, 13));
        add(IDfieldlabel);

        JLabel perphone = new JLabel("Personal phone no: ");
        perphone.setFont(new Font("Arial", Font.BOLD, 13));
        perphone.setBounds(40, 440, 200, 30);
        add(perphone);

        JLabel perphonefield = new JLabel();
        perphonefield.setBounds(185, 440, 200, 30);
        perphonefield.setFont(new Font("tahoma", Font.PLAIN, 13));
        add(perphonefield);

        JLabel birthcertificate= new JLabel("Birth cer/NID no: ");
        birthcertificate.setFont(new Font("Arial", Font.BOLD,13));
        birthcertificate.setBounds(410,440,200,30);
        add(birthcertificate);



        JLabel birthcerfieldlabel= new JLabel();
        birthcerfieldlabel.setBounds(550,440,200,30);
        birthcerfieldlabel.setFont(new Font("tahoma",Font.PLAIN,13));
        add(birthcerfieldlabel);


        JLabel emerphone = new JLabel("Emergency phone no: ");
        emerphone.setFont(new Font("Arial", Font.BOLD, 13));
        emerphone.setBounds(410, 320, 200, 30);
        add(emerphone);

        JLabel emerphonefield = new JLabel();
        emerphonefield.setBounds(550, 320, 200, 30);
        emerphonefield.setFont(new Font("tahoma", Font.PLAIN, 13));
        add(emerphonefield);

        JLabel email = new JLabel("Email address: ");
        email.setFont(new Font("Arial", Font.BOLD, 13));
        email.setBounds(410, 400, 200, 30);
        add(email);

        JLabel emailfield = new JLabel();
        emailfield.setBounds(550, 400, 200, 30);
        emailfield.setFont(new Font("tahoma", Font.PLAIN, 13));
        add(emailfield);

        JLabel studentsearchbox = new JLabel("ID:");
        studentsearchbox.setBounds(333, 60, 80, 30);
        studentsearchbox.setFont(new Font("Arial", Font.BOLD, 16));
        add(studentsearchbox);

        JLabel IDno= new JLabel(userID);
        IDno.setBounds(359,60 , 150, 30);
        IDno.setFont(new Font("Arial",Font.BOLD,16));
        add(IDno);




                try{
                    cnction c= new cnction();
                    String query= "select * from SignUp where ID='"+userID+"' ";
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





        home= new JButton("Back");
        home.setBounds(630, 530, 120, 30);
        home.setFont(new Font("Arial", Font.BOLD, 13));
        home.setBackground(Color.black);
        home.setForeground(Color.white);
        home.addActionListener(this);
        add(home);

    }

    public void actionPerformed(ActionEvent ae) {
       if(ae.getSource()==home){
            setVisible(false);
        }
    }


    public static void main(String[] args) {
        new viewStudentPersonalDetails("");
    }
}
