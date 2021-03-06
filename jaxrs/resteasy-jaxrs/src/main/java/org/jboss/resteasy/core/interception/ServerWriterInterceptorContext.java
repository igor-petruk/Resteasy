package org.jboss.resteasy.core.interception;

import org.jboss.resteasy.spi.HttpRequest;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.WriterInterceptor;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;

/**
 * @author <a href="mailto:bill@burkecentral.com">Bill Burke</a>
 * @version $Revision: 1 $
 */
public class ServerWriterInterceptorContext extends AbstractWriterInterceptorContext
{
   private HttpRequest request;

   public ServerWriterInterceptorContext(WriterInterceptor[] interceptors, MessageBodyWriter writer,
                                         Object entity, Class type, Type genericType, Annotation[] annotations,
                                         MediaType mediaType, MultivaluedMap<String, Object> headers,
                                         OutputStream outputStream,
                                         HttpRequest request)
   {
      super(interceptors, annotations, entity, genericType, mediaType, type, outputStream, writer, headers);
      this.request = request;
   }

   @Override
   public Object getProperty(String name)
   {
      return request.getAttribute(name);
   }

   @Override
   public Collection<String> getPropertyNames()
   {
      ArrayList<String> names = new ArrayList<String>();
      Enumeration<String> enames = request.getAttributeNames();
      while (enames.hasMoreElements())
      {
         names.add(enames.nextElement());
      }
      return names;
   }

   @Override
   public void setProperty(String name, Object object)
   {
      if (object == null)
      {
         request.removeAttribute(name);
      }
      else
      {
         request.setAttribute(name, object);
      }
   }

   @Override
   public void removeProperty(String name)
   {
      request.removeAttribute(name);
   }
}
