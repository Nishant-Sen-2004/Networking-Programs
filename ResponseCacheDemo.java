import java.io.*;
import java.net.*;
import java.util.*;

/**
 * Demonstrates returning data from cache if available,
 * otherwise fetching from server using
 * ResponseCache, CacheRequest, and CacheResponse
 */
public class ResponseCacheDemo {

    /* ================== ResponseCache ================== */
    static class SimpleResponseCache extends ResponseCache {

        private final Map<URI, byte[]> cache = new HashMap<>();
        private final Map<URI, Map<String, List<String>>> headers = new HashMap<>();

        @Override
        public CacheResponse get(URI uri, String rqstMethod,
                                 Map<String, List<String>> rqstHeaders)
                throws IOException {

            if (cache.containsKey(uri)) {
                System.out.println("✅ Data served from cache");
                return new SimpleCacheResponse(cache.get(uri), headers.get(uri));
            }
            return null; // cache miss
        }

        @Override
        public CacheRequest put(URI uri, URLConnection conn)
                throws IOException {

            System.out.println("🌐 Data fetched from server and cached");
            headers.put(uri, conn.getHeaderFields());
            return new SimpleCacheRequest(uri, cache);
        }
    }

    /* ================== CacheResponse ================== */
    static class SimpleCacheResponse extends CacheResponse {

        private final byte[] data;
        private final Map<String, List<String>> headers;

        public SimpleCacheResponse(byte[] data,
                                   Map<String, List<String>> headers) {
            this.data = data;
            this.headers = headers;
        }

        @Override
        public InputStream getBody() {
            return new ByteArrayInputStream(data);
        }

        @Override
        public Map<String, List<String>> getHeaders() {
            return headers;
        }
    }

    /* ================== CacheRequest ================== */
    static class SimpleCacheRequest extends CacheRequest {

        private final URI uri;
        private final Map<URI, byte[]> cache;
        private final ByteArrayOutputStream buffer = new ByteArrayOutputStream();

        public SimpleCacheRequest(URI uri, Map<URI, byte[]> cache) {
            this.uri = uri;
            this.cache = cache;
        }

        @Override
        public OutputStream getBody() {
            return buffer;
        }

        @Override
        public void abort() {
            // No action needed
        }

        @Override
        protected void finalize() throws Throwable {
            cache.put(uri, buffer.toByteArray());
        }
    }

    private static void fetchData(URL url) throws IOException {
        URLConnection conn = url.openConnection();

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(conn.getInputStream()))) {

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    /* ================== MAIN ================== */
    public static void main(String[] args) throws Exception {

        // Set custom cache as default
        ResponseCache.setDefault(new SimpleResponseCache());

        URL url = new URL("https://httpbin.org/get");

        System.out.println("First request:");
        fetchData(url);   // From server

        System.out.println("\n----------------------\n");

        System.out.println("Second request:");
        fetchData(url);   // From cache
    }
}
