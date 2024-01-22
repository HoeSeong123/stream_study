import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

public class StreamTest {
    @Nested
    @DisplayName("퀴즈 5-2")
    class quiz_5_2 {
        @Test
        @DisplayName("1번")
        void quiz_1() {
            List<Integer> nums = List.of(1, 2, 3, 4, 5);
            List<Integer> squares = nums.stream()
                    .map(n -> n * n)
                    .toList();

            assertThat(squares).isEqualTo(List.of(1, 4, 9, 16, 25));
        }

        @Test
        @DisplayName("2번")
        void quiz_2() {
            List<Integer> num1 = List.of(1, 2, 3);
            List<Integer> num2 = List.of(3, 4);

            List<int[]> result = num1.stream()
                    .flatMap(i -> num2.stream()
                            .map(j -> new int[]{i, j}))
                    .toList();

            assertArrayEquals(new int[]{1, 3}, result.get(0));
            assertArrayEquals(new int[]{1, 4}, result.get(1));
            assertArrayEquals(new int[]{2, 3}, result.get(2));
            assertArrayEquals(new int[]{2, 4}, result.get(3));
            assertArrayEquals(new int[]{3, 3}, result.get(4));
            assertArrayEquals(new int[]{3, 4}, result.get(5));
        }

        @Test
        @DisplayName("3번")
        void quiz_3() {
            List<Integer> num1 = List.of(1, 2, 3);
            List<Integer> num2 = List.of(3, 4);

            List<int[]> result = num1.stream()
                    .flatMap(i -> num2.stream()
                            .filter(j -> (i + j) % 3 == 0)
                            .map(j -> new int[]{i, j}))
                    .toList();

            assertArrayEquals(new int[]{2, 4}, result.get(0));
            assertArrayEquals(new int[]{3, 3}, result.get(1));
        }
    }

}
