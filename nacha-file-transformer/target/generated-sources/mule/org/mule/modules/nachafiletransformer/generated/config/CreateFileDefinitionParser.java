
package org.mule.modules.nachafiletransformer.generated.config;

import javax.annotation.Generated;
import org.mule.common.MuleVersion;
import org.mule.config.MuleManifest;
import org.mule.modules.nachafiletransformer.generated.processors.CreateFileMessageProcessor;
import org.mule.modules.nachafiletransformer.generated.processors.CreateFileMessageProcessorDebuggable;
import org.mule.security.oauth.config.AbstractDevkitBasedDefinitionParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.parsing.BeanDefinitionParsingException;
import org.springframework.beans.factory.parsing.Location;
import org.springframework.beans.factory.parsing.Problem;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.9.0", date = "2018-01-09T08:51:50-06:00", comments = "Build UNNAMED.2793.f49b6c7")
public class CreateFileDefinitionParser
    extends AbstractDevkitBasedDefinitionParser
{

    private static Logger logger = LoggerFactory.getLogger(CreateFileDefinitionParser.class);

    private BeanDefinitionBuilder getBeanDefinitionBuilder(ParserContext parserContext) {
        try {
            MuleVersion muleVersion = new MuleVersion(MuleManifest.getProductVersion());
            BeanDefinitionBuilder beanDefinitionBuilder;
            if (muleVersion.atLeastBase("3.8.0")) {
                beanDefinitionBuilder = beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(CreateFileMessageProcessorDebuggable.class.getName());
            } else {
                beanDefinitionBuilder = beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(CreateFileMessageProcessor.class.getName());
            }
            return beanDefinitionBuilder;
        } catch (NoClassDefFoundError noClassDefFoundError) {
            String muleVersion = "";
            try {
                muleVersion = MuleManifest.getProductVersion();
            } catch (Exception _x) {
                logger.error("Problem while reading mule version");
            }
            logger.error(("Cannot launch the mule app, the @Processor [create-file] within the connector [nacha-file-transformer] is not supported in mule "+ muleVersion));
            throw new BeanDefinitionParsingException(new Problem(("Cannot launch the mule app, the @Processor [create-file] within the connector [nacha-file-transformer] is not supported in mule "+ muleVersion), new Location(parserContext.getReaderContext().getResource()), null, noClassDefFoundError));
        }
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = getBeanDefinitionBuilder(parserContext);
        builder.addConstructorArgValue("createFile");
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        if (!hasAttribute(element, "config-ref")) {
            throw new BeanDefinitionParsingException(new Problem("It seems that the config-ref for @Processor [create-file] within the connector [nacha-file-transformer] is null or missing. Please, fill the value with the correct global element.", new Location(parserContext.getReaderContext().getResource()), null));
        }
        parseConfigRef(element, builder);
        if (hasAttribute(element, "mapDataFromExpression-ref")) {
            if (element.getAttribute("mapDataFromExpression-ref").startsWith("#")) {
                builder.addPropertyValue("mapDataFromExpression", element.getAttribute("mapDataFromExpression-ref"));
            } else {
                builder.addPropertyValue("mapDataFromExpression", (("#[registry:"+ element.getAttribute("mapDataFromExpression-ref"))+"]"));
            }
        }
        BeanDefinition definition = builder.getBeanDefinition();
        setNoRecurseOnDefinition(definition);
        attachProcessorDefinition(parserContext, definition);
        return definition;
    }

}
