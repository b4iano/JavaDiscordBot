package br.com.core;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBase extends Database2 {
    private static final String DB_DRIVER = "";
    private static final String DB_CONNECTION = "";
    private static final String DB_USER = "";
    private static final String DB_PASSWORD = "";
    public static String aux;

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

    public String selectRecordsFromDbUserTable(String UserID) throws SQLException {

        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        String processador = null;
        String sistemaOp = null;
        String memoria = null;
        String gpu = null;

        String selectTableSQL = "select nome_processador, sistema_operacional, memoria_total, placa_video " +
                "from hardware where fk_idSoft= ?";

        try {
            dbConnection = getDBConnection();
            preparedStatement = dbConnection.prepareStatement(selectTableSQL);
            preparedStatement.setString(1, UserID);

            // execute select SQL stetement
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                processador = rs.getString("nome_processador");
                sistemaOp = rs.getString("sistema_operacional");
                memoria = rs.getString("memoria_total");
                gpu = rs.getString("placa_video");
                //String username = rs.getString("Sistema Operacional \n");

                System.out.println("PC Info : " + processador);
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
        return aux = processador + "\n" + sistemaOp + "\n" + memoria + "\n" + gpu;
    }

    public String insertRecordIntoTable(String IdUser) throws SQLException {


        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        String insertTableSQL = "UPDATE Username"
                + " SET id_discord = "
                + "(?)" + "where id_usuario = " + UserID;

        try {
            dbConnection = getDBConnection();
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);


            preparedStatement.setString(1, IdUser);
            //preparedStatement.setString(2, IdUsuario);


            // execute insert SQL stetement
            preparedStatement.executeUpdate();

            java.lang.System.out.println("Record is inserted into table!");

        } catch (SQLException e) {

            java.lang.System.out.println(e.getMessage());

        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }

        }

        return IdUser;
    }

    public String getInfoCPU(String maquina) throws SQLException {

        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        String processador = null;
        String cpuDisponivel = null;
        String cpuEmUso = null;
        String temperaturaCpu = null;

        String selectTableSQL = "SELECT cpu_disponivel, cpu_em_uso, temperatura_cpu FROM desempenho WHERE fk_idSoft = ?";

        try {
            dbConnection = getDBConnection();
            preparedStatement = dbConnection.prepareStatement(selectTableSQL);
            preparedStatement.setString(1, maquina);

            // execute select SQL stetement
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                cpuDisponivel = rs.getString("cpu_disponivel");
                cpuEmUso = rs.getString("cpu_em_uso");
                temperaturaCpu = rs.getString("temperatura_cpu");
                System.out.println("Dados do processador capturados");
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
        return aux = "Porcentagem livre na CPU: " + cpuDisponivel + "%\nPorcentagem de uso da CPU: " + cpuEmUso +
                "%\nTemperatura atual da CPU: " + temperaturaCpu + "°C";

    }

    public String getInfoRAM(String maquina) throws SQLException {

        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        String memoriaDisponivel = null;
        String memoriaEmUso = null;

        String selectTableSQL = "SELECT memoria_ram_disponivel, memoria_ram_em_uso_cpu FROM desempenho WHERE fk_idSoft = ?";

        try {
            dbConnection = getDBConnection();
            preparedStatement = dbConnection.prepareStatement(selectTableSQL);
            preparedStatement.setString(1, maquina);

            // execute select SQL stetement
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                memoriaDisponivel = rs.getString("memoria_ram_disponivel");
                memoriaEmUso = rs.getString("memoria_ram_em_uso_cpu");
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
        return aux = "Porcentagem de Memória RAM livre: " + memoriaDisponivel + "%\n" + "Porcentagem de Memória RAM em uso: "
                + memoriaEmUso + "%";
    }

    public String getInfoDisk(String maquina) throws SQLException {
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        String discoLivre = null;
        String discoEmUso = null;

        String selectTableSQL = "SELECT disco_livre_hd, disco_em_uso_hd from desempenho where fk_idSoft = ?";

        try {
            dbConnection = getDBConnection();
            preparedStatement = dbConnection.prepareStatement(selectTableSQL);
            preparedStatement.setString(1, maquina);

            // execute select SQL stetement
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                discoLivre = rs.getString("disco_livre_hd");
                discoEmUso = rs.getString("disco_em_uso_hd");
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
        return aux = "Porcentagem de Disco livre: " + discoLivre + "%\n" + "Porcentagem de Disco em uso: "
                + discoEmUso + "%";
    }

    public String getTemperaturaCpu(String maquina) throws SQLException {

        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        String temperaturaCpu = null;

        String selectTableSQL = "SELECT temperatura_cpu FROM desempenho WHERE fk_idSoft = ?";

        try {
            dbConnection = getDBConnection();
            preparedStatement = dbConnection.prepareStatement(selectTableSQL);
            preparedStatement.setString(1, maquina);

            // execute select SQL stetement
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                temperaturaCpu = rs.getString("temperatura_cpu");
                System.out.println("Temperatura da CPU capturada");
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
        return aux = temperaturaCpu;
    }

    public String codeUser(String code) {

        String codigo = "";
        for (char c : code.toCharArray()) {
            if (Character.isDigit(c)) {

                codigo += c;
            }
        }
        return aux = codigo;
    }
}


