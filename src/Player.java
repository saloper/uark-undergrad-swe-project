public class Player {
    String name;
    int id;
    boolean isRedTeam;

    public Player(String _name, int _id, boolean _isRedTeam){
        name = _name;
        id = _id;
        isRedTeam = _isRedTeam;
    }

    public Player(Player player){
        name = player.getName();
        id = player.getId();
    }

    public String getName() { return name; }
    public int getId() { return id; }
    public boolean getTeam() { return isRedTeam; }
    public void setName(String _name) { name = _name; }
    public void setId(int _id) { id = _id; }
    public void setTeam(boolean _isRedTeam) { isRedTeam = _isRedTeam; }
}
