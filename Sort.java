import java.util.Arrays;

public class Sort<T extends Comparable<T>> {
    private int[] array;
    private T[]array2;

    public Sort(int[] array,T[]array2){
        this.array=array;
        this.array2=array2;
    }

    //COMPARISON COMPLEXITY IS WORST:O(n^2) BEST:O(n^2)
    //EXCHANGE COMPLEXITY IS WORST:O(n) BEST:O(n)
    //SPACE COMPLEXITY:O(1)
    public void selectionSort(){
        int n = array.length;
        for (int i = 0; i < n-1; i++) {
            int min_index = i;
            for (int j = i+1; j < n; j++)
                if (array[j] < array[min_index])
                    min_index = j;
            int temp = array[min_index];
            array[min_index] = array[i];
            array[i] = temp;
        }
    }
    public void genericSelectionSort(){
        int n = array2.length;
        for (int fill = 0; fill < n-1; fill++) {
            int min_index = fill;
            for (int j = fill+1; j < n; j++)
                if (array2[j].compareTo(array2[min_index])<0)
                    min_index = j;
            T temp = array2[min_index];
            array2[min_index] = array2[fill];
            array2[fill] = temp;
        }
    }

    //*********************************************************

    //COMPARISON COMPLEXITY IS WORST:O(n^2) BEST:O(n)
    //EXCHANGE COMPLEXITY IS WORST:O(n^2) BEST:O(1)
    //SPACE COMPLEXITY:O(1)
    //Stable
    public void bubbleSort(){//BURDAKİ EXCHANGE ÇOK ÖNEMLİ!!
        int i=0;
        boolean exchange=false;
        do{
            exchange=false;
            for(int j=0;j<array.length-i-1;++j){
                if(array[j]>array[j+1]){
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                    exchange=true;
                }
                System.out.println(i);
            }
            ++i;
        }
        while (i<array.length&&exchange);
    }

    public void genericBubbleSort(){
        for(int i=0;i<array2.length;++i){
            for(int j=0;j<array2.length-i-1;++j){
                if(array2[j].compareTo(array2[j+1])>0){
                    T temp=array2[j];
                    array2[j]=array2[j+1];
                    array2[j+1]=temp;
                }
            }
        }
    }

    //*********************************************************

    //COMPARISON COMPLEXITY IS WORST:O(n^2) BEST:O(n)
    //EXCHANGE COMPLEXITY IS WORST:O(n^2) BEST:O(n)
    //SPACE COMPLEXITY:O(1)
    //Stable
    public void insertionSort(){
        for(int nextPos=1  ;nextPos<array.length;++nextPos){
            int nextVal = array[nextPos];
            while (nextPos > 0 && nextVal<array[nextPos - 1]) {
                array[nextPos] = array[nextPos - 1];
                nextPos--;
            }
            array[nextPos] = nextVal;//??
        }
    }

    public void genericInsertionSort(){
        for(int nextPos=1;nextPos<array2.length;++nextPos){
            T nextVal = array2[nextPos];
            while (nextPos > 0 && nextVal.compareTo(array2[nextPos - 1])<0) {
                array2[nextPos] = array2[nextPos - 1];
                nextPos--;
            }
            array2[nextPos] = nextVal;
        }
    }

    //*********************************************************

    //COMPARISON COMPLEXITY IS WORST:O(n^7/6) BEST:O(n)
    //EXCHANGE COMPLEXITY IS WORST:O(n^2) BEST:O(n)
    //SPACE COMPLEXITY:O(1)
    public void shellSort(){
        int gap = array.length/2;
        while (gap > 0) {
            for (int nextPos = gap; nextPos < array.length; nextPos++) {
                int nextVal = array[nextPos];
                while (nextPos > 0 && nextVal<array[nextPos - 1]) {
                    array[nextPos] = array[nextPos - 1];
                    nextPos--;
                }
                array[nextPos] = nextVal;
            }
            if (gap == 2){
                gap = 1;
            }
            else{
                gap = (int) (gap / 2.2);
            }
        }
    }

    public void genericShellSort(){
        int gap = array2.length/2;
        while (gap > 0) {
            for (int nextPos = gap; nextPos < array2.length; nextPos++) {
                T nextVal = array2[nextPos];
                while (nextPos > 0 && nextVal.compareTo(array2[nextPos - 1])<0) {
                    array2[nextPos] = array2[nextPos - 1];
                    nextPos--;
                }
                array2[nextPos] = nextVal;
            }
            if (gap == 2){
                gap = 1;
            }
            else{
                gap = (int) (gap / 2.2);
            }
        }
    }

