package tch.code.clientcatalog.core.service.data.model;

import java.util.List;

/**
 *
 * @author tch
 */
public class CompanyData {
    private String companyName = null;
    private List<PrivatePersonData> board = null;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<PrivatePersonData> getBoard() {
        return board;
    }

    public void setBoard(List<PrivatePersonData> board) {
        this.board = board;
    }
}
