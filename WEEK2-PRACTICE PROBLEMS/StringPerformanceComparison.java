public class StringPerformanceComparison {
    public static void main(String[] args) {
        long start, end;
        start = System.nanoTime();
        String result1 = concatenateWithString(1000);
        end = System.nanoTime();
        System.out.println("String time: " + (end - start) + " ns");
        start = System.nanoTime();
        String result2 = concatenateWithStringBuilder(1000);
        end = System.nanoTime();
        System.out.println("StringBuilder time: " + (end - start) + " ns");
        start = System.nanoTime();
        String result3 = concatenateWithStringBuffer(1000);
        end = System.nanoTime();
        System.out.println("StringBuffer time: " + (end - start) + " ns");
        demonstrateStringBuilderMethods();
        compareStringComparisonMethods();
    }
    public static String concatenateWithString(int iterations) {
        String result = "";
        for (int i = 0; i < iterations; i++) result += "Java" + i;
        return result;
    }
    public static String concatenateWithStringBuilder(int iterations) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) sb.append("Java").append(i);
        return sb.toString();
    }
    public static String concatenateWithStringBuffer(int iterations) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < iterations; i++) sb.append("Java").append(i);
        return sb.toString();
    }
    public static void demonstrateStringBuilderMethods() {
        StringBuilder sb = new StringBuilder("Hello World");
        sb.append("!");
        sb.insert(6, "Java ");
        sb.delete(0, 5);
        sb.reverse();
        System.out.println("StringBuilder final: " + sb.toString());
    }
    public static void compareStringComparisonMethods() {
        String str1 = "Hello";
        String str2 = "Hello";
        String str3 = new String("Hello");
        System.out.println("== : " + (str1 == str2));
        System.out.println("equals: " + str1.equals(str3));
        System.out.println("equalsIgnoreCase: " + str1.equalsIgnoreCase("hello"));
        System.out.println("compareTo: " + str1.compareTo(str3));
        System.out.println("compareToIgnoreCase: " + str1.compareToIgnoreCase("hello"));
    }
}
