package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Lixuhang
 * @date 2023/4/14
 * @whatItFor
 */
public class testJava {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("张三", "李四"));
        Set<TestA> collect = list.stream()
                .map(TestA::new
                ).collect(Collectors.toSet());
    }
}
