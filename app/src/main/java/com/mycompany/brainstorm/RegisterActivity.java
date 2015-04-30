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

import java.util.HashMap;
import java.util.Map;


public class RegisterActivity extends ActionBarActivity {

    Button btnReg;
    EditText txtUser, txtEmail, txtPassword, txtPhone;
    public static Map<String, User> users = new HashMap<String, User>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registeration_page);
        btnReg = (Button)findViewById(R.id.btnRegisterReg);
        txtUser = (EditText) findViewById(R.id.txtUserNameReg);
        txtEmail = (EditText) findViewById(R.id.txtEmailReg);
        txtPassword = (EditText) findViewById(R.id.txtPassReg);
        txtPhone = (EditText) findViewById(R.id.txtPhoneReg);
        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUser(txtUser.getText().toString(), txtEmail.getText().toString(),
                        txtPassword.getText().toString(), Integer.parseInt(txtPhone.getText().toString()));
                Intent i = new Intent(RegisterActivity.this, LoginActivity.class );
                startActivity(i);
            }
        });
    }

    public void addUser(String name, String email, String password, int phone) {
        if(users.containsValue(name)) {
            Toast.makeText(getApplicationContext(), "username " + name + " already exists, please choose another.",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        User curr = new User(password, name, email, phone);
        users.put(name, curr);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register, menu);
        return true;
    }

    public static Map<String, User> getUsers(){
        return users;
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
