package com.teknokrat.mobile2019.if17fx.a16312309.gambarin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Pengambilan data, apakah ada yang login.
        final FirebaseAuth auth = FirebaseAuth.getInstance();
        final FirebaseUser user = auth.getCurrentUser();
        //Pengecekan, jika tidak ada login. Di arahkan ke Login activity.
        if (user == null) {
            startActivity(new Intent(MainActivity.this, Login.class));
            finish();
        }
        View logout = findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Logout user dan alihkan ke form login.
                auth.signOut();
                startActivity(new Intent(MainActivity.this, Login.class));
                finish();
            }
        });
        //
    }
}
