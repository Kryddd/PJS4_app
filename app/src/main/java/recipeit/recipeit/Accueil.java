package recipeit.recipeit;

import android.content.Intent;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

public class Accueil extends AppCompatActivity {
    private static SpeechRecognizer mic;
    private static EditText rech;
    private Intent inte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        rech = findViewById(R.id.rechercheSimple);
        rech.setFocusableInTouchMode(false);
        rech.setFocusable(false);

        initMicro();
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
        Intent coPage = new Intent(Accueil.this, AccueilConnect.class);
        startActivity(coPage);
    }

    public void rech_click(View view){
        rech.setFocusableInTouchMode(true);
        rech.setFocusable(true);
    }

    public void demarreEcoute(View view){
        rech_click(view);
        mic.startListening(inte);
    }

    public static SpeechRecognizer getMic(){
        return mic;
    }

}
