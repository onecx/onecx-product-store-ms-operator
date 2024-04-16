package org.tkit.onecx.product.store.ms.operator.client.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.tkit.onecx.product.store.ms.operator.MicroserviceSpec;

import gen.org.tkit.onecx.product.store.ms.v1.model.UpdateMsRequest;

@Mapper
public interface ProductStoreMapper {

    @Mapping(target = "undeployed", constant = "false")
    UpdateMsRequest map(MicroserviceSpec spec);

}
