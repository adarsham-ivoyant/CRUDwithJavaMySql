package com.ivoyant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Read {
    private static final Logger logger = LoggerFactory.getLogger(Read.class);

    public static void dis(){
        logger.info("Print all details");
        String query = "select * from emp";

        try {
            Statement stmt = DbCon.connection.createStatement();
            ResultSet result=stmt.executeQuery(query);
            logger.info("EmpId\tEmpName\tAddress\tDepartment");
            while(result.next()){
                logger.info(result.getInt(1)+"\t"
                        +result.getString(  2)+"\t"+
                        result.getString(3)+"\t"+
                        result.getString(4));
            }
        }catch (SQLException e) {
            logger.error("error is "+e);
        }

    }




}
