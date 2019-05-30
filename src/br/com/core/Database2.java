package br.com.core;

import java.sql.*;

public class Database2 {

    private static final String DB_DRIVER = "";
    private static final String DB_CONNECTION = "";
    private static final String DB_USER = "";
    private static final String DB_PASSWORD = "";
    public static String UserID = null;

    public String selectRecordsFromTable(String codigo) throws SQLException {

        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        String userid = null;

        String selectSQL = "SELECT id_usuario FROM Username WHERE id_usuario= ?";

        try {
            dbConnection = getDBConnection();
            preparedStatement = dbConnection.prepareStatement(selectSQL);
            preparedStatement.setInt(1, Integer.parseInt(codigo));

            // execute select SQL stetement
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                userid = rs.getString("id_usuario");
                //String username = rs.getString("USERNAME");

                System.out.println("userid : " + userid);
                //System.out.println("username : " + username);

            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }

        }
        UserID = userid;
        return userid;


    }

    public String selectIdSoftFromTable(String nomeMaquina) throws SQLException {
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        int tamanho = nomeMaquina.length();
        nomeMaquina = nomeMaquina.substring(8, tamanho);
        int fk_Id = 0;

        String selectSQL = "SELECT id_soft from maquina where nome_soft= ?";

        try {
            dbConnection = getDBConnection();
            preparedStatement = dbConnection.prepareStatement(selectSQL);
            preparedStatement.setString(1, nomeMaquina);

            // execute select SQL stetement
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                fk_Id = rs.getInt("id_soft");
                System.out.println("idSoft:" + fk_Id);
                UserID = String.valueOf(fk_Id);
            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }

        }

        return String.valueOf(fk_Id);
    }

    private static Connection getDBConnection() {

        Connection dbConnection = null;

        try {

            Class.forName(DB_DRIVER);

        } catch (ClassNotFoundException e) {

            System.out.println(e.getMessage());

        }

        try {

            dbConnection = DriverManager.getConnection(
                    DB_CONNECTION, DB_USER, DB_PASSWORD);
            return dbConnection;

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return dbConnection;

    }

}


