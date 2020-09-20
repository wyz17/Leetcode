class Solution {
    public String convert(String s, int numRows) {
        if(s == null || s.length() == 0 || numRows <=0)
            return "";
        if(numRows == 1)
            return s;

        StringBuilder res = new StringBuilder();
        int circle = 2 * numRows - 2;

        for(int i = 0; i < numRows; i++){ //行数
            for(int j = i; j < s.length(); j += circle){
                res.append(s.charAt(j));
                if(i != 0 && i != numRows - 1){
                    int temp = j + circle - 2 * i;
                    if(temp < s.length())
                        res.append(s.charAt(temp));
                }
            }
        }

        return res.toString();
    }
}
