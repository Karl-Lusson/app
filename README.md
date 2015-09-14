#Prérequis

## Installation du SDK Android
1. Télécharger le SDK android pour votre plate-forme [sur le site officiel](https://developer.android.com/sdk/index.html#Other)
    1. Windows [l'installateur - version r24.3.4](http://dl.google.com/android/installer_r24.3.4-windows.exe), par exemple dans le répertoire   
    `C:\Appl\SDK`  
        Puis créer la variable d'environnement `ANDROID_HOME` pointant sur ce répertoire. Je vous recommande également d'inclure dans votre PATH le chemin `%ANDROID_HOME%\tools` pour pouvoir lancer dans un terminal les commandes android. 
    
    2. linux  
    <code>
        $ mkdir -p ~/Android  
        $ wget http://dl.google.com/android/android-sdk_r24.3.4-linux.tgz    
        $ tar -cvjf android-sdk_r24.3.4-linux.tgz 
        </code>  
    Editer votre `.bashrc` pour y ajouter les instructions suivantes :  
    ```{bash, eval=false}
        export ANDROID_HOME="~/Android/android-sdk-linux"  
        # set PATH so it includes android/tools if it exists  
        if [ -d "$ANDROID_HOME/tools" ] ; then  
           PATH="$ANDROID_HOME/tools:$PATH"  
        fi
     ```
     
2. Récupérer les versions du SDK qui nous intéresse.
    1. nous avons besoin des API 16, 17, 18
    1. nous avons également besoin des extras. Dans le doute télécharger tout les extras du SDK pour avoir une arborescence comme ci-dessous:  
    
    $ANDROID_HOME  
        ├── add-ons  
**        │   ├── addon-google_apis-google-16  
        │   ├── addon-google_apis-google-17  
        │   └── addon-google_apis-google-18**  
        ├── build-tools  
        │   ├── 19.1.0  
        │   ├── 20.0.0  
        │   ├── 21.1.2  
        │   ├── 22.0.1  
        │   └── 23.0.1  
        ├── extras  
        │   ├── android  
        │   └── google  
        ├── platforms  
**        │   ├── android-16  
        │   ├── android-17  
        │   └── android-18**  
        ├── platform-tools  
        │   ├── api  
        │   ├── lib  
        │   └── systrace  
        ├── samples  
**        │   ├── android-16  
        │   ├── android-17  
        │   └── android-18**  
        ├── sources  
**        │   ├── android-16  
        │   ├── android-17  
        │   └── android-18**  
        ├── system-images  
**        │   ├── android-16  
        │   ├── android-17  
        │   ├── android-18**  
        │   ├── android-21 (facultatif)   
        │   └── android-22 (facultatif)  
        ├── temp  
        └── tools  
        
## Installer GIT (le gestionnaire de version)
source [Installation de GIT](https://git-scm.com/book/fr/v1/D%C3%A9marrage-rapide-Installation-de-Git)
### Installation sur Linux

Si vous souhaitez installer Git sur Linux via un installateur d'application, vous pouvez généralement le faire via le système de gestion de paquets de base fourni avec votre distribution. Si vous êtes sur Fedora, vous pouvez utiliser yum :  
<code>
$ yum install git
</code>  
Si vous êtes sur un système basé sur Debian, tel qu'Ubuntu, essayez apt-get :  
<code>
$ apt-get install git
</code>

### Installation sur Mac

Il y a deux moyens simples d'installer Git sur Mac. Le plus simple et d'utiliser l'installateur graphique de Git que vous pouvez télécharger depuis les pages SourceForge (voir figure 1-7) :

`http://sourceforge.net/projects/git-osx-installer/`

L'autre méthode consiste à installer Git par les MacPorts (http://www.macports.org). Si vous avez installé MacPorts, installez Git par :  
``
$ sudo port install git-core +svn +doc +bash_completion +gitweb  
``

### Installation sur Windows

Installer Git sur Windows est très facile. Le projet msysGit fournit une des procédures d'installation les plus simples. Téléchargez simplement le fichier exe d'installateur depuis la page GitHub, et lancez-le :  
``
http://msysgit.github.io  
``
Après son installation, vous avez à la fois la version en ligne de commande (avec un client SSH utile pour la suite) et l'interface graphique standard.

_Note sur l'usage sous Windows_ : vous devriez utiliser _Git_ avec le _shell bash_ fourni par msysGit (style Unix), car il permet d'utiliser les lignes de commandes complexes, parfois utiles. Si vous devez, pour une raison quelconque, utiliser l'interpréteur de commande natif de Windows (console système), vous devez utiliser des guillemets au lieu des apostrophes pour délimiter les paramètres avec des espaces. Vous devez aussi délimiter avec ces guillemets les paramètres finissant avec l'accent circonflexe (^) s'ils sont en fin de ligne, car c'est un symbole de continuation de Windows.

## Installer un IDE (Environnement de Développement Intégré)
A partir de là si vous installez un IDE (tel qu'[Eclipse](https://eclipse.org/downloads/) par exemple) vous pouvez développez ou faire fonctionner l'application. 

## Installation des prés-requis pour utiliser Maven pour Android

1. Installation de Maven (version minimum 3.1.1)  
Voir [Le Guide définitif de Maven](http://maven-guide-fr.erwan-alliaume.com/maven-guide-fr/site/reference/installation.html) en résumé :

    1. Télécharger Maven [là](http://maven.apache.org/download.cgi)    
    2. Décompresser l'archive (par exemple dans _C:\Appl_ ou sous linux _~/Appl_)
    3. Inclure le dossier _MAVEN_HOME/bin_ dans le PATH
    
1. Installation des artefacts Android dans un dépôt Maven
    1. Téléchargement de l'archive [maven pour Android](https://github.com/simpligility/maven-android-sdk-deployer/archive/master.zip) sur https://github.com/simpligility/maven-android-sdk-deployer  
    <code>
    $ wget https://github.com/simpligility/maven-android-sdk-deployer/archive/master.zip -O maven-android-sdk-deployer.zip  
    </code>
    1. Extraction de l'archive à coté du SDK  
    <code>
    $ unzip maven-android-sdk-deployer.zip  
    </code>
    1. Installation dans votre dépôt local des dépendances nécessaires pour les API 16,17,18 soit les version d'Android 4.1, 4.2 et 4.3  
    <code>
    $ mvn clean install -P 4.1,4.2,4.3
    </code>
    
# Récuperation du code
</code>
$ git clone https://github.com/eric-lemesre/app.git
</code>

