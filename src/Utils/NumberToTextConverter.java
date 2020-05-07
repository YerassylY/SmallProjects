package Utils;

import java.math.BigDecimal;

public class NumberToTextConverter {

    private static final String[] kazOnes = {
            "",
            "бір",
            "екі",
            "үш",
            "төрт",
            "бес",
            "алты",
            "жеті",
            "сеҒіз",
            "тоғыз"
    };

    private static final String[] kazTenth = {
            "",
            "он",
            "жиырма",
            "отыз",
            "қырық",
            "елу",
            "алпыс",
            "жетпіс",
            "сексен",
            "тоқсан"
    };

    private static final String[] rusOnes = {
            "",
            "один",
            "два",
            "три",
            "четыре",
            "пять",
            "шесть",
            "семь",
            "восемь",
            "девять",
            "десять",
            "одиннадцать",
            "двенадцать",
            "тринадцать",
            "четырнадцать",
            "пятнадцать",
            "шестнадцать",
            "семнадцать",
            "восемнадцать",
            "девятнадцать"
    };

    private static final String[] rusTenth = {
            "",
            "",
            "двадцать",
            "тридцать",
            "сорок",
            "пятьдесят",
            "шестьдесят",
            "семьдесят",
            "восемьдесят",
            "девяносто"
    };

    private static String[] rusHundreds = {
            "",
            "сто",
            "двести",
            "триста",
            "четыреста",
            "пятьсот",
            "шестьсот",
            "семьсот",
            "восемьсот",
            "девятьсот"
    };

    private static final String[] englishOnes = {
            "",
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine",
            "ten",
            "eleven",
            "twelve",
            "thirteen",
            "fourteen",
            "fifteen",
            "sixteen",
            "seventeen",
            "eighteen",
            "nineteen"
    };

    private static final String[] englishTenth = {
            "",        //0
            "",        //1
            "twenty",  //2
            "thirty",  //3
            "forty",   //4
            "fifty",   //5
            "sixty",   //6
            "seventy", //7
            "eighty",  //8
            "ninety",  //9
    };

    public static void main(String argv[]) {
        Long nKaz = 4127451241621789L;
        System.out.println(convertToKaz(nKaz));

        Long nRus = 12222221131121L;
        System.out.println(convertToRus(nRus));

        Long nEng = 999999999999999L;
        System.out.println(convertToEnglish(nEng));
    }

    public static String convertToKazOld(BigDecimal number) {

        long value = number.longValue();

        String result = "";
        char[] num = number.toString().toCharArray();

        int n = num.length;
        while (n > 0) {
            switch (n) {
                case 1:
                    result += kazOnes[(int) value];
                    n--;
                    break;
                case 2:
                    result += kazTenth[(int) (value / Math.pow(10, n - 1))] + " ";
                    value %= (int) Math.pow(10, n - 1);
                    n--;
                    break;
                case 3:
                    result += kazOnes[(int) (value / Math.pow(10, n - 1))] + " жүз ";
                    value %= (int) Math.pow(10, n - 1);
                    n--;
                    break;
                case 4:
                    result += kazOnes[(int) (value / Math.pow(10, n - 1))] + " мың ";
                    value %= Math.pow(10, n - 1);
                    n--;
                    break;
                case 5:
                    result += kazTenth[(int) (value / Math.pow(10, n - 1))] + " ";
                    value %= Math.pow(10, n - 1);
                    n--;
                    break;
                case 6:
                    result += kazOnes[(int) (value / Math.pow(10, n - 1))] + " жүз ";
                    value %= Math.pow(10, n - 1);
                    n--;
                    break;
                case 7:
                    result += kazOnes[(int) (value / Math.pow(10, n - 1))] + " миллион ";
                    value %= Math.pow(10, n - 1);
                    n--;
                    break;
                case 8:
                    result += kazTenth[(int) (value / Math.pow(10, n - 1))] + " ";
                    value %= Math.pow(10, n - 1);
                    n--;
                    break;
                case 9:
                    result += kazOnes[(int) (value / Math.pow(10, n - 1))] + " жүз ";
                    value %= Math.pow(10, n - 1);
                    n--;
                    break;
                case 10:
                    result += kazOnes[(int) (value / Math.pow(10, n - 1))] + " миллиард ";
                    value %= Math.pow(10, n - 1);
                    n--;
                    break;
                case 11:
                    result += kazTenth[(int) (value / Math.pow(10, n - 1))] + " ";
                    value %= Math.pow(10, n - 1);
                    n--;
                    break;
                case 12:
                    result += kazOnes[(int) (value / Math.pow(10, n - 1))] + " жүз ";
                    value %= Math.pow(10, n - 1);
                    n--;
                    break;
            }
        }
        return result;
    }

