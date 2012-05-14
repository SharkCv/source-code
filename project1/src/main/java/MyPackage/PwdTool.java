package MyPackage;

enum Weight {
    WEAK,
    GOOD,
    STRONG,
    PASSWORD_IS_NULL
}

public class PwdTool {
    static String pass = null;
    private int specRank = 0;
    private int digitRank = 0;
    private int lenRank = 0;
    private Weight weight = null;

    /**
     * Ñhecks the rules for password and throws the exception
     * when the rules was fault
     *
     * @throws PwdException
     */
    private void checkRules() throws PwdException {
        final int pwdRank = lenRank + digitRank + specRank;
        if (lenRank < 6) {
            throw new PwdException("Password too short");
        } else if (digitRank < 2) {
            throw new PwdException("Password must have at least 2 digit");
        } else if (specRank < 2) {
            throw new PwdException("Password must have at least 2 special symbol");
        } else if ((pwdRank >= 10) && (pwdRank <= 12))
            weight = Weight.WEAK;
        else if ((pwdRank >= 13) && (pwdRank <= 15))
            weight = Weight.GOOD;
        else if (pwdRank >= 15)
            weight = Weight.STRONG;
    }

    /**
     * @param pwd The password that will be tested for strength
     * @return The weight of the password
     * @throws PwdException
     */
    public Weight check(String pwd) throws PwdException {
        pass = pwd;
        if (pass == null) {
            System.out.println("Password can not be null");
            return Weight.PASSWORD_IS_NULL;
        }
        lenRank = pwd.length();
        process();
        checkRules();
        return weight;
    }

    /**
     * Analyzes the password for length , digits and special symbols
     */
    private void process() {
        try {
            byte[] a = pass.getBytes();
            for (byte b : a) {
                if ((b >= 1 && b <= 38) || (b >= 63 && b <= 64) || (b < -64))
                    specRank++;
                if (b >= 38 && b <= 57)
                    digitRank++;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
