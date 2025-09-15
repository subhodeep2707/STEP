package com.company.security;

public class AccessModifierDemo {
    private int privateField;
    String defaultField;
    protected double protectedField;
    public boolean publicField;

    private void privateMethod() {
        System.out.println("Private method called");
    }
    void defaultMethod() {
        System.out.println("Default method called");
    }
    protected void protectedMethod() {
        System.out.println("Protected method called");
    }
    public void publicMethod() {
        System.out.println("Public method called");
    }

    public AccessModifierDemo(int p, String d, double pr, boolean pub) {
        this.privateField = p;
        this.defaultField = d;
        this.protectedField = pr;
        this.publicField = pub;
    }

    public void testInternalAccess() {
        System.out.println(privateField);
        System.out.println(defaultField);
        System.out.println(protectedField);
        System.out.println(publicField);
        privateMethod();
        defaultMethod();
        protectedMethod();
        publicMethod();
    }

    public static void main(String[] args) {
        AccessModifierDemo obj = new AccessModifierDemo(10, "Hello", 99.9, true);
        System.out.println(obj.defaultField);
        System.out.println(obj.protectedField);
        System.out.println(obj.publicField);
        obj.defaultMethod();
        obj.protectedMethod();
        obj.publicMethod();
        obj.testInternalAccess();
    }
}

class SamePackageTest {
    public static void testAccess() {
        AccessModifierDemo obj = new AccessModifierDemo(5, "World", 55.5, false);
        System.out.println(obj.defaultField);
        System.out.println(obj.protectedField);
        System.out.println(obj.publicField);
    }
}
