import java.util.Date;

class Order {
    private User user;
    private LaundryService laundryService;
    private Date orderDate;
    private boolean isCompleted;
    private boolean isDelivered;
    /**
     * The price per kilogram for the laundry order.
     */
    private double priceKG=5000;
    private double price;

    public Order(User user, LaundryService laundryService, Date orderDate, double weight, double price) {
        this.user = user;
        this.laundryService = laundryService;
        this.orderDate = orderDate;
        this.isCompleted = false;
        this.isDelivered = false;
        setPrice(priceKG,weight, laundryService);
    }

    // Method untuk menyelesaikan pesanan
    public void completeOrder() {
        this.isCompleted = true;
    }

    // Method untuk mengantar pesanan
    public void deliverOrder() {
        if (isCompleted) {
            this.isDelivered = true;
        }
    }

    // Getter methods
    public User getUser() {
        return user;
    }

    public LaundryService getLaundryService() {
        return laundryService;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public boolean isDelivered() {
        return isDelivered;
    }

    public double getPrice() {
        return price;
    }


    public void setPrice() {
        this.price = price;
    }

    public double getPriceKG() {
        return priceKG;
    }

    

    public void setPrice(double priceKG,double weight, LaundryService laundryService) {
        if (this.laundryService.getHaveDelivery()) {
            this.price = priceKG*weight + 5000;
        } else {
            this.price = priceKG*weight;
        }
    }
}

