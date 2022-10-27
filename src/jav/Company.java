package jav;

public class Company {

    private String companyNameAndDate="";
    private String companyName = "";
    private String url = "";
    private float juga;
    private float dungrakRate;
    private float siga;
    private float goga;
    private float zeoga;
    private float georaeryang;
    private String stype;
    private float vsyesterday;
    private String date;

    public Company() {
    }

    public Company(String companyName, String url, float juga, float dungrakRate, float siga, float goga, float zeoga, float georaeryang, String stype, float vsyesterday, String date) {
        this.companyNameAndDate=companyName+date;
        this.companyName = companyName;
        this.url = url;
        this.juga = juga;
        this.dungrakRate = dungrakRate;
        this.siga = siga;
        this.goga = goga;
        this.zeoga = zeoga;
        this.georaeryang = georaeryang;
        this.stype = stype;
        this.vsyesterday = vsyesterday;
        this.date = date;
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

    public String getCompanyNameAndDate() {
        return companyNameAndDate;
    }

    public void setCompanyNameAndDate(String companyNameAndDate) {
        this.companyNameAndDate = companyNameAndDate;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public float getJuga() {
        return juga;
    }

    public void setJuga(float juga) {
        this.juga = juga;
    }

    public float getDungrakRate() {
        return dungrakRate;
    }

    public void setDungrakRate(float dungrakRate) {
        this.dungrakRate = dungrakRate;
    }

    public float getSiga() {
        return siga;
    }

    public void setSiga(float siga) {
        this.siga = siga;
    }

    public float getGoga() {
        return goga;
    }

    public void setGoga(float goga) {
        this.goga = goga;
    }

    public float getZeoga() {
        return zeoga;
    }

    public void setZeoga(float zeoga) {
        this.zeoga = zeoga;
    }

    public float getGeoraeryang() {
        return georaeryang;
    }

    public void setGeoraeryang(float georaeryang) {
        this.georaeryang = georaeryang;
    }

    public String getStype() {
        return stype;
    }

    public void setStype(String stype) {
        this.stype = stype;
    }

    public float getVsyesterday() {
        return vsyesterday;
    }

    public void setVsyesterday(float vsyesterday) {
        this.vsyesterday = vsyesterday;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "회사:'" + companyName + '\'' +
                ", 주가=" + juga +
                ", 등락률=" + dungrakRate +
                ", 시가=" + siga +
                ", 고가=" + goga +
                ", 저가=" + zeoga +
                ", 거래량=" + georaeryang +
                ", 타입='" + stype + '\'' +
                ", 전일대비=" + vsyesterday +
                ", 날짜='" + date + '\'';
    }
}

