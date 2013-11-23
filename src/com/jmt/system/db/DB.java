package com.jmt.system.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-21
 * Time: 下午5:55
 * To change this template use File | Settings | File Templates.
 */
public class DB {
    private static Connection conn = null;
    private static String driver = null;
    private static String url = null;
    private static String OracleName = null;
    private static String OraclePass = null;
    private static Properties prop = null;
    static {
        prop = new Properties();
        try {
            prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("Dao.properties"));
            driver = prop.getProperty("Driver");
            url = prop.getProperty("Url");
            OracleName = prop.getProperty("OracleName");
            OraclePass = prop.getProperty("OraclePass");
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public static Connection getConn() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, OracleName, OraclePass);
            System.out.println("连接成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return conn;
    }

    public static void connClose() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
