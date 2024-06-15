class LaundryService {
    private String Name;
    private String bank_account;
    private String address;
    private Boolean haveDelivery;
    private String phoneNumber;

    public LaundryService(String Name, String bank_account, String address, Boolean haveDelivery, String phoneNumber) {
        this.Name = Name;
        this.bank_account = bank_account;
        this.address = address;
        this.haveDelivery = haveDelivery;
        this.phoneNumber = phoneNumber;
    }

    // Getter and Setter methods
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getBank_account() {
        return bank_account;
    }

    public void setBank_account(String bank_account) {
        this.bank_account = bank_account;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getHaveDelivery() {
        return haveDelivery;
    }

    public void setHaveDelivery(Boolean haveDelivery) {
        this.haveDelivery = haveDelivery;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getServiceName() {
        if (this.haveDelivery) {
            return "Antar Jemput";
        } else {
            return "take away";
        }
    }

    public void printInfo() {
        System.out.println("Name: " + this.Name);
        System.out.println("Bank Account: " + this.bank_account);
        System.out.println("Address: " + this.address);
        System.out.println("Have Delivery: " + this.haveDelivery);
        System.out.println("Phone Number: " + this.phoneNumber);
    }

    public void printInfo(String message) {
        System.out.println(message);
        System.out.println("Name: " + this.Name);
        System.out.println("Bank Account: " + this.bank_account);
        System.out.println("Address: " + this.address);
        System.out.println("Have Delivery: " + this.haveDelivery);
        System.out.println("Phone Number: " + this.phoneNumber);
    }
}