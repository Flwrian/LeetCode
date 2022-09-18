import java.util.ArrayList;
import java.util.List;

public class Solution {


    public List<String> fizzBuzz(int n){

        List<String> results = new ArrayList<>();
        
        for(int i = 1; i < n+1; i++){

            String str = "";
    
            if(i % 3 == 0){
                str+= "Fizz";
            }
            if(i % 5 ==0){
                str+= "Buzz";
            }
            if(str == ""){
                str+=i;
            }

            results.add(str);
        }


        return results;
    }
}