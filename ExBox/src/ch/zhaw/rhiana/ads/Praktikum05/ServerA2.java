package ch.zhaw.rhiana.ads.Praktikum05;

import java.util.List;
import java.util.Stack;

import ch.zhaw.rhiana.ads.CommandExecutor;
import ch.zhaw.rhiana.ads.Praktikum03.Competitor;
import ch.zhaw.rhiana.ads.Praktikum03.CompetitorServer;

public class ServerA2 implements CommandExecutor  {
	
	private static final String rangliste = 	
		"3;Kiptum Daniel;1978;Reconvilier;02:11:31.1;\n" + 
		"51;An�ay Tarcis;1970;Lens;02:20:02.9;\n" + 
		"52;Kreienb�hl Christian;1981;R�ti ZH;02:21:47.6;\n" + 
		"53;Ott Michael;1982;Kilchberg ZH;02:33:48.9;\n" + 
		"54;Menzi Christoph;1984;Esslingen;02:27:26.4;\n" + 
		"55;Oliver Ruben;1976;Ebmatingen;02:32:12.8;\n" + 
		"57;Elmer Beat;1961;Hombrechtikon;02:33:53.3;\n" + 
		"58;K�hni Martin;1962;Kirchlindach;02:33:36.9;\n" + 
		"59;M�ller Stefan;1981;Luzern;02:31:14.0;\n" + 
		"62;Marti Adrian;1978;Rapperswil SG;02:30:09.7;\n" + 
		"63;Zwicky Christian;1966;Gockhausen;02:36:28.5;\n" + 
		"64;Gehrig Roman;1969;Z�rich;02:33:50.3;\n" + 
		"65;K�rner Lutz;1978;Z�rich;02:32:47.1;\n" + 
		"67;Nunige Guy;1966;Davos Platz;02:34:11.7;\n" + 
		"69;Marti Fredi;1974;Altst�tten SG;02:44:48.7;\n" + 
		"70;Dufaux Laurent;1969;Ollon VD;02:43:48.8;\n" + 
		"71;Hamd Mohamednur;1978;Neunkirch;02:19:45.7;\n" + 
		"72;Simpson Guy;1970;Cologny;02:30:50.8;\n" + 
		"151;Morceli Patricia;1974;Cham;02:37:28.0;\n" + 
		"152;Berchtold Rachel;1980;Z�rich;02:53:42.2;\n" + 
		"153;Di Marco Magali;1971;Troistorrents;02:42:56.3;\n" + 
		"156;Wyss Sandra;1977;Olten;02:54:06.3;\n" + 
		"157;Amiet Tanja;1976;Zuchwil;02:53:08.5;\n" + 
		"159;Meneghin-Pliska Maja;1978;Vermes;02:46:07.6;\n" + 
		"163;Zimmermann Denise;1975;Mels;02:56:54.0;\n" + 
		"165;Beffa Heidi;1964;Puplinge;03:09:43.9;\n" + 
		"166;Haller Natasha;1978;Sagno;03:01:07.3;\n" + 
		"167;Lohri Nicole;1972;Frauenfeld;02:52:31.3;\n" + 
		"168;Serafini Susanna;1974;Mendrisio;03:29:00.2;\n" + 
		"169;Annen Lamard Sandra;1977;Ecublens VD;02:57:20.3;\n" + 
		"170;Mayer-Hofmann Lucia;1979;Stans;02:59:35.4;\n" + 
		"201;Allard David;1947;Erlenbach ZH;04:26:57.0;\n" + 
		"202;Andres Robert;1952;Z�rich;03:33:42.9;\n" + 
		"203;Angehrn Otto;1945;D�bendorf;04:20:16.5;\n" + 
		"204;Bader Philipp;1965;Seltisberg;03:40:53.1;\n" + 
		"205;Baer Willi;1959;Wetzikon ZH;03:28:12.9;\n" + 
		"206;Baumann Simon;1975;Z�rich;03:03:47.9;\n" + 
		"207;Baumann Simon;1973;Bottenwil;03:12:09.6;\n" + 
		"208;Baumann Werner;1960;Hochfelden;03:45:49.7;\n" + 
		"209;Baur Hansruedi;1955;Rafz;04:04:04.5;\n" + 
		"210;Bellerjeau James;1968;Erlenbach ZH;03:42:08.6;\n" + 
		"211;Benz Felix;1960;Heerbrugg;02:58:13.2;\n" + 
		"212;Bergamin Mario;1954;Kloten;03:26:30.3;\n" + 
		"213;Bernhard Stefan;1970;Bubikon;04:46:01.3;\n" + 
		"215;Berweger Peter;1969;Wollerau;02:53:15.4;\n" + 
		"218;Bischof Thomas;1964;B�ch SZ;03:26:40.1;\n" + 
		"219;Blatter Eveline;1970;Z�rich;02:56:49.7;\n" + 
		"220;Bolliger Armin;1960;Hohentannen;03:00:08.5;\n" + 
		"221;Brem Daniel;1962;Wollerau;03:49:53.5;\n" + 
		"222;Meier Zgraggen Stefani;1971;B�lach;04:33:30.8;\n" + 
		"223;Brunold Andrea;1958;Adliswil;03:34:27.0;\n" + 
		"224;Br�schweiler Mathias;1961;Zollikon;03:29:48.0;\n" + 
		"225;Bucher Ren�;1965;Z�rich;04:06:20.5;\n" + 
		"226;Buchmann Isabel;1962;B�lach;03:26:18.3;\n" + 
		"227;B�hler Sigi;1957;Birmensdorf ZH;03:41:30.9;\n" + 
		"228;B�hler Willi;1957;Kloten;03:30:40.3;\n" + 
		"229;Buzzi Andreas;1962;Stallikon;03:46:55.3;\n" + 
		"230;Cavelti Roland;1963;Uster;03:17:16.1;\n" + 
		"231;Cremon Ren�;1964;Z�rich;03:39:32.4;\n" + 
		"233;Denker Catrina;1968;Z�rich;03:13:34.8;\n" + 
		"235;Egli Ariane;1963;Wetzikon ZH;04:06:18.9;\n" + 
		"236;Ehrismann Martin;1960;Z�rich;03:31:04.9;\n" + 
		"237;Eichholzer Hans;1945;Br�tten;03:57:46.6;\n" + 
		"239;Estermann Thomas;1968;Tann;03:48:47.8;\n" + 
		"240;Fahrni Kurt;1965;Wohlen AG;03:32:56.4;\n" + 
		"241;Fesli Mehmet;1950;Pratteln;04:46:31.2;\n" + 
		"242;Fl�ck Heinz;1947;Cadenazzo;04:41:57.5;\n" + 
		/*"243;Fl�hmann Katrin;1963;Murten;03:31:29.0;\n" + 
		"244;Fuchs Stefan;1969;Z�rich;03:02:36.3;\n" + 
		"245;F�glistaller J�rg;1957;Widen;03:32:35.2;\n" + 
		"246;F�rst Roger;1969;Kindhausen;03:24:10.4;\n" + 
		"247;F�rst Willi;1950;Hinwil;04:39:57.6;\n" + 
		"248;Galati Francesco;1944;Z�rich;03:29:38.1;\n" + 
		"249;Gasser Matthias;1968;Z�rich;03:29:03.8;\n" + 
		"250;G�umann Coni;1970;Mettmenstetten;03:59:14.9;\n" + 
		"251;Gautschi Martin;1961;Hittnau;03:02:27.4;\n" + 
		"252;Gerber Bernhard;1961;Wallisellen;04:06:33.1;\n" + 
		"254;Gianini Franz;1954;D�bendorf;04:01:52.1;\n" + 
		"255;Giger Claudio;1968;Z�rich;03:06:06.0;\n" + 
		"256;Giger Stephan;1963;Wilen b. Wil;03:56:50.1;\n" + 
		"257;Good Erich;1962;St. Gallen;03:30:46.9;\n" + 
		"258;Merkt J�rg;1964;B�lach;02:59:49.3;\n" + 
		"259;Streit Markus;1963;Steffisburg;02:59:49.2;\n" + 
		"260;Goudsmit Gerrit;1965;Greifensee;02:56:51.0;\n" + 
		"261;Gut Viktor;1960;Sempach Stadt;03:22:35.2;\n" + 
		"262;Haag Elisabeth;1952;St�fa;04:10:05.7;\n" + 
		"263;H�berli Roland;1968;Urdorf;04:36:11.0;\n" + 
		"264;H�chler Roland;1966;Volketswil;04:00:18.3;\n" + 
		"265;Haefeli Angela;1951;M�mliswil;03:48:09.9;\n" + 
		"266;H�fliger J�rg;1955;Z�rich;03:42:23.5;\n" + 
		"267;Hafner J�rg;1962;Z�rich;04:25:44.5;\n" + 
		"268;Hager Armin;1970;Kaltbrunn;03:22:35.8;\n" + 
		"269;H�ndle Heinz;1959;Hinteregg;04:13:38.7;\n" + 
		"270;Herren Kurt;1943;Lupsingen;04:49:31.2;\n" + 
		"271;Br�niger Markus;1955;Uster;03:56:54.1;\n" + 
		"272;Hirschi Peter;1954;Wangen b. D�bendo;04:32:42.3;\n" + 
		"273;H�ck Stefan;1976;Z�rich;03:34:37.9;\n" + 
		"274;Hofmann Martin;1950;Windisch;04:21:51.7;\n" + 
		"275;Hofstetter Corinne;1963;St. Gallen;03:30:35.2;\n" + 
		"277;Holzinger Adrian;1967;Greifensee;03:15:05.9;\n" + 
		"279;Huber Edi;1955;Jona;03:10:04.9;\n" + 
		"280;Huber Mac;1965;Berikon;03:46:59.0;\n" + 
		"281;Huggenberger Kurt;1949;Z�rich;04:20:30.3;\n" + 
		"282;Jaccard Marc Pierre;1947;Z�rich;04:41:07.1;\n" + 
		"283;Jakopic Klemen;1968;Jona;03:17:07.9;\n" + 
		"284;Jarjour Kamel;1951;M�rschwil;03:47:02.2;\n" + 
		"285;Jordi Markus;1963;Horgen;03:51:01.0;\n" + 
		"286;Jost Hansueli;1978;Nottwil;03:49:31.9;\n" + 
		"287;Jucker Andreas H.;1957;Wetzikon ZH;03:22:44.9;\n" + 
		"288;Jud Ueli;1961;Sch�nis;02:52:15.4;\n" + 
		"289;Jutzi Victor;1953;Birmensdorf ZH;03:40:25.6;\n" + 
		"290;K�lin L�on;1950;Wernetshausen;04:04:11.0;\n" + 
		"291;Kaufmann Patrick;1971;Dielsdorf;04:03:16.0;\n" + 
		"293;Keller Peter;1961;Laupen ZH;03:23:54.9;\n" + 
		"294;Keller Stephan;1959;Uster;03:26:12.3;\n" + 
		"295;Kilchherr Virginia;1966;R�schlikon;03:44:11.6;\n" + 
		"296;Kloter Georg;1961;Urdorf;03:38:02.6;\n" + 
		"297;Koch Stephan;1969;Langnau am Albis;03:28:39.7;\n" + 
		"298;Kopp Martin;1967;Hedingen;03:17:15.1;\n" + 
		"300;Kreienb�hl Anna;1954;R�ti ZH;04:04:25.4;\n" + 
		"301;Kreienb�hl Fridolin;1954;R�ti ZH;03:51:50.0;\n" + 
		"302;Kuendig Christoph;1961;Turbenthal;04:18:39.9;\n" + 
		"303;Kulik Karsten;1972;Z�rich;03:07:13.8;\n" + 
		"304;Kunz Thomas;1963;D�llikon;03:47:52.3;\n" + 
		"305;Kunz Tommy;1961;Tenniken;04:00:43.7;\n" + 
		"306;Kuonen Kurt;1954;Lalden;03:16:10.8;\n" + 
		"307;Kurz Daniel;1967;Z�rich;03:42:28.9;\n" + 
		"308;Kuster Verena;1956;Adliswil;04:46:49.9;\n" + 
		"309;Laffer Urs;1959;Oensingen;03:48:15.5;\n" + 
		"310;Landolt Andreas;1965;Adliswil;03:19:46.2;\n" + 
		"311;Ledermann Martin;1976;Chur;04:51:42.7;\n" + 
		"313;N�ssli Dave;1968;Rutschwil-D�gerle;03:14:49.2;\n" + 
		"314;Graf Peter;1966;Z�rich;03:14:47.9;\n" + 
		"315;Lilley Darrel;1965;Remetschwil;04:16:09.6;\n" + 
		"316;Manning John;1962;Z�rich;03:38:25.5;\n" + 
		"318;Maslarevic Dragan;1967;W�denswil;04:45:37.9;\n" + 
		"319;Meier Pascal;1968;Z�rich;03:53:51.1;\n" + 
		"320;Meier Pius;1968;B�lach;05:24:48.8;\n" + 
		"321;Meier Robert;1953;Widen;03:58:11.2;\n" + 
		"322;Meyer Arthur;1949;Dietlikon;04:36:21.2;\n" + 
		"323;Meyer Christoph;1966;G�mligen;03:49:14.4;\n" + 
		"324;Meyer Dirk;1968;Z�rich;03:13:32.3;\n" + 
		"325;Meyer Stephan;1968;Wohlen AG;03:26:31.8;\n" + 
		"326;Milivojevic Ljubomir;1964;Birmensdorf ZH;03:04:44.1;\n" + 
		"327;Miller Barbara;1964;Z�rich;03:17:17.1;\n" + 
		"330;Mona Sergio;1950;Bellinzona;03:19:03.6;\n" + 
		"331;Monn Matilda;1959;Igis;03:59:34.9;\n" + 
		"332;M�ller Adrian;1971;Freienbach;03:54:32.6;\n" + 
		"333;M�ller Doris;1963;Cham;03:40:25.5;\n" + 
		"334;M�ller Thomas;1967;Jona;03:23:52.0;\n" + 
		"335;Ochsner Ren�;1964;Windisch;04:01:31.7;\n" + 
		"336;Patcas Michel;1952;Z�rich;03:53:53.1;\n" + 
		"337;Peric Frank;1965;Luzern;03:27:59.8;\n" + 
		"338;Pfister Matthias;1959;Thalwil;03:22:09.8;\n" + 
		"339;Prosdocimi Ivan;1969;Z�rich;03:46:41.9;\n" + 
		"340;P�rro Beat;1962;Kloten;03:44:25.9;\n" + 
		"341;Rau Dani;1964;Meilen;03:24:19.5;\n" + 
		"342;Renggli Thomas;1972;Z�rich;02:53:46.2;\n" + 
		"343;Helfenstein Alain;1984;Z�rich;03:44:44.0;\n" + 
		"344;Anderhalden Donnino;1984;Z�rich;03:44:01.1;\n" + 
		"346;Rezan Robert;1977;Uster;03:34:37.5;\n" + 
		"347;Rickli J�rg;1967;Schaffhausen;03:29:51.8;\n" + 
		"348;Rothen Franz;1963;D�rnten;03:25:01.6;\n" + 
		"349;R�thlisberger Alain P.;1967;Herrliberg;03:34:40.8;\n" + 
		"350;R�egg Beat;1961;Muri AG;03:26:53.1;\n" + 
		"351;R�egg Herbert;1961;Rothrist;03:23:31.0;\n" + 
		"352;Ruoss Sven;1982;Z�rich;03:06:32.8;\n" + 
		"353;Sandmeier Ueli;1970;Mettmenstetten;03:13:54.5;\n" + 
		"354;Saxer Peter;1949;Oetwil am See;03:45:15.0;\n" + 
		"355;Schaffer Bernard;1957;Conches;03:37:55.1;\n" + 
		"356;Schaub Werner;1970;Bachenb�lach;03:36:45.4;\n" + 
		"357;Schilling Hans;1953;Islikon;03:55:00.8;\n" + 
		"358;Appenzeller Ulrich;1967;Bubendorf;03:59:30.8;\n" + 
		"359;Fischer Reto;1967;Kappel SO;03:59:33.1;\n" + 
		"360;Schlatter Sonya;1964;Z�rich;04:18:26.3;\n" + 
		"361;Schmid Christian;1967;Berikon;03:00:53.9;\n" + 
		"362;Schmid Richard;1966;Paspels;02:58:46.7;\n" + 
		"363;Schuster Mathias;1968;Binningen;03:11:42.3;\n" + 
		"364;Seiler Hans;1950;Z�rich;03:37:28.8;\n" + 
		"365;Sp�ni Urs;1955;Schindellegi;04:22:38.1;\n" + 
		"366;Spiess Paul;1948;Uhwiesen;03:42:34.9;\n" + 
		"367;Stalder Martin;1955;Udligenswil;03:57:32.6;\n" + 
		"368;Steimann Ernst;1960;Gattikon;04:41:02.1;\n" + 
		"369;St�ckli Urs;1950;Rottenschwil;03:03:26.1;\n" + 
		"370;Straumann Urs;1970;St. Gallen;03:01:40.9;\n" + 
		"371;Studer Franz;1956;Inwil;04:17:49.1;\n" + 
		"372;Sturzenegger Daniel;1966;Z�rich;03:28:01.9;\n" + 
		"373;S�ssli Philipp;1966;Freidorf TG;03:08:02.0;\n" + 
		"374;Suter Kurt;1960;Goldau;03:46:46.6;\n" + 
		"375;Tanner Christian;1969;W�denswil;03:34:34.6;\n" + 
		"376;Taschi Sander;1970;Pf�ffikon ZH;03:36:13.3;\n" + 
		"377;Thalmann Martin;1976;Wetzikon ZH;03:49:11.2;\n" + 
		"378;Theiler Alois;1958;Oensingen;03:47:54.7;\n" + 
		"379;Tischer Georg;1968;Z�rich;04:44:08.7;\n" + 
		"380;Tramacere Enrico;1964;Z�rich;04:00:20.5;\n" + 
		"381;Veraguth Christian;1964;Waltensburg/Vuorz;05:29:08.8;\n" + 
		"382;Vetterli Thomas;1954;Wermatswil;04:16:32.9;\n" + 
		"383;Vogel Marco;1965;R�ti ZH;03:25:36.1;\n" + 
		"384;V�geli Thomas;1958;Bronschhofen;03:49:27.0;\n" + 
		"385;Vogt Urs;1959;W�renlingen;03:19:15.3;\n" + 
		"386;Voser Therese;1957;Wettingen;03:29:13.2;\n" + 
		"387;Vosseler Beat;1964;Gebenstorf;02:56:34.7;\n" + 
		"388;Waller Max;1950;K�niz;04:15:17.0;\n" + 
		"389;Walther Rita;1946;Glattbrugg;04:23:45.5;\n" + 
		"390;W�schle Stefan;1967;Neftenbach;03:15:35.3;\n" + 
		"391;Wenger Beat;1967;Felsberg;03:34:52.6;\n" + 
		"392;Wettstein Walter;1951;Brugg AG;04:53:57.7;\n" + 
		"393;Wild Ruedi;1970;Bubikon;03:27:44.3;\n" + 
		"394;Wyser Norbert;1956;Au ZH;03:26:23.0;\n" + 
		"395;Zahler Markus;1954;Fehraltorf;03:56:47.9;\n" + 
		"396;Zgraggen Walter;1957;Eglisau;03:33:11.9;\n" + 
		"397;Zimmermann Herbert;1951;D�ttingen;04:26:40.4;\n" + 
		"398;Zingg Marcel;1967;Therwil;03:45:33.1;\n" + 
		"399;Zollinger Thomas;1976;W�renlos;03:17:47.8;\n" + 
		"400;Zingg Matthias;1986;Geroldswil;03:28:26.8;\n" + 
		"402;Z�ger Fritz;1940;Embrach;04:20:41.2;\n" + 
		"403;Zurbuchen R�bi;1964;Pf�ffikon SZ;03:26:40.4;\n" + 
		"404;Alpiger Karl Jun.;1966;Gr�t (Gossau ZH);03:26:11.7;\n" + 
		"405;Amacher Tom;1975;Bern;03:54:37.7;\n" + 
		"406;Ammann Anton;1939;Winterthur;04:54:02.2;\n" + 
		"407;Ammann Hansruedi;1952;Bettwiesen;03:49:23.4;\n" + 
		"408;Anneler James;1935;Urdorf;04:59:47.5;\n" + 
		"409;Bailey Richard;1956;R�dlingen;03:24:29.3;\n" + 
		"411;Baumberger Rolf;1964;Z�rich;03:05:38.5;\n" + 
		"412;Uhler Remo;1962;Pf�ffikon SZ;04:13:30.8;\n" + 
		"413;Jaussi Lars;1974;K�snacht ZH;04:13:31.4;\n" + 
		"414;Baumgartner Peter;1961;Weiach;04:43:47.2;\n" + 
		"415;Bebie Bruno;1957;F�llanden;03:23:03.2;\n" + 
		"416;Beck Ren�;1960;Oberengstringen;04:21:30.0;\n" + 
		"417;Bergamin Roland;1961;Brunnen;03:24:28.6;\n" + 
		"418;Berger Beat;1975;Olten;02:42:27.0;\n" + 
		"419;Bertschinger Erwin;1962;Volketswil;03:24:17.3;\n" + 
		"420;Binder Peter;1956;Z�rich;03:49:11.9;\n" + 
		"421;Bischofberger Lukas;1981;Z�rich;03:17:26.2;\n" + 
		"422;B�hler Thomas;1963;Birmensdorf ZH;03:43:48.7;\n" + 
		"424;Borner Daniel;1963;M�nnedorf;04:51:53.1;\n" + 
		"425;Bosshard Roland;1970;Erlenbach ZH;03:18:10.3;\n" + 
		"426;Breitenmoser Stefan;1967;Appenzell;02:56:21.4;\n" + 
		"427;Brem Gabriella;1959;Seuzach;03:56:23.3;\n" + 
		"428;Huber Yvonne;1964;Steinmaur;04:27:59.6;\n" + 
		"429;Malischke Jacqueline;1963;Neerach;04:27:59.2;\n" + 
		"430;Brem Ruedi;1956;Winterthur;03:32:12.2;\n" + 
		"432;Bruhin Marino;1955;Langnau am Albis;03:32:43.9;\n" + 
		"433;Bryner Adrian;1953;Z�rich;04:06:52.1;\n" + 
		"434;B�rgi Matthias;1973;Z�rich;04:11:55.0;\n" + 
		"436;Christen David;1969;Gattikon;05:02:03.8;\n" + 
		"437;Ciprian Peter;1960;W�renlos;04:12:24.3;\n" + 
		"438;Conrad Otto;1963;Maienfeld;04:34:00.0;\n" + 
		"439;Conti Antonio;1953;M�riken AG;03:14:49.1;\n" + 
		"440;Della Rossa Hanspeter;1954;Siebnen;04:04:20.0;\n" + 
		"441;Dese� Katja;1964;Herrliberg;04:32:53.5;\n" + 
		"442;Dese� Thomas;1959;Herrliberg;03:52:05.9;\n" + 
		"443;Reichmuth Ruedi;1968;Richterswil;04:40:20.4;\n" + 
		"444;Mettler Martin;1982;Bischofszell;04:39:44.8;\n" + 
		"445;Ehrhard Andre;1946;Wettingen;03:29:17.4;\n" + 
		"446;Eigenmann Markus;1952;Horgen;03:40:47.1;\n" + 
		"447;Engeli Benjamin;1979;Seuzach;02:57:53.2;\n" + 
		"448;Etzold Liz;1956;Winkel;04:33:10.0;\n" + 
		"450;Flury Alois;1966;Einsiedeln;04:51:02.6;\n" + 
		"451;Frei Martin;1962;Zollikon;02:46:47.7;\n" + 
		"452;Geerdsema Jan;1960;D�llikon;04:32:20.6;\n" + 
		"453;Gloor Ruedi;1952;Thalwil;04:20:10.2;\n" + 
		"454;Grimm Sch�del Christia;1960;M�nnedorf;03:49:06.0;\n" + 
		"456;Hauck Rene;1969;Z�rich;03:28:20.9;\n" + 
		"457;Haupt Hanspeter;1953;Z�rich;04:20:51.3;\n" + 
		"458;Josty Adrian;1971;Hindelbank;04:59:25.2;\n" + 
		"459;Wieser Andreas;1957;Z�rich;04:59:26.2;\n" + 
		"460;Heer Andreas;1975;Winterthur;03:50:32.2;\n" + 
		"461;Hegner Connie;1967;Schmerikon;03:51:46.0;\n" + 
		"463;Huerlimann Markus;1949;R�schlikon;03:33:33.9;\n" + 
		"465;Jordi Christine;1963;Horgen;03:56:35.0;\n" + 
		"466;Juhasz Bruno;1972;St. Gallen;03:45:55.0;\n" + 
		"467;K�mpf Kurt;1958;Koblenz;03:57:28.5;\n" + 
		"468;Keller Andreas;1959;Gossau ZH;03:53:52.6;\n" + 
		"469;Keller Markus;1962;Gossau SG;03:14:12.6;\n" + 
		"470;Kern Jean-Pierre;1952;Z�rich;03:55:37.6;\n" + 
		"471;L�derach Peter;1953;Sulzbach;03:35:32.3;\n" + 
		"472;Landolt Fredi;1944;Zollikon;03:57:25.0;\n" + 
		"473;L�rtscher Robin;1978;Z�rich;03:29:19.5;\n" + 
		"474;Lutz Peter;1951;Glattfelden;04:39:56.3;\n" + 
		"476;M�chler Anton;1960;Siebnen;03:47:14.9;\n" + 
		"477;Manz Thomas;1963;Egg b. Z�rich;03:33:38.9;\n" + 
		"479;Meier Kurt;1949;St. Gallen;04:04:48.9;\n" + 
		"480;Meier Philipp;1969;Wettingen;03:32:31.2;\n" + 
		"481;Meile Urs;1953;Z�rich;04:10:32.5;\n" + 
		"482;Melchior Ursula;1959;Z�rich;03:46:13.7;\n" + 
		"484;M�nzenmaier Samuel;1965;Winterthur;02:58:03.2;\n" + 
		"485;N�geli Oliver;1972;Adliswil;03:45:17.4;\n" + 
		"486;Niederberger Martin;1976;Sarnen;03:55:45.4;\n" + 
		"487;Pfenniger Peter;1956;Henggart;03:55:37.5;\n" + 
		"488;Rhyn Andy;1969;Adliswil;03:28:54.3;\n" + 
		"489;Rieder Marcos;1959;Luzern;03:08:11.3;\n" + 
		"490;R�eger Urs;1951;Winterthur;03:19:30.1;\n" + 
		"492;Schreiber Christian;1976;B�lach;03:27:36.0;\n" + 
		"493;Sobaszkiewicz Markus;1966;Wetzikon ZH;04:06:39.1;\n" + 
		"495;Sonderer Marcel;1963;Kilchberg ZH;03:11:32.6;\n" + 
		"496;Spielmann Hans-Peter;1948;Gr�ningen;03:44:30.3;\n" + 
		"497;Steiner Ueli;1964;Wallisellen;03:56:34.9;\n" + 
		"498;St�ckli Silvia;1950;Uster;05:10:36.7;\n" + 
		"499;Straube Wolfgang;1961;W�denswil;03:42:04.6;\n" + 
		"500;Zielmann Sarah;1976;Z�rich;03:59:32.8;\n" + 
		"501;Suter Thomas;1957;Meilen;03:21:52.2;\n" + 
		"502;Sutter Fritz;1941;Bonstetten;04:23:39.4;\n" + 
		"503;Tschopp Andr�;1960;Z�rich;03:25:06.6;\n" + 
		"504;Utzinger Reto;1964;Uster;03:24:43.8;\n" + 
		"506;Waltl G�nther;1965;Meilen;03:28:29.0;\n" + 
		"507;Wartmann Matthias;1957;Z�rich;03:42:03.9;\n" + 
		"508;Wegmueller Marc Simon;1977;Z�rich;03:15:37.4;\n" + 
		"509;Wegm�ller Rolf;1950;Bolligen;03:15:38.6;\n" + 
		"510;Widmer Lucas;1959;Uitikon Waldegg;02:46:06.3;\n" + 
		"513;Bugmann Daniel;1957;Weisslingen;03:15:19.8;\n" + 
		"514;Dos Reis Romeo;1966;Hinteregg;03:34:55.0;\n" + 
		"515;Meier-Pfosi Marlies;1958;Chur;05:11:40.1;\n" + 
		"516;Schmid Beat;1964;Urdorf;04:19:03.8;\n" + 
		"517;Sicurelli Ernesto;1948;Davos Platz;03:26:25.5;\n" + 
		"518;Ulrich Beat;1958;Buttikon SZ;03:25:27.1;\n" + 
		"519;Bossi Daniel;1961;Zollikerberg;04:04:24.4;\n" + 
		"520;Coradi Reto;1969;Esslingen;03:38:27.0;\n" + 
		"522;Kaufmann Reto;1950;Urdorf;05:10:43.1;\n" + 
		"523;Margreth Pascal;1956;Adliswil;04:24:04.5;\n" + 
		"524;Schaffner Lukas;1969;Sch�nenwerd;03:35:23.0;\n" + 
		"525;Schatt Hansj�rg;1966;Maur;04:09:32.5;\n" + 
		"526;Schmid Ernst;1965;Udligenswil;02:51:07.9;\n" + 
		"527;Soland Benjamin;1967;M�nnedorf;03:31:59.2;\n" + 
		"528;Meier Stefan;1970;W�denswil;03:33:03.6;\n" + 
		"777;Herzog Margrit;1957;Ottenbach;03:57:45.0;\n" + 
		"801;Bartholdi Roger;1969;Z�rich;04:01:38.7;\n" + 
		"802;Lauber Gerold;1956;Z�rich;03:48:01.4;\n" + 
		"1001;Abegg Monica;1959;Uetikon am See;03:56:33.1;\n" + 
		"1002;Abeguile Juliette;1972;Z�rich;03:33:44.5;\n" + 
		"1004;Aerne Rusterholz Susan;1958;Thalwil;04:05:15.9;\n" + 
		"1006;Allemann Olivia;1974;Hedingen;04:12:36.4;\n" + 
		"1007;Altmann B�atrice;1974;Horgen;03:31:22.2;\n" + 
		"1008;Altwegg Fehr Susanne;1965;Affoltern am Albi;03:44:40.6;\n" + 
		"1011;Angst Nicole;1969;Wangen b. D�bendo;03:58:32.6;\n" + 
		"1012;Antener Doris;1958;D�dingen;03:47:33.4;\n" + 
		"1014;Arena Michaela;1978;Richterswil;04:12:27.7;\n" + 
		"1015;Arlitt Nicole;1976;Kloten;04:10:56.4;\n" + 
		"1016;Arnold Corinne;1972;Zug;03:28:30.5;\n" + 
		"1017;Arnold Ruth;1963;Adligenswil;03:24:42.8;\n" + 
		"1018;B�chle Karin;1980;Z�rich;03:47:12.8;\n" + 
		"1019;Bachmann Nicole;1986;Winterthur;03:47:13.8;\n" + 
		"1024;Ballamann Gudrun;1964;R�ti ZH;04:10:45.9;\n" + 
		"1025;Bannier Elsbeth;1963;Aesch BL;03:54:42.0;\n" + 
		"1026;B�ttig Ruth;1968;Schenkon;03:45:44.9;\n" + 
		"1031;Bebi Mirjam;1982;Z�rich;02:58:12.9;\n" + 
		"1032;B�guin Sandrine;1977;M�nnedorf;04:21:05.8;\n" + 
		"1035;Belk Brigitte;1968;Courlevon;04:04:51.2;\n" + 
		"1036;Bellgardt Sabine;1956;Hausen AG;04:21:17.8;\n" + 
		"1037;Bennett Nicole;1961;Niederhasli;04:53:22.1;\n" + 
		"1038;Benz Regula;1974;Wil SG;03:30:19.7;\n" + 
		"1039;Berchtold Marion;1972;Filet;03:45:48.0;\n" + 
		"1040;Berchtold Silvia;1951;Niederhasli;05:00:58.2;\n" + 
		"1044;Bienz Sabrina;1983;Horgen;03:54:02.0;\n" + 
		"1045;Bissig Katharina;1979;Wallisellen;03:57:07.4;\n" + 
		"1046;Blaeser Manelle;1976;Neuhausen am Rhei;04:05:37.7;\n" + 
		"1047;Blatter Priska;1965;Niederried b. Int;04:16:43.4;\n" + 
		"1048;Boehm Martina;1976;Walchwil;03:58:38.9;\n" + 
		"1050;Bolfing Petra;1970;Luzern;03:09:24.2;\n" + 
		"1051;Boos-Hautmann Andrea;1979;Kaltbrunn;04:16:17.6;\n" + 
		"1052;Borsatti Luciana;1959;Z�rich;04:39:50.9;\n" + 
		"1053;Bosshard Erika;1969;B�lach;04:21:35.5;\n" + 
		"1054;Bottesi Elisabeth;1960;Oetwil am See;04:11:56.3;\n" + 
		"1056;Brandenberg Monika;1965;Steffisburg;03:41:55.3;\n" + 
		"1057;Br�ndle Cindy;1977;Dielsdorf;04:07:53.1;\n" + 
		"1062;Br�lisauer Marianne;1968;Appenzell;03:09:16.8;\n" + 
		"1063;Brunner Jeannette;1968;Uster;03:38:03.1;\n" + 
		"1065;Bucher Yvonne;1974;Lachen SZ;04:04:11.0;\n" + 
		"1066;Buchser Marie-Louise;1965;Meinisberg;04:27:44.9;\n" + 
		"1067;Buehler Luzia;1982;Pf�ffikon ZH;03:37:34.9;\n" + 
		"1069;Bugmann Franziska;1971;Ennetbaden;04:04:06.0;\n" + 
		"1070;Buholzer Marlis;1958;Steffisburg;04:14:25.0;\n" + 
		"1071;Burgardt Sonja;1968;Hausen am Albis;03:53:53.8;\n" + 
		"1072;B�rge-Stahel Ursula;1966;Weissbad;04:21:06.2;\n" + 
		"1075;Busque Stephanie;1979;Z�rich;04:16:09.0;\n" + 
		"1078;Calic Manda;1961;Ebmatingen;04:01:57.7;\n" + 
		"1079;Camathias Heidi;1963;Trimmis;04:25:21.0;\n" + 
		"1081;Casagrande Ruth;1956;Luzern;03:47:47.4;\n" + 
		"1083;Cathomas Yvonne;1958;Allschwil;04:33:50.5;\n" + 
		"1084;Cavelti Gaby;1968;Speicher;03:32:08.7;\n" + 
		"1086;Claivaz Patricia;1979;Bern;04:57:11.2;\n" + 
		"1087;Clark Joan;1972;Basel;04:09:41.9;\n" + 
		"1088;Clematide Renate;1966;Z�rich;03:12:23.6;\n" + 
		"1093;Cotroneo Laura;1959;Collombey;04:40:20.6;\n" + 
		"1096;De Cristofaro Teresa;1966;Wattwil;04:31:18.3;\n" + 
		"1098;Deb�ly-Escher Raphaela;1963;Worben;03:56:36.2;\n" + 
		"1099;Deck-Meier Rosie;1964;Watt;04:00:35.9;\n" + 
		"1102;Diethelm Melanie;1988;Bubikon;04:43:21.4;\n" + 
		"1105;Dober Karin;1973;K�ssnacht am Rigi;03:41:48.9;\n" + 
		"1107;Dollerup Brit;1974;Menzingen;03:34:36.5;\n" + 
		"1109;Dossenbach Laura;1989;Jonen;03:48:51.4;\n" + 
		"1112;Ducrey Marie-Claire;1966;Neyruz FR;03:37:40.4;\n" + 
		"1115;Ecoffey Liliane;1973;Z�rich;04:26:32.2;\n" + 
		"1120;Emmenegger Sandra;1970;Arlesheim;03:52:23.9;\n" + 
		"1121;Emmenegger Tanja;1976;Muttenz;03:42:35.7;\n" + 
		"1122;Engeler-Z�llig Monika;1951;Einsiedeln;04:01:55.1;\n" + 
		"1123;Erismann Liliane;1967;Thalwil;04:09:57.5;\n" + 
		"1125;Eyerman Jennifer;1976;Basel;03:27:32.3;\n" + 
		"1127;Addea Jasmin;1981;Sch�ftland;03:43:23.5;\n" + 
		"1128;Fikarova Olga;1977;Brugg AG;04:14:49.8;\n" + 
		"1130;Fischer Marion;1970;Gippingen;04:05:54.4;\n" + 
		"1131;Fischknecht Sibylle;1971;Feldbach;03:30:21.3;\n" + 
		"1134;F�ller Fiona;1969;D�bendorf;04:27:12.9;\n" + 
		"1135;Forrer Brigitte;1968;Wollerau;03:43:13.4;\n" + 
		"1137;Forster Kundert Helen;1941;Richterswil;05:02:18.5;\n" + 
		"1139;Frankiny Denise;1979;Kappel SO;03:13:41.3;\n" + 
		"1140;Franz-Pfetzer Ursula;1961;Kreuzlingen;05:14:57.7;\n" + 
		"1141;Fratila Ana-Maria;1967;Buchs AG;04:06:41.1;\n" + 
		"1142;Frei Melanie;1990;Unterstammheim;03:54:41.0;\n" + 
		"1143;Frei Miriam;1978;Z�rich;04:43:31.6;\n" + 
		"1144;Frey Gaby;1976;Hausen am Albis;03:41:35.6;\n" + 
		"1145;Frey Viola;1969;Tuggen;04:03:08.5;\n" + 
		"1146;Frey-Martins Eli;1977;Winterthur;03:58:10.1;\n" + 
		"1147;Friederich-Baur Marian;1956;Basel;04:37:22.9;\n" + 
		"1148;Friedli Gertrud;1960;Z�rich;04:33:34.9;\n" + 
		"1150;Fritzsche Sandra;1979;W�denswil;04:01:35.4;\n" + 
		"1151;Fuchs Katharina;1967;Schaffhausen;04:16:29.9;\n" + 
		"1152;Fuchser Karin;1971;Unterentfelden;04:01:53.8;\n" + 
		"1154;Furrer-Theiler Imelda;1961;Einsiedeln;03:49:14.6;\n" + 
		"1155;Gagliardi Ulla;1973;Dietikon;04:09:39.5;\n" + 
		"1156;Gahlinger Chantal;1971;Bern;03:58:12.1;\n" + 
		"1157;G�hwiler Anita;1962;Degersheim;05:13:12.4;\n" + 
		"1158;G�hwiler Liselotte;1964;L�tisburg;03:16:54.3;\n" + 
		"1163;Gass Regina;1965;Z�rich;04:01:53.2;\n" + 
		"1164;Gattiker Irene;1958;Z�rich;04:11:34.3;\n" + 
		"1165;Gautschi Caroline;1967;Freienstein;04:13:10.1;\n" + 
		"1168;Gerth-Zellweger Trudi;1958;Thal;04:12:03.6;\n" + 
		"1169;Glaus Barbara;1978;Neftenbach;03:11:55.5;\n" + 
		"1171;Gleises Alice;1985;Z�rich;04:11:29.1;\n" + 
		"1172;Gloor Isabelle;1966;Scherz;03:57:49.9;\n" + 
		"1175;Goeree Michelle;1970;Z�rich;04:57:30.0;\n" + 
		"1176;Gomringer Nicole;1972;Seuzach;03:12:56.5;\n" + 
		"1177;Graf-Ganz Ursula;1956;Uster;04:26:49.8;\n" + 
		"1179;Graule Karin;1962;Schaffhausen;03:56:29.5;\n" + 
		"1182;Grosswiler Katrin;1985;Winterthur;04:01:13.2;\n" + 
		"1184;Guenat Raquel;1975;Z�rich;03:45:58.1;\n" + 
		"1186;H�cki Florence;1977;Z�rich;03:22:38.0;\n" + 
		"1187;H�gle Monika;1964;Biel/Bienne;04:49:05.5;\n" + 
		"1189;Hannay Jackie;1959;D�bendorf;03:48:34.5;\n" + 
		"1191;Hartmann Hanne;1957;Wettswil;04:05:53.4;\n" + 
		"1193;Haudenschild Barbara;1975;Oberbuchsiten;04:11:32.2;\n" + 
		"1194;H�usermann Anya;1980;Basel;03:41:17.8;\n" + 
		"1195;H�usler Eva;1982;Greifensee;03:39:02.5;\n" + 
		"1196;Hayoz Catherine;1965;Neyruz FR;03:40:32.0;\n" + 
		"1197;Hefti Eliane;1985;Z�rich;04:23:02.4;\n" + 
		"1200;Heim Tina;1975;Romanshorn;03:33:22.1;\n" + 
		"1202;Heiniger Daniela;1986;B�ren an der Aare;03:44:44.1;\n" + 
		"1203;Heiniger Elsbeth;1952;B�ren an der Aare;04:06:59.8;\n" + 
		"1205;Hersberger-Gsell Vera;1978;Basel;03:58:03.6;\n" + 
		"1206;Herwig Marie-Therese;1947;Arosa;04:11:08.1;\n" + 
		"1209;Hoffmann Dorothee;1966;M�nnedorf;04:08:14.4;\n" + 
		"1210;Hofmann Judith;1989;Gr�ningen;03:39:20.5;\n" + 
		"1213;H�glund Mikaela;1979;Cheseaux-Nor�az;02:59:13.3;\n" + 
		"1220;Hotz Sigrist Gabriela;1964;Eglisau;04:03:19.2;\n" + 
		"1222;Huber Alice;1991;La Chaux-de-Fonds;03:45:15.5;\n" + 
		"1224;Huber-Muhl Prisca;1969;Windisch;03:27:03.8;\n" + 
		"1225;H�bscher Sara;1980;Cham;04:06:30.3;\n" + 
		"1226;Huclova Sonja;1980;Z�rich;03:28:29.1;\n" + 
		"1229;Hunn Erika;1961;Au ZH;03:47:11.7;\n" + 
		"1231;Huwyler Renate;1969;H�nenberg;04:56:46.2;\n" + 
		"1232;In-Albon Wampfler Tina;1976;Basel;02:54:59.8;\n" + 
		"1233;Inglin Heidi;1971;Winterthur;04:08:25.3;\n" + 
		"1234;Insley-Darling Janet;1968;Richterswil;04:01:18.8;\n" + 
		"1235;Issakainen Vilma;1983;Verbier;03:59:57.6;\n" + 
		"1238;Jeker Sabine;1973;Jona;03:40:53.9;\n" + 
		"1239;Jenny Esther;1963;Winterthur;03:26:56.8;\n" + 
		"1240;Jenzer Nina;1985;Z�rich;04:33:15.5;\n" + 
		"1241;Jokl Franziska;1984;Winterthur;05:15:39.1;\n" + 
		"1244;Jud Daniela;1964;Sch�nis;04:10:28.8;\n" + 
		"1245;K�ch Silvia;1976;Scherz;04:03:47.1;\n" + 
		"1246;Kaderli Iris;1973;Salenstein;04:15:39.5;\n" + 
		"1247;Kaetzke Philomela;1973;Z�rich;03:48:35.9;\n" + 
		"1249;Kaltenrieder Margrit;1956;D�dingen;03:25:23.4;\n" + 
		"1250;Kamm Heidy;1960;Z�rich;04:56:29.1;\n" + 
		"1251;K�ppeli Helena;1968;Merenschwand;03:59:34.3;\n" + 
		"1253;Karremans Jeannette;1969;Wasterkingen;03:33:33.0;\n" + 
		"1255;Keller Jacqueline;1962;Gebenstorf;03:09:10.5;\n" + 
		"1257;Keller-Noser Nicole;1968;Gossau SG;04:21:59.9;\n" + 
		"1258;Kellerhals Luzia;1974;Niederbipp;03:30:14.3;\n" + 
		"1259;Kern Beatrice;1969;Wollerau;04:32:41.8;\n" + 
		"1263;Keup Verena;1969;Z�rich;04:34:54.3;\n" + 
		"1265;Kirchhof Frizzi;1982;Z�rich;03:57:05.6;\n" + 
		"1266;Kleinlaut Karin;1974;Matt;03:56:20.7;\n" + 
		"1273;Knuchel Patrizia;1978;Galgenen;03:13:21.6;\n" + 
		"1274;Koch Tamara;1988;Dietikon;04:00:47.4;\n" + 
		"1278;Kramer Jutta;1972;Biberist;03:57:31.5;\n" + 
		"1281;Krebs-Stickel Sandra;1961;Z�rich;04:03:03.0;\n" + 
		"1286;Krummenacher Brigitte;1978;Sarnen;04:00:52.9;\n" + 
		"1287;Kubli Rebekka;1976;Langnau am Albis;04:07:21.4;\n" + 
		"1288;K�ffner Marianne;1972;Stetten AG;03:36:19.5;\n" + 
		"1290;Kuhn Patricia;1972;St. Pantaleon;04:05:17.5;\n" + 
		"1291;Kunz Sibylle;1973;H�nenberg See;03:50:46.1;\n" + 
		"1292;Lacher Priska;1963;Trachslau;03:22:38.7;\n" + 
		"1294;Landolt Bernadette;1964;Z�rich;03:54:31.3;\n" + 
		"1297;Lanner Regina;1976;Schaffhausen;04:20:58.1;\n" + 
		"1303;Lehner Christa;1985;Kilchberg ZH;04:44:59.2;\n" + 
		"1305;Leitmann Petra;1977;R�schlikon;04:13:02.7;\n" + 
		"1309;Lewis Anne;1957;Pf�ffikon SZ;05:07:56.6;\n" + 
		"1315;Litzius Denise;1980;Binningen;04:16:19.8;\n" + 
		"1316;Long Lisbeth;1944;Fehraltorf;05:28:42.2;\n" + 
		"1317;Loretz Manuela;1986;Erstfeld;03:27:22.2;\n" + 
		"1318;L�thi Lisa;1969;Thun;03:52:40.7;\n" + 
		"1320;Maag-Hegetschweiler Ch;1967;Dietikon;03:32:15.8;\n" + 
		"1322;Maggini Esther;1950;W�denswil;04:35:40.9;\n" + 
		"1324;Marti Rosmarie;1959;Bettlach;04:46:36.4;\n" + 
		"1326;Matz Brigitte;1959;St-L�gier;03:27:20.3;\n" + 
		"1328;Mazzolini Mbenda Betti;1970;Glarus;04:02:53.3;\n" + 
		"1331;Meier Gisela;1982;B�lach;04:20:56.8;\n" + 
		"1332;Meier Isabel;1962;Horgen;03:54:29.6;\n" + 
		"1333;Meier Jessica;1984;Z�rich;03:47:11.8;\n" + 
		"1334;Allemann Isabelle;1982;Aarburg;03:20:13.7;\n" + 
		"1335;Meister Franziska;1965;Dachsen;03:43:43.8;\n" + 
		"1336;Messmer Monika;1968;Hinwil;04:43:05.6;\n" + 
		"1338;Metzger H�bi;1954;Eschenz;03:56:50.5;\n" + 
		"1340;Michel Ir�ne;1959;Z�rich;04:40:33.3;\n" + 
		"1343;Mlekusch Sabine;1977;Bern;04:57:10.7;\n" + 
		"1344;M�ckli Ruth;1956;Uitikon Waldegg;04:55:14.3;\n" + 
		"1345;Modoux Liliane;1963;Feuerthalen;04:33:28.4;\n" + 
		"1347;M�hldorfer Annette;1970;Z�rich;03:58:49.9;\n" + 
		"1348;Morf Doris;1968;Frenkendorf;04:46:54.3;\n" + 
		"1349;Mosetti Michelle;1960;Froideville;04:21:30.0;\n" + 
		"1350;Muggleton Belinda;1968;Z�rich;04:18:22.4;\n" + 
		"1351;B�rtsch Edith;1983;Heiligkreuz (Mels;03:40:14.9;\n" + 
		"1354;M�ller Jennifer;1984;Frenkendorf;03:29:58.2;\n" + 
		"1355;M�ller Sandra;1970;Birmensdorf ZH;03:31:42.8;\n" + 
		"1359;N�f Esther;1973;Adliswil;04:04:42.8;\n" + 
		"1360;Nakanishi Yoshiko;1978;Versoix;04:26:51.9;\n" + 
		"1361;Nardiello Selina;1972;Birsfelden;03:43:57.5;\n" + 
		"1363;Neidhart Jana;1983;Winterthur;03:36:45.1;\n" + 
		"1365;Nelson Christen;1981;Fr�msen;03:24:28.6;\n" + 
		"1368;Baumann Flavia;1990;Flawil;03:50:36.9;\n" + 
		"1369;Neri Claudia;1979;Z�rich;03:52:57.9;\n" + 
		"1370;Neustadt Rita;1964;Grindelwald;03:35:23.3;\n" + 
		"1372;Niederberger Fr�nzi;1951;Ennetmoos;03:54:18.1;\n" + 
		"1373;Niederberger Trudi;1953;Uster;04:39:30.0;\n" + 
		"1374;Niederhauser Dami;1971;Binningen;04:14:27.6;\n" + 
		"1375;Nielsen Birgitte;1963;Zug;03:44:22.1;\n" + 
		"1378;O'Neill Annemarie;1983;Z�rich;04:10:48.7;\n" + 
		"1379;Odenbach Mary;1963;M�hlin;03:50:44.8;\n" + 
		"1382;Oneta Cristina;1963;Adliswil;04:07:10.3;\n" + 
		"1383;Ossowska Maria;1986;Wollerau;03:57:34.6;\n" + 
		"1384;Padberg Barbara;1961;Chur;03:46:42.8;\n" + 
		"1385;Paganini Chiara;1990;Gossau SG;04:16:43.3;\n" + 
		"1390;Praz Maria;1960;Sion;04:26:42.8;\n" + 
		"1393;Pulver Barbara;1965;Niederscherli;03:21:09.7;\n" + 
		"1395;Purtschert Amanda;1980;Bellinzona;04:07:03.6;\n" + 
		"1396;Rada Marianne;1963;Samstagern;03:51:41.6;\n" + 
		"1398;Rakic Silvia;1982;Adliswil;04:25:10.4;\n" + 
		"1400;Rechsteiner Sandra;1981;Niederb�ren;03:23:42.4;\n" + 
		"1401;Recine Lisa;1960;Z�rich;04:33:10.5;\n" + 
		"1402;Reinhold Irene;1964;Greifensee;03:57:05.1;\n" + 
		"1405;Renggli Conny;1972;Alpnach Dorf;04:23:09.5;\n" + 
		"1407;Reusser Christine;1963;Scherz;04:08:57.5;\n" + 
		"1408;Rhomberg Birgitta;1963;Z�rich;03:29:49.0;\n" + 
		"1409;Richards Shola;1975;Z�rich;05:05:02.8;\n" + 
		"1410;Riga Petra;1970;Stallikon;03:30:53.5;\n" + 
		"1413;Ringger Christa;1980;Z�rich;04:14:44.5;\n" + 
		"1414;Rippstein Hilde;1958;Baden;04:02:11.3;\n" + 
		"1415;Riva Anita;1965;Eglisau;04:57:03.1;\n" + 
		"1418;Rosenast Andrea;1970;Horgen;03:33:20.5;\n" + 
		"1419;Rosenberger Thekla;1957;Aarau;04:03:36.2;\n" + 
		"1420;Rossi Marianne;1977;Baden;03:43:50.4;\n" + 
		"1421;Roth Barbara;1964;Z�rich;04:38:53.2;\n" + 
		"1424;R�eger Riikka;1972;Lufingen;04:10:10.9;\n" + 
		"1425;R�egg Kim;1983;Z�rich;04:11:34.6;\n" + 
		"1426;Ruesch Caroline;1968;Basel;04:28:02.8;\n" + 
		"1429;Russenberger Doris;1974;Winterthur;03:13:34.4;\n" + 
		"1430;Russo Andrea;1966;Z�rich;04:41:49.5;\n" + 
		"1431;Rutishauser Cornelia;1976;Lachen SZ;04:28:46.0;\n" + 
		"1436;Saly Katrin;1975;Z�rich;03:31:23.0;\n" + 
		"1437;Schaub Andrea;1968;Hinwil;04:08:39.9;\n" + 
		"1438;Scheiwiller Margrit;1941;Amriswil;05:03:02.2;\n" + 
		"1440;Schenkel Gabriela;1977;Z�rich;03:34:02.3;\n" + 
		"1441;Schenkel Karin;1971;Stein am Rhein St;04:13:08.8;\n" + 
		"1442;Scherer Cornelia;1958;Bolligen;04:27:02.8;\n" + 
		"1445;Schild-Leuthold Juliet;1978;Bern;02:57:44.4;\n" + 
		"1452;Schneider Anne;1970;Hinteregg;04:01:13.0;\n" + 
		"1453;Schneider Monica;1964;Kilchberg ZH;03:59:27.5;\n" + 
		"1455;Sch�lly Deborah;1988;Zurzach;04:39:56.0;\n" + 
		"1458;Schudel Jacqueline;1987;Embrach;04:27:00.3;\n" + 
		"1459;Sch�lin Sabina;1969;Aeugst a.A.;03:47:19.8;\n" + 
		"1461;Schwander Gabriela;1958;W�renlos;04:14:55.3;\n" + 
		"1463;Schwarzentruber Cornel;1981;Menznau;03:45:09.2;\n" + 
		"1465;Schwegler Nicole;1975;Fehraltorf;03:42:48.1;\n" + 
		"1466;Schwerzmann Mich�le;1966;Brissago;03:17:01.7;\n" + 
		"1470;Seiler Sonja;1964;Burgdorf;03:09:36.5;\n" + 
		"1471;Seitz Judith;1962;Dietikon;04:00:13.6;\n" + 
		"1472;Senn Claudia;1976;Olten;03:45:32.6;\n" + 
		"1474;Siegenthaler Brigitte;1964;Oberentfelden;03:48:24.8;\n" + 
		"1475;Siegfried Anita;1962;Freidorf TG;04:14:01.9;\n" + 
		"1476;Sigrist Jeannette;1976;Oberwil BL;03:36:39.8;\n" + 
		"1477;Simmen Sabine;1980;Winterthur;03:24:12.0;\n" + 
		"1479;Skreckova Denisa;1981;Birr-Lupfig;03:51:43.8;\n" + 
		"1482;Smith Sarah;1975;Z�rich;03:52:56.6;\n" + 
		"1483;Sobrino Karen;1972;St. Gallen;03:26:49.4;\n" + 
		"1488;Stadler Eufemia;1956;Z�rich;04:16:10.4;\n" + 
		"1489;St�ger Marianne;1976;Z�rich;03:46:56.2;\n" + 
		"1491;Stampfer Brigitte;1976;St. Gallen;04:19:50.8;\n" + 
		"1496;Steiger Birgit;1960;Wangen b. D�bendo;04:31:36.7;\n" + 
		"1497;Steimann Dana;1958;Gattikon;04:48:23.3;\n" + 
		"1498;Steiner Marianne;1974;Lachen SZ;03:12:17.5;\n" + 
		"1499;Stettler-Brotschi Clau;1974;Grenchen;04:13:17.0;\n" + 
		"1500;Stich Isabelle;1988;Z�rich;04:11:38.4;\n" + 
		"1501;St�ckli Jolanda;1973;Stans;04:04:16.1;\n" + 
		"1502;St�ckli Mara;1984;Pfaffhausen;03:46:21.8;\n" + 
		"1504;Streule Eliane;1967;Appenzell;04:28:34.0;\n" + 
		"1506;Strub Kunz Jr�ne;1966;Tenniken;03:56:17.7;\n" + 
		"1507;Studer Cornelia;1976;Zuzwil SG;03:29:55.4;\n" + 
		"1508;Surber Tanja;1985;Urdorf;03:33:44.2;\n" + 
		"1509;Symonds Rebecca;1977;Z�rich;03:54:16.6;\n" + 
		"1510;Szlavik Vanda;1979;Zollikerberg;03:52:35.9;\n" + 
		"1511;Tan Siew;1946;Dietikon;04:40:39.9;\n" + 
		"1513;Tellefsen Tina;1971;Zumikon;03:28:51.4;\n" + 
		"1514;Theiler Nadia;1984;Sursee;04:04:38.6;\n" + 
		"1515;Tholen Anna;1977;Z�rich;03:54:26.7;\n" + 
		"1516;Thoma Erika;1973;Uitikon Waldegg;03:53:09.7;\n" + 
		"1517;Tiebout Isabelle;1971;Horgen;03:53:32.2;\n" + 
		"1518;Tietz Julia;1973;Schlieren;03:16:22.2;\n" + 
		"1520;Toledano Marisol;1968;Rapperswil SG;04:12:36.5;\n" + 
		"1521;Toumani Jenna;1986;Nyon;03:41:53.4;\n" + 
		"1526;Tricarico Gabi;1969;Flawil;03:07:35.1;\n" + 
		"1528;Trovato Carmela;1965;Hinteregg;03:48:41.6;\n" + 
		"1531;Ulrich Katharina;1967;Jegenstorf;03:47:35.1;\n" + 
		"1532;Urbach Deborah;1981;Z�rich;04:27:53.8;\n" + 
		"1534;van Rijs Ursula;1974;Bern;04:57:03.0;\n" + 
		"1535;Vasilache Cristina;1979;Z�rich;03:49:57.6;\n" + 
		"1536;Vermeulen Helene;1950;Wetzikon ZH;04:37:14.6;\n" + 
		"1539;Villiger Sonja;1971;Birmensdorf ZH;04:04:59.3;\n" + 
		"1541;Vocke Daniela;1976;Z�rich;04:27:03.6;\n" + 
		"1542;Voegeli Nico;1986;Lampenberg;03:55:29.7;\n" + 
		"1543;Voigt Cornelia;1976;Mettmenstetten;04:29:36.7;\n" + 
		"1544;Volfsch�tz Simona;1980;Mettlen;03:43:40.1;\n" + 
		"1545;von Mandach Annette;1970;Herisau;03:40:33.3;\n" + 
		"1546;von Niederh�usern Cris;1971;Ipsach;04:39:56.5;\n" + 
		"1547;Vopat Johanna;1974;Oberglatt ZH;04:08:22.7;\n" + 
		"1548;Wachter Karin D.;1963;Wettswil;03:38:58.7;\n" + 
		"1549;Wackernagel Britta;1961;Kleind�ttingen;04:23:01.6;\n" + 
		"1550;Walder Darja;1969;Basel;03:57:22.1;\n" + 
		"1551;Wartenberg Alexandra;1984;Kilchberg ZH;04:39:44.3;\n" + 
		"1552;Washington Caroline;1964;Z�rich;04:36:48.4;\n" + 
		"1554;Weber Tosca;1972;Schlieren;04:33:11.8;\n" + 
		"1555;Weiersm�ller Jacquelin;1963;Kilchberg ZH;04:10:53.8;\n" + 
		"1556;Weiler Katja;1968;Birr-Lupfig;04:42:27.7;\n" + 
		"1558;Welbergen Louisa;1986;Z�rich;03:08:03.9;\n" + 
		"1561;Werner Stephanie;1974;Thalwil;03:40:08.7;\n" + 
		"1562;Werthm�ller Gabriele;1974;Zuchwil;03:09:45.3;\n" + 
		"1564;Wettstein Edith;1961;Z�rich;04:19:31.1;\n" + 
		"1565;Wey Mirjam;1965;Nuglar;04:16:23.0;\n" + 
		"1566;Widmer Monika;1968;Z�rich;03:22:33.7;\n" + 
		"1567;Wiedmer Christine;1965;Bubendorf;04:09:04.6;\n" + 
		"1569;Wild Irene;1961;Oberdiessbach;04:40:20.9;\n" + 
		"1571;Winklehner Anna;1984;Z�rich;03:50:53.8;\n" + 
		"1574;Wittwer Gertrud;1950;Z�rich;04:08:44.0;\n" + 
		"1576;Wyler Karin;1971;Niederwil AG;03:35:51.3;\n" + 
		"1577;Wyss Ingrid;1953;Dulliken;04:44:13.8;\n" + 
		"1578;Wyss Sonja;1974;Niederbipp;04:07:25.2;\n" + 
		"1580;Zaugg Sibil;1966;Bern;03:51:58.2;\n" + 
		"1581;Zeller Seline;1994;Appenzell;03:47:18.3;\n" + 
		"1582;Zenger Daniela;1982;Zollikofen;04:26:55.5;\n" + 
		"1583;Ziegler Isabella;1978;Oberhelfenschwil;03:41:15.8;\n" + 
		"1585;Zingg Karin;1969;M�hlin;03:16:04.1;\n" + 
		"1586;Zuber Helen;1961;St. Gallen;03:36:41.9;\n" + 
		"1587;Zuber Sabrina;1987;Glattpark (Opfiko;04:35:32.4;\n" + 
		"1589;Zwicker Selinda;1960;St. Gallen;03:26:18.7;\n" + 
		"1592;Brazerol Carmen;1976;D�bendorf;03:37:38.4;\n" + 
		"1593;Bucher Sylvie;1965;Cham;03:51:22.5;\n" + 
		"1597;Freiburghaus Rahel;1983;Z�rich;03:53:47.1;\n" + 
		"1598;G�tsch Helen;1961;Berg TG;03:51:34.2;\n" + 
		"1599;G�ntzel Sara;1969;Z�rich;03:25:25.7;\n" + 
		"1600;Gurtner Susanne;1965;Luzern;03:52:40.0;\n" + 
		"1602;Hauser-Ruckli Cornelia;1968;Fr�schels;03:39:46.5;\n" + 
		"1603;Heimbs Anette;1977;Bergdietikon;04:36:24.5;\n" + 
		"1606;Inauen Fr�nzi;1986;Luzern;03:14:21.5;\n" + 
		"1609;Jaggi Theres;1950;Gossau SG;04:55:33.0;\n" + 
		"1610;Janser Susanne;1959;Niederhasli;04:13:22.6;\n" + 
		"1611;J�rg Regina;1965;Oberdorf BL;03:43:22.1;\n" + 
		"1612;Kern Alexandra;1983;Pf�ffikon SZ;04:41:12.4;\n" + 
		"1613;Kolhaupt Tanja;1979;Z�rich;04:26:48.7;\n" + 
		"1614;Landolt Christina;1962;Z�rich;04:12:17.6;\n" + 
		"1616;Lienhard Sonja;1968;Teufen ZH;03:30:23.9;\n" + 
		"1620;M�ntener Brigitte;1965;B�lach;03:55:51.9;\n" + 
		"1622;Ochieng Pernet Awilo;1965;Ecuvillens;04:17:59.9;\n" + 
		"1624;Peer Sandy;1969;Uerikon;03:31:59.1;\n" + 
		"1625;Polinelli Christina;1969;W�renlos;03:34:40.5;\n" + 
		"1626;Queralto Cristina;1978;Burtigny;03:50:26.5;\n" + 
		"1627;Ramsay Julie;1974;Wettswil;04:54:41.0;\n" + 
		"1628;R�thisberger C�line;1988;Lyss;04:21:20.7;\n" + 
		"1629;R�egger Andrea;1974;Kappel SO;04:31:24.6;\n" + 
		"1630;R�timann Gabriela;1964;B�lach;03:51:33.9;\n" + 
		"1631;Scheitlin Julie;1983;Z�rich;04:11:09.3;\n" + 
		"1632;Schiess Gabriela;1969;Bassersdorf;03:23:41.8;\n" + 
		"1633;Schillig-Planzer Stefa;1967;Altdorf UR;03:04:46.4;\n" + 
		"1635;Schlegel Alexandra;1981;Weite;03:24:22.5;\n" + 
		"1636;Schmid Catherine;1961;Kloten;03:56:28.3;\n" + 
		"1637;Schmid Conny;1969;Weinfelden;03:08:27.9;\n" + 
		"1638;Schrott Andrea;1975;Wetzikon ZH;03:53:30.9;\n" + 
		"1639;Schumacher Sandra;1968;Klingnau;03:53:25.1;\n" + 
		"1640;Senn Brigitte;1969;Romanshorn;04:09:12.6;\n" + 
		"1642;Sommer Daniela;1968;Sempach Stadt;03:04:31.1;\n" + 
		"1643;Sonderegger Tanja;1982;Rotkreuz;03:20:13.9;\n" + 
		"1644;Stalder Caroline;1980;Greifensee;03:44:15.9;\n" + 
		"1645;Steiner Denise;1982;Eggenwil;04:48:42.2;\n" + 
		"1646;Stoppiello Banu;1977;Chavornay;04:27:05.5;\n" + 
		"1647;Stucki Sonja;1964;R�schlikon;03:27:03.9;\n" + 
		"1648;Tambini Irma;1961;Jona;03:50:24.4;\n" + 
		"1649;Tangorra Sabrina;1970;Winterthur;04:21:32.4;\n" + 
		"1650;Tschannen Nathalie;1967;Basel;04:27:15.2;\n" + 
		"1655;Wiederkehr Denise;1983;Siebnen;04:41:12.9;\n" + 
		"1656;Z�hnler Bircher Silvia;1968;Chur;04:27:22.4;\n" + 
		"1657;Zanetti Windegger Lara;1967;Uitikon Waldegg;03:26:56.9;\n" + 
		"1658;Zehnder Corinne;1986;Z�rich;04:42:04.4;\n" + 
		"1660;Antila Heidi;1976;Hettlingen;05:04:33.0;\n" + 
		"1663;Flockerzi Martina;1979;St. Gallen;04:03:55.2;\n" + 
		"1664;Kieran Rose;1969;Z�rich;04:05:28.3;\n" + 
		"1665;Merz Beatrix;1973;W�denswil;03:40:06.9;\n" + 
		"1666;Minard Delphine;1984;Luzern;04:14:28.2;\n" + 
		"1668;Schoch Katharina;1952;St�fa;04:12:52.0;\n" + 
		"1669;Steiger Susanne;1976;Chur;04:12:15.1;\n" + 
		"1670;von Rotz Madeleine;1985;Z�rich;03:58:13.6;\n" + 
		"1672;Fischer Muriel;1989;Bremgarten AG;04:33:00.6;\n" + 
		"1674;K�pfli Stephanie;1968;H�nenberg See;03:49:57.6;\n" + 
		"1952;Walser Hans;1952;St�fa;03:56:38.0;\n" + 
		"2001;Abderhalden Claude;1982;Suhr;03:41:42.6;\n" + 
		"2002;Abdo Osman;1982;Cham;02:58:00.5;\n" + 
		"2003;Abegglen Timon;1983;Windisch;03:58:34.4;\n" + 
		"2004;Abgottspon Benjamin;1987;Horgen;04:50:43.5;\n" + 
		"2007;Achermann Alois;1972;Alpnach Dorf;03:58:12.6;\n" + 
		"2008;Ackermann Michael;1970;Mels;03:18:34.7;\n" + 
		"2009;Adler Ruedi;1951;Z�rich;03:31:56.7;\n" + 
		"2010;Adler Sandro;1980;Z�rich;04:27:06.5;\n" + 
		"2012;Aebersold Thomas;1963;Z�rich;04:14:11.4;\n" + 
		"2013;Aebi Hansj�rg;1966;Staffelbach;04:12:29.4;\n" + 
		"2015;Aeby Pascal;1967;F�tigny;03:48:08.2;\n" + 
		"2016;Aegerter Michael;1974;Egg b. Z�rich;04:45:55.9;\n" + 
		"2017;Aeschlimann Martin;1964;Heimberg;03:49:39.1;\n" + 
		"2018;Affentranger Fernando;1959;Z�rich;03:58:24.0;\n" + 
		"2020;Agostini Bernardo;1964;Wetzikon ZH;03:51:52.9;\n" + 
		"2021;Ait Bahassou Mohamed;1965;Winterthur;03:05:18.4;\n" + 
		"2022;Akeret Martin;1975;Winterthur;02:59:54.0;\n" + 
		"2023;Akermann Elmar;1970;Bernhardzell;04:13:06.1;\n" + 
		"2025;Albers Vincent;1956;Z�rich;03:14:20.7;\n" + 
		"2026;Albin Basil;1944;Falera;04:10:33.7;\n" + 
		"2027;Albin Norbert;1956;Hinteregg;03:56:43.3;\n" + 
		"2028;Albin Silvan;1992;Falera;04:10:34.6;\n" + 
		"2030;Alder Daniel;1962;Z�rich;04:41:19.3;\n" + 
		"2031;Alder Ernesto;1954;Gossau SG;03:59:27.8;\n" + 
		"2032;Alfassi Sami;1966;Dietikon;03:48:59.5;\n" + 
		"2033;Allemann Patrick;1973;Hedingen;04:18:55.4;\n" + 
		"2036;Alpiger Patrick Michae;1968;Z�rich;03:55:21.8;\n" + 
		"2039;Amacker Hugo;1962;Binningen;03:42:20.5;\n" + 
		"2041;Amb�hl Dany;1989;M�nnedorf;04:33:00.9;\n" + 
		"2042;Amstalden Guido;1955;Sarnen;03:50:47.7;\n" + 
		"2043;Amstutz Jean-Luc;1954;Vugelles-La Mothe;03:19:09.6;\n" + 
		"2046;Andenmatten Cyril;1971;Basel;03:43:33.6;\n" + 
		"2048;Anderegg Kurt;1969;M�nchaltorf;03:54:38.2;\n" + 
		"2050;Andres Peter Thomas;1985;Z�rich;03:20:56.6;\n" + 
		"2051;Andrews John;1950;Wollerau;03:33:53.3;\n" + 
		"2054;Anneler Albert;1962;Schlieren;04:59:47.1;\n" + 
		"2055;Antweiler Ralf;1970;Illnau;03:13:22.8;\n" + 
		"2056;Arbenz Beat;1965;Hettlingen;03:42:12.2;\n" + 
		"2058;Aretano Aldo;1967;Effretikon;04:30:15.4;\n" + 
		"2060;Arm Ueli;1960;Burgdorf;03:32:38.9;\n" + 
		"2063;Arnold Philipp;1987;Cham;02:41:46.9;\n" + 
		"2064;Artan Ayhan;1967;Baden;03:16:46.4;\n" + 
		"2067;Aurag Daniel;1960;M�nnedorf;03:45:18.9;\n" + 
		"2070;Azzato Remo;1979;Uster;04:20:56.2;\n" + 
		"2071;B�bler Ruedi;1954;Engi;04:32:46.8;\n" + 
		"2073;Bachmann Markus;1966;Zug;03:01:39.2;\n" + 
		"2074;Bachmann Markus;1967;Schlieren;03:56:19.8;\n" + 
		"2075;Bachmann Rolf;1963;H�tten;03:49:30.5;\n" + 
		"2076;B�chthold Jj;1977;Z�rich;04:20:38.4;\n" + 
		"2077;Baco Uwe;1968;Z�rich;03:27:34.1;\n" + 
		"2078;Bader Sandro;1979;Dielsdorf;03:45:03.5;\n" + 
		"2080;Badertscher Christian;1976;Seuzach;03:40:18.2;\n" + 
		"2081;Badorff Cornel;1968;Winterthur;03:27:32.8;\n" + 
		"2082;Baer Tobias;1973;M�nnedorf;03:16:28.8;\n" + 
		"2083;Baeriswyl Ren�;1967;Z�rich;04:07:47.5;\n" + 
		"2084;Bahl Alexander;1977;Z�rich;04:26:05.3;\n" + 
		"2085;Bahner Bertram;1959;Ober�geri;03:20:11.2;\n" + 
		"2087;Bako Barnabas;1976;Uetikon am See;04:34:08.5;\n" + 
		"2088;Bamert Rafael;1982;B�lach;03:32:01.0;\n" + 
		"2089;Bangerter Adrian;1980;Greifensee;03:08:16.8;\n" + 
		"2090;Bannier Marcel;1955;Aesch BL;03:39:04.9;\n" + 
		"2091;B�nninger Andy;1973;Winterthur;03:17:49.5;\n" + 
		"2096;B�rtsch Jonas;1981;Glattbrugg;04:26:32.4;\n" + 
		"2097;Baschera Matteo;1990;Z�rich;03:39:47.5;\n" + 
		"2100;Basler Michael;1974;M�rstetten;03:45:33.0;\n" + 
		"2105;Bauer J�rgen;1967;Horgen;04:17:56.1;\n" + 
		"2106;Bauer Mathias;1992;Auvernier;03:35:49.3;\n" + 
		"2107;Bauert Stephan;1972;D�ttlikon;03:20:28.6;\n" + 
		"2108;Baumann David;1972;Amriswil;03:13:50.4;\n" + 
		"2109;Baumann Reto;1971;Allschwil;03:23:53.3;\n" + 
		"2110;Baumgartner Benjamin;1984;Weiach;03:11:34.9;\n" + 
		"2111;Baumgartner Christoph;1982;Bern;03:02:43.1;\n" + 
		"2112;Colombani Jonathan;1980;Lausanne;03:02:45.8;\n" + 
		"2113;Baumgartner Philipp;1988;Zurzach;03:14:08.0;\n" + 
		"2115;B�umler Werner;1953;Wetzikon ZH;03:59:00.8;\n" + 
		"2116;Baumstark Achim;1964;R�schlikon;03:24:55.8;\n" + 
		"2117;Baur Sigrist Dieter;1955;Pratteln;04:00:33.8;\n" + 
		"2118;Bayer Claudio;1975;Wilen b. Wollerau;04:13:54.3;\n" + 
		"2119;Bebi Michael;1977;Uster;04:30:52.3;\n" + 
		"2123;Beeler Karl;1959;Rothenthurm;02:48:41.2;\n" + 
		"2124;Beeli Gian;1981;Domat/Ems;04:27:39.3;\n" + 
		"2125;Beer Patrick;1990;Spiegel b. Bern;04:22:37.2;\n" + 
		"2127;Beglinger Michael;1960;Mollis;04:27:45.7;\n" + 
		"2128;Beglinger Urs;1985;Glarus;03:18:09.9;\n" + 
		"2129;Belk Thomas;1962;Courlevon;04:26:06.6;\n" + 
		"2131;Benfatto Alessandro;1973;M�nsingen;03:42:59.3;\n" + 
		"2133;Benz Andy;1965;Adetswil;02:48:55.1;\n" + 
		"2135;Berg Christian;1955;Uerikon;03:27:36.3;\n" + 
		"2136;Berger Gedeon;1968;Z�rich;04:12:06.3;\n" + 
		"2137;Berger Olivier;1965;Auenstein;03:44:03.2;\n" + 
		"2138;Berger Walo;1972;Sessa;04:08:34.0;\n" + 
		"2141;Bernet Heiri;1968;Luzern;03:03:49.8;\n" + 
		"2142;Bernet Rolf;1967;Richterswil;03:51:10.1;\n" + 
		"2143;Bernhard Daniel;1972;Wettingen;03:37:57.5;\n" + 
		"2144;Bernhardsgr�tter Pitsc;1976;Gossau SG;03:27:47.0;\n" + 
		"2145;Bernotto Stefano;1961;Thalwil;03:55:01.3;\n" + 
		"2147;Bertozzi Silvio;1954;Horgen;04:25:58.6;\n" + 
		"2148;Berz Fabian;1955;Horw;03:26:17.0;\n" + 
		"2149;Betschon Stefan;1959;Z�rich;03:45:15.6;\n" + 
		"2150;Bettini Enrico;1963;Z�rich;03:49:03.2;\n" + 
		"2152;Biber Alex;1961;Frauenfeld;03:40:45.8;\n" + 
		"2153;Bichler Christoph;1980;Rebstein;03:31:24.9;\n" + 
		"2154;Biedermann Daniel;1980;Aarau;03:03:17.0;\n" + 
		"2155;Bieler Walter;1960;Urdorf;03:23:17.7;\n" + 
		"2156;Bieri Walter;1962;Leissigen;03:20:22.7;\n" + 
		"2158;Neiger Lukas;1985;Z�rich;03:24:45.9;\n" + 
		"2159;Bigler Gilles;1984;Urdorf;03:45:09.7;\n" + 
		"2161;Billeter J�rg;1968;Ebertswil;03:33:56.5;\n" + 
		"2163;Binder Walter;1950;Zug;03:55:38.1;\n" + 
		"2164;Binggeli Hansj�rg;1965;Bassersdorf;04:26:21.7;\n" + 
		"2166;Birbaum Patrice;1964;Collombey;03:35:36.8;\n" + 
		"2168;Birrer Hanspeter;1952;Ballwil;04:38:21.7;\n" + 
		"2171;Bischofberger Guido;1968;Oberegg;02:54:27.2;\n" + 
		"2174;Bissig Hans;1951;Cham;03:34:42.2;\n" + 
		"2175;Bissoli Benno;1962;T�gerwilen;03:44:17.8;\n" + 
		"2177;Bitterlin Stephan;1962;Jegenstorf;04:22:11.4;\n" + 
		"2179;Blaser Hanspeter;1964;M�nchaltorf;04:18:12.7;\n" + 
		"2180;Blaser Sascha;1977;Sins;03:14:32.3;\n" + 
		"2182;Blattmann Heiner;1975;Winterthur;02:59:53.0;\n" + 
		"2184;Bleiker Harry;1960;Z�rich;04:01:36.3;\n" + 
		"2185;Bl�chlinger Fabian;1984;Jona;02:58:56.8;\n" + 
		"2186;Blumer Philipp;1988;Z�rich;03:28:15.9;\n" + 
		"2187;Blumer Renato;1958;Oberiberg;04:36:55.7;\n" + 
		"2188;Blumer Sascha;1973;Hinwil;03:43:56.6;\n" + 
		"2192;Bodenmann Andreas;1956;Schwyz;02:55:28.6;\n" + 
		"2193;Bodenmann Hanspeter;1949;Adliswil;03:40:22.0;\n" + 
		"2194;Bodmer David;1966;Z�rich;04:25:48.7;\n" + 
		"2196;Bohnet Christophe;1968;Bremblens;03:04:42.0;\n" + 
		"2197;Bohnet Nicolas;1975;Trient;03:04:07.4;\n" + 
		"2198;Boller Simon;1987;Tann;03:45:47.8;\n" + 
		"2199;Bolli Kilian;1967;Schaffhausen;03:30:05.9;\n" + 
		"2200;Bolliger Bruno;1984;Z�rich;04:28:09.2;\n" + 
		"2201;Bollinger Beat;1974;Weinfelden;03:39:58.4;\n" + 
		"2202;Bolt Thomas;1971;Uerikon;02:55:14.0;\n" + 
		"2203;Bommer Hans;1947;Donzhausen;04:15:28.9;\n" + 
		"2205;B�niger-Pr�fer Michael;1976;Sch�nenberg ZH;03:47:21.1;\n" + 
		"2206;Bonner John;1969;Cham;04:16:28.9;\n" + 
		"2207;Bonvin Jean-Charles;1970;Ollon VD;03:04:59.5;\n" + 
		"2208;Bonvin John;1963;Pampigny;03:59:43.3;\n" + 
		"2209;Born Leo;1967;Winkel;03:29:51.8;\n" + 
		"2210;Bortolin Sergio;1961;Winterthur;04:21:40.2;\n" + 
		"2212;Bosshard Stefan;1965;Wallisellen;03:23:59.4;\n" + 
		"2214;Bottecchi Diego;1970;B�tterkinden;03:32:12.4;\n" + 
		"2219;Boulter Robert;1977;Basel;02:59:49.3;\n" + 
		"2221;Boutellier Ren�;1984;Z�rich;02:41:54.7;\n" + 
		"2223;Bozi Imre;1961;W�ngi;03:20:05.5;\n" + 
		"2225;Braathen Einar H;1989;St. Gallen;04:57:19.7;\n" + 
		"2227;Bracher Ueli;1967;Z�rich;03:28:21.2;\n" + 
		"2228;Brachetto Pascal;1986;Ellikon an der Th;03:45:04.5;\n" + 
		"2231;Br�ndli Jakob;1957;Langnau i. E.;04:08:40.6;\n" + 
		"2232;Br�ndli Urs-Beat;1955;Rudolfstetten;03:09:05.9;\n" + 
		"2233;Brandt Maximilian;1982;Z�rich;03:58:13.5;\n" + 
		"2234;Brandt Simppa;1971;Embrach;03:15:55.2;\n" + 
		"2238;Brecht Jens;1975;Z�rich;03:37:16.1;\n" + 
		"2240;Breimer Mans;1967;Uster;03:40:50.6;\n" + 
		"2245;Bressa Massimo;1969;Kilchberg ZH;03:46:41.6;\n" + 
		"2247;Brotz Sandro;1969;Kilchberg ZH;03:42:38.4;\n" + 
		"2250;Bruderer Daniel;1973;K�ssnacht am Rigi;04:27:11.2;\n" + 
		"2251;Br�hwiler Rolf;1968;Heimberg;02:59:26.3;\n" + 
		"2252;Br�llmann David;1978;Z�rich;03:57:33.8;\n" + 
		"2253;Brunhart Jakob;1977;Oberschan;03:16:31.0;\n" + 
		"2254;Brunner Alfred;1965;St�fa;03:29:59.2;\n" + 
		"2255;Brunner Andr�;1967;Oberengstringen;03:21:22.6;\n" + 
		"2256;Brunner Jan;1976;D�bendorf;03:36:53.6;\n" + 
		"2257;Brunner Johannes;1966;Remetschwil;02:56:57.4;\n" + 
		"2259;Brunner Reinhard;1947;Thun;04:23:31.4;\n" + 
		"2260;Bruno Emanuele;1971;Regensdorf;04:12:47.4;\n" + 
		"2261;Bruns Wolfgang;1960;Widen;03:33:18.8;\n" + 
		"2262;Brunschweiler Marco;1973;D�bendorf;03:18:51.7;\n" + 
		"2266;Bucher Johannes;1958;Z�rich;03:10:20.7;\n" + 
		"2267;B�chler Fredi;1962;Brugg AG;05:21:01.2;\n" + 
		"2269;Buchli Urs;1958;Pfaffhausen;04:52:55.4;\n" + 
		"2271;Buchser Thomas;1965;Kappelen;03:41:24.0;\n" + 
		"2272;Buck Andreas;1985;Niederrohrdorf;04:32:20.4;\n" + 
		"2274;B�eler Gerry;1974;Z�rich;03:36:59.5;\n" + 
		"2276;B�g�kkaya Abuzer;1968;Wohlen AG;03:14:12.4;\n" + 
		"2277;B�hler D.J Wale;1958;Dulliken;03:59:32.5;\n" + 
		"2278;B�hler Raphael;1986;St. Gallen;03:20:21.5;\n" + 
		"2280;B�hrer John;1964;Z�rich;03:43:03.4;\n" + 
		"2282;B�nter Jean Pierre;1952;Hombrechtikon;04:15:52.4;\n" + 
		"2284;Burger Willi;1951;M�riken AG;03:51:02.3;\n" + 
		"2285;B�rgi Simon;1985;Wollerau;03:09:10.3;\n" + 
		"2286;B�rgis Stefan;1977;Einsiedeln;03:28:37.3;\n" + 
		"2287;Burkhard Beat;1975;Uznach;02:39:47.5;\n" + 
		"2288;Burkhard Roger;1968;Oekingen;03:45:58.0;\n" + 
		"2289;Burkhardt Ralf;1966;Bern;03:46:35.5;\n" + 
		"2290;Burns Kevin;1974;Z�rich;03:51:19.0;\n" + 
		"2291;Burri Christian;1953;Kilchberg ZH;03:24:58.4;\n" + 
		"2293;Buser Thomas;1963;Nuglar;04:05:20.1;\n" + 
		"2295;Buslau Michael;1955;Schaffhausen;04:33:12.4;\n" + 
		"2296;Bussinger Manuel;1984;Effretikon;04:32:51.2;\n" + 
		"2297;Bussmann Oliver;1971;Langnau am Albis;02:58:43.7;\n" + 
		"2298;Butty St�phane;1965;Lausanne;02:59:31.2;\n" + 
		"2301;Caflisch Amedeo;1963;Z�rich;03:14:34.3;\n" + 
		"2302;Caillet C�dric;1973;Le Landeron;03:21:40.0;\n" + 
		"2304;Calame Louis;1952;Lausanne;03:35:20.8;\n" + 
		"2305;Calcagni Carlo;1961;Altdorf UR;03:52:42.3;\n" + 
		"2306;Calendo Ciro;1961;Pf�ffikon SZ;04:32:47.0;\n" + 
		"2307;Camathias Ulrich;1962;Trimmis;05:21:11.8;\n" + 
		"2308;Camenisch Glauco;1980;Z�rich;03:25:24.3;\n" + 
		"2309;Camenzind Markus;1982;Orbe;03:00:07.2;\n" + 
		"2310;Caprez Andrea;1965;Z�rich;02:54:43.7;\n" + 
		"2311;Carbonara Toni;1965;Lausanne;04:16:44.0;\n" + 
		"2312;Carbotti Franco;1972;Einsiedeln;03:35:47.3;\n" + 
		"2314;Caretta Claudio;1955;Wetzikon ZH;04:12:04.8;\n" + 
		"2317;Carminati Walter;1970;Uster;03:51:24.1;\n" + 
		"2319;Caruso Renato;1968;N�nikon;04:29:06.9;\n" + 
		"2320;Casanovas Ramon;1980;Le Landeron;03:24:06.5;\n" + 
		"2321;Castella Vincent;1979;Plan-les-Ouates;03:13:41.1;\n" + 
		"2322;Castiglioni Luca;1979;Z�rich;03:47:45.2;\n" + 
		"2323;Casto Salvatore;1937;Z�rich;05:25:47.6;\n" + 
		"2325;Caudwell David;1954;Z�rich;04:36:27.3;\n" + 
		"2327;Cavegn Werner;1970;Root;03:45:44.1;\n" + 
		"2328;Caviezel Andrin;1984;Domat/Ems;03:41:56.6;\n" + 
		"2329;Ceccarini Massimo;1966;Adliswil;03:26:18.4;\n" + 
		"2330;Ceriani Angelo;1956;Hirzel;04:25:25.3;\n" + 
		"2331;Cester Marc;1980;Morat;03:03:44.4;\n" + 
		"2333;Chapman Brian;1975;M�nnedorf;04:14:02.5;\n" + 
		"2335;Chassot Pierre-Andr�;1969;Bussy FR;03:43:24.5;\n" + 
		"2336;Chatila Rico;1962;D�ttingen;03:26:02.0;\n" + 
		"2337;Chatzichrisafis Nikos;1973;Z�rich;03:33:49.6;\n" + 
		"2338;Chevalley Raymond;1955;Dietikon;04:22:45.3;\n" + 
		"2339;Chiller-Glaus Michael;1975;Pf�ffikon ZH;03:53:35.8;\n" + 
		"2340;Choffat Yves;1960;Winterthur;03:17:39.2;\n" + 
		"2341;Choukroun Daniel;1985;Pully;02:45:27.4;\n" + 
		"2342;Christ Tobias;1981;Z�rich;03:30:40.3;\n" + 
		"2343;Christiner Mario;1989;Z�rich;02:48:10.6;\n" + 
		"2347;Clavadetscher Georg;1988;Azmoos;04:23:21.2;\n" + 
		"2348;Clesle Hanspeter;1969;Adliswil;04:32:43.1;\n" + 
		"2349;Cloetta Andri;1976;Cadempino;03:41:44.0;\n" + 
		"2353;Collenberg Reto;1964;Winterthur;03:39:01.9;\n" + 
		"2355;Colvin Graham;1968;Baar;03:20:35.2;\n" + 
		"2356;Conrad Alex;1973;Bergdietikon;04:29:04.0;\n" + 
		"2360;Cooke Sam;1961;Z�rich;03:28:23.2;\n" + 
		"2361;Corbisiero Salvatore;1968;Schaffhausen;03:34:25.0;\n" + 
		"2362;Cortelezzi Paolo;1973;Vezia;03:40:05.0;\n" + 
		"2363;Cottet Laurent;1968;Gen�ve;03:23:56.8;\n" + 
		"2364;Crespo Ricardo;1969;Z�rich;04:49:35.9;\n" + 
		"2365;Crettenand Olivier;1964;Sion;04:25:31.7;\n" + 
		"2366;Crisafulli Sebastiano;1964;Sennhof (Winterth;03:26:57.1;\n" + 
		"2368;Curda Josef;1957;Eglisau;04:37:56.2;\n" + 
		"2369;Curda Tobias;1982;Eglisau;03:40:33.1;\n" + 
		"2371;Cusack John-Paul;1967;Klosters;03:38:38.3;\n" + 
		"2372;D'Amato Gionni;1970;Volketswil;03:52:25.2;\n" + 
		"2373;Da Col Claudio;1964;Thalwil;03:31:27.0;\n" + 
		"2374;Da Costa Fernando;1976;Kloten;03:05:47.2;\n" + 
		"2376;Daly Paul;1984;Z�rich;04:21:31.1;\n" + 
		"2377;Dambach Ren�;1969;Sch�fflisdorf;03:22:06.3;\n" + 
		"2380;Danz Martin;1970;Z�rich;03:52:38.9;\n" + 
		"2381;D�pp Willi;1951;Brugg AG;04:17:14.8;\n" + 
		"2382;Dariz Michele;1980;Gordola;03:51:17.9;\n" + 
		"2383;Daschmann Volker;1973;Winterthur;04:49:31.1;\n" + 
		"2385;De Faria Patrick;1976;Montreux;04:43:32.0;\n" + 
		"2387;De Martin Marco;1979;Aadorf;02:49:12.6;\n" + 
		"2388;De Murga John;1974;Z�rich;04:58:21.6;\n" + 
		"2389;De Plinval Pierre-Loui;1986;Z�rich;03:41:55.6;\n" + 
		"2390;De Toffol Simon;1988;Zuzwil SG;04:14:18.7;\n" + 
		"2391;De Wit Guido;1962;Sch�nenberg ZH;03:52:16.4;\n" + 
		"2393;Degen Lukas;1959;Biel-Benken BL;02:58:50.8;\n" + 
		"2395;Della Badia Antonio;1975;Stansstad;03:24:35.6;\n" + 
		"2396;Delley Alain;1968;Givisiez;03:20:38.0;\n" + 
		"2397;Dentskevich Andrew;1965;Basel;03:27:49.7;\n" + 
		"2399;Dessimoz Philippe;1971;St-S�verin;03:09:13.0;\n" + 
		"2400;Desteffani J�rg;1964;Windisch;03:09:27.4;\n" + 
		"2402;Dhom Michael;1970;Steffisburg;03:03:48.4;\n" + 
		"2403;Di Giorgio Benedetto;1976;Z�rich;04:04:34.1;\n" + 
		"2404;Di Mauro Philipp;1971;Z�rich;04:01:57.7;\n" + 
		"2406;Diallo Ousmane;1980;Thalwil;03:23:35.8;\n" + 
		"2407;Dick Markus;1975;Lenzburg;03:21:35.5;\n" + 
		"2409;Diener Erwin;1960;Z�rich;02:55:16.4;\n" + 
		"2410;Diethelm Karl;1957;Zufikon;03:53:47.7;\n" + 
		"2411;Dietrich Rainer;1966;Steinhausen;03:00:12.0;\n" + 
		"2413;Dillner Tomas;1970;Richterswil;03:03:47.3;\n" + 
		"2414;Diviney Craig;1953;Affoltern am Albi;03:20:23.3;\n" + 
		"2416;D�beli Philipp;1988;Birrwil;03:05:55.6;\n" + 
		"2417;Dober Meinrad;1971;K�ssnacht am Rigi;03:38:30.9;\n" + 
		"2423;Dooney Barry;1980;Baar;04:44:52.8;\n" + 
		"2425;Doubman Jay;1971;D�bendorf;02:57:42.2;\n" + 
		"2429;Downey Denis;1974;Windisch;03:53:09.6;\n" + 
		"2430;Drayton Jeffrey;1967;Schaffhausen;03:43:02.5;\n" + 
		"2432;Dreier Daniel;1970;Humlikon;03:51:25.7;\n" + 
		"2433;Dreier Matthias;1978;Z�rich;03:18:07.5;\n" + 
		"2435;D�bi Roland;1977;Z�rich;04:05:24.0;\n" + 
		"2436;Dubugnon Christian;1970;Yverdon-les-Bains;03:27:29.5;\n" + 
		"2437;Dudle Cornel;1975;Z�rich;03:35:12.7;\n" + 
		"2438;Duerr Hampi;1970;Gossau SG;03:36:35.9;\n" + 
		"2440;Dummermuth J�rg;1969;Oberhofen am Thun;03:09:28.3;\n" + 
		"2443;D�ringer Michael;1965;St�fa;03:39:12.5;\n" + 
		"2444;Durrer Daniel;1963;Basel;04:27:31.7;\n" + 
		"2447;D�rst Michael;1966;Lenzburg;03:12:56.5;\n" + 
		"2448;Duschl Martin;1962;Rizenbach;04:25:17.7;\n" + 
		"2451;D�tschler Joel;1985;Winterthur;03:06:38.0;\n" + 
		"2453;Eberhard Thomas;1968;Bettlach;04:05:07.0;\n" + 
		"2455;Eberle Paul;1948;Degersheim;03:44:00.7;\n" + 
		"2457;Eckard Christophe;1966;Z�rich;03:47:58.1;\n" + 
		"2458;Eckert Clemens;1977;Volketswil;03:24:09.5;\n" + 
		"2459;Eckhardt J�rg;1966;Wollerau;03:42:48.4;\n" + 
		"2460;Eggenschwiler Bernhard;1985;Fehren;02:44:49.4;\n" + 
		"2461;Eggenschwiler Christop;1967;Del�mont;02:59:47.6;\n" + 
		"2462;Eggenschwiler Denis;1979;Solothurn;03:04:59.8;\n" + 
		"2466;Egidio Arturo;1969;Ballwil;03:29:56.5;\n" + 
		"2467;Egli Martin;1960;Schinznach Bad;03:47:10.6;\n" + 
		"2468;Egli Peter;1966;Gachnang;04:21:32.1;\n" + 
		"2469;Egli Sven;1965;Cham;03:27:58.8;\n" + 
		"2471;Eiche Francis;1950;Meiringen;04:06:02.4;\n" + 
		"2472;Eichelberger Pascal;1966;Recherswil;04:01:48.3;\n" + 
		"2474;Eichhorn Beat;1969;Arth;03:16:51.8;\n" + 
		"2478;Eisenlohr Frank;1963;Z�rich;03:21:41.6;\n" + 
		"2479;Eisner Hannes;1970;Visp;03:28:45.2;\n" + 
		"2480;Ellinger Thomas;1966;Oberurnen;04:11:31.5;\n" + 
		"2483;Elmer Markus;1974;Worb;03:07:08.3;\n" + 
		"2484;Emert Frank;1967;D�ttwil AG;04:29:08.6;\n" + 
		"2491;Eppler Beat;1965;D�bendorf;03:09:38.4;\n" + 
		"2493;Erb Peter;1958;Winterthur;03:10:21.4;\n" + 
		"2494;Erb Thomas;1959;Z�rich;03:57:37.7;\n" + 
		"2496;Erian Tom;1979;Utzenstorf;02:57:11.9;\n" + 
		"2498;Ernst Andreas;1966;Zeihen;03:38:39.2;\n" + 
		"2499;Ernst Andreas;1965;Schwerzenbach;03:47:40.6;\n" + 
		"2501;Ettlinger Claudius;1967;Z�rich;03:49:48.9;\n" + 
		"2502;Eugster Marcel;1963;Z�rich;02:59:33.6;\n" + 
		"2503;Eugster Tobias;1967;W�ngi;03:44:23.8;\n" + 
		"2504;Faccoli Gabriele;1979;Bosco Luganese;03:37:58.8;\n" + 
		"2505;Faerber Philipp;1966;St�fa;02:50:59.7;\n" + 
		"2507;Fahrni Andreas;1961;Kirchberg BE;03:22:49.6;\n" + 
		"2510;Falconer John;1958;R�schlikon;03:49:34.7;\n" + 
		"2511;Falcy Yves-Alain;1961;Vufflens-le-Ch�te;04:23:41.0;\n" + 
		"2512;Falter Harald;1961;Hersiwil;03:19:52.3;\n" + 
		"2513;Fanger Adrian;1976;Sarnen;04:11:25.3;\n" + 
		"2514;Fankhauser Martin;1961;Udligenswil;03:36:21.8;\n" + 
		"2515;Farner Kurt;1961;T�uffelen;04:41:50.4;\n" + 
		"2516;Farner Martin;1979;Feuerthalen;03:51:54.1;\n" + 
		"2517;Farner Ren�;1958;Wintersingen;03:29:55.9;\n" + 
		"2518;Farner Roger;1977;Z�rich;03:51:55.2;\n" + 
		"2519;Fasel Samuel;1980;D�dingen;03:49:40.2;\n" + 
		"2520;Fasnacht Markus;1968;Kestenholz;03:17:36.8;\n" + 
		"2521;F�ssler Christoph;1975;Richterswil;03:57:08.5;\n" + 
		"2522;F�ssler Lukas;1981;Z�rich;04:01:23.3;\n" + 
		"2524;Fatio Didier;1983;Z�rich;03:16:59.1;\n" + 
		"2525;Fattorini Leonardo;1980;Z�rich;02:54:53.3;\n" + 
		"2526;Fausch J�rg;1963;Frauenfeld;03:42:54.5;\n" + 
		"2529;Fehr Adrian;1986;Buchs ZH;03:32:24.9;\n" + 
		"2530;Fehr Harry;1966;Rafz;03:09:24.7;\n" + 
		"2531;Fehr Kurt;1943;Andelfingen;04:25:06.1;\n" + 
		"2532;Fehr Matthias;1960;Affoltern am Albi;03:34:08.9;\n" + 
		"2534;Feigl Christopher;1969;Oberschan;03:29:22.5;\n" + 
		"2535;Fejes Stefan;1974;Adliswil;03:20:33.5;\n" + 
		"2536;Fejry Khalil;1957;Bassersdorf;03:31:07.1;\n" + 
		"2537;Felchlin Walter;1951;Niederglatt ZH;04:18:13.9;\n" + 
		"2538;Felder Oliver;1969;St. Gallen;03:57:32.9;\n" + 
		"2539;Felder Willhelm;1947;Z�rich;04:27:39.1;\n" + 
		"2542;Fernandes Casimiro;1956;Monthey;03:04:51.4;\n" + 
		"2543;Fernandez Antonio;1952;Greifensee;03:22:54.5;\n" + 
		"2545;Ferraiuolo Salvatore;1959;Z�rich;03:40:18.9;\n" + 
		"2546;Ferrini Mattia;1982;Z�rich;04:13:05.9;\n" + 
		"2547;Fetzer Roland;1973;Jonen;03:00:23.0;\n" + 
		"2550;Fior Guglielmo;1967;Dachsen;02:59:38.8;\n" + 
		"2552;Fischer Cosy;1982;Z�rich;04:26:53.8;\n" + 
		"2553;Fischer Felix;1966;Ossingen;03:34:08.0;\n" + 
		"2555;Fischer Kai;1969;Geroldswil;02:43:15.0;\n" + 
		"2557;Fischer Oliver;1977;Bonstetten;03:10:50.3;\n" + 
		"2558;Flach Roland;1964;Z�rich;03:28:52.0;\n" + 
		"2559;Fleischer Thomas;1975;Z�rich;03:19:07.9;\n" + 
		"2560;Fleischhacker Cris;1961;Muttenz;04:22:00.4;\n" + 
		"2561;Fleischmann Rene;1974;Galgenen;03:37:43.1;\n" + 
		"2562;Fleischmann Sascha;1976;Reichenburg;03:28:45.9;\n" + 
		"2565;Flueckiger Joerg;1964;Biberstein;03:55:45.3;\n" + 
		"2566;Flum Michael;1965;Eschenz;03:29:34.5;\n" + 
		"2567;F�llmi Daniel;1970;H�nenberg;02:47:15.8;\n" + 
		"2568;Folly Olivier;1968;Pierrafortscha;03:08:24.4;\n" + 
		"2569;Fontana Patrick;1972;Z�rich;04:49:09.1;\n" + 
		"2570;Forlesi Maurice;1972;Fehraltorf;04:00:31.6;\n" + 
		"2571;Forney Jean-Francois;1969;Courtaman;03:50:11.3;\n" + 
		"2572;Forrer Andi;1961;Schindellegi;03:57:35.8;\n" + 
		"2573;Forrer Markus;1964;Wollerau;03:43:13.6;\n" + 
		"2574;Forrer Thomas;1983;Z�rich;03:26:44.2;\n" + 
		"2575;Forster Urs;1964;Leibstadt;03:56:10.2;\n" + 
		"2576;Fort Pierre-Andre;1954;Martigny;03:43:23.0;\n" + 
		"2577;Fortgens Erik;1972;Sulz AG;03:12:57.2;\n" + 
		"2578;Foster Cheran;1989;Rothenhausen;04:09:16.7;\n" + 
		"2579;Foster Kevin;1962;Gebenstorf;03:39:59.2;\n" + 
		"2580;Fraefel Beat;1959;Affoltern am Albi;03:39:42.4;\n" + 
		"2581;Fraefel Mario;1964;Rafz;03:42:55.1;\n" + 
		"2582;Franck Andreas;1963;Jonschwil;03:19:31.1;\n" + 
		"2583;Francois Herve;1963;Z�rich;03:56:16.3;\n" + 
		"2587;Frehner Jakob;1962;Castrisch;05:29:09.2;\n" + 
		"2588;Frei Christoph;1964;Wil AG;03:34:04.8;\n" + 
		"2589;Frei Marc;1976;Buchrain;03:37:59.3;\n" + 
		"2590;Frei Martin;1968;Kirchberg BE;02:44:02.8;\n" + 
		"2591;Frei Othmar;1957;Thayngen;03:59:15.3;\n" + 
		"2592;Frei Pascal;1976;Z�rich;03:34:47.5;\n" + 
		"2593;Frei Thomas;1975;Gontenschwil;03:28:06.0;\n" + 
		"2595;Freisler Peter;1970;Z�rich;04:06:40.1;\n" + 
		"2597;Fretz Willi;1938;Erlinsbach;04:35:35.7;\n" + 
		"2599;Frey Dominik;1988;Winterthur;04:00:28.3;\n" + 
		"2600;Frey Heini;1956;Winterthur;03:56:30.0;\n" + 
		"2601;Frey Stefan;1986;Winterthur;03:51:14.3;\n" + 
		"2604;Frieden Thomas;1969;Kollbrunn;02:32:25.2;\n" + 
		"2605;Friederich Mathias;1964;Niederweningen;03:26:38.5;\n" + 
		"2607;Friedli J�rg;1971;Bern;03:39:09.0;\n" + 
		"2609;Frischknecht Fritz;1958;Steinmaur;03:27:40.5;\n" + 
		"2611;Fritsche Lukas;1987;Diepoldsau;03:29:27.6;\n" + 
		"2612;Fritschi Michael;1972;B�lach;03:19:32.7;\n" + 
		"2615;Fuchs Christian;1965;B�ch SZ;02:58:20.9;\n" + 
		"2616;Fuchs Heinz;1956;Hofstetten b. Bri;04:23:57.8;\n" + 
		"2617;Fuchs Markus;1975;Z�rich;04:28:36.3;\n" + 
		"2618;Fuchs Peter;1972;Z�rich;04:31:50.6;\n" + 
		"2620;F�rer Karl;1957;Rheineck;03:30:37.6;\n" + 
		"2621;Furrer Felix;1964;Bettwil;03:38:12.0;\n" + 
		"2622;F�rst Ren�;1969;Z�rich;03:25:04.1;\n" + 
		"2623;Fusco Carlo;1966;Pf�ffikon SZ;03:20:24.2;\n" + 
		"2625;Gabathuler Tobias;1976;Z�rich;03:35:08.2;\n" + 
		"2626;Gabriel Daniel;1977;Ibach;03:54:27.7;\n" + 
		"2627;G�chter Roland;1972;R�thi (Rheintal);03:22:01.8;\n" + 
		"2628;Gadient Hans;1957;Kloten;03:53:31.1;\n" + 
		"2629;G�hwiler Hanspeter;1961;Wil SG;03:03:34.2;\n" + 
		"2631;Galliker Philipp;1958;Z�rich;03:28:25.2;\n" + 
		"2632;Gambino Dario;1978;F�llanden;04:12:56.5;\n" + 
		"2633;Gameiro Antonio;1962;Collombey;02:56:40.2;\n" + 
		"2635;Gantenbein Silvan;1990;Adliswil;04:45:52.8;\n" + 
		"2637;Gartmann Urs;1977;F�llanden;03:34:59.7;\n" + 
		"2638;Gasser Marc;1982;Z�rich;03:44:28.9;\n" + 
		"2640;Gast Fritz;1971;Rothrist;03:36:32.3;\n" + 
		"2641;Gattiker Roger;1972;Winkel;04:12:59.8;\n" + 
		"2643;Gaussmann Andreas;1962;Werdenberg;02:49:19.1;\n" + 
		"2646;Geiger Christian;1980;Z�rich;03:30:05.2;\n" + 
		"2647;Geissb�hler Andreas;1960;Boppelsen;03:12:39.6;\n" + 
		"2649;Geissmann Walter;1951;Allschwil;03:27:55.4;\n" + 
		"2651;Genn� Daniel;1964;La Chaux-de-Fonds;03:44:54.1;\n" + 
		"2653;Gerber Bernhard;1962;Epsach;04:11:50.8;\n" + 
		"2654;Gerber Roger;1970;Biberist;02:49:17.7;\n" + 
		"2655;Gerber Thomas;1966;Frenkendorf;03:14:33.7;\n" + 
		"2657;Gerlof Wolfram;1973;M�nnedorf;04:36:04.7;\n" + 
		"2658;Germain Jean-Pierre;1954;Z�rich;05:05:54.1;\n" + 
		"2659;Germann Pascal;1977;Z�rich;03:24:18.5;\n" + 
		"2662;Gerster Richard;1946;Richterswil;03:57:09.8;\n" + 
		"2664;Gertsch Marcel;1978;Unterseen;02:52:23.0;\n" + 
		"2665;Gertsch Ralph;1968;Engelburg;04:04:17.7;\n" + 
		"2666;Gertsch Silvan;1982;Thun;04:09:01.0;\n" + 
		"2667;Gertschen Mike;1978;Z�rich;04:14:45.5;\n" + 
		"2668;Gex-Collet Pierre-Jose;1975;Troistorrents;03:01:05.9;\n" + 
		"2669;Geyer Marc;1982;Wengen;04:48:45.7;\n" + 
		"2673;Gibel Richard;1953;D�rnten;03:47:26.8;\n" + 
		"2674;Gigandet Sylvain;1980;Genolier;03:01:43.5;\n" + 
		"2677;Giordano Lorenz;1971;Z�rich;03:33:03.4;\n" + 
		"2678;Girsberger Martin;1958;Frauenfeld;03:49:07.5;\n" + 
		"2679;Gisler Beat;1963;Ramiswil;02:57:43.5;\n" + 
		"2680;Gisler Jan;1974;Ennetmoos;03:05:52.6;\n" + 
		"2681;Gisler Karl;1957;Obernau;02:46:40.4;\n" + 
		"2684;Gl�ssner Marcel;1972;Heiligenschwendi;03:58:25.3;\n" + 
		"2685;Gleitz Robert;1959;Thalwil;03:29:13.4;\n" + 
		"2686;Gloden Alain;1967;Horgen;03:42:54.6;\n" + 
		"2689;Gnos Renato;1983;Ueberstorf;03:51:49.2;\n" + 
		"2693;Gomez David;1977;Z�rich;04:38:57.5;\n" + 
		"2694;Gorgerat Jean-Philippe;1976;Bern;03:10:36.4;\n" + 
		"2696;Gosteli Hansj�rg;1967;Worb;02:56:59.9;\n" + 
		"2697;Gosteli Oliver Jos�;1973;Z�rich;03:07:01.8;\n" + 
		"2698;Goto Fumihiko;1972;Gen�ve;03:28:24.1;\n" + 
		"2700;Gottwald Martin;1967;Gen�ve;03:53:30.7;\n" + 
		"2701;G�tz Markus;1948;Chur;03:59:00.6;\n" + 
		"2702;Grab Manfred;1967;Kehrsiten;03:25:34.2;\n" + 
		"2703;Graber Marcel;1967;Jona;03:10:08.0;\n" + 
		"2706;Graf Daniel;1983;B�lach;03:48:08.4;\n" + 
		"2708;Graf Klaus;1960;Roggliswil;03:29:26.8;\n" + 
		"2710;Granges Thierry;1959;Martigny;03:08:17.8;\n" + 
		"2711;Grausgruber Johannes;1963;Adliswil;04:21:27.5;\n" + 
		"2713;Greil Maeck;1967;Richterswil;03:13:35.2;\n" + 
		"2714;Greter Arno;1963;Buchrain;04:19:22.0;\n" + 
		"2717;Grisoni G�rald;1958;Corseaux;03:50:38.4;\n" + 
		"2718;Gr�bli Adrian;1961;Oetwil an der Lim;02:42:11.6;\n" + 
		"2721;Grossmann Frank;1963;Erstfeld;03:06:51.7;\n" + 
		"2722;Grubenmann Hens;1977;Z�rich;03:42:41.4;\n" + 
		"2723;Gruber Bernhard;1962;Diepoldsau;03:48:54.7;\n" + 
		"2724;Gr�ebler Thomas;1961;Bonstetten;04:28:45.2;\n" + 
		"2725;Grujcic Dejan;1985;Fehraltorf;03:59:53.0;\n" + 
		"2726;Grundmann Oliver;1979;Z�rich;03:56:49.0;\n" + 
		"2727;Gr�ter Andr�;1980;Ballwil;02:58:56.1;\n" + 
		"2728;Gr�tter Matthias;1964;G�mligen;03:04:15.1;\n" + 
		"2729;Gubler Daniel;1968;Uetikon am See;03:23:50.2;\n" + 
		"2730;Gubler Peter;1961;Winterthur;05:00:05.7;\n" + 
		"2731;G�ckel Christian;1980;Schaffhausen;03:18:41.5;\n" + 
		"2733;Gudehus Kim;1963;Brugg AG;03:34:02.0;\n" + 
		"2734;Guex St�phane;1969;Ollon VD;03:07:06.1;\n" + 
		"2735;Gugelmann Ren�;1968;Rheinau;03:23:28.6;\n" + 
		"2736;Guidon Andri;1954;Wallisellen;03:58:33.8;\n" + 
		"2737;Guignard Philippe;1954;Vaulion;03:48:33.7;\n" + 
		"2739;Guillet Marc-Antoine;1992;Avry-sur-Matran;03:42:50.7;\n" + 
		"2740;G�nthard Huldrych;1961;Z�rich;03:44:06.1;\n" + 
		"2741;Gunti Markus;1970;Laufen;03:14:02.3;\n" + 
		"2744;Gut Daniel;1984;Z�rich;03:24:08.6;\n" + 
		"2747;Gutjahr Rolf;1967;Schenkon;02:58:02.6;\n" + 
		"2748;Gutzwiller Mark;1973;Uerikon;03:48:16.6;\n" + 
		"2753;Gyger Peter;1969;Fahrni b. Thun;03:05:00.1;\n" + 
		"2754;Gygli Walter;1961;Kreuzlingen;03:03:59.7;\n" + 
		"2755;Gysin Ernst;1945;Oberdorf SO;05:07:37.7;\n" + 
		"2757;Ha Thomas;1981;H�ntwangen;03:41:22.8;\n" + 
		"2759;Haas Ingo;1976;Wilen b. Wollerau;03:05:20.4;\n" + 
		"2761;Habl�tzel Roman;1993;Stehrenberg;02:55:57.3;\n" + 
		"2762;Hadorn Jonas;1988;Z�rich;04:49:10.6;\n" + 
		"2764;Haefeli Stephan;1949;M�mliswil;03:48:07.5;\n" + 
		"2766;H�fliger Peter;1948;Oftringen;03:28:20.5;\n" + 
		"2767;H�fliger Rolf;1957;Uitikon Waldegg;03:44:11.9;\n" + 
		"2769;H�hni Marcel;1970;Samstagern;04:10:06.0;\n" + 
		"2770;Haider Martin;1980;Arth;03:35:02.2;\n" + 
		"2773;Halvorsroed Jan;1963;Z�rich;04:30:52.1;\n" + 
		"2776;H�nggi Gerold;1962;Z�rich;04:26:09.0;\n" + 
		"2777;H�ni Stephan;1976;Schlieren;03:13:50.4;\n" + 
		"2778;Hannah Jeremy;1976;Z�rich;03:14:27.7;\n" + 
		"2779;Hannay Mark;1991;D�bendorf;03:46:52.0;\n" + 
		"2780;Hansen Kjetil Hoie;1987;Ecublens VD;03:53:12.0;\n" + 
		"2781;Hansmann Daniel;1960;Aadorf;03:26:44.7;\n" + 
		"2783;H�rri Markus;1965;Adliswil;02:56:18.7;\n" + 
		"2789;Haselbach Stefan;1970;Abtwil SG;03:15:22.1;\n" + 
		"2790;H�sler Daniel;1975;Z�rich;03:40:47.6;\n" + 
		"2791;H�ssig Ralph;1984;Weggis;03:45:53.1;\n" + 
		"2792;Hassler Daniel;1981;Hedingen;03:06:09.3;\n" + 
		"2794;Haubensack Andr�;1966;Z�rich;03:54:47.5;\n" + 
		"2796;Haukaas Magnus Solli;1987;Z�rich;04:02:41.9;\n" + 
		"2797;Hausammann Urs;1965;Z�rich;03:35:21.0;\n" + 
		"2798;Hauser Daniel;1970;Seengen;03:01:58.0;\n" + 
		"2799;Hauser Olivier;1966;Rolle;04:01:12.2;\n" + 
		"2800;Hauser Thomas;1972;Steinhausen;03:00:12.2;\n" + 
		"2801;Hauser Thomas;1987;W�denswil;03:05:45.6;\n" + 
		"2802;H�usermann Christian;1967;M�nchenstein;03:10:43.9;\n" + 
		"2804;Haussner Enrico;1978;Teufen AR;03:10:05.3;\n" + 
		"2806;Heckendorn Felix;1965;Oberglatt ZH;04:54:02.0;\n" + 
		"2809;Heer Dominik;1971;Basel;03:49:37.4;\n" + 
		"2810;Hefti Gian-Franco;1972;Wettswil;02:59:32.3;\n" + 
		"2812;Hegglin Marco;1983;Z�rich;03:52:19.2;\n" + 
		"2813;Hegglin Markus;1960;Z�rich;03:30:57.7;\n" + 
		"2814;Hegner Norbert;1965;Galgenen;02:38:11.0;\n" + 
		"2815;Heide Uwe;1959;Schmerikon;04:15:06.3;\n" + 
		"2820;Heiniger Peter;1949;B�ren an der Aare;03:46:31.7;\n" + 
		"2821;Heiniger Stefan;1969;Zollikofen;03:52:21.0;\n" + 
		"2822;Heinz Max;1960;Lichtensteig;03:33:11.5;\n" + 
		"2825;Helbling Daniel;1967;Sch�nis;03:21:41.8;\n" + 
		"2826;Helbling Felix;1974;Kilchberg ZH;03:48:07.8;\n" + 
		"2827;Held Michel;1972;B�nigen b. Interl;03:20:14.4;\n" + 
		"2832;Henle Lukas;1982;M�nnedorf;03:49:53.3;\n" + 
		"2838;Herger Anton;1956;Adliswil;04:11:29.0;\n" + 
		"2840;Herrmann Daniel;1979;Langnau am Albis;03:07:48.1;\n" + 
		"2841;Hersche Marcel;1969;Adlikon b. Regens;04:48:12.9;\n" + 
		"2842;Herz Daniel;1973;Z�rich;03:49:14.2;\n" + 
		"2843;Hess Dieter;1958;Feldbrunnen;03:24:08.5;\n" + 
		"2844;Hess Florian;1989;Adliswil;04:13:36.8;\n" + 
		"2846;Hess Michael;1980;Bern;03:33:11.0;\n" + 
		"2851;Heyer Serge;1968;Stallikon;04:13:31.5;\n" + 
		"2853;Hilpertshauser Urs;1957;Hinwil;04:18:49.7;\n" + 
		"2855;Hiltbrand Martin;1963;Rombach;03:19:24.5;\n" + 
		"2856;Hirschi Alexandre;1974;Oulens-sous-Echal;03:56:11.0;\n" + 
		"2857;Hischier Aldo;1963;Leuk Stadt;03:43:51.1;\n" + 
		"2859;Hochuli Reto;1977;Niederh�nigen;03:18:25.6;\n" + 
		"2860;Hodel Roger;1964;Effretikon;03:11:15.0;\n" + 
		"2862;Hofer C�dric;1991;Kloten;05:20:20.3;\n" + 
		"2863;Hofer Erich;1961;Eggenwil;03:44:20.3;\n" + 
		"2865;Hofer Urs;1960;Wangen a. A.;03:57:42.1;\n" + 
		"2868;Hofmann Edy;1962;Winterthur;03:54:47.9;\n" + 
		"2870;Hofmann Raymond;1970;Reinach BL;03:00:32.8;\n" + 
		"2871;Hofstetter Martin;1952;St. Gallen;03:53:26.1;\n" + 
		"2872;Hofstetter Roman;1989;Bonstetten;03:39:15.6;\n" + 
		"2873;Hohl Andreas;1960;Thalwil;03:26:04.0;\n" + 
		"2876;Holenweger Mirko;1977;Fehraltorf;03:28:22.4;\n" + 
		"2877;Holenweger Thomas;1979;M�nnedorf;04:16:36.0;\n" + 
		"2878;H�lling Matthias;1969;Z�rich;04:11:46.0;\n" + 
		"2880;Holub Marc;1974;Schwarzenberg LU;04:20:54.6;\n" + 
		"2881;Holzh�ter Dirk;1965;Flawil;02:56:32.7;\n" + 
		"2882;Hommann Edgar;1946;Grossaffoltern;03:33:34.7;\n" + 
		"2886;Hookey Mark;1970;Adliswil;05:08:11.2;\n" + 
		"2888;H�ppli Marcel;1964;Nussbaumen AG;04:18:59.9;\n" + 
		"2889;Horat Karl;1960;Uster;03:43:51.2;\n" + 
		"2892;Hosner Markus;1958;Kriens;04:22:08.1;\n" + 
		"2897;Huber Andreas;1978;W�renlos;03:55:22.3;\n" + 
		"2898;Huber Daniel;1964;St. Gallen;04:06:24.1;\n" + 
		"2899;Huber Erwin;1941;Sulz AG;04:14:35.5;\n" + 
		"2900;Huber Michael;1972;Beinwil am See;02:59:15.1;\n" + 
		"2901;Huber Michael;1982;Z�rich;04:34:43.1;\n" + 
		"2902;Huber Rolf;1965;Dietlikon;03:31:34.6;\n" + 
		"2904;Huber-Meier Hans;1956;Winterthur;04:09:42.8;\n" + 
		"2907;Hug Jean-Pierre;1968;M�nnedorf;03:34:08.1;\n" + 
		"2908;Hugener Thomas;1963;Schwerzenbach;04:39:42.7;\n" + 
		"2909;Hugentobler Martin;1954;Uzwil;03:07:55.8;\n" + 
		"2912;H�gli Heinz;1963;Bonaduz;03:53:16.9;\n" + 
		"2913;Humbel Markus;1957;Z�rich;04:10:57.1;\n" + 
		"2914;Hungerb�hler Andreas;1982;Z�rich;03:51:39.2;\n" + 
		"2917;H�rlimann Fabrizio;1990;Trogen;03:55:19.2;\n" + 
		"2918;Hurni Beat;1969;Wetzikon ZH;04:33:18.0;\n" + 
		"2920;Huser Josef;1946;D�bendorf;04:06:01.1;\n" + 
		"2921;Huser Roland;1959;Hinwil;03:21:57.2;\n" + 
		"2922;Huwiler Denis;1972;Uerikon;03:23:18.4;\n" + 
		"2924;Ijland Marcel;1962;Forch;04:06:59.7;\n" + 
		"2925;Illi Ruedi;1962;F�llanden;03:28:01.8;\n" + 
		"2927;Immer Marcel;1981;Obfelden;03:34:15.8;\n" + 
		"2929;Inglin Roger;1970;Winterthur;04:28:05.4;\n" + 
		"2930;Ingold Marc;1982;Berikon;03:54:20.3;\n" + 
		"2931;Ingold Markus;1967;Z�rich;03:25:36.6;\n" + 
		"2932;Ingold-Martinez Lukas;1966;Basel;03:43:56.2;\n" + 
		"2934;Inzirillo Maurice;1960;Cort�bert;03:03:34.5;\n" + 
		"2935;Ippel Rene;1965;Bonstetten;03:35:14.9;\n" + 
		"2937;Iseli Ernst;1951;Burgdorf;04:32:16.9;\n" + 
		"2938;Isenring Martin;1973;Oberengstringen;03:39:07.5;\n" + 
		"2939;Aeschlimann Ulrich;1951;Gippingen;03:13:16.6;\n" + 
		"2940;Ismajli Alban;1978;Utzenstorf;03:42:49.6;\n" + 
		"2941;Iten Ralph;1975;Hausen am Albis;04:28:17.3;\n" + 
		"2942;Iten Roman;1977;Rheinau;03:48:06.4;\n" + 
		"2944;Jacky Florian;1991;Dietikon;03:57:40.1;\n" + 
		"2946;Jacobs Reto;1964;Z�rich;03:21:41.6;\n" + 
		"2949;J�ger Fabian;1979;Z�rich;04:16:02.4;\n" + 
		"2950;J�ggi Andreas;1969;Stein AR;03:40:32.7;\n" + 
		"2951;J�hde Oliver;1974;Winterthur;03:28:19.8;\n" + 
		"2954;Janes Paul;1979;Z�rich;03:29:51.7;\n" + 
		"2955;Janssen Volker;1958;Hagendorn;03:50:45.8;\n" + 
		"2962;Jegerlehner Andreas;1962;Glash�tten;05:07:38.7;\n" + 
		"2963;Jenny Florian;1983;Z�rich;03:58:43.3;\n" + 
		"2965;Jimenez Jos� Manuel;1969;M�llheim Dorf;03:30:23.0;\n" + 
		"2967;J�chle Werner;1966;Oberglatt ZH;04:28:05.2;\n" + 
		"2970;Johnson Mike;1979;Richterswil;03:29:50.5;\n" + 
		"2971;Joos Markus;1963;Trimmis;02:40:24.0;\n" + 
		"2972;J�rgensen Martin;1971;Schaffhausen;04:05:49.6;\n" + 
		"2973;J�ri Sandro;1985;Alpnach Dorf;02:45:27.7;\n" + 
		"2974;Jornot-Schmitt Michael;1963;Dietikon;04:23:37.8;\n" + 
		"2975;Joss Marc;1972;Lostorf;02:57:44.3;\n" + 
		"2977;Jost Urs;1964;Ruppoldsried;03:39:56.8;\n" + 
		"2984;Jud Toni;1956;Rufi;02:52:57.6;\n" + 
		"2985;Juengling Stephan;1966;Z�rich;03:43:04.6;\n" + 
		"2988;Jung Urs;1963;Grub AR;03:21:31.7;\n" + 
		"2989;Jutz Josef Sepp;1953;Eglisau;04:48:17.4;\n" + 
		"2990;Jutz Otto;1972;Arbon;03:14:52.0;\n" + 
		"2991;Jutz Stephan;1971;Affoltern am Albi;04:16:13.2;\n" + 
		"2992;Jutzi Urs;1964;Oberdiessbach;04:54:10.1;\n" + 
		"2994;Kaderli Oliver;1970;Salenstein;04:03:21.3;\n" + 
		"2995;K�gi Benjamin;1971;Horgen;04:15:08.3;\n" + 
		"2996;K�gi Christian;1953;Obfelden;04:35:32.5;\n" + 
		"2997;K�gi Rolf;1964;Uster;03:54:31.9;\n" + 
		"2998;Kaiser Walter;1948;Thalwil;05:10:37.2;\n" + 
		"2999;K�lin Christian;1958;Stallikon;03:28:06.3;\n" + 
		"3000;Stampfli Marc;1973;Ober�geri;04:23:41.2;\n" + 
		"3001;K�lin Stefan;1965;Z�rich;03:07:00.7;\n" + 
		"3003;Kalt Markus;1959;Wangen SZ;02:57:56.6;\n" + 
		"3004;Kameni Ga�tan;1972;Z�rich;03:28:13.3;\n" + 
		"3005;Kamer Stefan;1965;Obernau;03:08:06.5;\n" + 
		"3006;K�nzig J�rg;1951;Z�rich;03:57:34.5;\n" + 
		"3008;Karlen Werner;1967;Embrach;04:23:48.6;\n" + 
		"3010;K�ser Hans;1952;Anwil;03:56:16.3;\n" + 
		"3011;Kastrati Albert;1991;Kloten;05:21:39.8;\n" + 
		"3012;Kathriner Reto;1973;Cham;03:01:41.9;\n" + 
		"3013;K�tsch Hans-Martin;1965;Hasliberg Goldern;04:24:59.6;\n" + 
		"3016;Kaufmann Corrado;1958;Moutier;04:19:27.1;\n" + 
		"3017;Kaufmann Ferdi;1947;Z�rich;03:43:39.3;\n" + 
		"3018;Kaufmann Hubert;1967;Buttisholz;03:04:03.6;\n" + 
		"3019;Kaufmann Michael;1968;D�rnten;02:53:19.2;\n" + 
		"3022;Kehl Arthur;1963;Z�rich;03:41:36.8;\n" + 
		"3023;Keller Christian;1968;Z�rich;02:53:05.9;\n" + 
		"3027;Keller Michael;1973;Luzern Reussb�hl;03:14:50.1;\n" + 
		"3030;Kellerhals Martin;1970;Niederbipp;02:59:54.3;\n" + 
		"3032;Kempter Christoph;1967;Neuendorf;03:47:44.2;\n" + 
		"3034;Kerenyi Alexander;1971;Br�ttisellen;03:24:44.5;\n" + 
		"3035;Kern Andreas;1963;Glattbrugg;04:27:23.6;\n" + 
		"3036;Kern Daniel;1964;Z�rich;03:34:17.1;\n" + 
		"3037;Kersten Udo;1967;Z�rich;03:58:34.3;\n" + 
		"3038;Kessler Beat;1959;Hedingen;03:22:49.2;\n" + 
		"3039;Kessler Marcel;1969;Lengnau BE;04:36:38.0;\n" + 
		"3040;Kessler Nicolas;1974;Orsonnens;02:54:36.3;\n" + 
		"3041;Kessler Thomas;1966;Elsau;04:17:33.7;\n" + 
		"3042;Key Matthew;1975;Baden;03:41:19.8;\n" + 
		"3043;Kimati Celso;1965;Luzern;04:34:19.4;\n" + 
		"3045;Kirchmayr Wolfgang;1964;Therwil;03:36:00.5;\n" + 
		"3047;Kirst Christian;1975;Z�rich;03:06:06.1;\n" + 
		"3048;Kiser Felix;1949;Meggen;04:31:01.6;\n" + 
		"3049;Kistler Roger;1971;Lachen SZ;03:26:48.5;\n" + 
		"3051;Klaus Oliver;1973;Tuggen;03:04:59.5;\n" + 
		"3052;Kl�usler Stefan;1962;Winterthur;03:02:23.3;\n" + 
		"3055;Klingelfuss Marc;1965;Adliswil;03:52:57.3;\n" + 
		"3056;Klingenberg Bj�rn;1969;Gr�ningen;03:11:35.5;\n" + 
		"3057;Klopfenstein Marco;1981;Hilterfingen;03:41:02.8;\n" + 
		"3059;Klotz Matthias;1972;Biel/Bienne;02:53:23.2;\n" + 
		"3060;Klotzsch Thomas;1958;Oftringen;02:57:37.5;\n" + 
		"3062;Knapp Christian;1967;Z�rich;03:11:29.8;\n" + 
		"3064;Knobel Albert;1950;Altendorf;03:13:01.7;\n" + 
		"3067;Koch Dominik;1981;Eptingen;02:45:03.4;\n" + 
		"3068;Kock Carsten;1979;Jona;02:59:08.3;\n" + 
		"3069;Kodlinsky Christian;1973;Othmarsingen;04:37:31.6;\n" + 
		"3072;Kohler Marcel;1982;Z�rich;05:10:40.1;\n" + 
		"3073;Kohler Pirmin;1974;N�nikon;04:00:18.2;\n" + 
		"3077;Koller Gerold;1980;Steinen;02:59:33.2;\n" + 
		"3079;K�lliker Thomas;1976;Eich;03:14:11.2;\n" + 
		"3080;Kolly Jean-Bernard;1979;Tentlingen;03:13:14.0;\n" + 
		"3081;K�nigbauer Stefan;1983;Winterthur;03:43:36.7;\n" + 
		"3086;Koskela Ari;1961;Adliswil;03:09:54.7;\n" + 
		"3088;Kostic Milan;1982;Z�rich;03:57:18.7;\n" + 
		"3089;Koutny Zdenek;1958;M�hlin;03:23:51.1;\n" + 
		"3091;Kr�hemann Thomas;1977;Wil SG;03:40:47.4;\n" + 
		"3093;Kral Philipp;1981;Z�rich;04:19:30.0;\n" + 
		"3095;Krause Rainer;1962;D�rflingen;03:14:44.7;\n" + 
		"3097;Krebs Marcel;1969;Basel;03:38:13.1;\n" + 
		"3098;Krebs Markus;1961;Br�ttisellen;03:33:16.8;\n" + 
		"3100;Krebs Sandro;1970;Uttigen;03:47:07.4;\n" + 
		"3101;Krebs Thomas;1965;Pf�ffikon ZH;03:41:12.5;\n" + 
		"3103;Kreis Pablo;1973;Z�rich;04:03:57.3;\n" + 
		"3104;Kreis Simon;1987;Neukirch (Egnach);03:19:31.0;\n" + 
		"3107;Krieger Urs;1970;R�schlikon;02:59:44.4;\n" + 
		"3108;Kron Marius;1959;Muri AG;03:18:23.7;\n" + 
		"3109;Krucher Daniel;1964;Z�rich;03:13:52.3;\n" + 
		"3112;Kubli J�rg;1957;W�denswil;03:45:40.2;\n" + 
		"3113;Kuczynski Roman;1980;Z�rich;03:25:29.1;\n" + 
		"3116;Kuhn Bruno;1957;Schinznach Bad;04:09:49.9;\n" + 
		"3119;K�hne Raphael;1956;Flawil;03:23:39.4;\n" + 
		"3121;Kuipers Dennis;1971;Zug;02:42:30.1;\n" + 
		"3122;Kulendik Martin;1982;Fehraltorf;04:29:19.8;\n" + 
		"3124;K�min Michael;1988;Wollerau;05:05:16.6;\n" + 
		"3127;K�ndig Walter;1962;Hochdorf;03:24:59.1;\n" + 
		"3128;K�ng Martin;1970;Waldstatt;03:56:01.3;\n" + 
		"3129;K�ng Ralf;1974;Hochfelden;04:11:58.5;\n" + 
		"3130;Kunkel Maximilian;1982;Z�rich;03:07:48.5;\n" + 
		"3131;Kunz Dieter;1973;R�schlikon;04:22:50.6;\n" + 
		"3132;Kunz Gerhard;1969;Urswil;03:09:07.6;\n" + 
		"3133;Kunz Markus;1969;Arni-Islisberg;04:40:40.0;\n" + 
		"3136;K�nzle Peter;1949;Kirchberg SG;03:16:12.1;\n" + 
		"3137;Kupny Wojciech;1980;R�schlikon;05:23:35.3;\n" + 
		"3140;Kushwaha Imran;1972;D�rnten;03:12:23.2;\n" + 
		"3141;K�ttel Lars;1972;Obernau;03:45:04.6;\n" + 
		"3142;K�ttel Peter;1978;K�ssnacht am Rigi;02:58:08.2;\n" + 
		"3143;K�ttel Ruedi;1971;Schmerikon;03:23:20.7;\n" + 
		"3145;Kyburz Reto;1968;Z�rich;03:23:32.8;\n" + 
		"3146;Lagotzki Andreas;1962;Leuggern;04:21:42.7;\n" + 
		"3148;Lamard David;1970;Ecublens VD;03:36:50.7;\n" + 
		"3149;Lambert Gerard;1953;Wettswil;04:02:37.0;\n" + 
		"3150;Lampart Remo;1966;Benglen;03:26:15.9;\n" + 
		"3151;Landi Marco;1980;Buchs AG;03:23:33.8;\n" + 
		"3152;Landtwing Martin;1957;Dietlikon;04:54:11.6;\n" + 
		"3154;Langenegger Christian;1982;Z�rich;03:25:43.7;\n" + 
		"3157;Langridge James;1976;Kemptthal;03:43:34.7;\n" + 
		"3158;Lanter Guido;1968;Z�rich;03:39:57.9;\n" + 
		"3159;Lanz Peter;1961;Oberengstringen;04:07:17.9;\n" + 
		"3161;Larsson David;1989;Adliswil;03:56:14.8;\n" + 
		"3163;Lasser Philippe;1970;Z�rich;03:51:09.8;\n" + 
		"3164;Laticevschi Dumitru;1969;Gen�ve;03:35:32.4;\n" + 
		"3168;Lay Daniel;1982;Z�rich;03:42:40.1;\n" + 
		"3169;Le Quang Duc;1964;La Chaux-de-Fonds;03:59:50.7;\n" + 
		"3170;Ledergerber Ruedi;1958;St�fa;04:32:10.3;\n" + 
		"3171;Ledergerber Stefan;1970;Glattbrugg;04:32:10.5;\n" + 
		"3174;Leek Peter;1978;Z�rich;02:59:20.8;\n" + 
		"3179;Lehner J�rg;1979;Gr�nichen;03:57:37.1;\n" + 
		"3182;Leimgruber J�rg;1963;Dietikon;03:15:32.3;\n" + 
		"3186;Lennon Mark Antony;1968;Buonas;04:03:01.3;\n" + 
		"3187;Lerose Luigi;1982;Z�rich;03:54:21.4;\n" + 
		"3188;Leserf Gottlieb;1938;Uster;04:38:43.5;\n" + 
		"3189;Letta Marco;1965;Abtwil SG;03:24:07.6;\n" + 
		"3190;Leuenberger Frank;1974;Liestal;03:36:30.0;\n" + 
		"3191;Leuenberger Hans;1964;Bremgarten AG;03:54:21.9;\n" + 
		"3192;Leuenberger Michael;1973;D�ttwil AG;03:41:23.2;\n" + 
		"3194;Leuthold Bernhard;1971;Kloten;03:26:03.5;\n" + 
		"3197;Liard Gilles;1963;S�les (Gruy�re);03:21:25.7;\n" + 
		"3198;Lichtin J�rg;1967;Willisau;03:34:19.1;\n" + 
		"3199;Lichtsteiner Klemens;1970;Rothenburg;03:51:32.0;\n" + 
		"3200;Liechti Alexander;1955;Bisikon;04:10:06.8;\n" + 
		"3202;Lienhard C�dric;1977;Nyon;03:06:33.8;\n" + 
		"3203;Lienhard Tobias;1981;Z�rich;04:27:54.1;\n" + 
		"3209;Lindner Jack Olav;1967;Adliswil;03:26:11.1;\n" + 
		"3210;Lindsay Luke;1977;Z�rich;03:42:14.7;\n" + 
		"3211;Lippuner Christoph;1966;Frauenfeld;03:49:09.0;\n" + 
		"3212;Liver Richard;1976;Embrach;03:50:15.1;\n" + 
		"3214;Lloyd William;1980;Thalwil;03:35:22.3;\n" + 
		"3215;Locantore Paolo;1974;Oftringen;04:27:21.7;\n" + 
		"3217;Lockyer Mark;1991;Oberwil b. Zug;04:01:55.6;\n" + 
		"3218;Lockyer Paul;1965;Oberwil b. Zug;04:30:44.9;\n" + 
		"3220;Loher Martin;1959;Montlingen;03:26:47.0;\n" + 
		"3221;Lohri Philipp;1963;Frauenfeld;02:52:34.0;\n" + 
		"3222;Loiudice Giulio;1958;Schaffhausen;04:01:09.9;\n" + 
		"3223;Loosli Peter;1948;Riehen;03:21:24.2;\n" + 
		"3225;Lorenz Roman;1970;Spreitenbach;03:43:56.6;\n" + 
		"3226;Lorenz Tino;1975;Ch�telaine;03:50:20.8;\n" + 
		"3230;Louis Jvan;1990;Nesslau;03:39:52.0;\n" + 
		"3231;Loye Eric;1963;Haute-Nendaz;03:27:17.7;\n" + 
		"3234;Luder Beat;1972;Kirchberg BE;02:44:46.7;\n" + 
		"3236;Luginb�hl Guy;1963;Z�rich;03:36:20.6;\n" + 
		"3238;L��nd Urs;1965;Brunnen;03:42:14.2;\n" + 
		"3239;Lupp Bjoern;1973;Bottmingen;04:04:57.0;\n" + 
		"3241;L�scher Urs;1974;Arni AG;03:00:51.0;\n" + 
		"3242;Lustenberger Silvan;1967;Oberglatt ZH;03:46:35.3;\n" + 
		"3243;Lusti Andr�;1961;Unterengstringen;03:41:12.8;\n" + 
		"3246;Lutz Hansj�rg;1953;Glattfelden;03:47:12.2;\n" + 
		"3248;Luzzani Roger;1975;Schattdorf;02:57:26.5;\n" + 
		"3250;Maccioni Sandro;1965;Hinteregg;04:04:04.7;\n" + 
		"3251;Machowetz Alex;1984;Z�rich;03:49:38.8;\n" + 
		"3253;Macquarrie Hugh;1978;Z�rich;04:08:57.1;\n" + 
		"3254;Stadler Christian;1974;Dielsdorf;02:51:48.2;\n" + 
		"3255;Magnenat David;1977;Z�rich;03:26:51.3;\n" + 
		"3256;Maier J�rgen;1970;Alten;03:47:16.1;\n" + 
		"3259;Maier Robert;1973;Kilchberg ZH;03:57:45.8;\n" + 
		"3260;Maier Thomas;1977;Dielsdorf;05:04:51.4;\n" + 
		"3261;Maier-Thurn Marcus;1974;Horgen;05:25:28.0;\n" + 
		"3262;Maillard Joel;1961;Winterthur;04:23:55.4;\n" + 
		"3263;Maillefer Jo�l;1969;Cheseaux-Nor�az;02:45:44.7;\n" + 
		"3264;Maio Giuseppe;1961;Z�rich;03:55:33.4;\n" + 
		"3268;Mani Simon;1964;Weggis;02:50:34.2;\n" + 
		"3269;Mann Felix;1967;Clarmont;03:38:33.8;\n" + 
		"3272;Marchand Antoine;1979;Colombier NE;02:46:45.4;\n" + 
		"3273;Marchand Tony;1970;St-Imier;02:52:58.6;\n" + 
		"3278;Mariuzzo Christian;1964;Bernex;03:27:13.4;\n" + 
		"3279;Marrel David;1975;Wettingen;03:21:55.0;\n" + 
		"3280;Marro Alain;1967;Gen�ve;03:20:56.9;\n" + 
		"3283;Marta Massimo;1973;Roveredo GR;03:24:48.8;\n" + 
		"3284;Martel Sylvain;1972;Lausanne;03:34:24.9;\n" + 
		"3286;Marti Michael;1968;Rorschacherberg;03:59:00.9;\n" + 
		"3287;Martin Javier;1983;Z�rich;04:33:40.7;\n" + 
		"3289;Martin Sergio;1982;Jonen;03:37:34.2;\n" + 
		"3291;Martino Giuseppe;1968;Vezia;03:32:26.7;\n" + 
		"3292;Marty Patrick;1975;Derendingen;03:12:04.6;\n" + 
		"3293;Marty Philipp;1975;H�nibach;04:27:48.1;\n" + 
		"3296;Matos Gilberto;1975;Z�rich;04:06:32.7;\n" + 
		"3297;Matter Chrigi;1975;Ebmatingen;04:41:38.8;\n" + 
		"3298;Mattheis Hartmut;1969;Seewen SZ;05:12:34.9;\n" + 
		"3300;Mattle Paul;1958;Widnau;03:46:07.8;\n" + 
		"3301;Mattm�ller Martin;1954;Winterthur;03:45:00.0;\n" + 
		"3303;Maurer Heinz;1964;Ch�serex;03:15:31.1;\n" + 
		"3304;Maurer Oliver;1984;Unterentfelden;03:25:13.3;\n" + 
		"3305;Maurer Urs;1965;Hittnau;03:17:04.8;\n" + 
		"3306;Maury Laribiere Martia;1962;Gockhausen;03:37:06.3;\n" + 
		"3308;Mayer Jens;1975;Winterthur;03:53:36.6;\n" + 
		"3311;Mccreadie Murray;1959;Luzern;02:57:57.5;\n" + 
		"3313;Mecchia Francesco;1969;Z�rich;03:59:13.7;\n" + 
		"3314;Meier Andreas;1964;Elsau;03:37:11.4;\n" + 
		"3315;Meier Daniel;1964;Aarau;03:51:59.7;\n" + 
		"3316;Meier Elias;1992;Illnau;03:23:41.4;\n" + 
		"3317;Meier Franz;1960;Windisch;03:35:51.3;\n" + 
		"3318;Meier Heinz;1958;Winterthur;03:35:11.1;\n" + 
		"3319;Meier Kusi;1963;Baden;04:36:10.4;\n" + 
		"3320;Meier Marcel;1968;Niederhasli;03:57:58.0;\n" + 
		"3321;Meier Marcel;1963;Unterb�zberg;03:56:53.4;\n" + 
		"3322;Meier Michael;1966;Baden;03:24:24.0;\n" + 
		"3323;Meier Patrick;1971;Langnau am Albis;03:45:18.5;\n" + 
		"3325;Meier Peter;1966;B�ren SO;04:17:58.2;\n" + 
		"3328;Meier Roland;1964;Herzogenbuchsee;03:57:37.9;\n" + 
		"3329;Meier Simon;1982;Z�rich;03:09:02.0;\n" + 
		"3330;Meier Stefan;1954;Fehraltorf;05:18:06.7;\n" + 
		"3332;Meierhans Roman;1974;Z�rich;03:49:47.5;\n" + 
		"3333;Felix Manuela;1965;Z�rich;04:27:31.7;\n" + 
		"3334;Meisser Reto;1970;Uster;03:43:24.9;\n" + 
		"3335;Meister Roger;1978;Z�rich;04:08:36.6;\n" + 
		"3337;Mele Piero;1987;Ettingen;04:17:55.5;\n" + 
		"3338;Melzer Tino;1961;Kreuzlingen;03:01:31.3;\n" + 
		"3339;Menghini Daniel;1968;N�rensdorf;03:40:05.3;\n" + 
		"3340;Menzi Micha;1976;R�ti ZH;03:07:26.1;\n" + 
		"3342;Merkle Othmar;1963;Kreuzlingen;03:18:39.4;\n" + 
		"3343;Merkt Peter;1964;H�ntwangen;02:46:41.7;\n" + 
		"3345;Merup Christian;1986;Z�rich;03:11:09.0;\n" + 
		"3347;Mesaros Thomas;1978;St. Gallen;03:31:36.5;\n" + 
		"3349;Metger Georg;1968;Dottikon;04:11:15.4;\n" + 
		"3351;Metzler Hans;1961;Freidorf TG;03:28:18.4;\n" + 
		"3352;Meuris Richard;1981;Z�rich;03:56:30.3;\n" + 
		"3353;Meyer Daniel;1964;Amriswil;03:54:19.2;\n" + 
		"3356;Meyer Stephan;1964;D�llikon;03:39:00.0;\n" + 
		"3358;Michel Dominique;1966;Sierre;02:53:22.9;\n" + 
		"3359;Michel Walter;1953;Kloten;03:28:38.6;\n" + 
		"3360;Michnac Ivan;1957;B�lach;03:17:43.2;\n" + 
		"3361;Milesi Luca;1976;Arbedo;03:29:29.2;\n" + 
		"3362;Milic Mladen;1971;Z�rich;03:50:36.8;\n" + 
		"3363;Millius Beat;1959;Baltschieder;03:05:01.2;\n" + 
		"3366;Misic Andrija;1981;Z�rich;03:45:35.2;\n" + 
		"3367;Misiek Wiktor;1968;Kloten;04:39:59.9;\n" + 
		"3368;Mistretta Antinoo;1967;Ebikon;03:22:25.9;\n" + 
		"3369;Mittelholcz B�la;1979;Z�rich;02:59:34.5;\n" + 
		"3374;Moehlecke Thomas;1969;Lupfig;03:38:22.7;\n" + 
		"3375;Moggi Christoph;1961;Bonstetten;03:07:46.8;\n" + 
		"3376;Mohring Stephan;1975;Adliswil;04:14:29.0;\n" + 
		"3377;Mollitt Andrew;1973;Stallikon;03:43:01.7;\n" + 
		"3379;Monachon Jean-Claude;1960;Heimensten;03:48:13.6;\n" + 
		"3380;Monney Roland;1961;M�ni�res;03:55:16.2;\n" + 
		"3381;Montanari Matteo;1953;Z�rich;03:58:59.3;\n" + 
		"3382;Monterosso Germano;1996;Feuerthalen;04:11:41.3;\n" + 
		"3383;Monterosso Vincenzo;1964;Dachsen;03:31:29.0;\n" + 
		"3384;Mordasini Niccolo;1985;St. Gallen;03:50:29.5;\n" + 
		"3385;Moret Eloi;1966;M�ni�res;04:20:10.4;\n" + 
		"3387;Morley Tim;1974;Horgen;05:01:53.6;\n" + 
		"3388;Moscetti Christian;1973;Agno;04:23:30.5;\n" + 
		"3389;Moser Felix;1968;Z�rich;03:25:57.2;\n" + 
		"3390;Moser Rudolf;1960;Belp;03:36:15.4;\n" + 
		"3391;Mosetti Nicolas;1966;Froideville;03:07:06.4;\n" + 
		"3392;Mourtada Samir Paul;1962;Zug;04:04:00.4;\n" + 
		"3393;Mozzi Guido;1944;Z�rich;04:58:45.1;\n" + 
		"3395;Muehlethaler Adrian;1975;Bern;03:05:54.3;\n" + 
		"3397;Muff Christian;1951;Obernau;03:17:48.1;\n" + 
		"3398;Muff Ren�;1960;K�niz;02:59:55.7;\n" + 
		"3399;Muff Roland;1976;Z�rich;03:44:48.1;\n" + 
		"3402;M�ller Andreas;1961;Winterthur;04:19:43.0;\n" + 
		"3403;M�ller Bruno;1970;Udligenswil;02:59:29.8;\n" + 
		"3404;M�ller Daniel;1973;K�ssnacht am Rigi;02:41:27.6;\n" + 
		"3407;M�ller Hans-J�rg;1960;Bonstetten;03:39:32.5;\n" + 
		"3408;M�ller Hansruedi;1959;Rudolfingen;04:54:25.1;\n" + 
		"3409;M�ller Heinrich;1951;Hombrechtikon;04:50:24.5;\n" + 
		"3412;M�ller Lukas;1970;Wettswil;02:58:48.0;\n" + 
		"3414;M�ller Michael;1981;Steinmaur;03:27:18.4;\n" + 
		"3415;M�ller Michael;1953;Effretikon;04:47:25.2;\n" + 
		"3416;M�ller Patrick;1965;Kloten;03:20:42.2;\n" + 
		"3417;M�ller Rolf;1960;Z�rich;03:24:52.5;\n" + 
		"3418;M�ller Ronnie;1974;Ennetbaden;03:37:55.2;\n" + 
		"3420;M�ller Thomas;1962;Z�rich;03:18:13.2;\n" + 
		"3422;Mumenthaler Stephan;1971;Z�rich;03:18:08.8;\n" + 
		"3423;Munz Thomas;1957;Bern;04:44:53.8;\n" + 
		"3424;Murer Werner;1962;Zug;04:12:53.0;\n" + 
		"3425;Muriqi Agron;1971;Niederuzwil;03:51:22.8;\n" + 
		"3426;Murray Mark;1969;Jonen;03:12:56.2;\n" + 
		"3428;Nachbaur Gerd;1972;Corcelles-pr�s-Pa;03:42:44.4;\n" + 
		"3431;Nater Remo;1989;Wittenbach;03:15:12.2;\n" + 
		"3432;Naylor Charles;1956;Z�rich;03:55:34.7;\n" + 
		"3433;Nazabal Alexis;1975;Z�rich;03:27:10.9;\n" + 
		"3436;Neff Armin;1960;Amriswil;03:23:51.9;\n" + 
		"3438;Neff Yanick;1983;Z�rich;03:35:05.6;\n" + 
		"3443;Neul�ndner Martin;1961;Oberuzwil;03:45:52.5;\n" + 
		"3445;Neum�ller Peter;1975;Wetzikon ZH;02:59:15.1;\n" + 
		"3447;Nicolet Samuel;1981;Bulle;02:57:24.5;\n" + 
		"3448;Niederberger Guido;1970;Menznau;05:01:39.4;\n" + 
		"3449;Niederberger Philippe;1976;Islisberg;03:11:47.0;\n" + 
		"3450;Niederer Christian;1959;Endingen;03:44:10.4;\n" + 
		"3451;Niedermair Uli;1983;Uster;03:13:04.2;\n" + 
		"3452;Niethammer Thomas;1960;Flawil;03:22:03.9;\n" + 
		"3454;Niklaus Michael;1988;Kirchberg BE;03:26:55.0;\n" + 
		"3457;Nobis Markus;1973;Solothurn;03:30:49.1;\n" + 
		"3460;Noli Lorenz;1978;Schliern b. K�niz;03:57:45.7;\n" + 
		"3462;Notter Ren�;1967;Walchwil;04:10:33.5;\n" + 
		"3463;Notter Stefan;1966;Luzern;03:13:32.4;\n" + 
		"3464;Notz Ruedi;1963;Bonstetten;04:12:35.0;\n" + 
		"3465;Nussbaum Walter;1958;Muttenz;02:51:47.6;\n" + 
		"3467;Nutt Reto;1958;Z�rich;03:31:59.7;\n" + 
		"3469;Nyikos Thomas;1980;Z�rich;02:58:29.4;\n" + 
		"3471;Oberkalmsteiner Karl;1944;Sch�nis;03:25:11.7;\n" + 
		"3472;Oberle Adrian;1982;Z�rich;03:32:21.9;\n" + 
		"3474;Obermeit Volker;1957;Z�rich;03:48:01.2;\n" + 
		"3475;Obrecht Walter;1959;H�nenberg See;03:41:35.5;\n" + 
		"3476;Ochsner Daniel;1975;Winterthur;03:50:44.7;\n" + 
		"3477;Ochsner Harry;1971;Z�rich;03:57:42.9;\n" + 
		"3478;Odermatt Fredi;1955;Adligenswil;03:14:26.0;\n" + 
		"3479;Odermatt Michael;1975;Rothenburg;02:56:50.0;\n" + 
		"3480;Odermatt Urs;1961;Merlischachen;03:18:56.2;\n" + 
		"3481;Oehninger Ernst;1936;Watt;04:44:48.1;\n" + 
		"3482;Oester Patrick;1975;Gen�ve;04:29:57.7;\n" + 
		"3485;Omollo Omondi;1962;Winterthur;03:39:25.4;\n" + 
		"3486;Oppitz Lothar;1962;St. Gallen;03:30:46.4;\n" + 
		"3487;Oppitz Ulrich;1966;Bern;03:33:17.7;\n" + 
		"3488;Oppliger Christophe;1972;Lonay;02:58:07.5;\n" + 
		"3489;Oreilly David;1968;Winterthur;03:22:25.4;\n" + 
		"3490;Ortega Ilias;1961;Z�rich;04:50:08.7;\n" + 
		"3491;Ortkemper Frank;1972;Baar;04:00:41.3;\n" + 
		"3492;Ott Manuel;1976;St�fa;04:19:27.5;\n" + 
		"3493;Otter Ueli;1957;Subingen;04:05:48.4;\n" + 
		"3494;Overbeck Gernot;1965;Basel;04:04:16.5;\n" + 
		"3497;Overeem Joost;1965;Stetten SH;04:00:38.8;\n" + 
		"3498;Paccaud Christophe;1978;Lausanne;03:23:05.7;\n" + 
		"3499;Pacozzi Romeo;1961;Birchwil;03:54:08.0;\n" + 
		"3501;Page Basile;1985;Morlon;03:24:58.5;\n" + 
		"3503;Pagy Eilam;1974;Kilchberg ZH;04:17:56.6;\n" + 
		"3504;Palmiere Cristian;1972;Nyon;03:36:36.7;\n" + 
		"3505;Panatti Erik;1987;Castasegna;02:55:22.0;\n" + 
		"3510;Passera Giacomo;1980;Volketswil;03:58:51.6;\n" + 
		"3512;Pauchard Patrick;1969;Cousset;03:42:45.6;\n" + 
		"3517;Pedrini Claudio;1980;Opfikon;04:34:43.7;\n" + 
		"3518;Peinsold Martin;1984;Seon;03:23:16.6;\n" + 
		"3519;Pellegrini Flavio;1981;Z�rich;03:19:52.9;\n" + 
		"3520;Pellet Laurent;1958;Z�rich;03:30:38.5;\n" + 
		"3521;Peng Pierre;1949;Uster;05:29:00.9;\n" + 
		"3522;Pepe Pasquale;1961;Hinteregg;03:55:45.2;\n" + 
		"3527;Perisset Laurent;1982;Esmonts;03:27:54.1;\n" + 
		"3531;Perseghini Mauro;1975;Montagnola;03:06:10.0;\n" + 
		"3532;Pescheta Donato;1983;Effretikon;02:47:34.7;\n" + 
		"3533;Peter Guido;1966;D�bendorf;04:13:58.5;\n" + 
		"3534;Peterhans Urs;1961;Bassersdorf;04:45:28.4;\n" + 
		"3535;Petrig Markus;1964;Einsiedeln;03:42:58.9;\n" + 
		"3536;Peyer Thomas;1986;Z�rich;03:43:03.0;\n" + 
		"3537;Pf�ffli Roger;1979;Wil SG;04:23:41.2;\n" + 
		"3538;Pf�ndler Jonas;1985;Full-Reuenthal;03:23:40.4;\n" + 
		"3540;Pfenninger Roland;1967;Uster;04:25:03.0;\n" + 
		"3541;Pfister Felix;1959;Menzingen;03:49:12.2;\n" + 
		"3542;Pfister Heinz;1956;Thayngen;04:49:13.4;\n" + 
		"3543;Pfister Jeremias;1982;Erlinsbach SO;03:57:51.8;\n" + 
		"3544;Pfister Samuel;1986;M�llheim Dorf;04:19:00.1;\n" + 
		"3547;Pfyffer Roland;1961;W�renlingen;03:18:30.6;\n" + 
		"3548;Pfyffer Urs;1960;Luzern;03:20:18.4;\n" + 
		"3551;Pianaro Claudio;1961;D�bendorf;03:17:17.1;\n" + 
		"3557;Piguet Florian;1981;Biel/Bienne;02:44:03.2;\n" + 
		"3558;Pillard Luc;1973;Uster;05:12:05.1;\n" + 
		"3560;Piras Davide;1977;Z�rich;03:58:44.8;\n" + 
		"3561;Pirrello Antonino;1970;Z�rich;03:54:18.8;\n" + 
		"3562;Pirscher Andreas;1966;Freienwil;03:20:13.0;\n" + 
		"3563;Pittet Laurent;1975;Bercher;02:48:33.8;\n" + 
		"3564;Place Raymond;1971;Basel;03:57:29.2;\n" + 
		"3567;Ploetz Armin;1966;Jona;03:36:55.6;\n" + 
		"3568;Plum Carsten;1970;Liebefeld;03:28:52.6;\n" + 
		"3569;Pl�ss Fabian;1980;Z�rich;03:42:49.1;\n" + 
		"3571;Porfido Franco;1971;Kloten;03:25:53.3;\n" + 
		"3573;Portmann Hansj�rg;1971;Winterthur;03:18:53.2;\n" + 
		"3574;Portmann Marco;1977;H�nenberg;03:53:52.0;\n" + 
		"3575;N�meth Aniko;1975;D�bendorf;03:38:23.1;\n" + 
		"3576;Portmann Thomas;1969;St. Gallen;03:04:13.2;\n" + 
		"3578;Praz Max;1958;Sion;03:46:00.7;\n" + 
		"3581;Procacci Fabio;1962;Vevey;05:27:44.8;\n" + 
		"3582;Protze S�ren;1979;N�rensdorf;03:32:31.6;\n" + 
		"3583;Pulizzi Antonino;1958;Effretikon;04:30:16.3;\n" + 
		"3586;Putallaz Jean-Yves;1947;St-S�verin;03:46:42.2;\n" + 
		"3587;Quauka Daniel;1980;Altst�tten SG;03:24:49.4;\n" + 
		"3588;Quirici Giulio;1959;Hinteregg;03:13:54.4;\n" + 
		"3589;Raca Mirko;1984;Lausanne;03:56:05.5;\n" + 
		"3590;Raccuglia Armando;1975;M�genwil;03:50:52.4;\n" + 
		"3593;Ramer Stefan;1963;Fahrwangen;03:47:44.9;\n" + 
		"3595;Randegger Erwin;1948;Adliswil;04:35:57.6;\n" + 
		"3596;Ranta Tommy;1981;Buchs AG;03:13:32.0;\n" + 
		"3597;Raschle Adrian;1962;Egnach;03:53:25.5;\n" + 
		"3598;Rasquinet Patrick;1967;Z�rich;05:33:14.5;\n" + 
		"3601;Raymann Patrick;1970;Lufingen;03:32:12.0;\n" + 
		"3603;Rechsteiner Helmut;1959;Romanshorn;03:28:02.9;\n" + 
		"3604;Rechsteiner Kuno;1979;Z�rich;02:54:25.3;\n" + 
		"3606;Rehm Martin;1968;Weggis;03:36:33.3;\n" + 
		"3607;Rehmet Joachim;1973;Z�rich;03:58:16.8;\n" + 
		"3608;Reichmuth Thomas;1986;Schwyz;03:43:29.9;\n" + 
		"3611;Reinhard-Miltz Gerhard;1956;Kreuzlingen;03:39:41.8;\n" + 
		"3612;Reinhardt Stephan;1966;Aarau;04:24:27.6;\n" + 
		"3614;Reitbauer Stefan;1980;Horgen;03:26:39.9;\n" + 
		"3617;Rentsch Peter;1959;Wollerau;04:22:15.2;\n" + 
		"3620;Reutemann Patrick;1975;Baar;04:39:43.6;\n" + 
		"3622;Rentsch Max;1967;Gelterkinden;03:21:56.5;\n" + 
		"3623;Rezzonico Andrea;1981;Z�rich;03:27:57.2;\n" + 
		"3625;Richter Carsten;1978;Feusisberg;03:15:23.8;\n" + 
		"3627;Richter Manfred;1971;Winterthur;04:25:00.3;\n" + 
		"3628;Richterich Lukas;1956;Basel;03:21:29.5;\n" + 
		"3631;Riedi Mattias;1979;Sedrun;04:03:12.7;\n" + 
		"3635;Riekert Patrick;1973;Hedingen;04:10:28.1;\n" + 
		"3637;Rigoni Bruno;1969;Obfelden;03:45:09.7;\n" + 
		"3638;Rinderknecht Christoph;1979;Neerach;03:39:20.5;\n" + 
		"3639;Rindlisbacher Martin;1969;M�nsingen;02:45:30.3;\n" + 
		"3640;Rippstein Guido;1953;Baden;03:45:54.2;\n" + 
		"3641;Risby Lee Alexander;1971;Cham;04:13:36.7;\n" + 
		"3642;Risi Christoph;1964;St. Niklausen LU;04:03:02.2;\n" + 
		"3643;Ritler Roger;1968;Winterthur;03:25:15.4;\n" + 
		"3644;Ritschard Mario;1970;Uetendorf;03:59:14.8;\n" + 
		"3645;Ritter Daniel;1964;Z�rich;03:21:43.3;\n" + 
		"3646;Ritz Daniel;1971;Diepoldsau;03:19:33.6;\n" + 
		"3647;Rizzello Roberto;1964;D�bendorf;04:23:05.6;\n" + 
		"3651;Rodelli Leo;1945;Turbenthal;03:59:53.5;\n" + 
		"3652;Roduit Pascal;1958;Martigny;03:38:15.8;\n" + 
		"3653;Roduner Christoph;1966;Balgach;04:00:27.0;\n" + 
		"3654;Roffler Markus;1962;Churwalden;03:32:14.8;\n" + 
		"3655;Rohner Marius;1990;Heiden;04:09:52.2;\n" + 
		"3656;Rohr Stephan;1980;Vira (Gambarogno);02:46:41.1;\n" + 
		"3657;Rohrer Hansruedi;1958;Rubigen;03:07:34.0;\n" + 
		"3659;R�llin Martin;1974;Zug;04:13:18.0;\n" + 
		"3660;Roman Emilio;1965;Thayngen;03:18:19.8;\n" + 
		"3664;Rosen Oliver;1975;Pully;03:43:32.7;\n" + 
		"3665;Rosic Renato;1973;Basel;04:39:25.6;\n" + 
		"3667;Rosset Gilles;1969;St-Aubin FR;03:43:26.7;\n" + 
		"3668;Rossi Lorenzo;1969;Uerikon;03:23:54.0;\n" + 
		"3669;Roth Heiner;1960;Hinwil;04:15:00.2;\n" + 
		"3670;Roth Nick;1978;Z�rich;03:36:42.9;\n" + 
		"3671;R�thlisberger Andres;1976;Winterthur;04:37:29.6;\n" + 
		"3672;R�thlisberger Sergio;1990;Z�rich;04:25:03.5;\n" + 
		"3673;R�thlisberger Urs;1973;Opfikon;04:16:25.6;\n" + 
		"3676;Roulet Vincent;1964;Ecoteaux;03:54:01.8;\n" + 
		"3680;R�ckstein Bruno;1978;Thalwil;04:34:57.3;\n" + 
		"3681;Rudaz G�rald;1957;Bramois;04:23:41.7;\n" + 
		"3682;Rudolf Hanspeter;1955;Bad Zurzach;03:27:18.9;\n" + 
		"3683;R�ede Christian;1969;Sulz AG;03:53:44.9;\n" + 
		"3684;R�ede Nico;1978;Kloten;03:59:46.6;\n" + 
		"3685;Rueegg Patrick Stefan;1973;Bassersdorf;03:44:51.7;\n" + 
		"3686;R�egg Armin;1959;Adliswil;04:53:59.0;\n" + 
		"3687;R�egg Walter;1964;Niederglatt ZH;03:27:05.9;\n" + 
		"3688;R�esch Peter;1961;Z�rich;03:42:38.2;\n" + 
		"3689;Ruf Andreas;1967;Wetzikon ZH;04:11:30.1;\n" + 
		"3693;Rupper Patrick;1960;Z�rich;03:56:31.2;\n" + 
		"3694;Rusch Stefan;1967;Wetzikon ZH;03:39:31.0;\n" + 
		"3706;Safi Kamran;1974;Winterthur;03:52:32.5;\n" + 
		"3708;S�gesser Simon;1969;Reinach BL;03:10:45.4;\n" + 
		"3710;Salamin Michel;1963;Martigny;03:14:35.9;\n" + 
		"3713;Salmi Janne;1969;Forch;02:40:56.0;\n" + 
		"3715;Salzmann Urs;1955;Worb;02:58:48.1;\n" + 
		"3716;Sanchez Walter;1976;Mettmenstetten;05:02:44.7;\n" + 
		"3718;Sano Shogo;1986;Dietikon;04:07:36.9;\n" + 
		"3721;Sara Bened� Enrique;1970;Z�rich;03:49:28.4;\n" + 
		"3723;Sauder Patrick;1966;Oberb�zberg;02:46:46.9;\n" + 
		"3724;Saurer Werner;1962;Gr�ningen;03:51:01.8;\n" + 
		"3725;Sauter Markus;1958;Salenstein;03:05:55.1;\n" + 
		"3726;Savill Ian;1971;Z�rich;04:04:16.3;\n" + 
		"3727;Savola Juha;1958;Reinach BL;02:59:23.7;\n" + 
		"3729;Schaad Marco;1976;Matzendorf;02:59:09.3;\n" + 
		"3730;Schaad Thomas;1977;Basel;03:31:23.0;\n" + 
		"3731;Schaerer Bruno;1949;Geroldswil;04:37:21.1;\n" + 
		"3732;Schaermeli Claudio;1980;Romanshorn;03:32:27.7;\n" + 
		"3733;Sch�fer Andreas;1977;Z�rich;04:44:07.9;\n" + 
		"3734;Sch�fer Roger;1970;Embrach;03:54:43.3;\n" + 
		"3735;Sch�ffer Beat;1974;Schwerzenbach;03:30:50.2;\n" + 
		"3739;Sch�r Markus;1970;Rheineck;03:25:26.7;\n" + 
		"3740;Sch�rer Kurt;1941;Worb;03:38:13.8;\n" + 
		"3741;Sch�rli Christoph;1981;Sempach Stadt;04:27:06.9;\n" + 
		"3742;Schaub Rolf;1952;Z�rich;03:40:58.9;\n" + 
		"3743;Schegg Stefan;1978;Kriessern;03:53:05.2;\n" + 
		"3745;Scheidegger Ren�;1955;Spreitenbach;03:34:04.4;\n" + 
		"3746;Schelbert Armin;1976;Muotathal;03:17:03.3;\n" + 
		"3749;Schenk Felix;1964;Wigoltingen;02:40:59.9;\n" + 
		"3750;Schenkel Patrick;1973;Stein am Rhein St;03:54:05.6;\n" + 
		"3753;Scherer Kurt;1963;Udligenswil;02:48:44.0;\n" + 
		"3757;Scherzinger Fredy;1955;Schmerikon;03:47:12.0;\n" + 
		"3758;Schibig Viktor;1948;Illnau;04:14:23.6;\n" + 
		"3763;Schilling Martin;1971;Neuhausen am Rhei;03:26:17.5;\n" + 
		"3765;Schl�fli Matthias;1977;Thalwil;03:27:33.2;\n" + 
		"3766;Schl�pfer Marco;1984;Z�rich;03:41:13.5;\n" + 
		"3767;Schlatter Adrian;1965;Basel;02:47:58.4;\n" + 
		"3768;Schlatter David;1955;Amriswil;03:56:07.0;\n" + 
		"3771;Schlicht Michael;1974;Niederrohrdorf;03:56:54.8;\n" + 
		"3772;Schlub Jarbas;1975;Z�rich;03:32:39.0;\n" + 
		"3773;Schl�chter Roland;1966;Teufen AR;04:08:56.7;\n" + 
		"3777;Schmid Philipp;1986;Wald AR;04:35:30.8;\n" + 
		"3779;Schmid Tobias;1969;Glattfelden;04:24:42.1;\n" + 
		"3780;Schmid Tom;1974;Buchs SG;03:50:12.9;\n" + 
		"3781;Schmid-Erni Reto;1963;Neukirch (Egnach);03:54:33.1;\n" + 
		"3785;Schmidt Roberto;1965;Ottenbach;03:28:11.7;\n" + 
		"3787;Schmidt Urs;1970;Seuzach;04:11:40.1;\n" + 
		"3788;Schmidt Urs-Peter;1967;Uster;03:24:14.3;\n" + 
		"3789;Schmied Bruno;1962;Ostermundigen;04:15:44.7;\n" + 
		"3792;Schmutz Dominik;1979;Riehen;03:10:12.2;\n" + 
		"3793;Schneckenburger Julian;1973;Andelfingen;03:20:55.8;\n" + 
		"3794;Schneider Hans-Peter;1963;Niederweningen;03:43:26.5;\n" + 
		"3795;Schneider Jochen;1959;Magglingen/Macoli;03:59:45.6;\n" + 
		"3797;Schneider Martin;1953;Wetzikon ZH;03:49:35.3;\n" + 
		"3798;Schneider Martin;1983;Niederuzwil;03:14:47.1;\n" + 
		"3800;Schneider Reto;1978;Derendingen;03:31:42.6;\n" + 
		"3803;Schn�riger Erwin;1964;Steinen;03:21:49.3;\n" + 
		"3805;Schnyder Roger;1962;Varen;02:39:40.0;\n" + 
		"3807;Schoch Christoph;1975;Z�rich;03:45:11.6;\n" + 
		"3808;Scholian Heinz;1958;Dietikon;03:18:56.5;\n" + 
		"3809;Scholl Hans;1946;Uetendorf;03:09:32.4;\n" + 
		"3813;Sch�nenberger Bruno;1960;Niederwil SG;03:44:13.9;\n" + 
		"3814;Sch�nenberger Felix;1969;F�llinsdorf;04:12:40.9;\n" + 
		"3815;Sch�nenberger Samuel;1984;St. Gallen;03:48:07.0;\n" + 
		"3816;Sch�nenberger Tim;1988;Windisch;03:22:48.0;\n" + 
		"3817;Sch�nenberger Urs;1971;Niederhelfenschwi;02:59:20.6;\n" + 
		"3818;Sch�nherr Andreas;1974;Z�rich;03:27:28.9;\n" + 
		"3819;Sch�ni Beat;1959;B�tterkinden;03:37:03.4;\n" + 
		"3820;Sch�ni Martin;1961;Hasle-R�egsau;03:14:32.6;\n" + 
		"3821;Schoppe Mathias;1965;St�fa;03:20:08.7;\n" + 
		"3822;Schorno Enrico;1960;Z�rich;03:27:34.8;\n" + 
		"3824;Schranz Fred;1959;Thun;03:13:16.8;\n" + 
		"3826;Schreiber Mark;1955;Embrach;03:30:52.4;\n" + 
		"3827;Schreiber Simon;1973;Z�rich;03:24:29.2;\n" + 
		"3829;Schr�der Jan;1967;Z�rich;03:45:37.6;\n" + 
		"3832;Sch�epp Daniel;1964;Stallikon;03:58:33.0;\n" + 
		"3834;Schuler Paul;1962;Adliswil;03:16:16.7;\n" + 
		"3835;Schuler Werner;1957;H�nenberg;04:56:45.6;\n" + 
		"3836;Schulte Christian;1976;Baar;03:47:49.3;\n" + 
		"3839;Schultheiss Tobias;1988;Zug;03:45:27.9;\n" + 
		"3840;Schulze Elko;1972;Rheinau;03:49:49.4;\n" + 
		"3843;Sch�pbach Fabian;1986;N�nikon;04:19:23.7;\n" + 
		"3844;Sch�tz Patrick;1969;Z�rich;02:54:51.3;\n" + 
		"3845;Sch�tz Reinhart;1964;Wetzikon ZH;03:06:23.8;\n" + 
		"3849;Schweitzer Pascal;1976;Baden;04:03:43.6;\n" + 
		"3850;Schweizer Marcel;1974;Dietlikon;04:37:07.7;\n" + 
		"3851;Schwery Rolf;1969;Biel/Bienne;04:49:04.8;\n" + 
		"3854;Scotece Gerardo;1963;Vilters;03:11:52.4;\n" + 
		"3856;Seeger Andreas;1974;Z�rich;04:15:25.0;\n" + 
		"3859;Seiler Rico;1959;Jona;03:19:04.9;\n" + 
		"3860;Seipel Oliver;1965;Oberembrach;04:28:28.1;\n" + 
		"3863;Seki Tomoo;1967;Z�rich;04:30:38.1;\n" + 
		"3864;Semadeni Gian Andrea;1961;R�schlikon;03:48:33.3;\n" + 
		"3865;Senn Lucien;1978;Schlieren;03:58:23.8;\n" + 
		"3867;Senteler Roger;1979;Volketswil;03:26:22.0;\n" + 
		"3868;Serrano Camilo;1980;Z�rich;04:25:15.4;\n" + 
		"3870;Sgier Giusep;1961;Chur;03:17:08.5;\n" + 
		"3871;Sibilia Enrico;1974;D�llikon;03:56:19.7;\n" + 
		"3874;Sieber Oliver;1984;Z�rich;03:44:20.5;\n" + 
		"3875;Siegenthaler Fredy;1962;Oberentfelden;03:38:44.8;\n" + 
		"3877;Siegrist Thomas;1965;Bern;03:16:43.6;\n" + 
		"3881;Signer Martin;1969;Langnau a Albis;03:06:23.2;\n" + 
		"3882;Signer Ueli;1956;Weiningen TG;03:42:23.1;\n" + 
		"3883;Sigrist Daniel;1965;Luzern Reussb�hl;03:40:57.5;\n" + 
		"3884;Sigrist Felix;1965;Ennetb�rgen;03:07:04.2;\n" + 
		"3886;Silberschmidt Rico;1980;Schaffhausen;03:26:22.9;\n" + 
		"3887;Simon Robert;1947;Z�rich;04:53:49.2;\n" + 
		"3889;Siragusa Pietro Giovan;1979;Neuhausen am Rhei;04:03:53.2;\n" + 
		"3890;Sitruk Yves;1957;Horgen;04:32:17.3;\n" + 
		"3895;Smith Craig;1977;Lausanne;03:27:00.7;\n" + 
		"3898;Somerville Trevor;1957;Rorschacherberg;04:03:32.3;\n" + 
		"3901;Soto Josetxo;1969;Z�rich;03:20:56.8;\n" + 
		"3904;Spaargaren Marco;1966;Z�rich;03:06:49.2;\n" + 
		"3905;Spaggiari Giuseppe;1955;Bellinzona;03:54:22.4;\n" + 
		"3906;Sp�h Martin;1981;Z�rich;04:06:19.7;\n" + 
		"3907;Specht Dominique;1971;Watt;04:03:52.9;\n" + 
		"3908;Al-Godari Hamid;1967;St. Margrethen SG;03:41:40.7;\n" + 
		"3909;Spielhofer Hans;1952;Wattwil;03:59:34.2;\n" + 
		"3910;Spielhofer Reto;1989;Wattwil;03:54:43.7;\n" + 
		"3911;Spiess Thomas;1960;Thun;03:10:09.5;\n" + 
		"3912;Spilker Max;1978;Z�rich;04:03:58.3;\n" + 
		"3913;Spitteler Peter;1969;Wittinsburg;03:18:07.2;\n" + 
		"3914;Spitznagel Kurt;1964;Buchs AG;04:10:00.5;\n" + 
		"3915;Sp�rndli Daniel;1975;Schaffhausen;03:19:23.3;\n" + 
		"3916;Sprenger Raphael;1987;W�ngi;02:58:37.5;\n" + 
		"3917;Spring Daniel;1984;Thun;02:44:39.4;\n" + 
		"3920;Stadelmann Marc;1973;Langenthal;04:22:33.9;\n" + 
		"3921;Maeder Walter;1951;Courgevaux;03:24:38.6;\n" + 
		"3922;Stadler Marcel;1966;Niederscherli;03:16:27.9;\n" + 
		"3923;Stadler Reto;1965;Z�rich;03:44:02.1;\n" + 
		"3924;Staeheli Oliver;1971;Horgen;03:57:53.2;\n" + 
		"3925;Staffelbach Thomas;1969;St. Urban;03:08:56.5;\n" + 
		"3926;St�hli Sandro;1989;Zwillikon;03:45:28.5;\n" + 
		"3927;Stamm Dominik;1978;Reinach BL;03:52:10.3;\n" + 
		"3928;Stamm Franz;1956;Elsau;03:21:11.0;\n" + 
		"3929;Stamm Urs;1952;Schleitheim;04:25:34.8;\n" + 
		"3931;St�mpfli Bernhard;1967;Oberwil BL;02:54:25.7;\n" + 
		"3932;K�lin Kurt;1967;Wetzikon ZH;03:43:37.0;\n" + 
		"3933;Stangl Dominik;1969;Schaffhausen;03:00:46.5;\n" + 
		"3934;Stangl Stefan;1968;Jona;03:04:52.5;\n" + 
		"3935;St�uble Roland;1961;Z�rich;03:04:43.0;\n" + 
		"3936;Staudenmann Beat;1970;Toffen;03:15:38.4;\n" + 
		"3938;Stauffacher Ruedi;1968;Aeugst am Albis;03:11:28.7;\n" + 
		"3939;Stauffer Alexandre;1985;Corcelles NE;04:06:21.6;\n" + 
		"3940;Stauffer Mario;1974;Wilen b. Wollerau;05:15:15.7;\n" + 
		"3941;Stauffer Markus;1954;Bern;03:42:13.0;\n" + 
		"3942;Stebler Markus;1965;W�nnewil;03:02:06.8;\n" + 
		"3943;Steffen Peter;1958;K�ttigen;03:10:42.4;\n" + 
		"3946;Steigmeier Linus;1956;Villigen;04:08:41.2;\n" + 
		"3947;Stein Martin;1973;Z�rich;03:22:45.4;\n" + 
		"3948;Steiner Armin;1979;Uerkheim;02:50:52.4;\n" + 
		"3949;Steiner Daniel;1961;Neuhausen am Rhei;03:43:36.2;\n" + 
		"3950;Steiner Markus;1986;Zielebach;03:05:14.2;\n" + 
		"3951;Steiner Patrick;1979;Schindellegi;03:24:12.0;\n" + 
		"3952;Steiner Peter;1965;Bern;04:09:50.0;\n" + 
		"3953;Steiner Rolf;1970;Schwyz;03:09:05.2;\n" + 
		"3954;Steiner Thomas;1955;Glattfelden;04:10:46.1;\n" + 
		"3956;Steinhof Co Rosen Arne;1974;Pully;03:47:55.7;\n" + 
		"3958;Stern Pascal Nicolas;1964;Z�rich;03:19:11.3;\n" + 
		"3959;Stettler Roman;1970;Flums;03:40:48.8;\n" + 
		"3961;Stifel Peter;1947;Steinhausen;04:15:30.1;\n" + 
		"3962;Stillman David;1981;Siebnen;02:38:27.6;\n" + 
		"3964;Stirnemann Paul;1954;Z�rich;03:40:07.0;\n" + 
		"3966;Stirnimann Daniel;1978;Winterthur;02:41:11.4;\n" + 
		"3968;Stocker Ueli;1963;Zug;03:49:26.0;\n" + 
		"3969;Stockmann Hubertus;1966;Kilchberg ZH;03:25:34.4;\n" + 
		"3973;Stoll Oliver;1963;Zeihen;04:02:48.0;\n" + 
		"3975;Storchenegger Daniel;1986;Altishausen;03:42:10.7;\n" + 
		"3977;Str�hl Stefan;1970;Oensingen;02:51:29.0;\n" + 
		"3981;Strebel Philipp;1967;T�gerig;02:59:26.1;\n" + 
		"3982;Strehler Erich;1969;Z�rich;03:13:55.1;\n" + 
		"3983;Streich Daniel;1957;La Tour-de-Tr�me;04:41:40.2;\n" + 
		"3984;Streiff Christoph;1981;Winterthur;03:43:42.3;\n" + 
		"3985;Streule Ralf;1976;Herisau;04:01:55.6;\n" + 
		"3987;Strickler Werner;1954;Volketswil;04:03:01.8;\n" + 
		"3988;Strimer Simon;1960;Jona;03:34:57.6;\n" + 
		"3990;Stucker J�rg;1971;Z�rich;03:46:43.0;\n" + 
		"3992;Studer Adrian;1967;Baltschieder;03:15:06.9;\n" + 
		"3993;Studer J�rg;1972;Nieder�sch;03:44:32.3;\n" + 
		"3994;Studer Peter;1963;Affoltern am Albi;03:36:35.5;\n" + 
		"3995;Stupp Oliver;1982;Greifensee;03:26:35.1;\n" + 
		"3996;Sturzenegger Hans-Rudo;1959;Hittnau;03:28:40.3;\n" + 
		"3997;Sturzenegger Michael;1984;Hittnau;03:33:10.9;\n" + 
		"3999;Sturzenegger Thomas;1958;D�bendorf;03:32:38.9;\n" + 
		"4001;St�tz Andy;1967;Schenkon;03:11:15.4;\n" + 
		"4002;Stutz Bruno;1963;Dietlikon;04:20:28.5;\n" + 
		"4003;Stutz Michael;1978;Z�rich;03:26:25.5;\n" + 
		"4004;Stutz Toni;1959;Emmenbr�cke;03:46:37.2;\n" + 
		"4005;Sulser Silvio;1976;Z�rich;03:09:20.4;\n" + 
		"4006;Sumi Arthur;1953;Wigoltingen;04:36:55.9;\n" + 
		"4008;S�ssli Eric;1975;Glarus;03:16:24.9;\n" + 
		"4010;Suter J�rg;1981;Wettingen;03:50:56.7;\n" + 
		"4013;Sutter J�rg;1980;Flims Waldhaus;04:32:57.9;\n" + 
		"4014;Swars Erik;1971;Ecublens VD;03:53:42.4;\n" + 
		"4015;Szegvary Thomas;1979;Basel;02:51:21.5;\n" + 
		"4016;Szentgy�rgyi Istvan;1971;Z�rich;04:12:33.5;\n" + 
		"4018;Tabakovic Velid;1969;Z�rich;03:48:12.8;\n" + 
		"4019;Tacca Gianni;1964;Monthey;03:48:33.6;\n" + 
		"4021;Tanner Marcel;1968;Ostermundigen;03:02:51.3;\n" + 
		"4023;Tauber Albert;1963;Wetzikon ZH;03:52:15.9;\n" + 
		"4025;Tellefsen Anders;1968;Zumikon;03:49:52.4;\n" + 
		"4026;Teshima Ryo;1973;Z�rich;05:12:50.9;\n" + 
		"4030;Thalmann Rolf;1957;Emmenbr�cke;03:25:29.9;\n" + 
		"4031;Theis Manuel;1972;Forch;03:26:20.6;\n" + 
		"4033;Theules Olivier;1970;S�les (Gruy�re);03:43:07.9;\n" + 
		"4034;Thiel Dieter;1975;Z�rich;04:13:20.5;\n" + 
		"4036;Thoma Remo;1977;N�nikon;03:23:37.5;\n" + 
		"4037;Thoma Turi;1959;Cham;03:17:57.7;\n" + 
		"4044;Th�r Rapha�l;1981;R�ti ZH;03:39:33.5;\n" + 
		"4045;Thurre Jean-Daniel;1966;Saxon;04:37:23.7;\n" + 
		"4046;Tighnavard Babak;1983;Z�rich;04:11:49.9;\n" + 
		"4047;Tobler Urs;1956;Arni AG;04:26:49.9;\n" + 
		"4054;Tourolle Bruno;1968;Z�rich;05:09:51.3;\n" + 
		"4056;Traber Fabio;1981;Ober�geri;04:23:21.4;\n" + 
		"4058;Trajkovic Ivo;1980;Baden;03:18:32.4;\n" + 
		"4063;Tremp Christof;1974;Z�rich;03:32:14.2;\n" + 
		"4064;Tresch Reto;1972;Sch�ftland;03:27:44.2;\n" + 
		"4065;Triantafillou Christos;1968;Bern;04:52:37.0;\n" + 
		"4067;Tripolt Fabio;1989;Horgen;04:50:44.1;\n" + 
		"4069;Troller Rolf;1952;Langnau am Albis;03:16:04.1;\n" + 
		"4070;Trolp Frank;1967;St. Gallen;03:47:42.8;\n" + 
		"4071;Troxler Andreas;1973;Z�rich;03:05:43.5;\n" + 
		"4073;Tr�mpler Michael;1980;Ottikon (Gossau Z;03:59:59.4;\n" + 
		"4074;Truninger Joey;1986;R�schlikon;04:21:42.2;\n" + 
		"4076;Tr�ssel Stefan;1974;Uster;03:32:50.1;\n" + 
		"4077;Tschamon Martin;1969;Nenzing;04:26:02.9;\n" + 
		"4078;Tschanz Lukas;1982;N�nikon;03:50:40.1;\n" + 
		"4079;Tschopp Silvan;1985;Ottenbach;03:11:38.3;\n" + 
		"4081;Tschumper Markus;1969;Uerikon;03:23:05.0;\n" + 
		"4082;Turberg Yves;1960;Movelier;03:11:45.6;\n" + 
		"4084;Uebbing J�rgen;1966;Z�rich;03:25:51.0;\n" + 
		"4085;Ueltschi Thomas;1961;Allschwil;03:03:16.8;\n" + 
		"4087;Ulber Wolfgang;1963;Domat/Ems;02:56:59.8;\n" + 
		"4088;Ullmann Rolf;1946;Bern;04:23:43.6;\n" + 
		"4091;Ulrich Daniel;1965;Zug;02:47:17.1;\n" + 
		"4093;Umbricht Niklaus;1966;Untersiggenthal;03:28:21.8;\n" + 
		"4094;Vacheron Thierry;1968;Vionnaz;03:56:01.6;\n" + 
		"4095;Vagt Toni;1979;Z�rich;03:05:22.5;\n" + 
		"4097;van Zyl Charl;1967;Horgen;03:17:57.7;\n" + 
		"4100;Veronesi Silvio;1969;Birmensdorf ZH;04:04:59.4;\n" + 
		"4101;Vetsch Matthias;1965;Zufikon;03:20:04.1;\n" + 
		"4103;Vieux Florian;1986;Muraz (Collombey);02:44:19.9;\n" + 
		"4104;Vilchez Martin;1978;Z�rich;03:32:58.5;\n" + 
		"4109;Voegeli Matthias;1984;Z�rich;03:46:10.7;\n" + 
		"4110;V�geli Pierre;1961;Reinach BL;04:20:39.9;\n" + 
		"4111;Voegeli Ueli;1965;Egliswil;03:36:28.4;\n" + 
		"4114;Vogel Hanspeter;1965;Evilard;04:59:03.8;\n" + 
		"4115;Vogel Markus;1963;Aarau;03:42:53.5;\n" + 
		"4116;Vogel Roland;1984;Kloten;03:59:22.0;\n" + 
		"4117;V�geli Bernhard;1958;Buchs SG;04:15:08.8;\n" + 
		"4122;V�llmin Manuel;1984;Ormalingen;03:19:55.7;\n" + 
		"4125;von Dahlen Steffen;1984;Baden;03:47:50.9;\n" + 
		"4126;von Holzen Christoph;1960;Menzingen;03:01:28.8;\n" + 
		"4127;von Kaenel Dominik;1978;Oensingen;04:54:14.0;\n" + 
		"4128;von Mandach Conrad;1968;Bern;03:15:07.5;\n" + 
		"4129;Vonarburg Christian;1964;Z�rich;03:43:28.5;\n" + 
		"4130;Vonbach Lukas;1975;M�nnedorf;03:27:53.3;\n" + 
		"4132;Vonplon Raymond;1981;Baar;03:46:02.7;\n" + 
		"4133;Votteler Michael;1965;Herisau;04:08:24.6;\n" + 
		"4134;Vournelis Ellin;1975;Uster;03:19:49.1;\n" + 
		"4135;Vuillemez Samuel;1979;Le Cerneux-P�quig;03:08:05.7;\n" + 
		"4136;Vuilleumier C�dric;1982;Neyruz FR;04:14:26.1;\n" + 
		"4138;Waeber Pascal;1968;Tafers;03:03:57.3;\n" + 
		"4142;Wahl Kurt;1951;Stallikon;03:53:47.6;\n" + 
		"4143;Waldburger Hans;1963;Wetzikon ZH;03:57:57.1;\n" + 
		"4144;Walder Vitus;1975;Schluein;03:13:37.1;\n" + 
		"4145;Waldis Stefan;1964;Volketswil;02:55:28.2;\n" + 
		"4146;Waldner Peter;1965;Z�rich;03:19:31.4;\n" + 
		"4148;Allemann Urs;1977;Winterthur;03:34:53.7;\n" + 
		"4152;W�lti Jean Pierre;1960;Wallisellen;03:28:59.4;\n" + 
		"4153;W�lti Thomas;1977;Bolligen;03:30:38.1;\n" + 
		"4154;Wangler Timothy;1979;Bassersdorf;03:43:31.5;\n" + 
		"4155;Wanner Florian;1979;Bern;03:27:05.3;\n" + 
		"4156;Wanner Laurent;1964;Nyon;03:44:52.1;\n" + 
		"4161;Weber Heinrich;1956;M�llheim-Wigoltin;04:07:24.7;\n" + 
		"4162;Weber Jakob;1961;Reinach BL;03:15:35.5;\n" + 
		"4164;Weber Peter;1959;Netstal;03:13:56.6;\n" + 
		"4166;Weber Stefan;1964;Oberrieden;03:28:52.6;\n" + 
		"4167;Wegmann Marco;1965;Z�rich;02:53:05.3;\n" + 
		"4168;Wegmann-Wittlin Andrea;1959;F�llanden;03:08:13.7;\n" + 
		"4169;Wegscheider Beat;1968;Kloten;03:13:23.5;\n" + 
		"4170;Wehrli Fabian;1981;Buchs ZH;03:53:27.5;\n" + 
		"4171;Weibel Patrick;1967;Z�rich;03:45:57.3;\n" + 
		"4172;Weibel Xaver;1980;Z�rich;03:20:43.3;\n" + 
		"4173;Weiersm�ller J-C;1971;Lenzburg;05:01:02.3;\n" + 
		"4175;Weilenmann Pascal;1984;Winterthur;04:21:39.3;\n" + 
		"4176;Weiler Andreas;1967;Altst�tten SG;02:49:59.5;\n" + 
		"4177;Weiler Christoph;1956;St. Gallen;03:53:47.9;\n" + 
		"4181;Weiser Thomas;1974;Z�rich;04:26:18.4;\n" + 
		"4182;Weisheimer Thomas;1972;Ehrendingen;03:21:52.9;\n" + 
		"4183;Weisser Klaus;1961;Z�rich;03:47:57.0;\n" + 
		"4184;Welbergen Anthony;1983;Z�rich;03:18:37.6;\n" + 
		"4185;Welten Ernst;1968;T�gerig;04:24:38.0;\n" + 
		"4192;Wenger Urban;1958;Weinfelden;03:33:01.9;\n" + 
		"4195;Werder Daniel;1967;Kilchberg ZH;03:44:31.4;\n" + 
		"4199;Wernli Oliver;1976;Buochs;03:27:50.9;\n" + 
		"4200;Wernli Raphael;1981;Baden;03:39:33.1;\n" + 
		"4201;Wespi Marcel;1969;Uitikon Waldegg;03:13:52.0;\n" + 
		"4204;Westphalen Stephan;1941;Basel;05:24:41.6;\n" + 
		"4205;Wettstein Erich;1958;Biberist;03:48:10.3;\n" + 
		"4206;Wettstein Markus;1983;Russikon;03:27:17.7;\n" + 
		"4212;Wicki Roger;1974;Winterthur;03:14:34.4;\n" + 
		"4214;Widmer Erhard;1955;Z�rich;03:49:04.0;\n" + 
		"4219;Wildhaber Walter;1986;Bonstetten;03:49:04.8;\n" + 
		"4220;Wilkening Jan;1981;Z�rich;03:08:18.8;\n" + 
		"4222;Willisegger Christoph;1971;Winterthur;03:25:32.0;\n" + 
		"4223;Wilson Antony;1961;Baar;03:48:14.0;\n" + 
		"4224;Windm�ller Stefan;1970;Z�rich;03:56:11.3;\n" + 
		"4225;Winist�rfer Georges;1956;Z�rich;04:20:29.0;\n" + 
		"4226;Winkler Michael;1971;Z�rich;02:44:19.7;\n" + 
		"4230;Wirz Daniel;1967;Oetwil am See;03:27:50.7;\n" + 
		"4231;Wittlin Marc;1976;Birsfelden;03:42:46.4;\n" + 
		"4232;Wittwer David;1970;Obfelden;05:10:20.7;\n" + 
		"4233;Wohlers Florian;1975;D�bendorf;03:42:07.4;\n" + 
		"4234;Wolf Etienne;1971;Gundetswil;02:32:49.2;\n" + 
		"4236;Wollnow J�rg;1969;Sursee;04:10:28.4;\n" + 
		"4240;W�rner Mike;1971;Eschenbach SG;03:23:40.6;\n" + 
		"4241;Wullimann Markus;1976;Grenchen;02:51:35.0;\n" + 
		"4243;W�rzebesser Christian;1977;Z�rich;04:26:22.1;\n" + 
		"4246;W�thrich J�rg;1966;Thal;03:47:43.4;\n" + 
		"4248;Wyler Karl;1961;Teufen AR;03:47:18.4;\n" + 
		"4249;Wymann Fredi;1953;Uetikon am See;04:30:06.6;\n" + 
		"4250;Wymann Markus;1968;Z�rich;04:43:36.1;\n" + 
		"4251;Wyniger Lukas;1977;Wettingen;03:21:22.8;\n" + 
		"4253;Wyss Eric;1966;St. Moritz;02:54:59.2;\n" + 
		"4254;Wyss Roman;1976;Niederbipp;02:55:54.9;\n" + 
		"4255;Wyss Stefan;1982;Thun;03:26:00.0;\n" + 
		"4257;Yamashita Masato;1949;Versoix;03:43:53.9;\n" + 
		"4258;Zabe-K�hn Martin;1964;Ostermundigen;03:41:01.1;\n" + 
		"4262;Zampiccoli Manuel;1988;Mettmenstetten;04:05:48.2;\n" + 
		"4263;Zanella Bruno;1959;Richterswil;04:49:35.7;\n" + 
		"4264;Zangl Christian;1965;M�rschwil;03:41:31.8;\n" + 
		"4265;Zaouia Mehdi;1952;Z�rich;04:14:01.3;\n" + 
		"4266;Zbinden Manfred;1970;D�dingen;03:40:48.7;\n" + 
		"4267;Zbinden Ren�;1972;Bern;03:25:40.5;\n" + 
		"4268;Zbinden Thomas;1972;Schenkon;02:54:31.5;\n" + 
		"4269;Zeder Markus;1973;Burgdorf;03:11:35.9;\n" + 
		"4270;Zeder Patrick;1974;Bern;03:06:35.5;\n" + 
		"4272;Zehnder Marcel;1959;Wohlen AG;03:10:08.5;\n" + 
		"4274;Zekhnini Ahmed;1969;Weiningen TG;04:49:37.5;\n" + 
		"4275;Zemp Marco;1972;Root;03:23:55.1;\n" + 
		"4276;Zemp Markus;1966;Berikon;03:07:50.2;\n" + 
		"4277;Zengaffinen Erwin;1955;Hochfelden;03:54:57.9;\n" + 
		"4278;Zgraggen Franz;1966;B�lach;03:20:19.9;\n" + 
		"4279;Ziegler Marc;1971;H�nenberg See;04:19:45.6;\n" + 
		"4280;Ziegler Robert;1953;Sch�belbach;03:44:31.8;\n" + 
		"4284;Zimmerli Thomas;1962;Wolfhausen;03:32:23.9;\n" + 
		"4285;Zimmermann Patrick;1973;Rothrist;03:29:36.6;\n" + 
		"4286;Zimmermann Robert;1975;Forch;03:38:54.1;\n" + 
		"4288;Zingg Christoph;1986;Z�rich;03:02:52.0;\n" + 
		"4290;Zink Fritz;1991;Sch�fflisdorf;04:07:32.2;\n" + 
		"4293;Zoder Roland;1972;Rotkreuz;02:53:55.6;\n" + 
		"4294;Zoller Stefan;1968;Pfaffhausen;03:23:42.0;\n" + 
		"4295;Zollinger Marcel;1963;Oberglatt ZH;03:17:44.3;\n" + 
		"4297;Zuber Benno;1960;Randa;03:40:35.5;\n" + 
		"4298;Zuber Ralf;1960;St. Gallen;04:35:44.6;\n" + 
		"4299;Zubler Martin;1971;Metzerlen;03:22:58.5;\n" + 
		"4300;Zulauf Stefan;1962;Gutenburg;04:04:22.2;\n" + 
		"4301;Zumer Robert;1966;Benglen;03:36:37.2;\n" + 
		"4302;Zumsteg Rene;1978;Embrach;03:45:16.9;\n" + 
		"4303;Zurbuchen Christian;1983;Niederbipp;03:51:40.2;\n" + 
		"4305;Zurfl�h-Begr� Daniel;1964;Bern;03:13:49.8;\n" + 
		"4306;Zutter Jerome;1980;Dietikon;04:04:45.2;\n" + 
		"4307;Zwahlen Beat;1965;H�nenberg;03:57:51.2;\n" + 
		"4308;Zwick J�rg;1963;B�lach;03:17:10.8;\n" + 
		"4310;Zwygart Stephan;1964;Walzenhausen;04:01:59.8;\n" + 
		"4311;Alvarez Fernando;1976;Dietikon;03:51:14.8;\n" + 
		"4313;Ambrosini Stefan;1971;B�ttikon AG;04:55:45.4;\n" + 
		"4315;Ayeah Ebenezer;1971;Fribourg;03:17:16.7;\n" + 
		"4316;Bachsteffel Niklaus;1960;Ennetbaden;03:30:01.2;\n" + 
		"4317;Bagnoud G�rard;1970;Gen�ve;02:39:30.3;\n" + 
		"4318;Bartel Marco;1973;Aarau;03:44:18.2;\n" + 
		"4319;Barz Andreas;1962;Uetikon am See;04:09:47.4;\n" + 
		"4320;Baumann Rainer;1971;Uetikon a.S.;03:15:53.4;\n" + 
		"4321;Baumann Walter;1953;Flawil;02:57:59.7;\n" + 
		"4323;Baumgartner Andreas;1980;Cham;03:51:00.5;\n" + 
		"4324;Beck Jan;1970;Dornach;03:03:19.3;\n" + 
		"4327;Beer Sebastian;1984;Z�rich;03:17:11.4;\n" + 
		"4328;Beerli Urs-Peter;1953;M�rstetten;03:20:06.6;\n" + 
		"4329;Beermann Stefan;1981;Uster;03:09:44.7;\n" + 
		"4330;Bekcic Vladimir;1987;Zug;03:37:21.9;\n" + 
		"4331;Benkert Fritz;1949;Bergdietikon;03:38:32.5;\n" + 
		"4334;Birkenmaier Claude;1977;Z�rich;03:38:56.5;\n" + 
		"4335;Blum Edgar;1951;Niederrohrdorf;03:52:36.6;\n" + 
		"4336;Bogner Walter;1976;Z�rich;03:03:47.5;\n" + 
		"4337;Bonfanti Stefan;1960;Z�rich;03:17:04.7;\n" + 
		"4341;Bronner Reto;1972;Untersiggenthal;03:52:08.1;\n" + 
		"4342;Br�nnimann Ruedi;1951;Nussbaumen AG;03:24:43.9;\n" + 
		"4343;Bucher Martin;1976;Z�rich;03:07:06.7;\n" + 
		"4344;Buehler Andreas;1960;Hombrechtikon;03:34:03.6;\n" + 
		"4345;Buerki Fritz;1948;Herzogenbuchsee;04:35:05.4;\n" + 
		"4346;B�hlmann Daniel;1963;Buchrain;04:12:59.2;\n" + 
		"4347;Burgener Hubert;1958;Naters;03:35:04.4;\n" + 
		"4348;B�rgi Thomas;1971;Goldau;03:06:51.1;\n" + 
		"4350;Businger Urs;1955;Luzern;03:20:45.9;\n" + 
		"4351;Camenzind Peter;1951;Adliswil;02:54:41.7;\n" + 
		"4354;Carisch Emanuel;1978;Z�rich;03:55:06.5;\n" + 
		"4355;Carrasco Ernesto;1965;Steinmaur;04:38:15.0;\n" + 
		"4356;Casanova Lukas;1976;Z�rich;03:37:50.9;\n" + 
		"4357;Castella Jean-Marc;1964;Fribourg;05:11:31.3;\n" + 
		"4358;Caviezel Marzel;1960;Schluein;03:39:40.9;\n" + 
		"4361;Coradi Thomas;1971;Lenzburg;03:57:57.3;\n" + 
		"4362;Coray Roger;1967;Altst�tten SG;03:59:48.4;\n" + 
		"4363;Crosara Michel;1968;Elsau;03:09:28.6;\n" + 
		"4367;Derron Simon;1974;Uster;04:07:34.9;\n" + 
		"4369;Dobler Christoph;1982;Z�rich;03:32:07.5;\n" + 
		"4370;Dos Santos Nelson;1974;St-Luc;04:33:45.9;\n" + 
		"4373;Duschen Patrick;1977;Jona;03:07:44.2;\n" + 
		"4374;D�tschler Reto;1987;Horgen;03:57:58.0;\n" + 
		"4375;Eckert Marc;1982;Thun;04:24:13.0;\n" + 
		"4376;Egger Daniel;1980;Z�rich;03:12:08.4;\n" + 
		"4377;Ehrbar Martin;1966;Wil SG;03:13:13.1;\n" + 
		"4378;Eigenmann Raffael;1971;Gossau SG;03:26:14.5;\n" + 
		"4379;Enemrke Simon;1982;Z�rich;03:34:52.6;\n" + 
		"4381;Fallegger Hans-J�rg;1964;Uitikon Waldegg;03:26:03.3;\n" + 
		"4383;Fessler Andreas;1962;Arth;05:33:39.1;\n" + 
		"4384;Forster Martin;1955;Baden;03:57:47.7;\n" + 
		"4385;Frei Nicola;1986;Z�rich;03:18:16.7;\n" + 
		"4386;Fritz Romeo;1969;N�rensdorf;04:21:34.3;\n" + 
		"4388;Geissmann Willy;1945;Ormalingen;04:04:51.8;\n" + 
		"4390;Gisi Daniel;1968;Aarau Rohr;02:58:06.3;\n" + 
		"4391;Gomez Carlos;1971;Gen�ve;03:09:16.6;\n" + 
		"4392;Gossauer Andreas;1969;Kilchberg ZH;04:23:59.5;\n" + 
		"4393;Graham Colin;1978;Kloten;03:25:39.3;\n" + 
		"4394;Grau Patrick;1977;Dietikon;04:38:55.4;\n" + 
		"4395;Gr�ninger Thomas;1968;Gland;03:56:50.4;\n" + 
		"4397;Gujer Hanspeter;1969;Egg b. Z�rich;04:21:31.6;\n" + 
		"4398;Gyger Franz;1968;Steffisburg;03:06:10.5;\n" + 
		"4399;Haider Thomas;1977;Z�rich;02:53:41.2;\n" + 
		"4400;Haller Heinrich;1954;Zernez;03:14:40.7;\n" + 
		"4401;Hartmann Thomas;1990;Herisau;04:21:26.2;\n" + 
		"4402;Haueter Max;1955;Sumiswald;04:12:49.0;\n" + 
		"4403;Hauser Wolfgang;1964;Jona;02:55:57.6;\n" + 
		"4404;H�usler Philippe;1971;Mollis;03:26:49.3;\n" + 
		"4406;Herren Lars;1990;Z�rich;04:11:27.4;\n" + 
		"4407;Hertach Alain;1980;Z�rich;03:46:24.5;\n" + 
		"4408;Hess Ivan;1972;Seuzach;03:43:57.6;\n" + 
		"4409;Hess Oliver;1972;Wetzikon ZH;04:05:34.2;\n" + 
		"4411;Hohler Patrick;1973;Aesch BL;03:56:55.4;\n" + 
		"4412;Holenweger Michael;1990;St�fa;04:16:36.2;\n" + 
		"4413;Hollenstein Alex;1964;B�tschwil;03:44:11.4;\n" + 
		"4414;H�sli Hans;1960;Glattfelden;03:28:24.9;\n" + 
		"4415;Hubacher Thomas;1981;Bern;03:13:08.5;\n" + 
		"4416;Huber Ren�;1956;Kloten;04:36:47.8;\n" + 
		"4417;Hug Rene;1971;Neftenbach;03:14:54.9;\n" + 
		"4419;Humbel J�rg;1960;Untersiggenthal;03:30:52.9;\n" + 
		"4420;Hungerbuehler Pius;1961;Z�rich;03:53:02.2;\n" + 
		"4421;Inniger Hans-Christoph;1970;Bern;04:41:42.5;\n" + 
		"4424;Janser Alfred;1946;Niederhasli;04:13:22.2;\n" + 
		"4425;Jegen Thomas;1963;Illnau;03:57:29.2;\n" + 
		"4426;Joller Thomas;1968;Luzern;03:23:38.6;\n" + 
		"4428;Jutzi Stephan;1970;Z�rich;04:09:25.0;\n" + 
		"4433;Kaufmann Hanspeter;1963;Emmenbr�cke;03:50:16.8;\n" + 
		"4435;Kellenberger Stephan;1976;Bern;03:15:43.1;\n" + 
		"4436;Keller Daniel;1969;Rafz;03:58:39.7;\n" + 
		"4437;Keller Ernst;1961;Dorf;02:58:15.0;\n" + 
		"4438;Kelling Udo;1968;Turgi;03:04:50.7;\n" + 
		"4440;Kimmerlin Thierry;1968;Basel;03:16:52.9;\n" + 
		"4441;Kindlimann Heinz;1954;Regensdorf;03:43:31.0;\n" + 
		"4444;Kobi Peider;1960;Stadel b. Niederg;04:43:57.9;\n" + 
		"4445;Kopalek Peter;1973;Steinmaur;03:20:33.6;\n" + 
		"4448;K�chler Thorsten;1971;Z�rich;03:22:32.7;\n" + 
		"4449;Kuster Marcel;1966;Pratteln;03:17:29.6;\n" + 
		"4450;Kuster Matthias;1960;Z�rich;03:53:57.8;\n" + 
		"4452;Lanz Peter;1979;Mollis;02:51:38.1;\n" + 
		"4453;Laubscher Daniel;1968;B�ren an der Aare;03:35:14.5;\n" + 
		"4454;Leach Steven;1969;Weesen;04:22:52.4;\n" + 
		"4455;Leder Manfred;1965;Kaisten;03:38:05.7;\n" + 
		"4456;Lehmann Nik;1964;Gossau SG;03:08:46.4;\n" + 
		"4457;Lehni Markus;1954;Zug;03:51:10.8;\n" + 
		"4458;Leiggener Christoph;1964;Wallbach;04:24:27.4;\n" + 
		"4459;Leuener Felix;1969;Oberriet SG;03:56:31.0;\n" + 
		"4461;Loosli Adrian;1973;Ibach;03:07:31.4;\n" + 
		"4462;Lopes Oliveira Leonel;1971;Dietikon;03:05:47.9;\n" + 
		"4463;Lorencez Isaac;1954;Spreitenbach;03:48:08.4;\n" + 
		"4465;Lucas Fran�ois;1961;Z�rich;03:44:05.5;\n" + 
		"4466;L�thi Jean-Pierre;1965;Lausanne;03:36:16.2;\n" + 
		"4467;L�thi Marc;1981;Forch;04:06:42.3;\n" + 
		"4468;L�thi Markus;1968;Dussnang;03:55:50.1;\n" + 
		"4469;Maag Reto;1971;Illnau;03:30:04.5;\n" + 
		"4470;Maegli Rolf;1955;Meggen;04:07:31.1;\n" + 
		"4471;Maier Bernhard;1966;Wallisellen;03:49:12.4;\n" + 
		"4472;Malacarne Sergio;1962;Winterthur;03:57:34.6;\n" + 
		"4475;Martel Jan;1973;St. Gallen;04:12:25.3;\n" + 
		"4477;Maurer Dani;1965;Binningen;03:06:14.8;\n" + 
		"4478;Meichtry Urs;1960;Bonstetten;03:14:13.7;\n" + 
		"4479;Meier Bruno;1969;Stetten AG;03:03:26.5;\n" + 
		"4480;Meier Daniel;1973;Winterthur;03:28:25.1;\n" + 
		"4481;Meier Martin;1973;Winterthur;04:39:50.7;\n" + 
		"4483;Merian Paul;1963;Urdorf;03:27:56.6;\n" + 
		"4484;Messer Markus;1963;Flims Dorf;03:18:13.8;\n" + 
		"4485;Metzger Bernhard;1966;Lufingen;04:24:15.7;\n" + 
		"4487;Minuscoli Patrik;1981;Wollerau;03:17:11.0;\n" + 
		"4488;Miralhos Paulo;1974;Frauenfeld;02:42:54.8;\n" + 
		"4490;Moncaro Andrea;1970;Volketswil;04:00:17.6;\n" + 
		"4491;Montagut Vidal Jorge;1975;Ottikon (Gossau Z;03:27:46.0;\n" + 
		"4492;Moser Ives Jan;1984;B�lach;03:13:18.8;\n" + 
		"4493;Moser Mario;1976;Wettingen;04:25:43.7;\n" + 
		"4494;Motavalli Masoud;1962;R�schlikon;04:39:41.9;\n" + 
		"4495;M�hle Housi;1960;Utzenstorf;03:44:56.6;\n" + 
		"4496;Mullaney Chris;1967;Ottoberg;04:00:35.0;\n" + 
		"4497;Murbach Umberto;1948;Horgen;04:44:47.0;\n" + 
		"4499;Nehmer Raphael;1989;Adliswil;04:12:31.0;\n" + 
		"4500;Neuenschwander Hanspet;1966;Unterb�zberg;04:31:36.4;\n" + 
		"4501;Notter Thomy;1974;Hochfelden;04:11:43.5;\n" + 
		"4502;N�nlist N�ni;1970;Br�tten;04:26:57.3;\n" + 
		"4503;Nusseck Peter;1963;Unterentfelden;03:20:19.2;\n" + 
		"4504;Nyfeler Thomas;1979;Bleienbach;03:29:17.7;\n" + 
		"4505;Oberh�nsli Fabian;1990;Zezikon;03:20:58.3;\n" + 
		"4506;Obrist Beat;1965;R�fenach AG;04:26:57.6;\n" + 
		"4507;Obrist Fabio;1977;Kloten;04:11:19.7;\n" + 
		"4508;Odden Lee;1956;Zug;03:26:42.2;\n" + 
		"4509;Odermatt Karlheinz;1965;Rain;04:23:05.4;\n" + 
		"4510;Oetiker Beat;1965;Samstagern;04:43:15.9;\n" + 
		"4511;Omlin Niklaus;1965;Rudolfstetten;03:39:26.4;\n" + 
		"4512;Ommerborn Stephan;1964;Z�rich;03:57:30.2;\n" + 
		"4513;Ort Fred;1942;Bertschikon (Goss;03:42:06.9;\n" + 
		"4514;Pagan Olivier;1963;M�nchenstein;03:56:16.6;\n" + 
		"4515;Pauli Marc;1970;Mirchel;03:18:53.3;\n" + 
		"4516;Perez De La Sota Gabri;1980;Z�rich;04:08:57.6;\n" + 
		"4517;Perren Patrick;1971;Chalais;02:42:52.6;\n" + 
		"4519;Pf�ffli Andreas;1968;Winterthur;03:12:35.9;\n" + 
		"4521;Pfister Andreas;1990;M�rwil;03:11:43.3;\n" + 
		"4522;Pfister Christian;1975;Esslingen;03:51:55.3;\n" + 
		"4523;Plattner Daniel;1978;Greifensee;04:14:34.5;\n" + 
		"4525;Poenaru Daniel;1971;Brugg AG;03:58:25.8;\n" + 
		"4527;Portmann Philipp;1973;M�nchaltorf;03:33:19.1;\n" + 
		"4529;Pravato David;1972;Z�rich;03:18:04.8;\n" + 
		"4530;Provinzano Ignazio;1975;Mels;03:14:06.3;\n" + 
		"4531;Racine Gabriel;1956;Z�rich;04:12:19.3;\n" + 
		"4532;Raiser Thomas;1968;Wohlen AG;03:30:12.3;\n" + 
		"4533;Rando Andr�s;1955;Z�rich;03:36:42.3;\n" + 
		"4535;Reber Rolf;1958;Domat/Ems;03:30:37.7;\n" + 
		"4537;Renz Thomas;1959;B�lach;03:17:41.1;\n" + 
		"4538;Rickenbacher Leo;1960;Frauenfeld;03:03:42.2;\n" + 
		"4541;Risler Martin;1972;Bern;03:31:03.8;\n" + 
		"4542;Romer Paul;1962;R�ti ZH;03:16:56.2;\n" + 
		"4544;R�egg Roman;1981;Winterthur;03:23:46.4;\n" + 
		"4545;Russenberger Thomas;1963;Lenzburg;03:30:07.3;\n" + 
		"4546;R�timann Willy;1960;B�lach;04:06:31.0;\n" + 
		"4547;Sadriu Kreshnik;1994;B�lach;05:17:51.5;\n" + 
		"4548;Salisbury David;1970;Z�rich;03:40:37.7;\n" + 
		"4549;Sch�deli Ernst;1949;Pf�ffikon SZ;03:44:00.9;\n" + 
		"4550;Sch�fer Kai;1966;Hauptwil;03:05:08.6;\n" + 
		"4551;Scheller Gerd;1964;Kilchberg ZH;03:15:32.5;\n" + 
		"4552;Schiavarelli Nicola;1957;Z�rich;03:31:43.0;\n" + 
		"4554;Schlepfer Roland;1990;Appenzell;04:07:21.4;\n" + 
		"4556;Schmidl Martin;1967;Galgenen;03:21:19.3;\n" + 
		"4558;Schmitt Marius Gerhard;1990;Z�rich;03:43:19.3;\n" + 
		"4559;Schuler Othmar;1965;Schattdorf;03:10:19.1;\n" + 
		"4560;Schwegler Klaus;1990;Menzingen;04:12:49.8;\n" + 
		"4561;Siegenthaler Thomas;1954;Kilchberg ZH;03:43:26.1;\n" + 
		"4562;Signer Peter;1965;Wiesendangen;03:36:24.1;\n" + 
		"4564;Spiegel Patrick;1977;Dornach;03:11:15.1;\n" + 
		"4565;St�dler Oliver;1967;Affoltern a.A.;03:32:53.0;\n" + 
		"4568;Steiner Daniel;1988;Samstagern;04:36:39.3;\n" + 
		"4569;Steinhauser J�rg;1966;Uster;03:55:45.8;\n" + 
		"4570;Stephani Reto;1989;Samstagern;04:14:32.2;\n" + 
		"4571;Stoppiello Frank;1966;Chavornay;04:27:04.8;\n" + 
		"4572;Strebel Paddy;1961;St�fa;03:33:53.2;\n" + 
		"4573;Suter Daniel;1964;Aarau;04:04:30.7;\n" + 
		"4574;Taucher Joshua;1990;Buchs SG;04:22:37.3;\n" + */
		"4576;Thode Andreas;1975;Stallikon;03:34:42.0;\n" + 
		"4577;Isler Bruno;1963;Niederhasli;03:33:38.7;\n" + 
		"4578;Thomschke Till;1981;Z�rich;03:33:50.5;\n" + 
		"4579;Tobler Daniel;1970;Hedingen;03:12:40.1;\n" + 
		"4580;Tomic Slobodan Bob;1943;Unterengstringen;04:29:48.6;\n" + 
		"4581;Tonak Torsten;1976;Fahrweid;02:52:15.5;\n" + 
		"4582;Tonolli Alberto;1948;Davos Dorf;05:04:59.1;\n" + 
		"4584;Tuta Niko;1986;Z�rich;04:18:53.6;\n" + 
		"4588;Vogt Roland;1953;Hettlingen;03:42:03.5;\n" + 
		"4589;von K�nel Hans;1950;Wallisellen;03:40:14.8;\n" + 
		"4590;Vonchristen Martin;1967;Birmensdorf ZH;04:08:13.8;\n" + 
		"4591;Walder Christoph;1954;Z�rich;04:27:39.5;\n" + 
		"4592;Walker Steven;1969;Ollon VD;03:10:20.3;\n" + 
		"4593;Walter Martin;1962;Weinfelden;03:02:43.1;\n" + 
		"4594;Wang Lei;1979;Z�rich;05:21:55.4;\n" + 
		"4596;Wehren Marcel;1982;Niederwil AG;03:31:01.8;\n" + 
		"4597;Wey Franz;1954;Rickenbach LU;04:08:53.7;\n" + 
		"4598;Wey Herbert;1943;Oberengstringen;04:01:43.8;\n" + 
		"4599;Wey Simon;1976;Z�rich;03:22:42.6;\n" + 
		"4600;Wick Bernhard;1970;Andwil SG;03:50:22.0;\n" + 
		"4602;Wille David;1985;Z�rich;04:46:13.0;\n" + 
		"4603;Wirth Thomas;1971;Hombrechtikon;04:30:41.6;\n" + 
		"4605;W�est Simon;1978;Wettingen;03:59:02.1;\n" + 
		"4606;Wunderli Andreas;1961;Z�rich;03:38:17.9;\n" + 
		"4607;Wyler Marco;1976;Rapperswil SG;04:21:15.1;\n" + 
		"4608;Z�hnler Bruno;1970;Waldkirch;04:27:22.2;\n" + 
		"4609;Zehnder Rolf;1957;Uster;03:58:45.5;\n" + 
		"4610;Zehntner Daniel;1955;Liestal;03:23:23.5;\n" + 
		"4611;Zimmermann Niklaus;1963;Oberdorf SO;03:36:50.5;\n" + 
		"4612;Zimmermann Werner;1951;Z�rich;04:37:54.2;\n" + 
		"4613;Zumbach Charles;1954;H�ttikon;03:33:26.8;\n" + 
		"4614;Ackermann Martin;1957;Rothenhausen;03:28:06.3;\n" + 
		"4615;Berndt Matthias;1959;Arisdorf;04:05:43.4;\n" + 
		"4616;Bertucci Dario;1977;Z�rich;03:51:29.8;\n" + 
		"4619;Buchmann Remo;1973;St�fa;04:12:44.2;\n" + 
		"4620;Fl�ckiger Hans;1953;D�bendorf;03:46:16.2;\n" + 
		"4621;Germann Peter;1955;D�llikon;03:32:20.3;\n" + 
		"4622;Hagemann Peter;1951;Steffisburg;03:31:09.0;\n" + 
		"4623;Halme Tero;1985;Gen�ve;02:59:02.2;\n" + 
		"4625;Huber Daniel;1966;Z�rich;03:25:29.1;\n" + 
		"4626;Jeannet Olivier;1961;Neuch�tel;03:26:00.8;\n" + 
		"4627;Jorge Humberto;1968;Z�rich;03:38:11.0;\n" + 
		"4629;K�lin Sepp;1962;Einsiedeln;03:27:46.9;\n" + 
		"4631;Kellenberger Daniel;1990;Sirnach;04:33:31.9;\n" + 
		"4632;Knupfer Stefan;1982;Grabs;02:58:32.2;\n" + 
		"4633;Kn�sel Markus;1955;Uster;03:26:26.8;\n" + 
		"4634;Kovar Thomas;1971;Bassins;02:59:45.9;\n" + 
		"4636;Kuhn Matthias;1979;L�tzelfl�h-Goldba;03:02:55.4;\n" + 
		"4638;Lustenberger Kurt;1967;Aeugst am Albis;02:39:45.1;\n" + 
		"4640;Mantel Rico;1959;Zollikerberg;05:11:09.4;\n" + 
		"4641;Martin Ludwig;1982;Z�rich;03:26:31.4;\n" + 
		"4642;Mazzotta Cosimo;1962;Viganello;03:21:14.2;\n" + 
		"4644;Moret Raoul;1978;Aigle;03:55:48.2;\n" + 
		"4645;Nebbe Harry;1966;Affoltern a. Albi;03:13:15.5;\n" + 
		"4646;Neuenschwander Andre;1992;D�bendorf;04:13:30.5;\n" + 
		"4647;Pellegrini Fausto;1967;Chur;03:08:09.8;\n" + 
		"4648;Pellkofer Martin;1972;Z�rich;03:32:45.4;\n" + 
		"4649;Peterli Ralph;1965;Winterthur;04:26:53.4;\n" + 
		"4650;Phan Quang Biu;1971;Reinach BL;03:38:30.9;\n" + 
		"4653;Ruoss Patrick;1971;Zug;03:17:49.2;\n" + 
		"4654;Ryser Martin;1960;Reiden;03:22:53.6;\n" + 
		"4655;Schmid Andreas;1961;Steinhausen;02:45:39.7;\n" + 
		"4656;Schmidt Yvan;1966;Ollon VD;04:03:33.3;\n" + 
		"4657;Schwarzkopf Dominik;1990;Flawil;04:57:38.5;\n" + 
		"4660;Stoob Max;1994;F�llanden;04:29:24.7;\n" + 
		"4661;Tomczak Krzysztof;1976;Lachen SZ;03:13:04.2;\n" + 
		"4664;Wellington Daniel;1960;Allschwil;03:57:55.6;\n" + 
		"4665;Zgraggen Lorenzo;1991;Luzern;04:01:05.6;\n" + 
		"4668;H�uptli Daniel;1983;Z�rich;03:34:36.8;\n" + 
		"4669;Babounakis Antonios;1990;Z�rich;03:20:54.8;\n" + 
		"4670;Di Giovanni Bruno;1979;W�renlos;03:54:13.1;\n" + 
		"4672;B�ni Andr�;1970;Samstagern;04:21:43.2;\n" + 
		"4673;Keller Christian;1968;Abtwil SG;04:40:52.6;\n" + 
		"4674;Briner-Weber Markus;1957;Fehraltorf;03:43:34.2;\n" + 
		"4676;Brenner Patrick;1968;Z�rich;02:38:58.1;\n" + 
		"4677;Oyetan Seun;1976;Z�rich;04:24:23.2;\n" + 
		"4678;Manivanan Vijay Sudhak;1972;Z�rich;04:08:11.8;\n" + 
		"4679;Lehner Markus;1959;Bellmund;04:23:29.0;\n" + 
		"4680;Stadel Joachim;1968;Forch;03:14:49.9;\n" + 
		"4681;Sudan Philippe;1978;Wollerau;03:11:11.3;\n" + 
		"4682;Holzapfel Helmut;1953;Sevelen;04:10:32.5;\n" + 
		"4683;Lanz Martin;1973;Z�rich;02:37:54.8;\n" + 
		"4684;Gorrie Luke;1978;Z�rich;04:44:13.6;\n" + 
		"4685;Sutter Markus;1966;Hochfelden;03:05:39.8;\n" + 
		"4686;Meier Werner;1966;Wetzikon ZH;03:51:16.6;\n" + 
		"4687;Mvongo Jean-Paul;1983;Z�rich;03:20:08.7;\n" + 
		"4688;Czaykowsky Marco;1985;Z�rich;03:25:26.2;\n" + 
		"4689;Czaykowsky Yves;1987;Z�rich;03:14:06.0;\n" + 
		"4690;K�min Otto;1951;Pf�ffikon SZ;05:09:42.8;\n" + 
		"4691;Thalmann Daniel;1961;Bern;03:15:41.4;\n" + 
		"4692;Wespi Bernhard;1973;Dintikon;03:41:54.0;\n" + 
		"4693;Geiger Christoph;1942;Biel/Bienne;04:18:19.6;\n" + 
		"4694;Oswald Flurin;1955;Z�rich;05:01:23.6;\n" + 
		"4695;Mader Kevin;1986;Brugg AG;03:20:24.8;\n" + 
		"4696;Gentile Daniele;1965;Schlieren;03:26:43.6;\n" + 
		"4698;Ahler Markus;1977;Heiligenschwendi;03:58:28.3;\n" + 
		"4700;Zuzolo Vincenzo;1967;Pf�ffikon SZ;04:32:45.9;\n" + 
		"4701;Lochmann Guido;1959;Lostorf;04:03:18.1;\n" + 
		"4702;Bartosch Lukas;1972;Binningen;03:54:56.4;\n" + 
		"4703;Pfyffer Stefan;1982;Z�rich;03:37:36.1;\n" + 
		"4704;Untern�hrer Ren�;1969;Bubikon;03:24:40.5;\n" + 
		"4705;Habisreutinger Thomas;1969;Boppelsen;03:35:27.8;\n" + 
		"4706;Pokora Daniel;1972;Z�rich;03:13:45.2;\n" + 
		"4708;Steinbach Simon;1975;St�fa;03:44:59.6;\n" + 
		"4709;Bischof Harald;1957;Z�rich;04:06:47.0;\n" + 
		"4710;Kohli Bernhard;1978;Z�rich;03:40:30.6;\n" + 
		"4711;Bigger Reto;1972;Z�rich;03:25:21.6;\n" + 
		"4712;Lopez Oswaldo;1975;Lausanne;04:38:07.8;\n" + 
		"4713;Ortiz Claviso Luis Alb;1966;Lausanne;04:28:03.2;\n" + 
		"4949;Richner Peter;1962;Winterthur;03:29:21.3;\n" + 
		"6003;Beinhoff Martin;1970;Zollikon;03:51:58.2;\n" + 
		"6004;Bucherer Thomas;1982;Zollikon;04:07:49.2;\n" + 
		"6005;Cupples Richard;1978;Zollikon;03:34:25.9;\n" + 
		"6006;Dorn Alexander;1976;Zollikon;03:47:21.5;\n" + 
		"6007;Frou Benoit;1980;Zollikon;03:31:11.6;\n" + 
		"6008;Gerull John-Phillip;1974;Zollikon;03:23:42.2;\n" + 
		"6010;Hertig Andi;1973;Zollikon;03:59:01.1;\n" + 
		"6011;Joss Myriam;1975;Zollikon;03:33:17.7;\n" + 
		"6012;Lichtenberger Alexande;1975;Zollikon;04:10:32.4;\n" + 
		"6013;Mimouni Didier;1965;Zollikon;03:13:49.1;\n" + 
		"6014;Moeckli Simon;1993;Zollikon;03:55:15.5;\n" + 
		"6015;Nashid Ibrahim;1966;Zollikon;04:13:34.7;\n" + 
		"6016;Ochsner Thomy;1976;Zollikon;04:52:15.2;\n" + 
		"6017;Schmid Alex;1959;Zollikon;04:20:38.5;\n" + 
		"6018;van Ulzen Manuela;1967;Zollikon;03:56:48.8;\n" + 
		"6019;Vogeli Bernhard;1968;Zollikon;03:23:07.4;\n" + 
		"6020;Waldburger Claudio;1962;Zollikon;03:43:51.9;\n" + 
		"6021;Walser Alexander;1954;Zollikon;04:15:57.0;\n" + 
		"6022;Witzel Christian;1977;Zollikon;03:17:20.1;\n" + 
		"6023;Rupp Thomas H.;1969;Zollikon;03:29:09.6;\n" + 
		"6101;Affolter Darius;1990;K�snacht ZH;03:24:44.8;\n" + 
		"6104;Graham Angus;1967;K�snacht ZH;04:31:29.8;\n" + 
		"6106;Lee Jon;1971;K�snacht ZH;03:55:54.6;\n" + 
		"6107;Luessi Andreas;1974;K�snacht ZH;03:19:44.4;\n" + 
		"6108;Melas Theocharis;1956;K�snacht ZH;05:24:59.7;\n" + 
		"6110;Rentsch Beat;1966;K�snacht ZH;03:41:14.7;\n" + 
		"6111;Rezk Markus;1976;K�snacht ZH;03:56:55.2;\n" + 
		"6112;Schumacher Martin;1968;K�snacht ZH;03:44:43.2;\n" + 
		"6113;Sieger Pascal;1982;K�snacht ZH;03:17:43.8;\n" + 
		"6115;Sutter Andy;1971;K�snacht ZH;04:12:08.0;\n" + 
		"6116;van Buul Peter;1966;K�snacht ZH;03:26:02.6;\n" + 
		"6118;Wieland Lucio;1989;K�snacht ZH;04:56:57.3;\n" + 
		"6119;Zuzak Miro;1978;K�snacht ZH;04:30:29.7;\n" + 
		"6120;De-Vizzi Evelyn;1959;K�snacht ZH;04:52:55.3;\n" + 
		"6121;De-Vizzi Fiona;1992;K�snacht ZH;04:26:54.7;\n" + 
		"6122;Kl�ger Roland;1977;K�snacht ZH;03:15:58.8;\n" + 
		"6201;Allard Darren;1967;Erlenbach ZH;04:26:56.4;\n" + 
		"6204;Greco Luigi;1967;Erlenbach ZH;04:01:57.2;\n" + 
		"6205;Huber Sibylle;1959;Erlenbach ZH;03:52:02.2;\n" + 
		"6206;Ostertag Andreas;1957;Erlenbach ZH;03:02:03.7;\n" + 
		"6207;Piekarz Iwona;1976;Erlenbach ZH;04:05:35.5;\n" + 
		"6208;Rodriguez Jos� Manuel;1969;Erlenbach ZH;04:26:30.9;\n" + 
		"6210;Waelti Philippe;1964;Erlenbach ZH;03:43:39.0;\n" + 
		"6211;Ziegler Philippe;1993;Erlenbach ZH;03:26:06.0;\n" + 
		"6301;Baumgartner Rico;1959;Herrliberg;03:57:39.3;\n" + 
		"6302;Cestonato Antonella;1966;Herrliberg;04:01:16.4;\n" + 
		"6303;Eggenberger Kurt;1963;Herrliberg;03:40:38.8;\n" + 
		"6304;Enderlin Mich�le;1944;Herrliberg;04:41:47.1;\n" + 
		"6305;Hauser Claudia;1965;Herrliberg;03:53:32.8;\n" + 
		"6306;Litscher Daniel;1972;Herrliberg;04:06:55.2;\n" + 
		"6307;Regenscheit Fabian;1984;Herrliberg;03:43:11.8;\n" + 
		"6308;Sommer Martin;1971;Herrliberg;04:23:44.8;\n" + 
		"6309;Mathis Stefan;1981;Herrliberg;03:36:46.0;\n" + 
		"6310;Merkli Stephan;1973;Herrliberg;03:06:32.1;\n" + 
		"6311;T�rler Thomas;1967;Herrliberg;03:08:12.6;\n" + 
		"6401;Baumann Matthias;1973;Meilen;03:31:08.5;\n" + 
		"6402;Baumgartner Philip;1964;Meilen;03:42:46.7;\n" + 
		"6403;Biefer Christian;1947;Meilen;03:34:56.4;\n" + 
		"6405;Faller Sascha;1988;Meilen;04:17:10.0;\n" + 
		"6406;Ganz Jeannette;1967;Meilen;03:52:36.6;\n" + 
		"6407;Hari Daniel;1972;Meilen;03:01:44.4;\n" + 
		"6408;H�sser Zoe;1986;Meilen;04:10:43.6;\n" + 
		"6409;Lacy David;1968;Meilen;03:26:32.1;\n" + 
		"6411;Maag Felix;1970;Meilen;03:38:30.9;\n" + 
		"6412;Rehal Jaspal;1978;Meilen;03:53:54.4;\n" + 
		"6413;Sax Fredi;1965;Meilen;04:31:08.8;\n" + 
		"6414;Schmitt Martin;1977;Meilen;03:54:46.5;\n" + 
		"6415;Schraven Jan-Christian;1964;Obermeilen;05:28:19.0;\n" + 
		"6416;Stoller Fabienne;1985;Meilen;04:38:16.1;\n" + 
		"6417;Winkler Hansj�rg;1962;Meilen;03:25:01.0;\n" + 
		"6418;Zanotelli Reto;1955;Meilen;03:47:17.5;\n" + 
		"6419;Hug Pascal;1969;Meilen;03:13:19.9;\n" + 
		"6420;Pavlovic Marko;1960;Feldmeilen;03:06:25.1;\n" + 
		"6421;Seebach Nicole;1968;Meilen;04:18:42.6;\n" + 
		"6422;Wegmann Joachim;1973;Feldmeilen;04:22:49.0;\n" + 
		"7001;Leupi Daniel;1965;Z�rich;03:38:01.3;\n" + 
		"7002;Ziegler Roger;1990;Bassersdorf;03:16:34.3;\n" + 
		"7003;F�ssler Hildegard;1951;Grabs;03:38:29.4;\n" + 
		"7005;Egger Urs;1955;Z�rich;03:17:35.5;\n" + 
		"7006;Egger Urs;1955;Z�rich;03:35:12.7;\n" + 
		"7007;Abele Martin;1963;Z�rich;03:17:01.9;\n" + 
		"7008;Schmidig Urs;1968;Uster;03:25:06.6;\n" + 
		"7009;Mayenzet Didier;1973;Z�rich;03:24:19.9;\n" + 
		"7010;R�dis�li Pius;1959;Herrliberg;03:09:17.0;\n" + 
		"7011;Lauener Nicole;1970;Erlenbach ZH;03:55:59.2;\n" + 
		"7012;Wettstein Peter;1967;K�snacht ZH;03:58:32.8;\n" + 
		"7013;Wettstein Peter;1967;Illnau;03:33:56.4;\n" + 
		"7014;Wettstein Peter;1967;Illnau;03:48:10.4;\n" + 
		"7015;Welti Martin;1978;Kilchberg ZH;03:21:19.9;\n" + 
		"7016;Smits L�on;1964;Z�rich;03:31:41.3;\n" + 
		"7017;Diethelm Theri;1968;Zug;04:17:34.0;\n" + 
		"7018;Achermann Annemarie;1958;Z�rich;04:04:04.4;\n" + 
		"7019;Thomys Heike;1980;R�cl�re;03:55:56.8;\n" + 
		"7020;Thomys Heike;1980;R�cl�re;04:04:24.4;\n" + 
		"7021;Dettwiler Daniel;1969;Pf�ffikon SZ;03:35:12.1;\n" + 
		"7022;Zehr Bruno;1975;Glattfelden;03:20:21.9;\n" + 
		"7024;Spycher Hunziker Susan;1980;Mellingen;03:29:11.2;\n" + 
		"7025;Grieder Sandra;1973;Winterthur;04:03:23.1;\n" + 
		"7026;Schumpf Nicole;1980;Schindellegi;04:33:36.3;\n" + 
		"7027;Gantner Felicitas;1969;W�denswil;03:39:29.7;\n" + 
		"7028;Vaucher Pascale;1978;Uster;03:37:56.5;\n" + 
		"7029;Frost Elke;1973;Z�rich;03:15:55.7;\n" + 
		"7030;Vorbrodt Dominique;1965;Z�rich;03:41:23.8;\n" + 
		"7031;Koch Pascal;1985;Schlieren;03:21:34.9;\n" + 
		"7032;Ferrari-Fidel Frederic;1983;Z�rich;03:21:19.8;\n" + 
		"7033;Cloos Lis;1985;Z�rich;03:42:50.9;\n" + 
		"7034;Urosevic Aleksandra;1986;Buchs ZH;03:36:55.0;\n" + 
		"7035;Knaus Mich�le;1969;Berikon;04:24:04.0;\n" + 
		"7036;Fl�ckiger Miriam;1976;Z�rich;03:48:12.8;\n" + 
		"7037;Stutz Markus;1961;Herrliberg;03:29:55.2;\n" + 
		"7038;Niffenegger Viktor;1952;Hinwil;03:15:01.3;\n" + 
		"7039;Wehleit Kolja;1971;Z�rich;03:37:34.4;\n" + 
		"7040;Wehleit Kolja;1971;Z�rich;03:53:06.3;\n" + 
		"7041;Wehleit Kolja;1971;Z�rich;03:38:34.9;\n" + 
		"7042;Knecht Anina;1985;Z�rich;03:28:39.7;\n" + 
		"7043;Pfister Ren�;1968;Wangen SZ;04:04:57.2;\n" + 
		"7044;Fr�hlich Val�rie;1971;Aeugst am Albis;03:35:20.5;\n" + 
		"7045;Blomberg Per-Inge;1961;Z�rich;04:02:01.8;\n" + 
		"7046;Lhommel Laurence;1971;Mettmenstetten;03:13:06.8;\n" + 
		"7047;Bollinger-K�nz Dieter;1960;Meilen;03:08:41.2;\n" + 
		"7049;Brutschi Daniela;1964;Z�rich;03:38:47.8;\n" + 
		"7050;Platzer Martina;1967;Z�rich;03:46:53.0;\n" + 
		"7051;Ammann Barbara;1970;Oberrieden;02:58:56.3;\n" + 
		"7052;Aubry Luzia;1959;W�renlos;03:29:33.1;\n" + 
		"7054;St�ssel Daniel;1969;Uster;03:26:15.0;\n" + 
		"7055;Gschwend Christian;1982;Z�rich;03:41:46.2;\n" + 
		"7056;Leiser Kolja;1976;Affoltern am Albi;03:37:04.8;\n" + 
		"7057;Gr�tter Urs;1954;Hombrechtikon;03:05:29.8;\n" + 
		"7058;Coester Franz;1958;Eggenwil;03:53:05.8;\n" + 
		"7059;Wirz Markus;1967;Uster;03:25:52.8;\n" + 
		"7060;Wirz Markus;1967;Uster;03:22:32.2;\n" + 
		"7061;Albisser Beat;1965;Bubendorf;03:36:49.4;\n" + 
		"7062;Endres Julia;1979;Z�rich;03:56:24.5;\n" + 
		"7063;Ummel Beat;1960;Suhr;03:14:20.7;\n" + 
		"7064;Fischer Hurter Daniel;1976;Aarau;03:12:31.4;\n" + 
		"7065;Senn Rolf;1968;Bellikon;03:04:12.0;\n" + 
		"7066;Tobler Raphael;1987;Winterthur;03:17:22.0;\n" + 
		"7067;Tobler Raphael;1987;Winterthur;03:16:41.6;\n" + 
		"7068;Tobler Raphael;1987;Winterthur;03:15:21.0;\n" + 
		"7070;Eggimann Thomas;1967;Kehrsatz;03:25:22.5;\n" + 
		"7071;Bartholdi Andre;1966;R�mlang;03:26:19.9;\n" + 
		"7072;Merk Gaby;1962;D�bendorf;03:49:16.5;\n" + 
		"7073;Limacher Esther;1985;Winterthur;03:20:57.8;\n" + 
		"7074;Badertscher Sara;1978;Wermatswil;03:45:10.6;\n" + 
		"7075;Francotte Benedicte;1981;Olten;03:55:30.9;\n" + 
		"7076;Boschung Bernard;1951;Epagny;04:01:42.7;\n" + 
		"7077;Oswald Manfred;1971;Z�rich;03:27:07.8;\n" + 
		"7078;Steiner Markus;1986;Zielebach;03:28:41.5;\n" + 
		"7079;von Euw Martin;1984;St�fa;03:40:19.3;\n" + 
		"7080;Buergi Taboada Carole;1980;Z�rich;03:09:43.1;\n" + 
		"7081;Cordey Olivier;1972;Feldmeilen;03:44:06.7;\n" + 
		"7082;Richinger David;1971;Z�rich;03:29:20.7;\n" + 
		"7083;Caminada Rafael;1972;Kloten;03:47:59.1;\n" + 
		"7084;Schuermann Balz;1974;Zollikon;03:14:12.4;\n" + 
		"7085;Charri�re Thomas;1990;Herrliberg;03:49:45.7;\n" + 
		"7086;Vaterlaus Peter;1962;Wittenbach;03:34:58.1;\n" + 
		"7087;Eggimann Andreas;1982;Z�rich;03:21:26.4;\n" + 
		"7088;Gemperle Patrik;1976;Langnau a.A;03:40:13.6;\n" + 
		"7090;Point Laetitia;1981;Z�rich;03:24:53.5;\n" + 
		"7091;Preisig Ueli;1978;Adliswil;03:25:43.5;\n" + 
		"7092;Huber Nadine;1987;Urdorf;04:15:00.0;\n" + 
		"7093;Friedli Corinne;1964;Rubigen;03:30:37.4;\n" + 
		"7094;Knechtli Thomas;1969;Z�rich;03:26:56.1;\n" + 
		"7095;Hasler Catherine;1977;Z�rich;03:32:33.5;\n" + 
		"7096;B�llenr�cher Melanie;1987;D�nikon ZH;03:09:13.6;\n" + 
		"7097;Oung Raymond;1983;Z�rich;03:57:14.8;\n" + 
		"7098;Hassler Daniel;1981;Hedingen;03:33:44.8;\n" + 
		"7099;Bachmann Maria;1985;Seedorf BE;03:43:11.0;\n" + 
		"7100;Petersen Claus Gregers;1966;Z�rich;04:00:18.8;\n" + 
		"7101;Petersen Claus Gregers;1966;Z�rich;03:52:08.6;\n" + 
		"7102;Koch Roman;1960;Pf�ffikon SZ;03:56:38.8;\n" + 
		"7103;Thalmann Hans-Peter;1963;Bertschikon (Goss;03:44:32.5;\n" + 
		"7104;Beck Lea;1982;Z�rich;03:30:28.7;\n" + 
		"7105;Beck Lea;1982;Z�rich;03:10:59.2;\n" + 
		"7106;Beck Lea;1982;Z�rich;03:27:46.3;\n" + 
		"7107;Inderbitzin Kevin;1984;Baar;03:30:31.4;\n" + 
		"7108;Ledergerber Isabelle;1979;Z�rich;03:26:53.5;\n" + 
		"7109;Carnevale Vito;1982;Villars-sur-Gl�ne;03:54:49.9;\n" + 
		"7110;Nguyen Raphael;1979;Villars-sur-Gl�ne;03:38:06.6;\n" + 
		"7111;Huwyler Reto;1957;Z�rich;03:49:32.6;\n" + 
		"7112;Trappitsch Stefan;1965;Uetikon a.S.;03:49:28.6;\n" + 
		"7113;Meier David;1969;Widen;03:55:16.3;\n" + 
		"7114;Weisstanner Andreas;1962;Celerina/Schlarig;03:39:43.2;\n" + 
		"7115;Donath Marc;1963;Adliswil;03:33:25.0;\n" + 
		"7117;Klein Tobias;1969;Meilen;03:51:55.8;\n" + 
		"7118;Keller Claudia;1973;Z�rich;03:33:02.7;\n" + 
		"7119;Gabriel Reto;1967;Herrliberg;03:35:04.0;\n" + 
		"7120;Holzinger Thomas;1961;Z�rich;03:35:01.2;\n" + 
		"7121;Frischknecht Christine;1960;Z�rich;03:52:07.1;\n" + 
		"7122;Roth Jeannine;1969;Winterthur;04:01:38.6;\n" + 
		"7123;Delahaye Benjamin;1979;Z�rich;03:22:30.2;\n" + 
		"7124;Trifari Patricia;1963;Grenchen;03:34:45.5;\n" + 
		"7125;M�hlberg Martin;1965;Weiningen ZH;03:28:10.9;\n" + 
		"7127;Leuenberger Susanne;1978;Schindellegi;04:09:14.5;\n" + 
		"7128;Lurati Laura;1987;Z�rich;03:41:38.9;\n" + 
		"7129;Cackett Joanne;1984;Z�rich;03:35:02.7;\n" + 
		"7130;Baumgartner Philipp;1963;Embrach;03:31:11.3;\n" + 
		"7131;Altmann Andreas;1970;St�fa;03:38:29.8;\n" + 
		"7132;Marti Gabriel;1988;Samstagern;03:20:21.8;\n" + 
		"7133;Steiger-Glocker Gaby;1962;F�llanden;03:59:20.6;\n" + 
		"7134;Ruprecht Balz;1984;Herisau;03:04:17.3;\n" + 
		"7135;Stoessel Laura;1988;Feldmeilen;03:39:06.5;\n" + 
		"7136;Lauffenburger Roman;1972;Winterthur;03:56:36.6;\n" + 
		"7138;Williamson Libby;1976;Z�rich;03:54:41.0;\n" + 
		"7139;Koch Gisela;1974;Schwerzenbach;04:21:23.3;\n" + 
		"7140;Gubelmann Patrick;1976;Dietikon;03:49:50.0;\n" + 
		"7141;Majoleth Stefan;1980;Domat/Ems;03:16:44.7;\n" + 
		"7142;Parro Paolo;1982;Samstagern;03:23:59.2;\n" + 
		"7143;Zollinger Reto;1960;Wetzikon ZH;03:23:12.7;\n" + 
		"7144;Gundermann Julia;1982;Meilen;04:19:35.5;\n" + 
		"7145;Tross-M�ller Marianne;1967;Bachenb�lach;04:02:29.8;\n" + 
		"7146;M�ller Anna-Katharina;1981;Z�rich;03:32:55.9;\n" + 
		"7147;Suter Lorena;1992;Fehraltorf;03:46:31.1;\n" + 
		"7148;Grindley Peter;1956;Ebmatingen;03:49:28.6;\n" + 
		"7149;Leutwiler Sara;1973;Oetwil am See;03:40:08.6;\n" + 
		"7150;Bachmann Beatrice;1982;Obfelden;04:23:48.9;\n" + 
		"7151;Streuli Gabriela;1978;St�fa;03:18:41.6;\n" + 
		"7152;Stefka Daniel;1977;Z�rich;03:49:46.4;\n" + 
		"7153;Kofel Felix;1961;Ehrendingen;03:34:29.6;\n" + 
		"7154;Burkhard Patrick;1980;W�renlos;03:06:38.8;\n" + 
		"7155;Hess Corina;1984;Meilen;03:56:24.7;\n" + 
		"7156;Lehmann Beat;1977;Baden;04:18:47.4;\n" + 
		"7157;Patkovic Slavica;1972;Turgi;04:14:22.9;\n" + 
		"7158;Rudat J�rg;1969;W�renlingen;04:03:15.4;\n" + 
		"7159;Price Robert;1981;D�bendorf;03:48:57.9;\n" + 
		"7160;Imhof Nathalie;1971;Baden;04:10:43.7;\n" + 
		"7161;Sommer Ernesto;1956;Urdorf;04:23:31.9;\n" + 
		"7162;von Gunten Erich;1959;Gr�ningen;03:36:42.9;\n" + 
		"7163;Niederberger Katja;1979;Z�rich;04:31:56.7;\n" + 
		"7164;P�chel Johannes;1978;Z�rich;03:43:53.3;\n" + 
		"7165;Studer Lukas;1988;St. Gallen;03:20:55.7;\n" + 
		"7167;Graf Bettina;1983;Z�rich;03:32:31.9;\n" + 
		"7168;Burckhardt Straub Caro;1972;Herrliberg;04:10:05.5;\n" + 
		"7169;Camenzind Sepp;1956;Buchs ZH;03:36:18.1;\n" + 
		"7170;Rech Marielle;1968;Winterthur;03:25:46.7;\n" + 
		"7171;Gut Michael;1980;Wetzikon ZH;03:31:07.9;\n" + 
		"7172;Sigg Arnold;1965;Henggart;03:25:00.5;\n" + 
		"7173;Honegger Silja;1981;Wetzikon ZH;03:45:55.5;\n" + 
		"7174;Heiz Patrick;1977;Z�rich;04:12:02.0;\n" + 
		"7175;Rais Jeanne;1981;Winterthur;04:01:39.4;\n" + 
		"7176;Beyeler Erika;1971;Urdorf;03:53:31.7;\n" + 
		"7177;Z�rcher Thomas;1964;Thalwil;03:33:57.9;\n" + 
		"7178;Sutter Matthias;1962;Weiningen ZH;03:46:55.3;\n" + 
		"7179;Sutter Matthias;1962;Weiningen ZH;03:24:44.2;\n" + 
		"7180;Sutter Matthias;1962;Weiningen ZH;03:54:50.5;\n" + 
		"7181;Jud Maria;1987;L�tisburg;03:49:48.5;\n" + 
		"7182;Bonfranchi Riccardo;1950;Wolfhausen;04:33:12.3;\n" + 
		"7183;Rigamonti Alessandro;1989;Adliswil;03:31:34.0;\n" + 
		"7184;Kaufmann Patrick;1987;Z�rich;03:26:30.1;\n" + 
		"7185;Ortega Lydia;1978;Winterthur;04:20:15.7;\n" + 
		"7186;De Faveri Marisa;1978;Neerach;03:50:29.7;\n" + 
		"7187;Ortega Lydia;1978;Winterthur;03:41:42.2;\n" + 
		"7188;Hruba Gabriela;1979;Bern;03:35:52.7;\n" + 
		"7189;Hruba Gabriela;1979;Bern;03:53:28.6;\n" + 
		"7190;Kilbert Gert;1965;Hittnau;02:58:12.3;\n" + 
		"7191;Aniol Wars;1972;Neuhausen am Rhei;02:51:31.1;\n" + 
		"7192;Kraus Bret;1961;Winterthur;03:31:50.2;\n" + 
		"7193;Wenger Esther;1959;Hombrechtikon;03:58:17.1;\n" + 
		"7194;Schneeberger Ivonne;1973;Morgarten;03:33:36.3;\n" + 
		"7195;Luginb�hl Carolin;1982;Z�rich;03:41:17.9;\n" + 
		"7196;Furrer Roman;1988;St. Gallen;03:24:42.4;\n" + 
		"7197;Nesme Salome;1988;St. Gallen;03:41:42.7;\n" + 
		"7198;Pirlet Xavier;1991;Avry-sur-Matran;02:51:29.0;\n" + 
		"7199;Schneeberger Ivonne;1973;Morgarten;03:55:03.3;\n" + 
		"7200;Schneeberger Ivonne;1973;Morgarten;03:30:43.7;\n" + 
		"7201;Schneeberger Ivonne;1973;Morgarten;04:34:24.8;\n" + 
		"7202;Schneeberger Ivonne;1973;Morgarten;03:40:37.1;\n" + 
		"7203;Schneeberger Ivonne;1973;Morgarten;03:13:40.7;\n" + 
		"7204;Schneeberger Ivonne;1973;Morgarten;03:50:16.8;\n" + 
		"7205;Schneeberger Ivonne;1973;Morgarten;03:54:05.3;\n" + 
		"7206;Schneeberger Ivonne;1973;Morgarten;03:14:16.9;\n" + 
		"7207;Schneeberger Ivonne;1973;Morgarten;04:05:02.7;\n" + 
		"7208;Montanari Dani;1987;Z�rich;03:01:41.2;\n" + 
		"7209;Dolfing Henrico;1981;Z�rich;02:52:39.4;\n" + 
		"7210;Maag Ana;1975;Meilen;02:50:57.2;\n" + 
		"7211;Hafner Markus;1969;D�bendorf;03:48:44.7;\n" + 
		"7213;Schilliger Rolf;1968;Hedingen;03:41:56.1;\n" + 
		"7214;Fontanive Christian;1977;W�denswil;04:39:49.0;\n" + 
		"7215;Fontanive Christian;1977;W�denswil;03:32:31.9;\n" + 
		"7216;Fontanive Christian;1977;W�denswil;03:50:43.3;\n" + 
		"7217;M�der Petra;1974;Binz;04:12:24.2;\n" + 
		"7218;Schneeberger Ivonne;1973;Morgarten;04:13:15.0;\n" + 
		"7219;Ritter Christine;1979;Aarwangen;03:53:54.8;\n" + 
		"7220;Hancock Julia;1968;Zollikon;04:06:52.5;\n" + 
		"7221;Hildebrand Carmen;1969;Hedingen;03:30:30.0;\n" + 
		"7222;Reiser Evelyne;1975;Hettlingen;03:23:32.0;\n" + 
		"7223;Schaller Oscar;1959;Oberwil BL;02:58:40.7;\n" + 
		"7224;F�h Marco;1973;Kaltbrunn;03:03:43.9;\n" + 
		"7225;Grogg Diana;1972;Kaltbrunn;03:08:03.7;\n" + 
		"7226;Holdener Laura;2001;Benken SG;03:57:17.3;\n" + 
		"7227;Jud Janine;1991;Benken SG;03:28:37.9;\n" + 
		"7228;Ebn�ther Reto;1980;Wetzikon ZH;03:18:10.3;\n" + 
		"7229;Thomas Astrid;1959;Embrach;04:08:52.8;\n" + 
		"7230;Schawalder Peter;1952;Embrach;03:51:06.5;\n" + 
		"7231;Lassmann Fredi;1963;Z�rich;03:09:56.7;\n" + 
		"7232;Hansmann Nicole;1983;Rickenbach ZH;03:52:12.0;\n" + 
		"7233;Fuhrer Susanna;1972;Fehraltorf;03:36:22.6;\n" + 
		"7235;G�ttinger Daniel;1980;Z�rich;03:34:01.3;\n" + 
		"7236;Eugster Olivier;1982;La Tour-de-Peilz;02:53:58.1;\n" + 
		"7237;Fitoussi Cecile;1972;Wangen b. D�bendo;04:32:55.9;\n" + 
		"7238;Holzberg Nina;1983;D�bendorf;03:38:14.5;\n" + 
		"7239;Zahno Andi;1957;Geroldswil;03:54:03.4;\n" + 
		"7240;Gyomlay Katinka;1969;Eglisau;03:40:30.9;\n" + 
		"7241;Leitner Fabian;1984;Bassersdorf;03:19:16.4;\n" + 
		"7242;Reber Samuel;1981;Z�rich;03:13:08.2;\n" + 
		"7243;Marti Georg;1964;Zollikerberg;03:33:04.8;\n" + 
		"7244;Ruggaber Michel;1965;Z�rich;03:18:31.2;\n" + 
		"7245;Theiler Helen;1971;Luzern;04:11:34.1;\n" + 
		"7246;Theiler Helen;1971;Luzern;03:44:07.8;\n" + 
		"7247;Hormann Christian;1970;M�nnedorf;03:28:45.1;\n" + 
		"7248;Hempen Roland;1959;Z�rich;03:55:05.5;\n" + 
		"7249;Koch Gisela;1974;Schwerzenbach;03:50:52.0;\n" + 
		"7250;Kollbrunner Rebekka;1982;Winterthur;03:53:14.9;\n" + 
		"7251;Schmid Daria;1976;Z�rich;03:35:02.3;\n" + 
		"7252;Wigger Marcel;1960;Kilchberg ZH;03:32:08.3;\n" + 
		"7253;Hirt Christian;1960;R�mlang;04:11:43.3;\n" + 
		"7254;M�hlethaler Armando;1972;Glattfelden;03:37:55.2;\n" + 
		"7258;Weiss Ruth;1975;Z�rich;03:45:49.1;\n" + 
		"7259;Weisstanner Andreas;1962;Celerina/Schlarig;03:30:56.0;\n" + 
		"7260;Roberts Tania;1976;Z�rich;03:52:05.6;\n" + 
		"7261;Fischer Marcel;1979;H�nenberg See;03:21:50.0;\n" + 
		"7262;Fischer Marcel;1979;H�nenberg See;03:37:54.2;\n" + 
		"7263;Blunschi Selina;1983;Z�rich;04:04:23.1;\n" + 
		"7264;S�uberli Franziska;1982;St. Moritz;03:50:01.9;\n" + 
		"7265;H�rlimann Janine;1984;Bassersdorf;04:30:01.3;\n" + 
		"7266;Favre Guy;1975;Bretonni�res;02:38:31.4;\n" + 
		"7267;Wehrli Edith;1952;Russikon;03:40:23.1;\n" + 
		"7268;Bonfils Jacqueline;1973;Bassersdorf;03:40:51.1;\n" + 
		"7269;Schneider Sven;1999;Bassersdorf;03:37:03.3;\n" + 
		"7270;Annaheim Simon;1979;St. Gallen;02:29:43.2;\n" + 
		"7271;Mohenski Brigitte;1978;Ennetmoos;04:06:01.5;\n" + 
		"7272;Fischer Marc Pascal;1979;K�snacht ZH;03:17:03.8;\n" + 
		"7273;Stettler Stefan;1974;Kollbrunn;03:49:30.2;\n" + 
		"7274;Stettler Christa;1978;Kollbrunn;03:20:45.8;\n" + 
		"7275;Hocher Ursula;1980;Luzern;04:09:44.0;\n" + 
		"7276;Hager Michel;1970;Eggenwil;03:29:40.7;\n" + 
		"7277;Kreppke Jan-Niklas;1992;Binningen;02:37:53.1;\n" + 
		"7278;Grassi Grazia;1974;Z�rich;04:03:01.1;\n" + 
		"7279;Cerjak-Frei Cornelia;1969;Kilchberg ZH;03:52:05.8;\n" + 
		"7280;Suter Peter A.;1957;Ossingen;03:32:10.6;\n" + 
		"7281;F�llmi Carolyn;1967;Z�rich;04:15:45.6;\n" + 
		"7282;Bischof Simone;1976;Wagen;03:08:49.4;\n" + 
		"7284;Ruile Stefan;1968;Z�rich;02:46:27.9;\n" + 
		"7285;Schneider Roland;1965;Hedingen;03:46:04.9;\n" + 
		"7286;Scott Steven;1995;Zollikerberg;03:04:03.1;\n" + 
		"7287;Hohl Isabelle;1965;Thalwil;03:33:15.7;\n" + 
		"7288;Stirnimann Ruedi;1979;Ebikon;03:47:04.2;\n" + 
		"7289;Stirnimann Ruedi;1979;Ebikon;03:44:25.4;\n" + 
		"7290;Weiss Martin;1965;Wetzikon ZH;03:07:33.0;\n" + 
		"7291;Fuccaro Alexandra;1977;Salgesch;03:31:42.7;\n" + 
		"7292;Ratjen Christian;1978;Z�rich;03:33:12.7;\n" + 
		"7293;Walter Susanna;1979;Kilchberg ZH;04:09:57.4;\n" + 
		"7294;Lucas Elise;1984;Z�rich;03:29:58.8;\n" + 
		"7295;Abbenseth Ben;1980;Z�rich;03:13:55.0;\n" + 
		"7296;Skalik Vojtech;1986;Turbenthal;03:25:57.6;\n" + 
		"7297;Meier Michael;1975;Zollikon;03:08:48.7;\n" + 
		"7298;Bieler Sarah;1993;Urdorf;03:57:19.5;\n" + 
		"7299;Vetter Beat;1965;Aadorf;03:02:15.8;\n" + 
		"7300;Klinkmann Thomas;1988;Uerikon;03:22:48.2;\n" + 
		"7301;Frey Marcel;1975;Uster;04:07:28.3;\n" + 
		"7302;Frey Marcel;1975;Uster;03:33:33.8;\n" + 
		"7304;Scholz Urte;1975;Z�rich;04:03:08.1;\n" + 
		"7305;Maltry Karin;1976;Gattikon;03:50:28.7;\n" + 
		"7306;Gloor Marco;1969;Z�rich;03:47:16.8;\n" + 
		"7307;Str�bele Ren�;1971;Eglisau;04:01:34.2;\n" + 
		"7308;Cal�rtscher Denise;1981;Altendorf;03:37:54.9;\n" + 
		"7309;Magee Karina;1976;Wallisellen;03:21:43.1;\n" + 
		"7310;Rabenbauer Karin;1965;Wettswil;03:48:48.0;\n" + 
		"7311;Rauber-L�thy Christine;1955;Z�rich;03:58:37.3;\n" + 
		"7312;Ballabio-H�hne Sabrina;1965;Hinteregg;03:52:51.5;\n" + 
		"7314;M�chler Emil;1969;Lachen SZ;03:36:50.7;\n" + 
		"7315;Hausmann Nicole;1975;Wetzikon ZH;04:00:49.7;\n" + 
		"7316;K�lin Robin;1992;W�renlos;04:24:31.2;\n" + 
		"7317;Maier Sandy;1970;Pfungen;04:04:36.9;\n" + 
		"7319;Werer Karin;1972;Z�rich;03:41:33.6;\n" + 
		"7320;Schilling Stephanie;1982;Aadorf;04:22:31.9;\n" + 
		"7321;Ineichen Gerhard;1959;R�ti ZH;03:16:54.1;\n" + 
		"7322;Gilgen Sascha;1982;Oberengstringen;03:27:09.1;\n" + 
		"7323;Salinas Antoinette;1970;Wil SG;03:52:57.3;\n" + 
		"7324;R�themann Helen;1984;W�renlos;03:25:42.5;\n" + 
		"7325;Bracko Oliver;1979;Z�rich;03:09:00.2;\n" + 
		"7326;Schaelin Marcel;1978;Z�rich;03:47:54.9;\n" + 
		"7327;L�llau Claus;1969;Z�rich;04:07:23.3;\n" + 
		"7328;Sp�ni Andrea;1984;Pf�ffikon SZ;03:41:38.7;\n" + 
		"7329;Donner Georg;1977;Winterthur;03:26:31.9;\n" + 
		"7330;Rutz Eric;1960;Greifensee;03:49:55.7;\n" + 
		"7331;Stampfli Reto;1964;Gattikon;03:10:50.2;\n" + 
		"7332;Wloka Martin;1978;B�lach;03:32:23.2;\n" + 
		"7333;Belguendouz Abdelmalek;1956;Wohlen AG;03:51:14.4;\n" + 
		"7334;W�thrich Thomas;1969;Uster;03:21:20.5;\n" + 
		"7335;Schmiedler Ursula;1943;R�schlikon;03:25:43.0;\n" + 
		"7336;G�ldenapfel Erhard;1937;Adliswil;03:41:31.0;\n" + 
		"7337;Sch�nb�chler Ralph;1967;Feusisberg;03:41:31.5;\n" + 
		"7338;Hofmann Daniel;1968;Thalwil;03:20:55.5;\n" + 
		"7339;Traxler Sabrina;1979;Wil SG;03:23:26.2;\n" + 
		"7340;Traxler Sabrina;1979;Wil SG;03:24:52.8;\n" + 
		"7341;Schneble Max Charles;1980;Kilchberg ZH;03:11:57.8;\n" + 
		"7342;Wichmann Fabienne;1981;M�nchenstein;03:47:39.0;\n" + 
		"7343;Frei Stefan;1960;Thalwil;03:41:43.6;\n" + 
		"7344;Biedermann Urs;1961;Glattfelden;03:27:19.3;\n" + 
		"7345;Guindo Dominique;1972;Zollikon;04:17:47.1;\n" + 
		"7346;Niehus Swaantje;1985;Zollikon;03:43:50.3;\n" + 
		"7347;Ch�vre Fr�d�ric;1976;Zollikon;04:07:45.6;\n" + 
		"7349;Mose Soren;1964;Zollikon;03:43:22.5;\n" + 
		"7350;Shtufi Lara;1989;Zollikon;03:59:00.0;\n" + 
		"7352;M�ller Wenzel;1977;Zollikon;03:51:13.7;\n" + 
		"7353;Schoenholzer Beat;1974;Zollikon;03:46:45.7;\n" + 
		"7354;Schultz Tilman;1973;Zollikon;04:07:14.6;\n" + 
		"7355;K�lsky Carsten;1980;Zollikon;03:40:21.6;\n" + 
		"7356;Schieler Katrin;1974;Zollikon;04:27:28.6;\n" + 
		"7357;Schmidt Marc Andre;1973;Zollikon;04:13:16.0;\n" + 
		"7358;Kadlec Sven;1967;Reinach AG;03:35:45.2;\n" + 
		"7359;H�rler Rhea;1983;Rapperswil;03:59:12.4;\n" + 
		"7360;Gehri Friederike;1992;Gr�ningen;04:01:45.4;\n" + 
		"7361;Kaufmann Christian;1977;Z�rich;03:51:07.3;\n" + 
		"7362;Tschurr Flavian;1993;Wetzikon ZH;03:20:50.2;\n" + 
		"7363;D�rgeloh Martin;1958;Uitikon Waldegg;03:13:13.5;\n" + 
		"7364;Elmer Heiri;1977;Lachen SZ;03:23:34.2;\n" + 
		"7365;Elmer Heiri;1977;Lachen SZ;03:31:30.3;\n" + 
		"7366;Elmer Heiri;1977;Lachen SZ;03:26:55.4;\n" + 
		"7367;Stauch Vanessa;1976;Z�rich;03:11:35.6;\n" + 
		"7368;Sieber Eva;1985;Z�rich;03:57:18.3;\n" + 
		"7369;Suter Franziska;1970;Oberrieden;02:59:01.5;\n" + 
		"7370;Scattolin Pascal;1972;D�bendorf;03:11:31.8;\n" + 
		"7371;Walter Thomas;1970;W�renlos;03:29:40.3;\n" + 
		"7372;Seger Holger;1970;Herrliberg;03:29:57.5;\n" + 
		"7373;Ruest Erich;1973;Jona;03:29:54.5;\n" + 
		"7375;Sigrist Yvonne;1964;Luzern Reussb�hl;03:28:37.3;\n" + 
		"7376;Landolt Fridolin;1956;Z�rich;03:15:18.2;\n" + 
		"7377;Meier Anita;1983;Z�rich;04:12:26.0;\n" + 
		"7379;Bleiker Rolf;1966;Z�rich;03:21:31.4;\n" + 
		"7380;Fontolliet Daniel;1949;Z�rich;03:55:58.9;\n" + 
		"7381;Foletti Anita;1977;Z�rich;03:51:07.8;\n" + 
		"7382;Denier Claudia;1986;Urtenen-Sch�nb�hl;04:05:17.5;\n" + 
		"7383;Fuchs Ruth;1968;Uster;04:28:01.9;\n" + 
		"7384;Studer Larissa;1993;Inwil;04:07:31.6;\n" + 
		"7385;Fl�ckiger Reto;1971;Sch�pfen;03:42:29.2;\n" + 
		"7386;Egli Susanne;1962;Uster;03:54:19.9;\n" + 
		"7388;Bachmann Roger;1969;Ottenbach;03:51:44.7;\n" + 
		"7389;Brunner Heiko;1966;Oberrieden;03:46:08.8;\n" + 
		"7390;Zemp Peter;1973;Regensdorf;03:51:09.1;\n" + 
		"7391;Bachmann Ruedi;1968;Uster;03:22:08.6;\n" + 
		"7392;Camenzind Andr�;1975;Kilchberg ZH;02:54:12.8;\n" + 
		"7393;Steiner Sarah;1982;Z�rich;03:34:59.1;\n" + 
		"7394;Walter Urs;1966;Lindau;03:28:45.0;\n" + 
		"7395;Curiger Andreas;1964;Buchs ZH;03:08:36.7;\n" + 
		"7396;Romaniuc Marcelo Rober;1971;Horgen;04:07:36.4;\n" + 
		"7397;Fehr Jessica;1985;Wetzikon ZH;03:30:09.2;\n" + 
		"7398;Jakob Barbara;1981;Rheinau;03:42:04.4;\n" + 
		"7399;Jakob Barbara;1981;Rheinau;04:00:14.3;\n" + 
		"7400;Casali Daniela;1967;Hittnau;03:54:45.6;\n" + 
		"7401;Casali Fulvio;1965;Hittnau;03:46:58.7;\n" + 
		"7402;Felger Martin;1970;Samstagern;03:38:26.5;\n" + 
		"7403;Z�rcher Toni;1963;W�denswil;03:32:47.5;\n" + 
		"7404;Flachsmann Stefan;1965;Gockhausen;03:03:28.0;\n" + 
		"7405;Weiersm�ller Jacquelin;1963;Kilchberg ZH;04:07:45.3;\n" + 
		"7406;Weiersm�ller Jacquelin;1963;Kilchberg ZH;04:06:21.6;\n" + 
		"7407;Weiersm�ller Jacquelin;1963;Kilchberg ZH;04:02:38.3;\n" + 
		"7408;Weiersm�ller Jacquelin;1963;Kilchberg ZH;04:27:12.0;\n" + 
		"7410;Willi Barbara;1982;Z�rich;03:20:14.4;\n" + 
		"7411;Auf der Mauer Raphael;1980;Aarau;02:43:58.0;\n" + 
		"7412;Kutej Stefan;1968;Uitikon Waldegg;03:27:40.5;\n" + 
		"7413;Cappiello Mauro;1967;Z�rich;03:28:20.4;\n" + 
		"7414;Tatalias Melina;1982;Zollikon;03:41:37.0;\n" + 
		"7415;Sherlock Cushla;1986;Z�rich;03:41:14.2;\n" + 
		"7416;Benhauresch Abdel;1966;Rotkreuz;03:27:43.6;\n" + 
		"7417;Pircher Daniel;1975;M�riken AG;03:54:15.9;\n" + 
		"7418;Sasso Angela;1975;Z�rich;03:46:20.3;\n" + 
		"7419;Meyer Bernhard;1956;Hunzenschwil;03:13:50.2;\n" + 
		"7420;Olson Garrett;1979;Z�rich;03:36:52.4;\n" + 
		"7421;K�nzle Doris;1971;Horgen;03:39:37.1;\n" + 
		"7422;Knauer Anne-Juliane;1978;Z�rich;03:25:26.0;\n" + 
		"7423;Schleifer Judith;1980;Z�rich;03:57:50.6;\n" + 
		"7424;Goessler Franziska;1966;Uitikon Waldegg;03:43:50.0;\n" + 
		"7425;Beeler Etienne;1987;Wallisellen;03:27:16.0;\n" + 
		"7426;Wagner Mario;1990;Z�rich;03:27:13.1;\n" + 
		"7427;Niklaus Christin;1978;Z�rich;03:41:38.2;\n" + 
		"7429;Birkeland Ina;1980;Z�rich;03:55:35.1;\n" + 
		"7430;Adelmann Horst;1964;Thalwil;03:41:01.5;\n" + 
		"7431;Sommer Martin;1983;Z�rich;03:55:51.4;\n" + 
		"7432;Eltgen Johannes;1985;Z�rich;03:19:10.5;\n" + 
		"7433;J�rg Silvana;1966;Kloten;03:42:14.0;\n" + 
		"7434;Baumann Thomas;1981;Z�rich;03:47:21.1;\n" + 
		"7435;Ulrich Barbara;1962;Z�rich;03:41:15.5;\n" + 
		"7436;Volz Andreas;1974;Z�rich;03:34:37.7;\n" + 
		"7437;Britschgi Dani;1977;Meierskappel;03:51:54.0;\n" + 
		"7438;Fleetwood Rahel;1980;Adliswil;03:40:22.3;\n" + 
		"7439;Goulbourne Jane;1968;Z�rich;04:06:30.0;\n" + 
		"7440;Pl�ss Samuel;1987;Z�rich;03:22:32.4;\n" + 
		"7441;Fotheringham Jilly;1965;Thalwil;04:39:27.5;\n" + 
		"7442;Wirz Peter;1950;Z�rich;03:05:58.8;\n" + 
		"7443;Hall Terry;1978;Z�rich;03:25:45.6;\n" + 
		"7444;Wintsch Hanna;1954;Z�rich;03:52:58.5;\n" + 
		"7445;G�tz Thomas;1972;Gockhausen;03:14:35.0;\n" + 
		"7446;G�tz Thomas;1972;Gockhausen;03:10:48.9;\n" + 
		"7447;Krampf Eckhard;1973;Z�rich;04:18:50.5;\n" + 
		"7448;Akpinar Hakan;1968;W�renlos;03:04:17.3;\n" + 
		"7449;Bourquin Philippe;1969;Geroldswil;03:41:35.5;\n" + 
		"7450;Bley Petra;1981;Z�rich;03:44:29.2;\n" + 
		"7451;Landolt Thomas;1967;Baar;03:18:15.3;\n" + 
		"7452;Thoma Rolf;1954;Langnau am Albis;03:11:29.2;\n" + 
		"7453;Dickenmann Stefan;1981;Frauenfeld;03:09:23.3;\n" + 
		"7454;Lehner Christoph;1986;Arbon;03:37:26.4;\n" + 
		"7455;Marxer Ruth;1968;Oberengstringen;04:12:30.2;\n" + 
		"7456;Koch Gisela;1974;Schwerzenbach;04:00:22.9;\n" + 
		"7457;Hiestand Steve;1984;W�denswil;04:09:43.0;\n" + 
		"7458;Maggiulli Ivan;1970;Volketswil;04:22:05.4;\n" + 
		"7459;Wu Daye;1979;Z�rich;03:43:45.0;\n" + 
		"7460;Wantz Nadine;1985;Z�rich;03:37:12.6;\n" + 
		"7461;M�ller Rolf;1968;Zeiningen;03:34:40.7;\n" + 
		"7462;Locher Beatrice;1963;Bubikon;03:25:04.9;\n" + 
		"7463;Cevik Selim;1980;Z�rich;03:40:55.8;\n" + 
		"7464;Schulz Bianca;1977;K�snacht ZH;03:30:38.0;\n" + 
		"7465;von Aesch Christoph;1971;Langnau am Albis;03:07:51.5;\n" + 
		"7466;Borner Laura;1990;Adliswil;03:19:52.4;\n" + 
		"7467;Koch Gustav;1949;Geroldswil;03:21:28.8;\n" + 
		"7468;Lendenmann Tobias;1987;Z�rich;03:37:11.0;\n" + 
		"7469;Berger Verena;1984;W�denswil;03:36:21.3;\n" + 
		"7470;Berger Verena;1984;W�denswil;03:31:16.4;\n" + 
		"7471;Berger Verena;1984;W�denswil;03:35:27.7;\n" + 
		"7472;Betschart Markus;1975;Z�rich;03:27:50.5;\n" + 
		"7473;Feroce Adrian;1970;Aathal-Seegr�ben;02:59:01.1;\n" + 
		"7474;Meier Thomas;1971;D�rnten;03:02:31.4;\n" + 
		"7475;M�ller Lothar;1964;Uetikon am See;03:19:58.5;\n" + 
		"7476;B�ni Ralf;1985;D�bendorf;03:20:43.9;\n" + 
		"7477;Koller Urs;1965;M�nnedorf;03:23:11.9;\n" + 
		"7478;Br�ndl Michael;1989;St�fa;03:46:03.5;\n" + 
		"7479;Wicki Robin;1975;Henggart;03:10:14.0;\n" + 
		"7480;Fisler Guido;1977;D�bendorf;04:16:11.0;\n" + 
		"7481;Bonato Dario;1965;Uster;04:00:03.7;\n" + 
		"7482;M�ller Matthias;1972;Winterthur;03:49:18.0;\n" + 
		"7483;Balz Rene;1966;Jona;03:18:02.0;\n" + 
		"7484;Geiger Dominik;1991;W�denswil;04:10:40.8;\n" + 
		"7485;Werder Roland;1954;Fehraltorf;03:35:59.1;\n" + 
		"7486;Haldemann Peter;1972;Volketswil;03:47:50.5;\n" + 
		"7487;Peterhans Renato;1985;Uster;03:50:15.9;\n" + 
		"7488;Heusser Daniel;1964;Hinwil;03:32:16.0;\n" + 
		"7489;Meuli Barbara;1979;Kloten;04:15:41.5;\n" + 
		"7490;Abplanalp Beat;1966;Obfelden;02:56:18.8;\n" + 
		"7491;Hoogerwerf Erik;1970;Richterswil;03:20:51.9;\n" + 
		"7492;Feurer Olivia;1987;Kloten;03:32:15.5;\n" + 
		"7493;Lange Otto;1962;Richterswil;03:37:58.9;\n" + 
		"7494;De Lemos Antonio;1974;D�bendorf;04:10:09.7;\n" + 
		"7495;Seematter Marc;1979;Horgen;03:02:33.2;\n" + 
		"7496;B�hlmann Sandra;1989;Herrliberg;04:00:50.0;\n" + 
		"7497;Benz Fabienne;1992;Erlenbach ZH;04:00:49.9;\n" + 
		"7498;Huber Paul;1957;Wald ZH;03:40:27.0;\n" + 
		"7499;Pilz Michelle M.;1967;Oberhasli;03:56:20.5;\n" + 
		"7500;Walser Thomas;1973;Gossau ZH;03:40:42.7;\n" + 
		"7501;Senn Monika;1971;Z�rich;03:40:59.4;\n" + 
		"7502;Denneberg J�rg;1949;Herrliberg;03:55:59.1;\n" + 
		"7503;Lutz Stephan;1985;Zwillikon;03:12:00.6;\n" + 
		"7504;Steiner Melvin;1975;Z�rich;03:59:26.5;\n" + 
		"7505;Jetter Patrick;1975;Opfikon;03:39:07.8;\n" + 
		"7506;Isler Dominik;1974;Z�rich;03:33:58.7;\n" + 
		"7507;Kaufmann Ursula;1976;Affoltern am Albi;04:14:10.7;\n" + 
		"7508;Reimann Olivia;1977;Z�rich;03:41:57.2;\n" + 
		"7509;Ziesack Myriam;1974;Z�rich;03:44:39.6;\n" + 
		"7510;Moser-Hausammann Brigi;1966;M�nnedorf;03:56:57.8;\n" + 
		"7511;Moser-Hausammann Brigi;1966;M�nnedorf;03:56:57.7;\n" + 
		"7512;Manz Hansruedi;1958;Z�rich;03:40:15.9;\n" + 
		"7513;Manz Hansruedi;1958;Z�rich;03:41:44.7;\n" + 
		"7514;Berli Beatrice;1950;Hausen am Albis;04:01:07.5;\n" + 
		"7515;Weiler Walter;1969;Walchwil;03:05:54.9;\n" + 
		"7516;Bos Heleen;1968;Uhwiesen;04:43:34.3;\n" + 
		"7517;Hoidn Anuschka;1980;Z�rich;03:55:28.0;\n" + 
		"7519;Schroeder Bernd;1966;Z�rich;03:26:23.5;\n" + 
		"7520;Barlow Mike;1965;Watt;03:17:44.7;\n" + 
		"7521;M�ller Philippe;1986;Seuzach;03:17:20.1;\n" + 
		"7522;Grob Gabriela;1964;Unterengstringen;03:34:51.3;\n" + 
		"7523;Bosshardt Felix;1961;Kloten;03:33:12.2;\n" + 
		"7524;B�hrer Roger;1969;Dinhard;03:55:46.8;\n" + 
		"7526;Pletscher Thomas;1954;Benglen;03:29:04.7;\n" + 
		"7527;R�ttimann Erhard;1976;Langnau am Albis;03:13:11.7;\n" + 
		"7528;Janik Evelyn;1961;Niederteufen;03:09:22.8;\n" + 
		"7529;Huber Peter;1967;Z�rich;03:35:41.4;\n" + 
		"7530;Federspiel Heike;1967;M�nnedorf;03:44:35.7;\n" + 
		"7531;M�ller Patrick;1969;W�denswil;03:06:35.9;\n" + 
		"7532;Karrer Dominique;1984;Wetzikon ZH;03:38:35.0;\n" + 
		"7533;B�hrer Roger;1969;Dinhard;03:47:50.4;\n" + 
		"7534;Sch�nb�chler Pascal;1983;Affoltern am Albi;04:12:22.4;\n" + 
		"7535;K�gel Harald;1959;W�denswil;03:26:37.7;\n" + 
		"7536;Huber Nicolas;1985;Z�rich;03:53:55.4;\n" + 
		"7537;Utz Patrick;1968;Langnau am Albis;03:29:23.6;\n" + 
		"7538;Ricardoch Ag;1979;Zug;03:54:22.7;\n" + 
		"7539;Ricardoch Ag;1979;Zug;03:39:43.7;\n" + 
		"7540;Luise Ivo;1971;D�bendorf;03:24:29.5;\n" + 
		"7541;Enz Daniel;1985;Bassersdorf;03:38:51.4;\n" + 
		"7542;Wiederkehr Mirjam;1980;Eriswil;03:33:14.0;\n" + 
		"7543;Ricardoch Ag;1979;Zug;03:42:17.8;\n" + 
		"7544;Ricardoch Ag;1979;Zug;04:04:55.3;\n" + 
		"7545;J�ggi Jean-Pierre;1954;La Chaux-de-Fonds;04:09:59.3;\n" + 
		"7546;Habermacher Claudia;1969;Zug;03:21:07.0;\n" + 
		"7547;Rey Bruno;1969;Zollikerberg;04:04:48.9;\n" + 
		"7548;Krismer Saskia;1962;Birmensdorf ZH;03:44:54.0;\n" + 
		"7549;Greuel Wanja;1977;Z�rich;03:17:44.7;\n" + 
		"7550;Weibel Martina;1983;Basel;04:02:34.4;\n" + 
		"7551;Hofmann Markus;1974;Uster;03:20:40.2;\n" + 
		"7552;Cathrein Rene;1960;Gr�t (Gossau ZH);03:39:27.6;\n" + 
		"7553;Cathrein Rene;1960;Gr�t (Gossau ZH);03:28:22.3;\n" + 
		"7554;Badertscher J�rg;1968;Uster;03:12:07.7;\n" + 
		"7555;Hassler Brigitte;1958;Z�rich;04:09:54.8;\n" + 
		"7556;Gisler Sybille;1988;Altdorf UR;03:24:08.0;\n" + 
		"7557;Br�m Corina;1990;Otelfingen;03:24:43.0;\n" + 
		"7558;Hinder Christine;1965;Kaltbrunn;03:52:37.9;\n" + 
		"7559;Buner Sacha;1980;Gutenswil;03:23:47.2;\n" + 
		"7560;Illi Liselotte;1950;Bassersdorf;03:28:04.8;\n" + 
		"7561;Gasser Ronny;1984;Spreitenbach;03:03:53.1;\n" + 
		"7562;Schefer Stefan;1978;Ebmatingen;02:59:20.5;\n" + 
		"7563;Carl Anna Barbla;1984;Scuol;03:43:24.5;\n" + 
		"7564;Hottinger Nicole;1967;Volketswil;03:21:51.0;\n" + 
		"7565;Rechsteiner Simone;1975;Einsiedeln;03:28:45.5;\n" + 
		"7566;Rutz Miriam;1977;Z�rich;03:14:39.8;\n" + 
		"7567;Umbricht Sarah;1985;Lohn-Ammannsegg;03:15:55.8;\n" + 
		"7568;Gonzalez Arza Jose;1984;Z�rich;04:28:07.1;\n" + 
		"7570;Tedeschi Alfonso;1981;Z�rich;03:28:39.8;\n" + 
		"7571;Krebs Michaela;1982;Oberglatt ZH;03:31:25.8;\n" + 
		"7572;Willborn Alexander;1983;Herrliberg;03:30:52.6;\n" + 
		"7573;Niederbacher Martin;1968;Wetzikon ZH;04:10:14.3;\n" + 
		"7574;Langhard Markus;1979;Winterthur;03:34:16.7;\n" + 
		"7575;Blatter Samuel;1990;Schweiz;03:20:59.4;\n" + 
		"7576;Kwak Grace;1977;Adliswil;03:47:04.2;\n" + 
		"7577;M�ri Michaela;1973;Z�rich;03:35:15.5;\n" + 
		"7578;Seuring Carolin;1983;Z�rich;03:45:02.9;\n" + 
		"7579;B�r Eva;1984;Z�rich;03:48:23.5;\n" + 
		"7580;Meyer Nina;1985;Z�rich;04:32:29.3;\n" + 
		"7581;Zellweger Monique;1968;Goldach;03:25:58.5;\n" + 
		"7582;Sutter Samuel;1980;Schlieren;03:30:12.4;\n" + 
		"7583;Saar Rachel-Lee;1970;Adliswil;03:52:13.9;\n" + 
		"7584;Morf Celine;1979;W�denswil;03:29:13.6;\n" + 
		"7585;Naito Shinichi;1976;Versoix;03:24:00.8;\n" + 
		"7586;De Boni Oliver;1974;Horgen;03:30:53.5;\n" + 
		"7587;Keller Max;1948;Urdorf;03:29:53.3;\n" + 
		"7588;Pinchiroli Ettore;1982;Z�rich;03:14:14.3;\n" + 
		"7589;Peter Peter;1966;M�nnedorf;02:30:28.8;\n" + 
		"7590;Ziegler Paul;1944;Galgenen;02:29:58.0;\n" + 
		"7591;Sch�rer Sandra;1976;Z�rich;03:36:52.0;\n" + 
		"7592;Kessler Hannes;1981;Rapperswil SG;03:22:18.0;\n" + 
		"7593;Fraczak Marcin;1980;Glattpark (Opfiko;03:43:49.7;\n" + 
		"7594;R�egg Roger;1965;Winterthur;03:32:10.6;\n" + 
		"7595;Tschudi Mich�le;1978;Ottikon bei Kempt;03:12:09.2;\n" + 
		"7596;B�cher Rico;1951;Tann;03:34:27.7;\n" + 
		"7597;Hottarek Tatjana;1995;Oberrieden;03:58:52.1;\n" + 
		"7598;Blatter Samuel;1990;Schweiz;03:16:14.9;\n" + 
		"7599;Bingesser Barbara;1972;Esslingen;03:24:11.3;\n" + 
		"7600;Vaia Karin;1985;Z�rich;03:53:39.9;\n" + 
		"7601;Gellert Alexandre;1979;Z�rich;03:35:09.7;\n" + 
		"7602;Sagolla Markus;1976;Z�rich;03:41:17.9;\n" + 
		"7603;Bisgaard Jane;1978;Z�rich;04:00:09.4;\n" + 
		"7604;Beurret Hermes;1991;Biel-Benken BL;03:08:37.5;\n" + 
		"7605;Harder Daniel;1990;Uster;03:29:57.9;\n" + 
		"7606;Harder Daniel;1990;Uster;03:30:32.1;\n" + 
		"7607;Kugler Raphael;1975;Z�rich;03:13:30.7;\n" + 
		"7608;Ploskonka Elmar;1981;Berikon;03:39:46.1;\n" + 
		"7609;Kammerer Dorothee;1981;Aarau;03:26:09.6;\n" + 
		"7610;Kammerer Dorothee;1981;Aarau;03:02:54.5;\n" + 
		"7611;Koch Rachelle;1986;Embrach;03:44:11.7;\n" + 
		"7612;Bolliger Aino;1973;Langnau am Albis;03:02:42.2;\n" + 
		"7613;Bolliger Aino;1973;Langnau am Albis;03:55:59.6;\n" + 
		"7614;Guggisberg Michael;1974;Jegenstorf;03:03:11.1;\n" + 
		"7615;Winter Beatrix;1971;Z�rich;04:39:01.4;\n" + 
		"7616;Vincenz Claudia;1974;Hirzel;03:30:31.1;\n" + 
		"7617;Gy�rvari Lars;1980;Basel;03:50:30.3;\n" + 
		"7618;K�nzle Stefan;1979;Uster;03:25:50.0;\n" + 
		"7619;D�tting Andr�;1981;Altendorf;03:42:42.2;\n" + 
		"7620;Mondini Mich�le;1972;Z�rich;04:09:20.5;\n" + 
		"7621;Rohner Catherine;1981;Winterthur;03:29:21.0;\n" + 
		"7622;Ammann Beat;1965;Z�rich;02:37:36.2;\n" + 
		"7623;Kummrow Valerie;1990;Volketswil;03:36:06.5;\n" + 
		"7624;Graf Peter;1966;Z�rich;03:44:18.9;\n" + 
		"7625;Graf Peter;1966;Z�rich;02:42:09.8;\n" + 
		"7626;Winiger Benjamin;1976;Hombrechtikon;03:50:28.6;\n" + 
		"7627;L�thi Markus;1974;Winterthur;03:24:57.6;\n" + 
		"7628;Blatter Samuel;1990;Schweiz;03:33:51.6;\n" + 
		"7629;Gaillard Stephane;1982;Lenzburg;03:33:35.1;\n" + 
		"7630;R�egg Marco;1961;Baar;03:23:19.8;\n" + 
		"7631;R�ttimann Urs;1974;Z�rich;03:07:43.9;\n" + 
		"7633;Koller Markus;1973;Z�rich;03:04:41.8;\n" + 
		"7634;Flury Ernesto;1961;Berikon;03:16:30.0;\n" + 
		"7635;Specker Marco;1976;Z�rich;03:09:45.6;\n" + 
		"7636;Niklaus Tina;1973;Z�rich;03:37:33.4;\n" + 
		"7637;Widmer Nathalie;1990;D�bendorf;03:49:31.9;\n" + 
		"7638;Gr�bli Susanne;1968;Zollikerberg;03:34:44.0;\n" + 
		"7639;R�timann Thomas;1978;W�renlos;03:26:25.4;\n" + 
		"7640;Graf Beatrice;1965;Uster;03:31:13.2;\n" + 
		"7641;Steiner Elisabeth;1950;Kilchberg ZH;03:45:54.0;\n" + 
		"7642;Croset Marcel;1974;Oberurnen;03:25:34.8;\n" + 
		"7643;Scherrer Rainer;1993;Z�rich;03:00:26.2;\n" + 
		"7644;Kuhn Gabriela;1980;Wettingen;03:36:44.4;\n" + 
		"7645;Bernold Roman;1980;Z�rich;03:25:29.2;\n" + 
		"7646;Insley Anne;1967;Z�rich;04:01:04.7;\n" + 
		"7647;Wirth Jessy;1981;Z�rich;03:17:09.9;\n" + 
		"7648;Soldo Lovro;1987;Meilen;03:56:04.1;\n" + 
		"7649;Mazziotta Raffaele;1980;Wetzikon ZH;03:52:18.5;\n" + 
		"7650;Lacharite Claudie;1981;Z�rich;03:51:29.9;\n" + 
		"7651;Manz Alexander;1980;Z�rich;04:14:01.7;\n" + 
		"7652;Staub J�rg;1960;Gockhausen;04:12:48.2;\n" + 
		"7653;Petrakis Stefanos;1979;Z�rich;03:37:33.9;\n" + 
		"7654;Gerber Mark;1970;Z�rich;03:15:01.1;\n" + 
		"7655;Gerber Mark;1970;Z�rich;03:17:27.8;\n" + 
		"7656;Franzi Roger;1973;Uster;03:27:52.3;\n" + 
		"7657;Schmid Stefanie;1963;Biel-Benken BL;03:36:29.5;\n" + 
		"7658;Mehta Sunil;1974;Baden;04:00:20.4;\n" + 
		"7660;Spillmann Roger;1979;Z�rich;04:05:07.3;\n" + 
		"7661;Bolli Andreas;1981;Z�rich;04:02:04.2;\n" + 
		"7662;Suter Sabrina;1982;Z�rich;03:52:01.0;\n" + 
		"7663;Meier Helen;1989;R�schlikon;03:57:12.2;\n";
	
