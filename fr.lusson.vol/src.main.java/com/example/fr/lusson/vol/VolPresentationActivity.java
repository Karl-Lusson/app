package com.example.fr.lusson.vol;

import fr.lusson.bousole.vue.BousoleView;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class VolPresentationActivity extends Activity {

	private static final int DLG_DEMANDE_DIALOGUE = 0;
	private static final int TEXT_ID = 0;
	// Permet de sauvegarde R.id du menu
	private static int iRidSav=0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//
		setContentView(R.layout.activity_vol_presentation);
		//Definition des variables pour la police
		Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Comic_Sans_MS_Bold.ttf");
		TextView texteView = (TextView) findViewById(R.id.textViewHpt);
		//Affectation de la police aux TextView 
		texteView.setTypeface(font);
		texteView = (TextView) findViewById(R.id.textViewPrefixHgps);
		texteView.setTypeface(font);
		texteView = (TextView) findViewById(R.id.textViewcheckBoxVTH);
		texteView.setTypeface(font);
		texteView = (TextView) findViewById(R.id.textViewcheckBoxVP);
		texteView.setTypeface(font);
		texteView = (TextView) findViewById(R.id.textViewcheckBoxLogger);
		texteView.setTypeface(font);
		texteView = (TextView) findViewById(R.id.textViewcheckBoxX5);
		texteView.setTypeface(font);
		texteView = (TextView) findViewById(R.id.textViewcheckBoxChrono);
		texteView.setTypeface(font);
		texteView = (TextView) findViewById(R.id.textViewPrefixePT);
		texteView.setTypeface(font);
		texteView = (TextView) findViewById(R.id.textViewPT);
		texteView.setTypeface(font);
		texteView = (TextView) findViewById(R.id.textViewPts);
		texteView.setTypeface(font);
		texteView = (TextView) findViewById(R.id.textViewRw_WKT);
		texteView.setTypeface(font);
		texteView = (TextView) findViewById(R.id.textViewPtsPrefix);
		texteView.setTypeface(font);
		texteView = (TextView) findViewById(R.id.textViewRw_WKT);
		texteView.setTypeface(font);
		texteView = (TextView) findViewById(R.id.textViewHgps);
		texteView.setTypeface(font);
		texteView = (TextView) findViewById(R.id.textViewRv);
		texteView.setTypeface(font);
		texteView = (TextView) findViewById(R.id.textViewHsc);
		texteView.setTypeface(font);
		texteView = (TextView) findViewById(R.id.textViewCapVitesse);
		texteView.setTypeface(font);
		texteView = (TextView) findViewById(R.id.textViewVentCapVitesse);
		texteView.setTypeface(font);
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.vol_presentation, menu);
		return true;
		
	}


    //Méthode qui se déclenchera au clic sur un item
   public boolean onOptionsItemSelected(MenuItem item) {
	   // initialisation parameter
	   BousoleView cfr = (fr.lusson.bousole.vue.BousoleView)findViewById(R.id.BoussoleView);
	//On regarde quel item a été cliqué grâce à son id et on déclenche une action
	   switch (item.getItemId()) {

	   //Case à cocher
	   	case R.id.action_Vth:
	   		// Vth
	   		CheckBox cbTestVth;
	   		TextView tvTestVth;
	   		
	   		cbTestVth =(CheckBox) findViewById(R.id.checkBoxVTH);
	   		if (cbTestVth.getVisibility()==(View.VISIBLE)) {
		   		cbTestVth.setVisibility(View.INVISIBLE);
		   		tvTestVth = (TextView) findViewById(R.id.textViewcheckBoxVTH);
		   		tvTestVth.setVisibility(View.INVISIBLE);
	   		}
	   		else
	   		{
		   		cbTestVth.setVisibility(View.VISIBLE);
		   		tvTestVth = (TextView) findViewById(R.id.textViewcheckBoxVTH);
		   		tvTestVth.setVisibility(View.VISIBLE);
	   		}
       		return true;
        case R.id.action_VP:
	   		// VP
	   		CheckBox cbTestVP;
	   		TextView tvTestVP;
	   		cbTestVP =(CheckBox) findViewById(R.id.checkBoxVP);
	   		if (cbTestVP.getVisibility()==(View.VISIBLE)) {
	   			cbTestVP.setVisibility(View.INVISIBLE);
	   			tvTestVP = (TextView) findViewById(R.id.textViewcheckBoxVP);
	   			tvTestVP.setVisibility(View.INVISIBLE);
	   		}
	   		else
	   		{
	   			cbTestVP.setVisibility(View.VISIBLE);
	   			tvTestVP = (TextView) findViewById(R.id.textViewcheckBoxVP);
		   		tvTestVP.setVisibility(View.VISIBLE);
	   		}
            return true;
        case R.id.action_Logger:
	   		//iEtatBoussoleInt Logger
	   		CheckBox cbTestLogger;
	   		TextView tvTestLogger;
	   		cbTestLogger =(CheckBox) findViewById(R.id.checkBoxLogger);
	   		if (cbTestLogger.getVisibility()==(View.VISIBLE)) {
	   			cbTestLogger.setVisibility(View.INVISIBLE);
	   			tvTestLogger = (TextView) findViewById(R.id.textViewcheckBoxLogger);
	   			tvTestLogger.setVisibility(View.INVISIBLE);
	   		}
	   		else
	   		{
	   			cbTestLogger.setVisibility(View.VISIBLE);
	   			tvTestLogger = (TextView) findViewById(R.id.textViewcheckBoxLogger);
		   		tvTestLogger.setVisibility(View.VISIBLE);
	   		}
            return true;
        case R.id.action_SC:
   		// Logger
        	CheckBox cbTestSC;
        	TextView tvTestSC;
        	cbTestSC =(CheckBox) findViewById(R.id.checkBoxSC);
        	if (cbTestSC.getVisibility()==(View.VISIBLE)) {
        		cbTestSC.setVisibility(View.INVISIBLE);
        		tvTestSC = (TextView) findViewById(R.id.textViewcheckBoxSC);
        		tvTestSC.setVisibility(View.INVISIBLE);
        	}
        	else
        	{
        		cbTestSC.setVisibility(View.VISIBLE);
        		tvTestSC = (TextView) findViewById(R.id.textViewcheckBoxSC);
        		tvTestSC.setVisibility(View.VISIBLE);
        	}
        return true;	   		
        case R.id.action_X5:
   		// Logger
        	CheckBox cbTestX5;
        	TextView tvTestX5;
        	cbTestX5 =(CheckBox) findViewById(R.id.checkBoxX5);
        	if (cbTestX5.getVisibility()==(View.VISIBLE)) {
        		cbTestX5.setVisibility(View.INVISIBLE);
        		tvTestX5 = (TextView) findViewById(R.id.textViewcheckBoxX5);
        		tvTestX5.setVisibility(View.INVISIBLE);
        	}
        	else
        	{
        		cbTestX5.setVisibility(View.VISIBLE);
        		tvTestX5 = (TextView) findViewById(R.id.textViewcheckBoxX5);
        		tvTestX5.setVisibility(View.VISIBLE);
        	}
        return true;	   		
        // Valeur
        case R.id.action_Chrono:
   		// Logger
        	CheckBox cbTestChrono;
        	TextView tvTestChrono;
        	cbTestChrono =(CheckBox) findViewById(R.id.checkBoxChrono);
        	if (cbTestChrono.getVisibility()==(View.VISIBLE)) {
        		cbTestChrono.setVisibility(View.INVISIBLE);
        		tvTestChrono = (TextView) findViewById(R.id.textViewcheckBoxChrono);
        		tvTestChrono.setVisibility(View.INVISIBLE);
        	}
        	else
        	{
        		cbTestChrono.setVisibility(View.VISIBLE);
        		tvTestChrono = (TextView) findViewById(R.id.textViewcheckBoxChrono);
        	}
        	return true;	   		
        case R.id.action_PT:
        	iRidSav = R.id.action_PT;
        	LancementBoiteDialogue();
        	return true;	   		
        case R.id.action_Rv:
        	iRidSav = R.id.action_Rv;
        	LancementBoiteDialogue();
        	return true;	   		
        case R.id.action_Hpt:
        	iRidSav = R.id.action_Hpt;
        	LancementBoiteDialogue();
        	return true;	   		
        case R.id.action_Hgps:
        	iRidSav = R.id.action_Hgps;
        	LancementBoiteDialogue();
        	return true;	   		
        case R.id.action_PrefixHgps:
        	iRidSav = R.id.action_PrefixHgps;
        	LancementBoiteDialogue();
        	return true;	   		
        case R.id.action_Rw:
        	iRidSav = R.id.action_Rw;
        	LancementBoiteDialogue();
        	return true;	   		
        case R.id.action_WKT:
        	iRidSav = R.id.action_WKT;
        	LancementBoiteDialogue();
        	return true;	   		
        case R.id.action_Hsc:
        	iRidSav = R.id.action_Hsc;
        	LancementBoiteDialogue();
        	return true;	   		
        case R.id.action_PTS:
        	iRidSav = R.id.action_PTS;
        	LancementBoiteDialogue();
        	return true;	   		
        case R.id.action_VentCap:
        	iRidSav = R.id.action_VentCap;
        	LancementBoiteDialogue();
        	return true;	   		
        case R.id.action_VentVitesse:
        	iRidSav = R.id.action_VentVitesse;
        	LancementBoiteDialogue();
        	return true;	   		
        case R.id.action_Cap:
        	iRidSav = R.id.action_Cap;
        	LancementBoiteDialogue();
        	return true;	   		
        case R.id.action_Vitesse:
        	iRidSav = R.id.action_Vitesse;
        	LancementBoiteDialogue();
        	return true;	   		
// bousole vue
        case R.id.action_altitude:
        	iRidSav = R.id.action_altitude;
        	LancementBoiteDialogue();
        	return true;	   		
        case R.id.action_chrono:
        	iRidSav = R.id.action_chrono;
        	LancementBoiteDialogue();
        	return true;	   		
        case R.id.action_cap:
        	iRidSav = R.id.action_cap;
        	LancementBoiteDialogue();
        	return true;	   		
        case R.id.action_ecart_lateral:
        	iRidSav = R.id.action_ecart_lateral;
        	LancementBoiteDialogue();
        	return true;	   		
        case R.id.action_route:
        	iRidSav = R.id.action_route;
        	LancementBoiteDialogue();
        	return true;	   		
        case R.id.action_BousoleIntC1:
        	cfr.setiEtatBoussoleInt(1);
        	return true;	   		
        case R.id.action_BousoleIntC2:
        	cfr.setiEtatBoussoleInt(2);
        	return true;	   		
        case R.id.action_BousoleIntC3:
        	cfr.setiEtatBoussoleInt(3);
       	return true;	   		

	   }
      return false;
   }


   /**
    * Permet de lancer la boite de dialogue
    */

   @SuppressWarnings("deprecation")
	private void LancementBoiteDialogue() {
		showDialog(DLG_DEMANDE_DIALOGUE);
	}

	/**
    * Called to create a dialog to be shown.
    */
   @Override
   protected Dialog onCreateDialog(int id) {

       switch (id) {
           case DLG_DEMANDE_DIALOGUE:
               return createExampleDialog();
           default:
               return null;
       }
   }
   
   /** onPrepareDialog
    * Cette fonction permet de preparer pour l'affichage de la boite de dialogue
    * @see android.app.Activity#onPrepareDialog(int, android.app.Dialog)
    */
   	@Override
	protected void onPrepareDialog(int id, Dialog dialog) {
   		switch (id) {
   			case DLG_DEMANDE_DIALOGUE:
   				// Effacement du input de la boite de dialogue.
   				EditText text = (EditText) dialog.findViewById(TEXT_ID);
   				text.setText("");
            break;
   		}
	}
   	/**
     * Creer et returne l'information de la boite de dialogue
     * Create and return an example alert dialog with an edit text box.
     */
    private Dialog createExampleDialog() {
 
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Puis-je avoir la valeur ?");
        // variable pour rechercher les données sur l'affichage
        TextView tvBuf;
        switch (iRidSav) {
        case R.id.action_PT:
            builder.setTitle("PT");
			tvBuf = (TextView)findViewById(R.id.textViewPT);
			// Affichage des donnees
			builder.setMessage(tvBuf.getText()+" - Puis-je avoir la valeur ?");
            break;
        case R.id.action_Rv:
            builder.setTitle("Rv");
			tvBuf = (TextView)findViewById(R.id.textViewRv);
			// Affichage des donnees
			builder.setMessage(tvBuf.getText()+" - Puis-je avoir la valeur ?");
            break;
        case R.id.action_Hpt:
            builder.setTitle("Hpt");
			tvBuf = (TextView)findViewById(R.id.textViewHpt);
			// Affichage des donnees
			builder.setMessage(tvBuf.getText()+" - Puis-je avoir la valeur ?");
            break;
        case R.id.action_Hgps:
            builder.setTitle("Hgps");
			tvBuf = (TextView)findViewById(R.id.textViewHgps);
			// Affichage des donnees
			builder.setMessage(tvBuf.getText()+" - Puis-je avoir la valeur ?");
            break;
        case R.id.action_PrefixHgps:
            builder.setTitle("PrefixHgps");
			tvBuf = (TextView)findViewById(R.id.textViewPrefixHgps);
			// Affichage des donnees
			builder.setMessage(tvBuf.getText()+" - Puis-je avoir la valeur ?");
            break;
        case R.id.action_Rw:
            builder.setTitle("Rw");
			tvBuf = (TextView)findViewById(R.id.textViewRw_WKT);
			// Affichage des donnees
			builder.setMessage(tvBuf.getText()+" - Puis-je avoir la valeur ?");
            break;
        case R.id.action_WKT:
            builder.setTitle("WKT");
			tvBuf = (TextView)findViewById(R.id.textViewRw_WKT);
			// Affichage des donnees
			builder.setMessage(tvBuf.getText()+" - Puis-je avoir la valeur ?");
            break;
        case R.id.action_Hsc:
            builder.setTitle("Hsc");
			tvBuf = (TextView)findViewById(R.id.textViewHsc);
			// Affichage des donnees
			builder.setMessage(tvBuf.getText()+" - Puis-je avoir la valeur ?");
            break;
        case R.id.action_PTS:
            builder.setTitle("PTS");
			tvBuf = (TextView)findViewById(R.id.textViewPts);
			// Affichage des donnees
			builder.setMessage(tvBuf.getText()+" - Puis-je avoir la valeur ?");
            break;
        case R.id.action_VentCap:
            builder.setTitle("VentCap");
			tvBuf = (TextView)findViewById(R.id.textViewVentCapVitesse);
			// Affichage des donnees
			builder.setMessage(tvBuf.getText()+" - Puis-je avoir la valeur ?");
            break;
        case R.id.action_VentVitesse:
            builder.setTitle("VentVitesse");
			tvBuf = (TextView)findViewById(R.id.textViewVentCapVitesse);
			// Affichage des donnees
			builder.setMessage(tvBuf.getText()+" - Puis-je avoir la valeur ?");
            break;
        case R.id.action_Cap:
            builder.setTitle("Cap");
			tvBuf = (TextView)findViewById(R.id.textViewCapVitesse);
			// Affichage des donnees
			builder.setMessage(tvBuf.getText()+" - Puis-je avoir la valeur ?");
            break;
        case R.id.action_Vitesse:
            builder.setTitle("Vitesse");
			tvBuf = (TextView)findViewById(R.id.textViewCapVitesse);
			// Affichage des donnees
			builder.setMessage(tvBuf.getText()+" - Puis-je avoir la valeur ?");
            break;
		}
 
        // Use an EditText view to get user input.
        final EditText input = new EditText(this);
        input.setId(TEXT_ID);
        builder.setView(input);
 
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
 
            @Override
            public void onClick(DialogInterface dialog, int whichButton) {
                String sValue = input.getText().toString();
                
                // Variable de modification 
				TextView tvBuffer;
				// Variable de modification de la boussole
	        	BousoleView cfr = (fr.lusson.bousole.vue.BousoleView)findViewById(R.id.BoussoleView);
				
				// Modification du Text
		        switch (iRidSav) {
		        case R.id.action_PT:
					tvBuffer = (TextView)findViewById(R.id.textViewPT);
					// Affichage des donnees
					tvBuffer.setText(sValue);
		            break;
		        case R.id.action_Rv:
					tvBuffer = (TextView)findViewById(R.id.textViewRv);
					// Affichage des donnees
					tvBuffer.setText(sValue);
		            break;
		        case R.id.action_Hpt:
					tvBuffer = (TextView)findViewById(R.id.textViewHpt);
					// Affichage des donnees
					tvBuffer.setText(sValue);
		            break;
		        case R.id.action_Hgps:
					tvBuffer = (TextView)findViewById(R.id.textViewHgps);
					// Affichage des donnees
					tvBuffer.setText(sValue);
		            break;
		        case R.id.action_PrefixHgps:
					tvBuffer = (TextView)findViewById(R.id.textViewPrefixHgps);
					// Affichage des donnees
					tvBuffer.setText(sValue);
		            break;
		        case R.id.action_Rw:
					tvBuffer = (TextView)findViewById(R.id.textViewRw_WKT);
					// Affichage des donnees
					tvBuffer.setText(sValue);
		            break;
		        case R.id.action_WKT:
					tvBuffer = (TextView)findViewById(R.id.textViewRw_WKT);
					// Affichage des donnees
					tvBuffer.setText(sValue);
		            break;
		        case R.id.action_Hsc:
					tvBuffer = (TextView)findViewById(R.id.textViewHsc);
					// Affichage des donnees
					tvBuffer.setText(sValue);
		            break;
		        case R.id.action_PTS:
					tvBuffer = (TextView)findViewById(R.id.textViewPts);
					// Affichage des donnees
					tvBuffer.setText(sValue);
		            break;
		        case R.id.action_VentCap:
					tvBuffer = (TextView)findViewById(R.id.textViewVentCapVitesse);
					// Affichage des donnees
					tvBuffer.setText(sValue);
		            break;
		        case R.id.action_VentVitesse:
					tvBuffer = (TextView)findViewById(R.id.textViewVentCapVitesse);
					// Affichage des donnees
					tvBuffer.setText(sValue);
		            break;
		        case R.id.action_Cap:
					tvBuffer = (TextView)findViewById(R.id.textViewCapVitesse);
					// Affichage des donnees
					tvBuffer.setText(sValue);
		            break;
		        case R.id.action_Vitesse:
					tvBuffer = (TextView)findViewById(R.id.textViewCapVitesse);
					// Affichage des donnees
					tvBuffer.setText(sValue);
		            break;
		         // bousole vue
		        case R.id.action_altitude:
		        	cfr.setfAltitude(Float.valueOf(sValue.trim()).floatValue());
		        	break;
		        case R.id.action_chrono:
		        	cfr.setfChrono(Float.valueOf(sValue.trim()).floatValue());
		            break;
		        case R.id.action_cap:
		        	cfr.setfCap(Float.valueOf(sValue.trim()).floatValue());
		            break;
		        case R.id.action_ecart_lateral:
		        	cfr.setfEcartLateral(Float.valueOf(sValue.trim()).floatValue());
		            break;
		        case R.id.action_route:
		        	cfr.setRoute(Float.valueOf(sValue.trim()).floatValue());
		            break;
				}
                return;
            }
        });
 
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                return;
            }
        });
         return builder.create();
    }
	
}
