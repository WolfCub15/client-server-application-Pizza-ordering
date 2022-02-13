/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.pizza;
import grpc.*;
import io.grpc.*;
import grpc.PizzaServiceGrpc;
import com.google.protobuf.Empty;
import grpc.AddNewPizzaRequest;
import grpc.GetPizzaListResponse;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

/**
 *
 * @author Nastya
 */
public class PizzaClient {
    private static PizzaServiceGrpc.PizzaServiceStub createClient(String host, int port){
        Channel channel = ManagedChannelBuilder.forAddress(host,port)
            .usePlaintext()
            .build();
        return PizzaServiceGrpc.newStub(channel);
    }
    
    public static void main(String[] args) throws Exception{
        int count = 5;

        PizzaServiceGrpc.PizzaServiceStub asyncClient = createClient("localhost",1515);
        System.out.println("Client connected to server");
        
        Scanner in = new Scanner(System.in);
        
        while(true){
            System.out.println("Input: \n ");
            System.out.println("'ord' if you want ord pizza");
            System.out.println("'ordN' if you want ord N pizza");
            System.out.println("'get' if you want get pizza list");
            System.out.println("'check' if you want check pizza status");
            System.out.println("'bye' if you want disconnect");
            
            String action = in.nextLine();

            if ("ord".equals(action) ){
                System.out.println("Input pizza id: ");
                int id = in.nextInt();
                System.out.println("Input pizza count: ");
                int countP = in.nextInt();

                final CountDownLatch ordPizzaLatch = new CountDownLatch(count);

                WaitObserver<OrderPizzaResponse> observer = new WaitObserver<>(ordPizzaLatch,
                        t->System.out.println("Order number: " + t.getPizzaOrderNumber() + '\n' + 
                                              "Cost: " + t.getPizzaCost() + '\n'));

                
                OrderPizzaRequest pizzaRequest =
                OrderPizzaRequest.newBuilder()
                    .setPizzaId(id)
                    .setPizzaCount(countP)
                    .build();

                asyncClient.orderPizza(pizzaRequest,observer);
                
                ordPizzaLatch.await(5, TimeUnit.SECONDS);
            }
            else if("get".equals(action) ){
                                
                final CountDownLatch getPizzaLatch = new CountDownLatch(count);
                    
                WaitObserver<GetPizzaListResponse> observer = new WaitObserver<>(getPizzaLatch, new Consumer<GetPizzaListResponse>() {
                    @Override
                    public void accept(GetPizzaListResponse t) {
                        for(grpc.GetPizzaListResponse.PizzaList x: t.getPizzaListList()){
                            System.out.println("Id: " + x.getPizzaId() + '\n' + 
                                    "Name: " + x.getPizzaName() + '\n' + 
                                    "Description: " + x.getPizzaDescription() + '\n' + 
                                    "Cost: " + x.getPizzaCost() + '\n');
                        }
                    }
                });
                GetPizzaListRequest pizzaRequest =
                GetPizzaListRequest.newBuilder()
                    .build();

                asyncClient.getPizzaList(pizzaRequest ,observer);


                getPizzaLatch.await(5, TimeUnit.SECONDS);
            }
            else if("check".equals(action) ){
                System.out.println("Input order number: ");
                int number = in.nextInt();     
                final CountDownLatch numbPizzaLatch = new CountDownLatch(count);
                    
                WaitObserver<CheckOrderResponse> observer = new WaitObserver<>(numbPizzaLatch,
                        t->System.out.println("Status: " + t.getPizzaStatus()+ '\n'));
                
                CheckOrderRequest pizzaRequest =
                CheckOrderRequest.newBuilder()
                    .setPizzaOrderNumber(number)
                    .build();

                asyncClient.checkOrder(pizzaRequest ,observer);

                numbPizzaLatch.await(5, TimeUnit.SECONDS);
            }
            else if("bye".equals(action) ){
                System.out.println("Goodbye!");
                break;
            }
            else if("ordN".equals(action)){
                System.out.println("Input pizza count: ");
                int N = in.nextInt();
                OrderNPizzaRequest.Builder request = OrderNPizzaRequest.newBuilder();
                        
                for(int i = 0; i < N; ++i){
                    System.out.println("Input pizza id: ");
                    int id = in.nextInt();
                    System.out.println("Input pizza count: ");
                    int pizzaCount = in.nextInt();
                    OrderNPizzaRequest.PizzaList pList =
                            OrderNPizzaRequest.PizzaList.newBuilder()
                            .setPizzaId(id)
                            .setPizzaCount(pizzaCount)
                            .build();
                    request.addPizzaList(pList);
                }

                final CountDownLatch ordPizzaLatch = new CountDownLatch(count);

                WaitObserver<OrderNPizzaResponse> observer = new WaitObserver<>(ordPizzaLatch,
                        t->System.out.println("Order number: " + t.getPizzaOrderNumber() + '\n' + 
                                              "Cost: " + t.getPizzaCost() + '\n'));

                
                
                asyncClient.orderNPizza(request.build(),observer);
                
                ordPizzaLatch.await(5, TimeUnit.SECONDS);
            }
            
        }
        
    } 
    
}
