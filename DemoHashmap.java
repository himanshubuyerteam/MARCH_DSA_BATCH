import java.util.HashMap;

class User
{
    int id;
    String name;
    User(int id,String name)
    {
        this.id=id;
        this.name=name;
    }

    @Override
    public int hashCode()
    {
        return this.id;
    }

    @Override
    public boolean equals(Object obj)
    {
        User u = (User) obj;
        if(u.id == this.id)
            return true;
        else
            return false;
    }
}
public class DemoHashmap {
    public static void main(String[] args) {
        HashMap<User,Integer> hm = new HashMap<>();
        User u1 = new User(1, "ABC");
        User u2 = new User(2, "BCD");

        hm.put(u1, 100);
        hm.put(u2, 200);
        System.out.println(hm);
        User u3 = new User(1, "ABC");
        System.out.println(hm.containsKey(u3));
    }
}
