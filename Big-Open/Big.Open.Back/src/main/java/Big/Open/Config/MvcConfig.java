package Big.Open.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
 
@Configuration
public class MvcConfig implements WebMvcConfigurer 
{ 
 
	@Autowired
	private Environment env;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
    	var folderUpload = env.getProperty("app.file.storage.mapping");
        exposeDirectory(folderUpload, registry);
    }
     
    private void exposeDirectory(String dirName, ResourceHandlerRegistry registry) 
    {
    	registry.addResourceHandler("/uploads/**").addResourceLocations("file:///" + dirName);
    }
}