import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class createProfile extends JFrame implements ActionListener {

    JTextField  usernameIDfield;
    JPasswordField userPassField;
    JButton confirmCreate,clearBox;
    String ID;
    JRadioButtonMenuItem showpass;
    createProfile(String ID){
        this.ID=ID;
        setLayout(null);
        setTitle("Student Database Management System");
        setResizable(false);

        JLabel username = new JLabel("Username/ID:");
        username.setFont(new Font("Raleway",Font.BOLD, 16));
        username.setBounds(100, 170, 200, 40 );
        add(username);

        usernameIDfield = new JTextField(ID);
        usernameIDfield.setBounds(250, 175, 231, 30);
        usernameIDfield.setFont(new Font("Arial",Font.BOLD,14));
        usernameIDfield.setEditable(false);
        add(usernameIDfield);

        JLabel pass = new JLabel("Password: ");
        pass.setFont(new Font("Raleway",Font.BOLD, 16));
        pass.setBounds(100, 210, 200, 40 );
        add(pass);

        userPassField = new JPasswordField();
        userPassField.setBounds(250, 215, 231, 30);
        userPassField.setFont(new Font("Arial", Font.BOLD,14));
        add(userPassField);

        JLabel text = new JLabel("Create Student Profile");
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
        String UserID= usernameIDfield.getText();
        String password= userPassField.getText();

        if(ae.getSource()==clearBox)
        {
            userPassField.setText(null);
        }
        if(ae.getSource()==showpass) {
            if (showpass.isSelected()) {
                userPassField.setEchoChar((char) 0);
            }
            else {
                userPassField.setEchoChar('\u2022');
            }
        }
        if(ae.getSource()== confirmCreate){
            try {
                if (userPassField.equals("")) {
                    JOptionPane.showMessageDialog(null,"Password is required");
                }
                else
                {
                    cnction c = new cnction();
                    String query = "insert into createProfile values('" + UserID + "','" + password + "')";
                    c.s.executeUpdate(query);
                    setVisible(false);
                }
            }
            catch (Exception e){
                System.out.println(e);
            }
        }


    }
    public static void main(String[] args){
        new createProfile("");
    }
}
