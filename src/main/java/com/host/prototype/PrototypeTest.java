package com.host.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ankit_Kumar
 * The Prototype design pattern in Java allows you to create new objects by cloning existing ones. 
 */
public class PrototypeTest {
	public static void main(String[] args) {
//		BasicProduct basicProduct = new BasicProduct("Basic Product");
//		List<Integer> list = new ArrayList<Integer>();
//		list.add(10);
//		basicProduct.setList(list);
//		System.out.println(basicProduct);
//		 System.out.println("---------------");
//		
//		BasicProduct clonedBasicProduct =(BasicProduct) basicProduct.clone();
//        basicProduct.setName("Ankit");
//		System.out.println(basicProduct);
//        System.out.println(clonedBasicProduct);
//        //clonedBasicProduct.configure();
//        System.out.println("---------------");
//        clonedBasicProduct.setName("Kumar");
//        clonedBasicProduct.getList().add(20);
//        System.out.println(clonedBasicProduct);
//        System.out.println("base: "+basicProduct);
		

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);

        ComplexObject original = new ComplexObject(1, "Original", numbers);
        // Set initial values and configure the original object

        ComplexObject clone = original.deepCopy();
        // Perform deep cloning by using the copy constructor

        // Modify the clone or original as needed
        System.out.println(original);
        System.err.println(clone);
        
        original.setId(11);
        original.setName("Ankit");
        original.getNumbers().add(100000);
        
        System.out.println(original);
        System.err.println(clone);
        
        clone.setId(11222);
        clone.setName("Kumar");
        clone.getNumbers().add(1111111);
        
        System.out.println(original);
        System.err.println(clone);

	}

}
