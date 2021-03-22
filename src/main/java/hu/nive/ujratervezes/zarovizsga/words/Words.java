package hu.nive.ujratervezes.zarovizsga.words;

public class Words {

    public boolean hasMoreDigits(String s) {
        int digits = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                digits++;
            }
        }
        return digits > s.length() - digits;
    }
}
