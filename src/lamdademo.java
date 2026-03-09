import org.postgresql.util.PSQLException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

interface calculator
{
    int operator(int a,int b);

}




public class lamdademo
{

//    (int a,int b)->
//    {
//        return a+b;
//    }


    public static void main(String[] args)
    {
        calculator add=(a,b)->a+b;
        System.out.println("Addition :"+add.operator(23,33));
        System.out.println("Addidtion:"+add.operator(44,55));

//         List<Integer> nums= Arrays.asList(12,23,44,55,565);
//
        calculator square=(a,b)-> a*b;
        System.out.println("Square:"+square.operator(2,3));

        calculator triple = (a,b) -> 2*(a+b);
        System.out.println("triple:"+triple.operator(2,3));
//        for (int i = 0; i < nums.size(); i++) {
//            System.out.println(square.operator(nums.get(i),nums.get(i)));
//        }



    }
}
