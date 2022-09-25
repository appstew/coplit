package com.example.coplit.daily;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class daily01 {


    @Test
    public void test01() {

        System.out.println("1. 배열을 입력받아 차례대로 배열의 첫 요소와 마지막 요소를 키와 값으로 하는 HashMap을 리턴해야 합니다.");
        System.out.println(transformFirstAndLast(new String[]{"a", "b", "c", "d"}));
        System.out.println("2. 연이율을 입력받아 원금이 2배 이상이 될 때까지 걸리는 시간(년)을 리턴해야 합니다.");
        System.out.println(computeWhenDouble(7));
        System.out.println("3. 수를 입력받아 2의 거듭제곱인지 여부를 리턴해야 합니다.");
        System.out.println(powerOfTwo(16));
        System.out.println("4. 문자열을 입력받아 문자열을 구성하는 각 단어의 첫 글자로 이루어진 문자열을 리턴해야 합니다.");
        System.out.println(firstCharacter("hello world"));
        System.out.println("5. 문자열을 입력받아 순서가 뒤집힌 문자열을 리턴해야 합니다.");
        System.out.println(firstReverse("I love codestates"));
        System.out.println("6. 문자열을 입력받아 문자열을 구성하는 각 단어의 첫 글자가 대문자인 문자열을 리턴해야 합니다.");
        System.out.println(letterCapitalize("java is good "));
        System.out.println("7. 2차원 배열(배열을 요소로 갖는 배열)을 입력받아 각 배열을 이용해 만든 HashMap을 리턴해야 합니다.");
        System.out.println(convertListToHashMap(new String[][]{
                {"make", "Ford"},
                {"model", "Mustang"},
                {"year", "1964"},
                {"make", "Bill"}
        }));
        System.out.println("8. 문자열을 입력받아 해당 문자열에 등장하는 두 칸의 공백을 모두 한 칸의 공백으로 바꾼 문자열을 리턴해야 합니다.");
        System.out.println(convertDoubleSpaceToSingle("string  with  double  spaces"));
        System.out.println("9. 문자열을 입력받아 문자열 내에 아래 중 하나가 존재하는지 여부를 리턴해야 합니다.\n" +
                "\n" +
                "    'a'로 시작해서 'b'로 끝나는 길이 5의 문자열\n" +
                "    'b'로 시작해서 'a'로 끝나는 길이 5의 문자열");
        System.out.println(ABCheck("aMAJ7sBrO4CyysuoHFrgGTX"));
        System.out.println("10. 문자열을 입력받아 연속된 한자리 홀수 숫자 사이에 '-'를 추가한 문자열을 리턴해야 합니다.");
        System.out.println(insertDash("6734611997679419173"));

    }

    @Test
    public HashMap<String, String> transformFirstAndLast(String[] arr) {
        //배열을 입력받아 차례대로 배열의 첫 요소와 마지막 요소를 키와 값으로 하는 HashMap을 리턴해야 합니다.
        if (arr.length == 0) return null;

        HashMap<String, String> map = new HashMap<String, String>();
        int a = arr.length - 1;

        map.put(arr[0], arr[a]);
        return map;
    }

    public int computeWhenDouble(double interestRate) {
        //연이율을 입력받아 원금이 2배 이상이 될 때까지 걸리는 시간(년)을 리턴해야 합니다.
        double cur = 1.0;
        double r = interestRate / 100;
        int result = 0;
        while (cur < 2.0) {
            cur = cur * (1 + r);
            result++;
        }
        return result;

    }

    public boolean powerOfTwo(long num) {
        if (num == 1) return true;
        if (num % 2 != 0) return false;

        long t = 2;
        while (t < num) {
            t = t * 2;
        }
        return t == num;
    }

    public String firstCharacter(String str) {
        if (str.length() == 0) return "";
        String[] arr = str.split(" ");
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            result = result + arr[i].charAt(0);
        }
        return result;
    }

    public String firstReverse(String str) {
        StringBuilder sb = new StringBuilder(str);

        return sb.reverse().toString();
    }

    public String letterCapitalize(String str) {
        if (str.trim().isEmpty()) return "";

        char[] r = str.toCharArray();
        r[0] = Character.toUpperCase(r[0]);

        for (int i = 0; i < str.length() - 1; i++) {

            if (r[i] == ' ' && r[i + 1] != ' ') {
                r[i + 1] = Character.toUpperCase(r[i + 1]);
            }

        }
        return new String(r);
    }

    public HashMap<String, String> convertListToHashMap(String[][] arr) {
        HashMap<String, String> result = new HashMap<>();
        if (arr.length == 0) return result;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 0 && !result.containsKey(arr[i][0])) {
                result.put(arr[i][0], arr[i][1]);
            }

        }
        return result;
    }

    public String convertDoubleSpaceToSingle(String str) {
        String[] words = str.split("  ");

        return String.join(" ", words);
    }

    public boolean ABCheck(String str) {
        if (str.length() == 0) return false;

        String s = str.toLowerCase();
        Boolean result;

        for (int i= 4; i<s.length(); i++) {
            if ((s.charAt(i) == 'a' && s.charAt(i-4) == 'b') || (s.charAt(i) == 'b' && s.charAt(i-4) == 'a'))
            return true;
        }
        return false;
    }

    public String insertDash(String str) {
        if (str.length() ==0 ) return null;
        String result = "" + str.charAt(0);

        for (int i =1; i<str.length(); i++) {
            int pre = Character.getNumericValue(str.charAt(i-1)) ;
            int cur = Character.getNumericValue(str.charAt(i));

            if (pre%2 !=0 && cur%2 !=0) {
                result = result + "-";
            }
            result = result + str.charAt(i);
        }
        return result;
    }



}


