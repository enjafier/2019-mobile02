package id.ac.polinema.tebakangka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;
public class MainActivity extends AppCompatActivity {

	//  TODO: deklarasikan variabel di sini
	private EditText numberInput;
	private Button button;
	private Button reset;
	int random = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initRandomNumber();
		numberInput = findViewById(R.id.number_input);
		button = findViewById(R.id.guess_button);
		reset = findViewById(R.id.reset_button);
		// TODO: bind layout di sini
	}

	// TODO: generate angka random di sini
	private int initRandomNumber() {
		random = (int)(Math.random()*100);
		return random;
	}

	public void handleGuess(View view) {
		// TODO: Tambahkan logika untuk melakukan pengecekan angka
		int number = Integer.parseInt(String.valueOf(numberInput.getText()));
		if (number>random){
			Toast.makeText(this,"Tebakan anda terlalu besar!", Toast.LENGTH_SHORT).show();
		}else if (number<random){
			Toast.makeText(this,"Tebakan anda terlalu kecil!", Toast.LENGTH_SHORT).show();
		}else{
			Toast.makeText(this,"Tebakan anda benar!", Toast.LENGTH_SHORT) .show();
			Button btn = (Button) findViewById(R.id.guess_button);
			btn.setEnabled(false);


		}
	}

	public void handleReset(View view) {
		// TODO: Reset tampilan
		numberInput.setText("");
		initRandomNumber();
		Button btn = (Button) findViewById(R.id.guess_button);
		btn.setEnabled(true);
	}
}
