/*
 */
package tch.code.clientcatalog.core.logic;

import java.util.*;

/**
 *
 * @author tch
 */
public class PagedList<T> {

    private Collection<T> givenCollection;

    public PagedList(Collection<T> givenCollection) {
        this.givenCollection = givenCollection;
    }

    public Map<Integer, List> pageAsMap(int pageCapacity) {
        Map<Integer, List> pagedClients = new HashMap<Integer, List>();

        int size = givenCollection.size();
        int currentIndex = 0;
        int currentOffset = size > pageCapacity ? currentIndex + pageCapacity : size;

        int pageIndex = 0;
        if (size > 0) {
            do {

                // put page content
                pagedClients.put(pageIndex, Arrays.asList(givenCollection.toArray()).subList(currentIndex, currentOffset));
                // calculte offsets
                
                currentIndex += pageCapacity;
                if (isMorePages(currentOffset, size)) {
                    currentOffset = currentIndex + pageCapacity;
                } else {
                    currentOffset = currentIndex + size;
                }
                pageIndex++;
            } while (isMorePages(currentOffset, size));
        }

        return pagedClients;
    }

    public List<Page> pages(int pageCapacity) {
        List<Page> pages = new ArrayList<Page>();
        Map<Integer, List> paged = this.pageAsMap(pageCapacity);
        for (Integer index : paged.keySet()) {
            pages.add(new Page(index, paged.get(index)));
        }
        return pages;
    }

    private boolean isMorePages(int offset, int size) {
        return size - offset >= 0 ? true : false;
    }
}
