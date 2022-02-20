package ci.smilecheck.cc.helper.error;

public enum ErrorMessage {
	
	
	SUCCESS_CREATE("Création effectué avec succès "), 
	SUCCESS_UPDATE("Modification effectuée avec succès "),
	SUCCESS_UTILISATEUR_REINIT("Utilisateur reinitialisé avec succès (mot de passe par defaut) "), 
	SUCCESS_UTILISATEUR_SUPPRIMER("Suppression de l'utilisateur effectuée "), 
	SUCCES_DELETE("Désactivation effectuée avec succès"),  
	SUCCESS_UTILISATEUR_ACTIVER("Utilisateur réactivé"), 


	
	ERROR_SERVEUR_500("Erreur interne du serveur, veuillez réessayer ultérieurement "),
	
	ERROR_LOGIN("Mot de passe ou nom d'utilisateur incorrect "),
	ERROR_AGENCE_CODEAGENCE("Veuillez saisir un code agence correct "),
	ERROR_AGENCE_NOMAGENCE("Veuillez saisir un nom d'agence correct (entre 5 et 25 caractères) "),
	ERROR_BANQUE_NOT_FOUND("Veuillez sélectionner une banque correct "),
	

	
	ERROR_UTILISATEUR_EMAIL("L'Email de l'utilisateur est incorrecte (5-50 caractères) "), 
	ERROR_UTILISATEUR_NOM("Veuillez saisir un nom d'utilisateur correct "), 
	ERROR_UTILISATEUR_PRENOM("Veuillez renseignez correctement le champ prenom "), 
	ERROR_UTILISATEUR_MOTDEPASSE("Veuillez renseigner votre mot de passe (entre 7-16 caractères)"),
	ERROR_UTILISATEUR_MOTDEPASSECONF("Veuillez renseigner la confirmation du mot de passe "), 
	ERROR_UTILISATEUR_MOTDEPASSEDIFF("Le mot de passe saisi est différent de la confirmation "), 
	ERROR_UTILISATEUR_NOTEXIST("L'utilisateur choisi n'existe pas "), 
	
	ERROR_UTILISATEUR_LOGINMOTDEPASSINCORRECT("Le login ou le mot de passe est incorrect "), 
	ERROR_UTILISATEUR_DEFAULTPASSWORD("ADMIN"), 
	ERROR_CLIENT_NOMINVALIDE("Saisissez un nom correct (longueur nom <50)"), 
	ERROR_CLIENT_PRENOMINVALIDE("Saisissez un prénom correct "), 
	ERROR_MICROFINANCE_MICROFINANCENOTEXIST("La microfinance selectionnée est invalide"), 
	ERROR_MICROFINANCECOMPTE_MICROFINANCECOMPTENOTEXIST("Le compte bancaire de la microfinance selectionnée est invalide "),
	ERROR_MICROFINANCECOMPTE_MICROFINANCECOMPTENOTEXISTAGENCE("Aucune microfinance enregistrée"),

	ERROR_AGENCE_AGENCENOTEXISTFORBANQUE("Agence non valide pour la banque selectionnée"),  
	ERROR_CLIENTCOMPTE_CLIENTCOMPTEFULL("Impossible de creer un nouveau compte, le nombre de compte possible est atteint "), 
	ERROR_CLIENT_NUMEROCLIENTINVALIDE("Saisissez un numero client valide "),   
	ERROR_CLIENT_NUMEROCLIENT_INTROUVABLE("Numero client inexistant dans la base"),
	ERROR_CLIENT_NUMEROEXIST("Numéro client existant, veuillez saisir un numéro non enregistré "), 
	ERROR_CLIENT_STATUTINVALIDE("Le statut définit est invalide"), 
	ERROR_CLIENT_CLIENTINACTIFUPDATE("Impossible de modifier un client inactif"),  
	ERROR_CLIENT_ADRESSEINVALIDE("Veuillez saisir une adresse valide (3-250) caractères"), 
	ERROR_AGENCE_AGENCEINACTIFUPDATE("Impossible de modifier un client inactif"),
	ERROR_AGENCE_AGENCEINACTIF("L'agence selectionnée n'est est inactive. Veuillez selectionner une autre"),

	ERROR_COMPTE_COMPTEINACTIFUPDATE("Impossible de modifier un compte inactif"), 
	ERROR_CLIENTCOMPTE_CLIENTCOMPTENOTEXIST("Ce compte bancaire n'appartient à aucun client "),  
	ERROR_UTILISATEUR_EMAILALREADYUSE("L'email renseignée est déjà utilisée"),
	ERROR_UTILISATEUR_ACCOUNTBLOCKED("Ce compte utilisateur est verrouillé"), 
	
	ERROR_MICROFINANCECOMPTE_NOMGROUPE("Veuillez saisir un nom de groupe correct"), 
	ERROR_MICROFINANCECOMPTE_ADRESSE("Veuillez saisir une adresse correcte"), 
	ERROR_MICROFINANCECOMPTE_CODEGROUPE("Veuillez saisir un code de groupe correct"), 
	ERROR_MICROFINANCECOMPTE_EMAIL("Veuillez saisir une adresse email correcte"), 
	ERROR_MICROFINANCECOMPTE_TELEPHONE("Veuillez saisir un numéro de telephone valide"),  
	ERROR_MICROFINANCECOMPTE_COMPTEINVALIDE("Veuillez saisir un numéro de compte valide"), 
	ERROR_MICROFINANCECOMPTE_CLERIBINVALIDE("La clé RIB est invalide "), 
	ERROR_MICROFINANCECOMPTE_LONGUEURCLERIBINVALIDE("Longueur clé RIB invalide, <br/> la longueur autorisée est de deux chiffres"), 

	ERROR_MICROFINANCECOMPTE_NUMEROREGISTRE("Veuillez saisir un numéro de registre valide"),
	ERROR_MICROFINANCE_MICROFINANCENOTACTIF("La microfinance selectionnée n'est pas active, Veuillez selectionnée une autre"), 
	ERROR_MICROFINANCECOMPTE_INACTIF("Le compte selectionné est inactif"), 
	ERROR_MESSAGE_ERROR_CSV("Les informations fournies ne sont pas correct. "),
	ERROR_MESSAGE_ERROR_BANQ_AGENCE_CSV("Vérifiez la banque et/ou l'agence "),
	
	
	
	//SMILECHECK CUSTOMER CARE
	ERROR_CUSTOMER_NAME("Veuillez saisir une nom d'utilisateur correct (100 caractères maximum)"),
	ERROR_CUSTOMER_NAME_ALREADY_ASSIGN("Nom d'utilisateur deja attribué"),
	ERROR_CUSTOMER_BAD_LICENCE("Licence invalide"), 
	SUCCESS_CUSTOMER_LICENCE_ACTIVATION("Activation de la licence reussie"), 
	ERROR_CUSTOMER_ADRESS("Veuillez renseigener une  adresse valide");


	
	
	public final String label;

    private ErrorMessage(String label) {
        this.label = label;
    }
	
    
    @Override
    public String toString(){
        return label;
    }


	public static String ligneErrorMessage(ErrorMessage message,int ligne) {
		// TODO Auto-generated method stub
		return message.toString()+"<br/>Ligne erronée : ("+ligne+")" ;
	}


	
}
