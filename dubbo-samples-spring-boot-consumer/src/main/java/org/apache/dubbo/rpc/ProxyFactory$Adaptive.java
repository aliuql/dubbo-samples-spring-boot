package org.apache.dubbo.rpc;

import org.apache.dubbo.rpc.model.ScopeModel;
import org.apache.dubbo.rpc.model.ScopeModelUtil;

public class ProxyFactory$Adaptive implements ProxyFactory {
    public Object getProxy(Invoker invoker) throws RpcException {
        if (invoker == null) {
            throw new IllegalArgumentException("org.apache.dubbo.rpc.Invoker argument == null");
        }
        if (invoker.getUrl() == null) {
            throw new IllegalArgumentException("org.apache.dubbo.rpc.Invoker argument getUrl() == null");
        }
        org.apache.dubbo.common.URL url = invoker.getUrl();
        String extName = url.getParameter("proxy", "javassist");
        if (extName == null) {
            throw new IllegalStateException("Failed to get extension (org.apache.dubbo.rpc.ProxyFactory) name from url (" + url.toString() + ") use keys([proxy])");
        }
        ScopeModel scopeModel = ScopeModelUtil.getOrDefault(url.getScopeModel(), ProxyFactory.class);
        ProxyFactory extension = (ProxyFactory) scopeModel.getExtensionLoader(ProxyFactory.class).getExtension(extName);
        return extension.getProxy(invoker);
    }

    public Object getProxy(Invoker invoker, boolean generic) throws RpcException {
        if (invoker == null) {
            throw new IllegalArgumentException("org.apache.dubbo.rpc.Invoker argument == null");
        }
        if (invoker.getUrl() == null) {
            throw new IllegalArgumentException("org.apache.dubbo.rpc.Invoker argument getUrl() == null");
        }
        org.apache.dubbo.common.URL url = invoker.getUrl();
        String extName = url.getParameter("proxy", "javassist");
        if (extName == null) {
            throw new IllegalStateException("Failed to get extension (org.apache.dubbo.rpc.ProxyFactory) name from url (" + url.toString() + ") use keys([proxy])");
        }
        ScopeModel scopeModel = ScopeModelUtil.getOrDefault(url.getScopeModel(), ProxyFactory.class);
        ProxyFactory extension = (ProxyFactory) scopeModel.getExtensionLoader(ProxyFactory.class).getExtension(extName);
        return extension.getProxy(invoker, generic);
    }

    public Invoker getInvoker(Object proxy, Class type, org.apache.dubbo.common.URL url) throws RpcException {
        if (url == null) {
            throw new IllegalArgumentException("url == null");
        }
        String extName = url.getParameter("proxy", "javassist");
        if (extName == null) {
            throw new IllegalStateException("Failed to get extension (org.apache.dubbo.rpc.ProxyFactory) name from url (" + url.toString() + ") use keys([proxy])");
        }
        ScopeModel scopeModel = ScopeModelUtil.getOrDefault(url.getScopeModel(), ProxyFactory.class);
        ProxyFactory extension = (ProxyFactory) scopeModel.getExtensionLoader(ProxyFactory.class).getExtension(extName);
        return extension.getInvoker(proxy, type, url);
    }

}
