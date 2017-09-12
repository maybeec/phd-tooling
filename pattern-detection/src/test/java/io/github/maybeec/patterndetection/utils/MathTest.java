package io.github.maybeec.patterndetection.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

/**
 *
 */
public class MathTest {

    @Test
    public void testMultichoose() {
        assertThat(MathUtil.multichoose(5, 2)).containsExactly(new int[] { 0, 5 }, new int[] { 1, 4 },
            new int[] { 2, 3 }, new int[] { 3, 2 }, new int[] { 4, 1 }, new int[] { 5, 0 });
    }

    @Test
    public void testMultichooseMin1() {
        assertThat(MathUtil.multichooseMin1(5, 2)).containsExactly(new int[] { 1, 4 }, new int[] { 2, 3 },
            new int[] { 3, 2 }, new int[] { 4, 1 });
    }
}
