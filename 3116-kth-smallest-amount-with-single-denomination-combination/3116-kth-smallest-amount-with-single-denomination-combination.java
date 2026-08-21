import java.util.*;

class Solution {
    public long findKthSmallest(int[] coins, int k) {
        int n = coins.length;
        List<Long> lcms = new ArrayList<>();
        List<Integer> signs = new ArrayList<>();

        int total = 1 << n;
        for (int mask = 1; mask < total; mask++) {
            long curLcm = 1;
            boolean overflow = false;

            for (int j = 0; j < n; j++) {
                if (((mask >> j) & 1) == 1) {
                    curLcm = lcm(curLcm, coins[j]);
                    if (curLcm > (long) 1e18) {
                        overflow = true;
                        break;
                    }
                }
            }

            if (!overflow) {
                lcms.add(curLcm);
                signs.add((Integer.bitCount(mask) % 2 == 1) ? 1 : -1);
            }
        }

        long low = 1;
        long high = (long) Arrays.stream(coins).min().getAsInt() * k;

        while (low < high) {
            long mid = low + (high - low) / 2;
            if (count(mid, lcms, signs) < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    private long count(long target, List<Long> lcms, List<Integer> signs) {
        long cnt = 0;
        for (int i = 0; i < lcms.size(); i++) {
            cnt += signs.get(i) * (target / lcms.get(i));
        }
        return cnt;
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }
}