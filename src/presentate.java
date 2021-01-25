
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class presentate {
    /**
     *isPermu
     *@return boolean - to check is two stirngs are permutation of to the other, not
     * regarding of the order and cases.
     */
    public static boolean isPermu(String a, String b){
        boolean isPer = true;
        String inputA = toLowCase(a);
        String inputB = toLowCase(b);
        int lenA = a.length();
        int lenB = b.length();
        if(lenA != lenB) return false;
        char[] charA = new char[lenA];
        char[] charB = new char[lenB];

        for(int i = 0; i<a.length(); i++){
            charA[i] = inputA.charAt(i);
            charB[i] = inputB.charAt(i);
        }
        Arrays.sort(charA);
        Arrays.sort(charB);
        for(int i =0;i<charA.length;i++){
            if(charA[i] != charB[i]){
                isPer = false;
                System.out.println("no same input!");
            }
        }

        return isPer;
    }

    /**
     *
     * toLowCase
     * @return String - to convert all the char to lower case for a input string
     */
    public static String toLowCase(String input){
        char[] inputList = new char[input.length()];
        for(int i=0;i<input.length();i++){
            if(input.charAt(i)<'Z'&&input.charAt(i)>'A'){
                inputList[i]= (char)(input.charAt(i)+32);
            }else{
                inputList[i]= input.charAt(i);
            }
        }
        String outPut = new String(inputList);
        return outPut;
    }

    /**
     *
     * getSmallestDifference
     * @return int - to check the smallestDifference between numbers in two arrays
     */
    public static int getSmallestDifference(int[] a,int[] b){
        int smallDiff= Math.abs(a[0] - b[0]);;
        int thisDiff;
        for(int i = 0; i<a.length; i++){
            for(int j = 0;j<b.length;j++){
                thisDiff = Math.abs(a[i]-b[j]);
                System.out.println("thisDiff: "+thisDiff);
                if(thisDiff<smallDiff){
                    smallDiff = thisDiff;
                    System.out.println("updata small:  "+smallDiff);
                }
            }
        }
        return smallDiff;
    }

    public static int getSmallestDifferentB(int[] a,int[] b){
        int[] total = new int[a.length+b.length];
        int counter = 0;
        int lastCount =0;
        while(true){
            if(counter<a.length){
                total[counter] = a[counter];
                counter++;
                lastCount = counter;
            }else{
                total[counter] = b[counter-lastCount];
                counter++;
                if(counter-lastCount>b.length-1){
                    break;
                }
            }
        }
        Arrays.sort(total);
//        for(int elements:total){
//            System.out.println(elements);
//        }

        int smallest = total[1]-total[0];
        int current;
        for(int i=0;i<total.length-1;i++){
            current = total[i+1]-total[i];
            if(current<smallest){
                smallest = current;
                //System.out.println(current);
            }
        }
        return smallest;
    }

    /**
     *
     * bullGame
     * @return  String[] - to check how many numbers are in right position. how many in wrong position
     */
    public static String[] bullGame(String playIn, String myNum){
        if(playIn.length()!=4||myNum.length()!=4){
            throw new IllegalArgumentException("value must be four digits");
        }

        String[] result = new String[2];
        int bulls=0;
        int cows=0;
        for(int i =0;i<4;i++){
            if(playIn.charAt(i)==myNum.charAt(i)){
                bulls+=1;
            }else{
                if(playIn.charAt(i)==myNum.charAt(0)||playIn.charAt(i)==myNum.charAt(1)
                        ||playIn.charAt(i)==myNum.charAt(2)||playIn.charAt(i)==myNum.charAt(3)){
                    cows +=1;
                }
            }
        }
        result[0] = String.valueOf(bulls)+"bulls";
        result[1] = String.valueOf(cows)+"cows";

        return result;
    }
    /**
     *
     * best year
     * @return  int - best year that mose people are alive that year
     */
    public static int bestYear(Person[] foo){
        ArrayList<Integer> years = new ArrayList<Integer>();

        for(Person elements:foo){
            for(int i=elements.getBirthYear();
                i< elements.getDeathYear()+1;i++){
                years.add(i);
            }

        }
        int result = mostCommonYear(years);

        return result;
    }

    /**
     *
     * mostCommonYear
     * @return  int - the most common number in an ArrayList
     */
    public static int mostCommonYear(ArrayList<Integer> years){
        HashMap<Integer,Integer> yearMap = new HashMap<>();
        Integer times;
        int result = 0;
        int mostYear = 0;
        for(int elements:years){
            times = yearMap.get(elements);
            if(times != null){
                yearMap.put(elements,times+1);
            }else{
                yearMap.put(elements,1);
            }
        }
        for(Map.Entry<Integer,Integer> elements:yearMap.entrySet()){
            if(elements.getValue()>result){
                result = elements.getValue();
                mostYear = elements.getKey();
            }
        }
        return mostYear;
    }
    /**
     *
     * bestYearB
     * @return  int - the most common number in an ArrayList
     */
    public static int bestYearB(Person[] list){
        HashMap<Integer,Integer> yearMap = new HashMap<>();
        Integer times;
        int result=0;
        int mostYear=0;

        int minYear = list[0].getBirthYear();
        int maxYear = list[0].getDeathYear();
        for(Person elements:list){
            if(elements.getBirthYear()<minYear){
                minYear = elements.getBirthYear();
            }
            if(elements.getDeathYear()>maxYear){
                maxYear = elements.getDeathYear();
            }
        }
        for(int i=minYear;i<maxYear+1;i++){
            for(Person elements:list){
                if(elements.isAlive(i)){
                    times = yearMap.get(i);
                    if(times != null){
                        yearMap.put(i,times+1);
                    }else{
                        yearMap.put(i,1);
                    }
                }
            }
        }
        for(Map.Entry<Integer,Integer> elements:yearMap.entrySet()){
            if(elements.getValue()>result){
                result = elements.getValue();
                mostYear = elements.getKey();
                //System.out.println(mostYear);
            }
        }
        return mostYear;

    }



    public static void main(String[] args){
        //System.out.println(toLowCase("HaHaHahHhhHJFDKASFHJddf"));
        //System.out.println(isPermu("acbdfgshfdgz","acbdfgshfdgy"));
        //int[] a = {100,310,932,12,90,30,4,1000};
        //int[] b = {8,10,0,120,92,300,60,1,6,};
        //System.out.println(getSmallestDifference(a,b));
//        for(String element:bullGame("9305","9305")){
//            System.out.println(element);
//        }
        Person Li = new Person(2000,2008);
        Person Ye = new Person(2001,2006);
        Person Ji = new Person(1990,2002);
        Person lo = new Person(2002,2090);
        Person fi = new Person(1960,2048);
        Person di = new Person(2003,2032);

        Person[] foo = {Li,Ye,Ji,lo,fi,di};
        System.out.println(bestYearB(foo));
//        ArrayList<Integer> test = new ArrayList<Integer>();
//        for(int i =2000;i<2008+1;i++){
//            test.add(i);
//            test.add(2003);
//            test.add(2003);
//            test.add(2005);
//            test.add(2005);
//            test.add(2005);
//        }
//        test.add(2000);
//        //System.out.println(mostCommonYear(test));
//        System.out.println(bestYear(foo));
//
//        bestYear(foo);


    }

}