	public static void main(String[] args) {
		try {
			System.out.println(new ServerA2().execute(rangliste));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String execute(String command) throws Exception {
		List<Competitor> list = CompetitorServer.parseRangliste(command);
		list.sort(CompetitorServer.COMPARATOR_TIME);
		
		TreeNode<Competitor> root = new TreeNode<Competitor>();
		doit(root, list);

		StringBuilder sb = new StringBuilder();
		TreeTraversal<Competitor> tt = new TreeTraversal<Competitor>(root);
		tt.inorder((obj) -> sb.append(obj.toString()).append("\n"));
	
		return sb.toString();
	}
	
	private void doit(TreeNode<Competitor> root, List<Competitor> sortedData) {
		int sortedDataSize = sortedData.size();
		int sortedDataIndexMin = 0;
		int sortedDataIndexMax = sortedDataSize;
		
		int sortedDataIndexMiddle = (int) ((double) (sortedDataSize - 1) / 2.0);
		
		root.element = sortedData.get(sortedDataIndexMiddle);
		
		List<Competitor> leftData = sortedData.subList(sortedDataIndexMin, sortedDataIndexMiddle);
		if (!leftData.isEmpty()) {
			root.left = new TreeNode<>();
			doit(root.left, leftData);
		}
		
		List<Competitor> rightData = sortedData.subList(sortedDataIndexMiddle + 1, sortedDataIndexMax);
		if (!rightData.isEmpty()) {
			root.right = new TreeNode<>();
			doit(root.right, rightData);
		}
	}
}
