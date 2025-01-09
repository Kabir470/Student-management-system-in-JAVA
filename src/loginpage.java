import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginpage extends JFrame implements ActionListener {

    JButton admin,student,back;
    loginpage(){

        setLayout(null);

        setSize(400,300);setLocation(400,100);
        setBackground(Color.LIGHT_GRAY);
        setVisible(true);
        setResizable(false);

        JLabel login_page= new JLabel("Login page");
        login_page.setBounds(116,30,300,40);
        login_page.setFont(new Font("Arial",Font.BOLD,28));
        login_page.setForeground(Color.BLUE);
        add(login_page);

        JLabel welcome= new JLabel("Please select the panel");
        welcome.setBounds(90,90,300,30);
        welcome.setFont(new Font("Arial",Font.BOLD,18));
        welcome.setForeground(Color.BLACK);
        add(welcome);


         admin= new JButton("Admin login");
        admin.setBounds(62,130,120,30);
        admin.addActionListener(this);
        add(admin);

         student= new JButton("Student login");
        student.setBounds(205,130,120,30);
        student.addActionListener(this);
        add(student);

         back= new JButton("Back");
        back.setBounds(133,170,120,30);
        back.addActionListener(this);
        add(back);


    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Login().setVisible(true);
        }
        if(ae.getSource()==admin){
            setVisible(false);
            new adminLogin().setVisible(true);
        }
        if(ae.getSource()==student)
        {
            setVisible(false);
            new studentLogin().setVisible(true);
        }
    }
    public static void main(String[] args){
        new loginpage();
    }

}
