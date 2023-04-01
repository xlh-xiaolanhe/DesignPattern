/**
 * @Package PACKAGE_NAME
 * @author xiaolanhe
 * @date 2023/3/31 9:50
 * @version V1.0
 */

import java.util.ArrayList;
import java.util.List;

/**
 *@author: xiaolanhe
 *@createDate: 2023/3/31 9:50
 */
public class IDCardFactory extends Factory{

    private List owners = new ArrayList<>();
    @Override
    public Product createProduct(String name) {
        return new IDcard(name);
    }

    @Override
    public void registerProduct(Product p) {
        owners.add(((IDcard) p).getOwner());
    }

    public List getOwners(){
        return owners;
    }
}
