public class Customer extends User {
	private double wallet;
    private String customerName;
    private String email;
    private String password;
    public Customer(String customerName, String email, String password)
    {
        this.setCustomerName(customerName);
        this.setEmail(email);
        this.setPassword(password);
        this.setWallet(0.0);
        
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public double getWallet() {
        return wallet;
    }
}
