/* @UNIVESRE.COM_20170114_HYE
 * ShowProterties.java, p31. */

//import java.util.*;

public class ShowProperties{
	public static void main(String[] args){
        System.getProperties().list(System.out);
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("java.library.path"));
	}
}