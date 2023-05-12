package com.host.prototype;

import java.util.ArrayList;
import java.util.List;

public class BasicProduct implements Product {
    private String name;
    private List<Integer> list;

    public BasicProduct(String name) {
        this.name = name;
    }
   
	public void setName(String name) {
		this.name = name;
	}

	public List<Integer> getList() {
		return list;
	}

	public void setList(List<Integer> list) {
		this.list = list;
	}

	@Override
    public void configure() {
        System.out.println("Configuring basic product: " + name);
    }

    @Override
    public Product clone() {
    	try {
    		BasicProduct cloned = (BasicProduct) super.clone();
            cloned.list = new ArrayList<>(this.list);
            return (Product)cloned;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

	@Override
	public String toString() {
		return "BasicProduct [name=" + name + ", list=" + list + "]";
	}
    
    // Implement other methods specific to a basic product
}

/*
 To achieve a deep clone without modifying the clone() method itself, you have a few alternative options:

 1. Implement the Serializable interface and use serialization/deserialization: 
 You can make your class implement the Serializable interface and use serialization to perform a deep clone. 
 This approach requires the class and its member objects to implement Serializable as well. Here's an example:
 import java.io.*;

class MyClass implements Serializable {
    // Class definition

    public MyClass deepClone() {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);
            oos.flush();
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            return (MyClass) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }
}
2. Use external libraries: There are several external libraries available, 
such as Apache Commons Lang and Gson, that provide deep cloning utilities. 
These libraries often offer more convenient and flexible ways to perform deep 
cloning without modifying the clone() method manually.
import org.apache.commons.lang3.SerializationUtils;

class MyClass {
    // Class definition

    public MyClass deepClone() {
        return SerializationUtils.clone(this);
    }
}
3. Implement a custom deep cloning mechanism: You can create your own custom mechanism to perform deep cloning by
 recursively cloning the member objects within the class. This approach requires careful handling of each member
  object's cloning process.
 
 */
