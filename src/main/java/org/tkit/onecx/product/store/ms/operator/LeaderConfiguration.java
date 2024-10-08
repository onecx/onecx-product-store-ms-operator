package org.tkit.onecx.product.store.ms.operator;

import jakarta.inject.Singleton;

import io.javaoperatorsdk.operator.api.config.LeaderElectionConfiguration;

@Singleton
public class LeaderConfiguration extends LeaderElectionConfiguration {

    public LeaderConfiguration(MicroserviceConfig config) {
        super(config.leaderElectionConfig().leaseName());
    }
}
