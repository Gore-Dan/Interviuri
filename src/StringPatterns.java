
import java.util.ArrayList;
import java.util.List;
import  java.util.*;
import java.util.stream.Collectors;

//Cea mai mare ciobanie de program, imposibil sa nu isi ia runtime out la compilare.....

public class StringPatterns {

    static List<String> allPossibilites(char[] set, String prefix, int n, int wordLen,int k,List<String> myList){

        if(k == 0){
            return myList;
        }

        for(int i = 0; i < n; ++i){
            String myString = prefix + set[i];
            if(myString.length() == wordLen){
                myList.add(myString);

            }
            allPossibilites(set,myString,n,wordLen,k -1,myList);

        }
        return myList;
    }
    public static List<String> checkVowels(List<String> myList){
        List<String> newList = new ArrayList<>();
        for(String s: myList){
            char[] myFilter = s.toCharArray();
            for(int i=0; i < myFilter.length;i++){
                if(myFilter[i] == 'c'){
                    if(i > 0 && i < myFilter.length - 1 &&
                            (myFilter[i+1] == myFilter[i]) && (myFilter[i-1] == myFilter[i]) ){
                        newList.add(s);
                    }
                }
                if(myFilter[i] == 'v'){
                    if(i > 0 && i < myFilter.length - 1 &&
                        (myFilter[i+1] != myFilter[i]) && (myFilter[i-1] != myFilter[i]) ){
                        newList.add(s);
                    }
                }

            }
        }

        List<String>  debugList = newList.stream().distinct().collect(Collectors.toList());
        return debugList;
    }
    public static int calculateWays(int wordLen,int maxVowels){

        char[] set = {'c','v'};
        int n = set.length;

        List<String> list = new ArrayList<>();
        allPossibilites(set,"",n,wordLen,wordLen,list);

        List<String> lista = new ArrayList<>();
        lista = checkVowels(list);
        for(String s:lista){
            System.out.println("String: " + s);
        }

        int j = 0;
        int[] sum = new int[lista.size()];
        for(String s:lista){
            int m = 0;
            int nn = 0;
            char[] elements = s.toCharArray();
            for(int i = 0; i < elements.length;i++){
                if(elements[i] == 'c'){
                    m++;
                    System.out.println("m "+m);
                }else{
                    nn++;
                    System.out.println("n "+n);
                }

            }
            if(nn == 0){
            sum[j] = (int) (Math.pow(21,m));
            }else {
                sum[j] = (int) (Math.pow(21,m)*Math.pow(5,nn));
            }
            System.out.println("Suma "+  j+ "=" + sum[j]);
            j++;
        }
        int finalSum = 0;
        for(int i = 0; i<sum.length;i++){
            finalSum = finalSum + sum[i];
        }

        return finalSum;
    }
    public static void main(String[] args){
        System.out.println(calculateWays(4,2));
    }
}
