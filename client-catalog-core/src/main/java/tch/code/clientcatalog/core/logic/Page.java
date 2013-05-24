/*
 */
package tch.code.clientcatalog.core.logic;

import java.util.List;

/**
 *
 * @author tch
 */
public class Page<T> {
    private int pageIndex = 0;
    private List<T> pageContent = null;

    public Page(int pageIndex, List<T> pageContent) {
        this.pageIndex = pageIndex;
        this.pageContent = pageContent;
    }

    public List<T> getPageContent() {
        return pageContent;
    }

    public int getPageIndex() {
        return pageIndex;
    }
    
}
