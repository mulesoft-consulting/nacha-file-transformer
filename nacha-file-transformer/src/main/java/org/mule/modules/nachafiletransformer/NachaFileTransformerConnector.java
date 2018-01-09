package org.mule.modules.nachafiletransformer;

import java.io.ByteArrayOutputStream;

import org.mule.api.annotations.Category;
import org.mule.api.annotations.Config;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Processor;
import org.mule.api.annotations.display.Summary;
import org.mule.api.annotations.param.Default;
//import org.mule.api.annotations.param.Optional;
import org.mule.api.annotations.param.RefOnly;
import org.mule.modules.nachafiletransformer.config.ConnectorConfig;

import com.ach.achViewer.ach.ACHFile;

@Connector(name="nacha-file-transformer", friendlyName="NACHA File Transformer", description="Creates New or Parses ACH files in NACHA Format")
//@Category(name = "org.mule.tooling.category.transformers", description = "Transformers")
public class NachaFileTransformerConnector {

    @Config
    ConnectorConfig config;	
    
    public ConnectorConfig getConfig() {
        return config;
    }

    public void setConfig(ConnectorConfig config) {
        this.config = config;
    }
	
    /**
     * Reads the file contents either as a String, InputStream, or ByteArrayInputStream.  It creates and returns
     * an ACHFile object which can be consumed within the Mule Flow
     * 
     * @param mapDataFromExpresssion	The object data referencing the NACHA file.  It can be a String, InputStream
     * 									or a ByteArrayInputStream
     * @return ACHFile
     * @throws Exception when parse fails
     */
    @Processor(friendlyName="Read / Parse File")
    @Summary("Reads / Parses an ACH File in NACHA format.  If successful, will output a Java POJO (com.ach.achViewer.ach.ACHFile).  If failure in the header or format, it throws a General Exception with a descriptive error.  If error in a specific record, it will succeed but put failed records in the errroMessages attribute.")
	public ACHFile readFile(@Default("#[payload]") @Summary("MEL Expression Containing the ACH File. Valid types are String, InputStream, and ByteArrayInputStream") Object mapDataFromExpression) throws Exception {
        /*
         * MESSAGE PROCESSOR CODE GOES HERE
         */
		ACHFile file = new ACHFile();
		
		if (mapDataFromExpression instanceof java.io.ByteArrayInputStream
				|| mapDataFromExpression instanceof java.io.InputStream)
			file.parseStream((java.io.InputStream) mapDataFromExpression);
		else if (mapDataFromExpression instanceof String)
			file.parseString((String) mapDataFromExpression);
		else
			throw new Exception("Data input type not supported: Input supports ByteArrayInputStream, InputStream, or String");

		return file;
    }
    
    /**
     * Writes a file from an ACHFile object.  ACHFile is probably easiest to create via mapping
     * with DataWeave.
     * 
     * @param mapDataFromExpresssion	The object data referencing the NACHA file.  It can be a String, InputStream
     * 									or a ByteArrayInputStream
     * @return ByteArrayOutputStream
     * @throws Exception when write fails
     */
    @Processor(friendlyName="Create File")
    @Summary("Creates an ACH File in NACHA format.  If successful, will output a ByteArrayOutputStream with a String of data representing the file contents it throws a General Exception with a descriptive error.  If error in a specific record, it will succeed but put failed records in the errroMessages attribute.")
	public ByteArrayOutputStream createFile(@Default("#[payload]") @Summary("MEL Expression Containing the ACHFile Object") @RefOnly ACHFile mapDataFromExpression) throws Exception {
        /*
         * MESSAGE PROCESSOR CODE GOES HERE
         */
		if (mapDataFromExpression instanceof ACHFile)
			return mapDataFromExpression.save();
		else
			throw new Exception("Data input type not supported: Input supports ACHFile Object only.");

    }

}