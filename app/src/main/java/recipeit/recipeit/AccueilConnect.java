package recipeit.recipeit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AccueilConnect extends AppCompatActivity {
    private static EditText rech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil_connect);

        rech = findViewById(R.id.rechercheSimple);
        rech.setFocusableInTouchMode(false);
        rech.setFocusable(false);

    }

    public void rech_click(View view){
        rech.setFocusableInTouchMode(true);
        rech.setFocusable(true);
    }


    public void connexion(View view){
        Intent coPage = new Intent(AccueilConnect.this, Accueil.class);
        startActivity(coPage);
    }
}
