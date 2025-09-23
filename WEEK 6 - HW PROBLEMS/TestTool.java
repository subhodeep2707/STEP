class Tool {
    private String privateField = "privateTool";
    protected String protectedField = "protectedTool";
    public String publicField = "publicTool";

    // Getter for private
    public String getPrivateField() {
        return privateField;
    }
}

class Hammer extends Tool {
    void checkAccess() {
        // System.out.println(privateField); // ❌ Not accessible
        System.out.println(getPrivateField()); // ✅ Access via getter
        System.out.println(protectedField);    // ✅ Accessible in child
        System.out.println(publicField);       // ✅ Accessible
    }
}

public class TestTool {
    public static void main(String[] args) {
        Hammer hammer = new Hammer();
        hammer.checkAccess();
    }
}
