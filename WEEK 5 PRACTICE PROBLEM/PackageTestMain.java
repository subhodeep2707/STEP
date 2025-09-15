package com.company.main;

import com.company.security.AccessModifierDemo;

public class PackageTestMain {
    public static void main(String[] args) {
        AccessModifierDemo obj = new AccessModifierDemo(20, "Data", 88.8, true);
        System.out.println(obj.publicField);
        obj.publicMethod();
    }
}
// Note: Cannot access default, private, or protected members from another package