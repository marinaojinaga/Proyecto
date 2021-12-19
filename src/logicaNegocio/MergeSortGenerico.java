package logicaNegocio;

import java.util.Comparator;

public class MergeSortGenerico{

    private static <E> void merge(E[] list1, E[] list2, E[] temp, Comparator<? super E> comparator){
        int current1 = 0;//index list1
        int current2 = 0;//index list2
        int current3 = 0; //index temp

        while (current1<list1.length && current2 <list2.length){
            if(comparator.compare(list1[current1],list2[current2])<0)
                temp[current3++] = list1[current1++];
            else
                temp[current3++] = list2[current2++];
        }
        while (current1<list1.length)
            temp[current3++] = list1[current1++];
        while (current2<list2.length)
            temp[current3++] = list2[current2++];
    }
    public static <E> void mergeSort(E[] list, Comparator<? super E> comparator){
        if(list.length>1){
            E[] firstHalf;
            firstHalf = (E[])new Object[list.length/2];
            System.arraycopy(list,0,firstHalf,0, list.length/2);
            mergeSort(firstHalf,comparator);

            int secondHalfLenght = list.length- list.length/2;
            E[] secondHalf = (E[]) new Object[secondHalfLenght];
            System.arraycopy(list,list.length/2,secondHalf,0,secondHalfLenght);
            mergeSort(secondHalf,comparator);

            merge(firstHalf,secondHalf,list,comparator);
        }
    }



}
