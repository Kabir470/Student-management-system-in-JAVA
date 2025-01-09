import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class adminCreateProfile extends JFrame implements ActionListener {

    JTextField  adminUserIDfield;
    JPasswordField adminPassField;
    JButton confirmCreate,clearBox;
    JRadioButtonMenuItem showpass;
    adminCreateProfile(){

        setLayout(null);
        setTitle("Student Database Management System");
        setResizable(false);

        JLabel username = new JLabel("Username/ID:");
        username.setFont(new Font("Raleway",Font.BOLD, 16));
        username.setBounds(100, 170, 200, 40 );
        add(username);

        Random ran= new Random();
        long random= Math.abs((ran.nextLong()%90000000L)+100000L);

        adminUserIDfield = new JTextField("A"+random);
        adminUserIDfield.setBounds(250, 175, 231, 30);
        adminUserIDfield.setFont(new Font("Arial",Font.BOLD,14));
        adminUserIDfield.setEditable(false);
        add(adminUserIDfield);

        JLabel pass = new JLabel("Password: ");
        pass.setFont(new Font("Raleway",Font.BOLD, 16));
        pass.setBounds(100, 210, 200, 40 );
        add(pass);

        adminPassField = new JPasswordField();
        adminPassField.setBounds(250, 215, 231, 30);
        adminPassField.setFont(new Font("Arial", Font.BOLD,14));
        add(adminPassField);

        JLabel text = new JLabel("Create Admin Profile");
        text.setFont(new Font("Osward",Font.BOLD, 36));
        text.setBounds(120, 63, 500, 60 );
        add(text);

        getContentPane().setBackground(Color.white);
        setSize(600,500);
        setVisible(true);
        setLocation(350,50);


        showpass= new JRadioButtonMenuItem("Show Password");
        showpass.setBounds(247, 250,150,20);
        showpass.setBackground(Color.WHITE);
        showpass.setForeground(Color.BLACK);
        showpass.addActionListener(this);
        add(showpass);

        confirmCreate = new JButton("Confirm");
        confirmCreate.setBounds(250, 300,100, 30);
        confirmCreate.addActionListener(this);
        add(confirmCreate);

        clearBox = new JButton("CLEAR");
        clearBox.setBounds(380, 300,100, 30);
        clearBox.addActionListener(this);
        add(clearBox);




    }
    public void actionPerformed(ActionEvent ae){
        String Admin_User_ID= adminUserIDfield.getText();
        String Admin_Password= adminPassField.getText();

        if(ae.getSource()==clearBox)
        {
            adminPassField.setText(null);
        }
        if(ae.getSource()==showpass) {
            if (showpass.isSelected()) {
                adminPassField.setEchoChar((char) 0);
            }
            else {
                adminPassField.setEchoChar('\u2022');
            }
        }
        if(ae.getSource()== confirmCreate){
            try {
                if (adminPassField.equals("")) {
                    JOptionPane.showMessageDialog(null,"Password is required");
                }
                else
                {
                    cnction c = new cnction();
                    String query = "insert into adminCreateProfile values('" + Admin_User_ID + "','" + Admin_Password + "')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Admin Profile Created Successfully");
                }
            }
            catch (Exception e){
                System.out.println(e);
            }
        }


    }
    public static void main(String[] args){
        new adminCreateProfile();
    }
}
