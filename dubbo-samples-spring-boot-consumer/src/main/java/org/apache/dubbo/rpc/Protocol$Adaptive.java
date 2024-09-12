package org.apache.dubbo.rpc;

import org.apache.dubbo.rpc.model.ScopeModel;
import org.apache.dubbo.rpc.model.ScopeModelUtil;

public class Protocol$Adaptive implements Protocol {
    public void destroy() {
        throw new UnsupportedOperationException("The method public abstract void org.apache.dubbo.rpc.Protocol.destroy() of interface org.apache.dubbo.rpc.Protocol is not adaptive method!");
    }

    public int getDefaultPort() {
        throw new UnsupportedOperationException("The method public abstract int org.apache.dubbo.rpc.Protocol.getDefaultPort() of interface org.apache.dubbo.rpc.Protocol is not adaptive method!");
    }

    public Exporter export(Invoker invoker) throws RpcException {
        if (invoker == null) {
            throw new IllegalArgumentException("org.apache.dubbo.rpc.Invoker argument == null");
        }
        if (invoker.getUrl() == null) {
            throw new IllegalArgumentException("org.apache.dubbo.rpc.Invoker argument getUrl() == null");
        }
        org.apache.dubbo.common.URL url = invoker.getUrl();
        String extName = (url.getProtocol() == null ? "dubbo" : url.getProtocol());
        if (extName == null) {
            throw new IllegalStateException("Failed to get extension (org.apache.dubbo.rpc.Protocol) name from url (" + url.toString() + ") use keys([protocol])");
        }
        ScopeModel scopeModel = ScopeModelUtil.getOrDefault(url.getScopeModel(), Protocol.class);
        Protocol extension = (Protocol) scopeModel.getExtensionLoader(Protocol.class).getExtension(extName);
        return extension.export(invoker);
    }

    public java.util.List getServers() {
        throw new UnsupportedOperationException("The method public default java.util.List org.apache.dubbo.rpc.Protocol.getServers() of interface org.apache.dubbo.rpc.Protocol is not adaptive method!");
    }

    public Invoker refer(Class type, org.apache.dubbo.common.URL url) throws RpcException {
        if (url == null) {
            throw new IllegalArgumentException("url == null");
        }
        String extName = (url.getProtocol() == null ? "dubbo" : url.getProtocol());
        if (extName == null) {
            throw new IllegalStateException("Failed to get extension (org.apache.dubbo.rpc.Protocol) name from url (" + url.toString() + ") use keys([protocol])");
        }
        ScopeModel scopeModel = ScopeModelUtil.getOrDefault(url.getScopeModel(), Protocol.class);
        Protocol extension = (Protocol) scopeModel.getExtensionLoader(Protocol.class).getExtension(extName);
        return extension.refer(type, url);
    }

}
