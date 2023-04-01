
/**
 *@author: xiaolanhe
 *@createDate: 2023/4/1 10:54
 */
public class Singleton {
    private static Singleton instance = new Singleton();

    private Singleton(){}

    public static Singleton getInstance(){
        return instance;
    }
}
