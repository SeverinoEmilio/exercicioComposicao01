package entities;

import enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private Date moment;
    private OrderStatus orderStatus;
    private Client client;
    private List<OrderItem> orderItems = new ArrayList<>();


    public Order(){
    }

    public Order(Date moment, OrderStatus orderStatus, Client client) {
        this.moment = moment;
        this.orderStatus = orderStatus;
        this.client = client;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void addOrderItem(OrderItem orderItem){
        orderItems.add(orderItem);
    }

    public void removeOrderItem(OrderItem orderItem){
        orderItems.remove(orderItem);
    }

    public double total(){
        double sum = 0.0;
        for (OrderItem orderItem: orderItems){
            sum += orderItem.subTotal();
        }
        return sum;

    }

    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("ORDER SUMMARY: \n");

        sb.append("Order moment: ");
        sb.append(sdf.format(moment ) +"\n");

        sb.append("Order statud: ");
        sb.append(orderStatus + "\n");

        sb.append("Cliente: ");
        sb.append(client.getName() + "(" +sdf.format(client.getBirthDate()) +")" +" - " + client.getEmail() + "\n");

        sb.append("Order items: \n");

        for(OrderItem orderItem: orderItems){
            sb.append(orderItem.getProduct().getName() +", ");
            sb.append(String.format("$%.2f", orderItem.getPrice()) +", ");
            sb.append("Quantity: ");
            sb.append(orderItem.getQuantity() + ", ");
            sb.append("Subtotal: ");
            sb.append(String.format("$%.2f", orderItem.subTotal()) + "\n");
        }

        sb.append("Total price: ");
        sb.append(String.format("$%.2f", total()));

        return sb.toString();


    }

}
