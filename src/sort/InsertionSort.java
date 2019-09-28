package sort;

public class InsertionSort {
    public static void sort(int[] arr){
        for(int i = 1; i < arr.length; i++) {
            for(int j = i - 1; j >= 0; j--) {
                if(arr[j] > arr[j + 1])
                    swap(arr,j, j+1);
            }
        }
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {2,9,5,4,8,1,6};
        sort(arr);
        for(int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
    }
}
