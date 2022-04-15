package hu.da.ccs.service;

import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class ConnectionData {

    @PostConstruct
    public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:sqlite:src/main/resources/Kaloriaszamlalo");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
