import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class viewStudentFees extends JFrame implements ActionListener{

    Choice IDno;
    JTable table;
    JButton search,print,back,home;

    viewStudentFees(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setLocation(60,20);
        setSize(1200,650);
        setResizable(false);
        setVisible(true);

        JLabel heading = new JLabel("Student's Fee Lists");
        heading.setBounds(50, 40, 400, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(heading);

        JLabel studentsearchbox = new JLabel("Search by ID:");
        studentsearchbox.setBounds(60, 90, 140, 30);
        studentsearchbox.setFont(new Font("Arial", Font.BOLD, 13));
        add(studentsearchbox);

        IDno= new Choice();
        IDno.setBounds(210,96,200,30);
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
        jsp.setBounds(0,180,1186,490);
        add(jsp);

        try {
            cnction cnn = new cnction();
            ResultSet rs = cnn.s.executeQuery("select * from feeForm");
            table.setModel(DbUtils.resultSetToTableModel(rs));

            for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
                TableColumn column = table.getColumnModel().getColumn(i);
                column.setPreferredWidth(500);
            }

        }catch (Exception e){
            System.out.println(e);
        }

        search = new JButton("Search");
        search.setBounds(60,130,80,25);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(150,130,80,25);
        print.addActionListener(this);
        add(print);


        back = new JButton("Back");
        back.setBounds(240,130,80,25);
        back.addActionListener(this);
        add(back);

        home = new JButton("HOME");
        home.setBounds(330,130,80,25);
        home.addActionListener(this);
        add(home);






    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search){
            String query= "select * from feeForm where ID='"+IDno.getSelectedItem()+"' ";
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
        if(ae.getSource()==print) {
            try {
                table.print();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
            if(ae.getSource()==back){
                setVisible(false);
                new viewStudentFees().setVisible(true);
            }
            if(ae.getSource()==home){
                setVisible(false);

            }



    }
    public static void main(String[] args){
        new viewStudentFees();
    }
}
