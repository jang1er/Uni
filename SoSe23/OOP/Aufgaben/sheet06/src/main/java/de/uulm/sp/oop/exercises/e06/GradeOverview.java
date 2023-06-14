package main.java.de.uulm.sp.oop.exercises.e06;

import main.java.de.uulm.sp.oop.exercises.e06.util.Pair;

import java.util.HashMap;
import java.util.Optional;

public class GradeOverview {


    private HashMap<String, Pair<Double, Integer>> gradeOverview;

    public GradeOverview(){
        gradeOverview = new HashMap<>();
    }

    public Pair<Double, Integer> addTestResult(String lectureName, Pair<Double, Integer> gradeAndECTS){
        gradeOverview.put(lectureName, gradeAndECTS);
        return gradeAndECTS;
    }

    public int currentECTS(){
        int sum = 0;
        for( Pair<Double, Integer> pair : gradeOverview.values()){
            sum += pair.getSecond();
        }
        return sum;
    }

    public Optional<Pair<Double, Integer>> getExamResults(String lectureName){
        Optional opt = Optional.ofNullable(gradeOverview.get(lectureName));
        if(opt.isPresent())return opt;
        return null;
    }

    public double totalGradeAverage(){
        double sum = 0;
        for( Pair<Double, Integer> pair : gradeOverview.values()){
            sum += pair.getSecond() * pair.getFirst();
        }
        return sum / currentECTS();
    }
}
