package academy.penan.appointmentreminderapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements MainFragment.OnItemSelectedListener, AddAppointmentFragment.OnItemSelectedListener {

    MainFragment myFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm = getSupportFragmentManager();
        myFragment = new MainFragment();

        // add
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.myContainer, myFragment);
        ft.commit();
    }

    public void onAddAppointmentSelected(Appointment appt) {
        FragmentManager fragmentManager = getSupportFragmentManager();

        myFragment.updateAppointmentList(appt);

        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.myContainer, myFragment);
        ft.commit();
    }


    public void onCancel() {
        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.myContainer, myFragment);
        ft.commit();
    }


    @Override
    public void onButtonSelected() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.myContainer, new AddAppointmentFragment());
        ft.commit();
    }

    public void onLogout(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(this, Register.class));
    }
}
