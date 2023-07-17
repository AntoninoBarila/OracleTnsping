package it.antoninobarila.db;

import java.sql.PreparedStatement;

import it.antoninobarila.enumeration.DBConnectionTypeEnum;


public final class DBConnectionInfo {


    public static final String THINCONNECTION = "jdbc:oracle:thin:@";
    public static final String OCICONNECTION = "jdbc:oracle:oci:@";


    public static final int INVALID_USERNAME_PASSWORD = 1017;


    public static int MAX_FETCH_SIZE = 100;


    public static int MAX_STATEMENT_CACHE = 10;


    private static String dbUserName;


    private static String dbPassWord;

    // Sintax d Oracle: localhost:1521:xe
    // (DESCRIPTION=(ENABLE=BROKEN)
    //   (ADDRESS=(PROTOCOL=tcp)(PORT=port_no)(HOST=host_name))
    //   (CONNECT_DATA=(SERVICE=service_name)))
    private static String dbStrConnect;


    private static DBConnectionTypeEnum dbConnType;

    private DBConnectionInfo() {
        dbUserName = "system";
        dbPassWord = "dummypassword";
        dbStrConnect = null;
        dbConnType = DBConnectionTypeEnum.THIN;
    }

    public static String getDbUserName() {
        return dbUserName;
    }

    public static String getDbPassWord() {
        return dbPassWord;
    }

    public static String getDbStrConnect() {
        return dbStrConnect;
    }

    public static void setDbStrConnect(String dbStrConnect) {
        DBConnectionInfo.dbStrConnect = dbStrConnect;
    }

    public static DBConnectionTypeEnum getDbConnType() {
        return dbConnType;
    }

    public static void setDbConnType(DBConnectionTypeEnum dbConnType) {
        DBConnectionInfo.dbConnType = dbConnType;
    }
}