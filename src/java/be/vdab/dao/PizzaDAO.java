/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.dao;

import be.vdab.entities.Pizza;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author oleg.kolokolnikov
 */
public class PizzaDAO {
    private static final String FIND_ALL_SQL =
    "select nummer,naam,prijs,pikant from pizzas order by naam";
    private static final String READ_SQL =
    "select nummer,naam,prijs,pikant from pizzas where nummer=?";
    private static final String FIND_BY_PRIJS_SQL =
    "select nummer,naam,prijs,pikant from pizzas "+
    "where prijs between ? and ? order by prijs";
    private static final String CREATE_SQL =
    "insert into pizzas(naam,prijs,pikant) values (?,?,?)";
    private final DatabaseUtil databaseUtil = new DatabaseUtil();
    
    public List<Pizza> findAll() { 
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            List<Pizza> pizzas = new ArrayList<Pizza>();
            connection =  databaseUtil.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(FIND_ALL_SQL);
            while (resultSet.next()) {
                pizzas.add(resultSetRijNaarPizza(resultSet));
            }
            return pizzas;
        } catch (SQLException ex) {
            throw new DAOException("Kan pizzas niet lezen uit database", ex);
        } finally {
            databaseUtil.close(resultSet, statement, connection);
        }
    }
    private Pizza resultSetRijNaarPizza(ResultSet resultSet) 
    throws SQLException { 
        return new Pizza(resultSet.getLong("nummer"),
        resultSet.getString("naam"),
        resultSet.getBigDecimal("prijs"),
        resultSet.getBoolean("pikant"));
    }
    public Pizza read(long nummer) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Pizza pizza = null;
            connection = databaseUtil.getConnection();
            statement = connection.prepareStatement(READ_SQL);
            statement.setLong(1, nummer);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                pizza = resultSetRijNaarPizza(resultSet);
            }
            return pizza;
        }
        catch (SQLException ex) {
            throw new DAOException("Kan pizza niet lezen uit database", ex);
        }
        finally {
            databaseUtil.close(resultSet, statement,connection);
        }
    }
    public List<Pizza> findByPrijs(BigDecimal van, BigDecimal tot) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            List<Pizza> pizzas = new ArrayList<>();
            connection = databaseUtil.getConnection();
            statement = connection.prepareStatement(FIND_BY_PRIJS_SQL);
            statement.setBigDecimal(1, van);
            statement.setBigDecimal(2, tot);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                pizzas.add(resultSetRijNaarPizza(resultSet));
            }
            return pizzas;
        } catch (SQLException ex) {
            throw new DAOException("Kan pizzas niet lezen uit database", ex);
        } finally {
            databaseUtil.close(resultSet, statement, connection);
        }
    }
    public void create(Pizza pizza) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = databaseUtil.getConnection();
            statement =  connection.prepareStatement(CREATE_SQL,
            Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, pizza.getNaam());
            statement.setBigDecimal(2, pizza.getPrijs());
            statement.setBoolean(3, pizza.isPikant());
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (! resultSet.next()) {
            throw new DAOException(
            "Kan nummer toegevoegde pizza niet lezen uit database");
        }
        pizza.setNummer(resultSet.getLong(1));
        } catch (SQLException ex) {
            throw new DAOException("Kan pizzas niet toevoegen aan database",
        ex);
        } finally {
            databaseUtil.close(resultSet, statement, connection);
        }
    }
    
}
