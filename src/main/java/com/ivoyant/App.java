package com.ivoyant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class App
{
    private static final Logger logger = LoggerFactory.getLogger(App.class);
    public static void main( String[] args )
    {
        DbCon.conn();
       // logger.info("adk");
        Scanner sc=new Scanner(System.in);
        logger.info("WelCome to Employee Management");
        while(true){
            logger.info("1.Insert data\n" +
                    "2.Read the Data\n" +
                    "3.Update the data\n"+
                    "4.Delete the data\n"+
                    "5.Display Particular data");
            logger.info("Enter the Choice");
            int ch=sc.nextInt();

            switch(ch){
                case 1:System.out.println("enter the Id");
                    int at1=sc.nextInt();
                    logger.info("enter the name");
                    String at2=sc.next();
                    logger.info("enter the Address");
                    String at3=sc.next();
                    logger.info("enter the Department");
                    String at4=sc.next();

                    Employee e=new Employee(at1,at2,at3,at4);
                    int id=e.getId();
                    String nam=e.getName();
                    String add=e.getAddress();
                    String dept=e.getDepartment();
                    Insert.add(id,nam,add,dept);

                    break;

                case 2:Read.dis();
                break;

                case 3:
                    logger.info("Enter the id");
                    int setid=sc.nextInt();

                    String query= "select * from emp where Empid="+setid;
                    String query1= "select * from emp where Empid="+setid;
                    try {
                        Statement stmt = DbCon.connection.createStatement();
                        ResultSet result1=stmt.executeQuery(query1);
                        boolean b=result1.next();

                        if(b==true){
                            ResultSet result=stmt.executeQuery(query);
                            logger.info("EmpId\tEmpName\tAddress\tDepartment");
                            while(result.next()){
                                logger.info(result.getInt(1)+"\t\t"
                                        +result.getString(2)+"\t\t"+
                                        result.getString(3)+"\t\t"+
                                        result.getString(4));
                            }

                            logger.info("select the field want to update\n" +
                                    "1.name\n" +
                                    "2.Address\n" +
                                    "3.Department\n" +
                                    "4.Want you to Update all\n" +
                                    "Enter the choice");
                            int c=sc.nextInt();
                            if(c==1){
                                logger.info("enter the name");
                                String upname=sc.next();
                                Update.updateName(setid,upname);
                            }else if(c==2){
                                logger.info("enter the Address");
                                String upAdd=sc.next();
                                Update.updateAddress(setid,upAdd);
                            }else if(c==3){
                                logger.info("enter the Department");
                                String upDept=sc.next();
                                Update.updateDept(setid,upDept);
                            }else if(c==4){
                                logger.info("enter the name");
                                String up1=sc.next();
                                logger.info("enter the Address");
                                String up2=sc.next();
                                logger.info("enter the Department");
                                String up3=sc.next();
                                Update.setUpdate(setid,up1,up2,up3);
                            }else{
                                logger.info("please enter correct choice");
                            }
                        }else{
                            logger.info(setid+" Not presented in Database");
                        }



                    }catch (SQLException ex) {
                        logger.error("error is "+ex);
                    }
                    break;

                case 4:logger.info("Enter the id to delete");
                    int did=sc.nextInt();
                    Delete.del(did);
                    break;

                case 5:
                    logger.info("Enter the id for specific data");
                    int sid=sc.nextInt();
                    SpecificData.dis2(sid);
                    break;

                default:
                    logger.info("select above mentioned");
            }
            logger.info("do you want to continue click 1 or stop click 0");
            int p=sc.nextInt();
            if(p==0){
                break;
            }
        }
    }
}
