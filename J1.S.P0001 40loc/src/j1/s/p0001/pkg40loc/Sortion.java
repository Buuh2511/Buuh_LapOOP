
package j1.s.p0001.pkg40loc;

import java.util.ArrayList;

/**
 *
 * @author Buu Huynh
 */

public class Sortion {
    public static void caculateSortion(ArrayList<Integer> ar){
       for (int i = 0; i < ar.size() - 1; i++) {
            for (int j = i + 1; j < ar.size(); j++) {
                if(ar.get(i) > ar.get(j)){
                    int tmp;
                    tmp = ar.get(i);
                    ar.set(i, ar.get(j));
                    ar.set(j, tmp);
                }
            }
        }
    }
}
