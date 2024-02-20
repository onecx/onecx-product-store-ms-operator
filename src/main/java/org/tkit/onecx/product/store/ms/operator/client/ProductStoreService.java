package org.tkit.onecx.product.store.ms.operator.client;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tkit.onecx.product.store.ms.operator.Microservice;
import org.tkit.onecx.product.store.ms.operator.MicroserviceSpec;
import org.tkit.onecx.product.store.ms.operator.client.mappers.ProductStoreMapper;

import gen.org.tkit.onecx.product.store.ms.v1.api.OperatorMsApi;
import gen.org.tkit.onecx.product.store.ms.v1.model.UpdateMsRequest;

@ApplicationScoped
public class ProductStoreService {

    private static final Logger log = LoggerFactory.getLogger(ProductStoreService.class);

    @Inject
    @RestClient
    OperatorMsApi client;

    @Inject
    ProductStoreMapper mapper;

    public int updateMicroservice(Microservice microfrontend) {
        MicroserviceSpec spec = microfrontend.getSpec();
        UpdateMsRequest dto = mapper.map(spec);
        try (var response = client.createOrUpdateMs(spec.getProductName(), spec.getAppId(), dto)) {
            log.info("Update micro-fronted response {}", response.getStatus());
            return response.getStatus();
        }
    }
}
