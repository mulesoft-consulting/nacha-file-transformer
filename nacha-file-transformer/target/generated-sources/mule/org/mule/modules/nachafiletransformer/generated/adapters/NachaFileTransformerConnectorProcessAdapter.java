
package org.mule.modules.nachafiletransformer.generated.adapters;

import javax.annotation.Generated;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.devkit.ProcessAdapter;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.routing.filter.Filter;
import org.mule.modules.nachafiletransformer.NachaFileTransformerConnector;
import org.mule.security.oauth.callback.ProcessCallback;


/**
 * A <code>NachaFileTransformerConnectorProcessAdapter</code> is a wrapper around {@link NachaFileTransformerConnector } that enables custom processing strategies.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.9.0", date = "2018-01-09T08:51:50-06:00", comments = "Build UNNAMED.2793.f49b6c7")
public class NachaFileTransformerConnectorProcessAdapter
    extends NachaFileTransformerConnectorLifecycleInjectionAdapter
    implements ProcessAdapter<NachaFileTransformerConnectorCapabilitiesAdapter>
{


    public<P >ProcessTemplate<P, NachaFileTransformerConnectorCapabilitiesAdapter> getProcessTemplate() {
        final NachaFileTransformerConnectorCapabilitiesAdapter object = this;
        return new ProcessTemplate<P,NachaFileTransformerConnectorCapabilitiesAdapter>() {


            @Override
            public P execute(ProcessCallback<P, NachaFileTransformerConnectorCapabilitiesAdapter> processCallback, MessageProcessor messageProcessor, MuleEvent event)
                throws Exception
            {
                return processCallback.process(object);
            }

            @Override
            public P execute(ProcessCallback<P, NachaFileTransformerConnectorCapabilitiesAdapter> processCallback, Filter filter, MuleMessage message)
                throws Exception
            {
                return processCallback.process(object);
            }

        }
        ;
    }

}
