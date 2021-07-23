package JDBC.day01;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @author 蟑螂恶霸
 * @version 1.0
 * @description: TODO
 * @date 2021/7/19 16:30
 */
public class BatchInsert {
    public static void main(String[] args) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);
            String sql="insert into goods(name) values(?)";
            ps = conn.prepareStatement(sql);
            long start = System.currentTimeMillis();
            for (int i = 1; i <=1000000 ; i++) {
                ps.setObject(1,"name_"+i);
//                ps.execute();
                ps.addBatch();
                if (i%100000==0){
                    ps.executeBatch();
                    ps.clearBatch();
                }
            }
            conn.commit();
            long end = System.currentTimeMillis();
            System.out.println(end-start);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ps.close();
        conn.close();
    }
}
