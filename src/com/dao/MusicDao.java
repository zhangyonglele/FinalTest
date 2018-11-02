package com.dao;

import com.entity.Music;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface MusicDao {
    public boolean insert(Music music) throws SQLException;
    public boolean delete(String key,String keyword) throws SQLException;
    public boolean update(Object[] fields, Object[] values, String key, String keyword) throws SQLException;
    public ResultSet query(String key, String keyword) throws SQLException;

}
