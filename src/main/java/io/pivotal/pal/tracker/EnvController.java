package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {


    private Map<String,String> myMap = new HashMap<String,String>();
    private String port,memoryLimit,cfInstanceIndex,cfInstanceAddress;
    public EnvController(@Value("${PORT:NOT SET}") String port,
                         @Value("${MEMORY_LIMIT:NOT SET}") String memoryLimit,
                         @Value("${CF_INSTANCE_INDEX:NOT SET}") String cfInstanceIndex,
                         @Value("${CF_INSTANCE_ADDR:NOT SET}") String cfInstanceAddress){
        this.port = port;
        this.memoryLimit = memoryLimit;
        this.cfInstanceIndex = cfInstanceIndex;
        this.cfInstanceAddress = cfInstanceAddress;
        this.myMap.put("PORT",this.port);
        this.myMap.put("MEMORY_LIMIT",this.memoryLimit);
        this.myMap.put("CF_INSTANCE_INDEX",this.cfInstanceIndex);
        this.myMap.put("CF_INSTANCE_ADDR",this.cfInstanceAddress);
    }

    @GetMapping("/env")
    public Map<String,String> getEnv(){
        return this.myMap;
    }


}
