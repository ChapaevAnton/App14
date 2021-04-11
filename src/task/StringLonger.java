package task;

public interface StringLonger {

    String getStringLonger(String str1, String str2);

    static String getLonger(String str1, String str2) {
        if (str1.length() >= str2.length()) return str1;
        else return str2;
    }
}
