
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class feeStructure extends JFrame {

    Choice IDno;
    JButton search,cancel;
    feeStructure() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setLocation(60,20);
        setSize(1200,650);
        setResizable(false);
        setVisible(true);

        JLabel heading = new JLabel("Fee Structure");
        heading.setBounds(50, 10, 400, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(heading);

        JButton Back = new JButton("BACK");
        Back.setBounds(60, 80,100,30);
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        add(Back);

        JTable table = new JTable();

        try {
            cnction c = new cnction();
            ResultSet rs = c.s.executeQuery("select * from fee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }


        JScrollPane jsp = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jsp.setBounds(0, 140, 1200, 700);
        add(jsp);


    }

    public static void main(String[] args) {
        new feeStructure();
    }
}