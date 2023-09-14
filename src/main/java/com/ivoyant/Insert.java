package com.ivoyant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert {
    private static final Logger logger = LoggerFactory.getLogger(Insert.class);
    public static void add(int id,String n,String a,String d){
        String sql = "Insert into emp values(?,?,?,?)";
        try {

            PreparedStatement preparedStatement = DbCon.connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,n);
            preparedStatement.setString(3,a);
            preparedStatement.setString(4,d);
            preparedStatement.execute();
            logger.info("Data Inserted Successfully....!");
        } catch (SQLException e) {
            logger.error("error is "+e);
        }

    }

}
