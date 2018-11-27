package d;

public class Util {

    public static String constructPassword(char[] password) {
        StringBuilder result = new StringBuilder();
        for (char c : password) {
            result.append(c);
        }
        return result.toString();
    }

    public static String validatePassword(String pw, String rpw) {

        if(pw == null || pw.equals("")) return "Password cannot be empty";
        if(!pw.equals(rpw)) return "Passwords do not match";
        if(pw.length() < 8) return "Must be at least 8 chars";
        if(pw.length() > 14) return "Must be at most 14 chars";
        if(!pw.matches(".*\\d+.*")) return "Must contain a number";
        if(!pw.matches(".*[a-z].*")) return "Must contain a lower case letter";
        if(!pw.matches("(.*[A-Z]).*")) return "Must contain an upper case letter";
        if(pw.contains("#")) return "Cannot contain #";

        return "OK";
    }
}
