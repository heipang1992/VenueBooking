package ict.bean;


public class AccountBean {
    
    String name, password, email, phone;
    
    public AccountBean(String name, String password, String email, String phone) {
        this.name=name;
        this.password=password;
        this.email=email;
        this.phone=phone;
    }
    
    public void setName(String name) {
        this.name=name;
    } 
    public void setPassword(String password) {
        this.password=password;
    }
    public void setEmail(String email) {
        this.email=email;
    }
    public void setPhone(String phone) {
        this.phone=phone;
    }    
    public String getName() {
        return name;
    }
    public String getPassword() {
        return password;
    }
    public String getEmail() {
        return email;
    }
    public String getPhone() {
        return phone;
    }    
}
