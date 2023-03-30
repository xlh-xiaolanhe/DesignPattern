/**
 * @author xiaolanhe
 * @version V1.0
 * @Package PACKAGE_NAME
 * @date 2023/3/30 19:25
 */
public abstract class AbstractDisplay {
    public abstract void open();
    public abstract void print();
    public abstract void close();
    public final void display(){
        open();
        for(int i = 0; i < 5; i++){
            print();
        }
        close();
    }
}
