package apk.win.first.bankapl;

import java.io.IOException;

public class CallbackClass {

    interface Callback {

        Model callingBack() throws InterruptedException;
        ModelTwo callingBackModelTwo() throws IOException, InterruptedException;
        ModelTwo callingBackGeoData(String string, String stringTwo) throws IOException, InterruptedException;

        void callingBackSecondFr(Organization organization,Model model);
        void callingBackPhoneFr(String string);
        void callingBackButton();
        void callingBackWebFr(String string);
        void callingBackMapFr();
        void shareFragm();
        void dataToShareFr(Organization organization);

    }

    public Callback callback;

    public void registerCallBack(Callback callback){
        this.callback = callback;
    }

    void sentObjectToSecondFr(Organization organization, Model model){
        callback.callingBackSecondFr(organization, model);
    }

    void sentDataToFragmentPhone(String sampleString){
        callback.callingBackPhoneFr(sampleString);
    }

    void sentCallingBackMapFr(){
        callback.callingBackMapFr();
    }

    ModelTwo sentDataFromModelTwo(String string, String stringTwo) throws IOException, InterruptedException {
      return callback.callingBackGeoData(string,stringTwo);
    }

    void sendDataToShareFrFromSecondFra(Organization organization){
        callback.dataToShareFr(organization);
    }

    void sentLinkToWebFr(String string){
        callback.callingBackWebFr(string);
    }

    Model loadObjectsList() throws InterruptedException {
        return callback.callingBack();
    }

    ModelTwo loadModelTwoObject() throws IOException, InterruptedException {
        return callback.callingBackModelTwo();
    }

    void shareFragback(){
        callback.shareFragm();
    }

    void buttonBack(){
        callback.callingBackButton();
    }

}
