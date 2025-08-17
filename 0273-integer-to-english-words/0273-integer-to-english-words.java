class Solution {
    Map<Integer, String> map = Map.of(1000000000, "Billion ", 
                                        1000000, "Million ",
                                        1000, "Thousand ");
    Map<Integer, String> dmap = Map.of(2, "Twenty", 
                                        3, "Thirty",
                                        4, "Forty",
                                        5, "Fifty",
                                        6, "Sixty",
                                        7, "Seventy",
                                        8, "Eighty",
                                        9, "Ninety");
    Map<Integer, String> tmap = Map.of(
                                        10, "Ten",
                                        11, "Eleven", 
                                        12, "Twelve",
                                        13, "Thirteen",
                                        14, "Fourteen",
                                        15, "Fifteen",
                                        16, "Sixteen",
                                        17, "Seventeen",
                                        18, "Eighteen",
                                        19, "Nineteen");

    Map<Integer, String> smap = Map.of(
                                        1, "One",
                                        2, "Two", 
                                        3, "Three",
                                        4, "Four",
                                        5, "Five",
                                        6, "Six",
                                        7, "Seven",
                                        8, "Eight",
                                        9, "Nine");
    public String numberToWords(int num) {
        //million thousand hundred 20 - 90 10 --> 
        if(num == 0){
            return "Zero";
        }
        int val = 1000000000;
        StringBuilder sb = new StringBuilder();
        while(val > 0){
            int f = num / val % 1000;
            if(f != 0){
                sb.append(Helper(f));
                sb.append(map.getOrDefault(val, ""));
            }
            val /= 1000;
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();

    }

    public String Helper(int num){
        StringBuilder sb = new StringBuilder();
        int f = num / 100;
        if(f != 0){
            sb.append(smap.get(f));
            sb.append(" Hundred ");
        }
        f = num / 10 % 10;
        if(f == 1){
            sb.append(tmap.get(num%100));
            sb.append(" ");
            return sb.toString();
        }
        if(f != 0){
            sb.append(dmap.get(f));
            sb.append(" ");
        }

        f = num % 10;
        if(f != 0){
            sb.append(smap.get(f));
            sb.append(" ");
        }
        return sb.toString();
    }
}