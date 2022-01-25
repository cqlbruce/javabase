package sun.al.leetcode;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PermutationSeq {


    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();

        int n = 1 ;
        int k = 1 ;
        int[] ints = new int[n];
        for (int i=0 ; i<n ; i++){
            ints[i] = i+1 ;
        }

        int sum =1 ;
        for (int j=1 ; j<n ; j++){
            sum = sum * j;
        }
        int index = k/sum;
        int indexs = k%sum;
        if (indexs==0){
            index = index - 1 ;
        }
        getPermutation(ints , 0 , sum , list , index);
        if(indexs!=0){
            k=indexs;
        }else {
            k=sum;
        }
        Collections.sort(list);
        System.out.println(list.get(k-1).replace("[","").replace("]","").replace(",","").replace(" ",""));
//
//        System.out.println("--------");
//        for (String str:list){
//            System.out.println(str);
//        }
    }


    public static void getPermutation(int[] ints, int dep ,int k, List<String> list , int index ){

        if (dep==ints.length-1){
            list.add(Arrays.toString(ints));
            return;
        }

        for (int i=index ; i<ints.length ; i++){
            swap(ints , dep , i);
            getPermutation(ints,dep+1 , k , list , dep+1 );
            if (list.size()==k){
                return ;
            }
            swap(ints , dep , i);
        }

    }

    public static void swap(int[] ints , int dep , int i){

        int temp = ints[dep] ;
        ints[dep] = ints[i];
        ints[i]=temp ;
    }


}
