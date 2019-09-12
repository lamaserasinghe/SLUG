package lk.uordcs.SLUG;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;



import lk.uordcs.SLUG.REST_Classes.LoginApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
    private EditText NIC;
    private CardView Login;
    public static ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        NIC=(EditText)findViewById(R.id.etNIC);
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Login=(CardView) findViewById(R.id.login);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });
    }

    private void Login() {
        String nic;
        nic = NIC.getText().toString();

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<LoginApi> call= lk.uordcs.SLUG.Login.apiInterface.Login(nic);
        call.enqueue(new Callback<LoginApi>() {
            @Override
            public void onResponse(Call<LoginApi> call, Response<LoginApi> response) {
                if (response.body().getMessage().equals("ok")) {
                    Intent i = new Intent(Login.this, MainActivity.class);
                    startActivity(i);
                    finish();

                } else if (response.body().getMessage().equals("failed")) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Authentication failed! Please try again...", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast toast = Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG);
                toast.show();
            }


        });
        NIC.setText("");

    }

}

