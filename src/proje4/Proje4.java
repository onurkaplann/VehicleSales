/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje4;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ABRA
 */
public class Proje4 {
    private static String kullaniciadi="root";
    private static String parola="";
    private static String host="127.0.0.1";
    private static String db="test";
    private static int port=3306;
    private static Connection conn=null;
    private static ResultSet rs=null;
    private static Statement pst=null;
   //Muhammed Ali Dilekçi 160202093
   //Onur Kaplan 160202061
    public static void main(String[] args) {
        // TODO code application logic here
        String url="jdbc:mysql://"+host+":"+port+"/"+db;
               try{
                   Class.forName("com.mysql.jdbc.Driver");
               }
               catch(ClassNotFoundException e){
                   System.out.println("mysql connector yok");
                   e.printStackTrace();
               }
               try{
                   conn= (Connection) DriverManager.getConnection(url,kullaniciadi,parola);
               }
               catch(SQLException e){
                   System.out.println("Baglanti basarisiz");
                   e.printStackTrace();
               }
               if(conn!=null){
                   System.out.println("basardik");
               }
               else{
                   System.out.println("basarisiz");
               }
                Giris g = new Giris();
                g.setVisible(true);
        
               
               
    }
    
}