package com.example.androidproject.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidproject.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

public class LogInActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String TAG = LogInActivity.class.getSimpleName();

    private TextView registerEdit;
    private EditText mPasswordEdit;
    private EditText mEmailEdit;
    private Button mPassword;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        registerEdit = (TextView) findViewById(R.id.registerTextView);
        mEmailEdit = (EditText) findViewById(R.id.email);
        mPassword = (Button) findViewById(R.id.loginButton);
        mPasswordEdit = (EditText) findViewById(R.id.password);

        registerEdit.setOnClickListener(this);
        mAuth = FirebaseAuth.getInstance();
        mPassword.setOnClickListener(this);
        mAuthListener = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
//                    Intent intent = new Intent(LogInActivity.this, newMainActivity.class);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                    startActivity(intent);
//                    finish();
                }
            }
        };
    }

    @Override
    public void onClick(View v) {
        if (v == registerEdit) {
            Intent intent = new Intent(LogInActivity.this, SignUpActivity.class);
            startActivity(intent);
            finish();
        }
        if (v == mPassword) {
            loginWithPassword();
        }

    }

    private void loginWithPassword() {
        String email = mEmailEdit.getText().toString().trim();
        String password = mPasswordEdit.getText().toString().trim();
        if (email.equals("")) {
            mEmailEdit.setError("Please enter your email");
            return;
        }
        if (password.equals("")) {
            mPasswordEdit.setError("Password can not be blank ");
            return;
        }
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Intent intent = new Intent(LogInActivity.this,MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        finish();
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "signInWithEmail", task.getException());
                            Toast.makeText(LogInActivity.this, "You log in to Lancome paris.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
