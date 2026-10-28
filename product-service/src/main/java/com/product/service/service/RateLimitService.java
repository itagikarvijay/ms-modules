//package com.product.service.service;
//
//@Service
//public class RateLimitService {
//
//    private final Map<String, Bucket> cache =
//            new ConcurrentHashMap<>();
//
//    public Bucket resolveBucket(String clientId) {
//        return cache.computeIfAbsent(
//                clientId,
//                k -> RateLimiter.newBucket()
//        );
//    }
//}