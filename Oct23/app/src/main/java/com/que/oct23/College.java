package com.que.oct23;

public class College {
    int logo;
    String name, patron;

    public College(int cLogo, String name, String patron) {
        this.logo = cLogo;
        this.name = name;
        this.patron = patron;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatron() {
        return patron;
    }

    public void setPatron(String patron) {
        this.patron = patron;
    }

}
