package recipeit.recipeit;

import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.SpeechRecognizer;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Elena on 02/02/2018.
 */

public class VoiceListener implements RecognitionListener {
    public void onReadyForSpeech(Bundle params) {}
    public void onBeginningOfSpeech() {}
    public void onRmsChanged(float rmsdB) {}
    public void onBufferReceived(byte[] buffer) {}
    public void onEndOfSpeech() {
        //Log.d(TAG, "onEndOfSpeech");
    }
    public void onError(int error) {
        //Log.v(TAG, "error " + error);
    }
    public void onResults(Bundle results) {
        //Log.v(TAG, "onResults " + results);
        String data = results.get(SpeechRecognizer.RESULTS_RECOGNITION).toString();

        Accueil.getMic().stopListening();
        Accueil.getRech().setText(data);
    }
    public void onPartialResults(Bundle partialResults) {}
    public void onEvent(int eventType, Bundle params) {}
}
