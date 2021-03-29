package io.mycat.test.config.loader;

/**
 * 把配置文件加载到mycat的zk上面
 * @author funnyAnt
 *
 */
public class ZKConfigLoader implements ConfigLoader<Object>{
    String configFilePath = null;
    
    public ZKConfigLoader(String configFilePath) {
      this.configFilePath = configFilePath;
    }
    
    @Override
    public Object load() {
        // TODO Auto-generated method stub
        return null;
        
    }

   

}
