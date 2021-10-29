package es.florida.AEV03;

public class Llibre {
		
	private String identificador;
	private String titol;
	private String autor;
	private String any_publicacio;
	private String editoral;
	private String pagines;

	//	Métode: Llibre
	//	Descripció: creem els atributs d'un llibre
	//	Parametres d'entrada: identificador, titol, autor, any_publicacio, editorial, pagines
	//	Parametres d'eixida: ningún
	Llibre (String identificador, String titol, String autor, String any_publicacio, String editorial, String pagines){
		this.identificador = identificador;
		this.titol = titol;
		this.autor = autor;
		this.any_publicacio = any_publicacio;
		this.editoral = editorial;
		this.pagines = pagines;
	}

	//	Métode: getIdentificador
	//	Descripció: creem el getter
	//	Parametres d'entrada: ningún
	//	Parametres d'eixida: identificador
	public String getIdentificador() {
		return identificador;
	}

	//	Métode: setIdentificador
	//	Descripció: creem el setter
	//	Parametres d'entrada: identificador
	//	Parametres d'eixida: ningún
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	//	Métode: getTitol
	//	Descripció: creem el getter
	//	Parametres d'entrada: ningún
	//	Parametres d'eixida: titol
	public String getTitol() {
		return titol;
	}

	//	Métode: setTitol
	//	Descripció: creem el setter
	//	Parametres d'entrada: titol
	//	Parametres d'eixida: ningún
	public void setTitol(String titol) {
		this.titol = titol;
	}

	//	Métode: getAutor
	//	Descripció: creem el getter
	//	Parametres d'entrada: ningún
	//	Parametres d'eixida: autor
	public String getAutor() {
		return autor;
	}

	//	Métode: setAutor
	//	Descripció: creem el setter
	//	Parametres d'entrada: autor
	//	Parametres d'eixida: ningún
	public void setAutor(String autor) {
		this.autor = autor;
	}

	//	Métode: getAny_publicacio
	//	Descripció: creem el getter
	//	Parametres d'entrada: ningún
	//	Parametres d'eixida: any_publicacio
	public String getAny_publicacio() {
		return any_publicacio;
	}

	//	Métode: setAny_publicacio
	//	Descripció: creem el setter
	//	Parametres d'entrada: any_publicacio
	//	Parametres d'eixida: ningún
	public void setAny_publicacio(String any_publicacio) {
		this.any_publicacio = any_publicacio;
	}

	//	Métode: getEditoral
	//	Descripció: creem el getter
	//	Parametres d'entrada: ningún
	//	Parametres d'eixida: editoral
	public String getEditoral() {
		return editoral;
	}

	//	Métode: setEditoral
	//	Descripció: creem el setter
	//	Parametres d'entrada: editoral
	//	Parametres d'eixida: ningún
	public void setEditoral(String editoral) {
		this.editoral = editoral;
	}

	//	Métode: getPagines
	//	Descripció: creem el getter
	//	Parametres d'entrada: ningún
	//	Parametres d'eixida: pagines
	public String getPagines() {
		return pagines;
	}

	//	Métode: setPagines
	//	Descripció: creem el setter
	//	Parametres d'entrada: pagines
	//	Parametres d'eixida: ningún
	public void setPagines(String pagines) {
		this.pagines = pagines;
	}
	
	
}
