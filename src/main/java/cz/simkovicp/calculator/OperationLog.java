package cz.simkovicp.calculator;

import java.util.Collection;
import java.util.UUID;

import org.infinispan.Cache;

public class OperationLog {

    /**
     * Operation message cache
     */
    private Cache<String, String> cache;

    public OperationLog(Cache<String, String> cache) {
        this.cache = cache;
    }

    /**
     * Put the message into log.
     * @param message the message
     */
    public void putMessage(String message) {
        cache.put(UUID.randomUUID().toString(), message);
    }

    /**
     * Return the messages. 
     * @return the messages
     */
    public Collection<String> getMessages() {
        return cache.values();
    }

}
