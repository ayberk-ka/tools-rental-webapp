package bacit.web.bacit_web.DAO;
import bacit.web.bacit_web.Modell.AnsattM;
import bacit.web.bacit_web.DBUtils;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnsattDAO {


    public AnsattM getUser(String email, String password, PrintWriter out) throws SQLException {
    Connection db = null;
    try {
        db = DBUtils.getINSTANCE().getConnection(out);
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }

    String query3 = "select * from ansatt where  email = ? AND password=?";
    PreparedStatement statement = db.prepareStatement(query3);

    statement.setString(1, email);
    statement.setString(2, password);
    ResultSet rs = statement.executeQuery();
    AnsattM model = null;

    while (rs.next()) {
        model =
                new AnsattM(rs.getInt("ansatt_id"),
                        rs.getString("password"),
                        rs.getString("fornavn"),
                        rs.getString("etternavn"),
                        rs.getString("adresse"),
                        rs.getString("mobil"),
                        rs.getString("email"),
                        rs.getInt("unionn"),
                        rs.getInt("administrator") );

    }
        db.close();


        return model;
}

}
