package org.syed.utils;


public final class ServiceUtil {

    private ServiceUtil() {}

    public static String generatingShortCodeUrl(){
        int length = 6;

        return getAlphaNumericString(length);
    }

    public static String getAlphaNumericString(int length){
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = (int) (AlphaNumericString.length() *Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }

        return sb.toString();
    }

}
