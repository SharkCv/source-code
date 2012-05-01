package MyPackage;

public class PwdTool {
    private static int count = 0;
    private final int id = count++;
    static String pass = null;
    int specRank = 0,upperRank = 0,digitRank = 0;
    static int lenRank = 0;
    private String weight = null;
    /**
     * Ñhecks the rules for password and throws the exception
     * when the rules was fault
     * @throws PwdException
     */
    private void checkRules()throws PwdException{
        final int pwdRank = lenRank + digitRank + specRank;
        if(lenRank < 6){
            throw new PwdException("Password too short");
        }
        else
            if(digitRank < 2){
                throw new PwdException("Password must have at least 2 digit");
            }
        else
                if(specRank < 2){
                    throw new PwdException("Password must have at least 2 special symbol");
                }
        else
                    if((pwdRank >= 10) && (pwdRank <= 12))
                        weight = "Weak";
        else
                        if((pwdRank > 13) && (pwdRank <= 15))
                            weight = "Strong";
        else
                            if(pwdRank >= 15)
                                weight = "Very strong";
    }
    /**
     * @param pwd The password that will be tested for strength
     * @return The weight of the password
     * @throws PwdException
     * */
    public static String check(String pwd) throws PwdException{
        pass = pwd;
        lenRank = pwd.length();
        PwdTool pt = new PwdTool();
        pt.process();
        pt.checkRules();
        System.out.println("Success");
        return pt.weight;
    }
    /**
     * Analyzes the password for length , digits and special symbols
     * */
    private void process(){
        try{
            byte[] a = pass.getBytes("ascii");
            for(byte b:a){
                if((b>=1 && b<=38) || (b>=63 && b<=64))
                    specRank++;
                if(b >= 38 && b <= 57)
                    digitRank++;
            }
        }catch(Exception ex){ex.printStackTrace();}
    }
}
