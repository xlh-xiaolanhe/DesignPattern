/**
 * @Package PACKAGE_NAME
 * @author xiaolanhe
 * @date 2023/3/30 11:11
 * @version V1.0
 */

/**
 *@author: xiaolanhe
 *@createDate: 2023/3/30 11:11
 */

/* 实际需要使用此类的功能 */
public class Banner {
    private String string;
    public Banner(String string) {
        this.string = string;
    }
    public void showWithParen() {
        System.out.println("(" + string + ")");
    }
    public void showWithAster() {
        System.out.println("*" + string + "*");
    }
}
