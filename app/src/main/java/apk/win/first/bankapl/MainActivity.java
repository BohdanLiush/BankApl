package apk.win.first.bankapl;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.*;
//import com.mysql.fabric.jdbc.FabricMySQLDriver;
import java.sql.Driver;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

public class MainActivity extends AppCompatActivity implements Serializable, CallbackClass.Callback {

    NetworkManager networkManager = new NetworkManager();
    Fragment fragment = new Fragment();
    SecondFragment secondFragment = new SecondFragment();
    FragmentWeb fragmentWeb = new FragmentWeb();
    MapFragment mapFragment = new MapFragment();
    FragmentCall fragmentCall = new FragmentCall();
    ShareFragment shareFragment = new ShareFragment();

    private static final String URL = "jdbc:mysql://localhost:3306/mydbtesttwoo";
    //private static final String URL = "jdbc:mysql://192.168.0.192:3306/mydbtesttwoo";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFragment();
        Connection connection;
        {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
               // Driver driver = new FabricMySQLDriver();
                //DriverManager.registerDriver(driver);
                connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
                if (!connection.isClosed()){
                    System.out.println("connection with database is fine");
                    connection.close();
                    if (connection.isClosed())
                        System.out.println("connection with database is closed");
                }
            } catch (SQLException e) {
                System.err.println("There is no posobility to load class driver");
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
    }

    private void loadFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout, fragment).commit();
    }

    @Override
    public Model callingBack() throws InterruptedException {
        networkManager.loadNetworkModel();
        return networkManager.model;
    }

    @Override
    public ModelTwo callingBackModelTwo() throws IOException, InterruptedException {
        networkManager.loadModelTwoNetwork();
        return networkManager.modelTwo;
    }

    @Override
    public ModelTwo callingBackGeoData(String string, String stringTwo) throws IOException, InterruptedException {
        networkManager.loadNetworkModelTwo(string,stringTwo);

        Bundle arguments = new Bundle();
        arguments.putSerializable("modelTwo", networkManager.modelTwo);
        mapFragment.setArguments(arguments);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout, mapFragment).addToBackStack("home").commit();

        return networkManager.modelTwo;
    }

    @Override
    public void callingBackSecondFr(Organization organization, Model model) {
        Bundle arguments = new Bundle();
        arguments.putSerializable("organizationObject", organization);
        arguments.putSerializable("currencies", model);
        secondFragment.setArguments(arguments);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout, secondFragment).addToBackStack("home").commit();
    }

    @Override
    public void callingBackPhoneFr(String string) {
        Bundle arguments = new Bundle();
        arguments.putSerializable("phoneString", string);
        fragmentCall.setArguments(arguments);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout, fragmentCall).addToBackStack("home").commit();
    }

    @Override
    public void callingBackButton() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void callingBackWebFr(String string) {
        Bundle arguments = new Bundle();
        arguments.putSerializable("link", string);
        fragmentWeb.setArguments(arguments);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout, fragmentWeb).addToBackStack("home").commit();
    }

    @Override
    public void callingBackMapFr() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout, mapFragment).addToBackStack("home").commit();
    }

    @Override
    public void shareFragm() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout, shareFragment).addToBackStack("home").commit();
    }

    @Override
    public void dataToShareFr(Organization organization) {
        Bundle arguments = new Bundle();
        arguments.putSerializable("organizationObject", organization);
        shareFragment.setArguments(arguments);
    }
}
