class Payment {
    private Order order;
    private double amount;
    private boolean isPaid;

    public Payment(Order order, double amount) {
        this.order = order;
        this.amount = amount;
        this.isPaid = false;
    }

    // Method untuk melakukan pembayaran
    public void makePayment() {
        if (order.isCompleted()) {
            this.isPaid = true;
        }
    }

    // Getter methods
    public Order getOrder() {
        return order;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isPaid() {
        return isPaid;
    }
}

