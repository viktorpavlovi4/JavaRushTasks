package com.javarush.task.task37.task3708.retrievers;

import com.javarush.task.task37.task3708.cache.LRUCache;
import com.javarush.task.task37.task3708.storage.Storage;

public class CachingProxyRetriever implements Retriever {
    private LRUCache cache = new LRUCache(10);
    private OriginalRetriever retriever;

    public CachingProxyRetriever(Storage storage) {
        this.retriever = new OriginalRetriever(storage);
    }

    @Override
    public Object retrieve(long id) {
        Object o = null;
        if ((o = cache.find(id)) == null) {
            o = retriever.retrieve(id);
            cache.set(id, o);
        }
        return o;
    }
}
