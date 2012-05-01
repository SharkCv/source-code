package MyPackage; /**
 * Created by IntelliJ IDEA.
 * User: XpR_Project
 * Date: 07.04.2012
 * Time: 22:56:04
 * To change this template use File | Settings | File Templates.
 */

public class test {
    public static void main(String args[]){
        PwdTool s = new PwdTool();
        try{
            System.out.println(PwdTool.check("woohoo12#$"));
        }catch(Exception ex){System.out.println(ex.getMessage());}
    }
}
