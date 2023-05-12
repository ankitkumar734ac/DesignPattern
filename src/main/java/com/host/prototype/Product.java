package com.host.prototype;

public interface Product extends Cloneable {
    void configure();
    Product clone();
    // Add other common methods here
}
