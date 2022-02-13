package grpc;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.4.0)",
    comments = "Source: Pizza.proto")
public final class PizzaServiceGrpc {

  private PizzaServiceGrpc() {}

  public static final String SERVICE_NAME = "grpc.PizzaService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<grpc.AddNewPizzaRequest,
      com.google.protobuf.Empty> METHOD_ADD_NEW_PIZZA =
      io.grpc.MethodDescriptor.<grpc.AddNewPizzaRequest, com.google.protobuf.Empty>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "grpc.PizzaService", "addNewPizza"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              grpc.AddNewPizzaRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.google.protobuf.Empty.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<grpc.GetPizzaListRequest,
      grpc.GetPizzaListResponse> METHOD_GET_PIZZA_LIST =
      io.grpc.MethodDescriptor.<grpc.GetPizzaListRequest, grpc.GetPizzaListResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "grpc.PizzaService", "getPizzaList"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              grpc.GetPizzaListRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              grpc.GetPizzaListResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<grpc.DelPizzaRequest,
      grpc.DelPizzaResponse> METHOD_DEL_PIZZA =
      io.grpc.MethodDescriptor.<grpc.DelPizzaRequest, grpc.DelPizzaResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "grpc.PizzaService", "delPizza"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              grpc.DelPizzaRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              grpc.DelPizzaResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<grpc.ChangePizzaStatusRequest,
      com.google.protobuf.Empty> METHOD_CHANGE_PIZZA_STATUS =
      io.grpc.MethodDescriptor.<grpc.ChangePizzaStatusRequest, com.google.protobuf.Empty>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "grpc.PizzaService", "changePizzaStatus"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              grpc.ChangePizzaStatusRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.google.protobuf.Empty.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<grpc.OrderPizzaRequest,
      grpc.OrderPizzaResponse> METHOD_ORDER_PIZZA =
      io.grpc.MethodDescriptor.<grpc.OrderPizzaRequest, grpc.OrderPizzaResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "grpc.PizzaService", "orderPizza"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              grpc.OrderPizzaRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              grpc.OrderPizzaResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<grpc.OrderNPizzaRequest,
      grpc.OrderNPizzaResponse> METHOD_ORDER_NPIZZA =
      io.grpc.MethodDescriptor.<grpc.OrderNPizzaRequest, grpc.OrderNPizzaResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "grpc.PizzaService", "orderNPizza"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              grpc.OrderNPizzaRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              grpc.OrderNPizzaResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<grpc.CheckOrderRequest,
      grpc.CheckOrderResponse> METHOD_CHECK_ORDER =
      io.grpc.MethodDescriptor.<grpc.CheckOrderRequest, grpc.CheckOrderResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "grpc.PizzaService", "checkOrder"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              grpc.CheckOrderRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              grpc.CheckOrderResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<grpc.GetPizzaCountRequest,
      grpc.GetPizzaCountResponse> METHOD_GET_PIZZA_COUNT =
      io.grpc.MethodDescriptor.<grpc.GetPizzaCountRequest, grpc.GetPizzaCountResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "grpc.PizzaService", "getPizzaCount"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              grpc.GetPizzaCountRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              grpc.GetPizzaCountResponse.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PizzaServiceStub newStub(io.grpc.Channel channel) {
    return new PizzaServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PizzaServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new PizzaServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PizzaServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new PizzaServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class PizzaServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void addNewPizza(grpc.AddNewPizzaRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ADD_NEW_PIZZA, responseObserver);
    }

