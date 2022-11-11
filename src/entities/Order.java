package entities;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import enums.OrderStatus;

public class Order {

	private Date moment;
	private OrderStatus status;
	private Client client;
	private ArrayList<OrderItem> items = new ArrayList<OrderItem>();
	private SimpleDateFormat date = new SimpleDateFormat();
	
	
	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}
	
	//methods getters and sets 
	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public ArrayList<OrderItem> getItems() {
		return items;
	}

	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	
	//method public of the class 
	public void addItem(OrderItem item) {
		items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	
	
	public double total() {
		double total = 0;
		for(OrderItem item : items) {
			total += item.subTotal();
		}
		
		return total;
	}
	
	
	public String toString() {
		
		StringBuilder info = new StringBuilder();
		
		info.append("Order Moment:");
		info.append(date.format(moment) + "\n");
		info.append("Order Status:");
		info.append(status + "\n");
		info.append("Client: ");
		info.append(client.toString() + "\n");
		info.append("Order Items \n");
		for (OrderItem item : items) {
			info.append(item.toString() + "\n");
		}
		info.append("Total price: $");
		info.append(String.format("%.2f", total()));
		
		return  info.toString();
	}
}
