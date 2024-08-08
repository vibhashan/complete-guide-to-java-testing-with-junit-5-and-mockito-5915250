package com.linkedin.app;

import java.sql.Connection;

import javax.xml.crypto.Data;

public class DatabaseService {
  private DatabaseConnection dbConnection;

  public DatabaseService(DatabaseConnection dbConnection) {
    this.dbConnection = dbConnection;
  }

  public Data getData() {
    Connection connection = dbConnection.getConnection();
    // Retrieve data from the database and return it
    // (This code would normally be here, but for the sake of example, we'll omit
    // it)
    return null;
  }
}
