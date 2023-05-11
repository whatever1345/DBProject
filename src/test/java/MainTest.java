import Functionality.ContractFunctionality;

import java.sql.*;
import java.time.LocalDate;

public class MainTest {
    public static void main(String[] args){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con =DriverManager.getConnection(
                    "jdbc:oracle:thin:@dbsys.cs.vsb.cz:1521:oracle",
                    "VOL0152",
                    "AT6p72Sc65uC92qC");

            // Statement st = con.createStatement();
            // ResultSet rs = st.executeQuery("select * from contracts");

            ContractFunctionality.Select(con, 0, 0, 50);
            // ContractFunctionality.Insert(con, 2, 1, LocalDate.of(2033, 5, 7), 16000);
            // ContractFunctionality.Update(con, 1, 1, 1, LocalDate.of(2033, 9, 7), 16000);
            // ContractFunctionality.Delete(con, 1);

            // ContractFunctionality.BuyContract(con, 2, 1, 5000, LocalDate.of(2034, 6, 7));
            // ContractFunctionality.TerminateContract(con, 1, LocalDate.of(2035, 5, 7));
            // ContractFunctionality.TerminateContract(con, 1, LocalDate.of(2032, 5, 7));

            //while(rs.next())
                //System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
        } catch(Exception e){
            System.out.println(e);
        }
    }
}
