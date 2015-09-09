package fr.lusson.bousole.vue;

import java.text.NumberFormat;
import java.text.ParseException;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.widget.EditText;

public class BoussoleActivity extends Activity {
	// vue du
	//private BousoleView bousoleView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_boussole);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.boussole, menu);


		// Gestion pour la modification de la boussole
		// Gestion des evenements sur le editbox		;
		// Gestion de l'evenement sur l'altitude
		EditText etAltitude = (EditText) findViewById(R.id.etAltitude);
		etAltitude.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable s) {
				EditText etAltitude;
				etAltitude = (EditText)findViewById(R.id.etAltitude);
				etAltitude.getText();//setText(String.valueOf(Math.sin(Math.toRadians(45))));
				if (!etAltitude.getText().toString().isEmpty())
				{
					//Initialisation du convertisseur en float
					NumberFormat monFormatteurDeNombre = NumberFormat.getInstance();
					try {
						setfAltitude(monFormatteurDeNombre.parse(etAltitude.getText().toString()).floatValue());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}

			public void onTextChanged(CharSequence s, int start, int before,
					int count) {

			}
		});
		// Gestion de l'evenement sur le temps
		EditText etChrono = (EditText) findViewById(R.id.etChrono);
		etChrono.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable s) {
				EditText etChrono;
				etChrono = (EditText)findViewById(R.id.etChrono);
				etChrono.getText();//setText(String.valueOf(Math.sin(Math.toRadians(45))));
				if (!etChrono.getText().toString().isEmpty())
				{
					//Initialisation du convertisseur en float
					NumberFormat monFormatteurDeNombre = NumberFormat.getInstance();
					try {
						setfChrono(monFormatteurDeNombre.parse(etChrono.getText().toString()).floatValue());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}			
			}

			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}

			public void onTextChanged(CharSequence s, int start, int before,
					int count) {

			}
		});
		// Gestion de l'evenement sur le cap
		EditText etCap = (EditText) findViewById(R.id.etCap);
		etCap.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable s) {
				EditText etCap;
				etCap = (EditText)findViewById(R.id.etCap);
				etCap.getText();//setText(String.valueOf(Math.sin(Math.toRadians(45))));
				if (!etCap.getText().toString().isEmpty())
				{
					//Initialisation du convertisseur en float
					NumberFormat monFormatteurDeNombre = NumberFormat.getInstance();
					try {
						setfCap(monFormatteurDeNombre.parse(etCap.getText().toString()).floatValue());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}

			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}

			public void onTextChanged(CharSequence s, int start, int before,
					int count) {

			}

		});
		// Gestion de l'evenement sur la derive de cap
		EditText etDeriveCap = (EditText) findViewById(R.id.etEcartLateral);
		etDeriveCap.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable s) {
				EditText etEcartLateral;
				etEcartLateral = (EditText)findViewById(R.id.etEcartLateral);
				etEcartLateral.getText();//setText(String.valueOf(Math.sin(Math.toRadians(45))));
				if (!etEcartLateral.getText().toString().isEmpty())
				{
					//Initialisation du convertisseur en float
					NumberFormat monFormatteurDeNombre = NumberFormat.getInstance();
					try {
						setfEcartLateral(monFormatteurDeNombre.parse(etEcartLateral.getText().toString()).floatValue());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}

			public void onTextChanged(CharSequence s, int start, int before,
					int count) {

			}

		});
		// Gestion de l'evenement sur du plan vol
		EditText etRoute = (EditText) findViewById(R.id.etRoute);
		etRoute.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable s) {
				EditText etRoute;
				etRoute = (EditText)findViewById(R.id.etRoute);
				etRoute.getText();//setText(String.valueOf(Math.sin(Math.toRadians(45))));
				if (!etRoute.getText().toString().isEmpty())
					setiRoute(Integer.parseInt(etRoute.getText().toString()));
			}

			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}

			public void onTextChanged(CharSequence s, int start, int before,
					int count) {

			}
		});
		return true;
	}
	public void setfAltitude(float fAltitude) {
		//bousoleView.invalidate();
		BousoleView bv = (BousoleView)this.findViewById(R.id.BoussoleView);
		bv.setfAltitude(fAltitude);
		//bv.requestLayout();
	}
	public void setfChrono(float fChrono) {
		BousoleView bv = (BousoleView)this.findViewById(R.id.BoussoleView);
		bv.setfChrono(fChrono);
		//bv.requestLayout();
	}
	public void setfCap(float fCap) {
		BousoleView bv = (BousoleView)this.findViewById(R.id.BoussoleView);
		bv.setfCap(fCap);
		//bv.requestLayout();
	}
	public void setfEcartLateral(float f) {
		BousoleView bv = (BousoleView)this.findViewById(R.id.BoussoleView);
		bv.setfEcartLateral(f);
		//bv.requestLayout();
	}
	public void setiRoute(int iRoute) {
		BousoleView bv = (BousoleView)this.findViewById(R.id.BoussoleView);
		bv.setRoute(iRoute);
		//bv.requestLayout();
	}
}
