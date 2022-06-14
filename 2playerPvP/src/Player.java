public class Player {

    public  int hp;
    public  int maxHp = 100;
    public  String name;

    public Player(String name){
        this.name = name;
        this.hp = 100;
    }

    public int takeDamage(int damage){
        this.hp -= damage;
        return hp;
    }

    public void setName(String name) {
        this.name = name;
    }
}
