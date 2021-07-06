package day0706;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author liu yicheng
 * @date 2021/7/6 - 8:38
 */
public class Test01 {

    public List<List<String>> displayTable(List<List<String>> orders) {
        Map<String, Map<String, Integer>> map = new HashMap<>();
        Set<String> food = new HashSet<>();
        for (List<String> order : orders) {
            String x = order.get(1), y = order.get(2);
            Map<String, Integer> cnt = map.getOrDefault(x, new HashMap<>());
            food.add(y); // 统计菜品
            cnt.put(y, cnt.getOrDefault(y, 0) + 1);
            map.put(x, cnt);
        }

        // return
        List<List<String>> ans = new ArrayList<>();
        // 菜单
        List<String> foodNames = new ArrayList<>();
        for (String s : food) foodNames.add(s);
        Collections.sort(foodNames);
        List<String> title = new ArrayList<>();
        title.add("Table");
        for (String s : foodNames) title.add(s);
        ans.add(title);

        List<String> sorted = map.keySet().stream().sorted((x, y) -> {
            int a = Integer.parseInt(x), b = Integer.parseInt(y);
            return a - b;
        }).collect(Collectors.toList());

        for (String s : sorted) {
            List<String> temp = new ArrayList<>();
            temp.add(s);
            Map<String, Integer> k = map.get(s);
            for (String f : foodNames) {
                temp.add(String.valueOf(k.getOrDefault(f, 0)));
            }
            ans.add(temp);
        }
        return ans;
    }

    public static void main(String[] args) {
        List<List<String>> data = new ArrayList<>();
        String[] v1 = {"David","3","Ceviche"};
        String[] v2 = {"Corina","10","Beef Burrito"};
        String[] v3 = {"David","3","Fried Chicken"};
        String[] v4 = {"Carla","5","Water"};
        String[] v5 = {"Carla","5","Ceviche"};
        String[] v6 = {"Rous","3","Ceviche"};

        data.add(Arrays.stream(v1).collect(Collectors.toList()));
        data.add(Arrays.stream(v2).collect(Collectors.toList()));
        data.add(Arrays.stream(v3).collect(Collectors.toList()));
        data.add(Arrays.stream(v4).collect(Collectors.toList()));
        data.add(Arrays.stream(v5).collect(Collectors.toList()));
        data.add(Arrays.stream(v6).collect(Collectors.toList()));
        new Test01().displayTable(data);
    }
}
