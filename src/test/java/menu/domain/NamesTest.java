package menu.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NamesTest {
    @Test
    @DisplayName("올바른 범위 내의 인원이면 Names 객체가 생성된다.")
    void createNameWithRightCapacityRange() {
        //given
        List<String> inputNames = List.of("aa", "bb", "cc", "rr", "ff");
        //when
        //then
        assertThat(Names.from(inputNames)).isNotNull();
    }

    @Test
    void createNameWithOutOfCapacityRange() {
        //given
        List<String> inputNames = List.of("aa", "vv", "cc", "dd", "ff", "ee");
        //when
        //then
        assertThatThrownBy(() -> Names.from(inputNames)).isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 최소 2명부터 최대 5명까지 수용 가능합니다.\n");
    }
}