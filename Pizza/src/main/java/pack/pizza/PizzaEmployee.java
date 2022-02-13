/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.pizza;

import com.google.protobuf.Empty;
import grpc.AddNewPizzaRequest;
import grpc.GetPizzaListResponse;
import grpc.*;
import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


/**
 *
 * @author Nastya
 */
public class PizzaEmployee {
    private static PizzaServiceGrpc.PizzaServiceStub createClient(String host, int port){
        Channel channel = ManagedChannelBuilder.forAddress(host,port)
            .usePlaintext()
            .build();
        return PizzaServiceGrpc.newStub(channel);
    }
    public static void main(String[] args) throws Exception{
        int count = 5;

        PizzaServiceGrpc.PizzaServiceStub asyncClient = createClient("localhost",1515);
        System.out.println("Connected to server");
        
        Scanner in = new Scanner(System.in);
        
        while(true){
            System.out.println("Input: \n ");
            System.out.println("'add' if you want add new pizza");
            System.out.println("'get' if you want get pizza list");
            System.out.println("'del' if you want del pizza");
            System.out.println("'change' if you want change pizza status");
            System.out.println("'bye' if you want disconnect");


            String action = in.nextLine();

            if ("add".equals(action) ){
                System.out.println("Input pizza name: ");
                String name = in.nextLine();
                System.out.println("Input pizza description: ");
                String description = in.nextLine();
                System.out.println("Input pizza cost: ");
                double cost = in.nextDouble();

                final CountDownLatch addPizzaLatch = new CountDownLatch(count);

                WaitObserver<Empty> observer = new WaitObserver<>(addPizzaLatch, t->{});

                
                AddNewPizzaRequest pizzaRequest =
                AddNewPizzaRequest.newBuilder()
                    .setPizzaName(name)
                    .setPizzaDescription(description)
                    .setPizzaCost(cost)
                    .build();

                asyncClient.addNewPizza(pizzaRequest,observer);
                

                addPizzaLatch.await(5, TimeUnit.SECONDS);
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
            else if("del".equals(action) ){
                System.out.println("Input pizza id: ");
                int id = in.nextInt();     
                final CountDownLatch delPizzaLatch = new CountDownLatch(count);
                    
                WaitObserver<DelPizzaResponse> observer = new WaitObserver<>(delPizzaLatch, t->{});
                
                DelPizzaRequest pizzaRequest =
                DelPizzaRequest.newBuilder()
                    .setPizzaId(id)
                    .build();

                asyncClient.delPizza(pizzaRequest ,observer);

                delPizzaLatch.await(5, TimeUnit.SECONDS);
            }
            else if("change".equals(action) ){
                    
                System.out.println("Input new pizza status: ");
                String s = in.nextLine();
                
                System.out.println("Input order number: ");
                int numb = in.nextInt(); 
                
                final CountDownLatch changePizzaLatch = new CountDownLatch(count);
                    
                WaitObserver<Empty> observer = new WaitObserver<>(changePizzaLatch, t->{});
                
                ChangePizzaStatusRequest pizzaRequest =
                ChangePizzaStatusRequest.newBuilder()
                    .setPizzaOrderNumber(numb)
                    .setPizzaStatus(s)
                    .build();

                asyncClient.changePizzaStatus(pizzaRequest ,observer);

                changePizzaLatch.await(5, TimeUnit.SECONDS);
            }
            else if("bye".equals(action) ){
                System.out.println("Goodbye!");
                break;
            }            
        }
        
    } 
}
