class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int leftsum=0;
        int rightsum=0;
        int maxsum=0;
        for(int i=0;i<k;i++){
            leftsum+=cardPoints[i];
        }
        maxsum=leftsum;
        int index=cardPoints.length-1;
        for(int i=k-1;i>=0;i--){
            rightsum+=cardPoints[index];
            index--;
            leftsum-=cardPoints[i];
            maxsum=Math.max(maxsum , leftsum+rightsum);
        }
        return maxsum;
    }
}