package ccm.kx.rest;

import java.util.TreeMap;

import javax.ws.rs.*;

@Path("map")
public class MapResource {

    private final static TreeMap<String, String> commonMap = new TreeMap<>();

    // ---------------------------------------------------------
    // @GET methods : does not modify commonMap
    // ---------------------------------------------------------

    @GET
    @Path("size")
    public int size() {
        return commonMap.size();
    }

    @GET
    @Path("isEmpty")
    public boolean isEmpty() {
        return commonMap.isEmpty();
    }

    @GET
    @Path("containsKey/{key}")
    public boolean containsKey(@PathParam("key") String key) {
        return commonMap.containsKey(key);
    }

    @GET
    @Path("containsValue/{value}")
    public boolean containsValue(@PathParam("value") String value) {
        return commonMap.containsKey(value);
    }

    @GET
    @Path("get/{key}")
    public String get(@PathParam("key") String key) {
        return commonMap.get(key);
    }

    @GET
    @Path("keySet")
    public String keySet() {
        return commonMap.keySet().toString();
    }

    @GET
    @Path("values")
    public String values() {
        return commonMap.values().toString();
    }

    @GET
    @Path("entrySet")
    public String entrySet() {
        return commonMap.toString();
    }

    // ---------------------------------------------------------
    // @PUT methods : increase commonMap datas
    // ---------------------------------------------------------

    @PUT
    @Path("put/{key}/{value}")
    public void put(@PathParam("key") String key, @PathParam("value") String value) {
        commonMap.put(key, value);
    }

    // ---------------------------------------------------------
    // @DELETE methods : decrease commonMap datas
    // ---------------------------------------------------------

    @DELETE
    @Path("remove/{key}")
    public void remove(@PathParam("key") String key) {
        commonMap.remove(key);
    }

    @DELETE
    @Path("clear")
    public void clear() {
        commonMap.clear();
    }
}
