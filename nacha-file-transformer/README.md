# NACHA File Transformer Anypoint Connector

This connector allows for transforming data to/from the NACHA ACH flat file format.  This connector heavily uses work from the [ACHViewer project](https://sourceforge.net/projects/achviewer/) built and maintained by [johnlcallaway](https://sourceforge.net/u/johnlcallaway/profile/).  The ACHViewer application is released under [GPL v2](https://sourceforge.net/projects/achviewer/).

This connector accepts input in the following formats for the Read / Parse file Operation:
* ByteArrayInputStream
* InputStream
* String

(The file contents for the above should be a NACHA ACH File)

The connector will return a Java class called ACHFile (com.ach.achViewer.ach.ACHFile) which can then be used downstream in your Mule Application.
**DataSense is available for reading an ACHFile Object with DataWeave**

This connector accepts an ACHFile (com.ach.achViewer.ach.ACHFile) java object as the input for the Create File Operation.
**DataSense is available for creating an ACHFile Object with DataWeave**

**This connector requires a Global Element that is blank (no config options).  This is because Studio requires a Global Element in order for DataSense to work.**

# Sample Files
Samples are available in src/test/resources/samples

# Mule supported versions
Mule 3.8.x+

# Studio supported versions
Studio 6.0.2+
(Studio icons only exist for Studio Theme.Light, typically Classic theme)

# NACHA ACH File supported versions
Unknown, extensive testing of files and versions yet to be completed.

# Installation 
This connector is not yet released and available on MuleSoft's Exchange.  This connector is currently under review as to whether it will be added.
In the meantime, you can download the source code and build it with [devkit](https://docs.mulesoft.com/anypoint-connector-devkit/v/3.8/) within Anypoint Studio.
Once downloaded and added to Anypoint Studio, you can install it in Studio for use with your Mule Applications by right clicking on the project and selecting Anypoint Connector > Install or Update

#Usage
For information about usage our documentation at http://github.com/mulesoft-consulting/nacha-file-transformer.

# Reporting Issues

We use GitHub:Issues for tracking issues with this connector. You can report new issues at this link http://github.com/mulesoft-consulting/nacha-file-transformer/issues.