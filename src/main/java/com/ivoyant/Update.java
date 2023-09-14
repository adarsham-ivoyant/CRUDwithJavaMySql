package com.ivoyant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {

    private static final Logger logger = LoggerFactory.getLogger(Update.class);
    public static void setUpdate(int i,String n,String a,String d){

        String query="update emp set EmpName=?,Address=?,Department=? where EmpId=?";

        try {

            PreparedStatement preparedStatement = DbCon.connection.prepareStatement(query);

            preparedStatement.setString(1,n);
            preparedStatement.setString(2,a);
            preparedStatement.setString(3,d);
            preparedStatement.setInt(4,i);
            preparedStatement.executeUpdate();
            logger.info("Data Updated Successfully....!");
        } catch (SQLException e) {
            logger.error("error is "+e);
        }
    }
}
