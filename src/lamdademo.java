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

    public static void main(String[] args)
    {
        calculator add=(a,b)->a+b;
        System.out.println(add.operator(23,33));

         List<Integer> nums= Arrays.asList(12,23,44,55,565);

        calculator square=(a,b)-> a*b;
        for (int i = 0; i < nums.size(); i++) {
            System.out.println(square.operator(nums.get(i),nums.get(i)));
        }



    }
}
