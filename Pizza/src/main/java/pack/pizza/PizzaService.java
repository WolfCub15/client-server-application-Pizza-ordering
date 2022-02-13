/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.pizza;
import com.google.protobuf.Empty;
import grpc.*;
import io.grpc.*;
import io.grpc.stub.StreamObserver;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
/**
 *
 * @author Nastya
 */
public class PizzaService extends PizzaServiceGrpc.PizzaServiceImplBase{
    //Map<String, Pizza> pizza = new ConcurrentHashMap<>();
    List<Pizza> pizza = new ArrayList<Pizza>();
    List<Pizza> ordPizza = new ArrayList<Pizza>();
    int position = 0;
    int ordCount = 0;

    public PizzaService(){
        Pizza q1 = new Pizza();
        q1.setId(position);
        q1.setName("First");
        q1.setDescription("Cheese and bacon");
        q1.setCost(300);
        q1.setPos(position + 1);
        position++;
        pizza.add(q1);
        Pizza q2 = new Pizza();
        q2.setId(position);
        q2.setName("Second");
        q2.setDescription("Bacon and tomato");
        q2.setCost(288);
        q2.setPos(position + 1);
        position++;
        pizza.add(q2);
        Pizza q3 = new Pizza();
        q3.setId(position);
        q3.setName("Cool");
        q3.setDescription("Сhicken, bacon, cheese, tomato sauce");
        q3.setCost(500);
        q3.setPos(position + 1);
        position++;
        pizza.add(q3);
        
        Pizza q4 = new Pizza();
        q4.setCost(500);
        q4.setDescription("Сhicken, bacon, cheese, tomato sauce");
        q4.setId(3);
        q4.setName("Cool");
        q4.setStatus("In work");
        q4.setPos(ordCount + 1);
        ordPizza.add(q4);
        ordCount++;
        Pizza q5 = new Pizza();
        q5.setCost(900);
        q5.setDescription("Cheese and bacon");
        q5.setId(1);
        q5.setName("First");
        q5.setStatus("Ready!");
        q5.setPos(ordCount + 1);
        ordPizza.add(q5);
        ordCount++;
        
    }
    
    public void addNewPizza(grpc.AddNewPizzaRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
        Pizza q = new Pizza();
        q.setId(position);
        q.setName(request.getPizzaName());
        q.setDescription(request.getPizzaDescription());
        q.setCost(request.getPizzaCost());
        q.setPos(position + 1);
        position++;
        pizza.add(q);
        System.out.println("New pizza added: " + q.name + ' ' + q.description + ' ' + q.cost + ' ' + q.pos + '\n');
        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }
    
