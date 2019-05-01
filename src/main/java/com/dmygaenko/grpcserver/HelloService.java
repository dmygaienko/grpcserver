package com.dmygaenko.grpcserver;

import com.dmygaenko.api.*;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.lognet.springboot.grpc.GRpcService;

@GRpcService
@Slf4j
public class HelloService extends HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        log.info("HelloService is called with request - {}", request);

        HelloResponse helloResponse = HelloResponse.newBuilder()
                .setGreeting("Hello " + request.getFirstName())
                .build();

        responseObserver.onNext(helloResponse);
        responseObserver.onCompleted();
    }

    @Override
    public void transferFile(FileRequest request, StreamObserver<FileResponse> responseObserver) {
        log.info("TransferFile is called with request - {}", request);

        FileResponse fileResponse = FileResponse.newBuilder()
                .setGreeting("File is transferred, " + request.getFirstName())
                .build();

        responseObserver.onNext(fileResponse);
        responseObserver.onCompleted();
    }

}