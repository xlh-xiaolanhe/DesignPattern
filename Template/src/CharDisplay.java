/**
 * @Package PACKAGE_NAME
 * @author xiaolanhe
 * @date 2023/3/30 19:32
 * @version V1.0
 */

/**
 *@author: xiaolanhe
 *@createDate: 2023/3/30 19:32
 */
public class CharDisplay extends AbstractDisplay{

    private char c;

    public CharDisplay(char c) {
        this.c = c;
    }

    @Override
    public void open() {
        System.out.print("<<");
    }

    @Override
    public void print() {
        System.out.print(c);
    }

    @Override
    public void close() {
        System.out.print(">>");
    }
}
