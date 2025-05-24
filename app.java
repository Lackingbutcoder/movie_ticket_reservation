import java.util.*;

class MovieTicketApp{
    static HashMap<String, String> user_auth = new HashMap<>();
    public static boolean isAdmin = false;
    public static boolean isLogged = false;
    static ArrayList<String> movies = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in); 
    static int choice;
    static String username;
    static String password;
    static Authentication auth = new Authentication();
    public static void main(String args[]){
        boolean quit = false;
        movies.add("Interstellar");
        movies.add("Dune");
        while(!quit){
            welcome();
        }

    }

    static void welcome(){
        System.out.println("Welcome to Movie Ticket Reservation System");
        System.out.println("1)Movie Status\n2)Login/Signup\n3)Account_Info\n4)Exit");
        System.out.println();
        System.out.print("User Choice: ");
        choice = sc.nextInt();
        swcase(choice);
        System.out.println();


    }
    static void swcase(int choice){
        switch(choice){
            case 1 -> {
                if(movies.size()!=0){
                    System.out.println("Following movies are available");
                    for(int i=0;i<movies.size();i++){
                        System.out.println(movies.get(i));
                    }
                }
                else{
                    System.out.println("No movies available right now");
                }

                if(!isLogged){
                    System.out.println("Login/Signup to book a movie");
                }
            }
            case 2 -> {
                if(isLogged){
                    System.out.println("Already logged in");
                }
                else if(!isLogged){
                    System.out.println();
                    System.out.println("1)Login\n2)Signup");
                    System.out.print("User Choice: ");
                    choice = sc.nextInt();
                    sc.nextLine();
                    switch(choice){
                        case 1 -> {
                            System.out.print("Enter username:");
                            username = sc.nextLine();
                            System.out.print("Enter password:");
                            password = sc.nextLine();
                            auth.login(username,password);
                        }
                        case 2 -> {
                            System.out.print("Enter username:");
                            username = sc.nextLine();
                            System.out.print("Enter password:");
                            password = sc.nextLine();
                            auth.signup(username,password);

                        }
                        case 3 -> {
                            if(isLogged){
                                System.out.println(username);
                            }
                        }
                    }
                }
            }
            default -> {
                System.out.println("Invalid choice");
                System.out.println();
            }
        }
    }
}   

class Authentication extends MovieTicketApp{

    static void login(String username,String password){
        if(username !=null && password != null){
            if(user_auth.containsKey(username) && (user_auth.get(username).equals(password))){
                isLogged = true;
                System.out.println("Logged in Successfully");
            }
            else{
                System.out.println("Username or Password incorrect");
            }
        }
        else{
            System.out.println("Login error");
        }
    }

    static void signup(String username, String password){
        if(username !=null && password !=null){
            if(user_auth.containsKey(username)){
                System.out.println("Username already exists... Please choose another username");
            }
            else{
                user_auth.put(username,password);
                System.out.println("Successfully Signed Up");
                login(username,password);
            }
        }
        else{
            System.out.println("Signup error");
        }
    }

}

class User extends MovieTicketApp{

}