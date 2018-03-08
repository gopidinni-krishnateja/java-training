import java.util.HashSet;
import java.util.Iterator;

public class HashMap {
    String name;
    int age;
    int account_number;
    String gender;
    String bank_name;
    String ifsc_code;
    HashMap(String name, int age, int account_number, String gender, String bank_name, String ifsc_code ){
        this.name=name;
        this.age=age;
        this.account_number=account_number;
        this.gender=gender;
        this.bank_name=bank_name;
        this.ifsc_code=ifsc_code;
    }
    public static void main(String[] args){
        HashSet set=new HashSet();
        HashMap c1=new HashMap("krishna", 24,101,"MALE","SBI","SBI1234");
        HashMap c2=new HashMap("sandeep", 24,102,"MALE","Canara Bank", "CNRB1234");
        HashMap c3=new HashMap("arun", 28,103,"MALE","Axis Bank","UTIB0000553");
        set.add(c1);
        set.add(c2);
        set.add(c3);
        Iterator<HashMap> itr=set.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next().name);
        }
    }
}
