public class MountainArrayProblem {


    public int findInMountainArray(int target, MountainArray mountainArr) {

        int lo = 0;
        int hi = mountainArr.length()-1;

        while (lo < hi) {

            int mid = lo + (hi-lo)/2;

            int currentMid = mountainArr.get(mid);
            if(currentMid == target) {
                return mid;
            }else if(currentMid < mountainArr.get(mid+1)) {

                if (target < currentMid ) {
                    hi = mid-1;
                }else {
                    lo = mid+1;
                }

            }else {
                if (target < currentMid ) {
                    lo = mid+1;
                }else {
                    hi = mid-1;
                }
            }


        }

        return -1;
    }

    public static void main(String[] args) {

        MountainArray mountainArray = new MountainArray(new int[] {1,2,3,4,5,3,1});
        MountainArrayProblem mrp = new MountainArrayProblem();

        System.out.println(mrp.findInMountainArray(3, mountainArray));
    }
}
