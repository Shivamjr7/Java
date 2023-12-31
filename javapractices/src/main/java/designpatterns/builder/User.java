package designpatterns.builder;

public class User {

    private String firstName ; // mandatory
    private String lastName; //mandatory

    private int age; //optional
    private String phoneNo; //optional

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", phoneNo='" + phoneNo + '\'' +
                '}';
    }

    private User(UserBuilder builder)
    {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.phoneNo = builder.phoneNo;
    }



    public static class UserBuilder{

        private String firstName ; // mandatory
        private String lastName; //mandatory

        private int age; //optional
        private String phoneNo; //optional

        public UserBuilder(String firstName , String lastName)
        {
            this.firstName = firstName;
            this.lastName = lastName;

        }

        public UserBuilder age(int age)
        {
            this.age = age;
            return this;
        }

        public UserBuilder phone(String phoneNo)
        {
            this.phoneNo = phoneNo;
            return this;
        }
        public User build()
        {
            User user = new User(this);
            return user;
        }


    }





}
