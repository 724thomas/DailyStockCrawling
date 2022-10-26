package jav;

public class Company {

    private String companyName="";
    private String url="";

    public Company(){}

    public Company(String companyName, String url){
        this.companyName=companyName;
        this.url=url;
    }


    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
