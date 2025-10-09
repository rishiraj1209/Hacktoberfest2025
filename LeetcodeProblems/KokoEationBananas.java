class Solution {
    private int calMax(int[] piles){
        int maxi = Integer.MIN_VALUE;
        for(int i=0; i<piles.length; i++){
            maxi = Math.max(maxi,piles[i]);
        }
        return maxi;
    }

    private int calHours(int piles[], int rate){
        int hours = 0;
        for(int i=0; i<piles.length; i++){
            hours += Math.ceil((double)piles[i]/rate); // we put double to get decimal values
        }
        return hours;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int maxi = calMax(piles);
        int s = 1; int e = maxi;
        while(s <= e){
            int mid = s + (e-s)/2;
            int hours = calHours(piles,mid);
            if(hours <= h){
                e = mid-1;
            }else{
                s = mid+1;
            }
        }
        return s;
    }
}
