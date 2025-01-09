import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class studentLogin extends JFrame implements ActionListener {

    JTextField studentIDfield,studentPassField;
    JButton studentlogin,clear,home,back;
    studentLogin(){
        setLayout(null);
        setTitle("student database management system");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/uni 4.png"));
        Image i2 = i1.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel lebel= new JLabel(i3);
        add(lebel);
        setResizable(false);

        JLabel no = new JLabel("Student ID No:");
        no.setFont(new Font("Raleway",Font.BOLD, 16));
        no.setBounds(100, 200, 200, 40 );
        add(no);

        studentIDfield = new JTextField();
        studentIDfield.setBounds(250, 205, 231, 30);
        studentIDfield.setFont(new Font("Arial",Font.BOLD,14));
        add(studentIDfield);

        JLabel pass = new JLabel("Student Password: ");
        pass.setFont(new Font("Raleway",Font.BOLD, 16));
        pass.setBounds(100, 240, 200, 40 );
        add(pass);

        studentPassField = new JPasswordField();
        studentPassField.setBounds(250, 245, 231, 30);
        studentPassField.setFont(new Font("Arial", Font.BOLD,14));
        add(studentPassField);

        JLabel text = new JLabel("Student Login");
        text.setFont(new Font("Osward",Font.BOLD, 46));
        text.setBounds(220, 63, 400, 60 );
        add(text);

        getContentPane().setBackground(Color.white);
        lebel.setBounds(148,50,70,70);
        setSize(600,500);
        setVisible(true);
        setLocation(350,50);

        studentlogin = new JButton("SIGN IN");
        studentlogin.setBounds(250, 300,100, 30);;
        studentlogin.addActionListener(this);
        add(studentlogin);

        clear = new JButton("CLEAR");
        clear.setBounds(380, 300,100, 30);;
        clear.addActionListener(this);
        add(clear);

        back = new JButton("Back");
        back.setBounds(250, 350,100, 30);;
        back.addActionListener(this);
        add(back);

        home = new JButton("HOME");
        home.setBounds(380, 350,100, 30);
        home.setBackground(Color.BLACK);
        home.setForeground(Color.WHITE);
        home.addActionListener(this);
        add(home);

    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == clear) {
            studentPassField.setText(null);
            studentIDfield.setText(null);
        }
        if (ae.getSource() == back) {
            setVisible(false);
            new loginpage().setVisible(true);
        }
        if (ae.getSource() == studentlogin) {
            cnction cnc = new cnction();
            String userID = studentIDfield.getText();
            String pass = studentPassField.getText();
            String query = "select * from createProfile where UserID='" + userID + "'and password= '" + pass + "' ";
            try {
                ResultSet rs = cnc.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new studentPanel(userID).setVisible(true);
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

    }
    public static void main(String[] args){
        new studentLogin();
    }
}
