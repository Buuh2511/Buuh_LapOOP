    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0006;

import java.util.ArrayList;

/**
 *
 * @author Buu Huynh
 */
public class BinarySearch {

    public static void sortTheArray(ArrayList<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            for (int j = arr.size() - 1; j > i; j--) {
                if (arr.get(j) < arr.get(j - 1)) {
                    int tmp = arr.get(j);
                    arr.set(j, arr.get(j - 1));
                    arr.set(j - 1, tmp);
                }
            }
        }
    }

    public static int searchBinary(int num, ArrayList<Integer> arr) {
        int location = -1;
        int head = 0;
        int tail = arr.size() - 1;
        int mid = (head + tail) / 2;
        while (true) {
            if (head > tail) {
                return location;
            }
            if (arr.get(mid) == num) {
                location = mid;
                return location;
            }
            if (arr.get(mid) < num) {
                head = mid + 1;
                mid = (head + tail) / 2;
            }
            if (arr.get(mid) > num) {
                tail = mid - 1;
                mid = (head + tail) / 2;
            }
        }
    }
}
