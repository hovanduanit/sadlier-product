package com.sadlier.sadlier_product;


import com.sadlier.product.ProductProto;
import com.sadlier.product.ProductServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class ProductServiceImpl extends ProductServiceGrpc.ProductServiceImplBase {
    @Override
    public void getUserInfo(ProductProto.ProductRequest request, StreamObserver<ProductProto.ProductResponse> responseObserver) {
        ProductProto.ProductResponse response = ProductProto.ProductResponse.newBuilder()
                .setUserId(request.getProductId())
                .setName("John Doe")
                .setEmail("johndoe@example.com")
                .build();

        // Trả kết quả về client
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
