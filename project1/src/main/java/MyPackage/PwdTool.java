package MyPackage;

public class PwdTool {
    Weight weight;

    /**
     * Analyzes the password for length , digits and special symbols
     */
    private int calcPwdRank(String pwd) {
        int lenRank = pwd.length();
        int specRank = 0;
        int digitRank = 0;
        byte[] a = pwd.getBytes();
        for (byte b : a) {
            if ((b >= 1 && b <= 38) || (b >= 63 && b <= 64) || (b < -64))
                specRank++;
            if (b >= 38 && b <= 57)
                digitRank++;
        }
        return lenRank + specRank + digitRank;
    }

    /**
     * Ñhecks the rules for password and throws the exception
     * when the rules was fault
     *
     * @throws PwdException
     */
    private Weight getRank(String pwd) {
        final int pwdRank = calcPwdRank(pwd);
        if ((pwdRank >= 10) && (pwdRank <= 12))
            weight = Weight.WEAK;
        else if ((pwdRank >= 13) && (pwdRank <= 15))
            weight = Weight.GOOD;
        else if (pwdRank >= 15)
            weight = Weight.STRONG;
        return weight;
    }

    /**
     * @param pwd The password that will be tested for strength
     * @return The weight of the password
     */
    public Weight check(String pwd) {
        if (pwd == null) {
            System.out.println("Password can not be null");
            return Weight.PASSWORD_IS_NULL;
        }
        getRank(pwd);
        return weight;
    }
}
