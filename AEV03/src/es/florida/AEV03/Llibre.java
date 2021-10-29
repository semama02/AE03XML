package es.florida.AEV03;

public class Llibre {
		
	private String identificador;
	private String titol;
	private String autor;
	private String any_publicacio;
	private String editoral;
	private String pagines;

	//	M�tode: Llibre
	//	Descripci�: creem els atributs d'un llibre
	//	Parametres d'entrada: identificador, titol, autor, any_publicacio, editorial, pagines
	//	Parametres d'eixida: ning�n
	Llibre (String identificador, String titol, String autor, String any_publicacio, String editorial, String pagines){
		this.identificador = identificador;
		this.titol = titol;
		this.autor = autor;
		this.any_publicacio = any_publicacio;
		this.editoral = editorial;
		this.pagines = pagines;
	}

	//	M�tode: getIdentificador
	//	Descripci�: creem el getter
	//	Parametres d'entrada: ning�n
	//	Parametres d'eixida: identificador
	public String getIdentificador() {
		return identificador;
	}

	//	M�tode: setIdentificador
	//	Descripci�: creem el setter
	//	Parametres d'entrada: identificador
	//	Parametres d'eixida: ning�n
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	//	M�tode: getTitol
	//	Descripci�: creem el getter
	//	Parametres d'entrada: ning�n
	//	Parametres d'eixida: titol
	public String getTitol() {
		return titol;
	}

	//	M�tode: setTitol
	//	Descripci�: creem el setter
	//	Parametres d'entrada: titol
	//	Parametres d'eixida: ning�n
	public void setTitol(String titol) {
		this.titol = titol;
	}

	//	M�tode: getAutor
	//	Descripci�: creem el getter
	//	Parametres d'entrada: ning�n
	//	Parametres d'eixida: autor
	public String getAutor() {
		return autor;
	}

	//	M�tode: setAutor
	//	Descripci�: creem el setter
	//	Parametres d'entrada: autor
	//	Parametres d'eixida: ning�n
	public void setAutor(String autor) {
		this.autor = autor;
	}

	//	M�tode: getAny_publicacio
	//	Descripci�: creem el getter
	//	Parametres d'entrada: ning�n
	//	Parametres d'eixida: any_publicacio
	public String getAny_publicacio() {
		return any_publicacio;
	}

	//	M�tode: setAny_publicacio
	//	Descripci�: creem el setter
	//	Parametres d'entrada: any_publicacio
	//	Parametres d'eixida: ning�n
	public void setAny_publicacio(String any_publicacio) {
		this.any_publicacio = any_publicacio;
	}

	//	M�tode: getEditoral
	//	Descripci�: creem el getter
	//	Parametres d'entrada: ning�n
	//	Parametres d'eixida: editoral
	public String getEditoral() {
		return editoral;
	}

	//	M�tode: setEditoral
	//	Descripci�: creem el setter
	//	Parametres d'entrada: editoral
	//	Parametres d'eixida: ning�n
	public void setEditoral(String editoral) {
		this.editoral = editoral;
	}

	//	M�tode: getPagines
	//	Descripci�: creem el getter
	//	Parametres d'entrada: ning�n
	//	Parametres d'eixida: pagines
	public String getPagines() {
		return pagines;
	}

	//	M�tode: setPagines
	//	Descripci�: creem el setter
	//	Parametres d'entrada: pagines
	//	Parametres d'eixida: ning�n
	public void setPagines(String pagines) {
		this.pagines = pagines;
	}
	
	
}
