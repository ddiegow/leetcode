public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        if (t.length() == 0) {
            return false;
        }
        for (int i = 0, j = 0; i < s.length(); i++) {
            while (t.charAt(j) != s.charAt(i)) {
                j++;
                if (j >= t.length()) {
                    return false;
                }
            }
            j++;
            if (j >= t.length() && i < s.length() - 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsSubsequence is = new IsSubsequence();
        System.out.println(is.isSubsequence("abc", "ahbgdc"));
    }
}
