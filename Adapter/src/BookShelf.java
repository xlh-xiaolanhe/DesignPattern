import com.sun.glass.ui.Size;

import java.util.ArrayList;
import java.util.List;

/**
 *@author: xiaolanhe
 *@createDate: 2023/3/29 15:09
 */
public class BookShelf implements Aggregate{

    private List<Book> books;

    private int last;

    public BookShelf(int size)
    {
        books = new ArrayList<>(size);
    }

    public Book getBook(int index) {
        return books.get(index);
    }

    public void appendBook(Book book){
        books.add(book);
        last++;
    }

    public int getLength()
    {
        return last;
    }

    @Override
    public Iterator iterator() {
        return new BookShelfIterator(this);
    }
}
