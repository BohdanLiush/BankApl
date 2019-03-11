package apk.win.first.bankapl;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelCurrenciesBasic {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("ask")
    @Expose
    private String ask;

    @SerializedName("bid")
    @Expose
    private String bid;

    /*public ModelCurrenciesBasic(String string) {
        this.name = string;
    }*/

    /*public ModelCurrenciesBasic(ModelCurrenciesBasic modelCurrenciesBasic, String string) {
       this.name = string;
       this.ask = modelCurrenciesBasic.ask;
       this.bid = modelCurrenciesBasic.bid;

    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAsk() {
        return ask;
    }

    public void setAsk(String ask) {
        this.ask = ask;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }
}