    /**
     */
    public void getPizzaList(grpc.GetPizzaListRequest request,
        io.grpc.stub.StreamObserver<grpc.GetPizzaListResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_PIZZA_LIST, responseObserver);
    }

    /**
     */
    public void delPizza(grpc.DelPizzaRequest request,
        io.grpc.stub.StreamObserver<grpc.DelPizzaResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_DEL_PIZZA, responseObserver);
    }

    /**
     */
    public void changePizzaStatus(grpc.ChangePizzaStatusRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CHANGE_PIZZA_STATUS, responseObserver);
    }

    /**
     */
    public void orderPizza(grpc.OrderPizzaRequest request,
        io.grpc.stub.StreamObserver<grpc.OrderPizzaResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ORDER_PIZZA, responseObserver);
    }

    /**
     */
    public void orderNPizza(grpc.OrderNPizzaRequest request,
        io.grpc.stub.StreamObserver<grpc.OrderNPizzaResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ORDER_NPIZZA, responseObserver);
    }

    /**
     */
    public void checkOrder(grpc.CheckOrderRequest request,
        io.grpc.stub.StreamObserver<grpc.CheckOrderResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CHECK_ORDER, responseObserver);
    }

    /**
     */
    public void getPizzaCount(grpc.GetPizzaCountRequest request,
        io.grpc.stub.StreamObserver<grpc.GetPizzaCountResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_PIZZA_COUNT, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_ADD_NEW_PIZZA,
            asyncUnaryCall(
              new MethodHandlers<
                grpc.AddNewPizzaRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_ADD_NEW_PIZZA)))
          .addMethod(
            METHOD_GET_PIZZA_LIST,
            asyncUnaryCall(
              new MethodHandlers<
                grpc.GetPizzaListRequest,
                grpc.GetPizzaListResponse>(
                  this, METHODID_GET_PIZZA_LIST)))
          .addMethod(
            METHOD_DEL_PIZZA,
            asyncUnaryCall(
              new MethodHandlers<
                grpc.DelPizzaRequest,
                grpc.DelPizzaResponse>(
                  this, METHODID_DEL_PIZZA)))
          .addMethod(
            METHOD_CHANGE_PIZZA_STATUS,
            asyncUnaryCall(
              new MethodHandlers<
                grpc.ChangePizzaStatusRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_CHANGE_PIZZA_STATUS)))
          .addMethod(
            METHOD_ORDER_PIZZA,
            asyncUnaryCall(
              new MethodHandlers<
                grpc.OrderPizzaRequest,
                grpc.OrderPizzaResponse>(
                  this, METHODID_ORDER_PIZZA)))
          .addMethod(
            METHOD_ORDER_NPIZZA,
            asyncUnaryCall(
              new MethodHandlers<
                grpc.OrderNPizzaRequest,
                grpc.OrderNPizzaResponse>(
                  this, METHODID_ORDER_NPIZZA)))
          .addMethod(
            METHOD_CHECK_ORDER,
            asyncUnaryCall(
              new MethodHandlers<
                grpc.CheckOrderRequest,
                grpc.CheckOrderResponse>(
                  this, METHODID_CHECK_ORDER)))
          .addMethod(
            METHOD_GET_PIZZA_COUNT,
            asyncUnaryCall(
              new MethodHandlers<
                grpc.GetPizzaCountRequest,
                grpc.GetPizzaCountResponse>(
                  this, METHODID_GET_PIZZA_COUNT)))
          .build();
    }
  }

  /**
   */
  public static final class PizzaServiceStub extends io.grpc.stub.AbstractStub<PizzaServiceStub> {
    private PizzaServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PizzaServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PizzaServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PizzaServiceStub(channel, callOptions);
    }

    /**
     */
    public void addNewPizza(grpc.AddNewPizzaRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ADD_NEW_PIZZA, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getPizzaList(grpc.GetPizzaListRequest request,
        io.grpc.stub.StreamObserver<grpc.GetPizzaListResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_PIZZA_LIST, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void delPizza(grpc.DelPizzaRequest request,
        io.grpc.stub.StreamObserver<grpc.DelPizzaResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_DEL_PIZZA, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void changePizzaStatus(grpc.ChangePizzaStatusRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CHANGE_PIZZA_STATUS, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void orderPizza(grpc.OrderPizzaRequest request,
        io.grpc.stub.StreamObserver<grpc.OrderPizzaResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ORDER_PIZZA, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void orderNPizza(grpc.OrderNPizzaRequest request,
        io.grpc.stub.StreamObserver<grpc.OrderNPizzaResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ORDER_NPIZZA, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void checkOrder(grpc.CheckOrderRequest request,
        io.grpc.stub.StreamObserver<grpc.CheckOrderResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CHECK_ORDER, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getPizzaCount(grpc.GetPizzaCountRequest request,
        io.grpc.stub.StreamObserver<grpc.GetPizzaCountResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_PIZZA_COUNT, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class PizzaServiceBlockingStub extends io.grpc.stub.AbstractStub<PizzaServiceBlockingStub> {
    private PizzaServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PizzaServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PizzaServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PizzaServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.google.protobuf.Empty addNewPizza(grpc.AddNewPizzaRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ADD_NEW_PIZZA, getCallOptions(), request);
    }

    /**
     */
    public grpc.GetPizzaListResponse getPizzaList(grpc.GetPizzaListRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_PIZZA_LIST, getCallOptions(), request);
    }

    /**
     */
    public grpc.DelPizzaResponse delPizza(grpc.DelPizzaRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_DEL_PIZZA, getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty changePizzaStatus(grpc.ChangePizzaStatusRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CHANGE_PIZZA_STATUS, getCallOptions(), request);
    }

    /**
     */
    public grpc.OrderPizzaResponse orderPizza(grpc.OrderPizzaRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ORDER_PIZZA, getCallOptions(), request);
    }

    /**
     */
    public grpc.OrderNPizzaResponse orderNPizza(grpc.OrderNPizzaRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ORDER_NPIZZA, getCallOptions(), request);
    }

    /**
     */
    public grpc.CheckOrderResponse checkOrder(grpc.CheckOrderRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CHECK_ORDER, getCallOptions(), request);
    }

    /**
     */
    public grpc.GetPizzaCountResponse getPizzaCount(grpc.GetPizzaCountRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_PIZZA_COUNT, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class PizzaServiceFutureStub extends io.grpc.stub.AbstractStub<PizzaServiceFutureStub> {
    private PizzaServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PizzaServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PizzaServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PizzaServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> addNewPizza(
        grpc.AddNewPizzaRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ADD_NEW_PIZZA, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.GetPizzaListResponse> getPizzaList(
        grpc.GetPizzaListRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_PIZZA_LIST, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.DelPizzaResponse> delPizza(
        grpc.DelPizzaRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_DEL_PIZZA, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> changePizzaStatus(
        grpc.ChangePizzaStatusRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CHANGE_PIZZA_STATUS, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.OrderPizzaResponse> orderPizza(
        grpc.OrderPizzaRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ORDER_PIZZA, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.OrderNPizzaResponse> orderNPizza(
        grpc.OrderNPizzaRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ORDER_NPIZZA, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.CheckOrderResponse> checkOrder(
        grpc.CheckOrderRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CHECK_ORDER, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.GetPizzaCountResponse> getPizzaCount(
        grpc.GetPizzaCountRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_PIZZA_COUNT, getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_NEW_PIZZA = 0;
  private static final int METHODID_GET_PIZZA_LIST = 1;
  private static final int METHODID_DEL_PIZZA = 2;
  private static final int METHODID_CHANGE_PIZZA_STATUS = 3;
  private static final int METHODID_ORDER_PIZZA = 4;
  private static final int METHODID_ORDER_NPIZZA = 5;
  private static final int METHODID_CHECK_ORDER = 6;
  private static final int METHODID_GET_PIZZA_COUNT = 7;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PizzaServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PizzaServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_NEW_PIZZA:
          serviceImpl.addNewPizza((grpc.AddNewPizzaRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_PIZZA_LIST:
          serviceImpl.getPizzaList((grpc.GetPizzaListRequest) request,
              (io.grpc.stub.StreamObserver<grpc.GetPizzaListResponse>) responseObserver);
          break;
        case METHODID_DEL_PIZZA:
          serviceImpl.delPizza((grpc.DelPizzaRequest) request,
              (io.grpc.stub.StreamObserver<grpc.DelPizzaResponse>) responseObserver);
          break;
        case METHODID_CHANGE_PIZZA_STATUS:
          serviceImpl.changePizzaStatus((grpc.ChangePizzaStatusRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_ORDER_PIZZA:
          serviceImpl.orderPizza((grpc.OrderPizzaRequest) request,
              (io.grpc.stub.StreamObserver<grpc.OrderPizzaResponse>) responseObserver);
          break;
        case METHODID_ORDER_NPIZZA:
          serviceImpl.orderNPizza((grpc.OrderNPizzaRequest) request,
              (io.grpc.stub.StreamObserver<grpc.OrderNPizzaResponse>) responseObserver);
          break;
        case METHODID_CHECK_ORDER:
          serviceImpl.checkOrder((grpc.CheckOrderRequest) request,
              (io.grpc.stub.StreamObserver<grpc.CheckOrderResponse>) responseObserver);
          break;
        case METHODID_GET_PIZZA_COUNT:
          serviceImpl.getPizzaCount((grpc.GetPizzaCountRequest) request,
              (io.grpc.stub.StreamObserver<grpc.GetPizzaCountResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class PizzaServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.PizzaServiceProto.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (PizzaServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PizzaServiceDescriptorSupplier())
              .addMethod(METHOD_ADD_NEW_PIZZA)
              .addMethod(METHOD_GET_PIZZA_LIST)
              .addMethod(METHOD_DEL_PIZZA)
              .addMethod(METHOD_CHANGE_PIZZA_STATUS)
              .addMethod(METHOD_ORDER_PIZZA)
              .addMethod(METHOD_ORDER_NPIZZA)
              .addMethod(METHOD_CHECK_ORDER)
              .addMethod(METHOD_GET_PIZZA_COUNT)
              .build();
        }
      }
    }
    return result;
  }
}
