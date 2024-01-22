package com.example.demo.profileandproperties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("production")
@ConfigurationProperties(prefix = "server")
public class ProdImpl implements ProfileInterface {
    String name;

    String ipaddress;

    String commonkey;

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

    public String getCommonkey() {
        return commonkey;
    }

    public void setCommonkey(String commonkey) {
        this.commonkey = commonkey;
    }

    public String printProfileInfo() {
        return "In ProdImpl. Profile selected is " + this.name + ". Ip address is " + this.ipaddress + ". Common key is " + this.commonkey;
    }
}
