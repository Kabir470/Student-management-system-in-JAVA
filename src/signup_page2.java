
import com.mysql.cj.xdevapi.AddResultImpl;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class signup_page2 extends JFrame implements ActionListener {
 JTextField preschoolfield,gphonefield,birthcerfield;
 JRadioButton married,unmarried,notify;
 JButton confirm;
 JDateChooser dateChooser;
 JComboBox religioncombo,foccupationcombo;
String ID;
    signup_page2(String ID){
        this.ID=ID;
        setLayout(null);

        setResizable(false);
        JLabel formno= new JLabel("STUDENT APPLICATION FORM");
        formno.setFont(new Font("Arial", Font.BOLD,20));
        formno.setBounds(150,20,600,40);
        add(formno);



        JLabel personal= new JLabel("Page 2: Personal Details(ID:"+ID+")");
        personal.setFont(new Font("Arial", Font.BOLD,14));
        personal.setBounds(200,60,500,30);
        add(personal);

        JLabel additional= new JLabel("Additional information:");
        additional.setBounds(60,90,200,30);
        additional.setFont(new Font("Arial",Font.BOLD,15));
        additional.setForeground(Color.BLUE);
        add(additional);

        JLabel father_occup= new JLabel("Father occupation: ");
        father_occup.setFont(new Font("Arial", Font.BOLD,13));
        father_occup.setBounds(60,120,200,30);
        add(father_occup);

        String[] occupation ={"Govt. employee","Private employee","Businessman","Retired officer","Teacher","other"};
         foccupationcombo= new JComboBox(occupation);
        foccupationcombo.setBounds(202,125,350,22);
        foccupationcombo.setFont(new Font("Arial",Font.BOLD,12));
        add(foccupationcombo);

        JLabel marital= new JLabel("Marital status: ");
        marital.setFont(new Font("Arial", Font.BOLD,13));
        marital.setBounds(60,150,100,30);
        add(marital);

         married= new JRadioButton("Married");
        married.setBounds(202,150,80,30);
        married.setBackground(Color.LIGHT_GRAY);
        add(married);

         unmarried= new JRadioButton("Unmarried");
        unmarried.setBounds(300,150,100,30);
        unmarried.setBackground(Color.LIGHT_GRAY);
        add(unmarried);

        ButtonGroup maritalgroup= new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);

        JLabel preschool= new JLabel("Previous school name: ");
        preschool.setFont(new Font("Arial", Font.BOLD,13));
        preschool.setBounds(60,180,200,30);
        add(preschool);

         preschoolfield= new JTextField();
        preschoolfield.setBounds(202,185,350,22);
        preschoolfield.setFont(new Font("Arial",Font.BOLD,12));
        add(preschoolfield);

        JLabel gphone= new JLabel("Guardian's phone no: ");
        gphone.setFont(new Font("Arial", Font.BOLD,13));
        gphone.setBounds(60,210,200,30);
        add(gphone);

         gphonefield= new JTextField();
        gphonefield.setBounds(202,215,350,22);
        gphonefield.setFont(new Font("Arial",Font.BOLD,12));
        add(gphonefield);

        JLabel addmdate= new JLabel("Admission date: ");
        addmdate.setFont(new Font("Arial", Font.BOLD,13));
        addmdate.setBounds(60,240,200,30);
        add(addmdate);

         dateChooser= new JDateChooser();
        dateChooser.setBounds(202,245,350,22);
        dateChooser.setForeground(Color.BLACK);
        add(dateChooser);

        JLabel religion= new JLabel("Religion: ");
        religion.setFont(new Font("Arial", Font.BOLD,13));
        religion.setBounds(60,270,200,30);
        add(religion);

        String[] rel_option = {"Muslim","Hindu","Christian","Buddha","Other"};
        religioncombo= new JComboBox(rel_option);
        religioncombo.setBounds(202,275,350,22);
        religioncombo.setFont(new Font("Arial",Font.BOLD,12));
        add(religioncombo);

        JLabel birthcertificate= new JLabel("Birth cer/NID no: ");
        birthcertificate.setFont(new Font("Arial", Font.BOLD,13));
        birthcertificate.setBounds(60,300,200,30);
        add(birthcertificate);



        birthcerfield= new JTextField();
        birthcerfield.setBounds(202,305,350,22);
        birthcerfield.setFont(new Font("Arial",Font.BOLD,12));
        add(birthcerfield);

        confirm= new JButton("Next Page");
        confirm.setBounds(392, 390,160,30);
        confirm.setEnabled(false);
        confirm.addActionListener(this);
        add(confirm);


         notify= new JRadioButton("I have entered all the information correctly.");
        notify.setBounds(55,350,300,30);
        notify.setBackground(Color.lightGray);
        add(notify);

        notify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirm.setEnabled(notify.isSelected());

            }
        });

         //feedbackconfirm = new JLabel();
        //feedbackconfirm.setBounds(55, 410, 120, 30);
        //add(feedbackconfirm);


        getContentPane().setBackground(Color.LIGHT_GRAY);
        setSize(600,650);
        setLocation(350,10);
        setVisible(true);


    }

    public void actionPerformed(ActionEvent ae){
        int flag=0;
        int cnt=0;
        String father_occupation= (String) foccupationcombo.getSelectedItem();
        String religion= (String) religioncombo.getSelectedItem();
        String guardian_phone= gphonefield.getText();
        String previous_institute= preschoolfield.getText();
        String birth_cer_or_NID= birthcerfield.getText();
        String marital_status= null;
        String admission_date= ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        if(married.isSelected())
        {
            marital_status="Married";
            cnt=2;

        }
        else if(unmarried.isSelected())
        {
            marital_status= "Unmarried";
            cnt=2;
        }




        try{
            if(father_occupation.equals("")){
                JOptionPane.showMessageDialog(null,"father occupation is required");
                flag=1;
            }
            else if(cnt==0){
                JOptionPane.showMessageDialog(null,"marital status is required");
                flag=1;
            }
            else if(religion.equals("")){
                JOptionPane.showMessageDialog(null,"religion is required");
                flag=1;
            }
            else if(previous_institute.equals("")){
                JOptionPane.showMessageDialog(null,"previous institute is required");
                flag=1;
            }
            else if(marital_status.equals("")){
                JOptionPane.showMessageDialog(null,"marital status is required");
                flag=1;
            }
            else if(admission_date.equals("")){
                JOptionPane.showMessageDialog(null,"admission date is required");
                flag=1;
            }

            else if(birth_cer_or_NID.equals("")) {
                JOptionPane.showMessageDialog(null, "birth cer/NID is required");
                flag = 1;
            }
            else {
                flag=0;
                cnction c= new cnction();
                String query= "insert into signup_page2 values('"+father_occupation+"', '"+marital_status+"', '"+previous_institute+"', '"+guardian_phone+"', '"+admission_date+"', '"+religion+"', '"+birth_cer_or_NID+"')";
                c.s.executeUpdate(query);

            }




        }catch (Exception e){
            System.out.println(e);
        }
        if(ae.getSource()==confirm) {
            if (flag == 1) {
                setVisible(true);
            } else {
                setVisible(false);
                new createProfile(ID).setVisible(true);
            }
        }


    }

    public static void main(String[] args){
        new signup_page2("");
    }
}
