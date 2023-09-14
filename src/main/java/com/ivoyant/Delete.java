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
            int c=preparedStatement.executeUpdate();

            if(c!=0){
                logger.info("Data Deleted Successfully....!");
            }
            else{
                logger.info(id+" is not present in database");
            }

        }catch (SQLException e) {
            logger.error("error is "+e);
        }
    }
}
