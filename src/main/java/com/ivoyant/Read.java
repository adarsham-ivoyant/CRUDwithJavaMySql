package com.ivoyant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Read {
    private static final Logger logger = LoggerFactory.getLogger(Read.class);

    public static void dis(){

        String query = "select * from emp";
        String query1 = "select * from emp";


        try {

            Statement stmt = DbCon.connection.createStatement();

            ResultSet result1=stmt.executeQuery(query1);

            boolean b=result1.next();
            if(b==true){
                logger.info("Print all details");
                logger.info("EmpId\tEmpName\tAddress\tDepartment");
                ResultSet result=stmt.executeQuery(query);
                while(result.next()){
                    logger.info(result.getInt(1)+"\t\t"
                            +result.getString(  2)+"\t\t"+
                            result.getString(3)+"\t\t"+
                            result.getString(4));
                }
            }else{
                logger.info("DataNot present in Database");
            }

        }catch (SQLException e) {
            logger.error("error is "+e);
        }

    }




}
