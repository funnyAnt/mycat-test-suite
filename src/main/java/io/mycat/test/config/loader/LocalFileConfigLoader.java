package io.mycat.test.config.loader;

/**
 * 把配置文件复制到mycat目录下。
 * 约束：mycat必须部署在当前机器下
 * @author funnyAnt
 *
 */
public class LocalFileConfigLoader implements ConfigLoader<Object>{
    String configFilePath = null;
    
    public LocalFileConfigLoader(String configFilePath) {
      this.configFilePath = configFilePath;
    }
    
    @Override
    public Object load() {
        // TODO Auto-generated method stub
        return null;
    }

 

}
