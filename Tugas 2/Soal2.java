// Buat program Java yang mengurutkan data dari terbesar ke terkecil menggunakan Counting Sort, Tentukan sendiri nilai untuk variabel (misal): a1, a2, a3, a4, a5, a6, a7, a8 minimal 8 elemen). Kemudian buat analisa kinerja algoritma tersebut menurut anda?

import java.util.Arrays;

public class Soal2 {

    public static void countingSortDesc(int[] arr) {
        int min = arr[0], max = arr[0];

        for (int v : arr) {
            if (v < min) min = v;
            if (v > max) max = v;
        }

        int[] count = new int[max - min + 1];

        for (int v : arr) count[v - min]++;

        int index = 0;
        for (int value = max; value >= min; value--) {
            while (count[value - min]-- > 0) {
                arr[index++] = value;
            }
        }
    }

    public static void main(String[] args) {
        int[] data = {42, 17, 99, 23, 17, -5, 64, 64};
        System.out.println("Data awal: " + Arrays.toString(data));
        countingSortDesc(data);
        System.out.println("Hasil Counting Sort Desc: " + Arrays.toString(data));
    }
}

