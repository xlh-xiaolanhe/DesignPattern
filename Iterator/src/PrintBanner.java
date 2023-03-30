/**
 * @Package PACKAGE_NAME
 * @author xiaolanhe
 * @date 2023/3/30 11:12
 * @version V1.0
 */

/**
 *@author: xiaolanhe
 *@createDate: 2023/3/30 11:12
 */

/* 扮演适配器的角色 */
public class PrintBanner extends Banner implements Print{
    private Banner banner;
    public PrintBanner(String string) {
        super(string);
    }
    public void printWeak() {
        showWithParen();
    }
    public void printStrong() {
        showWithAster();
    }
}
