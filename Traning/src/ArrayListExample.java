import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String args[]) {
        ArrayList<String> obj = new ArrayList<String>();
        obj.add("Krishna");
        obj.add("Sandeep");
        obj.add("Arun");
        System.out.println("Current the array list values"+obj);
        obj.add(0, "Rahul");
        obj.add(1, "Teja");
        obj.remove("Sandeep");
        obj.remove("Teja");
        System.out.println("Current array list is:"+obj);
        obj.remove(1);
        System.out.println("Current array list is:"+obj);
    }
}
