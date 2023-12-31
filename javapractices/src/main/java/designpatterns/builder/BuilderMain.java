package designpatterns.builder;

public class BuilderMain {

    public static void main(String[] args) {


        //creating user with age and phone
        User user = new User.UserBuilder("Shivam" ,"Jari")
                        .age(31)
                        .phone("7795121207")
                        .build();

        User userWithoutPhone = new User.UserBuilder("Mehandi","Khanna").age(30)
                                    .build();
        System.out.println(user);
        System.out.println(userWithoutPhone);
    }
}
