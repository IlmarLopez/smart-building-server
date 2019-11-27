package com.ilmarlopez.smart.building.utils;

import java.sql.Connection;

import com.ilmarlopez.smart.building.beans.Alarm;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBUtils {
    
    public static List<Alarm> queryAlarm(Connection conn) throws SQLException {
        String sql = "select a.id, a.created_at, a.teaching_id from alarm a";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        ResultSet rs = pstm.executeQuery();
        List<Alarm> list = new ArrayList<Alarm>();
        while (rs.next()) {
        	int id = rs.getInt("id");
            String createdAt = rs.getString("created_at");
            int teachingId = rs.getInt("teaching_id");
            
            Alarm alarm = new Alarm();
            alarm.setCreatedAt(createdAt);
            alarm.setTeachingId(teachingId);
            alarm.setId(id);
            list.add(alarm);
        }
        return list;
    }
    
        public static void insertAlarm(Connection conn, Alarm alarm) throws SQLException {
        String sql = "INSERT INTO alarm(created_at, teaching_id) values (?,?)";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        
        pstm.setString(1, alarm.getCreatedAt());
        pstm.setInt(2, alarm.getTeachingId());
 
        pstm.executeUpdate();
    }
}