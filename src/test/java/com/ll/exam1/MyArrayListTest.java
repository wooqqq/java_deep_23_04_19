package com.ll.exam1;

import com.ll.TestUt;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

public class MyArrayListTest {
    @Test
    @DisplayName("size()")
    void t01() {
        MyArrayList<String> list = new MyArrayList<>();
        assertThat(list.size()).isEqualTo(0);
    }

    @Test
    @DisplayName("add(\"사과\")")
    void t02() {
        MyArrayList<String> list = new MyArrayList<>();

        list.add("사과");
        list.add("포도");

        assertThat(list.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("get(1)")
    void t03() {
        MyArrayList<String> list = new MyArrayList<>();

        list.add("사과"); // data[0];
        list.add("포도"); // data[1];

        assertThat(list.get(0)).isEqualTo("사과"); // data[0];
        assertThat(list.get(1)).isEqualTo("포도"); // data[1];
    }

    @Test
    @DisplayName("data(배열)의 크기가 자동으로 늘어나야 한다.")
    void t04() {
        MyArrayList<String> list = new MyArrayList<>();

        // 초창기 배열의 길이
        int dataLength1 = ((Object[]) TestUt.getFieldValue(list, "data", null)).length;

        // IntStream.range(0, 10); = [0, ... 9] 까지의 int 스트림 발생
        // 딱 1번 넘칠만큼의 데이터를 넣는다.
        IntStream.range(0, dataLength1 + 1)
                        .forEach(index -> list.add("사과 %d".formatted(index)));

        // 현재 배열의 길이
        int dataLength2 = ((Object[]) TestUt.getFieldValue(list, "data", null)).length;
        assertThat(dataLength2).isGreaterThan(dataLength1);
    }

    @Test
    @DisplayName("MyArrayList 초기화(new) 시 생성자 인자로 data 배열의 사이즈 지정")
    void t05() {
        MyArrayList<String> list = new MyArrayList<>(200);

        // 초창기 배열의 길이
        int dataLength = ((Object[]) TestUt.getFieldValue(list, "data", null)).length;

        assertThat(dataLength).isEqualTo(200);
    }

    @Test
    @DisplayName("디버그 : 데이터를 많이 넣으면 배열증가가 많이 발생함")
    void t06() {
        MyArrayList<String> list = new MyArrayList<>();
        list.debug = true;

        IntStream.range(0, 100)
                .forEach(index -> list.add("사과 %d".formatted(index)));
    }

    @Test
    @DisplayName("디버그 : 애초에 큰 배열로 만들면 데이터를 많이 넣어도 배열증가가 빈번하지 않음")
    void t07() {
        MyArrayList<String> list = new MyArrayList<>();
        list.debug = true;

        IntStream.range(0, 100)
                .forEach(index -> list.add("사과 %d".formatted(index)));
    }

    @Test
    @DisplayName("indexOf")
    void t08() {
        MyArrayList<String> list = new MyArrayList<>(100);

        IntStream.range(0, 100)
                .forEach(index -> list.add("사과 %d".formatted(index)));

        assertThat(list.indexOf("사과 0")).isEqualTo(0);
        assertThat(list.indexOf("사과 1")).isEqualTo(1);
        assertThat(list.indexOf("사과 5")).isEqualTo(5);
        assertThat(list.indexOf("사과 99")).isEqualTo(99);
        assertThat(list.indexOf("사과 100")).isEqualTo(-1);
    }

    @Test
    @DisplayName("add(true)")
    void t09() {
        MyArrayList<Boolean> list = new MyArrayList<>();

        list.add(true);
        list.add(false);

        assertThat(list.size()).isEqualTo(2);
    }
}
