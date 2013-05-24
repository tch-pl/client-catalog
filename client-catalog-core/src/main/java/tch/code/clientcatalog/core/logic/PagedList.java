/*
 */
package tch.code.clientcatalog.core.logic;

import java.util.*;
import tch.code.clientcatalog.core.service.data.model.ClientDTO;

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
        int currentOffset = currentIndex + pageCapacity;

        int pageIndex = 0;

        while (isMoreThanOnePage(currentOffset, size + 1)) {
            // put page content
            pagedClients.put(pageIndex, Arrays.asList(givenCollection.toArray()).subList(currentIndex, currentOffset));

            // calculte offsets
            currentIndex += currentOffset;
            pageIndex++;
            if (isMoreThanOnePage(currentOffset, size)) {
                currentOffset = currentIndex + pageCapacity;
            } else {
                currentOffset = currentIndex + (size - currentOffset);
            }
        }
        return pagedClients;
    }
    
    public List<Page> pages(int pageCapacity) {
        List<Page> pages = new ArrayList<Page>();
               

        int size = givenCollection.size();
        int currentIndex = 0;
        int currentOffset = currentIndex + pageCapacity;

        int pageIndex = 0;

        while (isMoreThanOnePage(currentOffset, size + 1)) {
            // put page content
            pages.add(new Page(pageIndex, Arrays.asList(givenCollection.toArray()).subList(currentIndex, currentOffset)));

            // calculte offsets
            currentIndex += currentOffset;
            pageIndex++;
            if (isMoreThanOnePage(currentOffset, size)) {
                currentOffset = currentIndex + pageCapacity;
            } else {
                currentOffset = currentIndex + (size - currentOffset);
            }
        }
        return pages;
    }

    private boolean isMoreThanOnePage(int offset, int size) {
        return size - offset > 0 ? true : false;
    }
}
