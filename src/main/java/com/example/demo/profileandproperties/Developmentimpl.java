package com.example.demo.profileandproperties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("development")
public class Developmentimpl implements  ProfileInterface{

    @Value("${server.name}")
    String name;

    @Value("${server.ipaddress}")
    String ipaddress;

    @Value("${server.commonkey}")
    String commonKey;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    public String getCommonKey() {
        return commonKey;
    }

    public void setCommonKey(String commonKey) {
        this.commonKey = commonKey;
    }

    public String printProfileInfo() {
        return "In DevelopmentImpl. Profile selected is " + this.name + ". Ip address is " + this.ipaddress + ". Common key is " + this.commonKey;
    }
}
