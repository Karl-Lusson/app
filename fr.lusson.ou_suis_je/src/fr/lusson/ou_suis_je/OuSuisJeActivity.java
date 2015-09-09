package fr.lusson.ou_suis_je;

import java.text.SimpleDateFormat;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class OuSuisJeActivity extends Activity {
	
	// Gestion des variables pour l'orientation
	// Acceleration
	private float[] fAccelerometerValues=new float[3];
	// Magnetisme
	private float[] fMagneticFieldValues=new float[3];
	// Test du temps
	private long lSeconde=0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Permet l'acces au gestionnaire de localisation
		LocationManager locationManager;
		String svcName = Context.LOCATION_SERVICE;
		locationManager = (LocationManager)getSystemService(svcName);
		
		// Permet l'acces a la localisation selon des critere
		Criteria criteria = new Criteria();
		criteria.setAccuracy(Criteria.ACCURACY_FINE);
		criteria.setPowerRequirement(Criteria.POWER_HIGH); // Alimentation basse
		criteria.setAltitudeRequired(true);
		criteria.setBearingRequired(true);
		criteria.setSpeedRequired(true);
		criteria.setCostAllowed(true);
		String provider = locationManager.getBestProvider(criteria, true);
	
		// Permet de chercher la localisation
		Location location = locationManager.getLastKnownLocation(provider);
		
		// Mise a jour affichage
		updateWithNewLocation(location);

		// Demande l'ecoute des changement de 10 metre tous les 1 seconde
		locationManager.requestLocationUpdates(provider, 1000, 1, locationListener);
	
		// Initialisation de l'ecoute des sensors
		SensorManager sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
		
		//Initialisation de l'accelerometer
		int sensorTypeAcce = Sensor.TYPE_ACCELEROMETER;
		sensorManager.registerListener(mySensorEventListener, 
				sensorManager.getDefaultSensor(sensorTypeAcce),
				SensorManager.SENSOR_DELAY_NORMAL);//SENSOR_DELAY_NORMAL => La fréquence par default UI -> Delais affichage
		
	//Initialisation de la detection du champs magnétique
		int sensorTypeMag = Sensor.TYPE_MAGNETIC_FIELD;
		sensorManager.registerListener(mySensorEventListener, 
			sensorManager.getDefaultSensor(sensorTypeMag),
			SensorManager.SENSOR_DELAY_NORMAL);//SENSOR_DELAY_NORMAL => La fréquence par default UI -> Delais affichage
	}
	
	// Permet la mise a jour et ecoute des modifications des sensors
	private final SensorEventListener mySensorEventListener = new SensorEventListener() {
		
		@Override
		public void onSensorChanged(SensorEvent sensorEvent) 
		{
			// Test du type de sensor
			// acceleration
			if (sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
			{
				// Enregistrement des variables
				fAccelerometerValues = sensorEvent.values;

				// Acceleration du mobile
				TextView AcceLateraleV;
				AcceLateraleV = (TextView)findViewById(R.id.AcceLateraleV);
				TextView AcceLongitudinaleV;
				AcceLongitudinaleV = (TextView)findViewById(R.id.AcceLongitudinaleV);
				TextView AcceVerticale;
				AcceVerticale = (TextView)findViewById(R.id.AcceVerticale);

				// Affichage des donnees
				AcceLateraleV.setText(String.format("%4.2f",sensorEvent.values[0]));
				AcceLongitudinaleV.setText(String.format("%4.2f",sensorEvent.values[1]));
				AcceVerticale.setText(String.format("%4.2f",sensorEvent.values[2]));
			}
			// magnetisme
			if (sensorEvent.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD)
			{
				// Enregistrement des variables
				fMagneticFieldValues = sensorEvent.values;

			}
			
			if (((sensorEvent.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD)||
					(sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER))&&
					(((sensorEvent.timestamp)/1000000000)!=lSeconde))
			{
				// Initialisation de la variable de controle d'une seconde
				lSeconde=((sensorEvent.timestamp)/1000000000);
				// Initialisation des variable pour l'orientation
				float[] fR = new float[9];
			
			// fonction de calcul d'orientation avec les parametres magnetique et d'acceleration
				SensorManager.getRotationMatrix(fR, null,
					fAccelerometerValues, fMagneticFieldValues);

				// Initialisation des variable pour l'orientation
				float[] fOrientation = new float[3];
					
				// Fonction de retour de calcul
				SensorManager.getOrientation(fR, fOrientation);
				
				// convertion en degre
				fOrientation[0] = (float) Math.toDegrees(fOrientation[0]);//Azimut
				fOrientation[1] = (float) Math.toDegrees(fOrientation[1]);//Tangage
				fOrientation[2] = (float) Math.toDegrees(fOrientation[2]);//Roulis
					
				//Orientation matériel
				// Creation du lien vers la vue
				TextView AzimutV;
				AzimutV = (TextView)findViewById(R.id.AzimutV);
				TextView TangageV;
				TangageV = (TextView)findViewById(R.id.TangageV);
				TextView RoulisV;
				RoulisV = (TextView)findViewById(R.id.RoulisV);

				// Affichage des donnees
				AzimutV.setText(String.format("%4.2f",fOrientation[0]));
				TangageV.setText(String.format("%4.2f",fOrientation[1]));
				RoulisV.setText(String.format("%4.2f",fOrientation[2]));
			}
		}
		
		
		@Override
		public void onAccuracyChanged(Sensor sensor, int accuracy) {
			// TODO Auto-generated method stub
			
		}
	};
	
	// permet de lancer la mise a jour ou ecoute des modifications du GPS
	private final LocationListener locationListener = new LocationListener() {
		
		public void onLocationChanged(Location location) {
			// TODO Auto-generated method stub
			updateWithNewLocation(location);
		}

		public void onProviderDisabled(String provider) {}

		public void onProviderEnabled(String provider) {}

		public void onStatusChanged(String provider, int status, Bundle extras) {}
		
	};
	
	// permet de lancer une mise a jour de la fenetre pour le GPS
	private void updateWithNewLocation(Location location) {
		// Creation du lien vers la vue
		TextView LatitudeV;
		LatitudeV = (TextView)findViewById(R.id.LatitudeV);
		TextView LongitudeV;
		LongitudeV = (TextView)findViewById(R.id.LongitudeV);
		TextView AltitudeV;
		AltitudeV = (TextView)findViewById(R.id.AltitudeV);
		TextView DateV;
		DateV = (TextView)findViewById(R.id.DateV);
		TextView CapV;
		CapV = (TextView)findViewById(R.id.CapV);
		TextView VitesseV;
		VitesseV = (TextView)findViewById(R.id.VitesseV);

		// Verification de valeur et attribution de valeur
		if (location != null)
		{
			LatitudeV.setText(String.format("%4.2f",location.getLatitude()));
			LongitudeV.setText(String.format("%4.2f",location.getLongitude()));
			AltitudeV.setText(String.valueOf(location.getAltitude()));
			// Convertion de la date
			SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss:SSS");
			DateV.setText(String.valueOf(formatter.format(location.getTime())));
			CapV.setText(String.format("%4.2f",location.getBearing()));
			VitesseV.setText(String.format("%4.2f",location.getSpeed()));
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
