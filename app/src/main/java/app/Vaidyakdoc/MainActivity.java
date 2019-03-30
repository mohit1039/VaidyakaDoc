package app.Vaidyakdoc;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

import app.Vaidyakdoc.AccountActivity.LoginActivity;
import app.Vaidyakdoc.Common.Common;
import app.Vaidyakdoc.Model.Register;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private ImageView iv;
    DatabaseReference fdb;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        tv = findViewById(R.id.splash_tv);
        iv = findViewById(R.id.splash_iv);
        auth = FirebaseAuth.getInstance();
        fdb = FirebaseDatabase.getInstance().getReference("Register");

        if (auth.getCurrentUser()!= null){
            loadcommon();
        }
        else{
            animate();
        }


    }

    public  void  animate(){
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.splash_transition);
        tv.startAnimation(anim);
        iv.startAnimation(anim);

        final Intent i = new Intent(this, LoginActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        Thread timer = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    startActivity(i);
                    finish();
                }
            }
        };

        timer.start();
    }

    public void loadcommon(){
        fdb.child(Objects.requireNonNull(auth.getUid())).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Common.register = dataSnapshot.getValue(Register.class);
                animate();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