    public void delPizza(grpc.DelPizzaRequest request,
        io.grpc.stub.StreamObserver<grpc.DelPizzaResponse> responseObserver) {
        for(int i = 0; i < pizza.size(); ++i){
            if (pizza.get(i).getId() == request.getPizzaId()){
                Pizza remove = pizza.remove(request.getPizzaId());
                position--;
                DelPizzaResponse response = DelPizzaResponse.newBuilder()
                    .setPizzaStatus("OK!")
                    .build();

                System.out.println("Remove pizza status = OK \n");
                responseObserver.onNext(response);
                responseObserver.onCompleted();
                return;
            }
        }
        DelPizzaResponse response = DelPizzaResponse.newBuilder()
            .setPizzaStatus("Incorrect pizza id")
            .build();
  
        System.out.println("Remove pizza status: Incorrect pizza id \n");
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
    
    public void orderPizza(grpc.OrderPizzaRequest request,
        io.grpc.stub.StreamObserver<grpc.OrderPizzaResponse> responseObserver) {
        
        for(int i = 0; i < pizza.size(); ++i){
            if (pizza.get(i).getId() == request.getPizzaId()){
                OrderPizzaResponse response = OrderPizzaResponse.newBuilder()
                    .setPizzaOrderNumber(ordCount + 1)
                    .setPizzaCost(request.getPizzaCount() * pizza.get(i).getCost())
                    .build();
                Pizza q = new Pizza();
                q.setCost(request.getPizzaCount() * pizza.get(i).getCost());
                q.setDescription(pizza.get(i).getDescription());
                q.setId(request.getPizzaId());
                q.setName(pizza.get(i).getName());
                q.setStatus("In work");
                q.setPos(ordCount + 1);
                ordPizza.add(q);
                ordCount++;
                System.out.println("Order pizza: " +  request.getPizzaId() + ' ' + request.getPizzaCount() + '\n');
                responseObserver.onNext(response);
                responseObserver.onCompleted();
                return;
            }
        }
        OrderPizzaResponse response = OrderPizzaResponse.newBuilder()
            .setPizzaOrderNumber(-1)
            .setPizzaCost(-1)
            .build();
        System.out.println("Order pizza: " +  request.getPizzaId() + ' ' + request.getPizzaCount() + '\n');
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
    
    public void orderNPizza(grpc.OrderNPizzaRequest request,
        io.grpc.stub.StreamObserver<grpc.OrderNPizzaResponse> responseObserver) {
        int currCost = 0;
        List<OrderNPizzaRequest.PizzaList> pizL = request.getPizzaListList();
        for(int i = 0; i < pizL.size(); ++i){
            OrderNPizzaRequest.PizzaList tmpPizza = pizL.get(i);
            
            for (int j = 0; j < pizza.size(); ++j){
                if (pizza.get(j).getId() == tmpPizza.getPizzaId()){
                    Pizza q = new Pizza();
                    q.setCost(tmpPizza.getPizzaCount() * pizza.get(j).getCost());
                    q.setDescription(pizza.get(j).getDescription());
                    q.setId(tmpPizza.getPizzaId());
                    q.setName(pizza.get(j).getName());
                    q.setStatus("In work");
                    q.setPos(ordCount + 1);
                    ordPizza.add(q);
                    currCost += q.getCost();
                    //ordCount++;
                    System.out.println("Order pizza: " +  tmpPizza.getPizzaId() + ' ' + tmpPizza.getPizzaCount() + '\n');
                    break;
                }
            }
        }
        OrderNPizzaResponse response = OrderNPizzaResponse.newBuilder()
            .setPizzaOrderNumber(ordCount + 1)
            .setPizzaCost(currCost)
            .build();
        ordCount++;
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
    
    public void checkOrder(grpc.CheckOrderRequest request,
        io.grpc.stub.StreamObserver<grpc.CheckOrderResponse> responseObserver) {
        int k = -1;
        for(int i = 0; i < ordPizza.size(); ++i){
            if (ordPizza.get(i).getPos()== request.getPizzaOrderNumber()){
                System.out.println("Check order: " +  ordPizza.get(i).getStatus() + '\n');
                k = i;
            }
        }
        if (k != -1){
            CheckOrderResponse response = CheckOrderResponse.newBuilder()
                .setPizzaStatus(ordPizza.get(k).getStatus())
                .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            return;
        }
        CheckOrderResponse response = CheckOrderResponse.newBuilder()
            .setPizzaStatus("Incorrecr order number")
            .build();
        System.out.println("Check order: Incorrecr order number \n");
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
    
    public void changePizzaStatus(grpc.ChangePizzaStatusRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
        
        int k = 0;
        for(int i = 0; i < ordPizza.size(); ++i){
            if (ordPizza.get(i).getPos()== request.getPizzaOrderNumber()){
                ordPizza.get(i).setStatus(request.getPizzaStatus());
                System.out.println("New status: " +  request.getPizzaStatus() + '\n');
                k++;
            }
        }
        if(k != 0){
            responseObserver.onNext(Empty.newBuilder().build());
            responseObserver.onCompleted();
        }
        else{
            System.out.println("New pizza status: incorrect order number \n");
            responseObserver.onNext(Empty.newBuilder().build());
            responseObserver.onCompleted();
        }
    }
    
    public void getPizzaCount(grpc.GetPizzaCountRequest request,
        io.grpc.stub.StreamObserver<grpc.GetPizzaCountResponse> responseObserver) {
        GetPizzaCountResponse resp = GetPizzaCountResponse.newBuilder()
                    .setPizzaCount(position)
                    .build();
        responseObserver.onNext(resp);
        responseObserver.onCompleted();

    }
    
    public void getPizzaList(grpc.GetPizzaListRequest request,
        io.grpc.stub.StreamObserver<grpc.GetPizzaListResponse> responseObserver) {
        GetPizzaListResponse.Builder response = GetPizzaListResponse.newBuilder();

        for (int i = 0; i < pizza.size(); ++i){
            GetPizzaListResponse.PizzaList.Builder pizzaL = GetPizzaListResponse.PizzaList.newBuilder()
                    .setPizzaId(pizza.get(i).getId())
                    .setPizzaName(pizza.get(i).getName())
                    .setPizzaDescription(pizza.get(i).getDescription())
                    .setPizzaCost(pizza.get(i).getCost())
                    .setPizzaCount(position);
            response.addPizzaList(pizzaL);
            System.out.println("Get pizza: " + pizza.get(i).getName());
        }
        System.out.println("List pizza: " + position);
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
    
    public static void main(String[] args) throws Exception{
        Server server = ServerBuilder
        .forPort(1515)
        .addService(new PizzaService()).build();
        server.start();
        System.out.println("Server started");
        server.awaitTermination();    
    }
    
}
