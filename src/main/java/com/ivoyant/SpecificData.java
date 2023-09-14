package com.ivoyant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SpecificData {

    private static final Logger logger = LoggerFactory.getLogger(SpecificData.class);

    public static void dis2(int i){

        String query= "select * from emp where EmpId="+i;
        String query2= "select * from emp where EmpId="+i;
        try {
            Statement stmt = DbCon.connection.createStatement();
            ResultSet result1=stmt.executeQuery(query);
            boolean b=result1.next();

            if(b==true){
                ResultSet result=stmt.executeQuery(query);
                logger.info("EmpId\tEmpName\tAddress\tDepartment");
                while(result.next()){
                    logger.info(result.getInt(1)+"\t"
                            +result.getString(2)+"\t"+
                            result.getString(3)+"\t"+
                            result.getString(4));
                }
            }else{
                logger.info(i+" not present");
            }


        }catch (SQLException e) {
            logger.error("error is "+e);
        }

    }
}
