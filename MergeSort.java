import java.util.Random;

public class MergeSort{

    static Random rand = new Random(); //Generowanie randomowych liczb
    static int[] numbers = new int[5]; //Tablica z 5 itemami

    static void mergeSort(int[] numbers)
    {
        int arrayLength = numbers.length;
        int mid = arrayLength/2;
        int[] left = new int[mid];
        int[] right = new int[arrayLength - mid];

        for (int i = 0; i < mid; i++){
            left[i] = numbers[i];
        }
 
        for (int i = mid; i < arrayLength; i++){ 
            right[i - mid] = numbers[i];
        }

        if(arrayLength < 2){
            return;
        }

        mergeSort(left);
        mergeSort(right);

        merge(numbers, left, right);
    }

    private static void merge(int[] numbers, int[] left, int[] right){
        int leftLength = left.length;
        int rightLength = right.length;

        int i = 0, j = 0, k = 0;

        while(i < leftLength && j < rightLength){
           if(left[i] <= right[j]){
                numbers[k] = left[i];
                i++;
           }
           else{
                numbers[k] = right[j];
                j++;
           }
           k++;
        }

        while(i < leftLength){
            numbers[k] = left[i];
            i++;
            k++;
        }

        while(j < rightLength){
            numbers[k] = right[j];
            j++;
            k++;
        }
    }

    static void printArray(int[] numbers)
    {
        for(int i = 0; i < numbers.length; i++)
        {
            System.out.print(numbers[i] + " ");
        }       
    }

    public static void main(String[] args)
    {
        for(int i = 0; i < numbers.length; i++)
        {
            numbers[i] = rand.nextInt(1000); //Wypełnianie tablicy liczbami
        }

        System.out.println("Before:");
        printArray(numbers);

        mergeSort(numbers);

        System.out.println("\nAfter:");
        printArray(numbers);
    }
}