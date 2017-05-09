package com.kc.unsplash.net;

/**
 * Created by kcred on 5/9/2017.
 */

public enum Order {

    LATEST("latest"),
    OLDEST("oldest"),
    POPULAR("popular");

    private String order;

    Order(String order){
        this.order = order;
    }

    public String getOrder() {
        return order;
    }
}
