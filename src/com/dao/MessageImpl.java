package com.dao;

import com.entity.Message;
import com.util.JdbcUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MessageImpl implements MessageDao {

    @Override
    public boolean insert(Message message) throws SQLException {
        String sql = "INSERT INTO Message(chairId,content,fileType) VALUES (?,?,?)";
        Object[] params = new Object[]{message.getId(),message.getContent(),message.getFileType()};
        return JdbcUtils.update(sql, params);

    }

    @Override
    public boolean delete(String key,String keyword) throws SQLException{
        String sql = "DELETE FROM Message WHERE "+key+" ='"+keyword+"'";
        return JdbcUtils.update(sql);
    }


    /**
     *
     * @param fields :需要更新的字段，例如，Object[] fields = new Object[]{musicName,musicURL,fileType,emotion}
     * @param values :字段对应的值，例如，Object[] values = new Object[]{"你还要我这样",http://...","音乐","开心"}
     * @param key :关键字段
     * @param keyword：关键字段对应的值
     * @return
     * @throws SQLException
     */
    @Override
    public boolean update(Object[] fields, Object[] values, String key, String keyword) throws SQLException {
        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < fields.length; x++) {
            if (x < fields.length - 1)
                sb.append(fields[x]).append("=?,");
            else
                sb.append(fields[x]).append("=?");
        }
        String params = sb.toString();
        String sql = "UPDATE Message SET " + params + " WHERE " + key + " = '" + keyword + "'";
        return JdbcUtils.update(sql, values);
    }


    @Override
    public ResultSet query(String key, String keyword) throws SQLException{
        String sql = "SELECT FROM Message WHERE"+key+" ='"+keyword+"'";
        return JdbcUtils.query(sql);

    }
}
