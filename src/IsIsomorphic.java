import java.util.ArrayList;
import java.util.Arrays;

public class IsIsomorphic {
    private class Map {
        private int[] keys = new int[2];
        private int[] values = new int[2];
        private int count = 0;
        public boolean find(int key, int value) {
           for (int i = 0; i < keys.length; i++) {
               if (keys[i] == key && values[i] == value) {
                   return true;
               }
           }
           return false;
        }
        public void add(int key, int value) {
            if (count >= keys.length / 2) {
                keys = expand(keys, keys.length * 2);
                values = expand(values, values.length * 2);
            }
            keys[count] = key;
            values[count++] = value;
        }
        private int[] expand(int[] array, int newLength) {
            int[] tmp = new int[newLength];
            for (int i = 0; i < array.length; i++) {
                tmp[i] = array[i];
            }
            return tmp;
        }
        public boolean hasDuplicateKeys() {
            int countKeys = 0;
            boolean hasZero = false;
            for (int i = 0; i < keys.length; i++) {
                if (keys[i] == 0 && hasZero == false) {
                    hasZero = true;
                }
                if (keys[i] != 0) {
                    countKeys++;
                }
            }
            if (hasZero) {
                return (Arrays.stream(keys).distinct().count() - 1) != countKeys;
            }
            return Arrays.stream(keys).distinct().count() != countKeys;
        }
    }
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length() || s.chars().distinct().count() != t.chars().distinct().count()) {
            return false;
        }
        Map map = new Map();
        for (int i = 0; i < s.length(); i++) {
            if (!map.find(s.charAt(i), t.charAt(i))) {
                map.add(s.charAt(i), t.charAt(i));
            }

        }
        if (map.hasDuplicateKeys()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        IsIsomorphic ii = new IsIsomorphic();
        System.out.println(ii.isIsomorphic("egg", "add")); // true
        System.out.println(ii.isIsomorphic("foo", "bar")); // false
        System.out.println(ii.isIsomorphic("aaabba", "bbbaab")); // true
        System.out.println(ii.isIsomorphic("aaabba", "bbaaab")); // false
    }
}

/*
BEST SOLUTION "aaabba", "bbaaab" a = 97, b = 98
public boolean isIsomorphic(String s, String t) {
        char alpha[] = new char[257];
        boolean arr[] = new boolean[257];
        char ss[] = s.toCharArray();
        char tt[] = t.toCharArray();

        for(int i = 0; i < ss.length; i++){
            if(alpha[tt[i]] == 0 && arr[ss[i]] == false){
                   arr[ss[i]] = true;
                   alpha[tt[i]] = ss[i];

            }else if(alpha[tt[i]] != ss[i]){
                return false;
            }
        }
        return true;
    }
 */
