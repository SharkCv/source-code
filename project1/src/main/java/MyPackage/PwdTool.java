package MyPackage;

public class PwdTool {
    private String pass;
    private int specRank;
    private int digitRank;
    private int lenRank;
    private Weight weight;

    /**
     * Ñhecks the rules for password and throws the exception
     * when the rules was fault
     *
     * @throws PwdException
     */
    private void checkRules(){
        final int pwdRank = lenRank + digitRank + specRank;
        if ((pwdRank >= 10) && (pwdRank <= 12))
            weight = Weight.WEAK;
        else if ((pwdRank >= 13) && (pwdRank <= 15))
            weight = Weight.GOOD;
        else if (pwdRank >= 15)
            weight = Weight.STRONG;
    }

    /**
     * @param pwd The password that will be tested for strength
     * @return The weight of the password
     */
    public Weight check(String pwd){
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
