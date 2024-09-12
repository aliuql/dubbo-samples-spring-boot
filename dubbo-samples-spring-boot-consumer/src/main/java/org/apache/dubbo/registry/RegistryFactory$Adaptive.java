package org.apache.dubbo.registry;

import org.apache.dubbo.rpc.model.ScopeModel;
import org.apache.dubbo.rpc.model.ScopeModelUtil;

public class RegistryFactory$Adaptive implements RegistryFactory {
    public Registry getRegistry(org.apache.dubbo.common.URL url) {
        if (url == null) {
            throw new IllegalArgumentException("url == null");
        }
        String extName = url.getProtocol();
        if (extName == null) {
            throw new IllegalStateException("Failed to get extension (org.apache.dubbo.registry.RegistryFactory) name from url ("
                    + url.toString() + ") use keys([protocol])");
        }
        ScopeModel scopeModel = ScopeModelUtil.getOrDefault(url.getScopeModel(), RegistryFactory.class);
        RegistryFactory extension =
                (RegistryFactory)
                        scopeModel.getExtensionLoader(RegistryFactory.class).getExtension(extName);
        return extension.getRegistry(url);
    }
}
