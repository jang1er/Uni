import java.util.ArrayList;
import java.util.Optional;

public class IntegerArrayClass {

    private ArrayList<Integer> workingarray;

    public IntegerArrayClass (ArrayList<Integer> param){
        this.workingarray.addAll(param);
    }

    private int sum(){
        int sum = 0;
        for(Integer i : workingarray){
            sum += i;
        }
        return sum;
    }


    public Optional<Integer> binSearch(int searchedElement){
        int left = 0, right = this.workingarray.size()-1;
        while (left <= right){
            int middle = (int) (right - left)/2 + left;
            if(workingarray.get(middle) == searchedElement)return Optional.of(middle);
            if(workingarray.get(middle) < middle)right = middle - 1;
            if(workingarray.get(middle) > middle)left = middle + 1;


        }
        return Optional.empty();
    }

}
