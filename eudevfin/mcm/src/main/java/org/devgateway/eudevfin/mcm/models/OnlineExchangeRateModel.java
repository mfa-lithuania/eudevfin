package org.devgateway.eudevfin.mcm.models;

import java.io.Serializable;

/**
 * @author idobre
 * @since 9/5/14
 */
public class OnlineExchangeRateModel implements Serializable {
    private String baseurl;
    private String key;
    private Boolean jobActive;

    public String getBaseurl() {
        return baseurl;
    }

    public void setBaseurl(String baseurl) {
        this.baseurl = baseurl;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Boolean getJobActive() {
        return jobActive;
    }

    public void setJobActive(Boolean jobActive) {
        this.jobActive = jobActive;
    }
}
