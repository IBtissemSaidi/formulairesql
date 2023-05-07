package formulairemysql;

import java.io.Serializable;

public class Contact implements Serializable {
	private int id;
	private String nom;
	private String prenom;
	private String email;
	
	
 public Contact(int id,String nom,String prenom,String email) {
	 super();
	 this.id=id;
	 this.nom=nom;
	 this.prenom=prenom;
	 this.email=email;
 }
 
 /*public Contact() {
	 super(); 
 }*/
 
 public int getid(int id) {
	 return id;
 }
 
 public String getnom(String nom) {
	 return nom;
 }
 
 public String getprenom(String prenom) {
	 return nom;
 }
 public String getemail(String email) {
	 return email;
 }
 

 public void setid(int id) {
	 this.id=id;
 }
 
 public void setnom(String nom) {
	 this.nom=nom;
 }
 public void setprenom(String prenom) {
	 this.prenom=prenom;
 }
 
 public void setemail(String email) {
	 this.email=email;
 }
 
}
