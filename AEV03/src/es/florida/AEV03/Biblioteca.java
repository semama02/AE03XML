package es.florida.AEV03;

import java.util.ArrayList;
import java.util.Scanner;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.*;

public class Biblioteca {
	
	//	Métode: recuperarTots
	//	Descripció: posar en una llista tots els llibres del document xml
	//	Parametres d'entrada: ningún
	//	Parametres d'eixida: els llibres
	public static ArrayList<Llibre> recuperarTots(){
		ArrayList<Llibre> llibres = new ArrayList<Llibre>();
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document document = dBuilder.parse(new File("biblioteca.xml"));
			NodeList nodeList = document.getElementsByTagName("libro");
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
						Element eElement = (Element) node;
						String id = eElement.getAttribute("id");
						String titol = eElement.getElementsByTagName("titol").item(0).getTextContent();
						String autor = eElement.getElementsByTagName("autor").item(0).getTextContent();
						String any_Publicacio = eElement.getElementsByTagName("any_publicacio").item(0).getTextContent();
						String editorial = eElement.getElementsByTagName("editorial").item(0).getTextContent();
						String pagines = eElement.getElementsByTagName("pagines").item(0).getTextContent();
						llibres.add(new Llibre(id, titol, autor, any_Publicacio, editorial, pagines));
						
				}
			}
			} catch (Exception e) {
			e.printStackTrace();
			}
			return (llibres);
			}
	
	//	Métode: recuperarLlibre
	//	Descripció: mos torna un objecte llibre
	//	Parametres d'entrada: int identificador
	//	Parametres d'eixida: un llibre
	public static Llibre recuperarLlibre(int identificador) {
		Llibre llibreNou = null;
		ArrayList<Llibre>llista = recuperarTots();
		for (int i = 0; i < llista.size(); i++) {
			int pepe = Integer.parseInt(llista.get(i).getIdentificador());
			if (identificador == pepe) {
				llibreNou = llista.get(i);
			}
		}
		return llibreNou;
	}
	
	//	Métode: mostrarLlibre
	//	Descripció: mostra per pantalla un llibre
	//	Parametres d'entrada: un llibre
	//	Parametres d'eixida: atributs del llibre
	public static void mostrarLlibre(Llibre llibre) {
		System.out.println("ID " + llibre.getIdentificador());
		System.out.println("Titol " + llibre.getTitol());
		System.out.println("Autor " + llibre.getAutor());
		System.out.println("Any de publicacio " + llibre.getAny_publicacio());
		System.out.println("Editorial " + llibre.getEditoral());
		System.out.println("Pàgines " + llibre.getPagines());
	}
	
	//	Métode: writeXmlFile
	//	Descripció: crea o modifica un document xml
	//	Parametres d'entrada: Array amb els llibres
	//	Parametres d'eixida: ningún
	public static void writeXmlFile(ArrayList<Llibre> llibres) {
		try {
			DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
			DocumentBuilder build = dFact.newDocumentBuilder();
			Document doc = build.newDocument();
			Element raiz = doc.createElement("libros");
			doc.appendChild(raiz);
			for (Llibre can : llibres) {
				Element libro = doc.createElement("libro");
				String id = String.valueOf(can.getIdentificador());
				libro.setAttribute("id",id); raiz.appendChild(libro);
				Element titol = doc.createElement("titol");
				titol.appendChild(doc.createTextNode(String.valueOf(can.getTitol())));
				libro.appendChild(titol);
				Element autor = doc.createElement("autor");
				autor.appendChild(doc.createTextNode(String.valueOf(can.getAutor())));
				libro.appendChild(autor);
				Element any_publicacio = doc.createElement("any_publicacio");
				any_publicacio.appendChild(doc.createTextNode(String.valueOf(can.getAny_publicacio())));
				libro.appendChild(any_publicacio);
				Element editorial = doc.createElement("editorial");
				editorial.appendChild(doc.createTextNode(String.valueOf(can.getEditoral())));
				libro.appendChild(editorial);
				Element pagines = doc.createElement("pagines");
				pagines.appendChild(doc.createTextNode(String.valueOf(can.getEditoral())));
				libro.appendChild(pagines);
			}
			TransformerFactory tranFactory = TransformerFactory.newInstance(); // Crear serializador
			Transformer aTransformer = tranFactory.newTransformer();
			aTransformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1"); // Darle formato al documento
			aTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			aTransformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(doc);
			try {
				FileWriter fw = new FileWriter("biblioteca.xml"); // Definir el nombre del fichero y guardar
				StreamResult result = new StreamResult(fw);
				aTransformer.transform(source, result);
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			} catch (TransformerException ex) {
			System.out.println("Error escribiendo el documento");
			} catch (ParserConfigurationException ex) {
			System.out.println("Error construyendo el documento");
			}
	}
	
	//	Métode: crearLlibre
	//	Descripció: a partir de la llista creada anyadim un llibre nou
	//	Parametres d'entrada: un llibre
	//	Parametres d'eixida: el identificador del llibre
	public static int crearLlibre(Llibre llibre) {
		ArrayList<Llibre>llista = recuperarTots();
		llista.add(llibre);
		writeXmlFile(llista);
		return Integer.parseInt(llibre.getIdentificador());
	}
	
	//	Métode: actualitzaLlibre
	//	Descripció: a partir de la llista modifiquem un llibre
	//	Parametres d'entrada: identificador
	//	Parametres d'eixida: ningún
	public static void actualitzaLlibre(int identificador) {
		ArrayList<Llibre>llista = recuperarTots();
		Scanner in = new Scanner(System.in);
		for (Llibre llibre : llista) {
			if (identificador == Integer.parseInt(llibre.getIdentificador())) {
				System.out.println("Dime el ID: ");
				llista.get(identificador-1).setIdentificador(in.nextLine());
				
				System.out.println("Dime el titol: ");
				llista.get(identificador-1).setTitol(in.nextLine());
				
				System.out.println("Dime el autor: ");
				llista.get(identificador-1).setAutor(in.nextLine());
				
				System.out.println("Dime el any de publicacio: ");
				llista.get(identificador-1).setAutor(in.nextLine());

				System.out.println("Dime la editorial: ");
				llista.get(identificador-1).setEditoral(in.nextLine());

				System.out.println("Dime el numero de pagines: ");
				llista.get(identificador-1).setPagines(in.nextLine());
				
				writeXmlFile(llista);
			}
		}
	}
	
	//	Métode: borrarLlibre
	//	Descripció: a partir de la llista borrem un llibre
	//	Parametres d'entrada: identificador
	//	Parametres d'eixida: ningún
	public static void borrarLlibre(int identificador) {
		ArrayList<Llibre>llista = recuperarTots();
		llista.remove(identificador-1);
		writeXmlFile(llista);
		System.out.println("Se ha borrado");
	}
	
	//	Métode: main
	//	Descripció: utilitzem un "menú" per a vore que vol fer l'usuari
	//	Parametres d'entrada: ningún
	//	Parametres d'eixida: ningún
	public static void main(String[] args) {
		System.out.println("1. Mostrar tots els títols de la biblioteca");
		System.out.println("2. Mostrar informació detallada d'un llibre");
		System.out.println("3. Crear nou llibre");
		System.out.println("4. Actualitzar llibre");
		System.out.println("5. Borrar llibre");
		System.out.println("6. Tanca la biblioteca");
		Scanner in = new Scanner(System.in);
		String opcion = in.nextLine();
		
		switch(opcion) {
			case "1":
				for (int i = 0; i < recuperarTots().size(); i++) {
					System.out.print("Identificador " + recuperarTots().get(i).getIdentificador() + ": ");
					System.out.println(recuperarTots().get(i).getTitol());
				}
			case "2":
				in = new Scanner(System.in);
				String opcion2 = in.nextLine();
				int opcion3 = Integer.parseInt(opcion2); 
				if (recuperarLlibre(opcion3) == null) {
					System.out.println("ERROR");
				}else {
					System.out.println(recuperarLlibre(opcion3).getTitol());
				}
				
			case "3":
				in = new Scanner(System.in);
				System.out.println("Dime el ID: ");
				String id = in.nextLine();
				System.out.println("Dime el titol: ");
				String titol = in.nextLine();
				System.out.println("Dime el autor: ");
				String autor = in.nextLine();
				System.out.println("Dime el any de publicacio: ");
				String any_publicacio = in.nextLine();
				System.out.println("Dime la editorial: ");
				String editorial = in.nextLine();
				System.out.println("Dime el numero de pagines: ");
				String pagines = in.nextLine();
				Llibre nouLlibre = new Llibre(id, titol, autor, any_publicacio, editorial, pagines);
				crearLlibre(nouLlibre);
				
			case "4":
				System.out.println("Dime el ID al que canviar: ");
				String idCanviar = in.nextLine();
				actualitzaLlibre(Integer.parseInt(idCanviar));
				
			case "5":
				System.out.println("Dime el ID a borrar: ");
				String idBorrar = in.nextLine();
				borrarLlibre(Integer.parseInt(idBorrar));
				
			case "6":
				System.exit(0);
		}
	}

}
