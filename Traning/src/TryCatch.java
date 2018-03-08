public class TryCatch {
    public static void main(String args[]){
        try{
            int values[]=new int[2];
            values[10]=30/0;
        }
        catch(ArithmeticException e){
            System.out.println("ArithmeticException");
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("ArrayIndexOutOfBoundsException");
        }
        System.out.println("Out of try-catch block");
    }
}
