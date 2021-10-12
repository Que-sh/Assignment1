class numbers {
   
    static void convert_to_words(char[] num)
    {
        
        int len = num.length;
 
        
        if (len == 0) {
            System.out.println("empty string");
            return;
        }
        if (len > 4) {
            System.out.println(
                "Length more than 4 is not supported");
            return;
        }
 
        
        String[] single_digits = new String[] {
            "zero", "one", "two",   "three", "four",
            "five", "six", "seven", "eight", "nine"
        };
 
        
        String[] two_digits = new String[] {
            "",          "ten",      "eleven",  "twelve",
            "thirteen",  "fourteen", "fifteen", "sixteen",
            "seventeen", "eighteen", "nineteen"
        };
 
        
        String[] tens_multiple = new String[] {
            "",      "",      "twenty",  "thirty", "forty",
            "fifty", "sixty", "seventy", "eighty", "ninety"
        };
 
        String[] tens_power
            = new String[] { "hundred", "thousand" };
 
        
        System.out.print(String.valueOf(num) + ": ");
 
       
        if (len == 1) {
            System.out.println(single_digits[num[0] - '0']);
            return;
        }
 
        
        int x = 0;
        while (x < num.length) {
 
            
            if (len >= 3) {
                if (num[x] - '0' != 0) {
                    System.out.print(
                        single_digits[num[x] - '0'] + " ");
                    System.out.print(tens_power[len - 3]
                                     + " ");
                    // here len can be 3 or 4
                }
                --len;
            }
 
            /* Code path for last 2 digits */
            else {
                /* Need to explicitly handle
                10-19. Sum of the two digits
                is used as index of "two_digits"
                array of strings */
                if (num[x] - '0' == 1) {
                    int sum
                        = num[x] - '0' + num[x + 1] - '0';
                    System.out.println(two_digits[sum]);
                    return;
                }
 
                /* Need to explicitely handle 20 */
                else if (num[x] - '0' == 2
                         && num[x + 1] - '0' == 0) {
                    System.out.println("twenty");
                    return;
                }
 
                /* Rest of the two digit
                numbers i.e., 21 to 99 */
                else {
                    int i = (num[x] - '0');
                    if (i > 0)
                        System.out.print(tens_multiple[i]
                                         + " ");
                    else
                        System.out.print("");
                    ++x;
                    if (num[x] - '0' != 0)
                        System.out.println(
                            single_digits[num[x] - '0']);
                }
            }
            ++x;
        }
    }
 
    // Driver Code
    public static void main(String[] args)
    {
        convert_to_words("20".toCharArray());
        
        convert_to_words("365".toCharArray());
        convert_to_words("86".toCharArray());
   
    }
}