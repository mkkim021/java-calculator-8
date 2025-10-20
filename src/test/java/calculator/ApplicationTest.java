package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 구분자만_입력_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 구분자외_문자가_포함_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\na;2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 구분자가_마지막에_나오는_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n3;3;"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 처음에_구분자가_나오는_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n;3;3;"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 구분자외_다른_문자가_입력되는_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n3^3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
