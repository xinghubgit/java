package list;

import java.math.BigInteger;

/**
 * @author allen.jin
 * @date 2021/1/19
 * @Description TODO
 */
public class BigIntegerFib {
    public static void main(String[] args) {
        BigInteger first = BigInteger.ONE;
        BigInteger second = BigInteger.ONE;
        String f = "1";
        String s ="1";
        int length = 100;
        long now = System.currentTimeMillis();
        int n = firstNthValueLengthGreaterThan(first, second, length);
        System.out.println(n);
        long later = System.currentTimeMillis();
        System.out.println("Cost: " + (later - now));
//        char[] sum = sum(f.toCharArray(), s.toCharArray());
        int sum = nthValue(f.toCharArray(), s.toCharArray(), length);
        System.out.println(sum);
        System.out.println("Cost2: " + (System.currentTimeMillis() - later));






//        System.out.println(n);
    }

    public static int nthValue(char[] first, char[] second, int n) {
        int count = 0;
        if (first.length == n) {
            return ++count;
        } else {
            count++;
        }
        if (second.length == n) {
            return ++count;
        } else {
            count++;
        }
        while (true) {
            char[] sum = sum(first, second);
            first = second;
            second = sum;
            count++;
//            System.out.println("count : " + count + " sum : " + String.valueOf(sum));
            if (sum.length >= n) {
                System.out.println("count : " + count + " sum : " + String.valueOf(sum));
                break;
            }
        }
        return count;
    }



    public static char[] sum(char[] num1, char[] num2) {
        int radix = 0;
        int sum = 0;
        int length = num1.length > num2.length ? num1.length + 1 : num2.length + 1;
        char[] result = new char[length];
        for (int j = 0; j < result.length; j++) {
            result[j] = '0';
        }
        int i = 0;
        while (i < num1.length && i < num2.length) {
            sum = num1[i] - '0' + num2[i] - '0' + radix;
            radix = 0;
            if (sum >= 10) {
                radix++;
                sum = sum % 10;
            }
            result[i] = (char)(sum + '0');
            i++;
        }
        if (i < num1.length) {
            while (i < num1.length) {
                if (radix > 0) {
                    sum = num1[i] + radix - '0';
                    radix = 0;
                    if (sum >= 10) {
                        sum = sum % 10;
                        radix++;
                    }
                    result[i] = (char) (sum + '0');
                } else {
                    result[i] = (char)(num1[i]);
                }
                i++;
            }
            if (radix > 0) {
                result[i] = (char) (1 + '0');
            }
        } else if (i < num2.length) {
            while (i < num2.length) {
                if (radix > 0) {
                    sum = num2[i] + radix - '0';
                    radix = 0;
                    if (sum >= 10) {
                        sum = sum % 10;
                        radix++;
                    }
                    result[i] = (char) (sum + '0');
                } else {
                    result[i] = (char)(num2[i]);
                }
                i++;
            }
            if (radix > 0) {
                result[i] = (char) (1 + '0');
            }
        } else {
            if (radix > 0) {
                result[i] = (char) (1 + '0');
            }
        }
        if (result[result.length - 1] == '0') {
            char[] extraResult = new char[result.length-1];
            System.arraycopy(result, 0 , extraResult, 0,result.length - 1);
            return extraResult;
        } else {
            return result;

        }

    }


    public static int firstNthValueLengthGreaterThan(BigInteger first, BigInteger second, int length) {
        int count = 0;
        if (length <= 0 ) {
            return count;
        }
        if (first.toString().length() < length) {
            count++;
        } else {
            return ++count;
        }
        if (second.toString().length() < length) {
            count++;
        } else {
            return ++count;
        }

        BigInteger next;
        while (true) {
            next = first.add(second);
            first = second;
            second = next;
            count++;

//            System.out.println("count : " + count  + " next : " + next.toString());
            if (next.toString().length() >= length) {
                System.out.println("count : " + count  + " next : " + next.toString());
                break;
            }
        }
        return count;
    }
}
