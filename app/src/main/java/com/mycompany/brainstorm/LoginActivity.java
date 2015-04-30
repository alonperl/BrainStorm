package com.mycompany.brainstorm;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends ActionBarActivity {

    Button btnRegistration, btnLogin;
    EditText txtUser, txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        txtUser = (EditText) findViewById(R.id.txtUserLogin);
        txtPassword = (EditText) findViewById(R.id.txtPasswordLogin);
        btnRegistration = (Button)findViewById(R.id.btnRegLogin);
        btnLogin = (Button)findViewById(R.id.btnLoginLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!RegisterActivity.getUsers().containsKey(txtUser.getText().toString()) ){
                    Toast.makeText(getApplicationContext(), "Wrong Username.", Toast.LENGTH_SHORT).show();
                }
                else if(!((User) RegisterActivity.getUsers().get(txtUser.getText().toString())).get_password().equals(txtPassword.getText().toString())){
                    Toast.makeText(getApplicationContext(), "Wrong Password.", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent i = new Intent(LoginActivity.this, MenuActivity.class);
                    startActivity(i);
                }
            }
        });

        btnRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this,RegisterActivity.class );
                startActivity(i);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
