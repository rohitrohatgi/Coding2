package rohit.leetcode;

/**
 * Created by rohit on 12/6/20.
 */
public class CountNumberOfTeams {
    public int numTeams(int[] rating) {
        int result = 0;

        for (int i = 1; i < rating.length - 1; i++) {
            int[] greater = new int[2];
            int[] smaller = new int[2];

            for (int j = 0; j < rating.length; j++) {
                if (rating[i] > rating[j]) {
                    greater[i > j ? 0 : 1] += 1;
                }
                if (rating[j] > rating[i]) {
                    smaller[i > j ? 0 : 1] += 1;
                }
            }

            result += greater[0] * smaller[1] + greater[1] * smaller[0];
        }

        return result;

    }

    public static void main(String[] args) {
        CountNumberOfTeams countNumberOfTeams = new CountNumberOfTeams();
        System.out.println(countNumberOfTeams.numTeams(new int[]{2,5,3,4,1}));
    }
}
