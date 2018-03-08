import java.util.Enumeration;
import java.util.Hashtable;

public class HashTable {
    public static void main(String[] arg)
    {
        Hashtable marks = new Hashtable();
        marks.put("Krishna", new Integer(345));
        marks.put("Teja", new Double(245.78));
        marks.put("Rahul", new Integer(790));
        marks.put("Sandeep", new Double(365.98));
        marks.put("Ramesh", new Integer(435));
        if (marks.containsValue(345)){
            System.out.println("value found in table");
        }
        Enumeration e = marks.elements();
        System.out.println("display values:");
        while (e.hasMoreElements()) {
            System.out.println(e.nextElement());}
    }
}
