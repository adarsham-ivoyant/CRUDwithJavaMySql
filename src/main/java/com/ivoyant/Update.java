package com.ivoyant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {

    private static final Logger logger = LoggerFactory.getLogger(Update.class);

    //Name update code
    public static void updateName(int i,String n){

        String query="update emp set EmpName=? where EmpId=?";

        try {

            PreparedStatement preparedStatement = DbCon.connection.prepareStatement(query);

            preparedStatement.setString(1,n);
            preparedStatement.setInt(2,i);
            int c=preparedStatement.executeUpdate();
            if(c!=0){
                logger.info("Data Updated Successfully....!");
            }else{
                logger.error(i+" "+n+" : Note updated");
            }

        } catch (SQLException e) {
            logger.error("error is "+e);
        }
    }

    public static void updateAddress(int i,String a){

        String query="update emp set Address=? where EmpId=?";

        try {

            PreparedStatement preparedStatement = DbCon.connection.prepareStatement(query);

            preparedStatement.setString(1,a);
            preparedStatement.setInt(2,i);
            int c=preparedStatement.executeUpdate();
            if(c!=0){
                logger.info("Data Updated Successfully....!");
            }else{
                logger.error(i+" "+a+" : Note updated");
            }

        } catch (SQLException e) {
            logger.error("error is "+e);
        }
    }

    public static void updateDept(int i,String d){

        String query="update emp set Department=? where EmpId=?";

        try {

            PreparedStatement preparedStatement = DbCon.connection.prepareStatement(query);

            preparedStatement.setString(1,d);
            preparedStatement.setInt(2,i);
            int c=preparedStatement.executeUpdate();
            if(c!=0){
                logger.info("Data Updated Successfully....!");
            }else{
                logger.error(i+" "+d+" : Note updated");
            }

        } catch (SQLException e) {
            logger.error("error is "+e);
        }
    }
    public static void setUpdate(int i,String n,String a,String d){

        String query="update emp set EmpName=?,Address=?,Department=? where EmpId=?";

        try {

            PreparedStatement preparedStatement = DbCon.connection.prepareStatement(query);

            preparedStatement.setString(1,n);
            preparedStatement.setString(2,a);
            preparedStatement.setString(3,d);
            preparedStatement.setInt(4,i);
            int c=preparedStatement.executeUpdate();
            if(c!=0){
                logger.info("Data Updated Successfully....!");
            }else{
                logger.error(i+" Note Updated");
            }

        } catch (SQLException e) {
            logger.error("error is "+e);
        }
    }
}
