package JDBC.day02.dao;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 蟑螂恶霸
 * @version 1.0
 * @description: TODO
 * @date 2021/7/21 13:05
 */
public abstract class BaseDao<T>{
    private Class<T> clazz =null;
    {
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        ParameterizedType paramType = (ParameterizedType) genericSuperclass;
        Type[] actualTypeArguments = paramType.getActualTypeArguments();
        clazz=(Class<T>)actualTypeArguments[0];
    }

    //通用的增删改操作 （考虑事务）
    public int update(Connection conn,String sql,Object... args){
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i <args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            return ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return 0;
    }
    //通用的查询操作，用于返回数据表中的一条数据
    public  T getInstance(Connection conn,String sql,Object...args) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            if (rs.next()){
                T t = clazz.newInstance();
                for (int i = 0; i <rsmd.getColumnCount() ; i++) {
                    String columnName=rsmd.getColumnName(i+1);
                    Object columnValue=rs.getObject(i+1);
                    Field field = clazz.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(t,columnValue);
                }
                return t;
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
    //通用的查询操作，用于返回多条记录构成的集合
    public List<T> getForList(Connection conn,String sql,Object... args){
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i <args.length ; i++) {
                ps.setObject(i+1,args[i]);
            }
            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            List<T> lists=new ArrayList<>();
            while (rs.next()){
                T t = clazz.newInstance();
                for (int i = 0; i <rsmd.getColumnCount() ; i++) {
                    Object columnValue = rs.getObject(i + 1);
                    String columnName = rsmd.getColumnName(i + 1);
                    Field field = clazz.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(t,columnValue);
                }
                lists.add(t);
            }
            return lists;
        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
    //用于查询特殊值的通用方法
    public <T> T getValue(Connection conn,String sql,Object... args){
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i <args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            rs = ps.executeQuery();
            if (rs.next()){
                return (T) rs.getObject(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

}
