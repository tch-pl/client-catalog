/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package tch.code.clientcatalog.core.logic;





/**
 * Convenient base class for sortable lists. JSF Managed Beans can extend this class (if sortable option is needed)
 * @author wrz
 * @version $Revision: 1.2.38.1 $ $Date: 2009-06-29 11:53:47 $
 */
public abstract class SortableList
{
    private String sortParam;
    private boolean ascendingFlag;

    protected SortableList(String defaultSortColumn)
    {
        sortParam = defaultSortColumn;
        ascendingFlag = isDefaultAscending(defaultSortColumn);
    }

    /**
     * Sort the list.
     */
    protected abstract void sort(String column, boolean ascending);

    /**
     * Is the default sort direction for the given column "ascending" ?
     */
    protected abstract boolean isDefaultAscending(String sortColumn);


    public void sort(String sortColumn)
    {
        if (sortColumn == null)
        {
            throw new IllegalArgumentException("Argument sortColumn must not be null.");
        }

        if (sortParam.equals(sortColumn))
        {
            //current sort equals new sortColumn -> reverse sort order
            ascendingFlag = !ascendingFlag;
        }
        else
        {
            //sort new column in default direction
            sortParam = sortColumn;
            ascendingFlag = isDefaultAscending(sortParam);
        }

        sort(sortParam, ascendingFlag);
    }

    public String getSort()
    {
        return sortParam;
    }

    public void setSort(String sort)
    {
        sortParam = sort;
    }

    public boolean isAscending()
    {
        return ascendingFlag;
    }

    public void setAscending(boolean ascending)
    {
        ascendingFlag = ascending;
    }
}
