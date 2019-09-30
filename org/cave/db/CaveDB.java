package org.cave.db;
import org.cave.*;
import java.sql.*;

public class CaveDB {
  public Connection c;
  public Statement s;
  public ResultSet rs;

  public Connection createConnection() {
    Connection localConn = null;

    try {
      Class.forName("org.sqlite.JDBC"); //Sqlite driver
    } catch (ClassNotFoundException cnfe) {
      System.err.println("Couldn't find driver class:");
      System.out.println(cnfe.getMessage());
      System.exit(1);
    }
    //System.out.println("Driver ok");

    try {
      localConn = DriverManager.getConnection("jdbc:sqlite:cave2db\\cavedatabas.db");
    } catch (SQLException se) {
      System.out.println("Couldn't connect: print a SQL message and exit.");
      System.out.println(se.getMessage());
      System.exit(1);
    }

    //if (localConn != null)
    //  System.out.println("Connected to the database!");
    //else
    //println("We should never get here.");

    return localConn;
  }

  public Statement myCreateStatement(Connection c) {
    Statement s = null;

    try {
      s = c.createStatement();
    } catch (SQLException se) {
      System.out.println("We got an exception while creating a statement:" +
                         "that probably means we lost the connectio to the db.");
      System.out.println(se.getMessage());
      System.exit(1);
    }
    return s;
  }

  public ResultSet myCreateResultSet(Statement s, String query) {
    ResultSet rs = null;

    try {
      rs = s.executeQuery(query);
    } catch (SQLException se) {
      System.out.println("We got an exception while executing our query:" +
                         "that probably means our SQL is invalid");
      System.out.println(se.getMessage());
      System.exit(1);
    }
    return rs;
  }

}
