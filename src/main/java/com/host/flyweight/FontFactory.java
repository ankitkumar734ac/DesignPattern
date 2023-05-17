package com.host.flyweight;

import java.util.HashMap;
import java.util.Map;

//FlyweightFactory class
public class FontFactory {
 private Map<String, Font> fontPool;

 public FontFactory() {
     fontPool = new HashMap<>();
 }

 public Font getFont(String name) {
     Font font = fontPool.get(name);

     if (font == null) {
         font = new ConcreteFont(name);
         fontPool.put(name, font);
     }

     return font;
 }
}