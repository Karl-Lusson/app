package fr.lusson.xml.lecture;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class XmlLectureActivity extends Activity {

	// Variable globale de la list pour gridview
	private ArrayList<String> alGridView = new ArrayList<String>();

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_xml_lecture);
		// initialisation de la liaison entre la gridview et l'arryList
		// Creation de la varible gridView
		GridView gridView= (GridView) findViewById(R.id.gvFichier);
		// Creation de l'adapteur de la grid view
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,alGridView);
		// Affectation de l'adapteur
		gridView.setAdapter(adapter);

		
		/* permet le lancement sur l'appuis d'un bouton	
		final Button button = (Button) findViewById(R.id.Parcourir);
        button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// Test
				TextView FichierSelectionner;
				FichierSelectionner = (TextView)findViewById(R.id.FichierSelectionner);
				FichierSelectionner.setText("aaa");
			}
		}
        );
        */
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.xml_lecture, menu);
		return true;
	}
	
	
	
	// Gestion des menus
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		//Choix des menu
		TextView FichierSelectionner;
		FichierSelectionner = (TextView)findViewById(R.id.FichierSelectionner);
		switch (item.getItemId())
		{
		case R.id.Nav :
			// Test
			FichierSelectionner.setText("Nav");
//			LectureNavXML("//sdcard//Download//Memoy-Map//nav.gpx");
			LectureNavXML("//storage//sdcard0//Download//Memory-Map//nav.gpx");
			
			return true;
		case R.id.Sc :
			// Test
			FichierSelectionner.setText("Sc");
//			LectureScXML("//sdcard//Download//Memoy-Map//sc.gpx");
			LectureScXML("//storage//sdcard0//Download//Memory-Map//nav.gpx");
			return true;
			default:
					return super.onOptionsItemSelected(item);
		}
	
	}

	

	// Permet la récupération du fichier XML de Nav.gpx
	private void LectureNavXML(String stNameFichier)
	{
		// Effacement des données
		alGridView.clear();
		// Creation de la varible gridView
		GridView gridView= (GridView) findViewById(R.id.gvFichier);
		// Nombre de colonne
		gridView.setNumColumns(6);
		// Liaison avec la vue pour afficher des informations
		TextView FichierSelectionner;
		FichierSelectionner = (TextView)findViewById(R.id.FichierSelectionner);

		File f= new File(stNameFichier);
		if(f.exists()==true)
		{
		  //le fichier existe
			try
			{
			// création d'une fabrique de documents
				DocumentBuilderFactory fabrique = DocumentBuilderFactory.newInstance();
			
			// création d'un constructeur de documents
				DocumentBuilder constructeur = fabrique.newDocumentBuilder();
			
			// lecture du contenu d'un fichier XML avec DOM
				File xml = new File(stNameFichier);
				Document document = constructeur.parse(xml);
				//Element channelNode = (Element) document.getElementsByTagName(" ");
				// recherche tous les element
				NodeList nodesList = document.getElementsByTagName("*");
				// Initialisation des variables
				String stLatitude="",stLongitude="",stName="",stTime="",stTypePoint="",stAlt="";
				for (int temp = 0; temp < nodesList.getLength(); temp++) 
				{
					//Noeud en cour
					Node nNode = nodesList.item(temp);
					if (nNode.getNodeName().equals("rtept"))
					{
						if (!(stLatitude.equals("")))
						{
							//		nom	lat		lon		heure		(alt)	V

							alGridView.add(stName);
							alGridView.add(stLatitude);
							alGridView.add(stLongitude);
							alGridView.add(stTime);
							alGridView.add(stAlt);
							alGridView.add(stTypePoint);
							stLatitude="";
							stLongitude="";
							stName="";
							stTime="";
							stTypePoint="";
							stAlt="";
						}
						stLatitude = nodesList.item(temp).getAttributes().getNamedItem("lat").getNodeValue();
						stLongitude = nodesList.item(temp).getAttributes().getNamedItem("lon").getNodeValue();
					}
					if (nNode.getNodeName().equals("name"))
					{
						stName = nNode.getTextContent();
					}
					if (nNode.getNodeName().equals("desc"))
					{
						stTime = nNode.getTextContent();
					}
					if (nNode.getNodeName().equals("sym"))
					{
						stTypePoint = nNode.getTextContent();
					}
					if (nNode.getNodeName().equals("alt"))
					{
						stAlt = nNode.getTextContent();
					}
				}
				if (!(stLatitude.equals("")))
				{
					//		nom	lat		lon		heure		(alt)	V

					alGridView.add(stName);
					alGridView.add(stLatitude);
					alGridView.add(stLongitude);
					alGridView.add(stTime);
					alGridView.add(stAlt);
					alGridView.add(stTypePoint);
				}
			}
			catch(ParserConfigurationException pce)
			{
				FichierSelectionner.setText("Probleme lors de l'appel à fabrique.newDocumentBuilder();");
			}
			catch(SAXException se)
			{
				FichierSelectionner.setText("Probleme lors de l'appel à construteur.parse(xml)");
			}
			catch(IOException ioe)
			{
				FichierSelectionner.setText("robleme Plors de l'appel à construteur.parse(xml)");
			}
		}
		else
		{
		   // il n'existe pas
			FichierSelectionner.setText("Probleme de lecture du fichier");
		}
	}

	// Permet la récupération du fichier XML de Nav.gpx
	private void LectureScXML(String stNameFichier)
	{
		// Effacement des données
		alGridView.clear();
		// Creation de la varible gridView
		GridView gridView= (GridView) findViewById(R.id.gvFichier);
		// Nombre de colonne
		gridView.setNumColumns(4);
		// Liaison avec la vue pour afficher des informations
		TextView FichierSelectionner;
		FichierSelectionner = (TextView)findViewById(R.id.FichierSelectionner);

		File f= new File(stNameFichier);
		if(f.exists()==true)
		{
		  //le fichier existe
			try
			{
			// création d'une fabrique de documents
				DocumentBuilderFactory fabrique = DocumentBuilderFactory.newInstance();
			
			// création d'un constructeur de documents
				DocumentBuilder constructeur = fabrique.newDocumentBuilder();
			
			// lecture du contenu d'un fichier XML avec DOM
				File xml = new File(stNameFichier);
				Document document = constructeur.parse(xml);
				//Element channelNode = (Element) document.getElementsByTagName(" ");
				// recherche tous les element
				NodeList nodesList = document.getElementsByTagName("*");
				// Initialisation des variables
				String stLatitude="",stLongitude="",stBranche="",stPoint="";
				boolean bRte=false;
				for (int temp = 0; temp < nodesList.getLength(); temp++) 
				{
					//Noeud en cour
					Node nNode = nodesList.item(temp);
					// Recherche de la rte
					if (nNode.getNodeName().equals("rte"))
					{
						if (!(stLatitude.equals("")))
						{
							alGridView.add(stBranche);
							alGridView.add(stPoint);
							alGridView.add(stLatitude);
							alGridView.add(stLongitude);
							stBranche="";
							stPoint="";
							stLatitude="";
							stLongitude="";
						}
						bRte=true;
					}
					if ((nNode.getNodeName().equals("name"))&&bRte)
					{
						stBranche = nNode.getTextContent();
						bRte=false;
					}
					if (nNode.getNodeName().equals("rtept"))
					{
						if (!(stLatitude.equals("")))
						{
							alGridView.add(stBranche);
							alGridView.add(stPoint);
							alGridView.add(stLatitude);
							alGridView.add(stLongitude);
							stPoint="";
							stLatitude="";
							stLongitude="";
						}
						stLatitude = nodesList.item(temp).getAttributes().getNamedItem("lat").getNodeValue();
						stLongitude = nodesList.item(temp).getAttributes().getNamedItem("lon").getNodeValue();
					}
					if ((nNode.getNodeName().equals("name"))&&!bRte)
					{
						stPoint = nNode.getTextContent();
					}
				}
				if (!(stLatitude.equals("")))
				{
// Dernier point
					alGridView.add(stBranche);
					alGridView.add(stPoint);
					alGridView.add(stLatitude);
					alGridView.add(stLongitude);
				}
			}
			catch(ParserConfigurationException pce)
			{
				FichierSelectionner.setText("Probleme lors de l'appel à fabrique.newDocumentBuilder();");
			}
			catch(SAXException se)
			{
				FichierSelectionner.setText("Probleme lors de l'appel à construteur.parse(xml)");
			}
			catch(IOException ioe)
			{
				FichierSelectionner.setText("robleme Plors de l'appel à construteur.parse(xml)");
			}
		}
		else
		{
		   // il n'existe pas
			FichierSelectionner.setText("Probleme de lecture du fichier");
		}
	}

}
