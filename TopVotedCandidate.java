class TopVotedCandidate {

    int[] persons;
    int[] times;
    public TopVotedCandidate(int[] persons, int[] times) {
        this.persons = persons;
        this.times = times;
    }

    public int q(int t) {


        Arrays.b
        int i = performBinarySearch(this.times, t);
        int candidate = findMostVotedCandidate(this.persons, i);

    }

    private int performBinarySearch(int[] times, int t) {

        int lo = 0;
        int hi = times.length-1;
        while(lo <= hi) {
            int mid = lo +(hi-lo)/2;
            if(times[mid] == t) {
                retur mid;
            }else if ( t< times[mid]) {
                hi = mid-1;
            }else {
                lo = mid+1;
            }
        }

        return mid;
    }

    private int findMostVotedCandidate(int[] persons, int range) {
        int c
        for(int i =0; i<= range; i++) {

        }
    }
}
