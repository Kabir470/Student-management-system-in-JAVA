import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class adminLogin extends JFrame implements ActionListener {
    
    JTextField adminIDfield,adminPassField;
    JButton home,createAdminProfile,adminlogin,adminclear,back;
    adminLogin(){
        setLayout(null);
        setTitle("student database management system");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/uni 4.png"));
        Image i2 = i1.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel lebel= new JLabel(i3);
        add(lebel);
        setResizable(false);

        JLabel no = new JLabel("Admin ID No:");
        no.setFont(new Font("Raleway",Font.BOLD, 16));
        no.setBounds(100, 170, 200, 40 );
        add(no);

        adminIDfield = new JTextField();
        adminIDfield.setBounds(250, 175, 231, 30);
        adminIDfield.setFont(new Font("Arial",Font.BOLD,14));
        add(adminIDfield);

        JLabel pass = new JLabel("Admin Password: ");
        pass.setFont(new Font("Raleway",Font.BOLD, 16));
        pass.setBounds(100, 210, 200, 40 );
        add(pass);

        adminPassField = new JPasswordField();
        adminPassField.setBounds(250, 215, 231, 30);
        adminPassField.setFont(new Font("Arial", Font.BOLD,14));
        add(adminPassField);

        JLabel text = new JLabel("Admin Login");
        text.setFont(new Font("Osward",Font.BOLD, 46));
        text.setBounds(220, 63, 400, 60 );
        add(text);

        getContentPane().setBackground(Color.white);
        lebel.setBounds(148,50,70,70);
        setSize(600,500);
        setVisible(true);
        setLocation(350,50);

        adminlogin = new JButton("SIGN IN");
        adminlogin.setBounds(250, 270,100, 30);;
        adminlogin.addActionListener(this);
        add(adminlogin);

        adminclear = new JButton("CLEAR");
        adminclear.setBounds(380, 270,100, 30);;
        adminclear.addActionListener(this);
        add(adminclear);

        back = new JButton("Back");
        back.setBounds(250, 370,100, 30);;
        back.addActionListener(this);
        add(back);

        createAdminProfile = new JButton(" Create Admin Profile");
        createAdminProfile.setBounds(250, 320,231, 30);
        createAdminProfile.setBackground(Color.DARK_GRAY);
        createAdminProfile.setForeground(Color.WHITE);
        createAdminProfile.addActionListener(this);
        add(createAdminProfile);

        home = new JButton("HOME");
        home.setBounds(380, 370,100, 30);
        home.setBackground(Color.BLACK);
        home.setForeground(Color.WHITE);
        home.addActionListener(this);
        add(home);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==adminclear)
        {
            adminPassField.setText(null);
            adminIDfield.setText(null);
        }
        if(ae.getSource()==back){
            setVisible(false);
            new loginpage().setVisible(true);
        }
        if(ae.getSource()==adminlogin){
            cnction cnc = new cnction();
            String userID = adminIDfield.getText();
            String pass = adminPassField.getText();
//            String query1= "Create database if not exist StudentManagementSystem" +"use StudentManagementSystem"+
//                    "create table if not exists adminCreateProfile(Admin_User_ID varchar(50) ,Admin_Password varchar(50))";
//            try {
//                cnc.s.executeUpdate(query1);
//            } catch (Exception e) {
//                System.out.println(e);
//            }
            String query = "select * from adminCreateProfile where Admin_User_ID='" + userID + "'and Admin_Password= '" + pass + "' ";
            try {

                ResultSet rs = cnc.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new adminPanel().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect ID or Password");
                }


            } catch (Exception e) {
                System.out.println(e);
            }
        }
        if(ae.getSource()==home){
            setVisible(false);
            new Login().setVisible(true);
        }
        if(ae.getSource()==createAdminProfile){
            setVisible(false);
            new passForAdminProfileCreate().setVisible(true);
        }

    }
    public static void main(String[] args){
        new adminLogin();
    }
}
