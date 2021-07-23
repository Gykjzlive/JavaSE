package test;

/**
 * @author 蟑螂恶霸
 * @version 1.0
 * @description: TODO
 * @date 2021/3/25 11:35
 */
public class example {
    public static void main(String[] args) {
        int[] a = {3, 9, 2, 7, 2, 15, 74, 43, 61, 66, 22, 95, 11, 27, 49};
        int[] b = new int[a.length];
        for (int i : a) {
            System.out.print(i + " ");
        }
        f(a, b, 0, a.length - 1);
        System.out.println();
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    private static void f(int[] a, int[] b, int low, int hid) {
        if (low >= hid) return;
        int mid = (low + hid) / 2;
        f(a, b, low, mid);
        f(a, b, mid + 1, hid);
        fSort(a, b, low, mid, hid);
    }

    private static void fSort(int[] a, int[] b, int low, int mid, int hid) {
        int left = low;
        int right = mid + 1;
        int index = low;
        while (left <= mid && right <= hid) {
            if (a[left] <= a[right]) {
                b[index++] = a[left++];
            } else {
                b[index++] = a[right++];
            }
        }
        while (left <= mid) {
            b[index++] = a[left++];
        }
        while (right <= hid) {
            b[index++] = a[right++];
        }
        for (int i = low; i <= hid; i++) {
            a[i] = b[i];
        }
    }
}
