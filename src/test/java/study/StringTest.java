package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("학습 테스트 실습 1단계 - Junit, AssertJ 사용법 숙지")
public class StringTest {

    @ParameterizedTest
    @ValueSource(strings = "1,2")
    @DisplayName("[요구사항 1] '1,2' 문자열을 ','으로 split 할 때 '1', '2'로 잘 분리되는지 확인")
    void validateContainsElementsInReturnStringArrayWhenUseSplitMethod(final String givenInput) {
        final String separator = ",";
        final String one = "1";
        final String two = "2";

        final String[] splitStrArr = givenInput.split(separator);

        assertThat(splitStrArr).contains(one, two);
        assertThat(splitStrArr).containsExactly(one, two);
    }

    @ParameterizedTest
    @ValueSource(strings = "(1,2)")
    @DisplayName("[요구사항 2] '(1,2)' 문자열을 substring 메서드를 사용하여 '('와 ')'을 제거하여 '1,2'만을 포함하는 배열을 반환하는지 확인")
    void checkReturnStringAnd1And2SameWhenUseSubstringMethod(final String givenInput) {
        final int startPoint = 1;
        final String oneAndTwo = "1,2";

        final String resultStr = givenInput.substring(startPoint, givenInput.length() - 1);

        assertThat(resultStr).isEqualTo(oneAndTwo);
    }

    @ParameterizedTest
    @ValueSource(strings = "abc")
    @DisplayName("[요구사항 3-1] 'abc' 문자열을 charAt 메서드 사용시 유효한 위치값을 벗어나 " +
        "StringIndexOutOfBoundsException 예외 발생시 assertThatThrownBy 메서드를 사용하여 확인")
    void validateReturnIndexOutOfBoundsExceptionWhenUseCharAtMethod(final String givenInput) {
        assertThatThrownBy(
            () -> givenInput.charAt(givenInput.length()))
            .isInstanceOf(StringIndexOutOfBoundsException.class)
            .hasMessageContaining("String index out of range: 3");
    }

    @ParameterizedTest
    @ValueSource(strings = "abc")
    @DisplayName("[요구사항 3-2] 'abc' 문자열을 charAt 메서드 사용시 유효한 위치값을 벗어나 " +
        "StringIndexOutOfBoundsException 예외 발생시 assertThatExceptionOfType 메서드를 사용하여 확인")
    void validateReturnIndexOutOfBoundsExceptionWhenUseCharAtMethod2(final String givenInput) {
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
            .isThrownBy(() -> givenInput.charAt(givenInput.length()))
            .withMessageMatching("String index out of range: 3");
    }
}
