package apk.win.first.bankapl;

public interface MainContract {
    interface View {
        void giveModel(Currencies_ currencies);
    }

    interface Presenter {
        void onButtonWasClicked();
    }

}
