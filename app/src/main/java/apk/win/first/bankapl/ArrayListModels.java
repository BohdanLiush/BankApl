package apk.win.first.bankapl;

import java.util.ArrayList;

public class ArrayListModels {

    public void setListModel(ArrayList<ModelCurrenciesBasic> listModel) {
        this.listModel = listModel;
    }

    ArrayList<ModelCurrenciesBasic> listModel;

    public ArrayList<ModelCurrenciesBasic> getListModel() {
        return listModel;
    }

    public ArrayListModels(ArrayList<ModelCurrenciesBasic> listModels) {
        this.listModel = listModels;
    }

}
