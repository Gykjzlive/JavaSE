package JDBC.day04;

import JDBC.day01.Customers;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;

/**
 * @author 蟑螂恶霸
 * @version 1.0
 * @description: TODO
 * @date 2021/7/22 23:48
 */
public class QueryRunnerTest {
    @Test
    public void testInsert() throws Exception{
        Properties pro = new Properties();
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("JDBC\\day03\\druid.properties");
        pro.load(is);
        DataSource source = DruidDataSourceFactory.createDataSource(pro);
        Connection conn = source.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql="insert into customers(name,email,birth)values(?,?,?)";
        int count=queryRunner.update(conn,sql,"寇富贵","84892498@qq.com","1999-3-24");
        System.out.println(count);
    }
    @Test
    public void queryTest(){
        Connection conn = null;
        try {
            Properties pro = new Properties();
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("JDBC\\day03\\druid.properties");
            pro.load(is);
            DataSource source = DruidDataSourceFactory.createDataSource(pro);
            conn = source.getConnection();
            QueryRunner queryRunner = new QueryRunner();
            String sql="select  id,name,email,birth from customers where id<?";
            BeanListHandler beanListHandler = new BeanListHandler(Customers.class);
            List<Customers> query =(ArrayList<Customers>)queryRunner.query(conn, sql, beanListHandler, 30);
            query.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    @Test
    //mapHandler
    public void queryTest2(){
        Connection conn = null;
        try {
            Properties pro = new Properties();
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("JDBC\\day03\\druid.properties");
            pro.load(is);
            DataSource source = DruidDataSourceFactory.createDataSource(pro);
            conn = source.getConnection();
            QueryRunner queryRunner = new QueryRunner();
            String sql="select  id,name,email,birth from customers where id=?";
            MapHandler mapHandler = new MapHandler();
            Map<String, Object> map = queryRunner.query(conn, sql, mapHandler, 22);
            System.out.println(map);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    @Test
    //mapListHandler
    public void queryTest3(){
        Connection conn = null;
        try {
            Properties pro = new Properties();
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("JDBC\\day03\\druid.properties");
            pro.load(is);
            DataSource source = DruidDataSourceFactory.createDataSource(pro);
            conn = source.getConnection();
            QueryRunner queryRunner = new QueryRunner();
            String sql="select  id,name,email,birth from customers where id<?";
            MapListHandler mapListHandler = new MapListHandler();
            List<Map<String, Object>> map = queryRunner.query(conn, sql, mapListHandler, 30);
            map.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    @Test
    //scalarhandler  用于查询特殊值
    public void queryTest4(){
        Connection conn = null;
        try {
            Properties pro = new Properties();
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("JDBC\\day03\\druid.properties");
            pro.load(is);
            DataSource source = DruidDataSourceFactory.createDataSource(pro);
            conn = source.getConnection();
            QueryRunner queryRunner = new QueryRunner();
            String sql="select max(birth) from customers";
            ScalarHandler scalarHandler = new ScalarHandler();
            Object query = queryRunner.query(conn, sql, scalarHandler);
            System.out.println(query);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    @Test
    //自定义handler
    public void queryTest5(){
        Connection conn = null;
        try {
            Properties pro = new Properties();
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("JDBC\\day03\\druid.properties");
            pro.load(is);
            DataSource source = DruidDataSourceFactory.createDataSource(pro);
            conn = source.getConnection();
            QueryRunner queryRunner = new QueryRunner();
            String sql="select id,name,email,birth from customers where id=?";
            ResultSetHandler<Customers> resultSetHandler = new ResultSetHandler<Customers>(){
                @Override
                public Customers handle(ResultSet resultSet) throws SQLException {
                    ResultSetMetaData rsmd = resultSet.getMetaData();
                    if (resultSet.next()){
                        Customers customers = new Customers();
                        for (int i = 0; i <rsmd.getColumnCount(); i++) {
                            Object columnValue = resultSet.getObject(i + 1);
                            String columnName = rsmd.getColumnName(i + 1);
                            Field field = null;
                            try {
                                field = customers.getClass().getDeclaredField(columnName);
                            } catch (NoSuchFieldException e) {
                                e.printStackTrace();
                            }
                            field.setAccessible(true);
                            try {
                                field.set(customers,columnValue);
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }
                        }
                        return customers;
                    }
                    return null;
                }
            };
            Customers query = queryRunner.query(conn, sql, resultSetHandler, 25);
            System.out.println(query);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }
}

