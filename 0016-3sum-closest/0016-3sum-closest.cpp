class Solution {
public:
    int threeSumClosest(vector<int>& arr, int target) {
        int n = arr.size();
        sort(arr.begin(), arr.end());
        int ans = -1000001;
        for (int i = 0; i < n-2; i++) {
            int l = i + 1, r = n - 1;

            while (l < r) {
                if (arr[i] + arr[l] + arr[r] < target) {

                    if (abs(ans-target) >= abs(target - arr[i] - arr[l] - arr[r])) {
                        ans = arr[i] + arr[l] + arr[r];
                    }
                    l++;

                } else if (arr[i] + arr[l] + arr[r] > target) {

                    if (abs(ans-target) >= abs(target - arr[i] - arr[l] - arr[r])) {
                        ans = arr[i] + arr[l] + arr[r];
                    }
                    r--;

                } else {
                    return target;
                }
            }
        }

        return ans;
    }
};