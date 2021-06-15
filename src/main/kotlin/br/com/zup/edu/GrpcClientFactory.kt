package br.com.zup.edu

import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import io.micronaut.context.annotation.Factory
import io.micronaut.grpc.annotation.GrpcChannel
import javax.inject.Singleton

@Factory
class GrpcClientFactory {

    //    @Bean ou @Singleton ele define que esse metodo vai ser invocado sempre que for chamado o FreteService
    // @GrpcChannel("localhost:50051") pode ser informado assim ou colocando a informação do application
    @Singleton
    fun fretesClientStub(@GrpcChannel("fretes") channel: ManagedChannel): FretesServiceGrpc.FretesServiceBlockingStub? {

        //abistração dos detalhes de conexão, segurança essas configurações passam a ser
        // feitas declarativamente no application.yml
//        val channel: ManagedChannel = ManagedChannelBuilder
//            .forAddress("localhost", 50051)
//            .usePlaintext()
//            .maxRetryAttempts(10)
//            .build()

        return FretesServiceGrpc
            .newBlockingStub(channel)
    }
}