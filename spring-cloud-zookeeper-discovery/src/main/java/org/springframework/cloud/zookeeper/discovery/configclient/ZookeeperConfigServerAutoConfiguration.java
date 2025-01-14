/*
 * Copyright 2013-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.zookeeper.discovery.configclient;

import javax.annotation.PostConstruct;

import org.apache.curator.framework.CuratorFramework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.config.server.config.ConfigServerProperties;
import org.springframework.cloud.zookeeper.discovery.ZookeeperDiscoveryProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

/**
 * Extra configuration for config server if it happens to be registered with Zookeeper.
 *
 * @author Dave Syer
 */
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties
@ConditionalOnClass({ ZookeeperDiscoveryProperties.class, CuratorFramework.class,
		ConfigServerProperties.class })
public class ZookeeperConfigServerAutoConfiguration {

	@Autowired(required = false)
	private ZookeeperDiscoveryProperties properties;

	@Autowired(required = false)
	private ConfigServerProperties server;

	@PostConstruct
	public void init() {
		if (this.properties == null || this.server == null) {
			return;
		}
		String prefix = this.server.getPrefix();
		if (StringUtils.hasText(prefix)) {
			this.properties.getMetadata().put("configPath", prefix);
		}
	}


	public static void main(String[] args) {
		System.out.println();
	}

	public static void main(String[] args) {

	}


	public static void main(String[] args) {

	}

}
