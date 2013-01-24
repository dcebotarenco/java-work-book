package sdgtyh;
import java.util.*;

public class RandomFileTest
{  

public static void main(final String[] args) {
    print_nCr(3, 2);
}

public static final void print_nCr(final int n, final int r) {
    int[] res = new int[r];
    for (int i = 0; i < res.length; i++) {
        res[i] = i + 1;
    }
    boolean done = false;
    while (!done) {
        System.out.println(Arrays.toString(res));
        done = getNext(res, n, r);
    }
}

/////////

public static final boolean getNext(final int[] num, final int n, final int r) {
    int target = r - 1;
    num[target]++;
    if (num[target] > ((n - (r - target)) + 1)) {
        // Carry the One
        while (num[target] > ((n - (r - target)))) {
            target--;
            if (target < 0) {
                break;
            }
        }
        if (target < 0) {
            return true;
        }
        num[target]++;
        for (int i = target + 1; i < num.length; i++) {
            num[i] = num[i - 1] + 1;
        }
    }
    return false;
}
}
