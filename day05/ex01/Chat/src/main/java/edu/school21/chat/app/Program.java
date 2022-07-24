package edu.school21.chat.app;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.Duration;

public class Program {
    private static DataSource dataSource;
    public static void main(String[] args) {
        try(Connection connection = dataSource.getConnection()){

        }catch (SQLException io){
            io.getStackTrace();
        }
    }

    private static HikariDataSource getHikariConfig() {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl("jdbc:postgresql://localhost:5434/postgres");
        ds.setUsername("admin");
        ds.setPassword("admin");
        ds.addDataSourceProperty( "cachePrepStmts" , "true" );
        ds.addDataSourceProperty(  "prepStmtCacheSize" , "250" );
        ds.addDataSourceProperty(  "prepStmtCacheSqlLimit" , "2048" );
        return ds;
    }


}
