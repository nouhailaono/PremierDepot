public class JeuAnimauxAdapter {
    
}
// Anciennes classes (à réutiliser)
class LeChat {
    public void formeChat() {
        System.out.println("🐱 Le chat est petit et mignon.");
    }

    public void criChat() {
        System.out.println("🐱 Miaou !");
    }
}

class LaVache {
    public void formeVache() {
        System.out.println("🐮 La vache est grande et a des taches noires.");
    }

    public void criVache() {
        System.out.println("🐮 Meuh !");
    }
}

// Nouvelle interface commune
interface Animal {
    void afficherForme();
    void faireCri();
}

// Nouvelles classes conformes à Animal
class Chat implements Animal {
    public void afficherForme() {
        System.out.println("🐱 Le chat a une forme élégante.");
    }

    public void faireCri() {
        System.out.println("🐱 Miaou !");
    }
}

class Vache implements Animal {
    public void afficherForme() {
        System.out.println("🐮 La vache a une grande taille.");
    }

    public void faireCri() {
        System.out.println("🐮 Meuh !");
    }
}

// Adaptateurs pour réutiliser les anciennes classes
class ChatAdapter implements Animal {
    private LeChat leChat;

    public ChatAdapter(LeChat leChat) {
        this.leChat = leChat;
    }

    @Override
    public void afficherForme() {
        leChat.formeChat();
    }

    @Override
    public void faireCri() {
        leChat.criChat();
    }
}

class VacheAdapter implements Animal {
    private LaVache laVache;

    public VacheAdapter(LaVache laVache) {
        this.laVache = laVache;
    }

    @Override
    public void afficherForme() {
        laVache.formeVache();
    }

    @Override
    public void faireCri() {
        laVache.criVache();
    }
}

// Client
public class JeuAnimauxAdapter {
    public static void main(String[] args) {
        Animal chat = new ChatAdapter(new LeChat());
        Animal vache = new VacheAdapter(new LaVache());

        System.out.println("🎮 Jeu des animaux :");
        chat.afficherForme();
        chat.faireCri();
        vache.afficherForme();
        vache.faireCri();
    }
}
