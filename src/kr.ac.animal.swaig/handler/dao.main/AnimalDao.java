package handler.dao.main;

import common.sql.DBConnect;
import handler.dto.GetAnimalRes;
import handler.dto.PostAnimalReq;

import java.sql.*;
import java.util.ArrayList;

public class AnimalDao {
    
    static DBConnect dBConnect=new DBConnect();
    

    public static ArrayList<GetAnimalRes> getAnimalList() {

        ArrayList<GetAnimalRes> list = new ArrayList<>();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            con = DBConnect.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("SELECT animalName,animalBirth,animalType,animalKind, master,phoneNumber FROM animal order by createdDate desc ");
            while(rs.next()) {
                list.add(new GetAnimalRes(rs.getString(1),rs.getString(2),rs.getString(3),
                        rs.getString(4),rs.getString(5),rs.getString(6)));

            }
        }catch(Exception e) {
            e.getStackTrace();
        }finally {
            try {
                con.close(); con = null;
                st.close(); st = null;
                rs.close(); rs=null;
            }catch(Exception e) {
                e.getStackTrace();
            }
        }

        return list;
    }

    public static ArrayList<GetAnimalRes> searchAnimalList(String name) {
        ArrayList<GetAnimalRes> list = new ArrayList<>();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            con = DBConnect.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("select animalName,animalBirth,animalType,animalKind, master,phoneNumber FROM animal where animalName like '%" + name+  "%' ");
            while(rs.next()) {
                list.add(new GetAnimalRes(rs.getString(1),rs.getString(2),rs.getString(3),
                        rs.getString(4),rs.getString(5),rs.getString(6)));

            }
        }catch(Exception e) {
            e.getStackTrace();
        }finally {
            try {
                con.close(); con = null;
                st.close(); st = null;
                rs.close(); rs=null;
            }catch(Exception e) {
                e.getStackTrace();
            }
        }

        return list;
    }

    public static ArrayList<GetAnimalRes> filterAnimalList(String name ,String filter) {
        ArrayList<GetAnimalRes> list = new ArrayList<>();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;


        try {
            con = DBConnect.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("select animalName,animalBirth,animalType,animalKind, master,phoneNumber FROM animal where "+ name  + " order by " + filter+  " desc ");
            while(rs.next()) {
                list.add(new GetAnimalRes(rs.getString(1),rs.getString(2),rs.getString(3),
                        rs.getString(4),rs.getString(5),rs.getString(6)));

            }
        }catch(Exception e) {
            e.getStackTrace();
        }finally {
            try {
                con.close(); con = null;
                st.close(); st = null;
                rs.close(); rs=null;
            }catch(Exception e) {
                e.getStackTrace();
            }
        }

        return list;
    }

    public static void insertAnimal(PostAnimalReq postAnimalReq) {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            con = DBConnect.getConnection();
            st=con.createStatement();
            int stmt=st.executeUpdate("insert into animal(animalName,animalBirth,animalType,animalKind,master,phoneNumber) " +
                    "values('"+postAnimalReq.getAnimalName()+"', '"+ postAnimalReq.getAnimalBirth()+"',' "+postAnimalReq.getAnimalType()+"',' "+postAnimalReq.getAnimalKind()+"'," +
                    "' "+postAnimalReq.getMaster()+"',' "+postAnimalReq.getPhoneNumber()+"');");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally{
            try {
                st.close();
            }
            catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
    }

}
