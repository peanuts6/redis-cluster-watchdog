/*
 * Copyright 2016-2017 Leon Chen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.moilioncircle.redis.cluster.watchdog;

import com.moilioncircle.redis.cluster.watchdog.manager.ClusterManagers;

/**
 * @author Leon Chen
 * @since 1.0.0
 */
public abstract class AbstractClusterWatchdog implements ClusterWatchdog {

    protected final ClusterManagers managers;
    protected final ClusterConfiguration configuration;

    protected AbstractClusterWatchdog(ClusterConfiguration configuration) {
        this.configuration = configuration;
        this.managers = new ClusterManagers(configuration);
    }

    @Override
    public ReplicationListener setReplicationListener(ReplicationListener replicationListener) {
        return managers.setReplicationListener(replicationListener);
    }

    @Override
    public ClusterStateListener setClusterStateListener(ClusterStateListener clusterStateListener) {
        return managers.setClusterStateListener(clusterStateListener);
    }

    @Override
    public ClusterConfigListener setClusterConfigListener(ClusterConfigListener clusterConfigListener) {
        return managers.setClusterConfigListener(clusterConfigListener);
    }

    @Override
    public ClusterConfiguration getClusterConfiguration() {
        return this.configuration;
    }
}
