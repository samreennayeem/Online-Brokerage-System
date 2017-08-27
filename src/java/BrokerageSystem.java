/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;


/**
 *
 * @author Samreen
 */
@Named(value = "brokerageSystem")
@ManagedBean
@SessionScoped
public class BrokerageSystem implements Serializable {

    /**
     * Creates a new instance of BrokerageSystem
     */
   
     private String ssn;
    private String name;
    private String pswd;
    private String question1;
    private String answer1;
    private String question2;
    private String answer2;
    private String id;
    private String s;
    private String p;
    private String sans;
    private String userans;
    private double deposit;
    private String input;
   // private int loginattempt;
    private String inputtradetype;
    private String inputsymbol;
    private String reply;
    private int tradequantity;
    private String inputordertype;
    private double tradeprice;
    private int Ordernum=1;
    private ArrayList<OrderDetails> List = new ArrayList<>();
    
   
    public ArrayList<OrderDetails> getList() {
        return List;
    }

//    public BrokerageSystem()
//    {
//   
//    }
    public void setList(ArrayList<OrderDetails> List) {    
        this.List = List;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    public String getQuestion1() {
        return question1;
    }

    public void setQuestion1(String question1) {
        this.question1 = question1;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getQuestion2() {
        return question2;
    }

    public void setQuestion2(String question2) {
        this.question2 = question2;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public String getP() {
        return p;
    }

    public void setP(String p) {
        this.p = p;
    }

    public String getSans() {
        return sans;
    }

    public void setSans(String sans) {
        this.sans = sans;
    }

    public String getUserans() {
        return userans;
    }

    public void setUserans(String userans) {
        this.userans = userans;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getInputtradetype() {
        return inputtradetype;
    }

    public void setInputtradetype(String inputtradetype) {
        this.inputtradetype = inputtradetype;
    }

    public String getInputsymbol() {
        return inputsymbol;
    }

    public void setInputsymbol(String inputsymbol) {
        this.inputsymbol = inputsymbol;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public int getTradequantity() {
        return tradequantity;
    }

    public void setTradequantity(int tradequantity) {
        this.tradequantity = tradequantity;
    }

    public String getInputordertype() {
        return inputordertype;
    }

    public void setInputordertype(String inputordertype) {
        this.inputordertype = inputordertype;
    }

    public double getTradeprice() {
        return tradeprice;
    }

    public void setTradeprice(double tradeprice) {
        this.tradeprice = tradeprice;
    }

    public int getOrdernum() {
        return Ordernum;
    }

    public void setOrdernum(int Ordernum) {
        this.Ordernum = Ordernum;
    }
    
    
    //methods
     public String signup()
    {
        //load the driver
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
           
        }
         
         
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        final String DB_URL = "jdbc:mysql://mis-sql.uhcl.edu/nayeems9017";      
        try
        { 
            //connect to the database with user name and password
            conn = DriverManager.getConnection(DB_URL, 
                    "nayeems9017", "1452185");   
            stat = conn.createStatement();
            //to search an onlineaccount based on id or ssn
            rs = stat.executeQuery("Select * from onlineaccountDB "
                    + "where id = '" + 
                    id + "' or ssn = '" + ssn + "'" );
            
            if(rs.next())
            {
                 return("Account createion failed beacause account already exists");
            }
            else
            {
                stat.executeUpdate("Insert into onlineaccountDB values('"+ssn +"','"+name+"',"+id+",'"+pswd+"','"+question1+"','"+answer1+"','"+question2+"','"+answer2+"','"+deposit+"','active',0)");
                return ("Registration Successful! Please "
                         + "return to login your account.");
                
            }   
        }
        catch (SQLException e)
        {
           
            //return ("Internal Error! Please try again later.");
             
        }
        finally
        {
            try
            {
                rs.close();
                stat.close();
                conn.close();
                
            }
            catch (Exception e)
            {
                 
                e.printStackTrace();
            }
        }
    
         return("Successfull sign up!");
    }//signup
     
     public String login()
     {
          try
        {
            Class.forName("com.mysql.jdbc.Driver");
            
        }
        catch (Exception e)
        {
            return ("Internal Error! Please try again later.");
        }
         
         
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        final String DB_URL = "jdbc:mysql://mis-sql.uhcl.edu/nayeems9017";  
        
         try
        {
           conn = DriverManager.getConnection(DB_URL, "nayeems9017", "1452185");
           stat = conn.createStatement();
           //find the record
           rs= stat.executeQuery("Select * from onlineaccountDB where id = '" +id+"' ");
           
           if(rs.next())
           {
               //to check number of attempts- if its 3 or less than 3
              
               if("active".equals(rs.getString("Status")))
               {
               //check for password
               if(pswd.equals(rs.getString("Pswd")))
               {
                   //login successfull
                    //using stat because we just need to update it
                    stat.executeUpdate("Update onlineaccountDB set LoginAttempt = 0 where id = "+id+"  ");
                     //menu(id);
                  
               }
               else
               {
                   //Invalid password
                   //return("**** You have entered invalid password ****");
                   stat.executeUpdate("Update onlineaccountDB set LoginAttempt = loginAttempt+1 where id="+id+" " );
                   
                   rs = stat.executeQuery("Select * from onlineaccountDB where id="+id+"");
                   rs.next();
                 //return("Number of failed attempts: "+ "rs.getInt(\"LoginAttempt\")");
                  
                  
                  
                   if(rs.getInt(11)>=2)
                   {
                       stat.executeUpdate("Update onlineaccountDB set Status = 'locked' where id="+id+" ");
                   }
                    System.out.println("");
               }
               }//if(status is active)
               else
               {
                   //if locked
                   QuestionRetrieval();
               }
           }
           else
           {
               //invalid login id
              return("You have entered invalid login id");
              
           }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
             try
            {
                rs.close();
                stat.close();
                conn.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
               
            }
        }
         return("Login Successfull");
     }//login
    
     
     
     
     
      public String QuestionRetrieval()
     {
          try
        {
            Class.forName("com.mysql.jdbc.Driver");
            
        }
        catch (Exception e)
        {
            return ("Internal Error! Please try again later.");
        }
         
         
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        final String DB_URL = "jdbc:mysql://mis-sql.uhcl.edu/nayeems9017"; 
        
        Random rnd = new Random();
        int a =rnd.nextInt(2);
        
        try
        {
            conn = DriverManager.getConnection(DB_URL, "nayeems9017", "1452185");
           stat = conn.createStatement();
           rs=stat.executeQuery("Select * from onlineaccountDB where id="+id+"");
           rs.next();
            if(a==0)
             {
                  s=rs.getString("Question1");
                  //sans=rs.getString("answer1");
                 //s= stat.executeUpdate("Select Question1 from onlineaccountDB where id="+id+"");
             }
             else if(a==1)
             {
                   s=rs.getString("Question2");
                   //sans=rs.getString("Answer2");
                     //s= stat.executeUpdate("Select Question2 from onlineaccountDB where id="+id+"");
             }
           
//            if(userans.equals(sans))
//            {
//                
//                p=rs.getString("Pswd");
//                //return("Your password is: "+p);
//                stat.executeUpdate("Update onlineaccountDB set LoginAttempt = 0 , Status = 'active' where id='"+rs.getString("Id")+"'   " );
//                 // login();
//            }
//            else
//            {
//             //login();   
//            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
             try
            {
                rs.close();
                stat.close();
                conn.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
               
            }
        }
        return("Your question  is: "+s);
     }//question retireval
     
     
     
     
     
     
     
     
     
     public String PswdRetrieval()
     {
          try
        {
            Class.forName("com.mysql.jdbc.Driver");
            
        }
        catch (Exception e)
        {
            return ("Internal Error! Please try again later.");
        }
         
         
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        final String DB_URL = "jdbc:mysql://mis-sql.uhcl.edu/nayeems9017"; 
        
//        Random rnd = new Random();
//        int a =rnd.nextInt(2);
        
        try
        {
            conn = DriverManager.getConnection(DB_URL, "nayeems9017", "1452185");
           stat = conn.createStatement();
           rs=stat.executeQuery("Select * from onlineaccountDB where id="+id+" and (question1='"+s+"' or question2='"+s+"')     ");
           rs.next();
           if(rs.getString("question1").equals(s))
           {
                sans=rs.getString("answer1");
           }
           else if(rs.getString("question2").equals(s))
           {
               sans=rs.getString("answer2");
           }
          
//            if(a==0)
//             {
//                  s=rs.getString("Question1");
//                  sans=rs.getString("answer1");
//                 //s= stat.executeUpdate("Select Question1 from onlineaccountDB where id="+id+"");
//             }
//             else if(a==1)
//             {
//                   s=rs.getString("Question2");
//                   sans=rs.getString("Answer2");
//                     //s= stat.executeUpdate("Select Question2 from onlineaccountDB where id="+id+"");
//             }
           
            if(userans.equals(sans))
            {
                
                p=rs.getString("Pswd");
                //return("Your password is: "+p);
                stat.executeUpdate("Update onlineaccountDB set LoginAttempt = 0 , Status = 'active' where id='"+rs.getString("Id")+"'   " );
                 // login();
            }
            else
            {
             p = sans;//login();   
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
             try
            {
                rs.close();
                stat.close();
                conn.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
               
            }
        }
        return("Your password is: "+p);
     }//pswd retireval
     
     
     
     
     public String SearchList()
    {
       
          try
        {
            Class.forName("com.mysql.jdbc.Driver");
            
        }
        catch (Exception e)
        {
            return ("Internal Error! Please try again later.");
        }
       
        
        final String DB_URL = "jdbc:mysql://mis-sql.uhcl.edu/nayeems9017";
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        ResultSet r= null;
    
        try
        {
           conn = DriverManager.getConnection(DB_URL, "nayeems9017", "1452185");
           stat = conn.createStatement();
           rs= stat.executeQuery("Select * from stock where symbol = '" +inputsymbol+"' ");
           
           // System.out.println("Symbol"+"\t"+"Stock Name"+"\t"+"Last Traded Price");
            
           if(rs.next())
           {
               return(rs.getString("Symbol")+"\t"+rs.getString("Stock_name")+"\t"+rs.getDouble("LastTradedPrice"));
           }
           
          
        }//try
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
             try
            {
                rs.close();
                stat.close();
                conn.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
               
            }
        }
        return("Stock not found");
        
    }//searchlist
     
     
     
     
     
     
     
     public String TradeStocks(String tradeselection)
    {
         try
        {
            Class.forName("com.mysql.jdbc.Driver");
            
        }
        catch (Exception e)
        {
            return ("Internal Error! Please try again later.");
        }
        ArrayList<OrderDetails> OrderList = new ArrayList<>();
        int availableQuantity=0;
        
//      
//        
         final String DB_URL = "jdbc:mysql://mis-sql.uhcl.edu/nayeems9017";
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        ResultSet r= null;
    
        try
        {
           conn = DriverManager.getConnection(DB_URL, "nayeems9017", "1452185");
           stat = conn.createStatement();
          
          
           if("M".equals(inputordertype))
                
           {
               rs = stat.executeQuery("Select LastTradedPrice from stock where Symbol = '"+inputsymbol+"'");
               if(rs.next())
               {
                   tradeprice=rs.getDouble(1);
               }
           }
           inputtradetype=tradeselection;
           if("2".equals(inputtradetype))
           {
               //Before initiating the sell, check if the user owns enough quantity of the stock
                rs= stat.executeQuery("Select * from userstock where id = '" +id+"' and Symbol = '"+inputsymbol+"' and Quantity >= '"+tradequantity+"'");
                if(!rs.next())
                {
                    
                    return("**** You do not own enough quantity of this stock to trade ****");
                    
                }
                else //Sell Trade logic
                {
                    //Update user stock to reduce the number of stock - If Trade Quantity = Quantity, delete row else reduce the quantity (Blocked for Sale logic?)
                    if(rs.getInt("Quantity")==tradequantity)
                    {
                        //If users own exact qunatity of stock they are trying to sell, delete the entry from the User stock table
                        stat.executeUpdate("Delete from userstock where id = " +id+" and Symbol = '"+inputsymbol+"'");
                    }
                    else
                    {
                        // else if user owns more stocks than the quantity offered for sale then just reduce the quantity for that entry
                        stat.executeUpdate("Update userstock set Quantity = Quantity - "+tradequantity+" where id = '" +id+"' and Symbol = '"+inputsymbol+"'");
                    }
                    
                    if("L".equals(inputordertype))
                    {// Identify buy orders to match the sale deal which are either Market orders or Limit order satisfying my price range
                      rs= stat.executeQuery("Select * from orders where id <> " +id+" and Symbol = '"+inputsymbol+"' and StatusOfOrder <> 'Completed' and TypeOfTrade = 'buy' and (TypeOfOrder = 'M' or (TypeOfOrder = 'L' and OrderPrice >= '"+tradeprice+"')) order by OrderPrice desc" );  
                    }
                    else
                    {// For market orders, price is not really a criteria
                      rs= stat.executeQuery("Select * from orders where id <> " +id+" and Symbol = '"+inputsymbol+"' and StatusOfOrder <> 'Completed' and TypeOfTrade = 'Buy' order by OrderPrice desc");
                    }
                    
                    while(rs.next())
                    {
                        OrderList.add(new OrderDetails(rs.getString("Symbol"),rs.getInt("Id"),rs.getInt("OrderNum"),rs.getString("TypeOfTrade"),rs.getString("TypeOfOrder"),rs.getString("StatusOfOrder"),rs.getInt("OrderQuantity"),rs.getInt("CompletedQuantity"),rs.getInt("PendingQuantity"),rs.getDouble("OrderPrice"),rs.getDouble("LastTradedPrice"),"n"));
                        availableQuantity = availableQuantity +rs.getInt("pendingQuantity");
                    }
                    
                    rs= stat.executeQuery("Select max(OrderNum) from orders");
                    if(rs.next())
                    {
                       Ordernum =  rs.getInt(1) + 1;
                    }
                    if(availableQuantity==0)
                    {
                        String query = "Insert into orders values('"+inputsymbol+"'," +id+",'"+Ordernum+"','sell','"+inputordertype+"','pending',"+tradequantity+",0,"+tradequantity+","+tradeprice+",0.0)";
                        //System.out.println(query);
                        stat.executeUpdate(query);
                       
                        //Insert order in the order table as pending with Completed Quantity = 0 and Pending Quantity = trade quantity
                        
                    }
                    else if(tradequantity<=availableQuantity) //More buy offers existing than the user wants to sell
                    {
                        //Insert order in the order table as completed with Completed Quantity = tradequantity and Pending Quantity = 0
                        //Update order table for records matching this order
                        //Update userstock table with entries or quantities from this order
                        int checkQ=tradequantity;
                        double LastTradedPrice = 0.0;
                        for(int i=0;i<OrderList.size();i++)
                        {//CheckQ is the quantity required to fulfil the sale order
                                if(OrderList.get(i).pendingQuantity < checkQ)
                                {
                                   OrderList.get(i).matchedOrder = "y";
                                   OrderList.get(i).completedQuantity = OrderList.get(i).completedQuantity + OrderList.get(i).pendingQuantity;
                                  OrderList.get(i).tradedQuantity = OrderList.get(i).pendingQuantity;
                                  OrderList.get(i).pendingQuantity = 0;
                                  OrderList.get(i).statusOfOrder ="completed";
                                  OrderList.get(i).tradedQuantity = OrderList.get(i).pendingQuantity;
                                  checkQ = checkQ-OrderList.get(i).pendingQuantity; 
                                  
                                }
                                else if(OrderList.get(i).pendingQuantity >= checkQ)
                                {
                                  OrderList.get(i).matchedOrder = "y";
                                  OrderList.get(i).completedQuantity = OrderList.get(i).completedQuantity + checkQ;
                                  OrderList.get(i).pendingQuantity = OrderList.get(i).pendingQuantity - checkQ;
                                  OrderList.get(i).tradedQuantity = checkQ;
                                  if(OrderList.get(i).pendingQuantity == 0)
                                  {
                                      OrderList.get(i).statusOfOrder ="completed";
                                  }
                                  LastTradedPrice = OrderList.get(i).orderPrice;
                                  break; //
                                }
                        }
                        stat.executeUpdate("Insert into orders values('"+inputsymbol+"','" +id+"','"+Ordernum+"','sell','"+inputordertype+"','completed',"+tradequantity+","+tradequantity+",0,"+tradeprice+","+LastTradedPrice+")");
                        for(int i=0;i<OrderList.size();i++)
                        {
                            if(OrderList.get(i).matchedOrder == "y")
                            {
                                stat.executeUpdate("Update orders set StatusOfOrder = '"+OrderList.get(i).statusOfOrder+"',CompletedQuantity= "+OrderList.get(i).completedQuantity+",PendingQuantity= "+OrderList.get(i).pendingQuantity+" where OrderNum = "+OrderList.get(i).orderNum+"");
                            }
                            rs= stat.executeQuery("Select * from userstock where id = '" +OrderList.get(i).userId+"' and Symbol = '"+inputsymbol+"'");
                            if(rs.next())//If buyer already owns that stock, increase the quantity. If buyer is newly purchasing it, insert a new record for that stock
                            {
                                stat.executeUpdate("Update userstock set Quantity = Quantity + "+OrderList.get(i).tradedQuantity+" where id = '" +OrderList.get(i).userId+"' and Symbol = '"+inputsymbol+"'");
                            }
                            else
                            {
                                stat.executeUpdate("Insert into userstock values('"+OrderList.get(i).userId+"','"+inputsymbol+"',"+OrderList.get(i).tradedQuantity+")");
                            }
                        }
                        stat.executeUpdate("Update stock set LastTradedPrice = "+LastTradedPrice+" where Symbol = '"+inputsymbol+"'");
                 
                                                
                    }
                    else if(tradequantity>availableQuantity)
                    {
                        double LastTradedPrice = 0.0;
                        ////Insert order in the order table as pending with Completed Quantity = Available and Pending Quantity = tradequantity - Available
                        ///Update order table for records matching this order
                        ///Update userstock table with entries or quantities from this order
                        for(int i=0;i<OrderList.size();i++)
                            {
                                OrderList.get(i).matchedOrder = "y";
                                OrderList.get(i).completedQuantity = OrderList.get(i).completedQuantity + OrderList.get(i).pendingQuantity;
                                OrderList.get(i).pendingQuantity = 0;
                                OrderList.get(i).statusOfOrder ="completed";
                                LastTradedPrice = OrderList.get(i).orderPrice;
                            }
                        stat.executeUpdate("Insert into orders values('"+inputsymbol+"','" +id+"','"+Ordernum+"','sell','"+inputordertype+"','pending',"+tradequantity+","+availableQuantity+","+(tradequantity - availableQuantity)+","+tradeprice+","+LastTradedPrice+")");
                        for(int i=0;i<OrderList.size();i++)
                        {
                            if(OrderList.get(i).matchedOrder == "y")
                            {
                                stat.executeUpdate("Update orders set StatusOfOrder = '"+OrderList.get(i).statusOfOrder+"',CompletedQuantity= "+OrderList.get(i).completedQuantity+",PendingQuantity= "+OrderList.get(i).pendingQuantity+" where OrderNum = "+OrderList.get(i).orderNum+"");
                            }
                            rs= stat.executeQuery("Select * from userstock where id = '" +OrderList.get(i).userId+"' and Symbol = '"+inputsymbol+"'");
                            if(rs.next())
                            {
                                stat.executeUpdate("Update userstock set Quantity = Quantity + "+OrderList.get(i).tradedQuantity+" where id = '" +OrderList.get(i).userId+"' and Symbol = '"+inputsymbol+"'");
                            }
                            else
                            {
                                stat.executeUpdate("Insert into userstock values('"+OrderList.get(i).userId+"','"+inputsymbol+"',"+OrderList.get(i).tradedQuantity+")");
                            }
                        }
                        stat.executeUpdate("Update stock set LastTradedPrice = "+LastTradedPrice+" where Symbol = '"+inputsymbol+"'");
                    }
                
                }
                   
           }
           else if("1".equals(inputtradetype))//Buy Trade logic
           {
                    //Update user stock to reduce the number of stock - If Trade Quantity = Quantity, delete row else reduce the quantity (Blocked for Sale logic?)
                    if("L".equals(inputordertype))
                    {
                      rs= stat.executeQuery("Select * from orders where id <> " +id+" and Symbol = '"+inputsymbol+"' and StatusOfOrder <> 'Completed' and TypeOfTrade = 'sell' and (TypeOfOrder = 'M' or (TypeOfOrder = 'L' and OrderPrice <= '"+tradeprice+"' ))order by OrderPrice asc" );  
                    }
                    else
                    {
                      rs= stat.executeQuery("Select * from orders where id <> " +id+" and Symbol = '"+inputsymbol+"' and StatusOfOrder <> 'Completed' and TypeOfTrade = 'sell' order by OrderPrice asc");
                    }
                    
                    while(rs.next())
                    {
                        OrderList.add(new OrderDetails(rs.getString("Symbol"),rs.getInt("Id"),rs.getInt("OrderNum"),rs.getString("TypeOfTrade"),rs.getString("TypeOfOrder"),rs.getString("StatusOfOrder"),rs.getInt("OrderQuantity"),rs.getInt("CompletedQuantity"),rs.getInt("PendingQuantity"),rs.getDouble("OrderPrice"),rs.getDouble("LastTradedPrice"),"n"));
                        availableQuantity = availableQuantity +rs.getInt("pendingQuantity");
                    }
                    
                    rs= stat.executeQuery("Select max(OrderNum) from orders");
                    if(rs.next())
                    {
                       Ordernum =  rs.getInt(1) + 1;
                    }
                    if(availableQuantity==0)
                    {
                        String query = "Insert into orders values('"+inputsymbol+"'," +id+",'"+Ordernum+"','buy','"+inputordertype+"','pending',"+tradequantity+",0,"+tradequantity+","+tradeprice+",0.0)";
                        //System.out.println(query);
                        stat.executeUpdate(query);
                        //Insert order in the order table as pending with Completed Quantity = 0 and Pending Quantity = trade quantity
                        
                    }
                    else if(tradequantity<=availableQuantity)
                    {
                        //Insert order in the order table as completed with Completed Quantity = tradequantity and Pending Quantity = 0
                        //Update order table for records matching this order
                        //Update userstock table with entries or quantities from this order
                        int checkQ=tradequantity;
                        double LastTradedPrice = 0.0;
                        for(int i=0;i<OrderList.size();i++)
                        {
                                if(OrderList.get(i).pendingQuantity < checkQ)
                                {
                                   OrderList.get(i).matchedOrder = "y";
                                   OrderList.get(i).completedQuantity = OrderList.get(i).completedQuantity + OrderList.get(i).pendingQuantity;
                                  OrderList.get(i).pendingQuantity = 0;
                                  OrderList.get(i).statusOfOrder ="completed";
                                  checkQ = checkQ-OrderList.get(i).pendingQuantity; 
                                  
                                }
                                else if(OrderList.get(i).pendingQuantity >= checkQ)
                                {
                                  OrderList.get(i).matchedOrder = "y";
                                  OrderList.get(i).completedQuantity = OrderList.get(i).completedQuantity + checkQ;
                                  OrderList.get(i).pendingQuantity = OrderList.get(i).pendingQuantity - checkQ;
                                  if(OrderList.get(i).pendingQuantity == 0)
                                  {
                                      OrderList.get(i).statusOfOrder ="completed";
                                  }
                                  LastTradedPrice = OrderList.get(i).orderPrice;
                                  break;
                                }
                        }
                        stat.executeUpdate("Insert into orders values('"+inputsymbol+"','" +id+"','"+Ordernum+"','buy','"+inputordertype+"','completed',"+tradequantity+","+tradequantity+",0,"+tradeprice+","+LastTradedPrice+")");
                        for(int i=0;i<OrderList.size();i++)
                        {
                            if(OrderList.get(i).matchedOrder == "y")
                            {
                                stat.executeUpdate("Update orders set StatusOfOrder = '"+OrderList.get(i).statusOfOrder+"',CompletedQuantity= "+OrderList.get(i).completedQuantity+",PendingQuantity= "+OrderList.get(i).pendingQuantity+" where OrderNum = "+OrderList.get(i).orderNum+"");
                                
                            }
                        }
                        stat.executeUpdate("Update stock set LastTradedPrice = "+LastTradedPrice+" where Symbol = '"+inputsymbol+"'");
                        
                        rs= stat.executeQuery("Select * from userstock where id = '" +id+"' and Symbol = '"+inputsymbol+"'");
                            if(rs.next())
                            {
                                stat.executeUpdate("Update userstock set Quantity = Quantity + "+tradequantity+" where id = '" +id+"' and Symbol = '"+inputsymbol+"'");
                            }
                            else
                            {
                                stat.executeUpdate("Insert into userstock values("+id+",'"+inputsymbol+"',"+tradequantity+")");
                            }
                 
                                                
                    }
                    else if(tradequantity>availableQuantity)
                    {
                        double LastTradedPrice = 0.0;
                        ////Insert order in the order table as pending with Completed Quantity = Available and Pending Quantity = tradequantity - Available
                        ///Update order table for records matching this order
                        ///Update userstock table with entries or quantities from this order
                        for(int i=0;i<OrderList.size();i++)
                            {
                                OrderList.get(i).matchedOrder = "y";
                                OrderList.get(i).completedQuantity = OrderList.get(i).completedQuantity + OrderList.get(i).pendingQuantity;
                                OrderList.get(i).pendingQuantity = 0;
                                OrderList.get(i).statusOfOrder ="completed";
                                LastTradedPrice = OrderList.get(i).orderPrice;
                            }
                        stat.executeUpdate("Insert into orders values('"+inputsymbol+"','" +id+"','"+Ordernum+"','buy','"+inputordertype+"','pending',"+tradequantity+","+availableQuantity+","+(tradequantity - availableQuantity)+","+tradeprice+","+LastTradedPrice+")");
                        for(int i=0;i<OrderList.size();i++)
                        {
                            if(OrderList.get(i).matchedOrder == "y")
                            {
                                stat.executeUpdate("Update orders set StatusOfOrder = '"+OrderList.get(i).statusOfOrder+"',CompletedQuantity= "+OrderList.get(i).completedQuantity+",PendingQuantity= "+OrderList.get(i).pendingQuantity+" where OrderNum = "+OrderList.get(i).orderNum+"");
                            }
                        }
                        stat.executeUpdate("Update stock set LastTradedPrice = "+LastTradedPrice+" where Symbol = '"+inputsymbol+"'");
                        
                        rs= stat.executeQuery("Select * from userstock where id = '" +id+"' and Symbol = '"+inputsymbol+"'");
                            if(rs.next())
                            {
                                stat.executeUpdate("Update userstock set Quantity = Quantity + "+availableQuantity+" where id = '" +id+"' and Symbol = '"+inputsymbol+"'");
                            }
                            else
                            {
                                stat.executeUpdate("Insert into userstock values("+id+",'"+inputsymbol+"',"+availableQuantity+")");
                            }
                    
                    
                    }
                
                }
           
         }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
             try
            {
                rs.close();
                stat.close();
                conn.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
               
            }
        }
        
        return("Transaction completed.");
    }//Trade
     
     
     public String DisplayOrder()
    {
        final String DB_URL = "jdbc:mysql://mis-sql.uhcl.edu/nayeems9017";
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        ResultSet r= null;
        int recordcount = 1;
    
        try
        {
           conn = DriverManager.getConnection(DB_URL, "nayeems9017", "1452185");
           stat = conn.createStatement();
           
           String query = "Select orders.symbol,stock.Stock_name,orders.OrderPrice, orders.OrderQuantity from orders, stock where  orders.id = '" +id+"'and orders.symbol = stock.symbol ";
          
           rs= stat.executeQuery(query);
           
          // System.out.println("Symbol" +"\t"+ "Name Of Stock" +"\t"+"\t"+ "Traded Price" +"\t"+ "No.of shares");
           while(rs.next() && recordcount <= 5)
           {
               List.add(new OrderDetails(rs.getString(1),rs.getString(2),rs.getDouble(3),rs.getInt(4)));
               //System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+"\t"+rs.getDouble(3) +"\t"+"\t"+rs.getInt(4));
               recordcount++;
           }
           
           
        }//try
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
             try
            {
                rs.close();
                stat.close();
                conn.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
               
            }
        }
        return ("Done");
    }//display
     
     
     
     
     
     
     
}//end