    public static String convertToKaz(long number) {
        if (number < 10) {
            return kazOnes[(int) number];
        } else if (number < 100) {
            return kazTenth[(int) (number / 10)] + " " + convertToKaz(number % 10);
        } else if (number < 1000) {
            return convertToKaz(number / 100) + " жүз " + convertToKaz(number % 100);
        } else if (number < 1000000) {
            return convertToKaz(number / 1000) + " мың " + convertToKaz(number % 1000);
        } else if (number < 1000000000) {
            return convertToKaz(number / 1000000) + " миллион " + convertToKaz(number % 1000000);
        } else if (number < 1000000000000L) {
            return convertToKaz(number / 1000000000) + " миллиард " + convertToKaz(number % 1000000000);
        } else if (number < 1000000000000000L) {
            return convertToKaz(number / 1000000000000L) + " триллиона " + convertToKaz(number % 1000000000000L);
        } else return "Works till trillions, can be enlarged if it is required";
    }

    public static String convertToRus(long number) {
        // TODO: correct Склонение
        if (number < 20) {
            return rusOnes[(int) number];
        } else if (number < 100) {
            return rusTenth[(int) (number / 10)] + " " + convertToRus(number % 10);
        } else if (number < 1000) {
            return rusHundreds[(int) (number / 100)] + " " + convertToRus(number % 100);
        } else if (number < 1000000) {

            int thousand = (int) (number / Math.pow(10, String.valueOf(number).length() - 1));

            switch (thousand) {
                case (1):
                    return convertToRus((int) (number / 1000)) + " тысяча " + convertToRus(number % 1000);
                case (2):
                case (3):
                case (4):
                    return convertToRus((int) (number / 1000)) + " тысячи " + convertToRus(number % 1000);
                default:
                    return convertToRus((int) (number / 1000)) + " тысяч " + convertToRus(number % 1000);
            }

        } else if (number < 1000000000) {
            return convertToRus(number / 1000000) + " миллион  " + convertToRus(number % 1000000);
        } else if (number < 1000000000000L) {
            return convertToRus(number / 1000000000) + " миллиарда " + convertToRus(number % 1000000000);
        } else if (number < 1000000000000000L) {
            return convertToRus(number / 1000000000000L) + " триллиона " + convertToRus(number % 1000000000000L);
        } else return "Works till trillions, can be enlarged if it is required";
    }

    public static String convertToEnglish(long number) {
        if (number < 20) {
            return englishOnes[(int) number];
        } else if (number < 100) {
            return englishTenth[(int) (number / 10)] + "-" + convertToEnglish(number % 10);
        } else if (number < 1000) {
            return convertToEnglish(number / 100) + " hundred " + convertToEnglish(number % 100);
        } else if (number < 1000000) {
            return convertToEnglish(number / 1000) + " thousand " + convertToEnglish(number % 1000);
        } else if (number < 1000000000) {
            return convertToEnglish(number / 1000000) + " million " + convertToEnglish(number % 1000000);
        } else if (number < 1000000000000L) {
            return convertToEnglish(number / 1000000000) + " billion " + convertToEnglish(number % 1000000000);
        } else if (number < 1000000000000000L) {
            return convertToEnglish(number / 1000000000000L) + " trillion " + convertToEnglish(number % 1000000000000L);
        } else return "Works till trillions, can be enlarged if it is required";
    }
}
