
/**
 *@author: xiaolanhe
 *@createDate: 2023/3/31 9:46
 */
public abstract class Factory {

    public Product create(String owner){
        Product p = createProduct(owner);
        registerProduct(p);
        return p;
    }

    public abstract Product createProduct(String name);

    public abstract void registerProduct(Product p);
}
