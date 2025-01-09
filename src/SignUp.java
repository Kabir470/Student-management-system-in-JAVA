import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class SignUp extends JFrame implements ActionListener {

    JButton home, next;
    JTextField birthcerfield,namefield, fnamefield, mnamefield, nationalfield, presentaddfield, IDfield, perphonefield, emerphonefield, emailfield, bloodfield;
    JRadioButton notify,male,married,unmarried, female;
    JDateChooser addDate,dateChooser;
    JComboBox religioncombo,foccupationcombo;
    long currentID;

    public SignUp() {
        setLayout(null);
        setResizable(false);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setSize(800, 650);
        setLocation(250, 10);
        setVisible(true);

        JLabel formno = new JLabel("STUDENT APPLICATION FORM");
        formno.setFont(new Font("Arial", Font.BOLD, 20));
        formno.setBounds(210, 20, 600, 40);
        add(formno);

        JLabel personal = new JLabel("Page 1: Personal Details");
        personal.setFont(new Font("Arial", Font.BOLD, 14));
        personal.setBounds(276, 60, 400, 30);
        add(personal);

        JLabel basic = new JLabel("Basic Information");
        basic.setFont(new Font("Arial", Font.BOLD, 15));
        basic.setBounds(40, 95, 200, 30);
        basic.setForeground(Color.BLUE);
        add(basic);

        JLabel name = new JLabel("Name: ");
        name.setFont(new Font("Arial", Font.BOLD, 13));
        name.setBounds(40, 120, 100, 30);
        add(name);

        namefield = new JTextField();
        namefield.setBounds(185, 125, 200, 22);
        namefield.setFont(new Font("Arial", Font.BOLD, 12));
        add(namefield);

        JLabel bloodgroup = new JLabel("Blood group: ");
        bloodgroup.setFont(new Font("Arial", Font.BOLD, 13));
        bloodgroup.setBounds(410, 120, 100, 30);
        add(bloodgroup);

        bloodfield = new JTextField();
        bloodfield.setBounds(550, 125, 200, 22);
        bloodfield.setFont(new Font("Arial", Font.BOLD, 12));
        add(bloodfield);

        JLabel fathername = new JLabel("Father's name: ");
        fathername.setFont(new Font("Arial", Font.BOLD, 13));
        fathername.setBounds(40, 160, 100, 30);
        add(fathername);

        fnamefield = new JTextField();
        fnamefield.setBounds(185, 165, 200, 22);
        fnamefield.setFont(new Font("Arial", Font.BOLD, 12));
        add(fnamefield);

        JLabel father_occup= new JLabel("Father's occupation: ");
        father_occup.setFont(new Font("Arial", Font.BOLD,13));
        father_occup.setBounds(410,160,200,30);
        add(father_occup);

        String[] occupation ={"Govt. employee","Private employee","Businessman","Retired officer","Teacher","other"};
        foccupationcombo= new JComboBox(occupation);
        foccupationcombo.setBounds(550,165,200,22);
        foccupationcombo.setFont(new Font("Arial",Font.BOLD,12));
        add(foccupationcombo);

        JLabel mname = new JLabel("Mother's name: ");
        mname.setFont(new Font("Arial", Font.BOLD, 13));
        mname.setBounds(40, 200, 200, 30);
        add(mname);

        mnamefield = new JTextField();
        mnamefield.setBounds(185, 205, 200, 22);
        mnamefield.setFont(new Font("Arial", Font.BOLD, 12));
        add(mnamefield);

        JLabel religion= new JLabel("Religion: ");
        religion.setFont(new Font("Arial", Font.BOLD,13));
        religion.setBounds(410,200,200,30);
        add(religion);

        String[] rel_option = {"Muslim","Hindu","Christian","Buddha","Other"};
        religioncombo= new JComboBox(rel_option);
        religioncombo.setBounds(550,205,200,22);
        religioncombo.setFont(new Font("Arial",Font.BOLD,12));
        add(religioncombo);

        JLabel birth = new JLabel("Date Of Birth: ");
        birth.setFont(new Font("Arial", Font.BOLD, 13));
        birth.setBounds(40, 240, 100, 30);
        add(birth);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(185, 245, 200, 22);
        dateChooser.setForeground(Color.BLACK);
        add(dateChooser);

        JLabel addmdate= new JLabel("Admission date: ");
        addmdate.setFont(new Font("Arial", Font.BOLD,13));
        addmdate.setBounds(410,240,200,30);
        add(addmdate);

        addDate= new JDateChooser();
        addDate.setBounds(550,245,200,22);
        addDate.setForeground(Color.BLACK);
        add(addDate);

        JLabel gender = new JLabel("Gender: ");
        gender.setFont(new Font("Arial", Font.BOLD, 13));
        gender.setBounds(40, 280, 100, 30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(185, 280, 70, 30);
        male.setBackground(Color.LIGHT_GRAY);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(300, 280, 70, 30);
        female.setBackground(Color.LIGHT_GRAY);
        add(female);

        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);

        JLabel marital= new JLabel("Marital status: ");
        marital.setFont(new Font("Arial", Font.BOLD,13));
        marital.setBounds(40,320,100,30);
        add(marital);

        married= new JRadioButton("Married");
        married.setBounds(185,320,80,30);
        married.setBackground(Color.LIGHT_GRAY);
        add(married);

        unmarried= new JRadioButton("Unmarried");
        unmarried.setBounds(300,320,100,30);
        unmarried.setBackground(Color.LIGHT_GRAY);
        add(unmarried);

        ButtonGroup maritalgroup= new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);

        JLabel Nationality = new JLabel("Nationality: ");
        Nationality.setFont(new Font("Arial", Font.BOLD, 13));
        Nationality.setBounds(410, 280, 100, 30);
        add(Nationality);

        nationalfield = new JTextField();
        nationalfield.setBounds(550, 285, 200, 22);
        nationalfield.setFont(new Font("Arial", Font.BOLD, 12));
        add(nationalfield);

        JLabel presadd = new JLabel("Present address: ");
        presadd.setFont(new Font("Arial", Font.BOLD, 13));
        presadd.setBounds(40, 360, 200, 30);
        add(presadd);

        presentaddfield = new JTextField();
        presentaddfield.setBounds(185, 365, 565, 22);
        presentaddfield.setFont(new Font("Arial", Font.BOLD, 12));
        add(presentaddfield);

        JLabel ID = new JLabel("ID(available ID no): ");
        ID.setFont(new Font("Arial", Font.BOLD, 13));
        ID.setBounds(40, 400, 200, 30);
        add(ID);

        currentID = readIDFromFile();
        IDfield = new JTextField(String.valueOf(currentID));
        IDfield.setBounds(185, 405, 200, 22);
        IDfield.setFont(new Font("Arial", Font.BOLD, 12));
        IDfield.setEditable(false);
        add(IDfield);

        JLabel perphone = new JLabel("Personal phone no: ");
        perphone.setFont(new Font("Arial", Font.BOLD, 13));
        perphone.setBounds(40, 440, 200, 30);
        add(perphone);

        perphonefield = new JTextField();
        perphonefield.setBounds(185, 445, 200, 22);
        perphonefield.setFont(new Font("Arial", Font.BOLD, 12));
        add(perphonefield);

        JLabel birthcertificate= new JLabel("Birth cer/NID no: ");
        birthcertificate.setFont(new Font("Arial", Font.BOLD,13));
        birthcertificate.setBounds(410,440,200,30);
        add(birthcertificate);



        birthcerfield= new JTextField();
        birthcerfield.setBounds(550,445,200,22);
        birthcerfield.setFont(new Font("Arial",Font.BOLD,12));
        add(birthcerfield);


        JLabel emerphone = new JLabel("Emergency phone no: ");
        emerphone.setFont(new Font("Arial", Font.BOLD, 13));
        emerphone.setBounds(410, 320, 200, 30);
        add(emerphone);

        emerphonefield = new JTextField();
        emerphonefield.setBounds(550, 325, 200, 22);
        emerphonefield.setFont(new Font("Arial", Font.BOLD, 12));
        add(emerphonefield);

        JLabel email = new JLabel("Email address: ");
        email.setFont(new Font("Arial", Font.BOLD, 13));
        email.setBounds(410, 400, 200, 30);
        add(email);

        emailfield = new JTextField();
        emailfield.setBounds(550, 405, 200, 22);
        emailfield.setFont(new Font("Arial", Font.BOLD, 12));
        add(emailfield);



        next = new JButton("Next page");
        next.setBounds(630, 530, 120, 30);
        next.setFont(new Font("Arial", Font.BOLD, 13));
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.addActionListener(this);
        next.setEnabled(false);
        add(next);

        home = new JButton("HOME");
        home.setBounds(40, 530, 120, 30);
        home.setFont(new Font("Arial", Font.BOLD, 13));
        home.setBackground(Color.black);
        home.setForeground(Color.white);
        home.addActionListener(this);
        add(home);

        notify= new JRadioButton("I have entered all the information correctly.");
        notify.setBounds(45,485,400,30);
        notify.setFont(new Font("Raleway", Font.BOLD,14));
        notify.setBackground(Color.lightGray);
        add(notify);

        notify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                next.setEnabled(notify.isSelected());

            }
        });


    }

    public void actionPerformed(ActionEvent ae) {
        String nationality = nationalfield.getText();
        String present_add = presentaddfield.getText();
        String ID = IDfield.getText();
        String personal_phone = perphonefield.getText();
        String emergency_phone = emerphonefield.getText();
        String blood_group = bloodfield.getText();
        String name = namefield.getText();
        String father_name = fnamefield.getText();
        String mother_name = mnamefield.getText();
        int cnt=0;
        String father_occupation= (String) foccupationcombo.getSelectedItem();
        String religion= (String) religioncombo.getSelectedItem();
        String birth_cer_or_NID= birthcerfield.getText();
        String marital_status= null;

        String DoB = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String admission_date = ((JTextField) addDate.getDateEditor().getUiComponent()).getText();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dobDate = dateChooser.getDate();
        Date admissionDate = addDate.getDate();

        String formattedDoB = sdf.format(dobDate);
        String formattedAdmissionDate = sdf.format(admissionDate);
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
        String gender = null;

        if (male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        }

        String email = emailfield.getText();
        int flag = 0;

        if (ae.getSource() == home) {
            setVisible(false);
        } else {

            try {
                if (name.equals("")) {
                    JOptionPane.showMessageDialog(null, "Name is required");
                    flag = 1;

                }
                else if(father_occupation.equals("")){
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
                else if(admission_date.equals("")){
                    JOptionPane.showMessageDialog(null,"admission date is required");
                    flag=1;
                }

                else if(birth_cer_or_NID.equals("")) {
                    JOptionPane.showMessageDialog(null, "birth cer/NID is required");
                    flag = 1;
                }
                else if (father_name.equals("")) {
                    JOptionPane.showMessageDialog(null, "Father's name is required");
                    flag = 1;
                } else if (mother_name.equals("")) {
                    JOptionPane.showMessageDialog(null, "Mother's name is required");
                    flag = 1;
                } else if (nationality.equals("")) {
                    JOptionPane.showMessageDialog(null, "Nationality is required");
                    flag = 1;
                } else if (present_add.equals("")) {
                    JOptionPane.showMessageDialog(null, "Present address is required");
                    flag = 1;
                } else if (ID.equals("")) {
                    JOptionPane.showMessageDialog(null, "ID is required");
                    flag = 1;
                } else if (personal_phone.equals("")) {
                    JOptionPane.showMessageDialog(null, "Personal phone no is required");
                    flag = 1;
                } else if (emergency_phone.equals("")) {
                    JOptionPane.showMessageDialog(null, "Emergency phone no is required");
                    flag = 1;
                } else if (DoB.equals("")) {
                    JOptionPane.showMessageDialog(null, "Date of birth is required");
                    flag = 1;
                } else if (blood_group.equals("")) {
                    JOptionPane.showMessageDialog(null, "Blood group is required");
                    flag = 1;
                } else if (gender == null) {
                    JOptionPane.showMessageDialog(null, "Gender is required");
                    flag = 1;
                } else if (email.equals("")) {
                    JOptionPane.showMessageDialog(null, "Email is required");
                    flag = 1;
                } else {
                    cnction c = new cnction();
                    String query = "insert into SignUp values('" + ID + "','" + name + "', '" + father_name + "', '" + mother_name + "', '" + formattedDoB + "', '" + gender + "', '" + nationality + "', '" + present_add + "', '" + personal_phone + "', '" + emergency_phone + "','" + email + "', '" + blood_group + "','"+father_occupation+"', '"+marital_status+"', '"+formattedAdmissionDate+"', '"+religion+"', '"+birth_cer_or_NID+"')";
                    c.s.executeUpdate(query);

                    // Update ID for next user
                    currentID++;
                    writeIDToFile(currentID);
                }

                if (flag == 0) {
                    setVisible(false);
                    new createProfile(ID).setVisible(true);
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    private long readIDFromFile() {
        long id = 22235100000L;//starting from this ID
        try (Scanner scanner = new Scanner(new File("currentID.txt"))) {
            if (scanner.hasNextLong()) {
                id = scanner.nextLong();
            }
        } catch (FileNotFoundException e) {

        }
        return id;
    }

    private void writeIDToFile(long id) {
        try (PrintWriter writer = new PrintWriter(new File("currentID.txt"))) {
            writer.println(id);
        } catch (FileNotFoundException e) {
            System.out.println("Error writing ID to file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new SignUp();
    }
}
