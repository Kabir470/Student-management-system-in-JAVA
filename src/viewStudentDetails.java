import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class viewStudentDetails extends JFrame implements ActionListener{

    Choice IDno;
    JTable table;
    JButton search,print,add,update,delete,back,home;

    viewStudentDetails(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setLocation(60,20);
        setSize(1200,650);
        setResizable(false);
        setVisible(true);

        JLabel studentsearchbox = new JLabel("Search student by ID:");
        studentsearchbox.setBounds(60, 30, 140, 30);
        studentsearchbox.setFont(new Font("Arial", Font.BOLD, 13));
        add(studentsearchbox);

        IDno= new Choice();
        IDno.setBounds(210,36,200,30);
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

        table = new JTable();
        JScrollPane jsp = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jsp.setBounds(0,120,1186,490);
        add(jsp);

        try {
            cnction cnn = new cnction();
            ResultSet rs = cnn.s.executeQuery("select * from SignUp");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch (Exception e){
            System.out.println(e);
        }

        search = new JButton("Search");
        search.setBounds(60,70,80,25);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(150,70,80,25);
        print.addActionListener(this);
        add(print);

        add = new JButton("Add");
        add.setBounds(240,70,80,25);
        add.addActionListener(this);
        add(add);

        update = new JButton("Update");
        update.setBounds(330,70,80,25);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(420,70,80,25);
        back.addActionListener(this);
        add(back);

        home = new JButton("Home");
        home.setBounds(510,70,80,25);
        home.addActionListener(this);
        add(home);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search){
            String query= "select * from SignUp where ID='"+IDno.getSelectedItem()+"' ";
            try
            {
                cnction c= new cnction();
                ResultSet rs= c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch (Exception e)
            {
                System.out.println(e);
            }

        }
        if(ae.getSource()==back){
            setVisible(false);
            new viewStudentDetails().setVisible(true);
        }
        if(ae.getSource()==print){
            try{
                table.print();
            }catch (Exception e){
                System.out.println(e);
            }

        }
        if(ae.getSource()==update){
            setVisible(false);
            new updateStudentDetails().setVisible(true);
        }
        if(ae.getSource()==add){
            setVisible(false);
            new SignUp().setVisible(true);
        }
        if(ae.getSource()==home){
            setVisible(false);
        }

    }
    public static void main(String[] args){
new viewStudentDetails();
    }
}
