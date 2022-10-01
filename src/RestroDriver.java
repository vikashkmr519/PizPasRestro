import java.util.*;

public class RestroDriver {

    static Queue<OrderRequest> orderQueue = new LinkedList<>();
    static Inventory inventory;

    static Kitchen kitchen;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        inventory = new Inventory();
        kitchen = new KitchenImpl();
        Prices prices = new Prices();
        int exitChoice= -1;
        do {

            System.out.println("Welcome To PizPas Restro :) ");

            Customer customer = customerExistenceCheck(sc);
            System.out.println("Welcome to PizPasRestro " + customer.getName());

            if(!inventory.doesCustomerExists(customer.getCustId())){
                inventory.addCustomer(customer);
            }
            OrderRequest orderRequest = chooseFoodType(sc);
           int quantity = getQuantity(sc);
           orderRequest.setQuantity(quantity);
            orderRequest.setCustId(customer.getCustId());
            int cost = prices.getPriceOf(orderRequest);
            cost = cost*quantity;
            System.out.println("Amount to be paid " + cost);
            System.out.println("Please enter this amount to complete the transaction");
            int amount = 0;
            do {
                amount = sc.nextInt();

                if (amount == cost) {
                    break;
                } else {
                    System.out.println("Transaction denied :( ");
                    System.out.println("Please enter the valid amount ");
                }
            } while (cost != amount);
            System.out.println("ThankYou. Your Order has been placed");



            orderQueue.add(orderRequest);
            System.out.println("It is getting Prepared.........");
            List<Food> customerOrderList = new ArrayList<>();
            OrderRequest pickedRequest = orderQueue.poll();
            for(int i =0;i<quantity;i++){
                Food cookedFood = cookFood(pickedRequest);
                cookedFood.setOrderStatus(true);
                customerOrderList.add(cookedFood);
                inventory.addFoodToCustomer(cookedFood.getFoodId(), customer.getCustId());
                inventory.addFood(cookedFood);
            }

            System.out.println("Your food is ready");
            System.out.println("Packing your food , please wait!......");
            System.out.println("All foods are served below please check");
            System.out.println("#############################################");
            System.out.println(customer.getName()+" your foods are "+ customerOrderList.get(0).getFoodType());
            customerOrderList.stream().forEach(( food )->  serveFood(customer, food));
            System.out.println("Your Total price is : " + cost);
            System.out.println("Customer Id is : "+customer.getCustId());

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("if Don't want to proceed forward Enter 0");
            System.out.println("Else enter any number to continue");
            exitChoice = sc.nextInt();
        } while(exitChoice!=0);




    }
    private static int getQuantity(Scanner sc){
        System.out.println("Please Enter the quantity for your food");
        int choice = 0;

        do{
            choice = sc.nextInt();
            if(choice>10){
                System.out.println("We can Sereve at max 10 quantity to a person");
                System.out.println("please enter valid input");
            }else if(choice<1){
                System.out.println("Please Enter valid input");
            }
        }while(choice>10 || choice<1);

        return choice;
    }

    private static Food cookFood(OrderRequest orderRequest) {

      return   kitchen.cookFood(orderRequest);
    }

    private static Customer customerExistenceCheck(Scanner sc) {
        System.out.println("Already A Customer?");
        System.out.println("Enter 1 for Yes.");
        System.out.println("Enter 2 for No");
        int choice = 0;
        Customer customer = null;
        do {
            choice = sc.nextInt();
            if (choice == 1) {
                System.out.println("Please provide your customer Id");
                boolean customerPresent = false;
                do {
                    int custId = sc.nextInt();
                    customerPresent = inventory.doesCustomerExists(custId);
                    if (!customerPresent) {
                        System.out.println("Please provide valid customer Id");
                    } else {
                        customer = inventory.getCustomerById(custId);
                    }
                } while (!customerPresent);

            } else if (choice == 2) {
                System.out.println("Please provide your name");
                ///sc.next();
                String name = sc.next();
                customer = new Customer(name);
            }
            if (choice != 1 && choice != 2) {
                System.out.println("Please give the right input.");
            }
        } while (choice < 1 || choice > 2);

        return customer;
    }

    private static OrderRequest chooseFoodType(Scanner sc) {
        System.out.println("Please choose your food type");
        System.out.println("Enter 1 for Pizza");
        System.out.println("Enter 2 for Pasta");
        int choice = 0;
        OrderRequest orderRequest = null;
        do {
            choice = sc.nextInt();
            if (choice == 1) {
                orderRequest = orderPizza(sc);

            } else if (choice == 2) {

                orderRequest = orderPasta(sc);

            } else {
                System.out.println("Please Enter A Valid Choice");
            }

        } while (choice < 1 || choice > 2);

        return orderRequest;
    }


    private static PizzaRequest orderPizza(Scanner sc) {
        System.out.println("Please choose a pizza Size");
        System.out.println("Enter 1 for small size");
        System.out.println("Enter 2 for Medium size");
        System.out.println("Enter 3 for Large size");
        int sizeChoice = 0;
        String size = null;
        String flavor = null;
        String toppings = null;
        String crust = null;
        PizzaRequest request = null;

        do {
            sizeChoice = sc.nextInt();

            if (sizeChoice == 1) {
                size = Constants.PIZZA_SMALL_SIZE;
            } else if (sizeChoice == 2) {
                size = Constants.PIZZA_MEDIUM_SIZE;
            } else if (sizeChoice == 3) {
                size = Constants.PIZZA_LARGE_SIZE;
            } else {
                System.out.println("Please Enter a valid choice");
            }
        } while (sizeChoice < 1 && sizeChoice > 3);

        System.out.println("Please choose a pizza crust");
        System.out.println("Enter 1 for thin ");
        System.out.println("Enter 2 for thick");
        int crustChoice = 0;
        do {
            crustChoice = sc.nextInt();

            if (crustChoice == 1) {
                crust = Constants.PIZZA_THIN_CRUST;
            } else if (crustChoice == 2) {
                crust = Constants.PIZZA_THICK_CRUST;
            } else {
                System.out.println("Please Enter a valid choice");
            }
        } while (crustChoice < 1 && crustChoice > 3);

        System.out.println("Please choose a pizza flavour");
        System.out.println("Enter 1 for Vegetarian ");
        System.out.println("Enter 2 for Non-Veg");
        System.out.println("Enter 3 for Vegan");
        int flavourChoice = 0;

        do {
            flavourChoice = sc.nextInt();
            if (flavourChoice == 1) {
                flavor = Constants.PIZZA_VEG_FLAVOUR;
            } else if (flavourChoice == 2) {
                flavor = Constants.PIZZA_NON_VEG_FLAVOUR;
            } else if (flavourChoice == 3) {
                flavor = Constants.PIZZA_VEGAN_FLAVOUR;
            } else {
                System.out.println("Please Enter a valid choice");
            }
        } while (flavourChoice < 1 || flavourChoice > 3);

        System.out.println("Please choose a pizza toppings");
        System.out.println("Enter 1 for Cheese ");
        System.out.println("Enter 2 for Mushroom");
        System.out.println("Enter 3 for Tomato");
        System.out.println("Enter 4 for Jalpaeno");
        System.out.println("Enter 5 for Spinach");
        System.out.println("Enter 6 for None");
        int toppingsChoice = 0;

        do {
            toppingsChoice = sc.nextInt();
            if (toppingsChoice == 1) {
                toppings = Constants.PIZZA_CHEESE_TOPPINGS;
            } else if (toppingsChoice == 2) {
                toppings = Constants.PIZZA_MUSHROOM_TOPPINGS;
            } else if (toppingsChoice == 3) {
                toppings = Constants.PIZZA_TOMATO_TOPPINGS;
            } else if (toppingsChoice == 4) {
                toppings = Constants.PIZZA_JALAPENO_TOPPINGS;

            } else if (toppingsChoice == 5) {
                toppings = Constants.PIZZA_SPINACH_TOPPINGS;
            } else if (toppingsChoice == 6) {
                break;
            } else {
                System.out.println("Please Enter a Valid choice");
            }

        } while (toppingsChoice < 1 || toppingsChoice > 5);

        request = new PizzaRequest(size, crust, flavor, toppings);

        return request;
    }

    private static OrderRequest orderPasta(Scanner sc) {

        System.out.println("Please provide your pasta flavor choice");
        System.out.println("Enter 1 for White Sauce");
        System.out.println("Enter 2 for Red Sauce");

        int sauceChoice =0;
        String sauce = null;
        String types = null;
        PastaRequest request = null;

        do{
            sauceChoice = sc.nextInt();
            if(sauceChoice==1){
                sauce = Constants.PASTA_WHITE_SAUCE_FLAVOUR;
            }else if(sauceChoice==2){
                sauce = Constants.PASTA_RED_SAUCE_FLAVOUR;
            }else{
                System.out.println("Please Enter a valid choice");
            }


        }while(sauceChoice<1 || sauceChoice>2);

        System.out.println("Please Provide the pasta type");
        System.out.println("Enter 1 for Penne");
        System.out.println("Enter 2 for Ditalini");
        int typechoice = 0;

        do{
            typechoice = sc.nextInt();
            if(typechoice==1){
                types = Constants.PASTA_PENNE_TYPE;
            }else if(typechoice==2){
                types = Constants.PASTA_DITALINI_TYPE;
            }else{
                System.out.println("Please Enter a valid choice");
            }
        }while(typechoice<1 || typechoice>2);

        request = new PastaRequest(types,sauce);

        return request;

    }

    private static void serveFood(Customer customer, Food cookedFood){


        if(cookedFood.getFoodType().equals(Constants.PASTA_ORDER_TYPE)){
            Pasta pasta = (Pasta)cookedFood;
            System.out.println("Pasta Type "+ pasta.getPastaType());
            System.out.println("Pasta Sauce "+ pasta.getPastaFlavour());


        }else {
            Pizza pizza = (Pizza) cookedFood;
            System.out.println("Pizza Size : "+ pizza.getPizzaSize());
            System.out.println("Pizza Flavor : "+ pizza.getPizzaFlavor());
            System.out.println("Pizza crust : "+pizza.getCrustType());
            if(pizza.getToppings()!=null) {
                System.out.println("Pizza Toppings : " + pizza.getToppings());
            }

        }

        System.out.println("-----------------------");


    }


}
