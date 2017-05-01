/**
 * Created by jiken920 on 3/27/17.
 */
public class RomanToInteger {
    public int romanToInt(String s) {
        if(s.length() == 0) {
            return 0;
        }

        int result = 0;
        if(s.charAt(0) == 'M') {
            result = 1000 + romanToInt(s.substring(1));
        } else if(s.charAt(0) == 'D') {
            result = 500 + romanToInt(s.substring(1));
        } else if(s.charAt(0) == 'C') {
            if(s.length() > 1 && s.charAt(1) == 'M') {
                result = 900 + romanToInt(s.substring(2));
            } else if(s.length() > 1 && s.charAt(1) == 'D') {
                result = 400 + romanToInt(s.substring(2));
            } else {
                result = 100 + romanToInt(s.substring(1));
            }
        } else if(s.charAt(0) == 'L') {
            result = 50 + romanToInt(s.substring(1));
        } else if(s.charAt(0) == 'X') {
            if(s.length() > 1 && s.charAt(1) == 'C') {
                result = 90 + romanToInt(s.substring(2));
            } else if(s.length() > 1 && s.charAt(1) == 'L') {
                result = 40 + romanToInt(s.substring(2));
            } else {
                result = 10 + romanToInt(s.substring(1));
            }
        } else if(s.charAt(0) == 'V') {
            result = 5 + romanToInt(s.substring(1));
        } else if(s.charAt(0) == 'I') {
            if(s.length() > 1 && s.charAt(1) == 'X') {
                result += 9;
            } else if(s.length() > 1 && s.charAt(1) == 'V') {
                result += 4;
            } else {
                result = 1 + romanToInt(s.substring(1));
            }
        }

        return result;
    }

    public int romanToIntAlternate(String s) {
        int result = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == 'M') { result += 1000; }
            if(chars[i] == 'D') { result += 500; }
            if(chars[i] == 'C') { result += 100; }
            if(chars[i] == 'L') { result += 50; }
            if(chars[i] == 'X') { result += 10; }
            if(chars[i] == 'V') { result += 5; }
            if(chars[i] == 'I') { result += 1; }
        }

        if(s.indexOf("IX") != -1) { result -= 2; }
        if(s.indexOf("IV") != -1) { result -= 2; }
        if(s.indexOf("XL") != -1) { result -= 20; }
        if(s.indexOf("XC") != -1) { result -= 20; }
        if(s.indexOf("CD") != -1) { result -= 200; }
        if(s.indexOf("CM") != -1) { result -= 200; }

        return result;
    }
}
