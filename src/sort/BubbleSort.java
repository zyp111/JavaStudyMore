package sort;

public class BubbleSort {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void sort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            for(int j = 0; j < arr.length - i; j++) {
                if(arr[j] > arr[j+1])
                    swap(arr ,j, j+1);
            }
        }
    }

    public static void sort2(int[] arr) {  //冒泡算法改进
        //如果某次遍历中未曾发生交换，则不需进行下一次遍历，此时所有元素已是有序
        boolean needNextPass = true;
        for(int k = 1; k < arr.length; k++) {
            needNextPass = false;
            for(int i = 0; i < arr.length - k; i++) {
                if(arr[i] > arr[i+1]) {
                    swap(arr, i, i+1);
                    needNextPass = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,9,5,4,8,1,6};
//        sort(arr);
        sort2(arr);
        for(int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
    }
}
