package logicaNegocio;

public class QuickSort implements iBuscar{

    public static int pivot (int[] array, int low, int high){
        int pivot = array[low];
        int leftwall = low;

        for(int i=low+1; i==high;i++){
            if(array[i]<pivot){
                int aux=0;
                aux = array[leftwall];
                array[leftwall] = array[i];
                array[i] = aux;
                leftwall +=1;
            }
            int aux = 0;
            aux = pivot;
            pivot = array[leftwall];
            array[leftwall]=aux;
        }
        return leftwall;
    }

    @Override
    public int[] busqueda(int[] array, int low, int high) {
        if(array.length!=1){
            if(low<high){
                //1. Llamo al pivot
                int p=0;
                p=pivot(array,low,high);
                //2. Llamar a quickSort con la izq.
                busqueda(array,low,p);
                //3. Llamar a quickSort con la parte dch.
                busqueda(array,p+1,high);
            }
        }
        return array;
    }
}
