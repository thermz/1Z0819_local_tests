package me.certtest.excercise;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import static me.certtest.excercise.Utils.uncheck;

/**
 *
 * @author Riccardo
 */
public class JDBCTests {

    public static void testDerbyConnection() {
	String dbURL = "jdbc:derby:codejava/webdb;create=true";

	String query = "select count(*) from Phone";
	try (Connection conn = uncheck(() -> DriverManager.getConnection(dbURL));
		Statement stat = conn.createStatement()) {
	    stat.executeUpdate("CREATE TABLE Phone (Name CHAR(20), Number INT)");
	    stat.executeUpdate("INSERT INTO Phone VALUES ('Shaun Sheep', 1234567)");
	    stat.executeUpdate("INSERT INTO Phone VALUES ('Gary Potter', 7654321)");
	    stat.executeUpdate("INSERT INTO Phone VALUES ('Al Capone', 7976543)");
	    stat.executeUpdate("INSERT INTO Phone VALUES ('Shaun Sheep', 1234567)");
	    stat.executeUpdate("INSERT INTO Phone VALUES ('Gary Potter', 7654321)");
	    stat.executeUpdate("INSERT INTO Phone VALUES ('Al Capone', 7976543)");
	    stat.executeUpdate("INSERT INTO Phone VALUES ('Shaun Sheep', 1234567)");
	    stat.executeUpdate("INSERT INTO Phone VALUES ('Gary Potter', 7654321)");
	    stat.executeUpdate("INSERT INTO Phone VALUES ('Al Capone', 7976543)");

	    PreparedStatement ps = conn.prepareStatement(query);

	    var set = (ps.executeQuery().next()) ? ps.getResultSet().getInt(1) : 0;

		var preparedInsert = "INSERT INTO Phone values('Riccardo', ?)";
		PreparedStatement insertPs = conn.prepareStatement(preparedInsert);
		insertPs.setInt(1, 123456);

		try(insertPs){
			var insertedRows = insertPs.executeUpdate();
			System.out.println("inserted "+insertedRows+" with preparedstatement");
		}

	    ps.close();

	    System.out.println("Count is " + set);

	    try (var result = stat.executeQuery("SELECT * FROM Phone")) {
		while (result.next()) {
		    System.out.println(result.getString(1) + " - " + result.getInt(2));
		}
	    }

	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    try (Connection conn = uncheck(() -> DriverManager.getConnection(dbURL)); Statement stat = conn.createStatement()) {
		stat.executeUpdate("DROP TABLE Phone");
	    } catch (SQLException ex) {
		Logger.getLogger(JDBCTests.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
    }

    public static void main(String[] args) {
	testDerbyConnection();
    }

}
