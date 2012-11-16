package com.datastax.driver.core.policies;

/**
 * Policies configured for a {@link com.datastax.driver.core.Cluster} instance.
 */
public class Policies {

    /**
     * The default load balancing policy.
     * <p>
     * The default load balancing policy is {@link RoundRobinPolicy}.
     */
    public static final LoadBalancingPolicy DEFAULT_LOAD_BALANCING_POLICY = new RoundRobinPolicy();

    /**
     * The default reconnection policy.
     * <p>
     * The default reconnetion policy is an {@link ExponentialReconnectionPolicy}
     * where the base delay is 1 second and the max delay is 10 minutes;
     */
    public static final ReconnectionPolicy DEFAULT_RECONNECTION_POLICY = new ExponentialReconnectionPolicy(1000, 10 * 60 * 1000);

    /**
     * The default retry policy.
     * <p>
     * The default retry policy is {@link DefaultRetryPolicy}.
     */
    public static final RetryPolicy DEFAULT_RETRY_POLICY = DefaultRetryPolicy.INSTANCE;

    private final LoadBalancingPolicy loadBalancingPolicy;
    private final ReconnectionPolicy reconnectionPolicy;
    private final RetryPolicy retryPolicy;

    /**
     * Creates a new {@code Policies} object using the provided policies.
     *
     * @param loadBalancingPolicy the load balancing policy to use.
     * @param reconnectionPolicy the reconnection policy to use.
     * @param retryPolicy the retry policy to use.
     */
    public Policies(LoadBalancingPolicy loadBalancingPolicy,
                    ReconnectionPolicy reconnectionPolicy,
                    RetryPolicy retryPolicy) {

        this.loadBalancingPolicy = loadBalancingPolicy;
        this.reconnectionPolicy = reconnectionPolicy;
        this.retryPolicy = retryPolicy;
    }

    /**
     * The load balancing policy in use.
     * <p>
     * The load balancing policy defines how Cassandra hosts are picked for queries.
     *
     * @return the load balancing policy in use.
     */
    public LoadBalancingPolicy getLoadBalancingPolicy() {
        return loadBalancingPolicy;
    }

    public ReconnectionPolicy getReconnectionPolicy() {
        return reconnectionPolicy;
    }

    public RetryPolicy getRetryPolicy() {
        return retryPolicy;
    }
}