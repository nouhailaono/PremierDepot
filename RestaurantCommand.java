// Interface Command
interface Command {
    void executer();
}

// Récepteurs
class ChefCuisinier {
    public void preparerPlat(String plat) {
        System.out.println("👨‍🍳 Le chef prépare : " + plat);
    }
}

class ResponsableBoissons {
    public void preparerBoisson(String boisson) {
        System.out.println("🥤 Le responsable des boissons prépare : " + boisson);
    }
}

class ResponsableDemandesSpeciales {
    public void traiterDemande(String demande) {
        System.out.println("🍽️ Demande spéciale en cours : " + demande);
    }
}

// Commandes concrètes
class CommandePlat implements Command {
    private ChefCuisinier chef;
    private String plat;

    public CommandePlat(ChefCuisinier chef, String plat) {
        this.chef = chef;
        this.plat = plat;
    }

    @Override
    public void executer() {
        chef.preparerPlat(plat);
    }
}

class CommandeBoisson implements Command {
    private ResponsableBoissons responsable;
    private String boisson;

    public CommandeBoisson(ResponsableBoissons responsable, String boisson) {
        this.responsable = responsable;
        this.boisson = boisson;
    }

    @Override
    public void executer() {
        responsable.preparerBoisson(boisson);
    }
}

class CommandeSpeciale implements Command {
    private ResponsableDemandesSpeciales responsable;
    private String demande;

    public CommandeSpeciale(ResponsableDemandesSpeciales responsable, String demande) {
        this.responsable = responsable;
        this.demande = demande;
    }

    @Override
    public void executer() {
        responsable.traiterDemande(demande);
    }
}

// Invocateur
class Serveur {
    public void envoyerCommande(Command commande) {
        commande.executer();
    }
}

// Programme principal
public class RestaurantCommand {
    public static void main(String[] args) {
        Serveur serveur = new Serveur();
        ChefCuisinier chef = new ChefCuisinier();
        ResponsableBoissons barman = new ResponsableBoissons();
        ResponsableDemandesSpeciales responsableSpeciaux = new ResponsableDemandesSpeciales();

        serveur.envoyerCommande(new CommandePlat(chef, "Pizza Margherita"));
        serveur.envoyerCommande(new CommandeBoisson(barman, "Jus d'orange"));
        serveur.envoyerCommande(new CommandeSpeciale(responsableSpeciaux, "Sans gluten"));
    }
}