    //*********************************************************

    //COMPLEXITY=O(nlogn)-->both worst and best
    //Additional space complexity=O(n)-->for the output array
    //Stable
    private void merge(int[]rightArray,int[]leftArray,int[]outputArray){
        int i=0,j=0,k=0;
        while(i<leftArray.length&&j<rightArray.length){
            if(leftArray[i]<rightArray[j]){
                outputArray[k++]=leftArray[i++];
            }
            else
                outputArray[k++]=rightArray[j++];
        }
        while(i<leftArray.length){
            outputArray[k++]=leftArray[i++];
        }
        while (j<rightArray.length){
            outputArray[k++]=rightArray[j++];
        }
    }

    public void sort(int[]array){
        if(array.length>1){
            int half=array.length/2;
            int[]leftTable=new int[half];
            int[]rightTable=new int[array.length-half];
            leftTable=Arrays.copyOfRange(array, 0, half);
            rightTable=Arrays.copyOfRange(array, half, array.length);

            sort(leftTable);
            sort(rightTable);

            merge(rightTable, leftTable, array);
        }

    }

    //*********************************************************

    //COMPLEXITY=O(nlogn)-->both worst and best
    //Additional space complexity=O(1)-->in place
    private void swap(int i,int j){
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }

    private void buildHeap(){//normal arrayi maxHeap'e çevirme
        int n=1;
        while(n<array.length){
            n++;
            int child=n-1;
            int parent=(child-1)/2;
            while (parent>=0&&array[parent]<array[child]){
                swap(parent, child);
                child=parent;
                parent=(child-1)/2;
            }
        }
    }

    private void shrinkHeap(){//swaplayıp düzenliyor.her defasında n'i 1 azalttığı için en son swaplayip sıraladığı eleman ignore ediliyor.
        int n=array.length;
        while(n>0){
            n--;
            swap(0, n);
            int parent=0;
            while(true){
                int leftChild=2*parent+1;
                if(leftChild>=n){
                    break;
                }
                int rightChild=leftChild+1;
                int maxChild=leftChild;
                if (rightChild < n && array[leftChild]<array[rightChild]) {
                    maxChild = rightChild;
                }
                if(array[parent]<array[maxChild]){
                    swap(parent, maxChild);
                    parent=maxChild;
                }
                else
                    break;
            }
        }
    }

    public void heapSort(){
        buildHeap();
        shrinkHeap();
    }

    //*********************************************************

    //O(nlogn)
    //worst case:O(n^2)-->for the subarray's empty-->already sorted
    private void quickSort(int[]array,int lowerBound,int upperBound){
        if(lowerBound<upperBound){
            int pivIndex=partition(array,lowerBound,upperBound);
            quickSort(array, lowerBound, pivIndex-1);
            quickSort(array, pivIndex+1, upperBound);
        }
    }

    private int partition(int[]array,int lowerBound,int upperBound){//soldan ilk büyük, sağdan ilk küçük seçilir böylece devam edilir ve en son swaplanır
        int pivot=array[lowerBound];
        int up=lowerBound,down=upperBound;
        do{
            while ((up < upperBound) && pivot >= array[up]) {
                up++;
            }
            while(pivot<array[down]){
                down--;
            }
            if (up < down) {
                swap(up, down);
            }

        }while (up<down);

        swap(lowerBound, down);

        return down;

    }

    public void quSort(){
        quickSort(array, 0, array.length-1);
    }

    @Override
    public String toString() {
        StringBuilder builder=new StringBuilder();
        for (int i=0;i<array.length;++i){
            builder.append(array[i]+" ");
        }
        builder.append("\n");
        for (int i=0;i<array2.length;++i){
            builder.append(array2[i]+" ");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        //int[] array={10,5,2,4,5,6,20,1};
        int[] array={1,2,3,5,4};
        Integer[] array2={10,5,2,4,5,6,20,1};
        Sort deneme=new Sort(array,array2);
        //deneme.selectionSort();
        //deneme.genericSelectionSort();
        deneme.bubbleSort();
        //deneme.genericBubbleSort();
        //deneme.insertionSort();
        //deneme.genericInsertionSort();
        //deneme.shellSort();
        //deneme.genericShellSort();
        //deneme.sort(array);
        //deneme.heapSort();
        //deneme.quSort();

        System.out.println(deneme);

    }
}
