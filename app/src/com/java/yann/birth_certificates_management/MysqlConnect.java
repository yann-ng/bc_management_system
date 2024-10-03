package com.java.yann.birth_certificates_management;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MysqlConnect
{
    Connection conn = null ;

    public static Connection ConnectDB()
    {

        String user = "user";
        String password = "password";
        String DB_name = "birthCertificates";
        try
        {
            //Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting...");
            String loginURL = "jdbc:mysql://localhost/" + DB_name + "?user=" + user + "&password=" + password;
            Connection conn = DriverManager.getConnection(loginURL);
            System.out.println("Connection Established!");
            return conn;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static ObservableList<TheTable> getTableData()
    {
        Connection conn = ConnectDB();
        ObservableList<TheTable> list = FXCollections.observableArrayList();
        try
        {
            System.out.println("Reading Database...");
            String DB_tableName = "bcTable";
            String query = "SELECT * FROM " + DB_tableName;
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while(rs.next())
            {
                list.add(new TheTable(rs.getInt("certificateID"),
                                        rs.getString("fullName"),
                                        rs.getString("gender"),
                                        rs.getString("placeOfBirth"),
                                        rs.getDate("dateOfBirth"),
                                        rs.getString("fatherName"),
                                        rs.getString("motherName")));
            }
            System.out.println("OK!");
        }catch (Exception e){e.printStackTrace();}
        return list;
    }
    public static ObservableList<TheTable> searchData(String keyword)
    {
        Connection conn = ConnectDB();
        ObservableList<TheTable> list = FXCollections.observableArrayList();
        try
        {
            System.out.println("Reading Database...");
            String keywordQuery = "\"%" + keyword + "%\"";
            String DB_tableName = "bcTable";
            String query = "SELECT * FROM " + DB_tableName + " WHERE fullName LIKE " + keywordQuery;
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                list.add(new TheTable(rs.getInt("certificateID"),
                        rs.getString("fullName"),
                        rs.getString("gender"),
                        rs.getString("placeOfBirth"),
                        rs.getDate("dateOfBirth"),
                        rs.getString("fatherName"),
                        rs.getString("motherName")));
            }
            System.out.println("OK!");
        }catch (Exception e){e.printStackTrace();}
        return list;

    }

}
