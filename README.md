# Cache

#### This is a caching library where you can change the eviction policy as per your requirement. 

Technology: Java, Maven
Logging: Slf4j
Plugins: Lombok

For lombok to work on your IDE,  
1. You need to install the lombok plugin(IntelliJ)
2. Need to enable annotation processors. Can refer my answer on Stackover flow here: https://stackoverflow.com/a/42809311/3839716

###RUN

1. com.cache.app.Driver - Class to validate it executes. 
2. com.cache.app.RCacheApplication - Main Application class to run the cache. 

###Commands
* READ - Get the value for a key else log "Not Found"
* PUT - Inserts a key into the cache
* REMOVE - Removes a key from the cache
* FULL - Whether the cache is full or not. 

