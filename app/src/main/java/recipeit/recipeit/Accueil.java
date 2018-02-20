package recipeit.recipeit;

import android.content.Intent;
import android.net.Uri;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class Accueil extends AppCompatActivity implements accueilFRG.OnFragmentInteractionListener, rechAvancee.OnFragmentInteractionListener, voyage.OnFragmentInteractionListener {
    private static SpeechRecognizer mic;
    private static EditText rech;
    private Intent inte;
    private boolean connected;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        this.connected = false; // à supprimer plus tard, on récuperera ce booleen après la co

        super.onCreate(savedInstanceState);

        setLayout();

        rech = findViewById(R.id.rechercheSimple);
        rech.setFocusableInTouchMode(false);
        rech.setFocusable(false);

        initMicro();

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        accueilFRG fragment = new accueilFRG();
        fragmentTransaction.replace(R.id.contain_fragment, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void setLayout() {
        if(connected) {
            setContentView(R.layout.activity_accueil_connect);
        }
        else {
            setContentView(R.layout.activity_accueil);
        }
    }

    public static EditText getRech(){
        return rech;
    }

    public void initMicro(){
        mic = SpeechRecognizer.createSpeechRecognizer(Accueil.this);
        mic.setRecognitionListener(new VoiceListener());
        inte = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        inte.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        inte.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "FR");
        inte.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, this.getPackageName());
        inte.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 1);
    }
    public void connexion(View view){
        Intent coPage = new Intent(Accueil.this, Connexion.class);
        startActivity(coPage);
    }

    public void rech_click(View view){
        rech.setFocusableInTouchMode(true);
        rech.setFocusable(true);
    }

    public void accueilClick(View view){
        accueilFRG fragment = new accueilFRG();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.contain_fragment, fragment);
        fragmentTransaction.commit();

        ImageView img = findViewById(R.id.home);
        img.setImageResource(R.drawable.homeactive);

        img = findViewById(R.id.recherche);
        img.setImageResource(R.drawable.more);

        img = findViewById(R.id.voyage);
        img.setImageResource(R.drawable.world);
    }

    public void rechAvClick(View view) {
        rechAvancee fragment = new rechAvancee();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.contain_fragment, fragment);
        fragmentTransaction.commit();

        ImageView img = findViewById(R.id.recherche);
        img.setImageResource(R.drawable.moreactive);

        img = findViewById(R.id.voyage);
        img.setImageResource(R.drawable.world);

        img = findViewById(R.id.home);
        img.setImageResource(R.drawable.home);
    }

    public void worldClick(View view) {
        voyage fragment = new voyage();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.contain_fragment, fragment);
        fragmentTransaction.commit();

        ImageView img = findViewById(R.id.voyage);
        img.setImageResource(R.drawable.woldactive);

        img = findViewById(R.id.recherche);
        img.setImageResource(R.drawable.more);

        img = findViewById(R.id.home);
        img.setImageResource(R.drawable.home);
    }

    public void homeClick(View view) {

    }

    public void fridgeClick(View view) {

    }

    public void ajouterClick(View view) {

    }

    //reconnaissance vocale
    public void demarreEcoute(View view){
        rech_click(view);
        mic.startListening(inte);
    }

    public static SpeechRecognizer getMic(){
        return mic;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
