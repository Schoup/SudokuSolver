package logic.human.domain;

import logic.human.domain.Structure;

import java.util.List;

public class StructureOverview {
    private List<Structure> listRows;
    private List<Structure> listCols;
    private List<Structure> listBlocs;

    public List<Structure> getListRows() {
        return listRows;
    }

    public void setListRows(List<Structure> listRows) {
        this.listRows = listRows;
    }

    public List<Structure> getListCols() {
        return listCols;
    }

    public void setListCols(List<Structure> listCols) {
        this.listCols = listCols;
    }

    public List<Structure> getListBlocs() {
        return listBlocs;
    }

    public void setListBlocs(List<Structure> listBlocs) {
        this.listBlocs = listBlocs;
    }
}
