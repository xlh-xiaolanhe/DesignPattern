/**
 * @Package PACKAGE_NAME
 * @author xiaolanhe
 * @date 2023/3/29 15:16
 * @version V1.0
 */

/**
 *@author: xiaolanhe
 *@createDate: 2023/3/29 15:16
 */
public class BookShelfIterator implements Iterator{
    private BookShelf bookShelf;
    private int index;

    public BookShelfIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < bookShelf.getLength() ? true : false;
    }

    @Override
    public Object next() {
        return bookShelf.getBook(index++);
    }
}
