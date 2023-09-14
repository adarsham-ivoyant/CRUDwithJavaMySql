package com.ivoyant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {

    private static final Logger logger = LoggerFactory.getLogger(Delete.class);
    public static void del(int id){
        String query= "delete from emp where EmpId=?";
        try {
            PreparedStatement preparedStatement = DbCon.connection.prepareStatement(query);

            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();

            logger.info("Data Deleted Successfully....!");

        }catch (SQLException e) {
            logger.error("error is "+e);
        }
    }
}
