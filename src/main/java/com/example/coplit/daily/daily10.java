package com.example.coplit.daily;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

//import static jdk.vm.ci.meta.JavaKind.Char;

public class daily10 {

    @Test
    public void test10() {
        System.out.println("11. 문자열을 요소로 갖는 배열을 입력받아 가장 짧은 문자열과 가장 긴 문자열을 제거한 배열을 리턴해야 합니다.");
        System.out.println(Arrays.toString(removeExtremes(new String[]{"where", "is", "the", "longest", "word"})));
        System.out.println("12. 배열을 입력받아 순서가 뒤집힌 배열을 리턴해야 합니다.");
        System.out.println(Arrays.toString(reverseArr(new int[]{1,2,3,4})));
        System.out.println("13. 문자열을 요소로 갖는 배열을 입력받아 문자열을 세로로 읽었을 때의 문자열을 리턴해야 합니다.");
        System.out.println(readVertically(new String[]{
                "hi",
                "wolrd",
        }));

    }

    public String[] removeExtremes(String[] arr) {
        if (arr.length == 0) return null;

        int longestLen = 0;
        int shortestLen = 20;
        int shortestIdx = 0;
        int longestIdx = 0;

        for (int i =0;i<arr.length; i++) {
            if (arr[i].length() >= longestLen) {
                longestLen = arr[i].length();
                longestIdx = i;
            }
            if (arr[i].length() <= shortestLen) {
                shortestLen = arr[i].length();
                shortestIdx = i;
            }
        }

        String[] result = new String[arr.length-2];
        int cur = 0;

        for (int i=0;i<arr.length;i++) {
            if (i != shortestIdx && i != longestIdx ) {
                result[cur] = arr[i];
                cur++;
            }
        }
        return result;
    }

    public int[] reverseArr(int[] arr) {
        if (arr.length == 0) return arr;

        int[] head = Arrays.copyOfRange(arr, arr.length-1, arr.length);
        int[] tail = reverseArr(Arrays.copyOfRange(arr, 0, arr.length-1));

        int[] dest = new int[head.length + tail.length];
        System.arraycopy(head, 0, dest, 0, head.length);
        System.arraycopy(tail, 0, dest, head.length, tail.length);
        return dest;

    }

    public String readVertically(String[] arr) {
        int maxLength = 0;

        for(int i =0; i<arr.length; i++) {
            if (maxLength < arr[i].length()) {
                maxLength = arr[i].length();
            }
        }
//        arr = new String[]{
//                "hi",
//                "world",
//        };
        String[] temp = new String[maxLength];
        // String[] temp = new String[5]

        for (int i=0; i<arr.length; i++) {
            String str = arr[i];
            for(int j=0; j<str.length();j++) {
                if ( temp[j] == null) {
                    temp[j] = Character.toString(str.charAt(j));
                    // String[] temp = {"h", "i", "r", "l", "d"}
                } else {
                    temp[j] = temp[j] + str.charAt(j);
                    // String[] temp = {"hw", "io", "r", "l", "d"}
                }
            }
        }

        String result = "";
        for (int i = 0; i<temp.length; i++) {
            result = result + temp[i];
        }
        return result;
    }












}
