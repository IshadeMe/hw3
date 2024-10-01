package org.example;

import java.util.HashSet;
import java.util.TreeMap;


public class HomeWork {

    /**
     * <h1>Задание 1.</h1>
     * Метод возвращает подстроку максимальной длины в которой не повторяются символы
     * Если найдено несколько подстрок одинаковой длины - вернуть первую.
     * <p>
     * Пример 1 вход= abcddcba, выход = abcd
     * Так как найдены две подстроки с неповторяющимися значениями:
     * 1) abcd
     * 2) dcba
     * Они динаковой длины, по этому возвращаем 1 строку
     * <p>
     * Пример 2 вход= abcddcbaX, выход = dcbaX
     * Так как эта подстрока самая большая
     *
     * @param str входная не пустая строка
     * @return максимальная подстрока из уникальных значений
     * Сигнатуру метода не меняем
     */
    public String findMaxSubstring(String str) {
        var map = new TreeMap<Integer, Integer>(Integer::compareTo);
        var substring = new HashSet<>();
        var right = 0;
        while (right < str.length()) {
            var appendableChar = str.charAt(right);
            var left = right - substring.size();
            while (!substring.add(appendableChar)) {
                substring.remove(str.charAt(left++));
            }
            map.putIfAbsent(substring.size(), ++right);
        }
        var entry = map.lastEntry();
        return str.substring(entry.getValue() - entry.getKey(), entry.getValue());
    }


    /**
     * Задача со зведочкой (опционально)
     * <br/>
     * Можно решать так же для английского алфавита, проверять что присутствуют буквы от A до Z хотя бы по одному разу.
     * <br/>
     * A pangram is a sentence that contains every single letter of the alphabet at least once. For example, the sentence "The quick brown fox jumps over the lazy dog" is a pangram, because it uses the letters A-Z at least once (case is irrelevant).
     * <p>
     * Given a string, detect whether or not it is a pangram. Return True if it is, False if not. Ignore numbers and punctuation.
     *
     * @see <a href="https://www.codewars.com/kata/545cedaa9943f7fe7b000048">https://www.codewars.com/kata/545cedaa9943f7fe7b000048</a>
     */
    public boolean check(String sentence) {
        return 26 ==
                sentence.toUpperCase().chars()
                        .mapToObj(e -> (char) e)
                        .filter(x -> x >= 'A' && x <= 'Z')
                        .distinct()
                        .count();
    }

}
