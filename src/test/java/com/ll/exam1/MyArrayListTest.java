package com.ll.exam1;

import com.ll.TestUt;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.atIndex;

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
        int dataLength1 = ((String[]) TestUt.getFieldValue(list, "data", null)).length;

        // IntStream.range(0, 10); = [0, ... 9] 까지의 int 스트림 발생
        // 딱 1번 넘칠만큼의 데이터를 넣는다.
        IntStream.range(0, dataLength1 + 1)
                        .forEach(index -> list.add("사과 %d".formatted(index)));

        // 현재 배열의 길이
        int dataLength2 = ((String[]) TestUt.getFieldValue(list, "data", null)).length;
        assertThat(dataLength2).isGreaterThan(dataLength1);
    }
}
