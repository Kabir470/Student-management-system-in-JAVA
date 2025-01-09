import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {

    JButton login, exit, signUp;

    Login() {
        // Set up layout and window properties
        setLayout(null);
        setTitle("Student Database Management System");
        setResizable(false);

        // Add background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/globe.jpg"));
        Image i2 = i1.getImage().getScaledInstance(757, 471, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        add(label);
        label.setBounds(0, 0, 757, 471);

        // Set window size and location
        setSize(757, 471);
        setLocation(300, 50);
        setVisible(true);

        // Add title text
        JLabel text = new JLabel("EduMatrix");
        text.setFont(new Font("Quintessential", Font.BOLD, 46));
        text.setBounds(460, 120, 400, 40);
        label.add(text);

        // Add buttons
        login = new JButton("LOGIN");
        login.setBounds(465, 200, 80, 30);
        login.addActionListener(this);
        label.add(login);

        signUp = new JButton("Student Sign Up");
        signUp.setBounds(565, 200, 130, 30);
        signUp.addActionListener(this);
        label.add(signUp);

        exit = new JButton("EXIT");
        exit.setBounds(465, 260, 231, 30);
        exit.addActionListener(this);
        label.add(exit);

        // Create database and table
        createDatabaseAndTable();
    }

    private void createDatabaseAndTable() {
        try {
            cnction cnc = new cnction();

            // Create database
            String createDatabaseQuery = "CREATE DATABASE IF NOT EXISTS studentmanagementJAVA";
            cnc.s.executeUpdate(createDatabaseQuery);

            // Switch to the database
            String useDatabaseQuery = "USE studentmanagementJAVA";
            cnc.s.executeUpdate(useDatabaseQuery);

            // Create the table
            String adminCreateProfileQuery = """
                CREATE TABLE IF NOT EXISTS adminCreateProfile (
                    Admin_User_ID VARCHAR(50) PRIMARY KEY,
                    Admin_Password VARCHAR(50)
                );
                """;
            cnc.s.executeUpdate(adminCreateProfileQuery);

            String signupQuery = """
                    CREATE TABLE IF NOT EXISTS SignUp (
                        ID VARCHAR(50) NOT NULL PRIMARY KEY,
                        name VARCHAR(100) NOT NULL,
                        father_name VARCHAR(100) NOT NULL,
                        mother_name VARCHAR(100) NOT NULL,
                        DoB DATE NOT NULL,
                        gender VARCHAR(10) NOT NULL,
                        nationality VARCHAR(50) NOT NULL,
                        present_add VARCHAR(255) NOT NULL,
                        personal_phone VARCHAR(15) NOT NULL,
                        emergency_phone VARCHAR(15) NOT NULL,
                        email VARCHAR(100) NOT NULL,
                        blood_group VARCHAR(10) NOT NULL,
                        father_occupation VARCHAR(50) NOT NULL,
                        marital_status VARCHAR(20) NOT NULL,
                        admission_date DATE NOT NULL,
                        religion VARCHAR(50) NOT NULL,
                        birth_cer_or_NID VARCHAR(50) NOT NULL
                    );
                    """;
            cnc.s.executeUpdate(signupQuery);

            String createprofileQuery= """
                    CREATE TABLE IF NOT EXISTS createProfile (
                    UserID VARCHAR(50) PRIMARY KEY,
                    password VARCHAR(50) NOT NULL
                    );
                    
                    """;
            cnc.s.executeUpdate(createprofileQuery);

            String subjectQuery= """
                    CREATE TABLE IF NOT EXISTS subject (
                        ID VARCHAR(50) NOT NULL,
                        semester VARCHAR(20) NOT NULL,
                        subject1 VARCHAR(100) NOT NULL,
                        subject2 VARCHAR(100) NOT NULL,
                        subject3 VARCHAR(100) NOT NULL,
                        subject4 VARCHAR(100) NOT NULL,
                        subject5 VARCHAR(100) NOT NULL,
                        PRIMARY KEY (ID, semester)
                    );
                    """;
            cnc.s.executeUpdate(subjectQuery);

            String marksQuery= """
                    CREATE TABLE IF NOT EXISTS marks (
                        ID VARCHAR(50) NOT NULL,
                        semester VARCHAR(20) NOT NULL,
                        marks1 INT NOT NULL,
                        marks2 INT NOT NULL,
                        marks3 INT NOT NULL,
                        marks4 INT NOT NULL,
                        marks5 INT NOT NULL,
                        PRIMARY KEY (ID, semester)
                    );
                    """;
            cnc.s.executeUpdate(marksQuery);

            String feeQuery= """
                    CREATE TABLE IF NOT EXISTS feeForm (
                        ID VARCHAR(50) NOT NULL,
                        course VARCHAR(50) NOT NULL,
                        branch VARCHAR(50) NOT NULL,
                        semester VARCHAR(20) NOT NULL,
                        total VARCHAR(50) NOT NULL,
                        PRIMARY KEY (ID, course, semester)
                    );
                    """;
            cnc.s.executeUpdate(feeQuery);
            String feestrucureQuery= """
                    CREATE TABLE IF NOT EXISTS fee (
                        course VARCHAR(50) NOT NULL,
                        branch VARCHAR(50) NOT NULL,
                        semester VARCHAR(20) NOT NULL,
                        fee_amount VARCHAR(50) NOT NULL,
                        PRIMARY KEY (course, branch, semester)
                    );
                    """;
            cnc.s.executeUpdate(feestrucureQuery);

            String feestructureenterQuery= """
                    INSERT IGNORE INTO fee(course, branch, semester, fee_amount) VALUES
                   
                    ('BTech', 'Computer Science', 'Semester1', FLOOR(40000 + (RAND() * 30000))),
                    ('BTech', 'Computer Science', 'Semester2', FLOOR(40000 + (RAND() * 30000))),
                    ('BTech', 'Computer Science', 'Semester3', FLOOR(40000 + (RAND() * 30000))),
                    ('BTech', 'Computer Science', 'Semester4', FLOOR(40000 + (RAND() * 30000))),
                    ('BTech', 'Computer Science', 'Semester5', FLOOR(40000 + (RAND() * 30000))),
                    ('BTech', 'Computer Science', 'Semester6', FLOOR(40000 + (RAND() * 30000))),
                    ('BTech', 'Computer Science', 'Semester7', FLOOR(40000 + (RAND() * 30000))),
                    ('BTech', 'Computer Science', 'Semester8', FLOOR(40000 + (RAND() * 30000))),
                    ('BTech', 'Electronics', 'Semester1', FLOOR(40000 + (RAND() * 30000))),
                    ('BTech', 'Electronics', 'Semester2', FLOOR(40000 + (RAND() * 30000))),
                    ('BTech', 'Electronics', 'Semester3', FLOOR(40000 + (RAND() * 30000))),
                    ('BTech', 'Electronics', 'Semester4', FLOOR(40000 + (RAND() * 30000))),
                    ('BTech', 'Mechanical', 'Semester1', FLOOR(40000 + (RAND() * 30000))),
                    ('BTech', 'Mechanical', 'Semester2', FLOOR(40000 + (RAND() * 30000))),
                    ('BTech', 'Mechanical', 'Semester3', FLOOR(40000 + (RAND() * 30000))),
                    ('BTech', 'Mechanical', 'Semester4', FLOOR(40000 + (RAND() * 30000))),
                    ('BTech', 'Civil', 'Semester1', FLOOR(40000 + (RAND() * 30000))),
                    ('BTech', 'Civil', 'Semester2', FLOOR(40000 + (RAND() * 30000))),
                    ('BTech', 'Civil', 'Semester3', FLOOR(40000 + (RAND() * 30000))),
                    ('BTech', 'Civil', 'Semester4', FLOOR(40000 + (RAND() * 30000))),
                    ('BTech', 'IT', 'Semester1', FLOOR(40000 + (RAND() * 30000))),
                    ('BTech', 'IT', 'Semester2', FLOOR(40000 + (RAND() * 30000))),
                    ('BTech', 'IT', 'Semester3', FLOOR(40000 + (RAND() * 30000))),
                    ('BTech', 'IT', 'Semester4', FLOOR(40000 + (RAND() * 30000))),
                    
                    ('BBA', 'Management', 'Semester1', FLOOR(40000 + (RAND() * 30000))),
                    ('BBA', 'Management', 'Semester2', FLOOR(40000 + (RAND() * 30000))),
                    ('BBA', 'Management', 'Semester3', FLOOR(40000 + (RAND() * 30000))),
                    ('BBA', 'Management', 'Semester4', FLOOR(40000 + (RAND() * 30000))),
                    ('BBA', 'Management', 'Semester5', FLOOR(40000 + (RAND() * 30000))),
                    ('BBA', 'Management', 'Semester6', FLOOR(40000 + (RAND() * 30000))),
                    ('BBA', 'Management', 'Semester7', FLOOR(40000 + (RAND() * 30000))),
                    ('BBA', 'Management', 'Semester8', FLOOR(40000 + (RAND() * 30000))),
                    
                    ('BSc', 'None listed', 'Semester1', FLOOR(40000 + (RAND() * 30000))),
                    ('BSc', 'None listed', 'Semester2', FLOOR(40000 + (RAND() * 30000))),
                    ('BSc', 'None listed', 'Semester3', FLOOR(40000 + (RAND() * 30000))),
                    ('BSc', 'None listed', 'Semester4', FLOOR(40000 + (RAND() * 30000))),
                    
                    ('MSc', 'None listed', 'Semester1', FLOOR(40000 + (RAND() * 30000))),
                    ('MSc', 'None listed', 'Semester2', FLOOR(40000 + (RAND() * 30000))),
                    ('MSc', 'None listed', 'Semester3', FLOOR(40000 + (RAND() * 30000))),
                    ('MSc', 'None listed', 'Semester4', FLOOR(40000 + (RAND() * 30000))),
                    
                    ('MBA', 'Law', 'Semester1', FLOOR(40000 + (RAND() * 30000))),
                    ('MBA', 'Law', 'Semester2', FLOOR(40000 + (RAND() * 30000))),
                    ('MBA', 'Law', 'Semester3', FLOOR(40000 + (RAND() * 30000))),
                    ('MBA', 'Law', 'Semester4', FLOOR(40000 + (RAND() * 30000))),
                    
                    ('MCA', 'IT', 'Semester1', FLOOR(40000 + (RAND() * 30000))),
                    ('MCA', 'IT', 'Semester2', FLOOR(40000 + (RAND() * 30000))),
                    ('MCA', 'IT', 'Semester3', FLOOR(40000 + (RAND() * 30000))),
                    ('MCA', 'IT', 'Semester4', FLOOR(40000 + (RAND() * 30000))),
                    
                    ('MCom', 'None listed', 'Semester1', FLOOR(40000 + (RAND() * 30000))),
                    ('MCom', 'None listed', 'Semester2', FLOOR(40000 + (RAND() * 30000))),
                    ('MCom', 'None listed', 'Semester3', FLOOR(40000 + (RAND() * 30000))),
                    ('MCom', 'None listed', 'Semester4', FLOOR(40000 + (RAND() * 30000))),
                    
                    ('MA', 'None listed', 'Semester1', FLOOR(40000 + (RAND() * 30000))),
                    ('MA', 'None listed', 'Semester2', FLOOR(40000 + (RAND() * 30000))),
                    ('MA', 'None listed', 'Semester3', FLOOR(40000 + (RAND() * 30000))),
                    ('MA', 'None listed', 'Semester4', FLOOR(40000 + (RAND() * 30000)));
                    
                    """;
            cnc.s.executeUpdate(feestructureenterQuery);

            String leaveQuery= """
                    CREATE TABLE IF NOT EXISTS studentLeave (
                        ID VARCHAR(50) NOT NULL,
                        date DATE NOT NULL,
                        duration VARCHAR(20) NOT NULL,
                        PRIMARY KEY (ID, date)
                    );
                    """;
            cnc.s.executeUpdate(leaveQuery);




            System.out.println("Database and table created successfully.");
        } catch (Exception e) {
            System.err.println("Error while creating database or table: " + e.getMessage());
        }
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == signUp) {
            setVisible(false);
            new passForStudentProfileCreate().setVisible(true);
        } else if (ae.getSource() == login) {
            setVisible(false);
            new loginpage().setVisible(true);
        } else if (ae.getSource() == exit) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
