package modernjavainaction.chap05;

import static java.util.Comparator.comparing;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Chap05Test {
    private List<Transaction> transactions;

    @BeforeEach
    void settings() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
    }

    @Test
    @DisplayName("2011년에 일어난 모든 트랜잭션을 찾아 값을 오름차순으로 정리하시오.")
    void quiz_01() {
        List<Transaction> result = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .toList();

        assertThat(result.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("거래자가 근무하는 모든 도시를 중복 없이 나열하시오.")
    void quiz_02() {
        List<String> result = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .toList();

        assertThat(result).isEqualTo(List.of("Cambridge", "Milan"));
    }

    @Test
    @DisplayName("케임브리지에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬하시오.")
    void quiz_03() {

    }

    @Test
    @DisplayName("모든 거래자의 이름을 알파벳순으로 정렬해서 변환하시오.")
    void quiz_04() {

    }

    @Test
    @DisplayName("밀라노에 거래자가 있는가?")
    void quiz_05() {

    }

    @Test
    @DisplayName("케임브리지에 거주하는 거래자의 모든 트랜잭션값을 출력하시오.")
    void quiz_06() {

    }

    @Test
    @DisplayName("전체 트랜잭션 중 최댓값은 얼마인가?")
    void quiz_07() {

    }

    @Test
    @DisplayName("전체 트랜잭션 중 최솟값을 얼마인가?")
    void quiz_08() {

    }
}