class LaundryService {
    private String Name;
    private String bank_account;
    private String address;
    private Boolean haveDelivery;
    private String phoneNumber;

    public LaundryService(String serviceName, String bank_account, String address, Boolean haveDelivery, String phoneNumber) {
        this.serviceName = serviceName;
        this.bank_account = bank_account;
        this.address = address;
        this.haveDelivery = haveDelivery;
        this.phoneNumber = phoneNumber;
    }

    // Getter and Setter methods
    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
}