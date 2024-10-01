package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class HomeWorkTest {

    private final HomeWork hw = new HomeWork();

    @ParameterizedTest
    @MethodSource("provideString")
    void findMaxSubstring(Map.Entry<String, String> arg) {
        var result = hw.findMaxSubstring(arg.getKey());
        assertEquals(arg.getValue(), result);
    }

    @Test
    void checkSuccess() {
        assertTrue(hw.check("The quick brown fox jumps over the lazy dog"));
    }

    @Test
    void checkFail() {
        assertFalse(hw.check("The quick brown fox jumps over the lazy do"));
    }

    private static Stream<Arguments> provideString() {
        return Stream.of(
                Arguments.of(Map.entry("aaaaaaaaaaaaaaaaaaa", "a")),
                Arguments.of(Map.entry("aaaaaaaaaaaaaaaaaaab", "ab")),
                Arguments.of(Map.entry("abcddcba", "abcd")),
                Arguments.of(Map.entry("abcddcbaX", "dcbaX")),
                Arguments.of(Map.entry("abcddabcdffabcdd", "abcdf"))
        );
    }

}