// Buat program Java yang mengurutkan data dari terbesar ke terkecil menggunakan Merge Sort, Tentukan sendiri nilai untuk variabel (misal): a1, a2, a3, a4, a5, a6, a7, a8 (minimal 8 elemen). Kemudian buat analisa kinerja algoritma tersebut menurut anda?

import java.util.Arrays;

public class Soal1 {
    
    public static void mergeSortDesc(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        int[] temp = new int[arr.length];
        mergeSortDesc(arr, temp, 0, arr.length - 1);
    }

    private static void mergeSortDesc(int[] arr, int[] temp, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;

        mergeSortDesc(arr, temp, left, mid);
        mergeSortDesc(arr, temp, mid + 1, right);
        merge(arr, temp, left, mid, right);
    }

    private static void merge(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (arr[i] >= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        for (int p = left; p <= right; p++) arr[p] = temp[p];
    }

    public static void main(String[] args) {
        int[] data = {42, 17, 99, 23, 17, -5, 64, 64};
        System.out.println("Data awal: " + Arrays.toString(data));
        mergeSortDesc(data);
        System.out.println("Hasil Merge Sort Desc: " + Arrays.toString(data));
    }
}

