/**
 * @Package PACKAGE_NAME
 * @author xiaolanhe
 * @date 2023/3/31 9:49
 * @version V1.0
 */

/**
 *@author: xiaolanhe
 *@createDate: 2023/3/31 9:49
 */
public class IDcard extends Product{

    private String owner;

    // 在Java 中，只有同一个包中的类可以访问不带public、protected、private
    // 等修饰符的构造函数和方法。
    IDcard(String owner) {
        System.out.println("制作" + owner + "的ID卡");
        this.owner = owner;
    }

    public void use() {
        System.out.println("使用" + owner + "的ID卡");
    }

    public String getOwner() {
        return owner;
    }
}
