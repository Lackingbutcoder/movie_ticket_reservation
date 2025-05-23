import java.util.*;

class movie_ticket_app{
    static HashMap<String, String> user_auth = new HashMap<>();
    public static boolean isAdmin = false;
    public static boolean isLogged = false;
    static ArrayList<String> movies = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in); 
    static int choice;
    public static void main(String args[]){
        movies.add("Interstellar");
        movies.add("Dune");
        welcome();

    }

    static void welcome(){
        System.out.println("Welcome to Movie Ticket Reservation System");
        System.out.println("1)Movie Status\n2)Login/Signup\n3)Account_Info\n4)Exit");
        System.out.println("User Choice: ");
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

            }
            default -> {
                System.out.println("Invalid choice");
                System.out.println();
            }
        }
    }
}   