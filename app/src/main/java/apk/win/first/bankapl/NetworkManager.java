package apk.win.first.bankapl;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkManager {

    public final String URL = "http://resources.finance.ua/ru/public/";
    //public final String URL = "http://resources.finance.ua/ru/public/currency-cash.json";

    public final String URLTWOO = "https://maps.googleapis.com/maps/api/place/findplacefromtext/";
    // public final String URL = https://maps.googleapis.com/maps/api/place/findplacefromtext/json?input=Киев%20ул.%20Тарасовская,%2019&inputtype=textquery&fields=photos,formatted_address,name,rating,opening_hours,geometry&key=AIzaSyBtWKe-Lw4d7IyAD0Z5fJb6MC6v3o8jLSc;

    public Thread loadObjectThread;
    public Thread loadObjectThreadTwo;

    public Call<Model> idsCall;
    public Call<ModelTwo> idsCallTwo;

    public Model model;
    public ModelTwo modelTwo;

    String stringOne, stringTwo;

    public void loadNetworkModelTwo(String s, String sTwoo) throws IOException, InterruptedException {
        if (s.equals("7oiylpmiow8iy1smadm"))
            stringOne = "Днепр";
        else if (s.equals("7oiylpmiow8iy1smadn"))
            stringOne = "Запорожье";
        else if (s.equals("7oiylpmiow8iy1smadi"))
            stringOne = "Киев";
        else if (s.equals("7oiylpmiow8iy1smadr"))
            stringOne = "Львов";
        else if (s.equals("7oiylpmiow8iy1smadk"))
            stringOne = "Одесса";
        else if (s.equals("7oiylpmiow8iy1smadx"))
            stringOne = "Полтава";
        else if (s.equals("7oiylpmiow8iy1smadp"))
            stringOne = "Ужгород";
        else if (s.equals("7oiylpmiow8iy1smadj"))
            stringOne = "Харьков";
        else if (s.equals("7oiylpmiow8iy1smaec"))
            stringOne = "Чернигов";

        stringTwo = sTwoo;
        getCoordinatesFromMapGoogle();
    }

    public void loadNetworkModel(){
        try {
            getIDSFromWeb();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void loadModelTwoNetwork() throws IOException, InterruptedException {
        getCoordinatesFromMapGoogle();
    }

    public void getIDSFromWeb() throws InterruptedException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ModelApi idsApi = retrofit.create(ModelApi.class);

        idsCall = idsApi.message();
                //idsApi.idsInfo("currency-cash.json");

        loadObjectThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    model = idsCall.execute().body();
                    System.out.println("Look: ");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        loadObjectThread.start();
        loadObjectThread.join();
    }

    public void getCoordinatesFromMapGoogle() throws IOException, InterruptedException {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URLTWOO)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ModelApi idsApi = retrofit.create(ModelApi.class);
        //String string = "Киев"+" "+"ул. Тарасовская, 19";
        String string_ = stringOne +" "+ stringTwo;


        idsCallTwo = idsApi.getNameStreetToCoordinates(string_);

        loadObjectThreadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    modelTwo = idsCallTwo.execute().body();
                    System.out.println("Look: ");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        loadObjectThreadTwo.start();
        loadObjectThreadTwo.join();


    }
}
