package com.fuxi.bridge.autoconfigure;

import java.util.ArrayList;
import java.util.List;
import org.fisco.bcos.channel.handler.ChannelConnections;
import org.fisco.bcos.channel.handler.GroupChannelConnectionsConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
@ConfigurationProperties(
        prefix = "group-channel-connections-config"
)
public class GroupChannelConnectionsPropertyConfig {
    List<ChannelConnections> allChannelConnections = new ArrayList();
    private Resource caCert;
    private Resource sslCert;
    private Resource sslKey;

    public GroupChannelConnectionsPropertyConfig() {
    }

    @Bean
    public GroupChannelConnectionsConfig getGroupChannelConnections() {
        GroupChannelConnectionsConfig groupChannelConnectionsConfig = new GroupChannelConnectionsConfig();
        groupChannelConnectionsConfig.setCaCert(this.caCert);
        groupChannelConnectionsConfig.setSslCert(this.sslCert);
        groupChannelConnectionsConfig.setSslKey(this.sslKey);
        groupChannelConnectionsConfig.setAllChannelConnections(this.allChannelConnections);
        return groupChannelConnectionsConfig;
    }

    public Resource getCaCert() {
        return this.caCert;
    }

    public void setCaCert(Resource caCert) {
        this.caCert = caCert;
    }

    public Resource getSslCert() {
        return this.sslCert;
    }

    public void setSslCert(Resource sslCert) {
        this.sslCert = sslCert;
    }

    public Resource getSslKey() {
        return this.sslKey;
    }

    public void setSslKey(Resource sslKey) {
        this.sslKey = sslKey;
    }

    public List<ChannelConnections> getAllChannelConnections() {
        return this.allChannelConnections;
    }

    public void setAllChannelConnections(List<ChannelConnections> allChannelConnections) {
        this.allChannelConnections = allChannelConnections;
    }
}
