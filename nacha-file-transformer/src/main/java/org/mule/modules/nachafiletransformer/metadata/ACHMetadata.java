package org.mule.modules.nachafiletransformer.metadata;

import org.mule.api.annotations.MetaDataKeyRetriever;
import org.mule.api.annotations.MetaDataRetriever;
import org.mule.api.annotations.components.MetaDataCategory;
import org.mule.common.metadata.*;
import org.mule.common.metadata.builder.DefaultMetaDataBuilder;
import org.mule.modules.nachafiletransformer.NachaFileTransformerConnector;
import com.ach.achViewer.ach.ACHFile;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mulesoft, Inc
 */
@MetaDataCategory
public class ACHMetadata {

    @Inject
    NachaFileTransformerConnector connector;

    public void setConnector(NachaFileTransformerConnector connector) {
        this.connector = connector;
    }

    @MetaDataKeyRetriever
    public List<MetaDataKey> getEntities() throws Exception {

        List<MetaDataKey> entities = new ArrayList<MetaDataKey>();

        entities.add(new DefaultMetaDataKey("ACHFile_Id","ACHFile"));
        return entities;
    }

    @MetaDataRetriever
    public MetaData describeEntity(MetaDataKey entityKey) throws Exception {

        //Here we describe the entity depending on the entity key
        if ("ACHFile_Id".equals(entityKey.getId())) {
            MetaDataModel achModel =  new DefaultMetaDataBuilder().createPojo(ACHFile.class).build();
            return new DefaultMetaData(achModel);
        }

        throw new RuntimeException(String.format("This entity %s is not supported",entityKey.getId()));

    }
}