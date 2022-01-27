package basics;

public class CopyConstructor {

    private int id;
    private String name;


    CopyConstructor(int id , String name)
    {
        this.id = id;
        this.name = name;
    }

    CopyConstructor(CopyConstructor copy)
    {
        id = copy.id;
        name = copy.name;
    }

    @Override
    public String toString() {
        return "CopyConstructor{" +
                "id=" + id +
                ", name='" + name + '\'' + this.hashCode() +
                '}';
    }

    public static void main(String[] args) {
        CopyConstructor original = new CopyConstructor(1, "Shivam");


        CopyConstructor copy = new CopyConstructor(original);

        CopyConstructor object = copy;

        System.out.println(original);
        System.out.println(copy);
        System.out.println(object);


    }

}
