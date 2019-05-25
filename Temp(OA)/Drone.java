import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World!");

        List<List<Integer>> forwardList = new ArrayList<>();
        List<List<Integer>> returnList = new ArrayList<>();

        forwardList.add(Arrays.asList(1, 3000));
        forwardList.add(Arrays.asList(2, 5000));
        forwardList.add(Arrays.asList(3, 7000));
        forwardList.add(Arrays.asList(4, 10000));

        returnList.add(Arrays.asList(1, 2000));
        returnList.add(Arrays.asList(2, 3000));
        returnList.add(Arrays.asList(3, 4000));
        returnList.add(Arrays.asList(4, 5000));

        Main main = new Main();

        List<List<Integer>> res = main.findTheClosest(10000,forwardList,returnList);
        System.out.println(res);

    }

    public List<List<Integer>> findTheClosest(int maxTravelDistance, List<List<Integer>> forwardRouteList, List<List<Integer>> returnRouteList) {
        int gap = Integer.MAX_VALUE;
        int left = 0, right = returnRouteList.size() -1;

        List<List<Integer>> res = new ArrayList<>();
        int forwardSize = forwardRouteList.size(), returnSize = returnRouteList.size() ;
        if (maxTravelDistance == 0 || forwardSize   == 0 || returnSize == 0) {
            return res;
        }

        //Collections.sort(forwardRouteList, Comparator.comparingInt(a -> a.get(1)));
        //Collections.sort(returnRouteList, Comparator.comparingInt(a -> a.get(1)));

        while (left < forwardSize && right >= 0) {
            int sum = forwardRouteList.get(left).get(1) + returnRouteList.get(right).get(1);

            if (maxTravelDistance - sum >= 0 && maxTravelDistance - sum <= gap) {
                if (maxTravelDistance - sum < gap) {
                    gap = maxTravelDistance - sum;
                    res = new ArrayList<>();
                }
                res.add(Arrays.asList(forwardRouteList.get(left).get(0), returnRouteList.get(right).get(0)));
                // Should handler duplicate here
            }

            if (sum >= maxTravelDistance) {
                right--;
            } else {
                left++;
            }
        }
        return res;
    }
}
