/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Samreen
 */
public class OrderDetails {
     public String symbol;
    public int userId;
    public int orderNum;
    public String typeOfTrade;
    public String typeOfOrder;
    public String statusOfOrder;
   // public DateAndTime lastUpdated;
    public int orderQuantity;
    public int completedQuantity;
     public int pendingQuantity;
    public double orderPrice;
    public double lastTradedPrice;
    public String matchedOrder;
    public int tradedQuantity;
    public String stockname;

    public String getStockname() {
        return stockname;
    }

    public void setStockname(String stockname) {
        this.stockname = stockname;
    }
    
    

    public String getMatchedOrder() {
        return matchedOrder;
    }

    public void setMatchedOrder(String matchedOrder) {
        this.matchedOrder = matchedOrder;
    }
    
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public String getTypeOfTrade() {
        return typeOfTrade;
    }

    public void setTypeOfTrade(String typeOfTrade) {
        this.typeOfTrade = typeOfTrade;
    }

    public String getTypeOfOrder() {
        return typeOfOrder;
    }

    public void setTypeOfOrder(String typeOfOrder) {
        this.typeOfOrder = typeOfOrder;
    }

    public String getStatusOfOrder() {
        return statusOfOrder;
    }

    public void setStatusOfOrder(String statusOfOrder) {
        this.statusOfOrder = statusOfOrder;
    }

  
  

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public int getCompletedQuantity() {
        return completedQuantity;
    }

    public void setCompletedQuantity(int completedQuantity) {
        this.completedQuantity = completedQuantity;
    }

    public int getPendingQuantity() {
        return pendingQuantity;
    }

    public void setPendingQuantity(int pendingQuantity) {
        this.pendingQuantity = pendingQuantity;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public double getLastTradedPrice() {
        return lastTradedPrice;
    }

    public void setLastTradedPrice(double lastTradedPrice) {
        this.lastTradedPrice = lastTradedPrice;
    }

    public OrderDetails(String symbol, int userId, int orderNum, String typeOfTrade, String typeOfOrder, String statusOfOrder, int orderQuantity, int completedQuantity, int pendingQuantity, double orderPrice, double lastTradedPrice, String matchedOrder) {
        this.symbol = symbol;
        this.userId = userId;
        this.orderNum = orderNum;
        this.typeOfTrade = typeOfTrade;
        this.typeOfOrder = typeOfOrder;
        this.statusOfOrder = statusOfOrder;
       // this.lastUpdated = lastUpdated;
        this.orderQuantity = orderQuantity;
        this.completedQuantity = completedQuantity;
        this.pendingQuantity = pendingQuantity;
        this.orderPrice = orderPrice;
        this.lastTradedPrice = lastTradedPrice;
        this.matchedOrder = matchedOrder;
    }

    public OrderDetails(String symbol,String stockname,  double orderPrice, int orderQuantity) {
        this.symbol = symbol;
        this.orderQuantity = orderQuantity;
        this.orderPrice = orderPrice;
        this.stockname = stockname;
    }
    
}
