/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.ConexionMySQL;
import Views.Login;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author NESTORPC
 */
public class GoprosolVentas {

    ConexionMySQL conection;

    public GoprosolVentas() {
        this.conection = new ConexionMySQL();
    }

    public void addSale(String vendor, String client, int idclient) {

    }

    public void addClient(String name, String lastName) throws Exception {
        Connection conn = conection.conectarMySQL();
        int result = 0;
        String query = "INSERT INTO client (client_name , client_lastname) values (  '" + name + "','" + lastName + "'  ) ";
        try {
            Statement st = conn.createStatement();
            st.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "CLIENT ADDED");

        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    public void addVendor(String name) throws Exception {
        Connection conn = conection.conectarMySQL();
        int result = 0;
        String query = "INSERT INTO vendors (vendor_name) values ( '" + name + "') ";
        try {
            Statement st = conn.createStatement();
            st.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "VENDOR ADDED");

        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    public sales returnlastSale() {
        sales lastSales = new sales();
        Connection conn = conection.conectarMySQL();
        int result = 0;
        String query = "Select id ,sale_description ,FK_vendors, po_sales  from sales order by id desc limit 1";

        try {

            Statement st = conection.conectarMySQL().createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {

                lastSales = new sales(rs.getInt("id"), rs.getString("sale_description"), rs.getInt("FK_vendors"), rs.getString("po_sales"));
            }

        } catch (SQLException e) {
            e.getMessage();
        }

        return lastSales;
    }

    public static Calendar toCalendar(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

    public String creatingDatePo(Date date) {
        Calendar cal = toCalendar(date);

        DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        format.format(date);
        cal = format.getCalendar();
        String tempDay = "";
        String tempYears = getYearsbyDate(cal.get(Calendar.YEAR));
        String tempMonth = getMonthbyDate(cal.get(Calendar.MONTH) + 1);
        if (cal.get(Calendar.DAY_OF_MONTH) < 10) {
            tempDay = "0" + String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
        } else {

            tempDay = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
        }

        return tempYears + tempMonth + tempDay;
    }

    public String creatingPo(Date date, client newClient, vendor v, String description) {
        try {
            Connection conn = conection.conectarMySQL();
            creatingDatePo(date);
            Scanner scanner = new Scanner(System.in);
            String full_Name = newClient.getNombreyapellido();

            String firstcharacterlastName = (full_Name.split(" ")[1].trim()).substring(0, 1);
            String firstcharacterName = (newClient.getNombreyapellido()).substring(0, 1);

            String tempfirstSales = "01";
            String minusChar = "-";

            if (notSaleInsertedToday(date) == true || notSaleInserted() == true) {

                return creatingDatePo(date) + tempfirstSales + minusChar + firstcharacterName + firstcharacterlastName;
            } else {

                int result = 0;
                String query = " SELECT  SUBSTRING_INDEX(po_sales,'-', 1) AS indice,SUBSTRING(po_sales, 1,4) AS subst FROM clients_sales HAVING subst = '" + creatingDatePo(date) + "' order by indice DESC LIMIT 1 ";
                Statement st = conection.conectarMySQL().createStatement();
                ResultSet rs = st.executeQuery(query);

                String lastPo = "";

                while (rs.next()) {
                    lastPo = rs.getString("indice");
                }
                String temIncDay = "";
                int tempInc = Integer.parseInt(lastPo.substring(4, 6)) + 1;

                if (tempInc < 10) {
                    temIncDay = "0" + String.valueOf(tempInc);
                } else {
                    temIncDay = String.valueOf(tempInc);

                }

                return creatingDatePo(date) + temIncDay + minusChar + firstcharacterName + firstcharacterlastName;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "WE COULDN'T CREATE A PO NUMBER");
        }
        return "";

    }

    public String getMonthbyDate(int month) {

        String stringmonth = ascciByNumber(month);
        return stringmonth;
    }

    public String getYearsbyDate(int year) {

        String subSTr = String.valueOf(year);
        String years = subSTr.substring(2, 4);
        return ascciByNumber(Integer.parseInt(years));
    }

    public String ascciByNumber(int number) {
        int var = number + 64;
        char c = (char) var;
        String stringValueOf = String.valueOf(c);
        return stringValueOf;
    }

    public void refillCLient(JComboBox combo) {

        Connection conn = conection.conectarMySQL();
        int result = 0;
        String query = "select CONCAT_WS(' ', client_name, client_lastname) as client_name , id  from client";

        try {

            Statement st = conection.conectarMySQL().createStatement();
            ResultSet rs = st.executeQuery(query);

            combo.addItem("ADD A CLIENT");

            while (rs.next()) {
                combo.addItem(new client(rs.getString("client_name"), rs.getInt("id")));

            }

        } catch (SQLException e) {

            e.getMessage();
        }

    }

    public void refillVendor(JComboBox combo) {

        int result = 0;
        String query = "select vendor_name, idvendors  from vendors";

        try {

            Statement st = conection.conectarMySQL().createStatement();
            ResultSet rs = st.executeQuery(query);

            combo.addItem("ADD A VENDOR");

            while (rs.next()) {
                combo.addItem(new vendor(rs.getString("vendor_name"), rs.getInt("idvendors")));

            }

        } catch (SQLException e) {

            e.getMessage();
        }

    }

    public void insertSales(vendor v, Date date, String description, ArrayList<client> clients) {
        java.sql.Date date2 = new java.sql.Date(date.getTime());

        try {
         

                Connection conn = conection.conectarMySQL();
                int result = 0;

                String query = "INSERT INTO sales (sale_description,FK_vendors) VALUES"
                        + "('" + description + " ',' " + v.getId() + " ')";
                Statement st = conn.createStatement();
                st.executeUpdate(query);

                String query2 ="SELECT MAX(id) As lastId from sales";
                 Statement st1 = conn.createStatement();
                ResultSet rs1 = st1.executeQuery(query2);
                int idSale = 0 ; 
                
                while (rs1.next()){
                idSale=rs1.getInt("lastId");
                
                }
                 for (int i = 0; i < clients.size(); i++) {
                
                     
                 String query3 = "INSERT INTO clients_sales"
                        + "(FK_idventas, FK_idclients, po_sales) VALUES"
                        + "('" + idSale + "','" + clients.get(i).getId() + "','" + creatingPo(date, clients.get(i), v, description) + " ')";
                Statement st2 = conn.createStatement();
                st2.executeUpdate(query3);
                
                 }
                
                 JOptionPane.showMessageDialog(null, "SALE INSERTED !!!!!!");
                

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }
    

    public boolean notSaleInserted() {
//Verifing if we have sales inserted in the database  ; 
        boolean var = false;
        Connection conn = conection.conectarMySQL();
        int result = 0;
        String query = "select * from sales";

        try {

            Statement st = conection.conectarMySQL().createStatement();
            ResultSet rs = st.executeQuery(query);
            int total = 0;
            while (rs.next()) {
                //Obtienes la data que necesitas...
                total++;
            }
            
            
            if (total == 0) {
                return true;
            } else {
                return var;
            }

        } catch (SQLException e) {

            e.getMessage();
        }

        return var;
    }

    public Calendar convertPotoCalendar(String po) {

        Calendar cal = Calendar.getInstance();
        char year = po.charAt(0);
        char month = po.charAt(1);
        int asciiValueYear = (int) year;
        int asciiValueMonth = (int) month;
        int valueofDay = Integer.parseInt(po.substring(2, 4));
        cal.set(asciiValueYear - 64, asciiValueMonth - 1, valueofDay);
        return cal;
    }

    public boolean notSaleInsertedToday(Date date) {
        // Verifing if we have sales diferents at  date inserted
        String po = creatingDatePo(date);
        boolean var = false;

        int result = 0;
        // String query = "select date_inserted from sales where DATE_FORMAT(date_inserted , '%m/%d/%Y')= '" + date + "' ";
        String query2 = "select po_sales from clients_sales having SUBSTRING(po_sales, 1, 4) = '" + po + "' ";
      //  String query2 = "select po_sales from clients_sales";

        try {

            Statement st = conection.conectarMySQL().createStatement();
            ResultSet rs = st.executeQuery(query2);
           
            int total = 0;
            while (rs.next()) {
                //Obtienes la data que necesitas...
                total++;
            }
            if (total == 0) {

                return true;
            } else {
                return var;
            }

        } catch (SQLException e) {

            e.getMessage();
        }

        return var;

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Login.main(args);
// TODO code application logic here
    }

}
