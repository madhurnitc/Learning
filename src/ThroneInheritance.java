import java.util.*;

class ThroneInheritance {

    Set<String> dead ;
    Map<String, List<String>> family;
    String king;
    public ThroneInheritance(String kingName) {
        this.king = kingName;
        dead = new HashSet<>();
        family = new HashMap<>();
        family.putIfAbsent(kingName, new ArrayList<String>());

    }

    public void birth(String parentName, String childName) {
        family.putIfAbsent(parentName, new ArrayList<>());
        family.get(parentName).add(childName);
        family.putIfAbsent(childName, new ArrayList<>());

    }

    public void death(String name) {
        dead.add(name);

    }

    public List<String> getInheritanceOrder() {
        List<String> result = new ArrayList<>();
        if(!dead.contains(this.king)) {
            result.add(this.king);
        }
        dfs(this.king, result);
        return result;
    }

    private void dfs(String parent, List<String> result) {

        for(String child : family.get(parent)) {
            if(!dead.contains(child)) {
                result.add(child);
            }
            dfs(child, result);
        }
    }

    public static void main(String[] args) {
        ThroneInheritance obj = new ThroneInheritance("king");
        obj.birth("king", "andy");
        obj.birth("king", "bob");
        obj.birth("king","catherine");
        obj.birth("andy","matthew");
        obj.birth("bob","alex");
        obj.birth("bob","asha");
        List<String> order = obj.getInheritanceOrder();
        obj.death("bob");
        order = obj.getInheritanceOrder();
        System.out.println("######");

    }
}