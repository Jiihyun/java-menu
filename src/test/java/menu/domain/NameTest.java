package menu.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {
    @Test
    @DisplayName("올바른 범위 내의 이름을 입력하면 이름 객체가 생성된다.")
    void createNameWithRightLengthRange() {
        //given
        String name = "jii";
        //when
        //then
        assertThat(Name.from(name)).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {"t", "abcde"})
    void createNameWithOutOfLengthRange(String name) {
        assertThatThrownBy(() -> Name.from(name)).isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 이름은 최소 2글자부터 최대 4글자까지 입력 가능합니다.\n");
    }
}