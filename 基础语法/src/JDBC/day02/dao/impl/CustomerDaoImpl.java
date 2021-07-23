package JDBC.day02.dao.impl;

import JDBC.day01.Customers;
import JDBC.day02.dao.BaseDao;
import JDBC.day02.dao.CustomerDao;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

/**
 * @author 蟑螂恶霸
 * @version 1.0
 * @description: TODO
 * @date 2021/7/21 14:54
 */
public class CustomerDaoImpl extends BaseDao<Customers> implements CustomerDao{
    @Override
    public void insert(Connection conn, Customers cust) {
        String sql="insert into customers(name,email,birth) values(?,?,?)";
        update(conn,sql,cust.getName(),cust.getEmail(),cust.getBirth());
    }

    @Override
    public void deleteById(Connection conn, int id) {
        String sql="delete from customers where id=?";
        update(conn,sql,id);
    }

    @Override
    public void update(Connection conn, Customers cust) {
        String sql = "update customers set name = ?,email = ?,birth = ? where id = ?";
        update(conn, sql,cust.getName(),cust.getEmail(),cust.getBirth(),cust.getId());
    }

    @Override
    public Customers getCustomerById(Connection conn, int id) {
        String sql = "select id,name,email,birth from customers where id = ?";
        Customers cust=getInstance(conn,sql,id);
        return cust;
    }

    @Override
    public List<Customers> getAll(Connection conn) {
        String sql = "select id,name,email,birth from customers";
        List<Customers> list = getForList(conn, sql);
        return list;
    }

    @Override
    public Long getCount(Connection conn) {
        String sql = "select count(*) from customers";
        return getValue(conn, sql);
    }

    @Override
    public Date getMaxBirth(Connection conn) {
        String sql="select max(birth) from customers";
        return getValue(conn,sql);
    }
}
