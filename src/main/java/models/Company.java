package models;

public class Company {

    private int companyId;
    private String name;

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void yourCompany(String company) {
        name = company;
        System.out.println("Company: "+name);
    }
}
