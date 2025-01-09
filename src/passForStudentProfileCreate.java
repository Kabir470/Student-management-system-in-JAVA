import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class passForStudentProfileCreate extends JFrame implements ActionListener {
    JButton back,enter;
    JPasswordField passwordField;
    JRadioButtonMenuItem showpass;
    String mainPassword= "12345678";

    passForStudentProfileCreate(){
        setLayout(null);

        setSize(400,300);setLocation(400,100);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        setResizable(false);

        JLabel login_page= new JLabel("Password required!");
        login_page.setBounds(70,30,300,40);
        login_page.setFont(new Font("Arial",Font.BOLD,28));
        login_page.setForeground(Color.BLUE);
        add(login_page);


        JLabel password= new JLabel("Password:");
        password.setBounds(30,100,100,30);
        password.setFont(new Font("Arial",Font.BOLD,16));
        add(password);



        passwordField= new JPasswordField();
        passwordField.setBounds(130,102,220,30);
        add(passwordField);

        showpass= new JRadioButtonMenuItem("Show Password");
        showpass.setBounds(127, 140,140,20);
        showpass.setBackground(Color.WHITE);
        showpass.setForeground(Color.BLACK);
        showpass.addActionListener(this);
        add(showpass);



        enter= new JButton("Enter");
        enter.setBounds(133,180,90,30);
        enter.addActionListener(this);
        add(enter);

        back= new JButton("Back");
        back.setBounds(240,180,90,30);
        back.addActionListener(this);
        add(back);
        passwordField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                //**easy way**
                //passwordField.setToolTipText("Enter your username or ID here.");

                //**Alternative way**
                JPopupMenu popup = new JPopupMenu();
                JMenuItem item = new JMenuItem("Enter the pass provided from Admin office.");
                popup.add(item);
                item.setFont(new Font("Arial",Font.ITALIC,10));
                popup.show(password,120,-30);
            }
        });



    }

    public void actionPerformed(ActionEvent ae){

        String spassword= new String(passwordField.getPassword());

        if(ae.getSource()==back){
            setVisible(false);
            new Login().setVisible(true);
        }
        if(ae.getSource()==showpass) {
            if (showpass.isSelected()) {
                passwordField.setEchoChar((char) 0);
            }
            else {
                passwordField.setEchoChar('\u2022');
            }
        }
        if(ae.getSource()==enter) {
            try {
                if (spassword.equals("")) {
                    JOptionPane.showMessageDialog(null, "Password is required!");
                }
                else if (!spassword.equals(mainPassword)) {
                    JOptionPane.showMessageDialog(null, "Please enter the correct password");
                } else {
                    setVisible(false);
                    new SignUp().setVisible(true);
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }
    public static void main(String[] args){
        new passForStudentProfileCreate();
    }
}

