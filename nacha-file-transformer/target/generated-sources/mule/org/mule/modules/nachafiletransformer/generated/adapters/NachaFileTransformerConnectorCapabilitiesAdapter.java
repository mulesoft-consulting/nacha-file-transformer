
package org.mule.modules.nachafiletransformer.generated.adapters;

import javax.annotation.Generated;
import org.mule.api.devkit.capability.Capabilities;
import org.mule.api.devkit.capability.ModuleCapability;
import org.mule.modules.nachafiletransformer.NachaFileTransformerConnector;


/**
 * A <code>NachaFileTransformerConnectorCapabilitiesAdapter</code> is a wrapper around {@link NachaFileTransformerConnector } that implements {@link org.mule.api.Capabilities} interface.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.9.0", date = "2018-01-09T08:51:50-06:00", comments = "Build UNNAMED.2793.f49b6c7")
public class NachaFileTransformerConnectorCapabilitiesAdapter
    extends NachaFileTransformerConnector
    implements Capabilities
{


    /**
     * Returns true if this module implements such capability
     * 
     */
    public boolean isCapableOf(ModuleCapability capability) {
        if (capability == ModuleCapability.LIFECYCLE_CAPABLE) {
            return true;
        }
        return false;
    }

}
