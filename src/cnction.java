import java.sql.*;

public class cnction {
    Connection c;
    Statement s;
    public cnction(){
    try {
        c=DriverManager.getConnection("jdbc:mysql:///studentmanagementJAVA","root","put ur password here");
        s=c.createStatement();
    } catch(Exception e){
        System.out.println(e);
    }
    }
}
