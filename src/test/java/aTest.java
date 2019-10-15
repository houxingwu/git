import com.hou.CxProcessEnum;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * @Description test
 * @Author houxingwu
 * @Date 2019-09-23 12:54
 * @Version 1.0
 */
public class aTest {
    private Object CxProcessEnum2;
   /* @Test
    public static void main(String[] args) {
        System.out.println("ddd");
    }*/

    @Test
    public void aa(){
        /*com.hou.CxProcessEnum[] values = com.hou.CxProcessEnum.values();
        for (com.hou.CxProcessEnum value : values) {
            System.out.println(value);
        }*/

        CxProcessEnum[] II= (CxProcessEnum[]) CxProcessEnum2;
        System.out.println(II);
        String processId = CxProcessEnum.LDLCQZ.getProcessId();
        System.out.println(processId);

        String description = CxProcessEnum.LDLCQZ.getDescription();
        System.out.println(description);
        /* String cx_zcxp = com.hou.CxProcessEnum.getDescription("CX_ZCXP");*/
    }

    @Test
    public void splitTest() throws UnsupportedEncodingException {
        String a = "abc#defg";
        byte[] bytes = a.getBytes("UTF-8");

        int length = a.getBytes("UTF-8").length;
        System.out.println(length);
        String[] split = a.split("#", 11);

        for (String s : split) {
            System.out.println(s+"###");
        }
    }
}
