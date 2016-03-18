

// first accepcted version
/* thoughts
1 <-> 1
8 <-> 8
0 <-> 0 : only occur when len > 2, and should not be put at head or tail
6 <-> 9 : should not be put at middle

methodolody: using backtracking to gain all combinations
*/

public class Solution {
    public List<String> findStrobogrammatic(int n) {
        char[] candidates = {'1', '8', '0', '6', '9'};
        List<String> res = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        backtracking(0, n, path, res, candidates);
        return res;
    }
    
    private void backtracking(int pos, int len, StringBuilder path, List<String> res, char[] candidates) {
        // if surppass half of the len, check the middle bit and added up the remain bits
        if (pos >= (len + 1) / 2) {
            // not valid
            if (len % 2 == 1 && (path.charAt(pos - 1) == '6' || path.charAt(pos - 1) == '9')) {
                return;
            }
            StringBuilder resPath = new StringBuilder(path.toString());
            for (int i = len / 2 - 1; i >= 0; --i) {
                resPath.append(getPair(resPath.charAt(i)));
            }
            res.add(resPath.toString());
            return;
        }
        
        for (char c : candidates) {
            if (pos == 0 && c == '0' && len != 1) {
                continue;
            }
            path.append(c);
            backtracking(pos + 1, len, path, res, candidates);
            path.deleteCharAt(path.length() - 1);
        }
    }
    
    private char getPair(char c) {
        if (c == '1' || c == '8' || c == '0') {
            return c;
        }
        else if (c == '9') {
            return '6';
        }
        else {
            return '9';
        }
    }
}