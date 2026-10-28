//package com.product.service.filter;
//
//import com.product.service.service.RateLimitService;
//
//@Component
//public class RateLimitFilter extends OncePerRequestFilter {
//
//    private final RateLimitService rateLimitService;
//
//    public RateLimitFilter(RateLimitService rateLimitService) {
//        this.rateLimitService = rateLimitService;
//    }
//
//    @Override
//    protected void doFilterInternal(
//            HttpServletRequest request,
//            HttpServletResponse response,
//            FilterChain filterChain)
//            throws ServletException, IOException {
//
//        String userKey = getClientIdentifier(request);
//        System.out.println("User Key: " + userKey);
//
//        Bucket bucket = rateLimitService.resolveBucket(userKey);
//
//        ConsumptionProbe probe = bucket.tryConsumeAndReturnRemaining(1);
//
//        if (probe.isConsumed()) {
//
//            response.addHeader(
//                    "X-Rate-Limit-Remaining",
//                    String.valueOf(probe.getRemainingTokens()));
//
//            filterChain.doFilter(request, response);
//
//        } else {
//
//            response.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());
//
//            response.setContentType("application/json");
//
//            response.getWriter().write("""
//                {
//                  "error":"Too Many Requests"
//                }
//                """);
//        }
//    }
//
//    private String getClientIdentifier(
//            HttpServletRequest request) {
//
//        return request.getRemoteAddr();
//    }
//}